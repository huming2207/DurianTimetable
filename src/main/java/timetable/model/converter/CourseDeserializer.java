package timetable.model.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import timetable.model.enrolment.Activity;
import timetable.model.enrolment.Course;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CourseDeserializer extends StdDeserializer<Course>
{
    public CourseDeserializer()
    {
        this(null);
    }

    public CourseDeserializer(Class<?> vc)
    {
        super(vc);
    }

    @Override
    public Course deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException, JsonProcessingException
    {
        JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);
        ObjectMapper objectMapper = new ObjectMapper();
        Course course = objectMapper.treeToValue(rootNode, Course.class);

        // Parse the activity group "associative array", which is something like this:
        // {"groups": {"LEC01": {...(activity object)...}, "TUT01": {...(another activity object)...}}}
        // By the way, PHP sucks.
        JsonNode groupNode = rootNode.get("groups");
        Map<String, Activity> activities = new HashMap<>();
        groupNode.fields().forEachRemaining(activityGroup -> {
            try {
                activities.put(activityGroup.getKey(), objectMapper.treeToValue(groupNode, Activity.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        course.setActivities(activities);
        return course;
    }
}

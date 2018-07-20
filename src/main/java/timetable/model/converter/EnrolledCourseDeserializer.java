package timetable.model.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import timetable.model.result.Activity;
import timetable.model.result.EnrolledCourse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnrolledCourseDeserializer extends StdDeserializer<EnrolledCourse>
{
    public EnrolledCourseDeserializer()
    {
        this(null);
    }

    public EnrolledCourseDeserializer(Class<?> vc)
    {
        super(vc);
    }

    @Override
    public EnrolledCourse deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException, JsonProcessingException
    {
        JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);
        ObjectMapper objectMapper = new ObjectMapper();
        EnrolledCourse enrolledCourse = objectMapper.treeToValue(rootNode, EnrolledCourse.class);

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

        enrolledCourse.setActivities(activities);
        return enrolledCourse;
    }
}

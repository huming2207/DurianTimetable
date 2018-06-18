package auth;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple cookie jar implementation
 *
 * Ref: https://gist.github.com/johannes-staehlin/63a72467bd1f21829d11bc55456c5836
 */
public class AuthCookieJar implements CookieJar
{
    private List<Cookie> cookies;
    private static AuthCookieJar instance = null;

    public static AuthCookieJar getInstance()
    {
        if(instance == null) {
            instance = new AuthCookieJar();
        }

        return instance;
    }

    private AuthCookieJar()
    {
        this.cookies = new ArrayList<>();
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies)
    {
        this.cookies.addAll(cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url)
    {
        cookies.removeIf(cookie -> cookie.expiresAt() < System.currentTimeMillis());
        return cookies.stream().filter(cookie -> cookie.matches(url)).collect(Collectors.toList());
    }
}

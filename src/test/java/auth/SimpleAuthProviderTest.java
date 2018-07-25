package auth;

import helpers.AuthCookieJar;
import org.junit.Assert;
import org.junit.Test;

public class SimpleAuthProviderTest
{

    @Test
    public void requestLoginPage()
    {
        // Assert we can get the login page
        SimpleAuthProvider authProvider = new SimpleAuthProvider();
        Assert.assertFalse(authProvider.requestLoginPage().isEmpty());
    }

    @Test
    public void performLogin()
    {
        // Assert that it can logs in
        SimpleAuthProvider authProvider = new SimpleAuthProvider();
        Assert.assertTrue(authProvider.performLogin(authProvider.requestLoginPage()));

        // Assert that it can get some cookies
        AuthCookieJar cookieJar = AuthCookieJar.getInstance();
        Assert.assertTrue(cookieJar.getCookies().size() > 0);
    }
}
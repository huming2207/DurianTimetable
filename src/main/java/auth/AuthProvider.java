package auth;

/**
 * Authentication provider
 *
 */
public interface AuthProvider
{
    String requestLoginPage();
    boolean performLogin(String loginPageHtml);
    boolean validateLoginToken();
}

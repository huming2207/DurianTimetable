package auth;

/**
 * Authentication provider
 *
 */
public interface SsoCasAuthProvider
{
    String requestLoginPage();
    boolean performLogin(String loginPageHtml);
    boolean validateLoginToken();
}

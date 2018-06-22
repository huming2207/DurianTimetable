package auth;

import okhttp3.FormBody;

/**
 * Authentication provider
 *
 */
public interface SsoCasAuthProvider
{
    String requestLoginPage();
    boolean performLogin(FormBody loginForm);
    boolean validateLoginToken();
}

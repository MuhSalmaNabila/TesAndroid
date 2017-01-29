package tes.nabil.com.tes.model;


/**
 * Created by root on 28/01/17.
 */

public class LoginManager {
    private LoginManager() {}

    private static class LoginManagerHelper {
        private static final LoginManager INSTANCE = new LoginManager();
    }

    public static LoginManager getInstance() {
        return LoginManagerHelper.INSTANCE;
    }

    public boolean validate(String email, String password) {
        return isValidEmail(email) && isPasswordCorrect(password);
    }

    private boolean isValidEmail(String email) {
        return email.equalsIgnoreCase("mjs");
    }
    private boolean isPasswordCorrect(String password) {
        return password.equalsIgnoreCase("tanihub28");
    }


}

package tes.nabil.com.tes.view;

import android.content.Intent;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by root on 28/01/17.
 */

public interface MainContract {
    interface View {
        void loginSuccess(String title);
        void logout(String title);
        void showMessage(String message);

    }


    interface Presenter {
        void doLogin(String username, String password);
    }

}
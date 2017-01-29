package tes.nabil.com.tes.presenter;

import tes.nabil.com.tes.HomeActivity;
import tes.nabil.com.tes.LoginActivity;
import tes.nabil.com.tes.model.LoginManager;
import tes.nabil.com.tes.view.MainContract;
import android.content.Intent;

/**
 * Created by root on 28/01/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private boolean isLoggedIn;
    private LoginManager mLoginManager;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mLoginManager = LoginManager.getInstance();
    }

    @Override
    public void doLogin(String username, String password) {
        if (!isLoggedIn) {
            if (mLoginManager.validate(username,password)) {
                isLoggedIn = true;
                mView.loginSuccess("Logout");
                mView.showMessage("Login berhasil");

            } else {
                mView.showMessage("Login gagal");
            }
        } else {
            isLoggedIn = false;
            mView.logout("Login");
            mView.showMessage("Logout berhasil");
        }
    }


    public void detachView() {
        mView = null;
    }

}

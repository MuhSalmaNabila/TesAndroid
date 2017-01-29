package tes.nabil.com.tes;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tes.nabil.com.tes.presenter.MainPresenter;
import tes.nabil.com.tes.view.MainContract;

public class LoginActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter mPresenter;

    @BindView(R.id.et_username)
    TextInputEditText etUsername;

    @BindView(R.id.et_password)
    TextInputEditText etPassword;

    @BindView(R.id.bt_login)
    Button btLogin;

    @OnClick(R.id.bt_login)
    void loginClicked() {
        mPresenter.doLogin(etUsername.getText().toString(),etPassword.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setStatusBarTranslucent(true);


        ButterKnife.bind(this);
        mPresenter = new MainPresenter(this);
    }

    protected void setStatusBarTranslucent(boolean makeTranslucent) {
        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    public void loginSuccess(String title) {
        btLogin.setText(title);
        etUsername.setText("");
        etPassword.setText("");
    }

    @Override
    public void logout(String title) {
        btLogin.setText(title);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }


}

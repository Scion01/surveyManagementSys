package com.example.hauntarl.expandablelogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    ExpandableRelativeLayout expandableLayout1, expandableLayout2;
    private static final String TAG = "LoginActivity";

    @BindView(R.id.input_phone) EditText _phoneText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.btn_google) Button _googleButton;
    @BindView(R.id.phone_citi) EditText _phoneCiti;
    @BindView(R.id.btn_otp) Button _otpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });
        _googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleBtn();
            }
        });
        _otpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otpBtn();
            }
        });

    }
    public void otpBtn() {
        if (!validateOtp()) {
            onOtpFailed();
            return;
        }

        _otpButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Verifying...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onOtpSuccess();
                        //onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }
    public void onOtpSuccess() {
        _otpButton.setEnabled(true);
        startActivity(new Intent(getApplicationContext(), DashActivity.class));
        finish();
    }

    public void onOtpFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _otpButton.setEnabled(true);
    }
    public boolean validateOtp() {
        boolean valid = true;

        String phone = _phoneCiti.getText().toString();

        if (phone.isEmpty() || phone.length() != 10) {
            _phoneCiti.setError("enter a valid Phone number");
            valid = false;
        } else {
            _phoneCiti.setError(null);
        }
        return valid;
    }

    public void googleBtn() {
        _googleButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Verifying...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onGoogleSuccess();
                        //onGoogleFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onGoogleFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _googleButton.setEnabled(true);

    }

    public void onGoogleSuccess() {
        _googleButton.setEnabled(true);
         startActivity(new Intent(getApplicationContext(), DashActivity.class));
        finish();
    }

    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String phone = _phoneText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        //onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }
    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        startActivity(new Intent(getApplicationContext(), DashActivity.class));
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }
    public boolean validate() {
        boolean valid = true;

        String phone = _phoneText.getText().toString();
        String password = _passwordText.getText().toString();

        if (phone.isEmpty() || phone.length() != 10) {
            _phoneText.setError("enter a valid Phone number");
            valid = false;
        } else {
            _phoneText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2) ;
        expandableLayout2.collapse();
    }

    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.collapse();
    }
}
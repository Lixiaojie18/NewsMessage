package com.example.administrator.newsmessage.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.newsmessage.Fragment.LoginFragment;
import com.example.administrator.newsmessage.Fragment.RegisterFragment;
import com.example.administrator.newsmessage.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    private Fragment loginFragment,registerFragment;
    private RelativeLayout relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        relative = (RelativeLayout) findViewById(R.id.relative);
    }



    @OnClick({R.id.btn_login, R.id.btn_register})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                relative.setVisibility(View.INVISIBLE);
                loginFragment = new LoginFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction beginTransaction = manager.beginTransaction();
                beginTransaction.add(R.id.line1, loginFragment);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.btn_register:
                relative.setVisibility(View.INVISIBLE);
                registerFragment = new RegisterFragment();
                FragmentManager manager1 = getFragmentManager();
                FragmentTransaction beginTransaction1 = manager1.beginTransaction();
                beginTransaction1.replace(R.id.line1, registerFragment);
                beginTransaction1.addToBackStack(null);
                beginTransaction1.commit();
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        relative.setVisibility(View.VISIBLE);
    }
}

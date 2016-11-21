package com.example.administrator.newsmessage.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.newsmessage.Activity.MainActivity;
import com.example.administrator.newsmessage.R;

import static android.content.Context.MODE_PRIVATE;

public class RegisterFragment extends Fragment {
    private EditText ed_email, ed_name, ed_pass;
    private Button register;
    private boolean message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ed_email = (EditText) view.findViewById(R.id.ed_email);
        ed_name = (EditText) view.findViewById(R.id.ed_name);
        ed_pass = (EditText) view.findViewById(R.id.ed_pass);
        register = (Button) view.findViewById(R.id.register);
        register.setOnClickListener(onclicklister);
    }

    private View.OnClickListener onclicklister = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {
            VerifyMessage(getContext());
            if(message == true) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        }
    };

    private void VerifyMessage(Context context) {
        String email, name, pass;
        email = ed_email.getText().toString();
        name = ed_name.getText().toString();
        pass = ed_pass.getText().toString();
        if(email.equals("")) {
            Toast.makeText(getActivity(),"请输入有效邮箱",Toast.LENGTH_SHORT).show();
            return;
        }
        if(name.equals("")) {
            Toast.makeText(getActivity(),"请输入昵称",Toast.LENGTH_SHORT).show();
            return;
        }
        if(pass.equals("")) {
            Toast.makeText(getActivity(),"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        message = true;
        SharedPreferences Preferences = context.getSharedPreferences("config", MODE_PRIVATE);
        SharedPreferences.Editor editor = Preferences.edit();
        editor.putString("username",name);
        editor.putString("password",pass);
        editor.putString("Email",email);
        editor.commit();
    }
}

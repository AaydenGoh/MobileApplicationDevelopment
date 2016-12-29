package com.example.gee.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    MemberDataBase memberDB;

    public EditText text_email;
    public EditText text_password;
    public Button btn_register;
    public Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        memberDB=new MemberDataBase(this);
        text_email=(EditText)findViewById(R.id.edit_email);
        text_password=(EditText)findViewById(R.id.edit_password);
        OnclickButtonListener();
        login();
    }

    public void OnclickButtonListener(){
        btn_register=(Button) findViewById(R.id.btn_signup);
        btn_register.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.example.gee.assignment.Registration");
                        startActivity(intent);
                    }
                }
        );
    }

    public void login() {
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = memberDB.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","No member exist");
                            return;
                        }
                        boolean isLogin=false;
                        //StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {

                            if(res.getString(2).equals(text_email.getText().toString())&&res.getString(3).equals(text_password.getText().toString())){
                                Intent intent=new Intent("com.example.gee.assignment.MainActivity");
                                startActivity(intent);
                                isLogin=true;
                            }

                        }

                        // Show error message
                        if(!isLogin){
                            showMessage("Error","Wrong email or password.");
                        }

                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}

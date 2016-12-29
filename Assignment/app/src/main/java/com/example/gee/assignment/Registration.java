package com.example.gee.assignment;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    MemberDataBase memberDB;

    EditText editName, editEmail, editPassword, editDOB;
    RadioGroup radioGender;
    RadioButton radioButton;
    Button createAccountButton,btnviewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        memberDB=new MemberDataBase(this);

        editName = (EditText) findViewById(R.id.edit_name);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editPassword = (EditText) findViewById(R.id.edit_password);
        editDOB = (EditText) findViewById(R.id.edit_dob);
        radioGender = (RadioGroup) findViewById(R.id.radioGroup);
        createAccountButton=(Button) findViewById(R.id.button_register);
        btnviewAll = (Button)findViewById(R.id.btnRetrieve);

        AddMember();
        viewAll();
    }

    public void AddMember(){
        createAccountButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int radioId=radioGender.getCheckedRadioButtonId();
                        radioButton=(RadioButton)findViewById(radioId);
                        boolean isAdded=memberDB.addNewMember(editName.getText().toString(),editEmail.getText().toString(),editPassword.getText().toString(),
                                editDOB.getText().toString(),radioButton.getText().toString());

                        if(isAdded==true){
                            Toast.makeText(Registration.this,"Successful Registered", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Registration.this,"Unsuccessful Registered", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = memberDB.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Email :"+ res.getString(2)+"\n");
                            buffer.append("Password :"+ res.getString(3)+"\n");
                            buffer.append("Birthday :"+ res.getString(4)+"\n");
                            buffer.append("Gender :"+ res.getString(5)+"\n\n");

                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
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

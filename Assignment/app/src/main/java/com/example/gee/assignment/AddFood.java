package com.example.gee.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFood extends AppCompatActivity {
    FoodDatabase foodDatabase;
    EditText editCategory, editName, editCalories;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        editCategory = (EditText) findViewById(R.id.edit_category);
        editName = (EditText) findViewById(R.id.edit_name);
        editCalories = (EditText) findViewById(R.id.edit_calories);
        btnAdd =(Button) findViewById(R.id.btnAdd);

    }

    public void AddFood(){
        btnAdd.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isAdded=foodDatabase.addNewFood(editName.getText().toString(),editCalories.getText().toString(),editCategory.getText().toString());

                        if(isAdded==true){
                            Toast.makeText(AddFood.this,"Successful", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(AddFood.this,"Unsuccessful", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}

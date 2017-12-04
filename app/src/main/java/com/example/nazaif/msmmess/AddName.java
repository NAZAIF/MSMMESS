package com.example.nazaif.msmmess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddName extends AppCompatActivity {

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference membersRef = rootRef.child("members");

    EditText getName;
    Button AddNameBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        getName = (EditText)findViewById(R.id.nameEdit);
        AddNameBtn = (Button)findViewById(R.id.nameAddBtn);

        AddNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String newName = getName.getText().toString();
            membersRef.child(newName);
            membersRef.child(newName).child("breakfast").setValue(0);
            membersRef.child(newName).child("lunch").setValue(0);
            membersRef.child(newName).child("dinner").setValue(0);

            Toast.makeText(AddName.this, newName+" is Added", Toast.LENGTH_SHORT).show();


            }
        });
    }
}

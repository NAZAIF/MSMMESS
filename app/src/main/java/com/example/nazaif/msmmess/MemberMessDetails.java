package com.example.nazaif.msmmess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MemberMessDetails extends AppCompatActivity {

    private static RadioGroup Rg_bkfs, Rg_lnch, Rg_dnnr;
    private static RadioButton bkfs, lnch, dnnr;
    private static Button sbmtBtn;
    DatabaseReference membersRef = FirebaseDatabase.getInstance().getReference().child("members");
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_mess_details);

        name = getIntent().getExtras().get("name").toString();
        setTitle("Status of " + name);


    }

    public void onButtonClicked() {
        Rg_bkfs = (RadioGroup) findViewById(R.id.rg_bkfs);
        Rg_dnnr = (RadioGroup) findViewById(R.id.rg_dnnr);
        Rg_lnch = (RadioGroup) findViewById(R.id.rg_lnch);

        sbmtBtn = (Button) findViewById(R.id.sbtButton);

        sbmtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}

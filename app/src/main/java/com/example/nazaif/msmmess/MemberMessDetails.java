package com.example.nazaif.msmmess;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

        onButtonClicked();

    }

    public void onButtonClicked() {
        Rg_bkfs = (RadioGroup) findViewById(R.id.rg_bkfs);
        Rg_dnnr = (RadioGroup) findViewById(R.id.rg_dnnr);
        Rg_lnch = (RadioGroup) findViewById(R.id.rg_lnch);

        final DatabaseReference personRef = FirebaseDatabase.getInstance().getReference().child("members").child(name);

        sbmtBtn = (Button) findViewById(R.id.sbtButton);

        sbmtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bkfs_id, dnnr_id, lnch_id;
                bkfs_id = Rg_bkfs.getCheckedRadioButtonId();
                dnnr_id = Rg_dnnr.getCheckedRadioButtonId();
                lnch_id = Rg_lnch.getCheckedRadioButtonId();

                switch (bkfs_id) {
                    case R.id.rb_bkfs_yes:
                        personRef.child("breakfast").setValue(1);
                        break;
                    case R.id.rb_bkfs_no:
                        personRef.child("breakfast").setValue(0);
                        break;
                }

                switch (dnnr_id) {
                    case R.id.rb_dnnr_yes:
                        personRef.child("dinner").setValue(1);
                        break;
                    case R.id.rb_dnnr_no:
                        personRef.child("dinner").setValue(0);
                        break;
                }

                switch (lnch_id) {
                    case R.id.rb_lnch_yes:
                        personRef.child("lunch").setValue(1);
                        break;
                    case R.id.rb_lnch_no:
                        personRef.child("lunch").setValue(0);
                        break;
                }

                Toast.makeText(MemberMessDetails.this, "Status Updated", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

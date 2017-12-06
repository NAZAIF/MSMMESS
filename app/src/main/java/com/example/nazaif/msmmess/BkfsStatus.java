package com.example.nazaif.msmmess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BkfsStatus extends AppCompatActivity {

    int count = 0;
    DatabaseReference membersRef = FirebaseDatabase.getInstance().getReference().child("members");

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkfs_status);

        listView = (ListView) findViewById(R.id.listView1);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(arrayAdapter);

        membersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Set<String> set = new HashSet<String>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if ((long) snapshot.child("breakfast").getValue() == 1) {
                        set.add(snapshot.getKey());
                        count++;
                    }
                }
                nameList.clear();
                nameList.addAll(set);

                arrayAdapter.notifyDataSetChanged();
                setTitle("Breakfast Count : " + count);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

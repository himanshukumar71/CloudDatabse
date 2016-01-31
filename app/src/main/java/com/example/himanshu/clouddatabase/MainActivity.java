package com.example.himanshu.clouddatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView firedata;
    Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        firedata = (TextView)findViewById(R.id.firedata);
        mRef = new Firebase("https://blinding-heat-4834.firebaseio.com/condition");
        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myText = (EditText) findViewById(R.id.myText);
                String text = myText.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                mRef.setValue(text);
            }
        });

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String superdata = (String)dataSnapshot.getValue();
                firedata.setText(superdata);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }
}

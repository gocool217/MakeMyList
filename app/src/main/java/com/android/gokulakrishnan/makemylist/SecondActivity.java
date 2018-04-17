package com.android.gokulakrishnan.makemylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {



    private FirebaseAuth firebaseAuth;
    private Button logout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button)findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });


    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, MainActivity.class));
    }


    public void predict(View view) {
        Intent i = new Intent(SecondActivity.this, PredictActivity.class);
        startActivity(i);
    }

    public void nearby(View view) {
        Intent i = new Intent(SecondActivity.this, NearbyActivity.class);
        startActivity(i);
    }

    public void createlist(View view) {
        Intent i = new Intent(SecondActivity.this, CreateListActivity.class);
        startActivity(i);
    }













}

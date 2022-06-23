package com.meyfandi.faceimage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.net.Uri;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class Menu extends AppCompatActivity {
    private Button btnscan ,btnhistory ,btnhelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnscan =findViewById(R.id.btnscan);
        btnhistory =findViewById(R.id.btnhistori);
        btnhelp =findViewById(R.id.btnhelp);

        btnscan.setOnClickListener(view -> {
//                Toast.makeText(getApplicationContext(),"aloo ini bantun 1",Toast.LENGTH_SHORT).show();
            Intent Intent =new Intent(getApplicationContext(), MainActivity.class);
            startActivity(Intent);
        });
        btnhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent =new Intent(getApplicationContext(), Login.class);
                startActivity(Intent);

            }
        });
        btnhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent =new Intent(getApplicationContext(),Login.class);
                startActivity(Intent);

            }
        });
    }

}
package com.example.ongajong.fastout2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);
        Button btn_addProd = (Button) findViewById(R.id.navi_addProduct);
        btn_addProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewMain.this, AddProduct.class));
            }
        });
        Button btn_view = (Button) findViewById(R.id.navi_viewProduct);
        btn_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewMain.this, DisplayEdit.class));
            }
        });
    }
}

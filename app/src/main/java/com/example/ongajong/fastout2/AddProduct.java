package com.example.ongajong.fastout2;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;

import java.util.Random;

public class AddProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        final EditText ed_addname = (EditText) findViewById(R.id.ed_addname);
        final EditText ed_addprice = (EditText) findViewById(R.id.ed_addprice);
        Button btn_submit = (Button) findViewById(R.id.btn_add);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int i1 = r.nextInt(200-100)+100;
                String curr = ed_addname.getText().toString().replaceAll("[^A-Za-z]+", "").toLowerCase();
                curr += i1;
                Bitmap myBitmap = QRCode.from(curr).bitmap();
                ImageView myImage = (ImageView) findViewById(R.id.qrdisplay);
                Log.i("Laura", "QR DIsplayed");
                myImage.setImageBitmap(myBitmap);
                DataProvider.addProduct(curr, ed_addname.getText().toString(),Double.parseDouble(ed_addprice.toString()));
            }
        });
    }
}

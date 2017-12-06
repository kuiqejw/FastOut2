package com.example.ongajong.fastout2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.glxn.qrgen.android.QRCode;

import java.util.Random;

public class AddProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Laura","add Product created");
        setContentView(R.layout.activity_add_product);
        final EditText ed_addname = (EditText) findViewById(R.id.ed_addname);
        final EditText ed_addprice = (EditText) findViewById(R.id.ed_addprice);
        final EditText ed_addquantity = (EditText) findViewById(R.id.ed_addquantity);

        Button btn_submit = (Button) findViewById(R.id.btn_add);

        Log.i("Objects Created","On Click before");
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int i1 = r.nextInt(200-100)+100;
                String curr = ed_addname.getText().toString();
                String curr1  = curr.replaceAll("[^A-Za-z]+", "").toLowerCase() + i1;
                Bitmap myBitmap = QRCode.from(curr1).bitmap();
                ImageView myImage = (ImageView) findViewById(R.id.qrdisplay);
                Log.i("Laura", "QR Displayed");
                myImage.setImageBitmap(myBitmap);

                Double NewPrice = Double.parseDouble(ed_addprice.getText().toString());
                Integer Quantity = Integer.parseInt(ed_addquantity.getText().toString());
                Product item = new Product(curr1, curr, NewPrice,Quantity);
                Log.i("Laura", "New Conversion to Product done");
                DataProvider.productList.add(item);
                DataProvider.productMap.put(curr1, item);
                Log.i("Laura", "Added to internal List");
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef  = database.getReference("ProductList");
                myRef.child(curr).child("price").setValue(NewPrice);
                myRef.child(curr).child("itemId").setValue(curr1);
                myRef.child(curr).child("quantity").setValue(Quantity);
                //sendEmail();

            }
        });
    }protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"lauraong1@yahoo.com.sg"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(AddProduct.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}

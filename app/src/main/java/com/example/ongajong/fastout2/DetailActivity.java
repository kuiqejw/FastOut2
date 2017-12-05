package com.example.ongajong.fastout2;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Iterator;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final String productId = getIntent().getStringExtra(MainActivity.PRODUCT_ID);
        Product product = DataProvider.productMap.get(productId);
        TextView tv = (TextView) findViewById(R.id.nameText);
        tv.setText(product.getName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(product.getPrice());
        TextView priceText = (TextView) findViewById(R.id.priceText);
        priceText.setText(price);

        TextView descView = (TextView) findViewById(R.id.descriptionText);
        descView.setText(product.getDescription());
        //todo remove image from this if firebase implemented and put in QR CODE if Want
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        try {
            Bitmap bitmap = getBitmapFromAsset(product.getProductId());
            iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Button EditBtn = (Button) findViewById(R.id.button);
        EditBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //todo Edit contents of Firebase
                Iterator<String> it = DataProvider.productMap.keySet().iterator();
                while (it.hasNext()){
                }
            }
        });
        Button DeleteBtn = (Button) findViewById(R.id.button2);
        DeleteBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //todo Edit contents of Firebase
                Iterator itr = DataProvider.productList.iterator();
                while (itr.hasNext()){
                    DataProvider.deleteProduct(productId);
                }
            }
        });


    }
    private Bitmap getBitmapFromAsset(String productId) throws IOException {
        AssetManager assetManager = getAssets();
        InputStream stream = null;
        try{
            stream = assetManager.open(productId + ".png");
            return BitmapFactory.decodeStream(stream);
        }catch (IOException e){return null;}
    }
}

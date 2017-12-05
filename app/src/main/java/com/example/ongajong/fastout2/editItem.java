package com.example.ongajong.fastout2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        EditText name = findViewById(R.id.editText1);
        final String name1 = name.getText().toString();
        EditText price = findViewById(R.id.editText2);
        final Double price1 = Double.parseDouble(price.getText().toString());
        Button btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo save to firebase
                    Product item = new Product("blah blah blah", "blah blah ", "---", price1);
                    DataProvider.productList.add(item);
                    DataProvider.productMap.put(name1+"101", item);
                    finish();
                }

        });
    }
}

package com.example.ongajong.fastout2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class DisplayEdit extends AppCompatActivity {
    private List<Product> products = DataProvider.productList;
    public static final String PRODUCT_ID = "PRODUCT_ID";

    private static final int DETAIL_REQUEST = 1111;
    public static final String RETURN_MESSAGE = "RETURN MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items = getResources().getStringArray(R.array.item);
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                        android.R.id.text1,items);
        ProductListAdapter adapter = new ProductListAdapter(this,R.layout.list_item, products);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Intent intent = new Intent(DisplayEdit.this, DetailActivity.class);
                //create an instance of class and display there
                Product product = products.get(position);//have the complex product. Could break this down and pass value to all of product
                //go with simpler approach: pass product Id, primary key and leave it to decide what to di.

                intent.putExtra(PRODUCT_ID, product.getProductId());//String is the name of extra, and the primitives and other simple types of java
                startActivityForResult(intent,DETAIL_REQUEST);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        String[] items = getResources().getStringArray(R.array.item);
        ProductListAdapter adapter = new ProductListAdapter(this,R.layout.list_item, products);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Intent intent = new Intent(DisplayEdit.this, DetailActivity.class);
                //create an instance of class and display there
                Product product = products.get(position);//have the complex product. Could break this down and pass value to all of product
                //go with simpler approach: pass product Id, primary key and leave it to decide what to di.

                intent.putExtra(PRODUCT_ID, product.getProductId());//String is the name of extra, and the primitives and other simple types of java
                startActivityForResult(intent,DETAIL_REQUEST);
            }
        });
    }
}

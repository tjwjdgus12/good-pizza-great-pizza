package com.example.good_pizza_great_pizza;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        int n = intent.getIntExtra("menu_num", 0);

        String[] name = new String[n];
        String[] cost = new String[n];
        String[] count = new String[n];
        String[] sum = new String[n];

        for(int i = 0;i < n;i++){
            count[i] = intent.getStringExtra("menu_count".concat(Integer.toString(i)));
            name[i] = intent.getStringExtra("menu_name".concat(Integer.toString(i)));
            cost[i] = intent.getStringExtra("menu_cost".concat(Integer.toString(i)));
            sum[i] = Integer.toString((Integer.parseInt(cost[i]) * Integer.parseInt(count[i])));
        }

        TextView totalcostText = (TextView) findViewById(R.id.totalcost);
        int totalcost = 0;
        for(int i = 0;i < n;i++){
            totalcost += Integer.parseInt(sum[i]);
        }
        totalcostText.setText(Integer.toString(totalcost).concat("원"));

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        ListView listview_name = (ListView) findViewById(R.id.menu_name);
        listview_name.setAdapter(adapter);

        ListAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cost);
        ListView listview_cost = (ListView) findViewById(R.id.menu_cost);
        listview_cost.setAdapter(adapter2);

        ListAdapter adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, count);
        ListView listview_count = (ListView) findViewById(R.id.menu_count);
        listview_count.setAdapter(adapter3);

        ListAdapter adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sum);
        ListView listview_sum = (ListView) findViewById(R.id.menu_sum);
        listview_sum.setAdapter(adapter4);

        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(OrderActivity.this);
                builder.setMessage("장바구니로 돌아가시겠습니가?");
                builder.setTitle("결제 취소")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("결제 취소");
                alert.show();
            }
        });

    }

}

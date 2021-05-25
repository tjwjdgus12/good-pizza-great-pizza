package com.example.good_pizza_great_pizza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListViewBtnAdapter.ListBtnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview;
        ListViewBtnAdapter adapter;
        ArrayList<ListViewBtnItem> items = new ArrayList<ListViewBtnItem>();
        ListViewBtnItem item = new ListViewBtnItem();
        item.setText_name("피자");
        item.setText_cost("1700");
        item.setText_count("1");
        items.add(item);
        adapter = new ListViewBtnAdapter(this, R.layout.listview_btn_item, items,this);
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // TODO : item click
            }
        }) ;



        /*String[] items = {
                "콤비네이션 피자",
                "하와이안 피자",
                "치즈 피자",
                "포테이토 피자",
                "고구마 피자",
                "불고기 피자",
                "페페로니 피자",
        };

        String[] costs = {
                "17000",
                "20000",
                "15000",
                "17000",
                "17000",
                "18000",
                "16000",
        };

        String[] counts = {
                "2",
                "2",
                "2",
                "3",
                "1",
                "1",
                "1",
        };
        Button[] btn = {};

        TextView totalcostText = (TextView) findViewById(R.id.totalcost);
        int totalcost = 0;
        for(int i = 0;i < costs.length;i++){
            totalcost += Integer.parseInt(costs[i]) * Integer.parseInt(counts[i]);
        }
        totalcostText.setText(Integer.toString(totalcost).concat("원"));


        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        ListAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, costs);
        ListView listView2 = (ListView) findViewById(R.id.costs);
        listView2.setAdapter(adapter2);
        ListAdapter adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, counts);
        ListView listView3 = (ListView) findViewById(R.id.counts);
        listView3.setAdapter(adapter3);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        */
        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("종료하시겠습니까?");
                builder.setTitle("종료 알림창")
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
                alert.setTitle("종료 알림창");
                alert.show();
            }
        });
    }

    @Override
    public void onListBtnClick(int position) {
        Toast.makeText(this, "수량이 변경되었습니다.", Toast.LENGTH_SHORT).show();
    }
}
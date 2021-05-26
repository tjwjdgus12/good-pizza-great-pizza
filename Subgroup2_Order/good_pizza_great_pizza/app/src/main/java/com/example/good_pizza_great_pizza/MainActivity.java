package com.example.good_pizza_great_pizza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements ListViewBtnAdapter.ListBtnClickListener{
    ArrayList<ListViewBtnItem> items;

    public void adapterLink() {
        ListViewBtnAdapter adapter = new ListViewBtnAdapter(this, R.layout.listview_btn_item, items,this);
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview;
        ListViewBtnAdapter adapter;
        items = new ArrayList<ListViewBtnItem>();

        ListViewBtnItem item1 = new ListViewBtnItem("콤비네이션 피자", "17000", "1");
        ListViewBtnItem item2 = new ListViewBtnItem("하와이안 피자", "19000", "1");
        ListViewBtnItem item3 = new ListViewBtnItem("치즈 피자", "15000", "1");
        ListViewBtnItem item4 = new ListViewBtnItem("고구마 피자", "16000", "1");
        ListViewBtnItem item5 = new ListViewBtnItem("디럭스 불고기 피자", "180000", "1");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);


        listview = (ListView) findViewById(R.id.listview);
        adapterLink();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // TODO : item click
            }
        }) ;

        TextView totalcostText = (TextView) findViewById(R.id.totalcost);
        int totalcost = 0;
        for(ListViewBtnItem it : items){
            totalcost += Integer.parseInt(it.getText_cost()) * Integer.parseInt(it.getText_count());
        }
        totalcostText.setText(Integer.toString(totalcost).concat("원"));

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
    public void onListBtnClick() {
        Toast.makeText(this, "수량이 변경되었습니다.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateTotalCost(int change) {
        TextView totalcostText = (TextView) findViewById(R.id.totalcost);
        String tx = totalcostText.getText().toString();
        int currentCost = Integer.parseInt(tx.substring(0,tx.length()-1));
        currentCost += change;
        totalcostText.setText(Integer.toString(currentCost).concat("원"));
    }
}
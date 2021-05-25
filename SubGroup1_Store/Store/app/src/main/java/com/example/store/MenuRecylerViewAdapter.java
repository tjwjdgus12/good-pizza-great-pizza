package com.example.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuRecylerViewAdapter extends RecyclerView.Adapter<MenuRecylerViewAdapter.ItemViewHolder> {

    private ArrayList<PMenu> menuList;
    private int position;

    public MenuRecylerViewAdapter(ArrayList<PMenu> list) {
        this.menuList = list;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView price;
        //protected ImageView image;

        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name_view);
            this.price = itemView.findViewById(R.id.price_view);
            //this.image = itemView.findViewById(R.id.image);
        }

        public void onBind(PMenu menu) {
            name.setText(menu.getName());
            price.setText(Integer.toString(menu.getPrice()));
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewholder, final int position){
        viewholder.onBind(menuList.get(position));

        //viewholder.button.setOnClickListener

        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(), position + "번째 메뉴 클릭!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return (null != menuList ? menuList.size() : 0);
    }

    public ArrayList<PMenu> getListData(){
        return menuList;
    }

    public void setListData(ArrayList<PMenu> listData){
        this.menuList = listData;
    }

    public void addItem(PMenu data){
        menuList.add(data);
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    // removeItem

    // delete diaglog
}

package com.example.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.ItemViewHolder> {

    private ArrayList<PMenu> menuList;
    private int position;

    public MenuRecyclerViewAdapter(ArrayList<PMenu> list) {
        this.menuList = list;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView price;
        protected Button button;
        protected ImageView image;

        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name_view);
            this.price = itemView.findViewById(R.id.price_view);
            this.button = itemView.findViewById(R.id.add_button);
            this.image = itemView.findViewById(R.id.image_view);
        }

        public void onBind(PMenu menu) {
            name.setText(menu.getName());
            price.setText(Integer.toString(menu.getPrice()));
            /* 이창민 수정) 이미지 변경 가능: MenuAccessor에서 R.drawable 값 바꾸면 됨 */
            image.setImageResource(menu.getImage());
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

        viewholder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(), menuList.get(position).getName() + "의 상세정보가 등록되지 않았습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        viewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(), "카트에 " + menuList.get(position).getName() + "가 추가되었습니다.", Toast.LENGTH_SHORT).show();
            }

            // CartManager.addMenu(menuList.get(position));

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
}

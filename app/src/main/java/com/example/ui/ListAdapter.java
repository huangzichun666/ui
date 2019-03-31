package com.example.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    public int selectedPosition=0;
    private Context mContext;
    private LayoutInflater inflater;
    private ListEntity entity;
    private List<ListEntity> entities;

    public ListAdapter(Context mContext, List<ListEntity> entities) {
        this.mContext=mContext;
        this.entities=entities;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int position) {
        return entities.get(position);
    }

    @Override
    public long getItemId(int position) {
        selectedPosition=position;
        return selectedPosition;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_item, null);
            viewHolder.textView=convertView.findViewById(R.id.text);
            viewHolder.imageView = convertView.findViewById(R.id.image);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        entity = entities.get(position);
        viewHolder.textView.setText(entity.getText());
        viewHolder.imageView.setImageResource(entity.getImage());

        return  convertView;
    }

    class ViewHolder{
        private TextView textView;
        private ImageView imageView;
    }
}

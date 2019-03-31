package com.example.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {


    private ListEntity entity;
    private ListView listView;
    private List<ListEntity> mLists;
    private String[] texts = {"Lion", "Tiger", "Monkey", "Dog", "Cat"};
    private int[] images = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        init();
        //初始化并设置监听器
        final ListAdapter adapter = new ListAdapter(ListActivity.this, mLists);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setSelector(R.color.red);

        //设置列表点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, texts[position], Toast.LENGTH_LONG).show();
            }
        });
    }
    public void init(){
        listView = (ListView)findViewById(R.id.ListView);
        mLists = new ArrayList<ListEntity>();
        for(int i=0;i<5;i++){
            entity = new ListEntity(texts[i], images[i]);
            mLists.add(entity);
        }
    }
}


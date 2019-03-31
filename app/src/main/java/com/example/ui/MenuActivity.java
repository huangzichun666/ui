package com.example.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        init();
    }

    private void init(){
        textView = findViewById(R.id.text);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //导入菜单布局
        getMenuInflater().inflate(R.menu.two, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //创建菜单项的点击事件
        switch (item.getItemId()) {
            case R.id.mune_size:
                break;
            case R.id.mune_setting:
                Toast.makeText(this, "点击了普通选项", Toast.LENGTH_SHORT).show();break;
            case R.id.mune_color:
                break;
            case R.id.mune_size_big:
                textView.setTextSize(20);break;
            case R.id.mune_size_zhong:
                textView.setTextSize(16);break;
            case R.id.mune_size_small:
                textView.setTextSize(10);break;
            case R.id.mune_size_red:
                textView.setTextColor(getResources().getColor(R.color.red));break;
            case R.id.mune_size_balke:
                textView.setTextColor(getResources().getColor(R.color.blake));break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}


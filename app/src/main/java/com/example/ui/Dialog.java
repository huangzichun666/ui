package com.example.ui;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Dialog extends AppCompatActivity {

    private Button button;
    private View altertDialogView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity);
        init();
    }

    public void init(){
        button = findViewById(R.id.button);
        altertDialogView = getLayoutInflater().inflate(R.layout.dialog_item,null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder loginAltertDialog = new AlertDialog.Builder(Dialog.this);
                loginAltertDialog.setView (altertDialogView);
                loginAltertDialog.show();
            }
        });
    }
}

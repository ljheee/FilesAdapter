package com.example.administrator.filesadapter;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    FileAdapter fileAdapter;

    File[] data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 加载布局
        setContentView(R.layout.activity_main);

        // 初始化
        initView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);

        // 获得外部存储的路径
        File path = Environment.getExternalStorageDirectory();
        data = path.listFiles();

        fileAdapter = new FileAdapter(this, data);
        listView.setAdapter(fileAdapter);

        // 注册监听器
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        File f = fileAdapter.getItem(position);
                        // 如果是目录 进入目录

                        if (f.isDirectory()) {
                            // TODO
                        } else {
                            // TODO
                        }

                        // Toast
                        Toast.makeText(MainActivity.this, f.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}


package com.example.dongja94.samplecustomchoicelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new MyAdapter();
        listView.setAdapter(mAdapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        initData();
    }

    public void onChoiceItem(View view) {
        if (listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE) {
            SparseBooleanArray selection = listView.getCheckedItemPositions();
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < selection.size(); index++) {
                int position = selection.keyAt(index);
                if (selection.get(position)) {
                    sb.append((String)listView.getItemAtPosition(position)).append(",");
                }
            }
            Toast.makeText(MainActivity.this, "items : " + sb.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void initData() {
        for (int i = 0; i < 40 ; i++) {
            mAdapter.add("item : " + i);
        }
    }
}

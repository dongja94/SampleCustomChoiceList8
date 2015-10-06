package com.example.dongja94.samplecustomchoicelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2015-10-06.
 */
public class MyAdapter extends BaseAdapter {
    List<String> items = new ArrayList<String>();

    public void add(String text) {
        items.add(text);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView v;
        if (convertView != null) {
            v = (ItemView)convertView;
        } else {
            v = new ItemView(parent.getContext());
        }
        v.setText(items.get(position));
        return v;
    }
}

package com.example.dongja94.samplecustomchoicelist;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dongja94 on 2015-10-06.
 */
public class ItemView extends FrameLayout implements Checkable {
    public ItemView(Context context) {
        super(context);
        init();
    }

    TextView messageView;
    ImageView checkView, checkedImage;

    private void init() {
        inflate(getContext(), R.layout.view_item, this);
        messageView = (TextView)findViewById(R.id.text_message);
        checkView = (ImageView)findViewById(R.id.image_check);
        checkedImage = (ImageView)findViewById(R.id.checked_image);
    }

    public void setText(String text) {
        messageView.setText(text);
    }

    boolean isChecked = false;

    private void drawCheck() {
        if (isChecked) {
//            checkView.setImageResource(android.R.drawable.checkbox_on_background);
//            setBackgroundColor(Color.RED);
            checkedImage.setVisibility(View.VISIBLE);
        } else {
//            checkView.setImageResource(android.R.drawable.checkbox_off_background);
//            setBackgroundColor(Color.TRANSPARENT);
            checkedImage.setVisibility(View.GONE);
        }

    }

    @Override
    public void setChecked(boolean checked) {
        if (checked != isChecked) {
            isChecked = checked;
            drawCheck();
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}

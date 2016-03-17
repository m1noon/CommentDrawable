package com.m1noon.commentdrawable.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.m1noon.commentdrawable.CommentDrawable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView text1 = (TextView) findViewById(R.id.text_1);
        text1.setBackground(CommentDrawable.builder(this)
                .rectRadius(R.dimen.dimen_8)
                .triangleRadius(R.dimen.dimen_4)
                .triangleHeight(R.dimen.dimen_16)
                .triangleWidth(R.dimen.dimen_16)
                .color(R.color.app_gray)
                .build());

        TextView text2 = (TextView) findViewById(R.id.text_2);
        text2.setBackground(CommentDrawable.builder(this)
                .rectRadius(R.dimen.dimen_4)
                .triangleRadius(R.dimen.dimen_2)
                .triangleHeight(R.dimen.dimen_8)
                .triangleWidth(R.dimen.dimen_16)
                .color(R.color.app_blue)
                .build());

        TextView text3 = (TextView) findViewById(R.id.text_3);
        text3.setBackground(CommentDrawable.builder(this)
                .rectRadius(R.dimen.dimen_8)
                .triangleHeight(R.dimen.dimen_16)
                .triangleWidth(R.dimen.dimen_16)
                .color(R.color.app_white)
                .lineColor(R.color.app_gray)
                .lineWidth(R.dimen.dimen_2)
                .build());

        TextView text4 = (TextView) findViewById(R.id.text_4);
        text4.setBackground(CommentDrawable.builder(this)
                .rectRadius(R.dimen.dimen_64)
                .triangleRadius(R.dimen.dimen_4)
                .triangleHeight(R.dimen.dimen_16)
                .triangleWidth(R.dimen.dimen_16)
                .color(R.color.app_white)
                .lineColor(R.color.app_gray)
                .lineWidth(R.dimen.dimen_2)
                .build());
    }
}

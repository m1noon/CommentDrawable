package com.m1noon.commentdrawable.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.m1noon.commentdrawable.ArrowGravity;
import com.m1noon.commentdrawable.CommentDrawable;
import com.m1noon.commentdrawable.ArrowType;

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
                .color(R.color.app_black_transparent)
                .build());

        TextView text2 = (TextView) findViewById(R.id.text_2);
        text2.setBackground(CommentDrawable.builder(this)
                .rectRadius(R.dimen.dimen_4)
                .triangleRadius(R.dimen.dimen_2)
                .triangleHeight(R.dimen.dimen_8)
                .triangleWidth(R.dimen.dimen_16)
                .arrowType(ArrowType.LEFT)
                .arrowGravity(ArrowGravity.END)
                .arrowOffset(R.dimen.dimen_8)
                .color(R.color.app_blue)
                .build());

        TextView text3 = (TextView) findViewById(R.id.text_3);
        text3.setBackground(CommentDrawable.builder(this)
                .rectRadius(R.dimen.dimen_8)
                .triangleHeight(R.dimen.dimen_16)
                .triangleWidth(R.dimen.dimen_16)
                .arrowType(ArrowType.RIGHT)
                .color(R.color.app_blue_transparent)
                .lineColor(R.color.app_gray)
                .arrowGravity(ArrowGravity.START)
                .arrowOffset(R.dimen.dimen_8)
                .lineWidth(R.dimen.dimen_8)
                .build());

        TextView text4 = (TextView) findViewById(R.id.text_4);
        text4.setBackground(CommentDrawable.builder(this)
                .rectRadius(R.dimen.dimen_64)
                .triangleRadius(R.dimen.dimen_4)
                .triangleHeight(R.dimen.dimen_16)
                .triangleWidth(R.dimen.dimen_16)
                .color(R.color.app_black_transparent)
                .lineColor(R.color.app_blue_transparent)
                .lineWidth(R.dimen.dimen_2)
                .build());
    }
}

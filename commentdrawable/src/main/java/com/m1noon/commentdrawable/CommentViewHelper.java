package com.m1noon.commentdrawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by a13587 on 16/06/03.
 */
public class CommentViewHelper {

    private CommentViewHelper() {
    }

    public static void setUp(Context context, AttributeSet attrs, View view) {
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.CommentTextView);

        final ArrowType arrowType = ArrowType.values()[attr.getInt(R.styleable.CommentTextView_cd_arrowType, ArrowType.BOTTOM.ordinal())];
        final float arrowHeight = attr.getDimension(R.styleable.CommentTextView_cd_arrowHeight, 0); // TODO default height

        view.setPadding(
                view.getPaddingLeft() + (arrowType == ArrowType.LEFT ? (int) arrowHeight : 0),
                view.getPaddingTop() + (arrowType == ArrowType.TOP ? (int) arrowHeight : 0),
                view.getPaddingRight() + (arrowType == ArrowType.RIGHT ? (int) arrowHeight : 0),
                view.getPaddingBottom() + (arrowType == ArrowType.BOTTOM ? (int) arrowHeight : 0)
        );

        view.setBackground(CommentDrawable.builder(context)
                .rectRadius(attr.getDimension(R.styleable.CommentTextView_cd_rectRadius, 0))
                .arrowHeight(arrowHeight)
                .arrowWidth(attr.getDimension(R.styleable.CommentTextView_cd_arrowWidth, 0))// TODO default width
                .arrowRadius(attr.getDimension(R.styleable.CommentTextView_cd_arrowRadius, 0))
                .color(attr.getColor(R.styleable.CommentTextView_cd_color, Color.WHITE))
                .lineWidth(attr.getDimension(R.styleable.CommentTextView_cd_lineWidth, 0))
                .lineColor(attr.getColor(R.styleable.CommentTextView_cd_lineColor, Color.LTGRAY))
                .arrowOffset(attr.getDimension(R.styleable.CommentTextView_cd_arrowOffset, 0))
                .arrowType(arrowType)
                .arrowGravity(ArrowGravity.values()[attr.getInt(R.styleable.CommentTextView_cd_arrowGravity, ArrowGravity.CENTER.ordinal())])
                .build());

    }
}

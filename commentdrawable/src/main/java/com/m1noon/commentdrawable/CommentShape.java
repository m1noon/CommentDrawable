package com.m1noon.commentdrawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by m1noon on 16/03/17.
 */
/* package */ class CommentShape extends Shape {

    private int color;
    private float lineWidth;
    private int lineColor;

    private final PathMaker pathMaker;


    public CommentShape(int color, int lineColor, float lineWidth, PathMaker pathMaker) {
        this.color = color;
        this.lineWidth = lineWidth;
        this.lineColor = lineColor;
        this.pathMaker = pathMaker;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setAntiAlias(true);
        paint.setStrokeWidth(lineWidth);
        final Path path = pathMaker.make(getWidth(), getHeight());

        if (lineWidth > 0) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(lineColor);
            canvas.drawPath(path, paint);
        }

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        canvas.drawPath(path, paint);
    }
}

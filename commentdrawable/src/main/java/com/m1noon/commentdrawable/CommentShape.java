package com.m1noon.commentdrawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by m1noon on 16/03/17.
 */
/* package */ class CommentShape extends Shape {

    private float rectRadius;
    private float triangleHeight;
    private float triangleWidth;
    private float triangleRadius;
    private int color;
    private float lineWidth;
    private int lineColor;

    private final Path path = new Path();
    private final RectF cornerRect = new RectF();

    public CommentShape(float rectRadius, float triangleHeight, float triangleWidth, float triangleRadius, int color, float lineWidth, int lineColor) {
        this.rectRadius = rectRadius;
        this.triangleHeight = triangleHeight;
        this.triangleWidth = triangleWidth;
        this.triangleRadius = triangleRadius;
        this.color = color;
        this.lineWidth = lineWidth;
        this.lineColor = lineColor;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setAntiAlias(true);
        paint.setStrokeWidth(lineWidth);
        setUpPath();

        if (lineWidth > 0) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(lineColor);
            canvas.drawPath(path, paint);
        }

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        canvas.drawPath(path, paint);
    }

    private void setUpPath() {
        final float top = lineWidth / 2;
        final float left = lineWidth / 2;
        final float bottom = getHeight() - lineWidth;
        final float rectBottom = bottom - triangleHeight;
        final float right = getWidth() - lineWidth / 2;
        final float centerX = getWidth() / 3;

        float shortLine = Math.min(getWidth(), getHeight() - triangleHeight);
        final float radius = Math.min(rectRadius, shortLine);
        final float triangleRadius = Math.min(this.triangleRadius, shortLine);

        path.rewind();
        path.moveTo(centerX + triangleWidth / 2, rectBottom);
        path.lineTo(right - radius, rectBottom);
        cornerRect.set(right - radius, rectBottom - radius, right, rectBottom);
        path.arcTo(cornerRect, 90, -90);
        cornerRect.set(right - radius, top, right, top + radius);
        path.arcTo(cornerRect, 0, -90);
        cornerRect.set(left, top, left + radius, top + radius);
        path.arcTo(cornerRect, 270, -90);
        cornerRect.set(left, rectBottom - radius, left + radius, rectBottom);
        path.arcTo(cornerRect, 180, -90);
        path.lineTo(centerX - triangleWidth / 2, rectBottom);

        // draw triangle
        final float tW = Math.max(0, triangleWidth);
        final float tH = Math.max(0, triangleHeight);
        final float longSide = (float) Math.sqrt((tW * tW) + 4 * (tH * tH));
        final float bottomOffset = (longSide * triangleRadius / tW) - triangleRadius;
        final float angle = (float) (Math.toDegrees(Math.atan(tH / (tW / 2))));

        cornerRect.set(centerX - triangleRadius / 2, bottom - bottomOffset - triangleRadius, centerX + triangleRadius / 2, bottom - bottomOffset);
        path.arcTo(cornerRect, 90 + angle, -angle * 2);
        path.close();
    }
}

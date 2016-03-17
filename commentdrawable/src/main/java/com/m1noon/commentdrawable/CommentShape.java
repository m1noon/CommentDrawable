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

    private final RectF rect = new RectF();
    private final RectF triangleRoundArc = new RectF();
    private float rectRadius;
    private float triangleHeight;
    private float triangleWidth;
    private float triangleRadius;
    private int color;
    private float lineWidth;
    private int lineColor;


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
        paint.setStyle(Paint.Style.FILL);

        if (lineWidth > 0) {
            paint.setColor(lineColor);
            draw(canvas, paint, 0);
        }

        paint.setColor(color);
        draw(canvas, paint, lineWidth);
    }

    private void draw(Canvas canvas, Paint paint, final float padding) {
        //
        final float frameHeight = canvas.getHeight() - padding - padding;
        final float centerX = canvas.getWidth() / 2;

        // draw rect
        rect.set(padding, padding, canvas.getWidth() - padding, canvas.getHeight() - triangleHeight - padding);
        canvas.drawRoundRect(rect, rectRadius - padding, rectRadius - padding, paint);

        // draw triangle
        final float tW = Math.max(0, triangleWidth);
        final float tH = Math.max(0, triangleHeight);
        final float tR = Math.max(0, triangleRadius - padding);

        final float longSide = (float) Math.sqrt((tW * tW) + 4 * (tH * tH));
        final float x = 2 * tR * tH / longSide;
        final float y = frameHeight - tH + (1 - 4 * tR * tH / (tW * longSide)) * tH;
        Path path = new Path();
        path.moveTo(centerX - tW / 2, frameHeight - tH);
        path.lineTo(centerX - x, y);
        path.lineTo(centerX + x, y);
        path.lineTo(centerX + tW / 2, frameHeight - tH);
        path.lineTo(centerX - tW / 2, frameHeight - tH);
        path.close();
        canvas.drawPath(path, paint);

        // draw radius of triangle bottom
        final float circleCenterX = canvas.getWidth() / 2;
        final float circleCenterY = y - (tR * tW / longSide);
        triangleRoundArc.set(circleCenterX - tR, circleCenterY - tR, circleCenterX + tR, circleCenterY + tR);
        canvas.drawArc(triangleRoundArc, 0, 360, true, paint);
    }
}

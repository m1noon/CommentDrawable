package com.m1noon.commentdrawable;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
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

    private final Path mRectPath = new Path();
    private final Path mTrianglePath = new Path();
    private PathEffect mRectPathEffect;
    private PathEffect mTrianglePathEffect;

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
    protected void onResize(float width, float height) {
        super.onResize(width, height);
        float shortLine = Math.min(width, height);
        mTrianglePathEffect = new CornerPathEffect(Math.min(triangleRadius, shortLine / 2));
        mRectPathEffect = new CornerPathEffect(Math.min(rectRadius, shortLine / 2));
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setAntiAlias(true);
        paint.setStrokeWidth(lineWidth);

        setUpPath();

        if (lineWidth > 0) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(lineColor);
            paint.setPathEffect(mRectPathEffect);
            canvas.drawPath(mRectPath, paint);
            paint.setPathEffect(mTrianglePathEffect);
            canvas.drawPath(mTrianglePath, paint);
        }

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        paint.setPathEffect(mRectPathEffect);
        canvas.drawPath(mRectPath, paint);
        paint.setPathEffect(mTrianglePathEffect);
        canvas.drawPath(mTrianglePath, paint);
    }

    private void setUpPath() {
        final float offset = 100;

        final float top = lineWidth / 2;
        final float left = lineWidth / 2;
        final float bottom = getHeight() - lineWidth;
        final float rectBottom = bottom - triangleHeight;
        final float right = getWidth() - lineWidth / 2;
        final float centerX = getWidth() / 2;

        mRectPath.rewind();
        mRectPath.moveTo(centerX + triangleWidth / 2 + offset, rectBottom);
        mRectPath.lineTo(right, rectBottom);
        mRectPath.lineTo(right, top);
        mRectPath.lineTo(left, top);
        mRectPath.lineTo(left, rectBottom);
        mRectPath.lineTo(centerX - triangleWidth / 2 - offset, rectBottom);

        mTrianglePath.rewind();
        mTrianglePath.moveTo(centerX - triangleWidth / 2 - offset, rectBottom);
        mTrianglePath.lineTo(centerX - triangleWidth / 2, rectBottom);
        mTrianglePath.lineTo(centerX, bottom);
        mTrianglePath.lineTo(centerX + triangleWidth / 2, rectBottom);
        mTrianglePath.lineTo(centerX + triangleWidth / 2 + offset, rectBottom);
    }
}

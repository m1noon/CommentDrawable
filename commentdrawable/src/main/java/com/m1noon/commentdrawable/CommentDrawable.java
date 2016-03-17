package com.m1noon.commentdrawable;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.v4.content.ContextCompat;

/**
 * Created by m1noon on 16/03/17.
 */
public class CommentDrawable extends ShapeDrawable {

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public static class Builder {
        private Context context;

        private float rectRadius;
        private float triangleHeight;
        private float triangleWidth;
        private float triangleRadius;
        private int color;
        private float lineWidth;
        private int lineColor;

        public Builder(Context context) {
            this.context = context;
            color = Color.LTGRAY;
        }

        public Builder rectRadius(@DimenRes int dimenRes) {
            rectRadius = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder triangleHeight(@DimenRes int dimenRes) {
            triangleHeight = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder triangleWidth(@DimenRes int dimenRes) {
            triangleWidth = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder triangleRadius(@DimenRes int dimenRes) {
            triangleRadius = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder color(@ColorRes int colorRes) {
            color = ContextCompat.getColor(context, colorRes);
            return this;
        }

        public Builder lineWidth(@DimenRes int dimenRes) {
            lineWidth = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder lineColor(@ColorRes int colorRes) {
            lineColor = ContextCompat.getColor(context, colorRes);
            return this;
        }

        public ShapeDrawable build() {
            return new ShapeDrawable(new CommentShape(rectRadius, triangleHeight, triangleWidth, triangleRadius, color, lineWidth, lineColor));
        }

    }
}

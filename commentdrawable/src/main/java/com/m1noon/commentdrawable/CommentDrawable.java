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

    public CommentDrawable(CommentShape s) {
        super(s);
    }

    public static class Builder {
        private Context context;

        private ArrowDirection arrowDirection = ArrowDirection.DOWN;
        private ArrowGravity arrowGravity = ArrowGravity.CENTER;
        private float rectRadius;
        private float arrowHeight;
        private float arrowWidth;
        private float arrowRadius;
        private int color;
        private float lineWidth;
        private int lineColor;
        private float arrowOffset;

        public Builder(Context context) {
            this.context = context;
            color = Color.LTGRAY;
        }

        public Builder rectRadius(@DimenRes int dimenRes) {
            rectRadius = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder rectRadius(float radius) {
            rectRadius = radius;
            return this;
        }

        public Builder arrowHeight(@DimenRes int dimenRes) {
            arrowHeight = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder arrowHeight(float arrowHeight) {
            this.arrowHeight = arrowHeight;
            return this;
        }

        public Builder arrowWidth(@DimenRes int dimenRes) {
            arrowWidth = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder arrowWidth(float arrowWidth) {
            this.arrowWidth = arrowWidth;
            return this;
        }

        public Builder arrowRadius(@DimenRes int dimenRes) {
            arrowRadius = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder arrowRadius(float radius) {
            arrowRadius = radius;
            return this;
        }

        public Builder colorRes(@ColorRes int colorRes) {
            color = ContextCompat.getColor(context, colorRes);
            return this;
        }

        public Builder color(int color) {
            this.color = color;
            return this;
        }

        public Builder lineWidth(@DimenRes int dimenRes) {
            lineWidth = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder lineWidth(float width) {
            this.lineWidth = width;
            return this;
        }

        public Builder lineColorRes(@ColorRes int colorRes) {
            lineColor = ContextCompat.getColor(context, colorRes);
            return this;
        }

        public Builder lineColor(int color) {
            lineColor = color;
            return this;
        }

        public Builder arrowDirection(ArrowDirection arrowDirection) {
            this.arrowDirection = arrowDirection;
            return this;
        }

        public Builder arrowGravity(ArrowGravity arrowGravity) {
            this.arrowGravity = arrowGravity;
            return this;
        }

        public Builder arrowOffset(@DimenRes int offsetRes) {
            this.arrowOffset = context.getResources().getDimension(offsetRes);
            return this;
        }

        public Builder arrowOffset(float offset) {
            this.arrowOffset = offset;
            return this;
        }

        public CommentDrawable build() {
            return new CommentDrawable(
                    new CommentShape(color, lineColor, lineWidth,
                            new PathMaker(
                                    arrowDirection.rectPathMaker(arrowHeight, rectRadius, lineWidth),
                                    arrowDirection.arrowPathMaker(arrowHeight, arrowWidth, arrowRadius, lineWidth),
                                    arrowGravity.arrowPositionMaker(arrowOffset == 0 ? arrowWidth * 2 : arrowOffset, arrowDirection))
                    ));
        }

    }
}

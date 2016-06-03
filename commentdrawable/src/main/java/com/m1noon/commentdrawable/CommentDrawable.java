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

        private ArrowType arrowType = ArrowType.BOTTOM;
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

        public Builder arrowHeight(@DimenRes int dimenRes) {
            arrowHeight = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder arrowWidth(@DimenRes int dimenRes) {
            arrowWidth = context.getResources().getDimension(dimenRes);
            return this;
        }

        public Builder arrowRadius(@DimenRes int dimenRes) {
            arrowRadius = context.getResources().getDimension(dimenRes);
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

        public Builder arrowType(ArrowType arrowType) {
            this.arrowType = arrowType;
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

        public ShapeDrawable build() {
            return new ShapeDrawable(new CommentShape(color, lineColor, lineWidth,
                    new PathMaker(arrowType.rectPathMaker(arrowHeight, rectRadius, lineWidth),
                            arrowType.arrowPathMaker(arrowHeight, arrowWidth, arrowRadius, lineWidth),
                            arrowGravity.arrowPositionMaker(arrowOffset == 0 ? arrowWidth * 2 : arrowOffset, arrowType))));
        }

    }
}

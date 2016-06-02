package com.m1noon.commentdrawable;

import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by m1noon on 16/06/03.
 */
/* package */ abstract class PathMaker {

    protected RectPathMaker rectPathMaker;
    protected ArrowPathMaker arrowPathMaker;
    protected final RectF rect = new RectF();
    protected final Path path = new Path();

    PathMaker(RectPathMaker rectPathMaker, ArrowPathMaker arrowPathMaker) {
        this.rectPathMaker = rectPathMaker;
        this.arrowPathMaker = arrowPathMaker;
    }

    /* package */ final Path make(float width, float height) {
        rectPathMaker.setSize(width, height);
        arrowPathMaker.setSize(width, height);
        final float centerX = width / 2;
        make(width, height, centerX);
        return path;
    }

    abstract void make(float width, float height, float center);

    /* package */ static class RectPathMaker {

        private final float leftOffset;
        private final float topOffset;
        private final float rightOffset;
        private final float bottomOffset;
        private final float lineWidth;
        private final float wishedRadius;

        /* pckage */ float radius;
        /* pckage */ float left;
        /* pckage */ float top;
        /* pckage */ float right;
        /* pckage */ float bottom;

        public RectPathMaker(float leftOffset, float topOffset, float rightOffset, float bottomOffset, float radius, float lineWidth) {
            this.leftOffset = leftOffset;
            this.topOffset = topOffset;
            this.rightOffset = rightOffset;
            this.bottomOffset = bottomOffset;
            this.wishedRadius = radius;
            this.lineWidth = lineWidth;
        }

        public void setSize(float width, float height) {
            this.left = leftOffset + lineWidth / 2;
            this.top = topOffset + lineWidth / 2;
            this.right = width - rightOffset - lineWidth / 2;
            this.bottom = height - bottomOffset - lineWidth;
            this.radius = Math.min(wishedRadius, Math.min(width - leftOffset - rightOffset, height - topOffset - bottomOffset));
        }

        public void bottomLeft(RectF rect, Path path) {
            rect.set(left, bottom - radius, left + radius, bottom);
            path.arcTo(rect, 90, 90);
        }

        public void topLeft(RectF rect, Path path) {
            rect.set(left, top, left + radius, top + radius);
            path.arcTo(rect, 180, 90);
        }

        public void topRight(RectF rect, Path path) {
            rect.set(right - radius, top, right, top + radius);
            path.arcTo(rect, 270, 90);
        }

        public void bottomRight(RectF rect, Path path) {
            rect.set(right - radius, bottom - radius, right, bottom);
            path.arcTo(rect, 0, 90);
        }

        public float left() {
            return left;
        }

        public float top() {
            return top;
        }

        public float right() {
            return right;
        }

        public float bottom() {
            return bottom;
        }
    }

    /* package */ abstract static class ArrowPathMaker {
        private final float arrowHeight;
        private final float arrowWidth;
        private final float wishedArrowRadius;
        private final float lineWidth;
        protected float arrowRadius;
        protected float left;
        protected float top;
        protected float right;
        protected float bottom;

        public ArrowPathMaker(float arrowHeight, float arrowWidth, float arrowRadius, float lineWidth) {
            this.arrowHeight = arrowHeight;
            this.arrowWidth = arrowWidth;
            this.wishedArrowRadius = arrowRadius;
            this.arrowRadius = arrowRadius;
            this.lineWidth = lineWidth;
        }

        public void setSize(float width, float height) {
            arrowRadius = Math.min(wishedArrowRadius, Math.min(width, height));
            top = lineWidth;
            left = lineWidth;
            right = width - lineWidth;
            bottom = height - lineWidth;
        }

        public void make(RectF rect, Path path, float center) {
            final float tW = Math.max(0, arrowWidth);
            final float tH = Math.max(0, arrowHeight);
            final float longSide = (float) Math.sqrt((tW * tW) + 4 * (tH * tH));
            final float bottomOffset = (longSide * arrowRadius / tW) - arrowRadius;
            final float angle = (float) (Math.toDegrees(Math.atan(tH / (tW / 2))));

            make(rect, path, center, angle, bottomOffset);
        }

        protected abstract void make(RectF rect, Path path, float center, float angle, float bottomOffset);

        public float width() {
            return arrowWidth;
        }

        public float height() {
            return arrowHeight;
        }
    }


}

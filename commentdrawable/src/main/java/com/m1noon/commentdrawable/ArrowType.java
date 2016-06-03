package com.m1noon.commentdrawable;

import android.graphics.Path;
import android.graphics.RectF;

import com.m1noon.commentdrawable.PathMaker.ArrowPathMaker;
import com.m1noon.commentdrawable.PathMaker.RectPathMaker;

/**
 * Created by m1noon on 16/06/03.
 */
public enum ArrowType {
    LEFT {
        @Override
        protected RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth) {
            return new RectPathMaker(arrowHeight, 0, 0, 0, rectRadius, lineWidth) {
                @Override
                protected void make(Path path, RectF rect, float center, float arrowWidth) {
                    path.moveTo(left(), center - arrowWidth / 2);
                    topLeft(rect, path);
                    topRight(rect, path);
                    bottomRight(rect, path);
                    bottomLeft(rect, path);
                    path.lineTo(left(), center + arrowWidth / 2);
                }
            };
        }

        @Override
        protected ArrowPathMaker arrowPathMaker(float arrowHeight, float arrowWidth, float arrowRadius, float lineWidth) {
            return new ArrowPathMaker(arrowHeight, arrowWidth, arrowRadius, lineWidth) {
                @Override
                protected void make(RectF rect, Path path, float center, float angle, float bottomOffset) {
                    rect.set(left + bottomOffset, center - arrowRadius / 2, left + bottomOffset + arrowRadius, center + arrowRadius / 2);
                    path.arcTo(rect, 180 - angle, angle * 2);
                }
            };
        }
    },
    TOP {
        @Override
        protected RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth) {
            return new RectPathMaker(0, arrowHeight, 0, 0, rectRadius, lineWidth) {
                @Override
                protected void make(Path path, RectF rect, float center, float arrowWidth) {
                    path.moveTo(center + arrowWidth / 2, top());
                    topRight(rect, path);
                    bottomRight(rect, path);
                    bottomLeft(rect, path);
                    topLeft(rect, path);
                    path.lineTo(center - arrowWidth / 2, top());
                }
            };
        }

        @Override
        protected ArrowPathMaker arrowPathMaker(float arrowHeight, float arrowWidth, float arrowRadius, float lineWidth) {
            return new ArrowPathMaker(arrowHeight, arrowWidth, arrowRadius, lineWidth) {
                @Override
                protected void make(RectF rect, Path path, float center, float angle, float bottomOffset) {
                    rect.set(center - arrowRadius / 2, top + bottomOffset, center + arrowRadius / 2, top + bottomOffset + arrowRadius);
                    path.arcTo(rect, 270 - angle, angle * 2);
                }
            };
        }
    },
    RIGHT {
        @Override
        protected RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth) {
            return new RectPathMaker(0, 0, arrowHeight, 0, rectRadius, lineWidth) {
                @Override
                protected void make(Path path, RectF rect, float center, float arrowWidth) {
                    path.moveTo(right(), center + arrowWidth / 2);
                    bottomRight(rect, path);
                    bottomLeft(rect, path);
                    topLeft(rect, path);
                    topRight(rect, path);
                    path.lineTo(right(), center - arrowWidth / 2);
                }
            };
        }

        @Override
        protected ArrowPathMaker arrowPathMaker(float arrowHeight, float arrowWidth, float arrowRadius, float lineWidth) {
            return new ArrowPathMaker(arrowHeight, arrowWidth, arrowRadius, lineWidth) {
                @Override
                protected void make(RectF rect, Path path, float center, float angle, float bottomOffset) {
                    rect.set(right - bottomOffset - arrowRadius, center - arrowRadius / 2, right - bottomOffset, center + arrowRadius / 2);
                    path.arcTo(rect, -angle, angle * 2);
                }
            };
        }

    },
    BOTTOM {
        @Override
        protected RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth) {
            return new RectPathMaker(0, 0, 0, arrowHeight, rectRadius, lineWidth) {
                @Override
                protected void make(Path path, RectF rect, float center, float arrowWidth) {
                    path.moveTo(center - arrowWidth / 2, bottom());
                    bottomLeft(rect, path);
                    topLeft(rect, path);
                    topRight(rect, path);
                    bottomRight(rect, path);
                    path.lineTo(center + arrowWidth / 2, bottom());
                }
            };
        }

        @Override
        protected ArrowPathMaker arrowPathMaker(float arrowHeight, float arrowWidth, float arrowRadius, float lineWidth) {
            return new ArrowPathMaker(arrowHeight, arrowWidth, arrowRadius, lineWidth) {
                @Override
                protected void make(RectF rect, Path path, float center, float angle, float bottomOffset) {
                    rect.set(center - arrowRadius / 2, bottom - bottomOffset - arrowRadius, center + arrowRadius / 2, bottom - bottomOffset);
                    path.arcTo(rect, 90 - angle, angle * 2);
                }
            };
        }
    };

    protected abstract RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth);

    protected abstract ArrowPathMaker arrowPathMaker(float arrowHeight, float arrowWidth, float arrowRadius, float lineWidth);

}

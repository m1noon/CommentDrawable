package com.m1noon.commentdrawable;

import android.graphics.Path;
import android.graphics.RectF;

import com.m1noon.commentdrawable.PathMaker.ArrowPathMaker;
import com.m1noon.commentdrawable.PathMaker.RectPathMaker;

/**
 * Created by m1noon on 16/06/03.
 */
public enum ArrowType {
    BOTTOM {
        @Override
        protected RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth) {
            return new RectPathMaker(0, 0, 0, arrowHeight, rectRadius, lineWidth);
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

        @Override
        protected PathMaker pathMaker(RectPathMaker rectPathMaker, ArrowPathMaker arrowPathMaker) {
            return new PathMaker(rectPathMaker, arrowPathMaker) {
                @Override
                void make(float width, float height, final float centerX) {
                    // draw rect
                    path.rewind();
                    path.moveTo(centerX - arrowPathMaker.width() / 2, rectPathMaker.bottom());
                    rectPathMaker.bottomLeft(rect, path);
                    rectPathMaker.topLeft(rect, path);
                    rectPathMaker.topRight(rect, path);
                    rectPathMaker.bottomRight(rect, path);
                    path.lineTo(centerX + arrowPathMaker.width() / 2, rectPathMaker.bottom());

                    // draw triangle
                    arrowPathMaker.make(rect, path, centerX);
                    path.close();
                }
            };
        }
    },
    LEFT {
        @Override
        protected RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth) {
            return new RectPathMaker(arrowHeight, 0, 0, 0, rectRadius, lineWidth);
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

        @Override
        protected PathMaker pathMaker(RectPathMaker rectPathMaker, ArrowPathMaker arrowPathMaker) {
            return new PathMaker(rectPathMaker, arrowPathMaker) {
                @Override
                protected void make(float width, float height, float center) {
                    // draw rect
                    center = height / 2;
                    path.rewind();
                    path.moveTo(rectPathMaker.left(), center - arrowPathMaker.width() / 2);
                    rectPathMaker.topLeft(rect, path);
                    rectPathMaker.topRight(rect, path);
                    rectPathMaker.bottomRight(rect, path);
                    rectPathMaker.bottomLeft(rect, path);
                    path.lineTo(rectPathMaker.left, center + arrowPathMaker.width() / 2);

                    // draw triangle
                    arrowPathMaker.make(rect, path, center);
                    path.close();
                }
            };
        }
    },
    RIGHT {
        @Override
        protected RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth) {
            return new RectPathMaker(0, 0, arrowHeight, 0, rectRadius, lineWidth);
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

        @Override
        protected PathMaker pathMaker(RectPathMaker rectPathMaker, ArrowPathMaker arrowPathMaker) {
            return new PathMaker(rectPathMaker, arrowPathMaker) {
                @Override
                void make(float width, float height, float center) {
                    // draw rect
                    center = height / 2;
                    path.rewind();
                    path.moveTo(rectPathMaker.right(), center + arrowPathMaker.width() / 2);
                    rectPathMaker.bottomRight(rect, path);
                    rectPathMaker.bottomLeft(rect, path);
                    rectPathMaker.topLeft(rect, path);
                    rectPathMaker.topRight(rect, path);
                    path.lineTo(rectPathMaker.right(), center - arrowPathMaker.width() / 2);

                    // draw triangle
                    arrowPathMaker.make(rect, path, center);
                    path.close();
                }
            };
        }
    },
    TOP {
        @Override
        protected RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth) {
            return new RectPathMaker(0, arrowHeight, 0, 0, rectRadius, lineWidth);
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

        @Override
        protected PathMaker pathMaker(RectPathMaker rectPathMaker, ArrowPathMaker arrowPathMaker) {
            return new PathMaker(rectPathMaker, arrowPathMaker) {
                @Override
                void make(float width, float height, float center) {
                    // draw rect
                    path.rewind();
                    path.moveTo(center + arrowPathMaker.width() / 2, rectPathMaker.top());
                    rectPathMaker.topRight(rect, path);
                    rectPathMaker.bottomRight(rect, path);
                    rectPathMaker.bottomLeft(rect, path);
                    rectPathMaker.topLeft(rect, path);
                    path.lineTo(center - arrowPathMaker.width() / 2, rectPathMaker.top());

                    // draw triangle
                    arrowPathMaker.make(rect, path, center);
                    path.close();
                }
            };
        }
    };

    protected abstract RectPathMaker rectPathMaker(float arrowHeight, float rectRadius, float lineWidth);

    protected abstract ArrowPathMaker arrowPathMaker(float arrowHeight, float arrowWidth, float arrowRadius, float lineWidth);

    protected abstract PathMaker pathMaker(RectPathMaker rectPathMaker, ArrowPathMaker arrowPathMaker);

    /* package */ PathMaker pathMaker(final float arrowHeight, float arrowWidth, float arrowRadius, float rectRadius, float lineWidth) {
        return pathMaker(rectPathMaker(arrowHeight, rectRadius, lineWidth), arrowPathMaker(arrowHeight, arrowWidth, arrowRadius, lineWidth));
    }
}

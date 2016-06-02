package com.m1noon.commentdrawable;

/**
 * Created by m1noon on 16/06/03.
 */
public enum ArrowGravity {
    START {
        @Override
        public PathMaker.ArrowPositionMaker arrowPositionMaker(final float offset, final ArrowType arrowType) {
            return new PathMaker.ArrowPositionMaker() {
                @Override
                float make(float width, float height, float arrowWidth) {
                    return offset + arrowWidth / 2;
                }
            };
        }
    },
    END {
        @Override
        public PathMaker.ArrowPositionMaker arrowPositionMaker(final float offset, final ArrowType arrowType) {
            return new PathMaker.ArrowPositionMaker() {
                @Override
                float make(float width, float height, float arrowWidth) {
                    return getArrowLine(arrowType, width, height) - offset - arrowWidth / 2;
                }
            };
        }
    },
    CENTER {
        @Override
        public PathMaker.ArrowPositionMaker arrowPositionMaker(float offset, final ArrowType arrowType) {
            return new PathMaker.ArrowPositionMaker() {
                @Override
                float make(float width, float height, float arrowWidth) {
                    return getArrowLine(arrowType, width, height) / 2;
                }
            };
        }
    };

    abstract PathMaker.ArrowPositionMaker arrowPositionMaker(float offset, ArrowType arrowType);

    protected float getArrowLine(ArrowType arrowType, float width, float height) {
        switch (arrowType) {
            case BOTTOM:
            case TOP:
                return width;
            case LEFT:
            case RIGHT:
            default:
                return height;
        }
    }
}

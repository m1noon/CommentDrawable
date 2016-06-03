package com.m1noon.commentdrawable;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by a13587 on 16/06/03.
 */
public class CommentTextView extends TextView {

    public CommentTextView(Context context) {
        this(context, null);
    }

    public CommentTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        CommentViewHelper.setUp(context, attrs, this);
    }

}

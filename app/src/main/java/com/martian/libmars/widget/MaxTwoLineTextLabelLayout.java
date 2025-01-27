package com.martian.libmars.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class MaxTwoLineTextLabelLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10354a = 2;

    /* renamed from: b, reason: collision with root package name */
    private static final int f10355b = 2;

    public MaxTwoLineTextLabelLayout(Context context) {
        super(context);
    }

    private int a(TextView textView) {
        Layout layout = textView.getLayout();
        int lineCount = textView.getLineCount();
        if (layout == null || 1 >= lineCount) {
            return 0;
        }
        double lineWidth = layout.getLineWidth(1);
        Double.isNaN(lineWidth);
        return (int) (lineWidth + 0.5d);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b2) {
        if (getChildCount() == 2 && (getChildAt(0) instanceof TextView)) {
            int i2 = r - l;
            TextView textView = (TextView) getChildAt(0);
            int measuredWidth = textView.getMeasuredWidth();
            int measuredHeight = textView.getMeasuredHeight();
            View childAt = getChildAt(1);
            int measuredWidth2 = childAt.getMeasuredWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredHeight2 = childAt.getMeasuredHeight();
            if (measuredWidth + measuredWidth2 + marginLayoutParams.leftMargin <= i2) {
                textView.layout(0, 0, measuredWidth, measuredHeight);
                int i3 = measuredWidth + marginLayoutParams.leftMargin;
                int i4 = (measuredHeight - measuredHeight2) / 2;
                childAt.layout(i3, i4, measuredWidth2 + i3, measuredHeight2 + i4);
                return;
            }
            if (textView.getLineCount() == 1) {
                textView.layout(0, 0, measuredWidth, measuredHeight);
                int i5 = measuredHeight + marginLayoutParams.topMargin;
                childAt.layout(0, i5, measuredWidth2, measuredHeight2 + i5);
                return;
            }
            textView.layout(0, 0, measuredWidth, measuredHeight);
            int a2 = a(textView);
            int i6 = marginLayoutParams.leftMargin;
            if (a2 + i6 + measuredWidth2 < i2) {
                int i7 = a2 + i6;
                int i8 = ((measuredHeight + (measuredHeight / 2)) - measuredHeight2) / 2;
                childAt.layout(i7, i8, measuredWidth2 + i7, measuredHeight2 + i8);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (getChildCount() != 2 || !(getChildAt(0) instanceof TextView)) {
            setMeasuredDimension(size, size2);
            return;
        }
        TextView textView = (TextView) getChildAt(0);
        measureChild(textView, widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = textView.getMeasuredWidth();
        int measuredHeight = textView.getMeasuredHeight();
        View childAt = getChildAt(1);
        measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
        int measuredWidth2 = childAt.getMeasuredWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int measuredHeight2 = childAt.getMeasuredHeight();
        int i2 = measuredWidth2 + measuredWidth + marginLayoutParams.leftMargin;
        if (i2 <= size) {
            measuredWidth = i2;
        } else if (textView.getLineCount() == 1) {
            measuredHeight = marginLayoutParams.topMargin + measuredHeight + measuredHeight2;
        } else {
            measuredWidth = Math.max(measuredWidth, size);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public MaxTwoLineTextLabelLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}

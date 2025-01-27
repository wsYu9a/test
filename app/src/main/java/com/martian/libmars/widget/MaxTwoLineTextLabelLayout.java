package com.martian.libmars.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class MaxTwoLineTextLabelLayout extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public static final int f12660b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f12661c = 2;

    public MaxTwoLineTextLabelLayout(Context context) {
        super(context);
    }

    public final int a(TextView textView) {
        Layout layout = textView.getLayout();
        int lineCount = textView.getLineCount();
        if (layout == null || 1 >= lineCount) {
            return 0;
        }
        return (int) (layout.getLineWidth(1) + 0.5d);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (getChildCount() == 2 && (getChildAt(0) instanceof TextView)) {
            int i14 = i12 - i10;
            TextView textView = (TextView) getChildAt(0);
            int measuredWidth = textView.getMeasuredWidth();
            int measuredHeight = textView.getMeasuredHeight();
            View childAt = getChildAt(1);
            int measuredWidth2 = childAt.getMeasuredWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredHeight2 = childAt.getMeasuredHeight();
            if (measuredWidth + measuredWidth2 + marginLayoutParams.leftMargin <= i14) {
                textView.layout(0, 0, measuredWidth, measuredHeight);
                int i15 = measuredWidth + marginLayoutParams.leftMargin;
                int i16 = (measuredHeight - measuredHeight2) / 2;
                childAt.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
                return;
            }
            if (textView.getLineCount() == 1) {
                textView.layout(0, 0, measuredWidth, measuredHeight);
                int i17 = measuredHeight + marginLayoutParams.topMargin;
                childAt.layout(0, i17, measuredWidth2, measuredHeight2 + i17);
                return;
            }
            textView.layout(0, 0, measuredWidth, measuredHeight);
            int a10 = a(textView);
            int i18 = marginLayoutParams.leftMargin;
            if (a10 + i18 + measuredWidth2 < i14) {
                int i19 = a10 + i18;
                int i20 = ((measuredHeight + (measuredHeight / 2)) - measuredHeight2) / 2;
                childAt.layout(i19, i20, measuredWidth2 + i19, measuredHeight2 + i20);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (getChildCount() != 2 || !(getChildAt(0) instanceof TextView)) {
            setMeasuredDimension(size, size2);
            return;
        }
        TextView textView = (TextView) getChildAt(0);
        measureChild(textView, i10, i11);
        int measuredWidth = textView.getMeasuredWidth();
        int measuredHeight = textView.getMeasuredHeight();
        View childAt = getChildAt(1);
        measureChild(childAt, i10, i11);
        int measuredWidth2 = childAt.getMeasuredWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int measuredHeight2 = childAt.getMeasuredHeight();
        int i12 = measuredWidth2 + measuredWidth + marginLayoutParams.leftMargin;
        if (i12 <= size) {
            measuredWidth = i12;
        } else if (textView.getLineCount() == 1) {
            measuredHeight = marginLayoutParams.topMargin + measuredHeight + measuredHeight2;
        } else {
            measuredWidth = Math.max(measuredWidth, size);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public MaxTwoLineTextLabelLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

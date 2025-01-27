package y9;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public abstract class a extends tf.b {

    /* renamed from: e */
    @k
    public final List<View> f33077e;

    public a(@l Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f33077e = new ArrayList();
        this.f30865b = this;
    }

    @Override // android.view.View, android.view.ViewParent
    public boolean isLayoutRequested() {
        return this.f33077e.size() > 0 || super.isLayoutRequested();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f30867d == null) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                KeyEvent.Callback childAt = getChildAt(i10);
                if (childAt != null && (childAt instanceof pf.a)) {
                    this.f30867d = (pf.a) childAt;
                }
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            KeyEvent.Callback childAt = getChildAt(i10);
            if (childAt != null && (childAt instanceof pf.a)) {
                this.f30867d = (pf.a) childAt;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14 = i12 - i10;
        super.onLayout(z10, i10, i11, i12, i13);
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt != null && childAt.getVisibility() == 0) {
                int left = childAt.getLeft();
                int top = childAt.getTop();
                int right = childAt.getRight();
                int bottom = childAt.getBottom();
                int i16 = right - left;
                int i17 = bottom - top;
                int i18 = i14 - bottom;
                int i19 = (((i18 + i17) + i18) / 2) - (i16 / 2);
                int i20 = (((left + i16) + left) / 2) - (i17 / 2);
                childAt.setRotation(90.0f);
                childAt.layout(i19, i20, i16 + i19, i17 + i20);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        this.f33077e.clear();
        super.onMeasure(i11, i10);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt != null && childAt.getVisibility() == 0) {
                this.f33077e.add(childAt);
                childAt.setVisibility(8);
            }
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824));
        for (View view : this.f33077e) {
            if (view != null) {
                view.setVisibility(0);
            }
        }
        this.f33077e.clear();
    }
}

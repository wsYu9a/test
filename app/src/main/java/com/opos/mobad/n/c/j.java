package com.opos.mobad.n.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class j extends RelativeLayout {

    /* renamed from: a */
    private final a f22034a;

    /* renamed from: b */
    private float f22035b;

    public static class a {

        /* renamed from: a */
        public final int f22036a;

        /* renamed from: b */
        public final int f22037b;

        /* renamed from: c */
        public final int f22038c;

        /* renamed from: d */
        public final int f22039d;

        /* renamed from: e */
        public final int f22040e;

        /* renamed from: f */
        public final float f22041f;

        public a(int i2, int i3, float f2) {
            this(i2, i3, i2, f2);
        }

        public a(int i2, int i3, int i4, float f2) {
            f2 = f2 <= 0.0f ? 6.315f : f2;
            this.f22041f = f2;
            int i5 = i2 > 0 ? i2 : 171;
            this.f22037b = i5;
            this.f22036a = (int) (i5 / f2);
            if (i3 <= i5 && i3 > 0) {
                i2 = i3;
            }
            this.f22039d = i2;
            this.f22038c = (int) (i2 / f2);
            this.f22040e = a(i4);
        }

        public int a(int i2) {
            int i3 = this.f22039d;
            return (i2 > i3 && i2 < (i3 = this.f22037b)) ? i2 : i3;
        }

        public int b(int i2) {
            int i3 = this.f22038c;
            return (i2 > i3 && i2 < (i3 = this.f22036a)) ? i2 : i3;
        }

        public String toString() {
            return "maxH = " + this.f22036a + ",maxW = " + this.f22037b + ",minH = " + this.f22038c + ",minW = " + this.f22039d;
        }
    }

    public j(Context context, AttributeSet attributeSet, int i2, a aVar) {
        super(context, attributeSet, i2);
        this.f22035b = 1.0f;
        this.f22034a = aVar;
    }

    public j(Context context, AttributeSet attributeSet, a aVar) {
        this(context, attributeSet, 0, aVar);
    }

    public j(Context context, a aVar) {
        this(context, null, aVar);
    }

    private void a(View view, float f2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i2 = layoutParams.width;
        if (i2 != -2 && i2 != -1) {
            layoutParams.width = (int) (i2 * f2);
        }
        int i3 = layoutParams.height;
        if (i3 != -2 && i3 != -1) {
            layoutParams.height = (int) (i3 * f2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i4 = marginLayoutParams.bottomMargin;
            if (i4 != 0) {
                marginLayoutParams.bottomMargin = (int) (i4 * f2);
            }
            int i5 = marginLayoutParams.topMargin;
            if (i5 != 0) {
                marginLayoutParams.topMargin = (int) (i5 * f2);
            }
            int i6 = marginLayoutParams.leftMargin;
            if (i6 != 0) {
                marginLayoutParams.leftMargin = (int) (i6 * f2);
            }
            int i7 = marginLayoutParams.rightMargin;
            if (i7 != 0) {
                marginLayoutParams.rightMargin = (int) (i7 * f2);
            }
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextSize(0, textView.getTextSize() * f2);
            float lineSpacingExtra = textView.getLineSpacingExtra();
            if (0.0f != lineSpacingExtra) {
                lineSpacingExtra *= f2;
            }
            textView.setLineSpacing(lineSpacingExtra, textView.getLineSpacingMultiplier());
            textView.setPadding((int) (textView.getPaddingLeft() * f2), (int) (textView.getPaddingTop() * f2), (int) (textView.getPaddingRight() * f2), (int) (textView.getPaddingBottom() * f2));
            if (textView.getMaxWidth() > 0) {
                textView.setMaxWidth((int) (textView.getMaxWidth() * f2));
            }
        }
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                a(viewGroup.getChildAt(i8), f2);
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            float width = viewGroup.getWidth() / this.f22034a.f22040e;
            float f2 = this.f22035b;
            if (f2 == width) {
                com.opos.cmn.an.f.a.b("SizeView", "size not change");
                return;
            }
            this.f22035b = width;
            com.opos.cmn.an.f.a.b("SizeView", "scale view = " + viewGroup + ",scale = " + width);
            float f3 = width / f2;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), f3);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        a(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int b2 = this.f22034a.b(size);
        int a2 = this.f22034a.a(size2);
        a aVar = this.f22034a;
        int a3 = aVar.a(aVar.f22040e);
        float f2 = this.f22034a.f22041f;
        int i4 = (int) (a3 / f2);
        int i5 = (int) (a2 / f2);
        int i6 = (int) (b2 * f2);
        if (mode2 != 1073741824) {
            if (mode == 1073741824) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(b2, 1073741824);
            } else if (mode2 == Integer.MIN_VALUE && mode == Integer.MIN_VALUE) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a3, 1073741824);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            }
            super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
        }
        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a2, 1073741824);
        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }
}

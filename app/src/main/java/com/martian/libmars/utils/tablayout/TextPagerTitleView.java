package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class TextPagerTitleView extends ColorTransitionPagerTitleView {

    /* renamed from: h */
    public float f12481h;

    /* renamed from: i */
    public float f12482i;

    /* renamed from: j */
    public boolean f12483j;

    /* renamed from: k */
    public Drawable[] f12484k;

    /* renamed from: l */
    public int f12485l;

    /* renamed from: m */
    public int f12486m;

    /* renamed from: n */
    public int f12487n;

    /* renamed from: o */
    public int f12488o;

    /* renamed from: p */
    public int f12489p;

    /* renamed from: q */
    public int f12490q;

    /* renamed from: r */
    public float f12491r;

    /* renamed from: s */
    public float f12492s;

    public TextPagerTitleView(Context context, boolean z10) {
        super(context, z10);
        this.f12481h = 1.2f;
        this.f12482i = 0.89f;
        this.f12485l = 0;
        this.f12486m = 0;
        this.f12487n = 0;
        this.f12488o = 0;
        this.f12489p = 0;
        this.f12490q = 0;
        this.f12491r = 16.0f;
        this.f12492s = 16.0f;
    }

    private String getLongestString() {
        if (!getText().toString().contains("\n")) {
            return getText().toString();
        }
        String str = "";
        for (String str2 : getText().toString().split("\\n")) {
            if (str2.length() > str.length()) {
                str = str2;
            }
        }
        return str;
    }

    @Override // com.martian.libmars.utils.tablayout.ColorTransitionPagerTitleView, com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void b(int i10, int i11) {
        super.b(i10, i11);
        if (this.f12484k != null) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.f12487n, 0, this.f12488o, 0);
            setGravity(17);
            setTextSize(1, this.f12491r);
            return;
        }
        if (this.f12483j) {
            setScaleX((this.f12482i - 1.0f) + 1.0f);
            setScaleY((this.f12482i - 1.0f) + 1.0f);
            return;
        }
        setPivotY(getContentBottom());
        float f10 = this.f12481h;
        setScaleX(f10 + (1.0f - f10));
        float f11 = this.f12481h;
        setScaleY(f11 + (1.0f - f11));
    }

    @Override // com.martian.libmars.utils.tablayout.ColorTransitionPagerTitleView, com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void c(int i10, int i11, float f10, boolean z10) {
    }

    @Override // com.martian.libmars.utils.tablayout.ColorTransitionPagerTitleView, com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void d(int i10, int i11) {
        super.d(i10, i11);
        this.f12490q = i10;
        if (this.f12484k != null) {
            setGravity(8388627);
            Drawable[] drawableArr = this.f12484k;
            setCompoundDrawablesWithIntrinsicBounds(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
            setTextSize(1, this.f12492s);
            return;
        }
        setPivotX(getWidth() >> 1);
        if (!this.f12483j) {
            setPivotY(getContentBottom());
            setScaleX((this.f12481h - 1.0f) + 1.0f);
            setScaleY((this.f12481h - 1.0f) + 1.0f);
        } else {
            float f10 = this.f12482i;
            setScaleX(f10 + (1.0f - f10));
            float f11 = this.f12482i;
            setScaleY(f11 + (1.0f - f11));
        }
    }

    @Override // com.martian.libmars.utils.tablayout.ColorTransitionPagerTitleView, com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void e(int i10, int i11, float f10, boolean z10) {
    }

    public void f(String str, float f10, float f11, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        setText(str);
        this.f12491r = f10;
        this.f12492s = f11;
        setTextSize(1, f11);
        this.f12484k = new Drawable[]{drawable, drawable2, drawable3, drawable4};
        g();
    }

    public final void g() {
        Drawable[] drawableArr = this.f12484k;
        if (drawableArr != null) {
            Drawable drawable = drawableArr[0];
            Drawable drawable2 = drawableArr[2];
            if (drawable != null) {
                this.f12485l = drawable.getIntrinsicWidth();
            }
            if (drawable2 != null) {
                this.f12486m = drawable2.getIntrinsicWidth();
            }
        }
        int compoundDrawablePadding = getCompoundDrawablePadding();
        Rect rect = new Rect();
        String longestString = getLongestString();
        getPaint().getTextBounds(longestString, 0, longestString.length(), rect);
        this.f12487n = getPaddingLeft();
        this.f12488o = getPaddingStart();
        setEllipsize(null);
        int width = rect.width() + this.f12485l + this.f12486m + (compoundDrawablePadding * 2) + getPaddingLeft() + getPaddingRight();
        this.f12489p = width;
        setWidth(width);
    }

    public void setMaxScale(float f10) {
        this.f12481h = f10;
    }

    public void setMinScale(float f10) {
        this.f12482i = f10;
    }

    public void setMinScaleType(boolean z10) {
        this.f12483j = z10;
    }
}

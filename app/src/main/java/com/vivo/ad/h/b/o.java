package com.vivo.ad.h.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* loaded from: classes4.dex */
public class o extends LinearLayout {

    /* renamed from: a */
    private Bitmap f26831a;

    /* renamed from: b */
    private Bitmap f26832b;

    /* renamed from: c */
    private Bitmap f26833c;

    /* renamed from: d */
    private int f26834d;

    /* renamed from: e */
    private int f26835e;

    /* renamed from: f */
    private int f26836f;

    /* renamed from: g */
    private float f26837g;

    /* renamed from: h */
    private int f26838h;

    /* renamed from: i */
    private boolean f26839i;

    public o(Context context) {
        this(context, null);
    }

    private void b(Context context) {
        setOrientation(0);
        this.f26831a = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_nomal.png");
        this.f26833c = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_press.png");
        this.f26832b = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_half.png");
        this.f26834d = this.f26831a.getWidth();
        this.f26835e = this.f26831a.getHeight();
        this.f26836f = 5;
        this.f26837g = 5.0f;
        this.f26838h = com.vivo.mobilead.util.m.a(context, 3.0f);
        a(getContext());
    }

    public void a(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            this.f26834d = com.vivo.mobilead.util.m.a(getContext(), i2);
            this.f26835e = com.vivo.mobilead.util.m.a(getContext(), i3);
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = this.f26836f;
        setMeasuredDimension((this.f26834d * i4) + ((i4 - 1) * this.f26838h) + 10, this.f26835e);
    }

    public void setFirstNoMargin(boolean z) {
        this.f26839i = z;
    }

    public void setRating(float f2) {
        float f3 = this.f26836f;
        if (f2 > f3) {
            this.f26837g = f3;
        } else if (f2 < 4.0f) {
            this.f26837g = 4.0f;
        } else {
            this.f26837g = f2;
        }
        removeAllViews();
        a(getContext());
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public o(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26839i = false;
        b(context);
    }

    private void a(Context context) {
        int i2 = 0;
        while (i2 < this.f26836f) {
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f26834d, this.f26835e);
            if (!this.f26839i || i2 > 0) {
                layoutParams.leftMargin = this.f26838h;
            }
            float f2 = this.f26837g;
            int i3 = i2 + 1;
            if (f2 > i3) {
                imageView.setImageBitmap(this.f26833c);
            } else {
                float f3 = i2;
                float f4 = 0.3f + f3;
                if (f2 < f4) {
                    imageView.setImageBitmap(this.f26831a);
                } else if (f2 >= f4 && f2 <= f3 + 0.7f) {
                    imageView.setImageBitmap(this.f26832b);
                } else {
                    imageView.setImageBitmap(this.f26833c);
                }
            }
            addView(imageView, layoutParams);
            i2 = i3;
        }
    }
}

package com.vivo.mobilead.unified.base.g.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.vivo.advv.vaf.virtualview.core.IView;
import com.vivo.mobilead.util.m;

/* loaded from: classes4.dex */
public class g extends LinearLayout implements IView {

    /* renamed from: a */
    private Bitmap f29802a;

    /* renamed from: b */
    private Bitmap f29803b;

    /* renamed from: c */
    private Bitmap f29804c;

    /* renamed from: d */
    private int f29805d;

    /* renamed from: e */
    private int f29806e;

    /* renamed from: f */
    private int f29807f;

    /* renamed from: g */
    private float f29808g;

    /* renamed from: h */
    private int f29809h;

    public g(Context context) {
        super(context);
        this.f29808g = 4.0f;
        b(context);
    }

    private void a(Context context) {
        int i2 = 0;
        while (i2 < this.f29807f) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f29805d, this.f29806e);
            layoutParams.gravity = 16;
            if (i2 > 0) {
                layoutParams.leftMargin = this.f29809h;
            }
            float f2 = this.f29808g;
            int i3 = i2 + 1;
            if (f2 > i3) {
                imageView.setImageBitmap(this.f29804c);
            } else {
                float f3 = i2;
                float f4 = 0.3f + f3;
                if (f2 < f4) {
                    imageView.setImageBitmap(this.f29802a);
                } else if (f2 < f4 || f2 > f3 + 0.7f) {
                    imageView.setImageBitmap(this.f29804c);
                } else {
                    imageView.setImageBitmap(this.f29803b);
                }
            }
            addView(imageView, layoutParams);
            i2 = i3;
        }
    }

    private void b(Context context) {
        setOrientation(0);
        this.f29802a = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_nomal.png");
        this.f29804c = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_press.png");
        this.f29803b = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_half.png");
        this.f29805d = m.a(context, 10.0f);
        this.f29806e = m.a(context, 10.0f);
        this.f29807f = 5;
        this.f29808g = 5.0f;
        this.f29809h = m.a(context, 3.0f);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        measure(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        onMeasure(i2, i3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = this.f29807f;
        setMeasuredDimension((this.f29805d * i4) + ((i4 - 1) * this.f29809h), this.f29806e);
    }

    public void setRating(float f2) {
        float f3 = this.f29807f;
        if (f2 > f3) {
            this.f29808g = f3;
        } else {
            this.f29808g = f2;
        }
        removeAllViews();
        a(getContext());
    }

    public void setRatingDivider(int i2) {
        if (i2 > 0) {
            this.f29809h = i2;
        }
    }

    public void setRatingHeight(int i2) {
        if (i2 > 0) {
            this.f29806e = i2;
        }
    }

    public void setRatingWidth(int i2) {
        if (i2 > 0) {
            this.f29805d = i2;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }
}

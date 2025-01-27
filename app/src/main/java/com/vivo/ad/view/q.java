package com.vivo.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class q extends LinearLayout {

    /* renamed from: a */
    private Bitmap f27067a;

    /* renamed from: b */
    private Bitmap f27068b;

    /* renamed from: c */
    private Bitmap f27069c;

    /* renamed from: d */
    private int f27070d;

    /* renamed from: e */
    private float f27071e;

    /* renamed from: f */
    private int f27072f;

    /* renamed from: g */
    private TextView f27073g;

    /* renamed from: h */
    private ImageView[] f27074h;

    public q(Context context) {
        super(context);
        this.f27074h = new ImageView[5];
        b(context);
    }

    private void a(Context context) {
        for (int i2 = 0; i2 < this.f27070d; i2++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(this.f27067a);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 12.0f), com.vivo.mobilead.util.m.b(getContext(), 11.0f));
            layoutParams.leftMargin = this.f27072f;
            this.f27074h[i2] = imageView;
            addView(imageView, layoutParams);
        }
    }

    private void b(Context context) {
        setOrientation(0);
        setGravity(16);
        this.f27067a = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_nomal.png");
        this.f27069c = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_press.png");
        this.f27068b = com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_rating_half.png");
        this.f27070d = 5;
        this.f27071e = 5.0f;
        this.f27072f = com.vivo.mobilead.util.m.a(context, 3.0f);
        a(getContext());
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(Color.parseColor("#4d000000"));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 1.0f), com.vivo.mobilead.util.m.a(context, 6.0f));
        layoutParams.setMargins(com.vivo.mobilead.util.m.a(context, 6.0f), 0, com.vivo.mobilead.util.m.a(context, 6.0f), 0);
        addView(imageView, layoutParams);
        TextView textView = new TextView(context);
        this.f27073g = textView;
        textView.setTextColor(Color.parseColor("#4b4b4b"));
        this.f27073g.setTextSize(1, 11.0f);
        this.f27073g.setSingleLine();
        addView(this.f27073g, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView2 = new ImageView(context);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageDrawable(com.vivo.mobilead.util.g.b(context, "vivo_module_biz_ui_download.png"));
        int a2 = com.vivo.mobilead.util.m.a(context, 2.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 9.0f), com.vivo.mobilead.util.m.a(context, 9.0f));
        layoutParams2.setMargins(a2, a2, a2, a2);
        addView(imageView2, layoutParams2);
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

    public void setDownloadStr(String str) {
        this.f27073g.setText(str);
    }

    public void setRating(float f2) {
        float f3 = this.f27070d;
        if (f2 > f3) {
            this.f27071e = f3;
        } else {
            this.f27071e = f2;
        }
        int floor = (int) Math.floor(this.f27071e);
        for (int i2 = 0; i2 < floor; i2++) {
            this.f27074h[i2].setImageBitmap(this.f27069c);
        }
        if (floor < this.f27070d) {
            float f4 = this.f27071e - floor;
            if (f4 < 0.3f) {
                this.f27074h[floor].setImageBitmap(this.f27067a);
            } else if (f4 < 0.3f || f4 >= 0.7f) {
                this.f27074h[floor].setImageBitmap(this.f27069c);
            } else {
                this.f27074h[floor].setImageBitmap(this.f27068b);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }
}

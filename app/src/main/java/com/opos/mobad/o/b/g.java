package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class g extends com.opos.cmn.e.a.b.b.b {

    /* renamed from: e */
    private RelativeLayout f23021e;

    /* renamed from: f */
    private TextView f23022f;

    public g(Context context) {
        super(context);
    }

    private void f() {
        this.f23021e = new RelativeLayout(this.f16938a);
        g();
        h();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f16940c.addView(this.f23021e, layoutParams);
    }

    private void g() {
        ImageView imageView = new ImageView(this.f16938a);
        this.f16941d = imageView;
        imageView.setId(1);
        this.f16941d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f16941d.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f16938a, "opos_module_biz_ui_native_video_loading_img.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16938a, 24.0f), com.opos.cmn.an.h.f.a.a(this.f16938a, 24.0f));
        layoutParams.addRule(14);
        this.f23021e.addView(this.f16941d, layoutParams);
    }

    private void h() {
        TextView textView = new TextView(this.f16938a);
        this.f23022f = textView;
        textView.setText("加载中...");
        this.f23022f.setTextColor(-1);
        this.f23022f.setTextSize(1, 14.0f);
        this.f23022f.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f16938a, 12.0f);
        layoutParams.addRule(3, 1);
        this.f23021e.addView(this.f23022f, layoutParams);
    }

    @Override // com.opos.cmn.e.a.b.b.b
    protected void a() {
        ImageView imageView = new ImageView(this.f16938a);
        imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#000000")));
        imageView.setAlpha(0.4f);
        this.f16940c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.cmn.e.a.b.b.b
    protected void b() {
        f();
    }
}

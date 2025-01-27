package com.opos.cmn.e.a.b.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    protected Context f16932a;

    /* renamed from: b */
    protected com.opos.cmn.e.a.b.c.a f16933b;

    /* renamed from: c */
    protected RelativeLayout f16934c;

    /* renamed from: d */
    protected RelativeLayout f16935d;

    /* renamed from: e */
    protected TextView f16936e;

    /* renamed from: f */
    protected ImageView f16937f;

    public a(Context context) {
        this(context, 0.6f);
    }

    public a(Context context, float f2) {
        this.f16932a = context;
        a(f2);
        a();
    }

    private void a(float f2) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f16932a);
        this.f16934c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        b(f2);
        this.f16935d = new RelativeLayout(this.f16932a);
        c();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f16935d.setForceDarkAllowed(false);
        }
        TextView textView = new TextView(this.f16932a);
        this.f16936e = textView;
        textView.setId(1);
        this.f16936e.setGravity(17);
        this.f16936e.setMaxLines(3);
        this.f16936e.setEllipsize(TextUtils.TruncateAt.END);
        this.f16936e.setTextColor(Color.parseColor("#2f2f2f"));
        this.f16936e.setTextSize(1, 16.0f);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f16932a, 12.0f);
        this.f16936e.setPadding(a2, 0, a2, 0);
        d();
        ImageView imageView = new ImageView(this.f16932a);
        this.f16937f = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f16937f.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        e();
        f();
    }

    private void b(float f2) {
        ImageView imageView = new ImageView(this.f16932a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(f2);
        this.f16934c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void c() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f16932a, 14.0f);
        cVar.setImageDrawable(new ColorDrawable(-1));
        this.f16935d.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16932a, 260.0f), com.opos.cmn.an.h.f.a.a(this.f16932a, 91.0f));
        layoutParams.addRule(10);
        this.f16935d.addView(this.f16936e, layoutParams);
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16932a, 260.0f), com.opos.cmn.an.h.f.a.a(this.f16932a, 1.0f));
        layoutParams.addRule(3, 1);
        this.f16935d.addView(this.f16937f, layoutParams);
    }

    private void f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16932a, 260.0f), com.opos.cmn.an.h.f.a.a(this.f16932a, 130.0f));
        layoutParams.addRule(13);
        this.f16934c.addView(this.f16935d, layoutParams);
    }

    protected abstract void a();

    public void a(com.opos.cmn.e.a.b.c.a aVar) {
        this.f16933b = aVar;
    }

    public void a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f16936e.setText(charSequence);
    }

    public View b() {
        return this.f16934c;
    }
}

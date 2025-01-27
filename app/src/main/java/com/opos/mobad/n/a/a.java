package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class a extends LinearLayout {

    /* renamed from: a */
    private com.opos.mobad.n.c.f f21756a;

    /* renamed from: b */
    private TextView f21757b;

    /* renamed from: c */
    private TextView f21758c;

    public a(Context context) {
        super(context);
        a();
    }

    private void a() {
        setGravity(1);
        setOrientation(1);
        this.f21756a = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 70.0f), com.opos.cmn.an.h.f.a.a(getContext(), 70.0f));
        this.f21756a.setScaleType(ImageView.ScaleType.FIT_START);
        this.f21756a.setLayoutParams(layoutParams);
        TextView textView = new TextView(getContext());
        this.f21758c = textView;
        textView.setTextSize(1, 24.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.c(getContext(), 6.0f);
        this.f21758c.setTextColor(Color.parseColor("#000000"));
        this.f21758c.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.f21757b = textView2;
        textView2.setTextSize(1, 14.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
        this.f21757b.setTextColor(Color.parseColor("#80000000"));
        this.f21757b.setLayoutParams(layoutParams3);
        addView(this.f21756a);
        addView(this.f21758c);
        addView(this.f21757b);
        setVisibility(4);
    }

    private void a(int i2) {
        Context context;
        float f2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        if (i2 == 0) {
            context = getContext();
            f2 = 200.0f;
        } else {
            context = getContext();
            f2 = 50.0f;
        }
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, f2);
        setLayoutParams(layoutParams);
    }

    public void a(int i2, Bitmap bitmap, String str, String str2) {
        this.f21756a.setImageBitmap(bitmap);
        if (!TextUtils.isEmpty(str)) {
            this.f21758c.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f21757b.setText(str2);
        }
        a(i2);
        setVisibility(0);
    }
}

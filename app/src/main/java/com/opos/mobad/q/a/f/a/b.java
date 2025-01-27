package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.h;

/* loaded from: classes4.dex */
public class b extends a {
    public b(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        super(context, i2, interfaceC0458a);
    }

    private void a(LinearLayout linearLayout) {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f23251a, 33.0f);
        this.f23255e = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f23255e.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 50.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 50.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 13.0f);
        linearLayout.addView(this.f23255e, layoutParams);
    }

    private void b(LinearLayout linearLayout) {
        TextView textView = new TextView(this.f23251a);
        this.f23256f = textView;
        textView.setGravity(17);
        this.f23256f.setTextColor(Color.parseColor("#000000"));
        this.f23256f.setTextSize(1, 15.0f);
        this.f23256f.setTypeface(Typeface.defaultFromStyle(1));
        this.f23256f.setMaxEms(9);
        this.f23256f.setEllipsize(TextUtils.TruncateAt.END);
        this.f23256f.setSingleLine();
        this.f23256f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 5.0f);
        linearLayout.addView(this.f23256f, layoutParams);
    }

    private void c(LinearLayout linearLayout) {
        TextView textView = new TextView(this.f23251a);
        this.f23257g = textView;
        textView.setGravity(17);
        this.f23257g.setTextColor(Color.parseColor("#000000"));
        this.f23257g.setTextSize(1, 13.0f);
        this.f23257g.setMaxEms(13);
        this.f23257g.setEllipsize(TextUtils.TruncateAt.END);
        this.f23257g.setSingleLine();
        this.f23257g.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 52.0f);
        linearLayout.addView(this.f23257g, layoutParams);
    }

    private void d(LinearLayout linearLayout) {
        TextView textView = new TextView(this.f23251a);
        this.f23253c = textView;
        textView.setGravity(17);
        this.f23253c.setTextColor(Color.parseColor("#ffffff"));
        this.f23253c.setTextSize(1, 15.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#EB4B4F"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f23251a, 7.0f));
        g.a(this.f23253c, gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 120.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 30.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 3.0f);
        linearLayout.addView(this.f23253c, layoutParams);
        this.m = new f(this.f23253c, 1.0f, 1.2f, 1500L);
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.d.g gVar;
        com.opos.mobad.n.d.f e2 = hVar.e();
        if (e2 == null) {
            return;
        }
        h();
        j();
        if (this.r == null && (gVar = e2.f22080a) != null && !TextUtils.isEmpty(gVar.f22084a)) {
            Bitmap a2 = g.a(e2.f22080a.f22084a, com.opos.cmn.an.h.f.a.a(this.f23251a, 50.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 50.0f));
            this.f23260j = a2;
            if (a2 != null) {
                this.f23255e.setImageBitmap(a2);
                this.f23255e.setVisibility(0);
            }
        }
        if (this.f23256f != null && !TextUtils.isEmpty(e2.f22081b)) {
            a(this.f23256f, e2.f22081b);
            this.f23256f.setVisibility(0);
        }
        if (this.f23257g != null && !TextUtils.isEmpty(e2.f22082c)) {
            a(this.f23257g, e2.f22082c);
            this.f23257g.setVisibility(0);
        }
        a(e2.f22083d);
        a(this.f23253c, com.opos.mobad.cmn.a.b.a.FloatLayerClickBt);
        a(this.f23259i, com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt);
        this.r = e2;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            Bitmap bitmap = this.f23260j;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f23260j.recycle();
                this.f23260j = null;
                com.opos.cmn.an.f.a.b("GraphicMixFloatLayer", "mImgBitmap.recycle()");
            }
            a(this.f23256f, "");
            a(this.f23257g, "");
            a(this.f23253c);
            a(this.f23254d);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("GraphicMixFloatLayer", "");
        }
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public void g() {
        g.a(this.f23258h, new ColorDrawable(Color.parseColor("#cfffffff")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.b(this.f23251a), com.opos.cmn.an.h.f.a.c(this.f23251a) / 3);
        layoutParams.addRule(13);
        LinearLayout linearLayout = new LinearLayout(this.f23251a);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 144.0f), -2);
        layoutParams2.addRule(13);
        a(linearLayout);
        b(linearLayout);
        c(linearLayout);
        d(linearLayout);
        this.f23258h.addView(linearLayout, layoutParams2);
        this.f23259i.addView(this.f23258h, layoutParams);
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 30.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 30.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        boolean d2 = com.opos.cmn.an.h.f.a.d(this.f23251a);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, d2 ? 54 : 11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, d2 ? 24 : 11);
        return layoutParams;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: k */
    public RelativeLayout c() {
        return this.f23259i;
    }
}

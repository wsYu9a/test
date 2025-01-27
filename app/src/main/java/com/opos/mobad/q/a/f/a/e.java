package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.g;
import com.opos.mobad.n.d.h;
import java.util.List;

/* loaded from: classes4.dex */
public class e extends a {
    private LinearLayout t;

    public e(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        super(context, i2, interfaceC0458a);
    }

    private void a(LinearLayout linearLayout) {
        if (this.r != null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 98.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 98.0f));
        layoutParams.gravity = 1;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, -49.0f);
        linearLayout.addView(this.f23255e, layoutParams);
    }

    private void a(LinearLayout linearLayout, com.opos.mobad.n.d.f fVar, boolean z) {
        if (this.r == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, z ? 45 : 63);
            linearLayout.addView(this.f23256f, layoutParams);
        }
        a(this.f23256f, fVar.f22081b);
        this.f23256f.setVisibility(0);
    }

    private void a(RelativeLayout relativeLayout) {
        LinearLayout linearLayout = new LinearLayout(this.f23251a);
        this.t = linearLayout;
        linearLayout.setClipChildren(false);
        this.t.setOrientation(1);
        relativeLayout.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void a(com.opos.mobad.n.d.f fVar) {
        List<g> list;
        if (this.r == null && (list = fVar.f22076h) != null && list.size() > 0 && fVar.f22076h.get(0) != null) {
            g gVar = fVar.f22076h.get(0);
            if (TextUtils.isEmpty(gVar.f22084a)) {
                return;
            }
            Context context = this.f23251a;
            Drawable a2 = com.opos.mobad.cmn.a.b.g.a(context, gVar.f22084a, com.opos.cmn.an.h.f.a.b(context), com.opos.cmn.an.h.f.a.c(this.f23251a));
            if (a2 != null) {
                com.opos.mobad.cmn.a.b.g.a(this.f23259i, a2);
            }
        }
    }

    private void b(LinearLayout linearLayout, com.opos.mobad.n.d.f fVar, boolean z) {
        if (this.r == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, z ? 39 : 49);
            linearLayout.addView(this.f23257g, layoutParams);
        }
        a(this.f23257g, fVar.f22082c);
        this.f23257g.setVisibility(0);
    }

    private void b(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f23251a);
        this.f23253c = textView;
        textView.setGravity(17);
        this.f23253c.setTextColor(Color.parseColor("#ffffff"));
        this.f23253c.setTextSize(1, 16.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#EB4B4F"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f23251a, 7.0f));
        com.opos.mobad.cmn.a.b.g.a(this.f23253c, gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 282.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 41.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 32.0f);
        relativeLayout.addView(this.f23253c, layoutParams);
        this.m = new f(this.f23253c, 1.0f, 1.05f, 1500L);
    }

    private boolean b(com.opos.mobad.n.d.f fVar) {
        g gVar;
        if (this.r != null || fVar == null || (gVar = fVar.f22080a) == null || TextUtils.isEmpty(gVar.f22084a)) {
            return false;
        }
        Bitmap a2 = com.opos.mobad.cmn.a.b.g.a(fVar.f22080a.f22084a, com.opos.cmn.an.h.f.a.a(this.f23251a, 98.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 98.0f));
        this.f23260j = a2;
        com.opos.cmn.e.a.a.c cVar = this.f23255e;
        if (cVar == null || a2 == null) {
            return false;
        }
        cVar.setImageBitmap(a2);
        this.f23255e.setVisibility(0);
        return true;
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.d.f e2 = hVar.e();
        if (e2 == null) {
            return;
        }
        h();
        j();
        a(e2);
        boolean b2 = b(e2);
        if (b2) {
            a(this.t);
        }
        a(this.t, e2, b2);
        b(this.t, e2, b2);
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
                com.opos.cmn.an.f.a.b("PortModelAFloatLayer", "mImgBitmap.recycle()");
            }
            a(this.f23256f, "");
            a(this.f23257g, "");
            a(this.f23253c);
            a(this.f23254d);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("PortModelAFloatLayer", "");
        }
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public void g() {
        this.f23259i.setClipChildren(false);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#e3ffffff"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f23251a, 22.0f));
        com.opos.mobad.cmn.a.b.g.a(this.f23258h, gradientDrawable);
        this.f23258h.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 332.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 314.0f));
        layoutParams.addRule(13);
        a(this.f23258h);
        b(this.f23258h);
        this.f23259i.addView(this.f23258h, layoutParams);
        TextView textView = new TextView(this.f23251a);
        this.f23256f = textView;
        textView.setGravity(17);
        this.f23256f.setTextColor(Color.parseColor("#000000"));
        this.f23256f.setTextSize(1, 24.0f);
        this.f23256f.setTypeface(Typeface.defaultFromStyle(1));
        this.f23256f.setMaxEms(9);
        this.f23256f.setEllipsize(TextUtils.TruncateAt.END);
        this.f23256f.setSingleLine();
        this.f23256f.setVisibility(8);
        TextView textView2 = new TextView(this.f23251a);
        this.f23257g = textView2;
        textView2.setGravity(17);
        this.f23257g.setTextColor(Color.parseColor("#98151515"));
        this.f23257g.setTextSize(1, 16.0f);
        this.f23257g.setMaxEms(13);
        this.f23257g.setEllipsize(TextUtils.TruncateAt.END);
        this.f23257g.setVisibility(8);
        this.f23257g.setMaxLines(2);
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f23251a, 28.0f);
        this.f23255e = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 30.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 30.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 54.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 24.0f);
        return layoutParams;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: k */
    public RelativeLayout c() {
        return this.f23259i;
    }
}

package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.g;
import com.opos.mobad.n.d.h;
import java.util.List;

/* loaded from: classes4.dex */
public class d extends a {
    public d(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        super(context, i2, interfaceC0458a);
    }

    private void a(RelativeLayout relativeLayout) {
        if (this.r != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 94.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 94.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.o);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 24.0f);
        relativeLayout.addView(this.f23255e, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, com.opos.mobad.n.d.f fVar, boolean z) {
        if (this.r == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.p);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, z ? 20 : 40);
            relativeLayout.addView(this.f23256f, layoutParams);
        }
        a(this.f23256f, fVar.f22081b);
        this.f23256f.setVisibility(0);
    }

    private void a(com.opos.mobad.n.d.f fVar) {
        List<g> list;
        if (this.r == null && (list = fVar.f22076h) != null && list.size() > 0 && fVar.f22076h.get(0) != null) {
            g gVar = fVar.f22076h.get(0);
            if (TextUtils.isEmpty(gVar.f22084a)) {
                return;
            }
            BitmapDrawable a2 = com.opos.mobad.cmn.a.b.g.a(this.f23251a, com.opos.mobad.cmn.a.b.g.a(3, com.opos.mobad.cmn.a.b.g.a(gVar.f22084a, com.opos.cmn.an.h.f.a.b(this.f23251a) / 3, com.opos.cmn.an.h.f.a.c(this.f23251a))));
            if (a2 != null) {
                com.opos.mobad.cmn.a.b.g.a(this.f23259i, a2);
            }
        }
    }

    private void b(RelativeLayout relativeLayout) {
        if (this.r != null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#EB4B4F"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f23251a, 7.0f));
        com.opos.mobad.cmn.a.b.g.a(this.f23253c, gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 184.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 45.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 40.0f);
        relativeLayout.addView(this.f23253c, layoutParams);
    }

    private void b(RelativeLayout relativeLayout, com.opos.mobad.n.d.f fVar, boolean z) {
        if (this.r == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.q);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, z ? 40 : 53);
            relativeLayout.addView(this.f23257g, layoutParams);
        }
        a(this.f23257g, fVar.f22082c);
        this.f23257g.setVisibility(0);
    }

    private boolean b(com.opos.mobad.n.d.f fVar) {
        g gVar;
        if (this.r != null || fVar == null || (gVar = fVar.f22080a) == null || TextUtils.isEmpty(gVar.f22084a)) {
            return false;
        }
        Bitmap a2 = com.opos.mobad.cmn.a.b.g.a(fVar.f22080a.f22084a, com.opos.cmn.an.h.f.a.a(this.f23251a, 94.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 94.0f));
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
            a(this.f23258h);
        }
        a(this.f23258h, e2, b2);
        b(this.f23258h, e2, b2);
        b(this.f23258h);
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
                com.opos.cmn.an.f.a.b("LandModelAFloatLayer", "mImgBitmap.recycle()");
            }
            a(this.f23256f, "");
            a(this.f23257g, "");
            a(this.f23253c);
            a(this.f23254d);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("LandModelAFloatLayer", "");
        }
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public void g() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f23251a, 28.0f);
        this.f23255e = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f23255e.setVisibility(8);
        this.f23255e.setId(this.n);
        TextView textView = new TextView(this.f23251a);
        this.f23256f = textView;
        textView.setGravity(17);
        this.f23256f.setTextColor(Color.parseColor("#000000"));
        this.f23256f.setTextSize(1, 20.0f);
        this.f23256f.setTypeface(Typeface.defaultFromStyle(1));
        this.f23256f.setMaxEms(9);
        this.f23256f.setEllipsize(TextUtils.TruncateAt.END);
        this.f23256f.setMaxLines(2);
        this.f23256f.setVisibility(8);
        this.f23256f.setId(this.o);
        TextView textView2 = new TextView(this.f23251a);
        this.f23257g = textView2;
        textView2.setGravity(17);
        this.f23257g.setTextColor(Color.parseColor("#98151515"));
        this.f23257g.setTextSize(1, 14.0f);
        this.f23257g.setMaxEms(13);
        this.f23257g.setEllipsize(TextUtils.TruncateAt.END);
        this.f23257g.setVisibility(8);
        this.f23257g.setMaxLines(2);
        this.f23257g.setId(this.p);
        TextView textView3 = new TextView(this.f23251a);
        this.f23253c = textView3;
        textView3.setGravity(17);
        this.f23253c.setTextColor(Color.parseColor("#ffffff"));
        this.f23253c.setTextSize(1, 16.0f);
        this.f23253c.setId(this.q);
        this.m = new f(this.f23253c, 1.0f, 1.05f, 1500L);
        com.opos.mobad.cmn.a.b.g.a(this.f23258h, new ColorDrawable(Color.parseColor("#e3ffffff")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 260.0f), com.opos.cmn.an.h.f.a.b(this.f23251a));
        layoutParams.addRule(11);
        this.f23259i.addView(this.f23258h, layoutParams);
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23251a, 30.0f), com.opos.cmn.an.h.f.a.a(this.f23251a, 30.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 11.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23251a, 11.0f);
        return layoutParams;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: k */
    public RelativeLayout c() {
        return this.f23259i;
    }
}

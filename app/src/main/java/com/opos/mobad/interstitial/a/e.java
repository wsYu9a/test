package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;
import java.util.List;

/* loaded from: classes4.dex */
public class e extends b {
    private com.opos.cmn.e.a.a.c m;
    private com.opos.cmn.e.a.a.c n;
    private com.opos.cmn.e.a.a.c o;
    private Bitmap p;
    private Bitmap q;
    private Bitmap r;

    public e(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        super(context, i2, interfaceC0458a);
        this.p = null;
        this.q = null;
        this.r = null;
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(3, 3);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 19.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        a(dVar, this.f21021d, layoutParams);
    }

    private void h() {
        TextView textView = new TextView(this.k);
        this.f21026i = textView;
        textView.setGravity(17);
        this.f21026i.setTextColor(Color.parseColor("#2f2f2f"));
        this.f21026i.setTextSize(1, 19.0f);
        this.f21026i.setMaxEms(12);
        this.f21026i.setEllipsize(TextUtils.TruncateAt.END);
        this.f21026i.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 15.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.f21021d.addView(this.f21026i, layoutParams);
    }

    private void i() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.k, 14.0f);
        this.m = cVar;
        cVar.setId(2);
        this.m.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 86.0f), com.opos.cmn.an.h.f.a.a(this.k, 56.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 44.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.f21021d.addView(this.m, layoutParams);
    }

    private void j() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.k, 14.0f);
        this.n = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 86.0f), com.opos.cmn.an.h.f.a.a(this.k, 56.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 44.0f);
        this.f21021d.addView(this.n, layoutParams);
    }

    private void k() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.k, 14.0f);
        this.o = cVar;
        cVar.setId(4);
        this.o.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 86.0f), com.opos.cmn.an.h.f.a.a(this.k, 56.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 44.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.f21021d.addView(this.o, layoutParams);
    }

    private void l() {
        ImageView imageView = new ImageView(this.k);
        imageView.setId(3);
        imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 266.0f), com.opos.cmn.an.h.f.a.a(this.k, 1.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 114.0f);
        layoutParams.addRule(14);
        this.f21021d.addView(imageView, layoutParams);
    }

    private void m() {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.k, "opos_module_biz_ui_cmn_click_bn_normal_red_bg_img.png", "opos_module_biz_ui_cmn_click_bn_pressed_red_bg_img.png");
        this.f21027j = aVar;
        aVar.setGravity(17);
        this.f21027j.setTextColor(-1);
        this.f21027j.setTextSize(1, 12.0f);
        this.f21027j.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 107.0f), com.opos.cmn.an.h.f.a.a(this.k, 28.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(3, 3);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 13.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.f21021d.addView(this.f21027j, layoutParams);
    }

    private void n() {
        TextView textView = new TextView(this.k);
        this.f21025h = textView;
        textView.setGravity(17);
        this.f21025h.setTextColor(Color.parseColor("#999999"));
        this.f21025h.setTextSize(1, 11.0f);
        this.f21025h.setMaxEms(7);
        this.f21025h.setEllipsize(TextUtils.TruncateAt.END);
        this.f21025h.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 5);
        layoutParams.addRule(3, 3);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 18.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 10.0f);
        this.f21021d.addView(this.f21025h, layoutParams);
    }

    private void o() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 294.0f), com.opos.cmn.an.h.f.a.a(this.k, 173.0f));
        layoutParams.addRule(13);
        a(layoutParams);
    }

    private void p() {
        b(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 318.0f), com.opos.cmn.an.h.f.a.a(this.k, 197.0f)));
    }

    @Override // com.opos.mobad.interstitial.a.b, com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        super.a(hVar);
        com.opos.mobad.n.d.d a2 = hVar != null ? hVar.a() : null;
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("GM320X210GroupInterstitial", "render with data null");
            return;
        }
        b(a2);
        p();
        a(this.f21026i, a2.f22073e);
        a(a2);
        a(this.f21027j);
        b(this.f21021d);
        a(this.f21025h, a2.f22074f);
        a(a2.o);
        List<com.opos.mobad.n.d.g> list = a2.f22075g;
        if (list == null || list.size() < 3) {
            return;
        }
        String str = list.get(0).f22084a;
        String str2 = list.get(1).f22084a;
        String str3 = list.get(2).f22084a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Bitmap a3 = com.opos.mobad.cmn.a.b.g.a(str, com.opos.cmn.an.h.f.a.a(this.k, 86.0f), com.opos.cmn.an.h.f.a.a(this.k, 56.0f));
        this.p = a3;
        if (a3 != null) {
            this.m.setImageBitmap(a3);
        }
        Bitmap a4 = com.opos.mobad.cmn.a.b.g.a(str2, com.opos.cmn.an.h.f.a.a(this.k, 86.0f), com.opos.cmn.an.h.f.a.a(this.k, 56.0f));
        this.q = a4;
        if (a4 != null) {
            this.n.setImageBitmap(a4);
        }
        Bitmap a5 = com.opos.mobad.cmn.a.b.g.a(str3, com.opos.cmn.an.h.f.a.a(this.k, 86.0f), com.opos.cmn.an.h.f.a.a(this.k, 56.0f));
        this.r = a5;
        if (a5 != null) {
            this.o.setImageBitmap(a5);
        }
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            Bitmap bitmap = this.p;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.p.recycle();
                this.p = null;
                com.opos.cmn.an.f.a.b("GM320X210GroupInterstitial", "mAdBitmap_1.recycle()");
            }
            Bitmap bitmap2 = this.q;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.q.recycle();
                this.q = null;
                com.opos.cmn.an.f.a.b("GM320X210GroupInterstitial", "mAdBitmap_2.recycle()");
            }
            Bitmap bitmap3 = this.r;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.r.recycle();
                this.r = null;
                com.opos.cmn.an.f.a.b("GM320X210GroupInterstitial", "mAdBitmap_3.recycle()");
            }
            a(this.f21025h, "");
            a(this.f21026i, "");
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("GM320X210GroupInterstitial", "");
        }
    }

    @Override // com.opos.mobad.interstitial.a.b
    public void f() {
        h();
        i();
        j();
        k();
        l();
        m();
        n();
        o();
    }
}

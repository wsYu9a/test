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
public class f extends b {
    private com.opos.cmn.e.a.a.c m;
    private Bitmap n;

    public f(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        super(context, i2, interfaceC0458a);
        this.n = null;
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(3, 3);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 18.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        a(dVar, this.f21021d, layoutParams);
    }

    private void h() {
        TextView textView = new TextView(this.k);
        this.f21026i = textView;
        textView.setTextColor(Color.parseColor("#2f2f2f"));
        this.f21026i.setTextSize(1, 20.0f);
        this.f21026i.setMaxEms(7);
        this.f21026i.setEllipsize(TextUtils.TruncateAt.END);
        this.f21026i.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.addRule(0, 2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 28.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.f21021d.addView(this.f21026i, layoutParams);
    }

    private void i() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.k, 14.0f);
        this.m = cVar;
        cVar.setId(2);
        this.m.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 107.0f), com.opos.cmn.an.h.f.a.a(this.k, 70.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 17.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.f21021d.addView(this.m, layoutParams);
    }

    private void j() {
        ImageView imageView = new ImageView(this.k);
        imageView.setId(3);
        imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 266.0f), com.opos.cmn.an.h.f.a.a(this.k, 1.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 100.0f);
        layoutParams.addRule(14);
        this.f21021d.addView(imageView, layoutParams);
    }

    private void k() {
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

    private void l() {
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

    private void m() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 294.0f), com.opos.cmn.an.h.f.a.a(this.k, 156.0f));
        layoutParams.addRule(13);
        a(layoutParams);
    }

    private void n() {
        b(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 318.0f), com.opos.cmn.an.h.f.a.a(this.k, 180.0f)));
    }

    @Override // com.opos.mobad.interstitial.a.b, com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        super.a(hVar);
        com.opos.mobad.n.d.d a2 = hVar != null ? hVar.a() : null;
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("GM320X210Interstitial", "render with data null");
            return;
        }
        b(a2);
        n();
        a(this.f21026i, a2.f22073e);
        a(a2);
        a(this.f21027j);
        b(this.f21021d);
        a(this.f21025h, a2.f22074f);
        a(a2.o);
        List<com.opos.mobad.n.d.g> list = a2.f22075g;
        if (list == null || list.size() <= 0 || list.get(0) == null || TextUtils.isEmpty(list.get(0).f22084a)) {
            return;
        }
        Bitmap a3 = com.opos.mobad.cmn.a.b.g.a(list.get(0).f22084a, com.opos.cmn.an.h.f.a.a(this.k, 107.0f), com.opos.cmn.an.h.f.a.a(this.k, 70.0f));
        this.n = a3;
        if (a3 != null) {
            this.m.setImageBitmap(a3);
        }
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            Bitmap bitmap = this.n;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.n.recycle();
                this.n = null;
                com.opos.cmn.an.f.a.b("GM320X210Interstitial", "mAdBitmap.recycle()");
            }
            a(this.f21025h, "");
            a(this.f21026i, "");
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("GM320X210Interstitial", "");
        }
    }

    @Override // com.opos.mobad.interstitial.a.b
    public void f() {
        i();
        h();
        j();
        k();
        l();
        m();
    }
}

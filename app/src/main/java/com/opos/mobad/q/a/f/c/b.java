package com.opos.mobad.q.a.f.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: j */
    private com.opos.cmn.e.a.a.c f23330j;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private com.opos.cmn.e.a.a.a n;
    private Bitmap o;

    public b(Context context, com.opos.mobad.q.a.c.a aVar) {
        super(context, aVar);
        this.o = null;
    }

    private void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f20278a, 58.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 58.0f));
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f20278a, com.opos.cmn.an.h.f.a.d(this.f20278a) ? 17 : 35);
        this.f23330j.setLayoutParams(layoutParams);
    }

    private void e() {
        this.k = new RelativeLayout(this.f20278a);
        k();
        l();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 1);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f20278a, 8.0f);
        this.f23324i.addView(this.k, layoutParams);
    }

    private void k() {
        TextView textView = new TextView(this.f20278a);
        this.l = textView;
        textView.setId(2);
        this.l.setGravity(17);
        this.l.setTextColor(Color.parseColor("#2f2f2f"));
        this.l.setTextSize(1, 18.0f);
        this.l.setTypeface(Typeface.defaultFromStyle(0));
        this.l.setMaxEms(8);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setSingleLine();
        this.k.addView(this.l, new RelativeLayout.LayoutParams(-2, -2));
    }

    private void l() {
        TextView textView = new TextView(this.f20278a);
        this.m = textView;
        textView.setGravity(17);
        this.m.setTextColor(Color.parseColor("#80000000"));
        this.m.setTextSize(1, 12.0f);
        this.m.setMaxEms(12);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2);
        layoutParams.addRule(5, 2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f20278a, 4.0f);
        this.k.addView(this.m, layoutParams);
    }

    private void m() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f20278a, 13.0f);
        this.f23330j = cVar;
        cVar.setId(1);
        this.f23330j.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f20278a, 58.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 58.0f));
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f20278a, 17.0f);
        this.f23324i.addView(this.f23330j, layoutParams);
    }

    private void n() {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f20278a, "opos_module_biz_ui_cmn_click_bn_normal_red_bg_img.png", "opos_module_biz_ui_cmn_click_bn_pressed_red_bg_img.png");
        this.n = aVar;
        aVar.setGravity(17);
        this.n.setTextColor(Color.parseColor("#ffffff"));
        this.n.setTextSize(1, 14.0f);
        this.n.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f20278a, 80.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 30.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f20278a, 17.0f);
        this.f23324i.addView(this.n, layoutParams);
    }

    private void o() {
        this.n.setVisibility(0);
    }

    public void a(AdItemData adItemData, boolean z) {
        MaterialData materialData;
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        c();
        a(this.n, c(adItemData));
        a(this.f23324i, adItemData, com.opos.mobad.cmn.a.b.a.NonClickBt);
        a(this.n, adItemData, com.opos.mobad.cmn.a.b.a.ClickBt);
        o();
        List<MaterialFileData> j2 = materialData.j();
        if (j2 != null && j2.size() > 0 && j2.get(0) != null) {
            Bitmap a2 = g.a(j2.get(0).a(), com.opos.cmn.an.h.f.a.a(this.f20278a, 58.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 58.0f));
            this.o = a2;
            if (a2 != null) {
                this.f23330j.setImageBitmap(a2);
            }
        }
        a(this.l, materialData.h());
        a(this.m, materialData.i());
    }

    public com.opos.cmn.e.a.a.a b() {
        return this.n;
    }

    public void d(AdItemData adItemData) {
        a(adItemData, false);
    }

    @Override // com.opos.mobad.cmn.a.c
    public void g() {
        g.a(this.f23324i, new ColorDrawable(Color.parseColor("#E6FCFCFC")));
        m();
        e();
        n();
    }

    @Override // com.opos.mobad.cmn.a.c
    public void h() {
        try {
            TextView textView = this.f20279b;
            if (textView != null) {
                this.f23324i.removeView(textView);
            }
            Bitmap bitmap = this.o;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.o.recycle();
                this.o = null;
                com.opos.cmn.an.f.a.b("GraphicMixTipBar", "mIconBitmap.recycle()");
            }
            a(this.l, "");
            a(this.m, "");
            a(this.f23324i);
            a(this.n);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("GraphicMixTipBar", "");
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void i() {
    }
}

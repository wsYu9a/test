package com.opos.mobad.cmn.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: classes4.dex */
public abstract class c {

    /* renamed from: a */
    protected Context f20278a;

    /* renamed from: b */
    protected TextView f20279b;

    /* renamed from: c */
    protected Drawable f20280c;

    /* renamed from: d */
    protected int[] f20281d = new int[4];

    /* renamed from: e */
    protected boolean f20282e = false;

    /* renamed from: f */
    protected AdItemData f20283f;

    /* renamed from: g */
    protected GradientDrawable f20284g;

    public c(Context context) {
        this.f20278a = com.opos.mobad.service.b.a(context);
        k();
    }

    private void k() {
        TextView textView = new TextView(this.f20278a);
        this.f20279b = textView;
        textView.setPadding(com.opos.cmn.an.h.f.a.a(this.f20278a, 4.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 2.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 4.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 2.0f));
        this.f20279b.setTextColor(Color.parseColor("#FFFFFF"));
        this.f20279b.setTextSize(1, 8.0f);
        this.f20279b.setGravity(17);
        this.f20279b.setMaxEms(6);
        this.f20279b.setEllipsize(TextUtils.TruncateAt.END);
        this.f20279b.setSingleLine();
        this.f20279b.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f20284g = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#3D151515"));
        this.f20284g.setCornerRadius(5.0f);
    }

    protected void a(View view) {
        if (view != null) {
            try {
                view.setOnTouchListener(null);
                view.setOnClickListener(null);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("BaseCreative", "", (Throwable) e2);
            }
        }
    }

    protected void a(AdItemData adItemData) {
        TextView textView;
        int i2;
        if (adItemData == null || !adItemData.j()) {
            textView = this.f20279b;
            i2 = 8;
        } else {
            Drawable b2 = b(adItemData);
            this.f20280c = b2;
            if (b2 != null) {
                g.a(this.f20279b, b2);
            } else {
                g.a(this.f20279b, this.f20284g);
                if (!com.opos.cmn.an.c.a.a(adItemData.B())) {
                    this.f20279b.setText(adItemData.B());
                }
            }
            textView = this.f20279b;
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    protected Drawable b(AdItemData adItemData) {
        Drawable b2 = (adItemData == null || adItemData.l() == null || com.opos.cmn.an.c.a.a(adItemData.l().a())) ? null : g.b(this.f20278a, adItemData.l().a());
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(b2 != null ? b2 : "null");
        com.opos.cmn.an.f.a.b("BaseCreative", sb.toString());
        return b2;
    }

    protected String c(AdItemData adItemData) {
        return g.a(this.f20278a, adItemData, this.f20282e);
    }

    public void d() {
        h();
        i();
        j();
    }

    protected RelativeLayout.LayoutParams f() {
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoLP mLogoDrawable=");
        Object obj = this.f20280c;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("BaseCreative", sb.toString());
        return this.f20280c != null ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f20278a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 12.0f)) : new RelativeLayout.LayoutParams(-2, -2);
    }

    public abstract void g();

    public abstract void h();

    protected abstract void i();

    protected abstract void j();
}

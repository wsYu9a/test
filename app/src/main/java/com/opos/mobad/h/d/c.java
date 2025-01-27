package com.opos.mobad.h.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.h.f;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.n.a;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends a {
    private com.opos.cmn.e.a.a.c t;
    private Bitmap u;

    public c(Context context, a.InterfaceC0458a interfaceC0458a) {
        super(context, interfaceC0458a, 2.25f);
        this.u = null;
    }

    private void f(AdItemData adItemData) {
        a(adItemData);
        RelativeLayout.LayoutParams f2 = f();
        f2.addRule(9);
        f2.addRule(12);
        a(f2);
    }

    private void o() {
        TextView textView = new TextView(this.f20278a);
        this.n = textView;
        textView.setTextColor(Color.parseColor("#333333"));
        this.n.setTextSize(1, m() * 16.0f);
        this.n.setMaxLines(1);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.addRule(0, 3);
        layoutParams.topMargin = a(20.0f);
        layoutParams.rightMargin = a(16.0f);
        this.m.addView(this.n, layoutParams);
    }

    private void p() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f20278a, 6.66f);
        this.t = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.setId(3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(107.0f), a(70.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = a(20.0f);
        this.m.addView(this.t, layoutParams);
    }

    private void q() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(16.0f), a(16.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(0, 3);
        layoutParams.rightMargin = a(16.0f);
        b(layoutParams);
    }

    public void e(AdItemData adItemData) {
        if (adItemData != null) {
            this.f20283f = adItemData;
            this.f20282e = false;
            MaterialData materialData = adItemData.i().get(0);
            if (materialData != null) {
                f(adItemData);
                a(this.n, materialData.i());
                a(this.q, materialData.h());
                d(adItemData);
                a(this.l, adItemData, com.opos.mobad.cmn.a.b.a.NonClickBt);
                a(this.r, adItemData, com.opos.mobad.cmn.a.b.a.ClickBt);
                a(this.o, adItemData, materialData.Z());
                List<MaterialFileData> f2 = materialData.f();
                if (f2 == null || f2.size() <= 0 || f2.get(0) == null) {
                    return;
                }
                Bitmap a2 = f.a(f2.get(0).a(), a(107.0f), a(70.0f));
                this.u = a2;
                if (a2 != null) {
                    this.t.setImageBitmap(a2);
                }
            }
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void g() {
        p();
        o();
        q();
    }

    @Override // com.opos.mobad.cmn.a.c
    public void h() {
        try {
            Bitmap bitmap = this.u;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.u.recycle();
                this.u = null;
                com.opos.cmn.an.f.a.b("GM320X210NativeTemplet", "mAdBitmap.recycle()");
            }
            a(this.q, "");
            a(this.n, "");
            a(this.l);
            a(this.r);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("GM320X210NativeTemplet", "");
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void i() {
    }

    @Override // com.opos.mobad.h.d.a
    protected int l() {
        return a(90.0f);
    }
}

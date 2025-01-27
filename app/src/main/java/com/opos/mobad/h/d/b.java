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
public class b extends a {
    private com.opos.cmn.e.a.a.c t;
    private com.opos.cmn.e.a.a.c u;
    private com.opos.cmn.e.a.a.c v;
    private Bitmap w;
    private Bitmap x;
    private Bitmap y;

    public b(Context context, a.InterfaceC0458a interfaceC0458a) {
        super(context, interfaceC0458a, 1.6289593f);
        this.w = null;
        this.x = null;
        this.y = null;
    }

    private void f(AdItemData adItemData) {
        a(adItemData);
        RelativeLayout.LayoutParams f2 = f();
        f2.addRule(9);
        f2.addRule(3, 3);
        f2.topMargin = a(10.0f);
        a(f2);
    }

    private void o() {
        TextView textView = new TextView(this.f20278a);
        this.n = textView;
        textView.setId(2);
        this.n.setTextColor(Color.parseColor("#333333"));
        this.n.setTextSize(1, m() * 16.0f);
        this.n.setMaxLines(1);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.topMargin = a(20.0f);
        this.m.addView(this.n, layoutParams);
    }

    private void p() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f20278a, 6.66f);
        this.t = cVar;
        cVar.setId(3);
        this.t.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(107.0f), a(70.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(3, 2);
        layoutParams.topMargin = a(16.0f);
        this.m.addView(this.t, layoutParams);
    }

    private void q() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f20278a, 6.66f);
        this.u = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(107.0f), a(70.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 2);
        layoutParams.topMargin = a(16.0f);
        this.m.addView(this.u, layoutParams);
    }

    private void r() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f20278a, 6.66f);
        this.v = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.v.setId(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(107.0f), a(70.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(3, 2);
        layoutParams.topMargin = a(16.0f);
        this.m.addView(this.v, layoutParams);
    }

    private void s() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(16.0f), a(16.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(3, 4);
        layoutParams.topMargin = a(8.0f);
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
                MaterialFileData materialFileData = f2.get(0);
                MaterialFileData materialFileData2 = f2.get(1);
                MaterialFileData materialFileData3 = f2.get(2);
                if (materialFileData == null || materialFileData2 == null || materialFileData3 == null) {
                    return;
                }
                Bitmap a2 = f.a(materialFileData.a(), a(107.0f), a(70.0f));
                this.w = a2;
                if (a2 != null) {
                    this.t.setImageBitmap(a2);
                }
                Bitmap a3 = f.a(materialFileData2.a(), a(107.0f), a(70.0f));
                this.x = a3;
                if (a3 != null) {
                    this.u.setImageBitmap(a3);
                }
                Bitmap a4 = f.a(materialFileData3.a(), a(107.0f), a(70.0f));
                this.y = a4;
                if (a4 != null) {
                    this.v.setImageBitmap(a4);
                }
            }
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void g() {
        o();
        p();
        q();
        r();
        s();
    }

    @Override // com.opos.mobad.cmn.a.c
    public void h() {
        try {
            Bitmap bitmap = this.w;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.w.recycle();
                this.w = null;
                com.opos.cmn.an.f.a.b("GM320X210GroupNativeTemplet", "mAdBitmap_1.recycle()");
            }
            Bitmap bitmap2 = this.x;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.x.recycle();
                this.x = null;
                com.opos.cmn.an.f.a.b("GM320X210GroupNativeTemplet", "mAdBitmap_2.recycle()");
            }
            Bitmap bitmap3 = this.y;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.y.recycle();
                this.y = null;
                com.opos.cmn.an.f.a.b("GM320X210GroupNativeTemplet", "mAdBitmap_3.recycle()");
            }
            a(this.q, "");
            a(this.n, "");
            a(this.l);
            a(this.r);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("GM320X210GroupNativeTemplet", "");
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void i() {
    }

    @Override // com.opos.mobad.h.d.a
    protected int l() {
        return -2;
    }
}

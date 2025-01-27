package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.n.a;
import java.util.List;

/* loaded from: classes4.dex */
public class i extends c {
    private l k;
    private Bitmap l;

    public i(Activity activity, int i2, a.InterfaceC0458a interfaceC0458a) {
        super(activity, i2, interfaceC0458a);
        this.l = null;
    }

    @Override // com.opos.mobad.interstitial.a.c, com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        super.a(hVar);
        com.opos.mobad.n.d.d a2 = hVar != null ? hVar.a() : null;
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("ImgInterstitial", "render with data null");
            return;
        }
        a(a2, this.f21039h);
        a(false, a2.o);
        a(a2);
        a(this.f21037f);
        b((View) this.f21039h);
        a(a2.o);
        List<com.opos.mobad.n.d.g> list = a2.f22075g;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(list.get(0).f22084a)) {
            return;
        }
        Bitmap a3 = com.opos.mobad.cmn.a.b.g.a(list.get(0).f22084a, com.opos.cmn.an.h.f.a.a(this.f21032a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f21032a, 200.0f));
        this.l = a3;
        if (a3 != null) {
            this.k.setImageBitmap(a3);
        }
    }

    public void c(RelativeLayout relativeLayout) {
        l lVar = new l(this.f21032a, 14.0f);
        this.k = lVar;
        lVar.setId(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21032a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f21032a, 200.0f));
        layoutParams.addRule(10);
        relativeLayout.addView(this.k, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            Bitmap bitmap = this.l;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.l.recycle();
            this.l = null;
            com.opos.cmn.an.f.a.b("ImgInterstitial", "mImgBitmap.recycle()");
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("ImgInterstitial", "");
        }
    }

    @Override // com.opos.mobad.interstitial.a.c
    public void f() {
        c(this.f21039h);
        a(this.f21039h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21032a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f21032a, 234.0f));
        layoutParams.addRule(13);
        this.f21038g.addView(this.f21039h, layoutParams);
    }
}

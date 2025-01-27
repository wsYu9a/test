package com.opos.cmn.e.a.b.a;

import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: b */
    private ObjectAnimator f16931b;

    public b(View view) {
        super(view);
        c();
    }

    private void c() {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16930a, "rotation", 0.0f, 360.0f);
            this.f16931b = ofFloat;
            ofFloat.setDuration(1000L);
            this.f16931b.setRepeatMode(1);
            this.f16931b.setRepeatCount(-1);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e2);
        }
    }

    @Override // com.opos.cmn.e.a.b.a.a
    public void a() {
        try {
            this.f16931b.start();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e2);
        }
    }

    @Override // com.opos.cmn.e.a.b.a.a
    public void b() {
        try {
            this.f16931b.cancel();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e2);
        }
    }
}

package com.sigmob.sdk.nativead;

import android.content.Context;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.windad.natives.WindNativeAdData;

/* loaded from: classes4.dex */
public class p extends j {

    /* renamed from: e */
    public z f20032e;

    public p(Context context) {
        super(context);
    }

    public void a(z zVar) {
        this.f20032e = zVar;
    }

    @Override // com.sigmob.sdk.nativead.j
    public void d() {
        super.d();
        this.f20032e = null;
    }

    public void f() {
    }

    public void g() {
    }

    public c getAdConfig() {
        z zVar = this.f20032e;
        if (zVar != null) {
            return zVar.d();
        }
        return null;
    }

    public BaseAdUnit getAdUnit() {
        z zVar = this.f20032e;
        if (zVar != null) {
            return zVar.a();
        }
        return null;
    }

    public k getAppInfoView() {
        z zVar = this.f20032e;
        if (zVar != null) {
            return zVar.b();
        }
        return null;
    }

    public WindNativeAdData getNativeAdUnit() {
        z zVar = this.f20032e;
        if (zVar != null) {
            return zVar.h();
        }
        return null;
    }

    public double getVideoDuration() {
        return l5.c.f27899e;
    }

    public double getVideoProgress() {
        return l5.c.f27899e;
    }

    public void h() {
    }

    public void setUIStyle(g gVar) {
        this.f19965a = gVar;
    }
}

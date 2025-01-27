package com.sigmob.sdk.splash;

import android.content.Context;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.SplashAdSetting;

/* loaded from: classes4.dex */
public class c extends com.sigmob.sdk.base.common.i {

    /* renamed from: w */
    public int f20307w = 3;

    /* renamed from: x */
    public boolean f20308x;

    public static c f(BaseAdUnit baseAdUnit) {
        c cVar = new c();
        cVar.b(baseAdUnit);
        return cVar;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "click");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(Context context, int i10, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        b0.a("start", (String) null, baseAdUnit, (b0.g) null);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "start");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void c(Context context, int i10, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        b0.b("skip", null, baseAdUnit);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "skip");
    }

    public int m() {
        return this.f20307w;
    }

    public boolean n() {
        return this.f20308x;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, int i10, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        b0.b("close", null, baseAdUnit);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "ad_close");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        SplashAdSetting splashAdSetting = baseAdUnit.getSplashAdSetting();
        if (splashAdSetting != null) {
            this.f20307w = splashAdSetting.show_duration.intValue();
            this.f20308x = splashAdSetting.enable_close_on_click.booleanValue();
        }
    }
}

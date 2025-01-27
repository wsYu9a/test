package com.sigmob.sdk.splash;

import android.os.Bundle;
import android.text.TextUtils;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import java.util.Map;

/* loaded from: classes4.dex */
public class f extends x {

    /* renamed from: d */
    public c f20311d;

    /* renamed from: e */
    public SplashAdBroadcastReceiver f20312e;

    public interface a extends o.b, o.c {
        void c();

        void e();

        void f();

        void j();
    }

    public f(o.b bVar) {
        super(bVar);
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        MaterialMeta material = baseAdUnit.getMaterial();
        if (TextUtils.isEmpty(baseAdUnit.getCrid())) {
            return false;
        }
        return (TextUtils.isEmpty(material.video_url) && TextUtils.isEmpty(material.image_src)) ? false : true;
    }

    @Override // com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        return c(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        SplashAdBroadcastReceiver splashAdBroadcastReceiver = this.f20312e;
        if (splashAdBroadcastReceiver != null) {
            splashAdBroadcastReceiver.b(splashAdBroadcastReceiver);
            this.f20312e = null;
        }
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        super.a(map, baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(o.b bVar) {
        this.f18041a = bVar;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        if (baseAdUnit == null) {
            baseAdUnit = this.f18042b;
        }
        this.f20311d = (c) baseAdUnit.getAdConfig();
        super.a(baseAdUnit, bundle);
        if (this.f18041a instanceof a) {
            SplashAdBroadcastReceiver splashAdBroadcastReceiver = new SplashAdBroadcastReceiver((a) this.f18041a, baseAdUnit.getUuid());
            this.f20312e = splashAdBroadcastReceiver;
            splashAdBroadcastReceiver.a(splashAdBroadcastReceiver);
        }
    }
}

package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.view.m;

/* loaded from: classes4.dex */
public class e extends a {
    public e(Activity activity, AdParams adParams, UnifiedVivoSplashAdListener unifiedVivoSplashAdListener) {
        super(activity, adParams);
        this.u = unifiedVivoSplashAdListener;
    }

    @Override // com.vivo.mobilead.unified.splash.a, com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void a(@NonNull com.vivo.ad.model.b bVar) {
        super.a(bVar);
        m mVar = this.v;
        if (mVar != null) {
            mVar.f();
        }
    }
}

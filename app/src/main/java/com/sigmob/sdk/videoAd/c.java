package com.sigmob.sdk.videoAd;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: classes4.dex */
public abstract class c extends com.sigmob.sdk.base.common.j {
    public c(Activity activity, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
    }

    public void a(boolean z10) {
        if (z10) {
            this.f17902e.a();
        }
    }

    public void b(Context context, int i10, Bundle bundle) {
        Activity f10;
        try {
            a(context.getApplicationContext(), i10, bundle);
            boolean z10 = bundle.getBoolean(com.sigmob.sdk.base.k.f18189u, false);
            boolean z11 = bundle.getBoolean(com.sigmob.sdk.base.k.f18188t, false);
            if (Build.VERSION.SDK_INT >= 27) {
                if (z10) {
                    f().setTurnScreenOn(true);
                }
                if (z11) {
                    f().setShowWhenLocked(true);
                    f().setTurnScreenOn(true);
                }
                if (z10) {
                    f().getWindow().addFlags(128);
                }
                if (!z11) {
                    return;
                } else {
                    f10 = f();
                }
            } else {
                if (z10) {
                    f().getWindow().addFlags(128);
                }
                if (!z11) {
                    return;
                } else {
                    f10 = f();
                }
            }
            f10.getWindow().addFlags(2621440);
        } catch (Throwable th2) {
            SigmobLog.e("optionSetting error", th2);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void k() {
        this.f17902e.onSetContentView(this.f17901d);
    }
}

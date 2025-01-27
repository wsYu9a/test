package com.jd.ad.sdk.jad_fq;

import android.app.Application;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes2.dex */
public class jad_cp {
    public static Application jad_an;

    @Nullable
    public static Application jad_an() {
        Application application = jad_an;
        if (application != null) {
            return application;
        }
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (Exception e10) {
            Logger.w("get application error: ", e10.getMessage());
            try {
                return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", null).invoke(null, null);
            } catch (Exception e11) {
                Logger.w("get application error: ", e11.getMessage());
                return null;
            }
        }
    }
}

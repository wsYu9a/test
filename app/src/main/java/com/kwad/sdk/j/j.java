package com.kwad.sdk.j;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes2.dex */
final class j {
    static Context df(Context context) {
        Context applicationContext = unwrapContextIfNeed(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            applicationContext = applicationContext.getApplicationContext();
            if (applicationContext instanceof Application) {
                return applicationContext;
            }
            if (dg(applicationContext)) {
                applicationContext = dh(applicationContext);
            }
        }
        return applicationContext;
    }

    static boolean dg(Context context) {
        return context instanceof ResContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Context dh(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }

    static Context unwrapContextIfNeed(Context context) {
        if (dg(context)) {
            context = dh(context);
        }
        if (!dg(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i2 = 0; i2 < 10; i2++) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish());
                ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            context = dh(context);
            if (!dg(context)) {
                return context;
            }
        }
        return context;
    }

    static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }
}

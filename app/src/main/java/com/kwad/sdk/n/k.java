package com.kwad.sdk.n;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
final class k {
    /* JADX WARN: Multi-variable type inference failed */
    public static Context aF(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    public static boolean aG(Context context) {
        return context instanceof ResContext;
    }

    public static Context dF(Context context) {
        Context applicationContext = unwrapContextIfNeed(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        for (int i10 = 0; i10 < 10; i10++) {
            applicationContext = applicationContext.getApplicationContext();
            if (applicationContext instanceof Application) {
                return applicationContext;
            }
            if (aG(applicationContext)) {
                applicationContext = aF(applicationContext);
            }
        }
        return applicationContext;
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (aG(context)) {
            context = aF(context);
        }
        if (!aG(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i10 = 0; i10 < 10; i10++) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zE());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            context = aF(context);
            if (!aG(context)) {
                return context;
            }
        }
        return context;
    }

    public static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }
}

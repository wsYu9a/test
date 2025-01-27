package com.kwad.sdk.n;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;

/* loaded from: classes3.dex */
public final class m {
    private static Application aYd;

    private static boolean PZ() {
        if (f.PU().Ow()) {
            return true;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
        return false;
    }

    public static Application Qa() {
        PZ();
        Application Qb = Qb();
        if (j.PX()) {
            aYd = (Application) j.wrapContextIfNeed(Qb);
        }
        return aYd;
    }

    private static Application Qb() {
        Application application = aYd;
        if (application != null) {
            return application;
        }
        Context MA = ServiceProvider.MA();
        if (MA instanceof Application) {
            Application application2 = (Application) MA;
            aYd = application2;
            return application2;
        }
        Context applicationContext = MA.getApplicationContext();
        if (applicationContext instanceof Application) {
            Application application3 = (Application) applicationContext;
            aYd = application3;
            return application3;
        }
        Context dF = aG(applicationContext) ? j.dF(applicationContext) : k.aG(applicationContext) ? k.dF(applicationContext) : MA.getApplicationContext();
        if (dF instanceof Application) {
            aYd = (Application) dF;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.Fi().getApplication();
            if (application4 != null) {
                aYd = application4;
            } else if (dF instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) dF).getBaseContext();
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext instanceof Application) {
                    aYd = (Application) baseContext;
                }
            }
        }
        if (aYd == null) {
            aYd = Qc();
        }
        Application dL = dL(aYd);
        aYd = dL;
        return dL;
    }

    private static Application Qc() {
        Application application = (Application) w.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) w.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static View a(Context context, @LayoutRes int i10, @Nullable ViewGroup viewGroup, boolean z10) {
        return dO(context).inflate(i10, viewGroup, false);
    }

    private static boolean aG(Context context) {
        return context instanceof b;
    }

    public static LayoutInflater b(Context context, Context context2) {
        LayoutInflater cloneInContext = LayoutInflater.from(dP(context)).cloneInContext(context2);
        a(cloneInContext);
        return cloneInContext;
    }

    @Nullable
    public static Activity dH(@Nullable Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context dJ = dJ(context);
        if (dJ instanceof Activity) {
            return (Activity) dJ;
        }
        com.kwad.sdk.core.c.b.Fi();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    @NonNull
    private static Context dI(Context context) {
        if (j.PX() && !aG(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zE()));
        } else if (!j.PX() && !k.aG(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zE()));
        }
        return context;
    }

    @NonNull
    public static Context dJ(Context context) {
        if (!PZ()) {
            return context;
        }
        if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zB()) {
            return context;
        }
        if (dM(context)) {
            return context;
        }
        return dK(aG(context) ? j.dE(context) : k.unwrapContextIfNeed(context));
    }

    private static Context dK(Context context) {
        if (k.aG(context) || (context instanceof b)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zE()));
        }
        return context;
    }

    private static Application dL(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zE() + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zB()));
        return null;
    }

    public static boolean dM(Context context) {
        return (aG(context) || k.aG(context)) ? false : true;
    }

    public static Context dN(Context context) {
        try {
            if (k.aG(context)) {
                context = k.aF(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        if (dM(context)) {
            return context;
        }
        for (int i10 = 0; i10 < 5; i10++) {
            if (k.aG(context)) {
                context = k.aF(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
            if (dM(context)) {
                return context;
            }
        }
        return context;
    }

    public static LayoutInflater dO(Context context) {
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        if (!k.aG(wrapContextIfNeed)) {
            return LayoutInflater.from(wrapContextIfNeed);
        }
        LayoutInflater from = LayoutInflater.from(wrapContextIfNeed);
        a(from);
        return from;
    }

    private static Context dP(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    public static int getThemeResId(Context context) {
        if (!(context instanceof ContextThemeWrapper)) {
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
            }
            return 0;
        }
        Object a10 = w.a((Object) context, "android.view.ContextThemeWrapper", "getThemeResId");
        if (a10 != null) {
            return ((Integer) a10).intValue();
        }
        return 0;
    }

    public static View inflate(Context context, @LayoutRes int i10, @Nullable ViewGroup viewGroup) {
        return dO(context).inflate(i10, viewGroup);
    }

    public static void j(Activity activity) {
        k.onDestroy(activity);
    }

    @NonNull
    public static Context wrapContextIfNeed(Context context) {
        if (!PZ()) {
            return context;
        }
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zB()) {
            return dI(j.PX() ? j.wrapContextIfNeed(context) : k.wrapContextIfNeed(context));
        }
        return context;
    }

    public static void x(Context context, boolean z10) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z10).apply();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    public static void a(Application application) {
        if (aYd == null) {
            aYd = application;
        }
    }

    private static void a(LayoutInflater layoutInflater) {
        w.a(layoutInflater, "mFactory", (Object) null);
        w.a(layoutInflater, "mFactory2", (Object) null);
    }
}

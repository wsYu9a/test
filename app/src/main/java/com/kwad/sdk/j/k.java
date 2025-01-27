package com.kwad.sdk.j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;

/* loaded from: classes2.dex */
public final class k {
    private static Application aDP;

    public static Application FP() {
        checkInit();
        Application FQ = FQ();
        if (i.FO()) {
            aDP = (Application) i.wrapContextIfNeed(FQ);
        }
        return aDP;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.Application FQ() {
        /*
            android.app.Application r0 = com.kwad.sdk.j.k.aDP
            if (r0 == 0) goto L5
            return r0
        L5:
            android.content.Context r0 = com.kwad.sdk.service.ServiceProvider.CA()
            android.content.Context r0 = r0.getApplicationContext()
            boolean r1 = r0 instanceof android.app.Application
            if (r1 == 0) goto L16
            android.app.Application r0 = (android.app.Application) r0
        L13:
            com.kwad.sdk.j.k.aDP = r0
            return r0
        L16:
            boolean r1 = dg(r0)
            if (r1 == 0) goto L21
            android.content.Context r0 = com.kwad.sdk.j.i.df(r0)
            goto L34
        L21:
            boolean r1 = com.kwad.sdk.j.j.dg(r0)
            if (r1 == 0) goto L2c
            android.content.Context r0 = com.kwad.sdk.j.j.df(r0)
            goto L34
        L2c:
            android.content.Context r0 = com.kwad.sdk.service.ServiceProvider.CA()
            android.content.Context r0 = r0.getApplicationContext()
        L34:
            boolean r1 = r0 instanceof android.app.Application
            if (r1 == 0) goto L3e
            r1 = r0
            android.app.Application r1 = (android.app.Application) r1
        L3b:
            com.kwad.sdk.j.k.aDP = r1
            goto L61
        L3e:
            com.kwad.sdk.core.b.b r1 = com.kwad.sdk.core.b.b.vS()
            android.app.Application r1 = r1.getApplication()
            if (r1 == 0) goto L49
            goto L3b
        L49:
            boolean r1 = r0 instanceof android.content.ContextWrapper
            if (r1 == 0) goto L61
            r1 = r0
            android.content.ContextWrapper r1 = (android.content.ContextWrapper) r1
            android.content.Context r1 = r1.getBaseContext()
            if (r1 == 0) goto L5a
            android.content.Context r1 = r1.getApplicationContext()
        L5a:
            boolean r2 = r1 instanceof android.app.Application
            if (r2 == 0) goto L61
            android.app.Application r1 = (android.app.Application) r1
            goto L3b
        L61:
            android.app.Application r1 = com.kwad.sdk.j.k.aDP
            if (r1 != 0) goto L6b
            android.app.Application r1 = FR()
            com.kwad.sdk.j.k.aDP = r1
        L6b:
            android.app.Application r0 = dn(r0)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.j.k.FQ():android.app.Application");
    }

    private static Application FR() {
        Application application = (Application) s.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) s.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static View a(Context context, @LayoutRes int i2, @Nullable ViewGroup viewGroup, boolean z) {
        return dq(context).inflate(i2, viewGroup, false);
    }

    public static void a(Application application) {
        if (aDP == null) {
            aDP = application;
        }
    }

    public static void a(LayoutInflater layoutInflater) {
        s.a(layoutInflater, "mFactory", (Object) null);
        s.a(layoutInflater, "mFactory2", (Object) null);
    }

    private static void checkInit() {
        if (e.FK().Ep()) {
            return;
        }
        ServiceProvider.b(new RuntimeException("please init KSPlugin"));
    }

    private static boolean dg(Context context) {
        return context instanceof a;
    }

    public static int di(Context context) {
        if (!(context instanceof ContextThemeWrapper)) {
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
            }
            return 0;
        }
        Object a2 = s.a((Object) context, "getThemeResId", new Object[0]);
        if (a2 != null) {
            return ((Integer) a2).intValue();
        }
        return 0;
    }

    @Nullable
    public static Activity dj(@Nullable Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context dl = dl(context);
        if (dl instanceof Activity) {
            return (Activity) dl;
        }
        com.kwad.sdk.core.b.b.vS();
        return com.kwad.sdk.core.b.b.getCurrentActivity();
    }

    @NonNull
    private static Context dk(Context context) {
        RuntimeException runtimeException;
        if (!i.FO() || dg(context)) {
            if (!i.FO() && !j.dg(context)) {
                runtimeException = new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish());
            }
            return context;
        }
        runtimeException = new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish());
        ServiceProvider.b(runtimeException);
        return context;
    }

    @NonNull
    public static Context dl(Context context) {
        checkInit();
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal() && !m62do(context)) {
            return dm(dg(context) ? i.de(context) : j.unwrapContextIfNeed(context));
        }
        return context;
    }

    private static Context dm(Context context) {
        if (j.dg(context) || (context instanceof a)) {
            ServiceProvider.b(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish()));
        }
        return context;
    }

    private static Application dn(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        ServiceProvider.b(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish() + "--isExternal:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal()));
        return null;
    }

    /* renamed from: do */
    public static boolean m62do(Context context) {
        return (dg(context) || j.dg(context)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static Context dp(Context context) {
        boolean dg = j.dg(context);
        ?? r2 = context;
        if (dg) {
            r2 = j.dh(context);
        }
        boolean z = r2 instanceof a;
        Context context2 = r2;
        if (z) {
            context2 = ((a) r2).getDelegatedContext();
        }
        if (m62do(context2)) {
            return context2;
        }
        int i2 = 0;
        Context context3 = context2;
        while (i2 < 5) {
            boolean dg2 = j.dg(context3);
            ?? r22 = context3;
            if (dg2) {
                r22 = j.dh(context3);
            }
            boolean z2 = r22 instanceof a;
            Context context4 = r22;
            if (z2) {
                context4 = ((a) r22).getDelegatedContext();
            }
            if (m62do(context4)) {
                return context4;
            }
            i2++;
            context3 = context4;
        }
        return context3;
    }

    public static LayoutInflater dq(Context context) {
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        boolean dg = j.dg(wrapContextIfNeed);
        LayoutInflater from = LayoutInflater.from(wrapContextIfNeed);
        if (dg) {
            a(from);
        }
        return from;
    }

    public static void g(Activity activity) {
        j.onDestroy(activity);
    }

    public static View inflate(Context context, @LayoutRes int i2, @Nullable ViewGroup viewGroup) {
        return dq(context).inflate(i2, viewGroup);
    }

    @NonNull
    public static Context wrapContextIfNeed(Context context) {
        checkInit();
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal()) {
            return dk(i.FO() ? i.wrapContextIfNeed(context) : j.wrapContextIfNeed(context));
        }
        return context;
    }

    public static void x(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }
}

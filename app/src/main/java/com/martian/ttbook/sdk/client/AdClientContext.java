package com.martian.ttbook.sdk.client;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import b.d.e.a.d;
import b.d.e.a.j.c;
import b.d.e.a.j.f;
import b.d.e.a.j.g;
import b.d.e.a.k.e;
import com.martian.ttbook.a.i.a;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.j;
import com.martian.ttbook.sdk.client.SdkConfiguration;

/* loaded from: classes4.dex */
public class AdClientContext {
    public static final int S_COLD_BOOT_TIME = 30000;
    static final String TAG = "AdClientContext";
    private static boolean firstLaunch = false;
    static Context gContext = null;
    static SdkConfiguration gSdkConfiguration = null;
    private static boolean isInitSuccess = false;
    private static volatile boolean isRealy = false;
    public static String oaId = "";
    public static long sInitApplicationTimeWithCold;
    public static long sInitTime;
    public static long sSdkInitUsedTime;

    /* renamed from: com.martian.ttbook.sdk.client.AdClientContext$1 */
    static class AnonymousClass1 implements d.c {
        AnonymousClass1() {
        }

        @Override // b.d.e.a.d.c
        public void onInited() {
            c.f(j.r.booleanValue());
        }
    }

    public static Activity getActivity(AdRequest adRequest, Activity activity) {
        if (activity != null) {
            return activity;
        }
        Activity activity2 = adRequest.getActivity();
        if (activity2 != null) {
            return activity2;
        }
        return null;
    }

    public static Context getClientContext() {
        Context context = gContext;
        if (context != null) {
            return context;
        }
        throw new a("must call init");
    }

    public static long getInitApplicationCreateTime() {
        return sInitApplicationTimeWithCold;
    }

    public static long getInitTime() {
        return sInitTime;
    }

    public static LayoutInflater getLayoutInflater(Context context) {
        return LayoutInflater.from(context);
    }

    public static SdkConfiguration getSdkConfiguration() {
        return gSdkConfiguration;
    }

    public static long getSdkInitUsedTime() {
        return sSdkInitUsedTime;
    }

    static void init(Context context, SdkConfiguration sdkConfiguration) {
        if (context == null) {
            throw new a("context is null");
        }
        if (sdkConfiguration == null) {
            throw new a("sdkConfiguration is null");
        }
        try {
            sInitTime = System.currentTimeMillis();
            firstLaunch = true;
            gContext = context.getApplicationContext();
            gSdkConfiguration = new SdkConfiguration.Builder(sdkConfiguration).build();
            long currentTimeMillis = System.currentTimeMillis();
            g.d();
            c.d("timeTrace", "init base used time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            initCore(gContext);
            int isAgreePrivacy = gSdkConfiguration.isAgreePrivacy();
            c.d("timeTrace", "ap = " + isAgreePrivacy);
            if (isAgreePrivacy != -1) {
                n.e(isAgreePrivacy == 1);
            }
            e.b(gContext);
            sSdkInitUsedTime = System.currentTimeMillis() - currentTimeMillis;
            isInitSuccess = true;
            c.d("timeTrace", "init used time " + sSdkInitUsedTime + " ms");
        } catch (Exception e2) {
            c.d("timeTrace", "init err " + e2);
            gContext = null;
            isInitSuccess = false;
        }
    }

    public static synchronized void init(Context context, String str) {
        synchronized (AdClientContext.class) {
            oaId = str;
            Log.i(TAG, "init enter " + f.a());
            if (!isRealy()) {
                init(context, new SdkConfiguration.Builder().setAppName("wps").build());
            }
        }
    }

    private static void initCore(Context context) {
        try {
            d.a().d(new d.c() { // from class: com.martian.ttbook.sdk.client.AdClientContext.1
                AnonymousClass1() {
                }

                @Override // b.d.e.a.d.c
                public void onInited() {
                    c.f(j.r.booleanValue());
                }
            });
            isRealy = true;
        } catch (Throwable th) {
            th.printStackTrace();
            isRealy = false;
        }
    }

    public static boolean isCoreRealy() {
        return isRealy;
    }

    public static boolean isFirstLaunch() {
        return firstLaunch;
    }

    public static boolean isIsInitSuccess() {
        c.d("timeTrace", "init " + isInitSuccess + ", " + isRealy());
        return isInitSuccess;
    }

    public static boolean isRealy() {
        return gContext != null;
    }

    public static boolean isSplashColdBoot() {
        return firstLaunch && System.currentTimeMillis() - sInitTime < 30000;
    }

    static void reinit(Context context, SdkConfiguration sdkConfiguration) {
        firstLaunch = false;
    }

    public static void resetCollectTime() {
        sInitApplicationTimeWithCold = 0L;
        sInitTime = 0L;
        sSdkInitUsedTime = 0L;
    }

    public static void setOaid(String str) {
        try {
            d.a().f(str);
        } catch (Exception e2) {
            c.d("timeTrace", "set oaid " + e2.getMessage());
        }
    }

    public static void simpleRecycle(AdRequest adRequest) {
        adRequest.recycleClientRelation();
    }
}

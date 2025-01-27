package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class ServiceProvider {
    private static List<Throwable> LD;

    @SuppressLint({"StaticFieldLeak"})
    private static Context aSo;

    @SuppressLint({"StaticFieldLeak"})
    private static Context aSp;
    private static SdkConfig aSq;
    private static boolean aSr;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    public enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t10) {
            this.mProviders.put(cls, t10);
        }
    }

    @NonNull
    @Deprecated
    public static Context MA() {
        return mContext;
    }

    @NonNull
    public static SdkConfig MB() {
        return aSq;
    }

    public static void Mz() {
        aSr = true;
    }

    private static void b(Throwable th2) {
        if (LD == null) {
            LD = new CopyOnWriteArrayList();
        }
        LD.add(th2);
    }

    public static void bT(Context context) {
        aSo = context;
        mContext = m.dN(context);
    }

    public static void c(SdkConfig sdkConfig) {
        aSq = sdkConfig;
    }

    public static void f(com.kwad.sdk.f.a<Throwable> aVar) {
        List<Throwable> list = LD;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        LD.clear();
        LD = null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static String getAppId() {
        return aSq.appId;
    }

    public static String getAppName() {
        return aSq.appName;
    }

    @NonNull
    public static Context getContext() {
        if (aSr) {
            return MA();
        }
        if (aSp == null) {
            aSp = m.wrapContextIfNeed(mContext);
        }
        return aSp;
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static <T> void put(Class<T> cls, T t10) {
        ServiceProviderDelegate.INSTANCE.put(cls, t10);
    }

    public static void reportSdkCaughtException(Throwable th2) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th2);
        } else {
            b(th2);
        }
    }
}

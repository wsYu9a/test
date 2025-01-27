package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.kwai.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class ServiceProvider {
    private static List<Throwable> Iq;

    @SuppressLint({"StaticFieldLeak"})
    private static Context ayL;

    @SuppressLint({"StaticFieldLeak"})
    private static Context ayM;
    private static SdkConfig ayN;
    private static boolean ayO;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }

    @NonNull
    public static Context CA() {
        return mContext;
    }

    @NonNull
    public static SdkConfig CB() {
        return ayN;
    }

    public static void Cz() {
        ayO = true;
    }

    public static void a(SdkConfig sdkConfig) {
        ayN = sdkConfig;
    }

    public static void b(com.kwad.sdk.e.a<Throwable> aVar) {
        List<Throwable> list = Iq;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        Iq.clear();
        Iq = null;
    }

    public static void b(Throwable th) {
        d dVar = (d) get(d.class);
        if (dVar != null) {
            dVar.gatherException(th);
        } else {
            c(th);
        }
    }

    public static void bt(Context context) {
        ayL = context;
        mContext = k.dp(context);
    }

    private static void c(Throwable th) {
        if (Iq == null) {
            Iq = new CopyOnWriteArrayList();
        }
        Iq.add(th);
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    @NonNull
    public static Context getContext() {
        if (ayO) {
            return CA();
        }
        if (ayM == null) {
            ayM = k.wrapContextIfNeed(mContext);
        }
        return ayM;
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }
}

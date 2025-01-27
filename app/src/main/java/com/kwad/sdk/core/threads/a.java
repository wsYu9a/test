package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bm;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class a {
    private static Map<String, WeakReference<C0219a>> amk = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a */
    public static class C0219a {
        private HandlerThread aml;
        private Handler mHandler;

        public C0219a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aml = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.aml.getLooper());
        }

        public final bm b(bm.a aVar) {
            return new bm(aVar, this.aml.getLooper());
        }

        public final Handler getHandler() {
            return this.mHandler;
        }
    }

    public static synchronized bm a(bm.a aVar) {
        bm b2;
        synchronized (a.class) {
            b2 = cJ("commonHT").b(aVar);
        }
        return b2;
    }

    @NonNull
    private static C0219a cJ(String str) {
        WeakReference<C0219a> weakReference = amk.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0219a c0219a = new C0219a(str);
        amk.put(str, new WeakReference<>(c0219a));
        return c0219a;
    }

    public static synchronized Handler xI() {
        Handler handler;
        synchronized (a.class) {
            handler = cJ("commonHT").getHandler();
        }
        return handler;
    }

    public static synchronized Handler xJ() {
        Handler handler;
        synchronized (a.class) {
            handler = cJ("reportHT").getHandler();
        }
        return handler;
    }
}

package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class a {
    private static Map<String, WeakReference<C0499a>> aEG = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    public static class C0499a {
        private HandlerThread aEH;

        /* renamed from: hf, reason: collision with root package name */
        private Handler f11973hf;

        public C0499a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aEH = handlerThread;
            handlerThread.start();
            this.f11973hf = new Handler(this.aEH.getLooper());
        }

        public final Handler getHandler() {
            return this.f11973hf;
        }
    }

    public static synchronized Handler Hf() {
        Handler handler;
        synchronized (a.class) {
            handler = eE("commonHT").getHandler();
        }
        return handler;
    }

    public static synchronized Handler Hg() {
        Handler handler;
        synchronized (a.class) {
            handler = eE("reportHT").getHandler();
        }
        return handler;
    }

    @NonNull
    private static C0499a eE(String str) {
        WeakReference<C0499a> weakReference = aEG.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0499a c0499a = new C0499a(str);
        aEG.put(str, new WeakReference<>(c0499a));
        return c0499a;
    }
}

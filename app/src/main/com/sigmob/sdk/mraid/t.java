package com.sigmob.sdk.mraid;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.v;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class t {

    /* renamed from: a */
    public static final int f19676a = 50;

    /* renamed from: b */
    public static final long f19677b = 3000000;

    /* renamed from: c */
    public static final long f19678c = 3000000;

    /* renamed from: d */
    @SuppressLint({"UseSparseArrays"})
    public static final Map<String, b> f19679d = Collections.synchronizedMap(new HashMap());

    /* renamed from: e */
    public static final c f19680e = new c();

    /* renamed from: f */
    public static Handler f19681f = new Handler();

    public static class b {

        /* renamed from: a */
        public final com.sigmob.sdk.base.views.g f19682a;

        /* renamed from: b */
        public final WeakReference<v> f19683b;

        /* renamed from: c */
        public final com.sigmob.sdk.base.common.t f19684c;

        /* renamed from: d */
        public final d f19685d;

        public b(com.sigmob.sdk.base.views.g gVar, v vVar, com.sigmob.sdk.base.common.t tVar, d dVar) {
            this.f19682a = gVar;
            this.f19683b = new WeakReference<>(vVar);
            this.f19684c = tVar;
            this.f19685d = dVar;
        }

        public d a() {
            return this.f19685d;
        }

        public com.sigmob.sdk.base.common.t b() {
            return this.f19684c;
        }

        public WeakReference<v> c() {
            return this.f19683b;
        }

        public com.sigmob.sdk.base.views.g d() {
            return this.f19682a;
        }
    }

    public static class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.c();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    @Deprecated
    public static void a() {
        f19679d.clear();
        f19681f.removeCallbacks(f19680e);
    }

    @Deprecated
    public static Map<String, b> b() {
        return f19679d;
    }

    public static synchronized void c() {
        synchronized (t.class) {
            try {
                Iterator<Map.Entry<String, b>> it = f19679d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, b> next = it.next();
                    if (next.getValue().c().get() == null) {
                        next.getValue().b().a();
                        it.remove();
                    }
                }
                if (!f19679d.isEmpty()) {
                    Handler handler = f19681f;
                    c cVar = f19680e;
                    handler.removeCallbacks(cVar);
                    f19681f.postDelayed(cVar, 3000000L);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static b a(String str) {
        Preconditions.checkNotNull(str);
        return f19679d.remove(str);
    }

    @Deprecated
    public static void a(Handler handler) {
        f19681f = handler;
    }

    public static void a(String str, e eVar, com.sigmob.sdk.base.views.g gVar, com.sigmob.sdk.base.common.t tVar, d dVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(eVar);
        Preconditions.checkNotNull(gVar);
        c();
        Map<String, b> map = f19679d;
        if (map.size() >= 50) {
            SigmobLog.w("Unable to cache web view. Please destroy some via #destroy() and try again.");
        } else {
            map.put(str, new b(gVar, eVar, tVar, dVar));
        }
    }
}

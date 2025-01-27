package com.kwad.library.solder.lib;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.ext.c;
import com.kwad.sdk.utils.bt;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class i {
    private static volatile i amt;
    private static Map<String, Integer> amv = new ConcurrentHashMap(8);

    @Nullable
    private static a amw;
    private e amu;
    private volatile boolean mHasInit = false;

    /* renamed from: com.kwad.library.solder.lib.i$1 */
    public class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            try {
                i.amv.put(thread.getName(), 1);
            } catch (Throwable th2) {
                com.kwad.library.solder.lib.a.e("Sodler", Log.getStackTraceString(th2));
            }
            return thread;
        }
    }

    /* renamed from: com.kwad.library.solder.lib.i$2 */
    public class AnonymousClass2 implements f.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.library.solder.lib.a.f.a
        public final void a(com.kwad.library.solder.lib.a.e eVar, File file) {
            if (i.amw != null) {
                try {
                    i.amw.b(eVar.getDownloadUrl(), file);
                } catch (Throwable th2) {
                    i.amw.d(eVar.getDownloadUrl(), th2);
                    throw new PluginError.UpdateError(th2.getMessage(), PluginError.ERROR_UPD_PLUGIN_CONNECTION);
                }
            }
        }
    }

    /* renamed from: com.kwad.library.solder.lib.i$3 */
    public class AnonymousClass3<P, R> extends b<P, R> {

        /* renamed from: com.kwad.library.solder.lib.i$3$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ com.kwad.library.solder.lib.a.e amm;

            public AnonymousClass1(com.kwad.library.solder.lib.a.e eVar) {
                eVar = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (eVar.yw()) {
                    i.this.amu.a(eVar, 16);
                }
            }
        }

        public AnonymousClass3(com.kwad.library.solder.lib.ext.b bVar, com.kwad.library.solder.lib.ext.b bVar2) {
            super(bVar, bVar2);
        }

        @Override // com.kwad.library.solder.lib.b, com.kwad.library.solder.lib.ext.b
        public final void a(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
            super.a((AnonymousClass3<P, R>) eVar, pluginError);
            com.kwad.library.solder.lib.a.e("Sodler", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
            i.this.amu.i(eVar);
            bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                final /* synthetic */ com.kwad.library.solder.lib.a.e amm;

                public AnonymousClass1(com.kwad.library.solder.lib.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (eVar.yw()) {
                        i.this.amu.a(eVar, 16);
                    }
                }
            }, eVar2.yv() instanceof PluginError.UpdateError ? 1000L : 0L);
        }
    }

    /* renamed from: com.kwad.library.solder.lib.i$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ String amz;

        public AnonymousClass4(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                i.this.amu.yj().bI(str);
            } catch (Throwable th2) {
                Log.getStackTraceString(th2);
            }
        }
    }

    public interface a {
        void b(String str, File file);

        void d(String str, Throwable th2);

        int getCorePoolSize();

        int getMaxRetryCount();

        boolean yp();
    }

    private i() {
    }

    public static boolean bM(String str) {
        try {
            Map<String, Integer> map = amv;
            if (map != null) {
                return map.containsKey(str);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static ExecutorService bO(int i10) {
        return new ThreadPoolExecutor(i10, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.library.solder.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                try {
                    i.amv.put(thread.getName(), 1);
                } catch (Throwable th2) {
                    com.kwad.library.solder.lib.a.e("Sodler", Log.getStackTraceString(th2));
                }
                return thread;
            }
        });
    }

    private synchronized void init(Context context) {
        try {
            if (this.mHasInit) {
                return;
            }
            c.a bU = new c.a().bU("sodler");
            a aVar = amw;
            c.a bi2 = bU.bR(aVar != null ? aVar.getMaxRetryCount() : 1).bi(false);
            a aVar2 = amw;
            c.a bj2 = bi2.bj(aVar2 != null && aVar2.yp());
            a aVar3 = amw;
            c.a a10 = bj2.a(bO(aVar3 != null ? aVar3.getCorePoolSize() : 0));
            a aVar4 = amw;
            com.kwad.library.solder.lib.ext.c yS = a10.bS(aVar4 != null ? aVar4.getCorePoolSize() : 0).yS();
            d dVar = new d(context);
            c cVar = new c(context, yS);
            f fVar = new f(context);
            fVar.a(new f.a() { // from class: com.kwad.library.solder.lib.i.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.library.solder.lib.a.f.a
                public final void a(com.kwad.library.solder.lib.a.e eVar, File file) {
                    if (i.amw != null) {
                        try {
                            i.amw.b(eVar.getDownloadUrl(), file);
                        } catch (Throwable th2) {
                            i.amw.d(eVar.getDownloadUrl(), th2);
                            throw new PluginError.UpdateError(th2.getMessage(), PluginError.ERROR_UPD_PLUGIN_CONNECTION);
                        }
                    }
                }
            });
            this.amu = new e(dVar, fVar, cVar, yS, new com.kwad.library.solder.lib.ext.a());
            this.mHasInit = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static i ym() {
        if (amt == null) {
            synchronized (i.class) {
                try {
                    if (amt == null) {
                        amt = new i();
                    }
                } finally {
                }
            }
        }
        return amt;
    }

    public final void k(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        if (yg() == null || yg().yQ() == null) {
            return;
        }
        yg().yQ().execute(new Runnable() { // from class: com.kwad.library.solder.lib.i.4
            final /* synthetic */ String amz;

            public AnonymousClass4(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    i.this.amu.yj().bI(str);
                } catch (Throwable th2) {
                    Log.getStackTraceString(th2);
                }
            }
        });
    }

    @Nullable
    public final com.kwad.library.solder.lib.a.a l(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        e eVar = this.amu;
        if (eVar != null) {
            return eVar.yh().bK(str);
        }
        return null;
    }

    public final com.kwad.library.solder.lib.ext.c yg() {
        if (this.mHasInit) {
            return this.amu.yg();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public static void a(a aVar) {
        amw = aVar;
    }

    public final <P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> void a(Context context, @NonNull R r10, com.kwad.library.solder.lib.ext.b<P, R> bVar) {
        init(context);
        r10.bQ(this.amu.yg().getRetryCount());
        r10.a(new b<P, R>(bVar, new b.C0475b()) { // from class: com.kwad.library.solder.lib.i.3

            /* renamed from: com.kwad.library.solder.lib.i$3$1 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ com.kwad.library.solder.lib.a.e amm;

                public AnonymousClass1(com.kwad.library.solder.lib.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (eVar.yw()) {
                        i.this.amu.a(eVar, 16);
                    }
                }
            }

            public AnonymousClass3(com.kwad.library.solder.lib.ext.b bVar2, com.kwad.library.solder.lib.ext.b bVar22) {
                super(bVar2, bVar22);
            }

            @Override // com.kwad.library.solder.lib.b, com.kwad.library.solder.lib.ext.b
            public final void a(com.kwad.library.solder.lib.a.e eVar2, PluginError pluginError) {
                super.a((AnonymousClass3<P, R>) eVar2, pluginError);
                com.kwad.library.solder.lib.a.e("Sodler", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
                i.this.amu.i(eVar2);
                bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                    final /* synthetic */ com.kwad.library.solder.lib.a.e amm;

                    public AnonymousClass1(com.kwad.library.solder.lib.a.e eVar22) {
                        eVar = eVar22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (eVar.yw()) {
                            i.this.amu.a(eVar, 16);
                        }
                    }
                }, eVar22.yv() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        });
        this.amu.a(r10, 16);
    }
}

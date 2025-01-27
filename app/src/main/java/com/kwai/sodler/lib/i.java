package com.kwai.sodler.lib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.j;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class i extends j {
    private static volatile i aJQ;
    private j aJR;
    private ExecutorService aJS;
    private Map<String, a> aJT;
    private volatile boolean mHasInit;

    /* renamed from: com.kwai.sodler.lib.i$1 */
    static class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-Sodler-" + this.poolNumber.getAndIncrement());
        }
    }

    /* renamed from: com.kwai.sodler.lib.i$2 */
    final class AnonymousClass2 implements Callable<com.kwai.sodler.lib.a.f> {
        final /* synthetic */ com.kwai.sodler.lib.a.f aJG;
        final /* synthetic */ j.a aJU;

        AnonymousClass2(com.kwai.sodler.lib.a.f fVar, j.a aVar) {
            fVar = fVar;
            aVar = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ju */
        public com.kwai.sodler.lib.a.f call() {
            return i.this.a(fVar, aVar);
        }
    }

    public static class a {
        private final com.kwai.sodler.lib.a.f aJW;
        private final Future<com.kwai.sodler.lib.a.f> aei;

        public a(com.kwai.sodler.lib.a.f fVar, Future<com.kwai.sodler.lib.a.f> future) {
            this.aJW = fVar;
            this.aei = future;
        }

        public final void cancel() {
            this.aJW.cancel();
            this.aei.cancel(true);
        }
    }

    private i() {
        super(null, null, null, null, null, null);
        this.mHasInit = false;
    }

    public static i Jl() {
        if (aJQ == null) {
            synchronized (i.class) {
                if (aJQ == null) {
                    aJQ = new i();
                }
            }
        }
        return aJQ;
    }

    private static ExecutorService Jm() {
        return new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwai.sodler.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            AnonymousClass1() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ksad-Sodler-" + this.poolNumber.getAndIncrement());
            }
        });
    }

    private void Jt() {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    private synchronized void a(String str, a aVar) {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        Map<String, a> f2 = j.f(this.aJT);
        this.aJT = f2;
        if (str != null) {
            f2.put(str, aVar);
        }
    }

    private a b(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull j.a aVar) {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        a fN = fN(fVar.getId());
        if (fN != null) {
            fN.cancel();
        }
        fVar.a(this);
        a aVar2 = new a(fVar, this.aJS.submit(new Callable<com.kwai.sodler.lib.a.f>() { // from class: com.kwai.sodler.lib.i.2
            final /* synthetic */ com.kwai.sodler.lib.a.f aJG;
            final /* synthetic */ j.a aJU;

            AnonymousClass2(com.kwai.sodler.lib.a.f fVar2, j.a aVar3) {
                fVar = fVar2;
                aVar = aVar3;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: Ju */
            public com.kwai.sodler.lib.a.f call() {
                return i.this.a(fVar, aVar);
            }
        }));
        a(fVar2.getId(), aVar2);
        return aVar2;
    }

    @Nullable
    private synchronized a fN(String str) {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        Map<String, a> f2 = j.f(this.aJT);
        this.aJT = f2;
        if (str == null) {
            return null;
        }
        return f2.get(str);
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.c Jn() {
        if (this.mHasInit) {
            return this.aJR.Jn();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.d Jo() {
        if (this.mHasInit) {
            return this.aJR.Jo();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.g Jp() {
        if (this.mHasInit) {
            return this.aJR.Jp();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.c Jq() {
        if (this.mHasInit) {
            return this.aJR.Jq();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.b Jr() {
        if (this.mHasInit) {
            return this.aJR.Jr();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.a Js() {
        if (this.mHasInit) {
            return this.aJR.Js();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j
    public final com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull j.a aVar) {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        com.kwai.sodler.lib.a.e JA = fVar.JA();
        j jVar = this.aJR;
        if (JA == null) {
            JA = jVar;
        }
        return jVar.a(fVar.a(JA), aVar);
    }

    public final a a(@NonNull com.kwai.sodler.lib.a.f fVar, int i2) {
        return b(fVar, j.a.a(this, 16));
    }

    public final synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        if (!this.mHasInit) {
            d dVar = new d(context);
            e eVar = new e(context);
            c cVar2 = new c(context, cVar);
            b bVar = new b();
            this.aJS = Jm();
            this.aJR = new j(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
            this.mHasInit = true;
            Jt();
        }
    }

    public final void l(@NonNull com.kwai.sodler.lib.a.f fVar) {
        a fN = fN(fVar.getId());
        if (fN != null) {
            fN.cancel();
        }
        a(fVar.getId(), (a) null);
    }
}

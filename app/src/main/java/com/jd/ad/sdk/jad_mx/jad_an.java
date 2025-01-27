package com.jd.ad.sdk.jad_mx;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.jad_mx.jad_re;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class jad_an {
    public final boolean jad_an;

    @VisibleForTesting
    public final Map<com.jd.ad.sdk.jad_ju.jad_hu, jad_cp> jad_bo;
    public final ReferenceQueue<jad_re<?>> jad_cp;
    public jad_re.jad_an jad_dq;

    /* renamed from: com.jd.ad.sdk.jad_mx.jad_an$jad_an */
    public class ThreadFactoryC0334jad_an implements ThreadFactory {

        /* renamed from: com.jd.ad.sdk.jad_mx.jad_an$jad_an$jad_an */
        public class RunnableC0335jad_an implements Runnable {
            public final /* synthetic */ Runnable jad_an;

            public RunnableC0335jad_an(ThreadFactoryC0334jad_an threadFactoryC0334jad_an, Runnable runnable) {
                this.jad_an = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.jad_an.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0335jad_an(this, runnable), "glide-active-resources");
        }
    }

    public class jad_bo implements Runnable {
        public jad_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an jad_anVar = jad_an.this;
            jad_anVar.getClass();
            while (true) {
                try {
                    jad_anVar.jad_an((jad_cp) jad_anVar.jad_cp.remove());
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @VisibleForTesting
    public static final class jad_cp extends WeakReference<jad_re<?>> {
        public final com.jd.ad.sdk.jad_ju.jad_hu jad_an;
        public final boolean jad_bo;

        @Nullable
        public jad_xk<?> jad_cp;

        public jad_cp(@NonNull com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, @NonNull jad_re<?> jad_reVar, @NonNull ReferenceQueue<? super jad_re<?>> referenceQueue, boolean z10) {
            super(jad_reVar, referenceQueue);
            this.jad_an = (com.jd.ad.sdk.jad_ju.jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
            this.jad_cp = (jad_reVar.jad_fs() && z10) ? (jad_xk) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_reVar.jad_er()) : null;
            this.jad_bo = jad_reVar.jad_fs();
        }
    }

    public jad_an(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new ThreadFactoryC0334jad_an()));
    }

    public void jad_an(@NonNull jad_cp jad_cpVar) {
        jad_xk<?> jad_xkVar;
        synchronized (this) {
            this.jad_bo.remove(jad_cpVar.jad_an);
            if (jad_cpVar.jad_bo && (jad_xkVar = jad_cpVar.jad_cp) != null) {
                this.jad_dq.jad_an(jad_cpVar.jad_an, new jad_re<>(jad_xkVar, true, false, jad_cpVar.jad_an, this.jad_dq));
            }
        }
    }

    @VisibleForTesting
    public jad_an(boolean z10, Executor executor) {
        this.jad_bo = new HashMap();
        this.jad_cp = new ReferenceQueue<>();
        this.jad_an = z10;
        executor.execute(new jad_bo());
    }

    public void jad_an(jad_re.jad_an jad_anVar) {
        synchronized (jad_anVar) {
            synchronized (this) {
                this.jad_dq = jad_anVar;
            }
        }
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, jad_re<?> jad_reVar) {
        jad_cp put = this.jad_bo.put(jad_huVar, new jad_cp(jad_huVar, jad_reVar, this.jad_cp, this.jad_an));
        if (put != null) {
            put.jad_cp = null;
            put.clear();
        }
    }
}

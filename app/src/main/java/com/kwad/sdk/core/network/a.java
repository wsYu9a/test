package com.kwad.sdk.core.network;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class a<R extends g> {
    private static final ExecutorService sExecutors = GlobalThreadPools.xR();
    private Future<?> mTask;

    /* renamed from: com.kwad.sdk.core.network.a$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.fetchImpl();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }

    @CallSuper
    protected void cancel() {
        Future<?> future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }

    @NonNull
    protected abstract R createRequest();

    protected void fetch() {
        try {
            this.mTask = getExecutor().submit(new Runnable() { // from class: com.kwad.sdk.core.network.a.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.fetchImpl();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    @WorkerThread
    protected abstract void fetchImpl();

    protected ExecutorService getExecutor() {
        return sExecutors;
    }

    protected abstract void onResponse(R r, c cVar);
}

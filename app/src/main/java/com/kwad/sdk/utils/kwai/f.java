package com.kwad.sdk.utils.kwai;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class f implements Executor {
    private Runnable aCD;
    private Runnable aCE;

    /* renamed from: com.kwad.sdk.utils.kwai.f$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable aCF;

        AnonymousClass1(Runnable runnable) {
            runnable = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                runnable.run();
            } finally {
                f.this.scheduleNext();
            }
        }
    }

    private Runnable c(Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.kwai.f.1
            final /* synthetic */ Runnable aCF;

            AnonymousClass1(Runnable runnable2) {
                runnable = runnable2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    public synchronized void scheduleNext() {
        Runnable runnable = this.aCE;
        this.aCD = runnable;
        this.aCE = null;
        if (runnable != null) {
            d.getExecutor().execute(this.aCD);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.aCD == null) {
            this.aCD = c(runnable);
            d.getExecutor().execute(this.aCD);
        } else {
            if (this.aCE == null) {
                this.aCE = c(runnable);
            }
        }
    }
}

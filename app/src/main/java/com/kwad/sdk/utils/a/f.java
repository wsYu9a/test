package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class f implements Executor {
    private Runnable aWM;
    private Runnable aWN;

    /* renamed from: com.kwad.sdk.utils.a.f$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable aWO;

        public AnonymousClass1(Runnable runnable) {
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

    private Runnable d(Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            final /* synthetic */ Runnable aWO;

            public AnonymousClass1(Runnable runnable2) {
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
        Runnable runnable = this.aWN;
        this.aWM = runnable;
        this.aWN = null;
        if (runnable != null) {
            d.getExecutor().execute(this.aWM);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.aWM == null) {
            this.aWM = d(runnable);
            d.getExecutor().execute(this.aWM);
        } else {
            if (this.aWN == null) {
                this.aWN = d(runnable);
            }
        }
    }
}

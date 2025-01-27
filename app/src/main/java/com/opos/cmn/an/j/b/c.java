package com.opos.cmn.an.j.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class c implements Executor {

    /* renamed from: a */
    private Handler f16588a = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.cmn.an.j.b.c$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f16589a;

        AnonymousClass1(Runnable runnable) {
            runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            runnable.run();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f16588a.post(new Runnable() { // from class: com.opos.cmn.an.j.b.c.1

                /* renamed from: a */
                final /* synthetic */ Runnable f16589a;

                AnonymousClass1(Runnable runnable2) {
                    runnable = runnable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }
}

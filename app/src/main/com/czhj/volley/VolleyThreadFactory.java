package com.czhj.volley;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
class VolleyThreadFactory implements ThreadFactory {

    /* renamed from: com.czhj.volley.VolleyThreadFactory$1 */
    public class AnonymousClass1 extends Thread {
        public AnonymousClass1(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        VolleyLog.d("Volley ThreadFactor create ,current thread num :" + Thread.activeCount(), new Object[0]);
        return new Thread(runnable) { // from class: com.czhj.volley.VolleyThreadFactory.1
            public AnonymousClass1(Runnable runnable2) {
                super(runnable2);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
            }
        };
    }
}

package com.czhj.sdk.common.ThreadPool;

import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public class BackgroundThreadFactory implements ThreadFactory {

    /* renamed from: com.czhj.sdk.common.ThreadPool.BackgroundThreadFactory$1 */
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
        SigmobLog.d("ThreadFactor create ,current thread num :" + Thread.activeCount());
        return new Thread(runnable) { // from class: com.czhj.sdk.common.ThreadPool.BackgroundThreadFactory.1
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

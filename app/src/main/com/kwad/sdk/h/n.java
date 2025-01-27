package com.kwad.sdk.h;

/* loaded from: classes3.dex */
abstract class n implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            doTask();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}

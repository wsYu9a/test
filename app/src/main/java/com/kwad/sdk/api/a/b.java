package com.kwad.sdk.api.a;

import com.kwad.sdk.api.c;

/* loaded from: classes3.dex */
public abstract class b implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public void run() {
        try {
            doTask();
        } catch (Throwable th2) {
            c.m(th2);
        }
    }
}

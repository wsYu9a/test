package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public abstract class v6 implements Runnable {
    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            String str = "" + th.getMessage();
        }
    }
}

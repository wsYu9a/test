package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class bm extends Handler {
    private WeakReference<a> aBC;

    public interface a {
        void a(Message message);
    }

    public bm(a aVar) {
        this.aBC = new WeakReference<>(aVar);
    }

    public bm(a aVar, Looper looper) {
        super(looper);
        this.aBC = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference<a> weakReference;
        a aVar;
        try {
            weakReference = this.aBC;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}

package com.ss.android.downloadlib.lg;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class p extends Handler {

    /* renamed from: j */
    WeakReference<j> f24335j;

    public interface j {
        void j(Message message);
    }

    public p(Looper looper, j jVar) {
        super(looper);
        this.f24335j = new WeakReference<>(jVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar = this.f24335j.get();
        if (jVar == null || message == null) {
            return;
        }
        jVar.j(message);
    }
}

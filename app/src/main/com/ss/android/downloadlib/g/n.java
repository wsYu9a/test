package com.ss.android.downloadlib.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class n extends Handler {

    /* renamed from: a */
    WeakReference<a> f21672a;

    public interface a {
        void a(Message message);
    }

    public n(Looper looper, a aVar) {
        super(looper);
        this.f21672a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f21672a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}

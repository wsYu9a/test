package com.vivo.ic.dm.q;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.vivo.ic.VLog;

/* loaded from: classes4.dex */
class a extends Handler {

    /* renamed from: a */
    private static final String f28604a = "AutoFinishHandler";

    /* renamed from: b */
    private static final boolean f28605b = true;

    /* renamed from: c */
    private static final int f28606c = 10000;

    /* renamed from: d */
    private static final int f28607d = -27;

    /* renamed from: e */
    private final String f28608e;

    /* renamed from: f */
    private boolean f28609f;

    /* renamed from: g */
    private long f28610g;

    a(String str, Looper looper) {
        super(looper);
        this.f28609f = false;
        this.f28610g = -1L;
        this.f28608e = str;
        a("create handler");
    }

    private void a() {
        if (this.f28609f) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.f28610g;
        a("autoRemoveSelf " + uptimeMillis + "ms");
        if (uptimeMillis >= 0) {
            removeMessages(f28607d);
            sendEmptyMessageDelayed(f28607d, 10000L);
        }
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        a("dispatchMessage msg:" + message.what);
        super.dispatchMessage(message);
        a();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a("handleMessage msg:" + message.what);
        if (message.what != f28607d) {
            super.handleMessage(message);
            return;
        }
        d.b().b(this.f28608e);
        removeMessages(f28607d);
        this.f28609f = true;
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(Message message, long j2) {
        a("sendMessageAtTime msg:" + message.what);
        if (message.what != f28607d && this.f28610g < j2) {
            this.f28610g = j2;
            removeMessages(f28607d);
        }
        return super.sendMessageAtTime(message, j2);
    }

    private void a(String str) {
        VLog.d(f28604a, this.f28608e + " " + str);
    }
}

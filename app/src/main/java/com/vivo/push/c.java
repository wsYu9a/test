package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class c implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ b f24961a;

    public c(b bVar) {
        this.f24961a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.p.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i10 = message.what;
        if (i10 == 1) {
            com.vivo.push.util.p.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.f24961a.f24910f;
            if (atomicInteger.get() == 2) {
                this.f24961a.a(1);
            }
        } else if (i10 != 2) {
            com.vivo.push.util.p.b("AidlManager", "unknow msg what [" + message.what + "]");
        } else {
            atomicInteger2 = this.f24961a.f24910f;
            if (atomicInteger2.get() == 4) {
                this.f24961a.f();
            }
            this.f24961a.a(1);
        }
        return true;
    }
}

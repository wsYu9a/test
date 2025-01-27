package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay;

/* loaded from: classes.dex */
final class h implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ g f5467a;

    h(g gVar) {
        this.f5467a = gVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        Object obj2;
        obj = this.f5467a.f5463d;
        synchronized (obj) {
            this.f5467a.f5462c = IAlixPay.Stub.asInterface(iBinder);
            obj2 = this.f5467a.f5463d;
            obj2.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5467a.f5462c = null;
    }
}

package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.heytap.mcssdk.o.e;

/* loaded from: classes.dex */
final class i implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ Intent f8891a;

    /* renamed from: b */
    final /* synthetic */ a f8892b;

    i(a aVar, Intent intent) {
        this.f8892b = aVar;
        this.f8891a = intent;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context context;
        Bundle bundle = new Bundle();
        bundle.putAll(this.f8891a.getExtras());
        try {
            b.e.a.b.b(iBinder).a(bundle);
        } catch (Exception e2) {
            e.a("bindMcsService exception:" + e2);
        }
        context = this.f8892b.N;
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}

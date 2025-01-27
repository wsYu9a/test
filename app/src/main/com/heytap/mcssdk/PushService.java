package com.heytap.mcssdk;

import a7.a;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import b7.b;
import b7.h;
import c7.e;
import x6.c;

/* loaded from: classes2.dex */
public class PushService extends Service implements a {
    @Override // a7.a
    public void a(Context context, b bVar) {
        e.a("mcssdk-processMessage:" + bVar.j());
        c.b(getApplicationContext(), bVar, x6.b.c0());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        c.c(getApplicationContext(), intent, this);
        return super.onStartCommand(intent, i10, i11);
    }

    @Override // a7.a
    public void b(Context context, b7.a aVar) {
    }

    @Override // a7.a
    public void c(Context context, h hVar) {
    }
}

package com.heytap.mcssdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.n.h;
import com.heytap.mcssdk.o.e;

/* loaded from: classes.dex */
public class AppPushService extends Service implements com.heytap.mcssdk.h.a {
    @Override // com.heytap.mcssdk.h.a
    public void a(Context context, com.heytap.mcssdk.n.b bVar) {
        e.a("mcssdk-processMessage:" + bVar.j());
        b.a(getApplicationContext(), bVar, a.c0());
    }

    @Override // com.heytap.mcssdk.h.a
    public void b(Context context, com.heytap.mcssdk.n.a aVar) {
    }

    @Override // com.heytap.mcssdk.h.a
    public void c(Context context, h hVar) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        b.c(getApplicationContext(), intent, this);
        return super.onStartCommand(intent, i2, i3);
    }
}

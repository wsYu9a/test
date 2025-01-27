package com.vivo.mobilead.e.a.h;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes4.dex */
class g implements ServiceConnection {

    /* renamed from: a */
    private final Context f28787a;

    /* renamed from: b */
    private final com.vivo.mobilead.e.a.b f28788b;

    /* renamed from: c */
    private final a f28789c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws com.vivo.mobilead.e.a.d, RemoteException;
    }

    private g(Context context, com.vivo.mobilead.e.a.b bVar, a aVar) {
        if (context instanceof Application) {
            this.f28787a = context;
        } else {
            this.f28787a = context.getApplicationContext();
        }
        this.f28788b = bVar;
        this.f28789c = aVar;
    }

    public static void a(Context context, Intent intent, com.vivo.mobilead.e.a.b bVar, a aVar) {
        new g(context, bVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.vivo.mobilead.e.a.e.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                String a2 = this.f28789c.a(iBinder);
                if (a2 == null || a2.length() == 0) {
                    throw new com.vivo.mobilead.e.a.d("OAID/AAID acquire failed");
                }
                com.vivo.mobilead.e.a.e.a("OAID/AAID acquire success: " + a2);
                this.f28788b.a(a2);
                try {
                    this.f28787a.unbindService(this);
                    com.vivo.mobilead.e.a.e.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e2) {
                    com.vivo.mobilead.e.a.e.a(e2);
                }
            } catch (Exception e3) {
                com.vivo.mobilead.e.a.e.a(e3);
                this.f28788b.a(e3);
                try {
                    this.f28787a.unbindService(this);
                    com.vivo.mobilead.e.a.e.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e4) {
                    com.vivo.mobilead.e.a.e.a(e4);
                }
            }
        } catch (Throwable th) {
            try {
                this.f28787a.unbindService(this);
                com.vivo.mobilead.e.a.e.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e5) {
                com.vivo.mobilead.e.a.e.a(e5);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.vivo.mobilead.e.a.e.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (!this.f28787a.bindService(intent, this, 1)) {
                throw new com.vivo.mobilead.e.a.d("Service binding failed");
            }
            com.vivo.mobilead.e.a.e.a("Service has been bound: " + intent);
        } catch (Exception e2) {
            this.f28788b.a(e2);
        }
    }
}

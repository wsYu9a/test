package com.tanx.onlyid.api.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import ug.c;
import ug.e;

/* loaded from: classes4.dex */
public class b implements ServiceConnection {

    /* renamed from: b */
    public final Context f22034b;

    /* renamed from: c */
    public final c f22035c;

    /* renamed from: d */
    public final a f22036d;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public b(Context context, c cVar, a aVar) {
        if (context instanceof Application) {
            this.f22034b = context;
        } else {
            this.f22034b = context.getApplicationContext();
        }
        this.f22035c = cVar;
        this.f22036d = aVar;
    }

    public static void a(Context context, Intent intent, c cVar, a aVar) {
        new b(context, cVar, aVar).b(intent);
    }

    public final void b(Intent intent) {
        try {
            if (!this.f22034b.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            e.b("Service has been bound: " + intent);
        } catch (Exception e10) {
            this.f22035c.oaidError(e10);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String a10;
        e.b("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    a10 = this.f22036d.a(iBinder);
                } catch (Exception e10) {
                    e.b(e10);
                    this.f22035c.oaidError(e10);
                    this.f22034b.unbindService(this);
                    e.b("Service has been unbound: " + componentName.getClassName());
                }
                if (a10 == null || a10.length() == 0) {
                    throw new OAIDException("OAID/AAID acquire failed");
                }
                e.b("OAID/AAID acquire success: " + a10);
                this.f22035c.oaidSucc(a10);
                this.f22034b.unbindService(this);
                e.b("Service has been unbound: " + componentName.getClassName());
            } catch (Throwable th2) {
                try {
                    this.f22034b.unbindService(this);
                    e.b("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e11) {
                    e.b(e11);
                }
                throw th2;
            }
        } catch (Exception e12) {
            e.b(e12);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        e.b("Service has been disconnected: " + componentName.getClassName());
    }
}

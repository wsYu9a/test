package com.czhj.devicehelper.oaId.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.devicehelper.oaId.interfaces.c;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a */
    public Context f8316a;

    /* renamed from: b */
    public com.czhj.devicehelper.oaId.interfaces.c f8317b;

    /* renamed from: c */
    public final LinkedBlockingQueue<IBinder> f8318c = new LinkedBlockingQueue<>(1);

    /* renamed from: d */
    public ServiceConnection f8319d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.f8318c.put(iBinder);
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public d(Context context) {
        this.f8316a = context;
    }

    public void a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (a()) {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f8316a.bindService(intent, this.f8319d, 1)) {
                try {
                    c.a.C0247a c0247a = new c.a.C0247a(this.f8318c.take());
                    this.f8317b = c0247a;
                    String g10 = c0247a.g();
                    if (appIdsUpdater != null) {
                        appIdsUpdater.OnIdsAvalid(g10);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }

    public final boolean a() {
        try {
            return this.f8316a.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}

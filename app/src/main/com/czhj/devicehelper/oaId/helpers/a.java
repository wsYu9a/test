package com.czhj.devicehelper.oaId.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.devicehelper.oaId.interfaces.a;
import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    public Context f8296a;

    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f8297b = new LinkedBlockingQueue<>(1);

    /* renamed from: c */
    public ServiceConnection f8298c = new ServiceConnectionC0244a();

    /* renamed from: com.czhj.devicehelper.oaId.helpers.a$a */
    public class ServiceConnectionC0244a implements ServiceConnection {
        public ServiceConnectionC0244a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.f8297b.put(iBinder);
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public a(Context context) {
        this.f8296a = context;
    }

    public void a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (a()) {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.f8296a.bindService(intent, this.f8298c, 1)) {
                try {
                    try {
                        String a10 = new a.C0246a(this.f8297b.take()).a();
                        if (appIdsUpdater != null) {
                            appIdsUpdater.OnIdsAvalid(a10);
                        }
                    } catch (Exception e10) {
                        SigmobLog.e(e10.getMessage());
                    }
                } finally {
                    this.f8296a.unbindService(this.f8298c);
                }
            }
        }
    }

    public boolean a() {
        try {
            return this.f8296a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}

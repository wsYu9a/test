package com.czhj.devicehelper.oaId.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.devicehelper.oaId.interfaces.f;
import com.czhj.sdk.logger.SigmobLog;
import com.shu.priory.config.AdKeys;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a */
    public Context f8337a;

    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f8338b = new LinkedBlockingQueue<>(1);

    /* renamed from: c */
    public ServiceConnection f8339c = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(AdKeys.OAID, "oaid onServiceConnected() called with: name = [" + componentName + "], service = [" + iBinder + "]");
            try {
                i.this.f8338b.put(iBinder);
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public i(Context context) {
        this.f8337a = context;
    }

    public void a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (a()) {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            try {
                if (this.f8337a.bindService(intent, this.f8339c, 1)) {
                    try {
                        String a10 = new f.a(this.f8338b.take()).a();
                        if (appIdsUpdater != null) {
                            appIdsUpdater.OnIdsAvalid(a10);
                        }
                    } catch (Exception e10) {
                        SigmobLog.e(e10.getMessage());
                    }
                }
            } finally {
                this.f8337a.unbindService(this.f8339c);
            }
        }
    }

    public boolean a() {
        try {
            return this.f8337a.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}

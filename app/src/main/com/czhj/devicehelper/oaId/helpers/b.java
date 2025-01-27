package com.czhj.devicehelper.oaId.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a */
    public Context f8300a;

    /* renamed from: b */
    public final Handler f8301b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    public final LinkedBlockingQueue<IBinder> f8302c = new LinkedBlockingQueue<>(1);

    /* renamed from: d */
    public ServiceConnection f8303d = new ServiceConnectionC0245b();

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ DevicesIDsHelper.AppIdsUpdater f8304a;

        /* renamed from: b */
        public final /* synthetic */ Object f8305b;

        public a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater, Object obj) {
            this.f8304a = appIdsUpdater;
            this.f8305b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8304a != null) {
                try {
                    Object obj = this.f8305b.getClass().getField("id").get(this.f8305b);
                    if (obj instanceof String) {
                        this.f8304a.OnIdsAvalid((String) obj);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.czhj.devicehelper.oaId.helpers.b$b */
    public class ServiceConnectionC0245b implements ServiceConnection {
        public ServiceConnectionC0245b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f8302c.put(iBinder);
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public b(Context context) {
        this.f8300a = context;
    }

    public void a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (!a()) {
            SigmobLog.e("HIDeviceIDHelper not Support");
            return;
        }
        try {
            Object invoke = Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.f8300a);
            if (invoke == null) {
                SigmobLog.e("HIDeviceIDHelper info is null");
            } else {
                this.f8301b.post(new a(appIdsUpdater, invoke));
            }
        } catch (Throwable th2) {
            SigmobLog.e("HIDeviceIDHelper error ", th2);
        }
    }

    public boolean a() {
        try {
            Object invoke = Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient").getMethod("isAdvertisingIdAvailable", Context.class).invoke(null, this.f8300a);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}

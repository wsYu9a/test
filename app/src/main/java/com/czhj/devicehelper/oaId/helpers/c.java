package com.czhj.devicehelper.oaId.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.devicehelper.oaId.interfaces.b;
import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    public Context f8308a;

    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f8309b = new LinkedBlockingQueue<>(1);

    /* renamed from: c */
    public Handler f8310c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    public ServiceConnection f8311d = new b();

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ DevicesIDsHelper.AppIdsUpdater f8312a;

        /* renamed from: b */
        public final /* synthetic */ Object f8313b;

        public a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater, Object obj) {
            this.f8312a = appIdsUpdater;
            this.f8313b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8312a != null) {
                try {
                    Object invoke = this.f8313b.getClass().getDeclaredMethod("getId", null).invoke(this.f8313b, null);
                    if (invoke instanceof String) {
                        this.f8312a.OnIdsAvalid((String) invoke);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.f8309b.put(iBinder);
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public c(Context context) {
        this.f8308a = context;
    }

    public void a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (!a()) {
            SigmobLog.e("HWDeviceIDHelper not Support");
            return;
        }
        String str = null;
        try {
            try {
                Object invoke = Class.forName("com.huawei.hms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.f8308a);
                if (invoke != null) {
                    this.f8310c.post(new a(appIdsUpdater, invoke));
                    return;
                }
                SigmobLog.e("HWDeviceIDHelper info is null");
                String[] strArr = {"com.huawei.hwid", "com.huawei.hwid.tv", "com.huawei.hms"};
                String str2 = null;
                for (int i10 = 0; i10 < 3; i10++) {
                    String str3 = strArr[i10];
                    if (!TextUtils.isEmpty(str2)) {
                        if (appIdsUpdater != null) {
                            appIdsUpdater.OnIdsAvalid(str2);
                            return;
                        }
                        return;
                    }
                    str2 = a(str3);
                }
            } catch (Throwable th2) {
                SigmobLog.e("HWDeviceIDHelper error ", th2);
            }
        } catch (Throwable unused) {
            SigmobLog.e("HWDeviceIDHelper error, will retry");
            String[] strArr2 = {"com.huawei.hwid", "com.huawei.hwid.tv", "com.huawei.hms"};
            for (int i11 = 0; i11 < 3; i11++) {
                String str4 = strArr2[i11];
                if (!TextUtils.isEmpty(str)) {
                    if (appIdsUpdater != null) {
                        appIdsUpdater.OnIdsAvalid(str);
                        return;
                    }
                    return;
                }
                str = a(str4);
            }
        }
    }

    public boolean a() {
        PackageManager packageManager;
        try {
            Object invoke = Class.forName("com.huawei.hms.ads.identifier.AdvertisingIdClient").getMethod("isAdvertisingIdAvailable", Context.class).invoke(null, this.f8308a);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
        } catch (Throwable th2) {
            SigmobLog.e("hw oaid support", th2);
        }
        try {
            packageManager = this.f8308a.getPackageManager();
        } catch (Throwable unused) {
        }
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
            return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
        }
        return true;
    }

    public final String a(String str) {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(str);
        try {
            if (this.f8308a.bindService(intent, this.f8311d, 1)) {
                return new b.a(this.f8309b.take(), this.f8308a).i();
            }
            return null;
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
            return null;
        } finally {
            this.f8308a.unbindService(this.f8311d);
        }
    }
}

package com.czhj.devicehelper.oaId.helpers;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.devicehelper.oaId.interfaces.e;
import com.czhj.sdk.logger.SigmobLog;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a */
    public Context f8330a;

    /* renamed from: c */
    public String f8332c;

    /* renamed from: d */
    public com.czhj.devicehelper.oaId.interfaces.e f8333d;

    /* renamed from: b */
    public String f8331b = "OUID";

    /* renamed from: e */
    public final LinkedBlockingQueue<IBinder> f8334e = new LinkedBlockingQueue<>(1);

    /* renamed from: f */
    public ServiceConnection f8335f = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                h.this.f8334e.put(iBinder);
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h.this.f8333d = null;
        }
    }

    public h(Context context) {
        this.f8330a = context;
    }

    public void a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (a() && Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f8330a.bindService(intent, this.f8335f, 1)) {
                try {
                    com.czhj.devicehelper.oaId.interfaces.e a10 = e.a.a(this.f8334e.take());
                    this.f8333d = a10;
                    if (a10 != null) {
                        String a11 = a("OUID");
                        if (appIdsUpdater != null) {
                            appIdsUpdater.OnIdsAvalid(a11);
                        }
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
            PackageInfo packageInfo = this.f8330a.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo == null) {
                return false;
            }
            return (Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1;
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
            return false;
        }
    }

    @SuppressLint({"WrongConstant"})
    public final String a(String str) {
        Signature[] signatureArr;
        String packageName = this.f8330a.getPackageName();
        if (this.f8332c == null) {
            String str2 = null;
            try {
                signatureArr = this.f8330a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b10 : digest) {
                            sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb2.toString();
                    }
                } catch (Exception e11) {
                    SigmobLog.e(e11.getMessage());
                }
            }
            this.f8332c = str2;
        }
        return ((e.a.C0249a) this.f8333d).a(packageName, this.f8332c, str);
    }
}

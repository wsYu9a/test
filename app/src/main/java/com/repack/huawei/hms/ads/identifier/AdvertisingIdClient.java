package com.repack.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import hh.b;
import ih.a;
import java.io.IOException;

@Keep
/* loaded from: classes3.dex */
public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    @Keep
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z10) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z10;
        }

        @Keep
        public final String getId() {
            return this.advertisingId;
        }

        @Keep
        public final boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    /* renamed from: com.repack.huawei.hms.ads.identifier.AdvertisingIdClient$do */
    public static class Cdo implements Runnable {

        /* renamed from: b */
        public final Context f16634b;

        public Cdo(Context context) {
            this.f16634b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.f16634b);
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
                String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    updateAdvertisingIdInfo(context);
                    return new Info(string, Boolean.valueOf(string2).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return requestAdvertisingIdInfo(context);
    }

    @Keep
    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid");
            return !r4.queryIntentServices(r2, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static Info requestAdvertisingIdInfo(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            b bVar = new b();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (!context.bindService(intent, bVar, 1)) {
                throw new IOException("bind failed");
            }
            try {
                if (bVar.f26732b) {
                    throw new IllegalStateException();
                }
                bVar.f26732b = true;
                a aVar = new a(bVar.f26733c.take());
                Info info = new Info(aVar.j(), aVar.k());
                try {
                    context.unbindService(bVar);
                } catch (Throwable th2) {
                    Log.w("AdIdClient", "unbind " + th2.getClass().getSimpleName());
                }
                return info;
            } catch (RemoteException unused) {
                throw new IOException("bind hms service RemoteException");
            } catch (InterruptedException unused2) {
                throw new IOException("bind hms service InterruptedException");
            } catch (Throwable th3) {
                try {
                    context.unbindService(bVar);
                } catch (Throwable th4) {
                    Log.w("AdIdClient", "unbind " + th4.getClass().getSimpleName());
                }
                throw th3;
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Service not found");
        }
    }

    private static void updateAdvertisingIdInfo(Context context) {
        hh.a.f26730a.execute(new Cdo(context));
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z10) {
        Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
        if (requestAdvertisingIdInfo != null) {
            return TextUtils.equals(str, requestAdvertisingIdInfo.getId()) && z10 == requestAdvertisingIdInfo.isLimitAdTrackingEnabled();
        }
        Log.w("AdIdClient", "info is null");
        return false;
    }
}

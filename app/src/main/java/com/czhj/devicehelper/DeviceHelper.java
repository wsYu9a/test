package com.czhj.devicehelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.sdk.logger.SigmobLog;
import com.shu.priory.config.AdKeys;

/* loaded from: classes2.dex */
public final class DeviceHelper {

    /* renamed from: a */
    public static final String f8253a = "getSimState";

    /* renamed from: b */
    public static final String f8254b = "getImei";

    /* renamed from: c */
    public static final String f8255c = "getLine1Number";

    /* renamed from: d */
    public static String f8256d = null;

    /* renamed from: e */
    public static String f8257e = null;

    /* renamed from: f */
    public static String f8258f = null;

    /* renamed from: g */
    public static String f8259g = "";

    /* renamed from: h */
    public static long f8260h = 0;

    /* renamed from: i */
    public static long f8261i = 0;

    /* renamed from: j */
    public static Handler f8262j = null;

    /* renamed from: k */
    public static Handler f8263k = null;

    /* renamed from: l */
    public static int f8264l = 0;

    /* renamed from: m */
    public static boolean f8265m = false;

    /* renamed from: n */
    public static String f8266n;

    /* renamed from: o */
    public static String f8267o;

    /* renamed from: p */
    public static String f8268p;

    /* renamed from: q */
    public static Thread f8269q;

    /* renamed from: r */
    public static Thread f8270r;

    /* renamed from: s */
    public static boolean f8271s;

    /* renamed from: t */
    public static int f8272t;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f8273a;

        /* renamed from: b */
        public final /* synthetic */ DevicesIDsHelper.AppIdsUpdater f8274b;

        /* renamed from: com.czhj.devicehelper.DeviceHelper$a$a */
        public class C0242a implements DevicesIDsHelper.AppIdsUpdater {
            public C0242a() {
            }

            @Override // com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.AppIdsUpdater
            public void OnIdsAvalid(String str) {
                boolean unused = DeviceHelper.f8265m = false;
                if (!TextUtils.isEmpty(str)) {
                    String unused2 = DeviceHelper.f8259g = str;
                    DevicesIDsHelper.AppIdsUpdater appIdsUpdater = a.this.f8274b;
                    if (appIdsUpdater != null) {
                        appIdsUpdater.OnIdsAvalid(DeviceHelper.f8259g);
                    }
                }
                Log.d(AdKeys.OAID, "oaid_src: " + str);
                Thread unused3 = DeviceHelper.f8269q = null;
            }
        }

        public a(Context context, DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
            this.f8273a = context;
            this.f8274b = appIdsUpdater;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DevicesIDsHelper devicesIDsHelper = new DevicesIDsHelper();
                SigmobLog.d("private  getOAID_API");
                devicesIDsHelper.b(this.f8273a, new C0242a());
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f8276a;

        /* renamed from: b */
        public final /* synthetic */ DevicesIDsHelper.AppIdsUpdater f8277b;

        public class a implements DevicesIDsHelper.AppIdsUpdater {
            public a() {
            }

            @Override // com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.AppIdsUpdater
            public void OnIdsAvalid(String str) {
                String unused = DeviceHelper.f8256d = str;
                DevicesIDsHelper.AppIdsUpdater appIdsUpdater = b.this.f8277b;
                if (appIdsUpdater != null) {
                    appIdsUpdater.OnIdsAvalid(str);
                }
                boolean unused2 = DeviceHelper.f8271s = false;
                if (DeviceHelper.f8262j != null) {
                    Handler unused3 = DeviceHelper.f8262j = null;
                }
            }
        }

        public b(Context context, DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
            this.f8276a = context;
            this.f8277b = appIdsUpdater;
        }

        @Override // java.lang.Runnable
        public void run() {
            SigmobLog.d("private  getOAID");
            DevicesIDsHelper.a(this.f8276a, new a());
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager;
        String deviceId;
        String meid;
        try {
            SigmobLog.d("private :getIMEI");
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
        if (telephonyManager == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            deviceId = telephonyManager.getImei();
            if (TextUtils.isEmpty(deviceId)) {
                try {
                    return telephonyManager.getDeviceId();
                } catch (Throwable unused2) {
                    meid = telephonyManager.getMeid();
                    return meid;
                }
            }
        } else {
            deviceId = telephonyManager.getDeviceId();
        }
        if (deviceId != null) {
            return deviceId;
        }
        return null;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMSI(Context context) {
        return null;
    }

    public static String getMacAddress() {
        return "";
    }

    public static void getOAID(Context context, DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (!TextUtils.isEmpty(f8256d)) {
            if (appIdsUpdater != null) {
                appIdsUpdater.OnIdsAvalid(f8257e);
                return;
            }
            return;
        }
        if (f8272t > 10) {
            if (appIdsUpdater != null) {
                appIdsUpdater.OnIdsAvalid("");
                return;
            }
            return;
        }
        f8260h = System.currentTimeMillis();
        if (f8270r == null) {
            Log.d("", "Thread create ,current thread num :" + Thread.activeCount());
            Thread thread = new Thread(new b(context, appIdsUpdater));
            f8270r = thread;
            thread.start();
            f8272t++;
            f8271s = true;
        }
    }

    public static void getOAID_API(Context context, DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (!TextUtils.isEmpty(f8259g)) {
            if (appIdsUpdater != null) {
                appIdsUpdater.OnIdsAvalid(f8259g);
                return;
            }
            return;
        }
        if (f8264l > 10 || f8265m || System.currentTimeMillis() - f8261i < 1000) {
            if (appIdsUpdater != null) {
                appIdsUpdater.OnIdsAvalid("");
                return;
            }
            return;
        }
        f8261i = System.currentTimeMillis();
        if (f8269q == null) {
            Log.d("", "Thread create ,current thread num :" + Thread.activeCount());
            Thread thread = new Thread(new a(context, appIdsUpdater));
            f8269q = thread;
            thread.start();
        }
        f8264l++;
        f8265m = true;
    }

    public static String getVAID() {
        return f8258f;
    }

    @SuppressLint({"MissingPermission"})
    public static String getWifiName(Context context) {
        return f8266n;
    }

    @SuppressLint({"MissingPermission"})
    public static String getWifimac(Context context) {
        return "";
    }

    @SuppressLint({"MissingPermission"})
    public static String getIMEI(Context context, int i10) {
        TelephonyManager telephonyManager;
        String deviceId;
        String meid;
        String deviceId2;
        try {
            SigmobLog.d("private :getIMEI " + i10);
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
        if (telephonyManager == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            deviceId = telephonyManager.getImei(i10);
            if (TextUtils.isEmpty(deviceId)) {
                try {
                    deviceId2 = telephonyManager.getDeviceId(i10);
                    return deviceId2;
                } catch (Throwable unused2) {
                    meid = telephonyManager.getMeid(i10);
                    return meid;
                }
            }
        } else {
            deviceId = telephonyManager.getDeviceId();
        }
        if (deviceId != null) {
            return deviceId;
        }
        return null;
    }
}

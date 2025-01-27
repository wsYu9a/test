package b.c.a.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
class i {

    /* renamed from: a */
    private static String f4332a = "colorGetImei";

    /* renamed from: b */
    private static String f4333b;

    /* renamed from: c */
    private static boolean f4334c;

    /* renamed from: d */
    private static String f4335d;

    /* renamed from: e */
    private static boolean f4336e;

    /* renamed from: f */
    private static volatile String f4337f;

    /* renamed from: g */
    private static volatile boolean f4338g;

    /* renamed from: h */
    private static String f4339h;

    /* renamed from: i */
    private static boolean f4340i;

    i() {
    }

    static String a() {
        return "android.telephony." + m.c("Q29sb3JPUw==") + "TelephonyManager";
    }

    @SuppressLint({"MissingPermission"})
    static h b(Context context) {
        if (f4336e) {
            return new h(f4335d, g.f4320a);
        }
        int i2 = g.f4322c;
        try {
            if (b.f4296b) {
                b.a("try get imei below O ...");
            }
            if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f9318c) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                f4336e = true;
                String deviceId = telephonyManager.getDeviceId();
                f4335d = deviceId;
                i2 = TextUtils.isEmpty(deviceId) ? g.f4321b : g.f4323d;
            } else if (b.f4296b) {
                b.a("permission is denied, cannot get imei");
            }
        } catch (Exception e2) {
            if (b.f4296b) {
                b.a("get device id below AndroidO with exception is " + e2.toString());
            }
        }
        return new h(f4335d, i2);
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(26)
    static h c(Context context) {
        if (f4338g) {
            return new h(f4337f, g.f4320a);
        }
        int i2 = g.f4322c;
        try {
            if (b.f4296b) {
                b.a("try get imei on AndroidO...");
            }
            if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f9318c) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String str = null;
                try {
                    str = telephonyManager.getImei(0);
                } catch (Exception unused) {
                }
                if (TextUtils.isEmpty(str)) {
                    str = telephonyManager.getMeid(0);
                }
                f4338g = true;
                f4337f = str;
                i2 = TextUtils.isEmpty(str) ? g.f4321b : g.f4323d;
            } else if (b.f4296b) {
                b.a("permission is denied, cannot get imei");
            }
        } catch (Exception e2) {
            if (b.f4296b) {
                b.a("get imei on AndroidO with exception is: " + e2.toString());
            }
        }
        return new h(f4337f, i2);
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(28)
    static h d(Context context) {
        if (f4340i) {
            return new h(f4339h, g.f4320a);
        }
        int i2 = g.f4322c;
        try {
            if (b.f4296b) {
                b.a("try get imei on P...");
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String str = null;
                try {
                    str = telephonyManager.getImei(0);
                } catch (Exception unused) {
                }
                if (TextUtils.isEmpty(str)) {
                    str = telephonyManager.getMeid(0);
                }
                f4340i = true;
                f4339h = str;
                i2 = TextUtils.isEmpty(str) ? g.f4321b : g.f4323d;
            } else if (b.f4296b) {
                b.a("permission is denied, cannot get imei");
            }
        } catch (Exception e2) {
            if (b.f4296b) {
                b.a("get imei on AndroidP with exception is: " + e2.toString());
            }
        }
        return new h(f4339h, i2);
    }

    private static boolean e(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(com.kuaishou.weapon.p0.g.f9318c) != 0) {
                return false;
            }
        } else if (b.c.a.a.b.d(context, com.kuaishou.weapon.p0.g.f9318c) != 0) {
            return false;
        }
        return true;
    }

    static h f(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return new h(null, g.k);
        }
        if (f4334c) {
            return new h(f4333b, g.f4320a);
        }
        if (!e(context)) {
            if (b.f4296b) {
                b.a("don't grant read phone state permission");
            }
            return new h(null, g.f4322c);
        }
        int i2 = g.f4321b;
        try {
            if (b.f4296b) {
                b.a("try reflect imei...");
            }
            Class<?> cls = Class.forName(a());
            String str = (String) cls.getMethod(f4332a, Integer.TYPE).invoke(cls.getMethod("getDefault", Context.class).invoke(cls, context), 0);
            f4334c = true;
            f4333b = str;
            i2 = g.f4323d;
        } catch (Exception e2) {
            if (b.f4296b) {
                b.a("reflect ime with exception is: " + e2.toString());
            }
        }
        return new h(f4333b, i2);
    }
}

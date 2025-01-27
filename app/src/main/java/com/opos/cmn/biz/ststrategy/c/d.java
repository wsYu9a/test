package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class d {
    public static long a(Context context) {
        long j2 = 30;
        if (context != null) {
            SharedPreferences g2 = g(context);
            if (g2 != null) {
                try {
                    j2 = g2.getLong("nxLimitNew", 30L);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("SPUtil", "", e2);
                }
            }
            if (j2 < 15) {
                return 15L;
            }
            if (j2 > 10080) {
                return 10080L;
            }
        }
        return j2;
    }

    public static void a(Context context, int i2) {
        SharedPreferences g2;
        if (context == null || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putInt("dtLimit", i2);
        edit.apply();
    }

    public static void a(Context context, long j2) {
        SharedPreferences g2;
        if (context == null || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        if (j2 < 15 || j2 > 10080) {
            j2 = j2 < 15 ? 15L : j2 > 10080 ? 10080L : 30L;
        }
        edit.putLong("nxLimitNew", j2);
        edit.apply();
    }

    public static void a(Context context, String str) {
        SharedPreferences g2 = g(context);
        if (context == null || g2 == null || str == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("SPUtil", "setLastRegion=" + str);
        SharedPreferences.Editor edit = g2.edit();
        edit.putString("lastRegion", str);
        edit.apply();
    }

    public static void a(Context context, String str, long j2) {
        SharedPreferences g2;
        if (context == null || TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putLong("lastTime_" + str, j2);
        edit.apply();
    }

    public static long b(Context context, String str) {
        SharedPreferences g2;
        if (context == null || TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return 0L;
        }
        return g2.getLong("lastTime_" + str, 0L);
    }

    public static String b(Context context) {
        SharedPreferences g2 = g(context);
        String string = g2 != null ? g2.getString("lastRegion", "") : "";
        com.opos.cmn.an.f.a.b("SPUtil", "getLastRegion=" + string);
        return string;
    }

    public static void b(Context context, int i2) {
        SharedPreferences g2;
        if (context == null || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putInt("blackListLimit", i2);
        edit.apply();
    }

    public static void b(Context context, String str, long j2) {
        SharedPreferences g2;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
                    return;
                }
                SharedPreferences.Editor edit = g2.edit();
                edit.putLong("curr_" + str, j2);
                edit.apply();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("SPUtil", "", e2);
            }
        }
    }

    public static int c(Context context) {
        SharedPreferences g2;
        if (context == null || (g2 = g(context)) == null) {
            return 60;
        }
        return g2.getInt("dtLimit", 60);
    }

    public static long c(Context context, String str) {
        SharedPreferences g2;
        if (context == null) {
            return 0L;
        }
        try {
            if (TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
                return 0L;
            }
            return g2.getLong("curr_" + str, 0L);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("SPUtil", "", e2);
            return 0L;
        }
    }

    public static void c(Context context, String str, long j2) {
        SharedPreferences g2;
        if (context == null || TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putLong("firReq_" + str, j2);
        edit.apply();
    }

    public static int d(Context context) {
        SharedPreferences g2;
        if (context == null || (g2 = g(context)) == null) {
            return 2880;
        }
        return g2.getInt("blackListLimit", 2880);
    }

    public static long d(Context context, String str) {
        SharedPreferences g2;
        if (context == null || TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return 0L;
        }
        return g2.getLong("firReq_" + str, 0L);
    }

    public static void d(Context context, String str, long j2) {
        SharedPreferences g2;
        if (context == null || TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putLong("firDTLimit_" + str, j2);
        edit.apply();
    }

    public static long e(Context context, String str) {
        SharedPreferences g2;
        if (context == null || TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return 0L;
        }
        return g2.getLong("firDTLimit_" + str, 0L);
    }

    public static void e(Context context) {
        SharedPreferences g2;
        if (context == null || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putBoolean("isWbsVer", true);
        edit.apply();
    }

    public static boolean f(Context context) {
        SharedPreferences g2;
        if (context == null || (g2 = g(context)) == null) {
            return false;
        }
        return g2.getBoolean("isWbsVer", false);
    }

    private static final SharedPreferences g(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("com.opos.st.strategy.prefs", 0);
    }
}

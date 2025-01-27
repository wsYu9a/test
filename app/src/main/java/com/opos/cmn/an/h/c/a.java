package com.opos.cmn.an.h.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.kuaishou.weapon.p0.g;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static ConnectivityManager f16527a;

    /* renamed from: b */
    private static TelephonyManager f16528b;

    public static TelephonyManager a(Context context) {
        if (f16528b == null && context != null) {
            f16528b = (TelephonyManager) context.getSystemService("phone");
        }
        return f16528b;
    }

    private static String a(int i2) {
        switch (i2) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "CDMA - EvDo rev. 0";
            case 6:
                return "CDMA - EvDo rev. A";
            case 7:
                return "CDMA - 1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDEN";
            case 12:
                return "CDMA - EvDo rev. B";
            case 13:
                return "LTE";
            case 14:
                return "CDMA - eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            case 19:
                return "LTE_CA";
            case 20:
                return "NR";
            default:
                return "UNKNOWN";
        }
    }

    public static ConnectivityManager b(Context context) {
        if (f16527a == null && context != null) {
            f16527a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f16527a;
    }

    public static boolean c(Context context) {
        boolean z;
        ConnectivityManager b2;
        NetworkInfo activeNetworkInfo;
        try {
            b2 = b(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e2);
        }
        if (b2 != null && (activeNetworkInfo = b2.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 0) {
                z = true;
                com.opos.cmn.an.f.a.b("ConnMgrTool", "isMobileActive=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("ConnMgrTool", "isMobileActive=" + z);
        return z;
    }

    public static boolean d(Context context) {
        boolean z;
        ConnectivityManager b2;
        NetworkInfo activeNetworkInfo;
        try {
            b2 = b(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e2);
        }
        if (b2 != null && (activeNetworkInfo = b2.getActiveNetworkInfo()) != null) {
            if (NetworkInfo.State.CONNECTED == activeNetworkInfo.getState()) {
                z = true;
                com.opos.cmn.an.f.a.b("ConnMgrTool", "isNetAvailable=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("ConnMgrTool", "isNetAvailable=" + z);
        return z;
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        boolean z = false;
        if (context != null) {
            try {
                ConnectivityManager b2 = b(context);
                if (b2 != null && (activeNetworkInfo = b2.getActiveNetworkInfo()) != null) {
                    if (activeNetworkInfo.getType() == 1) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("ConnMgrTool", "isWifiActive=" + z);
        return z;
    }

    public static String f(Context context) {
        NetworkInfo activeNetworkInfo;
        String str = "";
        if (context != null) {
            try {
                ConnectivityManager b2 = b(context);
                if (b2 != null && (activeNetworkInfo = b2.getActiveNetworkInfo()) != null) {
                    StringBuilder sb = new StringBuilder();
                    if (activeNetworkInfo.getTypeName() != null) {
                        if ("WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                            sb.append(activeNetworkInfo.getTypeName());
                        } else if (Build.VERSION.SDK_INT <= 29) {
                            if (activeNetworkInfo.getSubtypeName() != null) {
                                sb.append(activeNetworkInfo.getSubtypeName());
                            }
                        } else if (com.opos.cmn.an.h.d.a.a(context, g.f9318c)) {
                            TelephonyManager a2 = a(context);
                            if (a2 != null) {
                                str = a(a2.getDataNetworkType());
                            }
                        } else if (c(context)) {
                            str = "mobile";
                        }
                        str = sb.toString();
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetTypeName=" + str);
        return str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0046 -> B:3:0x004b). Please report as a decompilation issue!!! */
    public static int g(Context context) {
        ConnectivityManager b2;
        NetworkInfo activeNetworkInfo;
        int i2;
        if (context != null) {
            try {
                b2 = b(context);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e2);
            }
            if (b2 != null && (activeNetworkInfo = b2.getActiveNetworkInfo()) != null) {
                if (1 == activeNetworkInfo.getType()) {
                    i2 = -1;
                } else if (activeNetworkInfo.getType() == 0) {
                    if (Build.VERSION.SDK_INT <= 29) {
                        i2 = activeNetworkInfo.getSubtype();
                    } else if (com.opos.cmn.an.h.d.a.a(context, g.f9318c)) {
                        TelephonyManager a2 = a(context);
                        if (a2 != null) {
                            i2 = a2.getDataNetworkType();
                        }
                    } else if (c(context)) {
                        i2 = -2;
                    }
                }
                com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetType=" + i2);
                return i2;
            }
        }
        i2 = 0;
        com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetType=" + i2);
        return i2;
    }

    public static String h(Context context) {
        String str;
        if (context != null) {
            try {
                int g2 = g(context);
                if (g2 == -2) {
                    str = "mobile";
                } else if (g2 == -1) {
                    str = com.alipay.mobilesecuritysdk.constant.a.I;
                } else if (g2 != 20) {
                    switch (g2) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2g";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = "3g";
                            break;
                        case 13:
                            str = "4g";
                            break;
                    }
                } else {
                    str = "5g";
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e2);
            }
            com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetEnv=" + str);
            return str;
        }
        str = com.baidu.mobads.sdk.internal.a.f5472a;
        com.opos.cmn.an.f.a.b("ConnMgrTool", "getNetEnv=" + str);
        return str;
    }
}

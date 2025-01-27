package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static String f24304a = null;

    /* renamed from: b */
    private static final String f24305b = "umeng+";

    /* renamed from: c */
    private static final String f24306c = "ek__id";

    /* renamed from: d */
    private static final String f24307d = "ek_key";

    /* renamed from: e */
    private static String f24308e = "";

    /* renamed from: f */
    private static final String f24309f = bd.b().b(bd.f23534n);

    /* renamed from: g */
    private static String f24310g = "";

    /* renamed from: h */
    private static a f24311h;

    private a() {
    }

    public static a a() {
        if (f24311h == null) {
            synchronized (a.class) {
                try {
                    if (f24311h == null) {
                        f24311h = new a();
                    }
                } finally {
                }
            }
        }
        return f24311h;
    }

    private String c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < substring.length(); i10++) {
                char charAt = substring.charAt(i10);
                if (!Character.isDigit(charAt)) {
                    sb2.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb2.append(0);
                } else {
                    sb2.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
            }
            str2 = sb2.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    public String b(String str) {
        String str2;
        String str3;
        try {
            return TextUtils.isEmpty(f24304a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f24304a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            String str4 = null;
            if (TextUtils.isEmpty(f24308e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str5 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f24308e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str5;
                } catch (Exception unused2) {
                    str4 = str5;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str3 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f24310g.getBytes()));
                    } catch (Throwable unused3) {
                        str2 = str4;
                    }
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str3;
                    } catch (Throwable unused4) {
                        str2 = str3;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str2;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f24304a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f24306c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f24308e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f24308e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24309f, 0);
                if (sharedPreferences != null) {
                    f24310g = sharedPreferences.getString(f24306c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f24310g);
                }
                f24304a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f24304a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f24304a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f24304a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}

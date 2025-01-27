package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static String f26077a = null;

    /* renamed from: b */
    private static final String f26078b = "umeng+";

    /* renamed from: c */
    private static final String f26079c = "ek__id";

    /* renamed from: d */
    private static final String f26080d = "ek_key";

    /* renamed from: e */
    private static String f26081e = "";

    /* renamed from: f */
    private static final String f26082f = "umeng_subprocess_info";

    /* renamed from: g */
    private static String f26083g = "";

    /* renamed from: h */
    private static a f26084h;

    private a() {
    }

    public static a a() {
        if (f26084h == null) {
            synchronized (a.class) {
                if (f26084h == null) {
                    f26084h = new a();
                }
            }
        }
        return f26084h;
    }

    private String c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < substring.length(); i2++) {
                char charAt = substring.charAt(i2);
                if (!Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
            }
            str2 = sb.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(f26077a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f26077a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f26081e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f26081e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f26083g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f26077a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f26079c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f26081e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f26081e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26082f, 0);
                if (sharedPreferences != null) {
                    f26083g = sharedPreferences.getString(f26079c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f26083g);
                }
                f26077a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f26077a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f26077a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f26077a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}

package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class y {

    /* renamed from: c */
    private static volatile y f26027c;

    /* renamed from: a */
    private w f26028a = new x();

    /* renamed from: b */
    private String f26029b;

    /* renamed from: d */
    private List<a> f26030d;

    /* renamed from: e */
    private String f26031e;

    public interface a {
        void a(String str, long j2, long j3, long j4);

        void a(String str, String str2, long j2, long j3, long j4);
    }

    private y() {
    }

    public static y a() {
        if (f26027c == null) {
            synchronized (y.class) {
                if (f26027c == null) {
                    f26027c = new y();
                }
            }
        }
        return f26027c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(u.f26012d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h2 = h(context);
        long i2 = i(context);
        String str = this.f26029b;
        long a2 = u.a(context);
        long j2 = a2 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a2);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(i2, h2, j2, str, false);
        this.f26029b = this.f26028a.a(context);
        a(i2, h2, j2, str, true);
        this.f26028a.a(context, this.f26029b);
        return this.f26029b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f26029b) && i.a(context).a(this.f26029b) > 0;
    }

    private long h(Context context) {
        return a(context, u.f26014f);
    }

    private long i(Context context) {
        return a(context, u.f26009a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j2 = sharedPreferences.getLong(u.f26013e, 0L);
            long j3 = sharedPreferences.getLong(u.f26014f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j2 > 0 && j3 == 0) {
                long a2 = u.a(appContext);
                if (a2 > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j3 = j2 + (a2 * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j3 - j2));
            return this.f26028a.a(j2, j3);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f26028a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f26029b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f26029b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f26029b)) {
            try {
                this.f26029b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f26029b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f26029b)) {
            this.f26029b = d(context);
        }
        return TextUtils.isEmpty(this.f26029b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f26029b = d(appContext);
        if (e(appContext)) {
            try {
                this.f26029b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f26029b;
    }

    public void a(long j2) {
        this.f26028a.a(j2);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (y.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(u.f26012d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f26030d) == null || list.size() == 0) {
            return;
        }
        this.f26030d.remove(aVar);
    }

    public String a(Context context, long j2) {
        if (TextUtils.isEmpty(this.f26031e)) {
            String str = "SUB" + j2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f26031e = sb.toString();
        }
        return this.f26031e;
    }

    private long a(Context context, String str) {
        long j2;
        try {
            j2 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j2 = 0;
        }
        return j2 <= 0 ? System.currentTimeMillis() : j2;
    }

    private void a(long j2, long j3, long j4, String str, boolean z) {
        List<a> list = this.f26030d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.f26029b, j2, j3, j4);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f26029b, j2, j3, j4);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f26030d == null) {
            this.f26030d = new ArrayList();
        }
        if (this.f26030d.contains(aVar)) {
            return;
        }
        this.f26030d.add(aVar);
    }
}

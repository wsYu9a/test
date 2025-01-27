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
public class aa {

    /* renamed from: c */
    private static volatile aa f23381c;

    /* renamed from: a */
    private y f23382a = new z();

    /* renamed from: b */
    private String f23383b;

    /* renamed from: d */
    private List<a> f23384d;

    /* renamed from: e */
    private String f23385e;

    public interface a {
        void a(String str, long j10, long j11, long j12);

        void a(String str, String str2, long j10, long j11, long j12);
    }

    private aa() {
    }

    public static aa a() {
        if (f23381c == null) {
            synchronized (aa.class) {
                try {
                    if (f23381c == null) {
                        f23381c = new aa();
                    }
                } finally {
                }
            }
        }
        return f23381c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(w.f24161d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h10 = h(context);
        long i10 = i(context);
        String str = this.f23383b;
        long a10 = w.a(context);
        long j10 = a10 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a10);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(i10, h10, j10, str, false);
        this.f23383b = this.f23382a.a(context);
        a(i10, h10, j10, str, true);
        this.f23382a.a(context, this.f23383b);
        return this.f23383b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f23383b) && k.a(context).a(this.f23383b) > 0;
    }

    private long h(Context context) {
        return a(context, w.f24163f);
    }

    private long i(Context context) {
        return a(context, w.f24158a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j10 = sharedPreferences.getLong(w.f24162e, 0L);
            long j11 = sharedPreferences.getLong(w.f24163f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j10 > 0 && j11 == 0) {
                long a10 = w.a(appContext);
                if (a10 > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j11 = j10 + (a10 * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j11 - j10));
            return this.f23382a.a(j10, j11);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f23382a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f23383b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f23383b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f23383b)) {
            try {
                this.f23383b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f23383b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f23383b)) {
            this.f23383b = d(context);
        }
        return TextUtils.isEmpty(this.f23383b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f23383b = d(appContext);
        if (e(appContext)) {
            try {
                this.f23383b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f23383b;
    }

    public void a(long j10) {
        this.f23382a.a(j10);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (aa.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(w.f24161d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f23384d) == null || list.size() == 0) {
            return;
        }
        this.f23384d.remove(aVar);
    }

    public String a(Context context, long j10) {
        if (TextUtils.isEmpty(this.f23385e)) {
            String str = "SUB" + j10;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f23385e = sb2.toString();
        }
        return this.f23385e;
    }

    private long a(Context context, String str) {
        long j10;
        try {
            j10 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j10 = 0;
        }
        return j10 <= 0 ? System.currentTimeMillis() : j10;
    }

    private void a(long j10, long j11, long j12, String str, boolean z10) {
        List<a> list = this.f23384d;
        if (list != null) {
            for (a aVar : list) {
                if (z10) {
                    try {
                        aVar.a(str, this.f23383b, j10, j11, j12);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f23383b, j10, j11, j12);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f23384d == null) {
            this.f23384d = new ArrayList();
        }
        if (this.f23384d.contains(aVar)) {
            return;
        }
        this.f23384d.add(aVar);
    }
}

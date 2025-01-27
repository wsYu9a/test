package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class cc implements cb {

    /* renamed from: a */
    private static final String f23728a = "cache_domain";

    /* renamed from: b */
    private static volatile String f23729b = "";

    public static class a {

        /* renamed from: a */
        public static final cc f23730a = new cc();

        private a() {
        }
    }

    public /* synthetic */ cc(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static cc b() {
        return a.f23730a;
    }

    private void d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
        if (sharedPreferences != null) {
            f23729b = sharedPreferences.getString(f23728a, "");
        }
    }

    private void e() {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(f23728a, f23729b).commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void a() {
    }

    public String c() {
        return f23729b;
    }

    private cc() {
        d();
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(Throwable th2) {
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("Status") && jSONObject.getInt("Status") == 0 && jSONObject.has("Answer")) {
                String optString = jSONObject.optString("Answer");
                String str2 = "";
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                if (jSONObject.has("ip")) {
                    str2 = jSONObject.optString("ip");
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> domain下发结果：" + optString);
                if (!TextUtils.isEmpty(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 对应domain下发请求ip：" + str2);
                }
                f23729b = optString;
                e();
            }
        } catch (Throwable unused) {
        }
    }
}

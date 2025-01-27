package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: a */
    public static final String f24680a = bd.b().b(bd.f23532l);

    /* renamed from: b */
    public static final String f24681b = "key_umeng_sp_oaid";

    /* renamed from: c */
    public static final String f24682c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d */
    private static final String f24683d = "oaid";

    /* renamed from: e */
    private Context f24684e;

    public i(Context context) {
        super("oaid");
        this.f24684e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OaidTracking.getId(): oaid开关已关闭。");
            return null;
        }
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f24684e.getSharedPreferences(f24680a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f24681b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: classes4.dex */
public class c extends a {

    /* renamed from: a */
    public static final String f24656a = bd.b().b(bd.f23532l);

    /* renamed from: b */
    public static final String f24657b = "key_umeng_sp_honor_oaid";

    /* renamed from: c */
    private static final String f24658c = "honor_oaid";

    /* renamed from: d */
    private Context f24659d;

    public c(Context context) {
        super(f24658c);
        this.f24659d = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** HonorOaidTracker.getId(): oaid开关已关闭。");
            return null;
        }
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f24659d.getSharedPreferences(f24656a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f24657b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

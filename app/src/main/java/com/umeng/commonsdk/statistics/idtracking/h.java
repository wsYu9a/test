package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManager;

/* loaded from: classes4.dex */
public class h extends a {

    /* renamed from: a */
    public static final String f26355a = "umeng_sp_oaid";

    /* renamed from: b */
    public static final String f26356b = "key_umeng_sp_oaid";

    /* renamed from: c */
    public static final String f26357c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d */
    private static final String f26358d = "oaid";

    /* renamed from: e */
    private Context f26359e;

    public h(Context context) {
        super(f26358d);
        this.f26359e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f26359e.getSharedPreferences(f26355a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f26356b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

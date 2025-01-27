package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;

/* loaded from: classes4.dex */
public class j extends a {

    /* renamed from: a */
    private static final String f26361a = "utdid";

    /* renamed from: b */
    private Context f26362b;

    public j(Context context) {
        super("utdid");
        this.f26362b = context;
    }

    private String g() {
        try {
            return this.f26362b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String h() {
        try {
            return this.f26362b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.u)) {
                String h2 = h();
                return TextUtils.isEmpty(h2) ? g() : h2;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}

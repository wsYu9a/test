package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;

/* loaded from: classes4.dex */
public class k extends a {

    /* renamed from: a */
    private static final String f24686a = "utdid";

    /* renamed from: b */
    private Context f24687b;

    public k(Context context) {
        super("utdid");
        this.f24687b = context;
    }

    private String g() {
        try {
            return this.f24687b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String h() {
        try {
            return this.f24687b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f24864u)) {
                String h10 = h();
                return TextUtils.isEmpty(h10) ? g() : h10;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}

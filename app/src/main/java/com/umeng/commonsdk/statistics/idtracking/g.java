package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes4.dex */
public class g extends a {

    /* renamed from: a */
    private static final String f24676a = "imei";

    /* renamed from: b */
    private Context f24677b;

    public g(Context context) {
        super(f24676a);
        this.f24677b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f24677b);
    }
}

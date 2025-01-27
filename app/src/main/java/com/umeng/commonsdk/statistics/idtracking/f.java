package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes4.dex */
public class f extends a {

    /* renamed from: a */
    private static final String f26351a = "imei";

    /* renamed from: b */
    private Context f26352b;

    public f(Context context) {
        super(f26351a);
        this.f26352b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f26352b);
    }
}

package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes4.dex */
public class d extends a {

    /* renamed from: a */
    private static final String f26337a = "idmd5";

    /* renamed from: b */
    private Context f26338b;

    public d(Context context) {
        super("idmd5");
        this.f26338b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f26338b);
    }
}

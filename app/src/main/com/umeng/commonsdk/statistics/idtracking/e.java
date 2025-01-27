package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes4.dex */
public class e extends a {

    /* renamed from: a */
    private static final String f24662a = "idmd5";

    /* renamed from: b */
    private Context f24663b;

    public e(Context context) {
        super("idmd5");
        this.f24663b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f24663b);
    }
}

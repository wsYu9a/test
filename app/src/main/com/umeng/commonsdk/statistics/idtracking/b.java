package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: a */
    private static final String f24654a = "android_id";

    /* renamed from: b */
    private Context f24655b;

    public b(Context context) {
        super(f24654a);
        this.f24655b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getAndroidId(this.f24655b);
    }
}

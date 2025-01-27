package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: a */
    private static final String f26333a = "android_id";

    /* renamed from: b */
    private Context f26334b;

    public b(Context context) {
        super(f26333a);
        this.f26334b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getAndroidId(this.f26334b);
    }
}

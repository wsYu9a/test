package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes4.dex */
public class c extends a {

    /* renamed from: a */
    private static final String f26335a = "idfa";

    /* renamed from: b */
    private Context f26336b;

    public c(Context context) {
        super(f26335a);
        this.f26336b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.f26336b);
    }
}

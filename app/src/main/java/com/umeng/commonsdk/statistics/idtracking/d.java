package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes4.dex */
public class d extends a {

    /* renamed from: a */
    private static final String f24660a = "idfa";

    /* renamed from: b */
    private Context f24661b;

    public d(Context context) {
        super(f24660a);
        this.f24661b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.f24661b);
    }
}

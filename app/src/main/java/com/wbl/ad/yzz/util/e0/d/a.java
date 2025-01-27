package com.wbl.ad.yzz.util.e0.d;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends com.wbl.ad.yzz.util.e0.a {

    /* renamed from: b */
    public final String f34230b;

    /* renamed from: c */
    public final String f34231c;

    /* renamed from: d */
    public final String f34232d;

    public a(@d String traceId, @d String taskType, @d String action) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(action, "action");
        this.f34230b = traceId;
        this.f34231c = taskType;
        this.f34232d = action;
    }

    @Override // com.wbl.ad.yzz.util.e0.c
    public String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9098, this, null);
    }

    @Override // com.wbl.ad.yzz.util.e0.c
    public Map<String, String> b() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9097, this, null);
    }
}

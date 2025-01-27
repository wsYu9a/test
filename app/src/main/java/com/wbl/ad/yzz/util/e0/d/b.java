package com.wbl.ad.yzz.util.e0.d;

import com.baidu.mobads.sdk.internal.bw;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b extends com.wbl.ad.yzz.util.e0.a {

    /* renamed from: b */
    public final String f34233b;

    /* renamed from: c */
    public final String f34234c;

    /* renamed from: d */
    public final String f34235d;

    /* renamed from: e */
    public int f34236e;

    /* renamed from: f */
    public int f34237f;

    /* renamed from: g */
    public final String f34238g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@d String traceId, @d String taskType, @d String action, int i2) {
        this(traceId, taskType, action, bw.o, i2, 0);
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    @Override // com.wbl.ad.yzz.util.e0.c
    public String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9100, this, null);
    }

    @Override // com.wbl.ad.yzz.util.e0.c
    public Map<String, String> b() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9099, this, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@d String traceId, @d String taskType, @d String action, @d String result) {
        this(traceId, taskType, action, result, 0, 0);
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(result, "result");
    }

    public b(@d String traceId, @d String taskType, @d String action, @d String result, int i2, int i3) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(result, "result");
        this.f34233b = traceId;
        this.f34234c = taskType;
        this.f34235d = action;
        this.f34236e = i2;
        this.f34237f = i3;
        this.f34238g = result;
    }
}

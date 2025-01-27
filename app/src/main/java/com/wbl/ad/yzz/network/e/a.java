package com.wbl.ad.yzz.network.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import f.b.a.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a<T> extends c {

    /* renamed from: e */
    public final Object f33759e;

    /* renamed from: f */
    public final com.wbl.ad.yzz.network.d.a<T> f33760f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@d String url, @e Object obj, @e Map<String, String> map, @e com.wbl.ad.yzz.network.d.a<T> aVar) {
        super(url, obj, map, aVar);
        Intrinsics.checkNotNullParameter(url, "url");
        this.f33759e = obj;
        this.f33760f = aVar;
    }

    @Override // com.wbl.ad.yzz.network.e.c, java.lang.Runnable
    public void run() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10561, this, null);
    }
}

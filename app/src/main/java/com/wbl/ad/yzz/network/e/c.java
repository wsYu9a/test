package com.wbl.ad.yzz.network.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.d.d;
import f.b.a.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class c implements Runnable, b {

    /* renamed from: a */
    public final String f33761a;

    /* renamed from: b */
    public final Object f33762b;

    /* renamed from: c */
    public final Map<String, String> f33763c;

    /* renamed from: d */
    public final d f33764d;

    public c(@f.b.a.d String url, @e Object obj, @e Map<String, String> map, @e d dVar) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f33761a = url;
        this.f33762b = obj;
        this.f33763c = map;
        this.f33764d = dVar;
    }

    @Override // com.wbl.ad.yzz.network.e.b
    public void a(Throwable th) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10567, this, th);
    }

    @Override // java.lang.Runnable
    public void run() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10562, this, null);
    }
}

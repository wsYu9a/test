package com.wbl.ad.yzz.network.d;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public abstract class a<T> extends e<T> {

    /* renamed from: e */
    public final c<String, String> f33749e;

    /* renamed from: f */
    public Class f33750f;

    public a(Context context, Class cls, c<String, String> cVar) {
        super(context, cls);
        this.f33749e = cVar;
        this.f33750f = cls;
    }

    @Override // com.wbl.ad.yzz.network.d.e, com.wbl.ad.yzz.network.d.d
    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10361, this, str);
    }

    @Override // com.wbl.ad.yzz.network.d.e, com.wbl.ad.yzz.network.d.d
    public void a(Throwable th) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10364, this, th);
    }

    public final void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10363, this, str);
    }

    public final void d(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10358, this, str);
    }

    public boolean e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10357, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10360, this, null);
    }
}

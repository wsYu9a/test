package com.wbl.ad.yzz.adrequest.c;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.c.b;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bw\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001e\u0012\u001c\u0010\u0016\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e\u0012\u0014\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0002\u0018\u00010%\u0012\u0014\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0002\u0018\u00010'¢\u0006\u0004\b)\u0010*R!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR8\u0010\u0016\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0006\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0004\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0018\u0010!\"\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/wbl/ad/yzz/adrequest/c/e;", "", "", "Lcom/wbl/ad/yzz/network/b/b/d;", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "adListBean", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/wbl/ad/yzz/adrequest/c/d;", "", "Lcom/wbl/ad/yzz/adapter/d/b;", "Lcom/wbl/ad/yzz/adrequest/c/b;", "c", "Lcom/wbl/ad/yzz/adrequest/c/d;", "()Lcom/wbl/ad/yzz/adrequest/c/d;", "(Lcom/wbl/ad/yzz/adrequest/c/d;)V", com.alipay.sdk.authjs.a.f5376c, "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "setBusContext", "(Ljava/lang/String;)V", "busContext", "Lcom/wbl/ad/yzz/innerconfig/d/d;", com.kwad.sdk.ranger.e.TAG, "Lcom/wbl/ad/yzz/innerconfig/d/d;", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "setSceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "sceneCache", "Lcom/wbl/ad/yzz/a;", "httpCallBackInfoFlow", "Lcom/wbl/ad/yzz/network/c/b$a;", "infoFlowAdCallBack", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/wbl/ad/yzz/innerconfig/d/d;Lcom/wbl/ad/yzz/adrequest/c/d;Lcom/wbl/ad/yzz/a;Lcom/wbl/ad/yzz/network/c/b$a;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: from kotlin metadata */
    @f.b.a.e
    public final Context context;

    /* renamed from: b, reason: from kotlin metadata */
    @f.b.a.e
    public final List<com.wbl.ad.yzz.network.b.b.d> adListBean;

    /* renamed from: c, reason: from kotlin metadata */
    @f.b.a.e
    public d<List<com.wbl.ad.yzz.adapter.d.b>, b> com.alipay.sdk.authjs.a.c java.lang.String;

    /* renamed from: d, reason: from kotlin metadata */
    @f.b.a.e
    public String busContext;

    /* renamed from: e */
    @f.b.a.e
    public com.wbl.ad.yzz.innerconfig.d.d sceneCache;

    public e(@f.b.a.e Context context, @f.b.a.e List<com.wbl.ad.yzz.network.b.b.d> list, @f.b.a.e com.wbl.ad.yzz.innerconfig.d.d dVar, @f.b.a.e d<List<com.wbl.ad.yzz.adapter.d.b>, b> dVar2, @f.b.a.e com.wbl.ad.yzz.a<List<com.wbl.ad.yzz.adapter.d.b>> aVar, @f.b.a.e b.a<List<com.wbl.ad.yzz.adapter.d.b>> aVar2) {
        this.context = context;
        this.adListBean = list;
        this.com.alipay.sdk.authjs.a.c java.lang.String = dVar2;
        this.sceneCache = dVar;
    }

    public final List<com.wbl.ad.yzz.network.b.b.d> a() {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15787, this, null);
    }

    public final void a(d<List<com.wbl.ad.yzz.adapter.d.b>, b> dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15782, this, dVar);
    }

    public final String b() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15781, this, null);
    }

    public final d<List<com.wbl.ad.yzz.adapter.d.b>, b> c() {
        return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15784, this, null);
    }

    public final com.wbl.ad.yzz.innerconfig.d.d d() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15783, this, null);
    }

    public final Context getContext() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15778, this, null);
    }
}

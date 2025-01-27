package com.wbl.ad.yzz.network.c.e;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.bean.AdPageNeedData;
import com.wbl.ad.yzz.network.c.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0003\u0010\bJ\u001b\u0010\u0003\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0003\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/wbl/ad/yzz/network/c/e/a;", "", "", "a", "()V", "Lcom/wbl/ad/yzz/innerconfig/d/e;", "scene", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "(Lcom/wbl/ad/yzz/innerconfig/d/e;)Lcom/wbl/ad/yzz/innerconfig/d/d;", "sceneCache", "Lcom/wbl/ad/yzz/bean/AdPageNeedData;", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)Lcom/wbl/ad/yzz/bean/AdPageNeedData;", "", "b", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)Z", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Z", "cancel", "Lcom/wbl/ad/yzz/bean/b;", "c", "Lcom/wbl/ad/yzz/bean/b;", "getBean", "()Lcom/wbl/ad/yzz/bean/b;", "bean", "<init>", "(Landroid/content/Context;Lcom/wbl/ad/yzz/bean/b;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: from kotlin metadata */
    public boolean cancel;

    /* renamed from: b, reason: from kotlin metadata */
    @f.b.a.e
    public final Context context;

    /* renamed from: c, reason: from kotlin metadata */
    @f.b.a.d
    public final com.wbl.ad.yzz.bean.b bean;

    /* renamed from: com.wbl.ad.yzz.network.c.e.a$a */
    public static final class C0772a implements d.b0<com.wbl.ad.yzz.network.b.b.t> {

        /* renamed from: b */
        public final /* synthetic */ String f33676b;

        public C0772a(String str) {
            this.f33676b = str;
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.t tVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10476, this, str, tVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10475, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.t tVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10470, this, str, tVar);
        }
    }

    public a(@f.b.a.e Context context, @f.b.a.d com.wbl.ad.yzz.bean.b bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.context = context;
        this.bean = bean;
    }

    public final AdPageNeedData a(com.wbl.ad.yzz.innerconfig.d.d sceneCache) {
        return (AdPageNeedData) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10472, this, sceneCache);
    }

    public final com.wbl.ad.yzz.innerconfig.d.d a(com.wbl.ad.yzz.innerconfig.d.e scene) {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10471, this, scene);
    }

    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10466, this, null);
    }

    public final boolean b(com.wbl.ad.yzz.innerconfig.d.d sceneCache) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10465, this, sceneCache);
    }

    public final Context getContext() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10468, this, null);
    }
}

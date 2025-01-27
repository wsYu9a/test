package com.wbl.ad.yzz.gudie.f;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.adrequest.c.c;
import com.wbl.ad.yzz.gudie.g.d;
import com.wbl.ad.yzz.innerconfig.d.j;
import com.wbl.ad.yzz.network.b.b.w;
import com.wbl.ad.yzz.network.c.a;
import com.wbl.ad.yzz.network.c.d;
import com.wbl.ad.yzz.util.h;
import com.wbl.ad.yzz.util.t;
import f.b.a.e;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0005\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001b¨\u0006 "}, d2 = {"Lcom/wbl/ad/yzz/gudie/f/a;", "Lcom/wbl/ad/yzz/gudie/f/b;", "Lcom/wbl/ad/yzz/gudie/g/d;", "view", "", "a", "(Lcom/wbl/ad/yzz/gudie/g/d;)V", "()V", "b", "Lcom/wbl/ad/yzz/adrequest/c/e;", "params", "(Lcom/wbl/ad/yzz/adrequest/c/e;)V", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "c", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "mSceneDataInfoWrap", "Lcom/wbl/ad/yzz/gudie/g/d;", "mView", "Lcom/wbl/ad/yzz/network/c/a;", "Lcom/wbl/ad/yzz/network/c/a;", "mFeedEngine", "sceneDataInfoWrap", "<init>", "(Landroid/content/Context;Lcom/wbl/ad/yzz/innerconfig/d/j;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements com.wbl.ad.yzz.gudie.f.b {

    /* renamed from: a, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.network.c.a mFeedEngine;

    /* renamed from: b, reason: from kotlin metadata */
    public d mView;

    /* renamed from: c, reason: from kotlin metadata */
    public final j mSceneDataInfoWrap;

    /* renamed from: d, reason: from kotlin metadata */
    @e
    public Context context;

    /* renamed from: com.wbl.ad.yzz.gudie.f.a$a */
    public static final class C0738a implements d.b0<w> {
        public C0738a() {
        }

        public void a(String str, w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13378, this, str, wVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13377, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13380, this, str, wVar);
        }
    }

    public static final class b implements a.InterfaceC0770a {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.gudie.g.d f32563b;

        public b(com.wbl.ad.yzz.gudie.g.d dVar) {
            this.f32563b = dVar;
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13379, this, Integer.valueOf(i2), str);
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13406, this, list);
        }
    }

    public a(@e Context context, @e j jVar) {
        this.context = context;
        c cVar = new c(h.b(this.context, t.c(context)) - 22.0f, 0.0f, 640, 320);
        com.wbl.ad.yzz.network.c.a aVar = new com.wbl.ad.yzz.network.c.a();
        this.mFeedEngine = aVar;
        aVar.a(cVar);
        this.mSceneDataInfoWrap = jVar;
    }

    public static final /* synthetic */ com.wbl.ad.yzz.gudie.g.d a(a aVar) {
        return (com.wbl.ad.yzz.gudie.g.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13405, null, aVar);
    }

    @Override // com.wbl.ad.yzz.gudie.f.b
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13408, this, null);
    }

    @Override // com.wbl.ad.yzz.gudie.f.b
    public void a(com.wbl.ad.yzz.adrequest.c.e params) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13407, this, params);
    }

    @Override // com.wbl.ad.yzz.gudie.f.b
    public void a(com.wbl.ad.yzz.gudie.g.d view) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13402, this, view);
    }

    @Override // com.wbl.ad.yzz.gudie.f.b
    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13401, this, null);
    }

    public final Context getContext() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13404, this, null);
    }
}

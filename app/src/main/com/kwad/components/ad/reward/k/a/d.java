package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes2.dex */
public final class d extends i implements s, x.b {

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private WeakReference<g> rF;
    private com.kwad.components.ad.reward.c.e yZ;

    /* renamed from: za */
    private m f11717za;

    /* renamed from: zb */
    private l f11718zb;

    /* renamed from: zc */
    private n f11719zc;

    /* renamed from: zd */
    private List<AdTemplate> f11720zd;

    /* renamed from: ze */
    @Nullable
    private DialogInterface.OnDismissListener f11721ze;

    public d(@NonNull g gVar, long j10, Context context) {
        super(j10, context);
        this.f11720zd = null;
        this.rF = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void R(AdTemplate adTemplate) {
        com.kwad.components.core.i.c cVar = new com.kwad.components.core.i.c(adTemplate, com.kwad.components.core.i.e.AGGREGATION);
        WeakReference<g> weakReference = this.rF;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        super.a(activity, adResultData, jVar);
        WeakReference<g> weakReference = this.rF;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.k.s
    public final void ab(boolean z10) {
        n nVar = this.f11719zc;
        if (nVar != null) {
            nVar.aa(z10);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final al c(com.kwad.sdk.core.webview.b bVar) {
        WeakReference<g> weakReference = this.rF;
        return new p(weakReference != null ? weakReference.get() : null, getTkTemplateId(), this.yV, bVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void dismiss() {
        WeakReference<g> weakReference = this.rF;
        if (weakReference != null) {
            weakReference.get().E(false);
        }
        super.dismiss();
    }

    public final BackPressHandleResult gI() {
        m mVar = this.f11717za;
        if (mVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        mVar.jB();
        return BackPressHandleResult.HANDLED;
    }

    public final void h(List<AdTemplate> list) {
        this.f11720zd = list;
    }

    public final com.kwad.components.ad.reward.c.e jI() {
        return this.yZ;
    }

    public final l jJ() {
        return this.f11718zb;
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void jK() {
        super.jK();
        WeakReference<g> weakReference = this.rF;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.b(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void show() {
        super.show();
        WeakReference<g> weakReference = this.rF;
        if (weakReference != null) {
            weakReference.get().E(true);
        }
    }

    public d(g gVar, long j10, Context context, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(-1L, context);
        this.f11720zd = null;
        this.f11721ze = onDismissListener;
        this.rF = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.components.s sVar, ViewGroup viewGroup) {
        super.a(bVar, cVar, sVar, viewGroup);
        this.mApkDownloadHelper = cVar;
        WeakReference<g> weakReference = this.rF;
        com.kwad.sdk.core.webview.c.a qVar = new q(bVar, cVar, weakReference != null ? weakReference.get() : null, this.yV, this, this.f11721ze);
        com.kwad.components.core.e.e.g.pg().a(this);
        sVar.c(qVar);
        com.kwad.components.ad.reward.c.e eVar = new com.kwad.components.ad.reward.c.e();
        this.yZ = eVar;
        sVar.c(eVar);
        Context context = this.mContext;
        WeakReference<g> weakReference2 = this.rF;
        sVar.c(new t(context, weakReference2 != null ? weakReference2.get() : null));
        WeakReference<g> weakReference3 = this.rF;
        sVar.c(new o(weakReference3 != null ? weakReference3.get() : null));
        m mVar = new m();
        this.f11717za = mVar;
        sVar.c(mVar);
        l lVar = new l();
        this.f11718zb = lVar;
        sVar.c(lVar);
        List<AdTemplate> list = this.f11720zd;
        if (list != null) {
            this.f11718zb.g(list);
            this.f11720zd = null;
        }
        x xVar = new x(bVar);
        xVar.a(this);
        sVar.c(xVar);
        n nVar = new n();
        this.f11719zc = nVar;
        sVar.c(nVar);
        sVar.c(new r(this.rF));
    }
}

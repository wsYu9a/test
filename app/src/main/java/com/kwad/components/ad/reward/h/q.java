package com.kwad.components.ad.reward.h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class q extends com.kwad.components.core.webview.jshandler.p {
    private long uV;
    private WeakReference<com.kwad.components.ad.reward.j> xb;

    public q(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.components.ad.reward.j jVar, long j2, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.uV = -1L;
        this.uV = j2;
        if (jVar != null) {
            this.xb = new WeakReference<>(jVar);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 long, still in use, count: 2, list:
          (r0v0 long) from 0x0025: PHI (r0v1 long) = (r0v0 long), (r0v2 long) binds: [B:10:0x0023, B:5:0x000e] A[DONT_GENERATE, DONT_INLINE]
          (r0v0 long) from 0x0021: CMP_L (r0v0 long), (0 long) A[WRAPPED]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // com.kwad.components.core.webview.jshandler.p
    @androidx.annotation.NonNull
    public final com.kwad.sdk.core.report.y.b getClientParams(com.kwad.sdk.core.webview.c.a.a r5, com.kwad.sdk.core.response.model.AdTemplate r6) {
        /*
            r4 = this;
            com.kwad.sdk.core.report.y$b r5 = super.getClientParams(r5, r6)
            java.lang.ref.WeakReference<com.kwad.components.ad.reward.j> r6 = r4.xb
            if (r6 == 0) goto L1d
            java.lang.Object r6 = r6.get()
            if (r6 == 0) goto L1d
            java.lang.ref.WeakReference<com.kwad.components.ad.reward.j> r6 = r4.xb
            java.lang.Object r6 = r6.get()
            com.kwad.components.ad.reward.j r6 = (com.kwad.components.ad.reward.j) r6
            com.kwad.components.ad.reward.j.b r6 = r6.oN
            long r0 = r6.getPlayDuration()
            goto L25
        L1d:
            long r0 = r4.uV
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L27
        L25:
            r5.uV = r0
        L27:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.h.q.getClientParams(com.kwad.sdk.core.webview.c.a.a, com.kwad.sdk.core.response.model.AdTemplate):com.kwad.sdk.core.report.y$b");
    }

    @Override // com.kwad.components.core.webview.jshandler.p
    public final void onAdClickListen() {
        super.onAdClickListen();
        if (this.mBridgeContext != null) {
            com.kwad.components.ad.reward.b.a.gQ().d(this.mBridgeContext.getAdTemplate(), com.kwad.components.ad.reward.b.b.STATUS_NONE);
        }
    }
}

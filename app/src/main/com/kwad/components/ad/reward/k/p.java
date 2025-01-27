package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class p extends al {
    private WeakReference<com.kwad.components.ad.reward.g> rF;
    private long yO;
    private String yP;

    /* renamed from: com.kwad.components.ad.reward.k.p$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ com.kwad.components.ad.reward.g pP;

        public AnonymousClass1(com.kwad.components.ad.reward.g gVar) {
            gVar = gVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            gVar.z(p.this.yP);
        }
    }

    public p(com.kwad.components.ad.reward.g gVar, String str, long j10, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.yP = str;
        this.yO = j10;
        if (gVar != null) {
            this.rF = new WeakReference<>(gVar);
        }
    }

    private static boolean T(String str) {
        try {
            return new JSONObject(str).optInt("elementType") == 18;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.al
    public final void b(boolean z10, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.ad.reward.j.b.a(z10, adTemplate, null, bVar);
    }

    private boolean b(al.b bVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference;
        if (bVar.getActionType() != 140 || !com.kwad.sdk.core.config.d.Af() || !T(bVar.ts()) || (weakReference = this.rF) == null || weakReference.get() == null) {
            return false;
        }
        bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.ad.reward.k.p.1
            final /* synthetic */ com.kwad.components.ad.reward.g pP;

            public AnonymousClass1(com.kwad.components.ad.reward.g gVar) {
                gVar = gVar;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                gVar.z(p.this.yP);
            }
        }, qe.a.f30009d);
        return true;
    }

    @Override // com.kwad.components.core.webview.jshandler.al
    public final void a(@NonNull al.b bVar) {
        if (b(bVar)) {
            return;
        }
        super.a(bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.al
    public final void a(com.kwad.sdk.core.adlog.c.b bVar) {
        super.a(bVar);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.rF;
        if (weakReference != null && weakReference.get() != null) {
            bVar.aq(this.rF.get().f11689qf.getPlayDuration());
            return;
        }
        long j10 = this.yO;
        if (j10 > 0) {
            bVar.aq(j10);
        }
    }
}

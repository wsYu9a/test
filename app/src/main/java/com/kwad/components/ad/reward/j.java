package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class j extends com.kwad.components.ad.m.b {

    @Nullable
    private com.kwad.components.ad.reward.c.d rE;
    private WeakReference<g> rF;

    /* renamed from: com.kwad.components.ad.reward.j$1 */
    public class AnonymousClass1 implements com.kwad.components.ad.reward.c.d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.c.d
        public final void a(com.kwad.components.ad.reward.c.b bVar) {
            if (j.this.rE != null) {
                j.this.rE.a(bVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$2 */
    public class AnonymousClass2 implements com.kwad.components.core.webview.jshandler.o {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.o
        public final void a(com.kwad.components.core.webview.jshandler.i iVar, String str) {
            if (TextUtils.equals(str, "getExtraReward")) {
                iVar.a(com.kwad.components.ad.reward.c.a.hg().hh());
            }
        }
    }

    public j(g gVar, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.rF = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.ad.m.b
    public final void fG() {
        WeakReference<g> weakReference = this.rF;
        com.kwad.components.ad.reward.monitor.c.a((weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.m.b
    public final void fH() {
        WeakReference<g> weakReference = this.rF;
        boolean z10 = (weakReference != null ? weakReference.get() : null) != null;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, z10, "end_card", F(adTemplate));
    }

    @Override // com.kwad.components.ad.m.b
    public final void fI() {
        WeakReference<g> weakReference = this.rF;
        com.kwad.components.ad.reward.monitor.c.a((weakReference != null ? weakReference.get() : null) != null, "end_card", F(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    public final void a(@Nullable com.kwad.components.ad.reward.c.d dVar) {
        this.rE = dVar;
    }

    @Override // com.kwad.components.ad.m.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.i.b(this.dY.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.j.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar) {
                if (j.this.rE != null) {
                    j.this.rE.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.i(new com.kwad.components.core.webview.jshandler.o() { // from class: com.kwad.components.ad.reward.j.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.o
            public final void a(com.kwad.components.core.webview.jshandler.i iVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    iVar.a(com.kwad.components.ad.reward.c.a.hg().hh());
                }
            }
        }));
        WeakReference<g> weakReference = this.rF;
        aVar.b(new com.kwad.components.ad.reward.k.p(weakReference != null ? weakReference.get() : null, "native_id", -1L, this.f11647eb));
    }
}

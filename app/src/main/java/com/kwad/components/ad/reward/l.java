package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class l extends com.kwad.components.ad.i.b {

    @Nullable
    private com.kwad.components.ad.reward.b.d ql;
    private WeakReference<j> qm;

    /* renamed from: com.kwad.components.ad.reward.l$1 */
    final class AnonymousClass1 implements com.kwad.components.ad.reward.b.d {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.b.d
        public final void a(com.kwad.components.ad.reward.b.b bVar) {
            if (l.this.ql != null) {
                l.this.ql.a(bVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.l$2 */
    final class AnonymousClass2 implements com.kwad.components.core.webview.jshandler.i {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.i
        public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
            if (TextUtils.equals(str, "getExtraReward")) {
                eVar.a(com.kwad.components.ad.reward.b.a.gQ().gR());
            }
        }
    }

    public l(j jVar, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.qm = new WeakReference<>(jVar);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.b.d dVar) {
        this.ql = dVar;
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.f.b(this.cS.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.b.f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.l.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar) {
                if (l.this.ql != null) {
                    l.this.ql.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.e(new com.kwad.components.core.webview.jshandler.i() { // from class: com.kwad.components.ad.reward.l.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.i
            public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    eVar.a(com.kwad.components.ad.reward.b.a.gQ().gR());
                }
            }
        }));
        WeakReference<j> weakReference = this.qm;
        aVar.b(new com.kwad.components.ad.reward.h.p(weakReference != null ? weakReference.get() : null, -1L, this.cV));
    }

    @Override // com.kwad.components.ad.i.b
    public final void ft() {
        WeakReference<j> weakReference = this.qm;
        com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.i.b
    public final void fu() {
        WeakReference<j> weakReference = this.qm;
        com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? weakReference.get() : null) != null, "end_card", l(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.i.b
    public final void fv() {
        WeakReference<j> weakReference = this.qm;
        com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? weakReference.get() : null) != null, "end_card", l(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }
}

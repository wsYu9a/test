package com.kwad.components.ad.reward.k.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.sdk.components.s;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.c.c implements e {
    private a yX;

    /* renamed from: com.kwad.components.ad.reward.k.a.c$1 */
    public class AnonymousClass1 implements com.kwad.components.ad.reward.c.d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.c.d
        public final void a(com.kwad.components.ad.reward.c.b bVar) {
            com.kwad.sdk.core.d.c.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar.hj());
            c.this.a(bVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k.a.c$2 */
    public class AnonymousClass2 implements o {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.o
        public final void a(i iVar, String str) {
            if (TextUtils.equals(str, "getExtraReward")) {
                iVar.a(com.kwad.components.ad.reward.c.a.hg().hh());
                com.kwad.components.ad.reward.c.a.hg().a(iVar);
            }
        }
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        a aVar = this.yX;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a
    public final com.kwad.components.core.webview.tachikoma.i ii() {
        this.yX = (a) this.adD;
        return new d(this.yX.jD(), this.yX.yV, getContext());
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        super.a(aVar);
        a aVar2 = this.yX;
        if (aVar2 == null || aVar2.jD() == null) {
            return;
        }
        this.yX.jD().f11688qe.cg();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(sVar, bVar);
        sVar.c(new f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.k.a.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.d.c.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.hj());
                c.this.a(bVar2);
            }
        }));
        sVar.c(new i(new o() { // from class: com.kwad.components.ad.reward.k.a.c.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.o
            public final void a(i iVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    iVar.a(com.kwad.components.ad.reward.c.a.hg().hh());
                    com.kwad.components.ad.reward.c.a.hg().a(iVar);
                }
            }
        }));
    }
}

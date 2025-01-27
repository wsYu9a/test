package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bi;

/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: com.kwad.components.ad.reward.presenter.i$1 */
    final class AnonymousClass1 extends aw {
        final /* synthetic */ Throwable sa;

        AnonymousClass1(Throwable th) {
            th = th;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            com.kwad.sdk.crash.b.g(th);
            i.this.hq();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        try {
            this.qt.oN.jH().jB();
        } catch (Throwable th) {
            bi.postOnUiThread(new aw() { // from class: com.kwad.components.ad.reward.presenter.i.1
                final /* synthetic */ Throwable sa;

                AnonymousClass1(Throwable th2) {
                    th = th2;
                }

                @Override // com.kwad.sdk.utils.aw
                public final void doTask() {
                    com.kwad.sdk.crash.b.g(th);
                    i.this.hq();
                }
            });
        }
    }
}

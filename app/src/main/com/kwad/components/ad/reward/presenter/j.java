package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class j extends b {

    /* renamed from: com.kwad.components.ad.reward.presenter.j$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ Throwable tN;

        public AnonymousClass1(Throwable th2) {
            th2 = th2;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ServiceProvider.reportSdkCaughtException(th2);
            j.this.hK();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        try {
            this.rO.f11689qf.kd();
        } catch (Throwable th2) {
            bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.presenter.j.1
                final /* synthetic */ Throwable tN;

                public AnonymousClass1(Throwable th22) {
                    th2 = th22;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    ServiceProvider.reportSdkCaughtException(th2);
                    j.this.hK();
                }
            });
        }
    }
}

package com.kwad.components.ad.reward.presenter.a;

import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* loaded from: classes.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    private AdLiveHandleClickListener tB = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.reward.presenter.a.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i2) {
            if (i2 == 1) {
                a.this.qt.a(1, a.this.getContext(), 115, 1);
            } else if (i2 == 2) {
                a.this.qt.a(1, a.this.getContext(), 117, 1);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.a.a$1 */
    final class AnonymousClass1 implements AdLiveHandleClickListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i2) {
            if (i2 == 1) {
                a.this.qt.a(1, a.this.getContext(), 115, 1);
            } else if (i2 == 2) {
                a.this.qt.a(1, a.this.getContext(), 117, 1);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        IAdLiveOfflineView iAdLiveOfflineView = this.qt.oO;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.registerClickListener(this.tB);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        IAdLiveOfflineView iAdLiveOfflineView = this.qt.oO;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.unRegisterClickListener(this.tB);
        }
    }
}

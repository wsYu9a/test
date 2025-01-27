package com.kwad.components.ad.reward.presenter.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {
    private AdLiveHandleClickListener vp = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.reward.presenter.b.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i10) {
            if (i10 == 1) {
                a.this.rO.a(1, a.this.getContext(), TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY, 1);
            } else if (i10 == 2) {
                a.this.rO.a(1, a.this.getContext(), TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE, 1);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.b.a$1 */
    public class AnonymousClass1 implements AdLiveHandleClickListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i10) {
            if (i10 == 1) {
                a.this.rO.a(1, a.this.getContext(), TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY, 1);
            } else if (i10 == 2) {
                a.this.rO.a(1, a.this.getContext(), TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE, 1);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        IAdLiveOfflineView iAdLiveOfflineView = this.rO.f11690qg;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.registerClickListener(this.vp);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        IAdLiveOfflineView iAdLiveOfflineView = this.rO.f11690qg;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.unRegisterClickListener(this.vp);
        }
    }
}

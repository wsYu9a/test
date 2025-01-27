package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.mvp.Presenter;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
public class a extends Presenter {
    public com.kwad.components.ad.reward.j qt;

    public final void L(boolean z) {
        int i2 = z ? 1 : TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND;
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, i2, jVar.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.qt = (com.kwad.components.ad.reward.j) Bh();
    }

    protected final void hq() {
        this.qt.hq();
    }
}

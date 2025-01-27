package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener {
    private TextView gO;
    private long gQ;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.b.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", b.this.qt.mAdTemplate).equals(str)) {
                b.this.cc();
            }
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.b.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            b.this.f(j2);
        }
    };
    private i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.b.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            b.this.f(j3);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.b$1 */
    final class AnonymousClass1 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", b.this.qt.mAdTemplate).equals(str)) {
                b.this.cc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.b$2 */
    final class AnonymousClass2 extends AdLivePlayStateListenerAdapter {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            b.this.f(j2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.b$3 */
    final class AnonymousClass3 extends com.kwad.components.core.video.j {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            b.this.f(j3);
        }
    }

    public void cc() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        AdTemplate adTemplate = jVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = jVar.mApkDownloadHelper;
        this.gQ = com.kwad.sdk.core.response.a.c.bN(adTemplate);
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    private void cd() {
        if (this.gO.getVisibility() == 0) {
            return;
        }
        String bO = com.kwad.sdk.core.response.a.c.bO(this.mAdTemplate);
        if (TextUtils.isEmpty(bO)) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_element_pv").aF(this.mAdTemplate).J("ELEMENT_PLAY_DETAIL_CALL_IMPRESSION", null).report();
            return;
        }
        this.gO.setText(bO);
        this.gO.setVisibility(0);
        this.gO.setOnClickListener(this);
        ce();
    }

    private void ce() {
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 18, this.qt.mReportExtData);
    }

    public void f(long j2) {
        if (j2 >= this.gQ) {
            cd();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        } else {
            cc();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.gO) {
            this.qt.a(1, view.getContext(), 40, 1, this.qt.oN.getPlayDuration());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gO = (TextView) findViewById(R.id.ksad_detail_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.gO.setVisibility(8);
    }
}

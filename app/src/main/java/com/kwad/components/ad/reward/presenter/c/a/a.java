package com.kwad.components.ad.reward.presenter.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.KSLoggerReporter;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c {
    private e gG = new e() { // from class: com.kwad.components.ad.reward.presenter.c.a.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.b(a.this);
            }
        }
    };
    private TextView vk;
    private TextView vl;

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a.a$1 */
    final class AnonymousClass1 extends e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.b(a.this);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a.a$2 */
    final class AnonymousClass2 implements a.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            a.this.iy();
            a.this.notifyAdClick();
        }
    }

    static /* synthetic */ void b(a aVar) {
    }

    private void ce() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 17, jVar.mReportExtData);
    }

    private void ix() {
        TextView textView;
        String bP = com.kwad.sdk.core.response.a.c.bP(this.qt.mAdTemplate);
        if (TextUtils.isEmpty(bP)) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_element_pv").aF(this.qt.mAdTemplate).J("ELEMENT_PLAY_END_CALL_IMPRESSION", null).report();
            return;
        }
        if (this.qt.mScreenOrientation == 1) {
            this.vl.setVisibility(8);
            this.vk.setText(bP);
            this.vk.setVisibility(0);
            textView = this.vk;
        } else {
            this.vk.setVisibility(8);
            this.vl.setText(bP);
            this.vl.setVisibility(0);
            textView = this.vl;
        }
        textView.setOnClickListener(this);
        ce();
    }

    public void iy() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 39, jVar.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
    }

    public void notifyAdClick() {
        this.qt.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a.c
    public final void iz() {
        if (this.qt.pq) {
            return;
        }
        ix();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vk || view == this.vl) {
            com.kwad.components.core.d.b.a.a(new a.C0172a(view.getContext()).I(this.qt.mAdTemplate).b(this.qt.mApkDownloadHelper).ao(false).ap(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.a.2
                AnonymousClass2() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    a.this.iy();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vk = (TextView) findViewById(R.id.ksad_end_left_call_btn);
        this.vl = (TextView) findViewById(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.vk.setVisibility(8);
        this.vl.setVisibility(8);
    }
}

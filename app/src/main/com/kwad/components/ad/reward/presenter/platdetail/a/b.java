package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bd;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private TextView iA;
    private long iC;

    /* renamed from: ia */
    private l f11813ia = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            b.this.g(j11);
        }
    };
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.b$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            b.this.g(j11);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.b$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.cy();
        }
    }

    private void cw() {
        this.mApkDownloadHelper = this.rO.mApkDownloadHelper;
        this.iC = com.kwad.sdk.core.response.b.d.dN(this.mAdTemplate);
        this.rO.f11689qf.a(this.f11813ia);
    }

    private void cx() {
        if (this.iA.getVisibility() == 0) {
            return;
        }
        this.iA.setText(com.kwad.sdk.core.response.b.d.dO(this.mAdTemplate));
        this.iA.setVisibility(0);
        this.iA.setOnClickListener(this);
        this.iA.post(new bd() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.this.cy();
            }
        });
    }

    public void cy() {
        this.rO.z("native_id");
    }

    public void g(long j10) {
        if (j10 >= this.iC) {
            cx();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        cw();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.iA) {
            this.rO.a(1, view.getContext(), 40, 1, this.rO.f11689qf.getPlayDuration());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        TextView textView = (TextView) findViewById(R.id.ksad_detail_call_btn);
        this.iA = textView;
        textView.setContentDescription("topBarCallLabel");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.f11813ia);
        this.iA.setVisibility(8);
    }
}

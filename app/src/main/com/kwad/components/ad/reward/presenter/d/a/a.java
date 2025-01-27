package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.m.a;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements a.b {
    private FrameLayout en;
    private l tX;

    /* renamed from: xc */
    private volatile long f11752xc = 0;

    /* renamed from: xd */
    private volatile boolean f11753xd = false;
    private l tY = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.f11753xd = false;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.f11753xd = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            a.this.f11752xc = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.f11753xd = false;
        }
    };

    /* renamed from: ia */
    private l f11751ia = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            a.this.f11752xc = j11;
            a.this.f11753xd = j10 - j11 < 800;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.4
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            if (a.this.rO.qN || a.this.rO.f11694qk == null) {
                return;
            }
            a.this.rO.f11694qk.aQ();
        }
    };

    /* renamed from: ee */
    private com.kwad.sdk.core.webview.d.a.a f11750ee = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.5
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            a.this.rO.f11688qe.cg();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.a$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.f11753xd = false;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.f11753xd = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            a.this.f11752xc = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.f11753xd = false;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.a$2 */
    public class AnonymousClass2 extends l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            a.this.f11752xc = j11;
            a.this.f11753xd = j10 - j11 < 800;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.a$3 */
    public class AnonymousClass3 implements a.InterfaceC0388a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.m.a.InterfaceC0388a
        public final void S(boolean z10) {
            a.this.rO.qH = z10;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.a$4 */
    public class AnonymousClass4 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            if (a.this.rO.qN || a.this.rO.f11694qk == null) {
                return;
            }
            a.this.rO.f11694qk.aQ();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.a$5 */
    public class AnonymousClass5 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            a.this.rO.f11688qe.cg();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.f11752xc = 0L;
        this.f11753xd = false;
        com.kwad.components.ad.reward.g gVar = this.rO;
        AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.m.a aVar = gVar.f11694qk;
        this.tX = gVar.f11689qf.kh() ? this.tY : this.f11751ia;
        if (aVar != null) {
            this.rO.qH = true;
            aVar.a(this);
            aVar.a(this.f11750ee);
            aVar.a(this.en, this.rO.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0388a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.components.ad.m.a.InterfaceC0388a
                public final void S(boolean z10) {
                    a.this.rO.qH = z10;
                }
            });
            aVar.setActivity(this.rO.getActivity());
            aVar.aX();
            this.rO.b(this.mPlayEndPageListener);
            this.rO.f11689qf.a(this.tX);
        }
    }

    @Override // com.kwad.components.ad.m.a.b
    public final void iR() {
        f.t(this.rO);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.en = (FrameLayout) findViewById(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.c(this.mPlayEndPageListener);
        this.rO.f11689qf.b(this.tX);
    }
}

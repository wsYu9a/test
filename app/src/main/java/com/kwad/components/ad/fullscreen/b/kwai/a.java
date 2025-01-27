package com.kwad.components.ad.fullscreen.b.kwai;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bm;

/* loaded from: classes.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements bm.a {
    private TextView gI;
    private View gJ;
    private bm gK;
    private boolean gL;
    private long gM;
    private AdInfo mAdInfo;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.this.cc();
            }
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.gL) {
                return;
            }
            a.this.gK.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (j2 > 800) {
                a.this.gM = j2;
                if (a.this.gM > 30000) {
                    a.this.gI.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.gJ.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(a.this.getContext(), 0.0f);
                    a.this.gJ.setLayoutParams(marginLayoutParams);
                }
                a.this.a(30000L, j2);
                a.a(a.this, true);
            }
        }
    };
    private i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            a.this.a(j2, j3);
            a.this.gM = j3;
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.a$1 */
    final class AnonymousClass1 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.this.cc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.a$2 */
    final class AnonymousClass2 extends AdLivePlayStateListenerAdapter {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.gL) {
                return;
            }
            a.this.gK.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (j2 > 800) {
                a.this.gM = j2;
                if (a.this.gM > 30000) {
                    a.this.gI.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.gJ.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(a.this.getContext(), 0.0f);
                    a.this.gJ.setLayoutParams(marginLayoutParams);
                }
                a.this.a(30000L, j2);
                a.a(a.this, true);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.a$3 */
    final class AnonymousClass3 extends com.kwad.components.core.video.j {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            a.this.a(j2, j3);
            a.this.gM = j3;
        }
    }

    private void A(int i2) {
        this.gI.setText(String.valueOf(i2));
    }

    public void a(long j2, long j3) {
        A(Math.max((int) (((j2 - j3) / 1000.0f) + 0.5f), 0));
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.gL = true;
        return true;
    }

    public void cc() {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        this.mAdInfo = cb;
        this.gI.setText(String.valueOf(com.kwad.sdk.core.response.a.a.F(cb)));
        this.gI.setVisibility(0);
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.qt.fW() || this.qt.fV()) {
                this.gK.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            long j2 = this.gM + 500;
            this.gM = j2;
            if (j2 <= 30000) {
                a(30000L, j2);
                this.gK.sendEmptyMessageDelayed(1, 500L);
            } else {
                this.gI.setVisibility(8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gJ.getLayoutParams();
                marginLayoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(getContext(), 0.0f);
                this.gJ.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.gK = new bm(this);
        if (com.kwad.components.ad.reward.j.c(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            return;
        }
        cc();
        if (this.qt.oN.jF()) {
            A(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gI = (TextView) findViewById(R.id.ksad_video_count_down);
        this.gJ = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.gL = false;
        this.gK.removeCallbacksAndMessages(null);
    }
}

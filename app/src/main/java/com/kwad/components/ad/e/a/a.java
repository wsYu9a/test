package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;

/* loaded from: classes.dex */
public final class a extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private KsAdVideoPlayConfig dZ;
    private ViewGroup nm;
    private ImageView nn;
    private TextView no;

    /* renamed from: com.kwad.components.ad.e.a.a$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            a.this.eS();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            a.this.eS();
        }
    }

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dZ = ksAdVideoPlayConfig;
    }

    public void eS() {
        if (this.nm.getVisibility() != 0) {
            return;
        }
        this.nm.setVisibility(8);
    }

    private boolean f(AdInfo adInfo) {
        if (!ag.isNetworkConnected(getContext())) {
            return false;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dZ;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return true;
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ag.isWifiConnected(getContext());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return ag.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ag.isMobileConnected(getContext()));
            }
        }
        if (com.kwad.sdk.core.response.a.a.bH(adInfo)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.bI(adInfo) && ag.isWifiConnected(getContext());
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        ViewGroup viewGroup;
        int i2;
        super.ar();
        if (f(com.kwad.sdk.core.response.a.d.cb(this.ni.mAdTemplate))) {
            viewGroup = this.nm;
            i2 = 8;
        } else {
            this.no.setText(bg.I(com.kwad.sdk.core.response.a.a.F(r0) * 1000));
            this.nn.setOnClickListener(this);
            this.ni.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            viewGroup = this.nm;
            i2 = 0;
        }
        viewGroup.setVisibility(i2);
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                a.this.eS();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                a.this.eS();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.nn) {
            this.ni.nj.fa();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nm = (ViewGroup) findViewById(R.id.ksad_data_flow_container);
        this.nn = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.no = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
    }
}

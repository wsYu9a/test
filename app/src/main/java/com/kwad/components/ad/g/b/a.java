package com.kwad.components.ad.g.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.br;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.g.a.a implements View.OnClickListener {
    private KsAdVideoPlayConfig bS;

    /* renamed from: ok */
    private ViewGroup f11532ok;
    private ImageView ol;
    private TextView om;

    /* renamed from: com.kwad.components.ad.g.b.a$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.eP();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.eP();
        }
    }

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.bS = ksAdVideoPlayConfig;
    }

    private boolean e(AdInfo adInfo) {
        if (!al.isNetworkConnected(getContext())) {
            return false;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.bS;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return true;
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return al.isWifiConnected(getContext());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return al.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && al.isMobileConnected(getContext()));
            }
        }
        if (com.kwad.sdk.core.response.b.a.cb(adInfo)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.cc(adInfo) && al.isWifiConnected(getContext());
    }

    public void eP() {
        if (this.f11532ok.getVisibility() != 0) {
            return;
        }
        this.f11532ok.setVisibility(8);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (e(com.kwad.sdk.core.response.b.e.eb(this.f11530oe.mAdTemplate))) {
            this.f11532ok.setVisibility(8);
        } else {
            this.om.setText(br.ak(com.kwad.sdk.core.response.b.a.L(r0) * 1000));
            this.ol.setOnClickListener(this);
            this.f11530oe.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f11532ok.setVisibility(0);
        }
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                a.this.eP();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                a.this.eP();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ol) {
            this.f11530oe.f11531of.eY();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11532ok = (ViewGroup) findViewById(R.id.ksad_data_flow_container);
        this.ol = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.om = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
    }
}

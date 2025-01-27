package com.kwad.components.ad.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bx;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public final class d extends com.kwad.components.core.video.a implements bx.a {
    private View bN;
    private final bx bO;
    private final AtomicBoolean bP;
    private boolean bQ;
    private boolean bR;
    private final KsAdVideoPlayConfig bS;

    public d(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.bO = new bx(this);
        this.bP = new AtomicBoolean(true);
        this.bR = true;
        this.bN = this;
        this.bS = ksAdVideoPlayConfig;
    }

    private void Z() {
        if (this.bP.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onViewAttached");
            this.bO.sendEmptyMessage(1);
        }
    }

    private void aa() {
        if (this.bP.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onViewDetached");
        this.bO.removeCallbacksAndMessages(null);
        if (this.bR) {
            release();
        } else {
            this.aFX.pause();
        }
    }

    private boolean ac() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.bS;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return al.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return al.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? al.isNetworkConnected(this.mContext) : al.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.b.a.bX(this.mAdInfo)) {
            return al.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.b.a.bY(this.mAdInfo)) {
            return al.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.sdk.utils.bx.a
    public final void a(Message message) {
        if (!this.Wf && message.what == 1) {
            if (!bw.o(this.bN, 30)) {
                ss();
            } else if (!this.bQ) {
                ab();
            }
            this.bO.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void ab() {
        if (!this.aFX.isIdle()) {
            if (this.aFX.isPaused() || this.aFX.HY()) {
                sr();
                this.aFX.restart();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar = this.Wu;
        if (aVar != null) {
            aVar.onStart();
        }
        if (!al.isNetworkConnected(this.mContext)) {
            sn();
            return;
        }
        so();
        if (this.Wf) {
            sr();
            this.aFX.start();
            return;
        }
        if (ac()) {
            sr();
            this.aFX.start();
        } else {
            if (this.Wd) {
                sr();
                this.aFX.start();
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(60, 60);
            layoutParams.addRule(13, -1);
            this.om.setVisibility(8);
            this.ol.setLayoutParams(layoutParams);
            sp();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onAttachedToWindow");
        Z();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onDetachedFromWindow");
        aa();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onFinishTemporaryDetach");
        Z();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onStartTemporaryDetach");
        aa();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
    }
}

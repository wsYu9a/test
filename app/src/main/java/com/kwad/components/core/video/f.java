package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bx;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class f extends com.kwad.components.core.video.a implements bx.a {
    private boolean FS;
    private boolean Xu;
    private boolean Xv;
    private View bN;
    private final bx bO;
    private final AtomicBoolean bP;

    public interface a extends a.c {
        void onVideoPlayError(int i10, int i11);
    }

    public f(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.bO = new bx(this);
        this.bP = new AtomicBoolean(true);
        this.FS = false;
        this.Xu = false;
        this.Xv = false;
        this.bN = this;
    }

    private void Z() {
        if (this.bP.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewAttached");
            this.bO.sendEmptyMessage(1);
        }
    }

    private void aa() {
        if (this.bP.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewDetached");
        this.bO.removeCallbacksAndMessages(null);
        release();
    }

    private void sP() {
        this.FS = false;
    }

    @Override // com.kwad.sdk.utils.bx.a
    public final void a(Message message) {
        if (!this.FS && message.what == 1) {
            if (this.Xv) {
                this.bO.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (bw.o(this.bN, 70)) {
                ab();
            } else {
                ss();
            }
            this.bO.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void ab() {
        super.ab();
    }

    @Override // com.kwad.components.core.video.a
    public final void eR() {
        if (this.Xu) {
            super.eR();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        sP();
        Z();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        aa();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        Z();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
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

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.FS = true;
    }

    public final void setShowLandingPage(boolean z10) {
        this.Xv = z10;
    }

    @Override // com.kwad.components.core.video.a
    public final void sl() {
        super.sl();
        ImageView imageView = this.ol;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        TextView textView = this.om;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void ss() {
        super.ss();
    }
}

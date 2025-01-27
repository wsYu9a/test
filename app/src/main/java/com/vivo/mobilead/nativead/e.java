package com.vivo.mobilead.nativead;

import android.view.ViewTreeObserver;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;

/* loaded from: classes4.dex */
public class e implements com.vivo.ad.nativead.d {

    /* renamed from: a */
    private NativeUnifiedADData f29619a;

    /* renamed from: b */
    private MediaListener f29620b;

    /* renamed from: c */
    private MediaView f29621c;

    /* renamed from: d */
    private boolean f29622d;

    /* renamed from: e */
    private boolean f29623e;

    /* renamed from: f */
    private ViewTreeObserver.OnWindowFocusChangeListener f29624f = d();

    /* renamed from: g */
    private NativeADMediaListener f29625g = new b();

    class a implements ViewTreeObserver.OnWindowFocusChangeListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            if (e.this.f29621c != null) {
                e.this.f29621c.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            }
            if (e.this.f29619a != null) {
                e.this.f29619a.resume();
                e.this.f29619a.startVideo();
            }
        }
    }

    class b implements NativeADMediaListener {
        b() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            if (e.this.f29620b != null) {
                e.this.f29620b.onVideoCompletion();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            if (e.this.f29620b != null) {
                e.this.f29620b.onVideoError(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
            e.this.f29622d = true;
            if (e.this.f29623e) {
                e.this.a();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i2) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            if (e.this.f29620b != null) {
                e.this.f29620b.onVideoPause();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            if (e.this.f29620b != null) {
                e.this.f29620b.onVideoPlay();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            if (e.this.f29620b != null) {
                e.this.f29620b.onVideoStart();
                e.this.f29620b.onVideoPlay();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }
    }

    private ViewTreeObserver.OnWindowFocusChangeListener d() {
        return new a();
    }

    @Override // com.vivo.ad.nativead.d
    public void b() {
        NativeUnifiedADData nativeUnifiedADData = this.f29619a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.pauseVideo();
        }
    }

    @Override // com.vivo.ad.nativead.d
    public void c() {
        NativeUnifiedADData nativeUnifiedADData = this.f29619a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.stopVideo();
        }
        MediaView mediaView = this.f29621c;
        if (mediaView != null && this.f29624f != null) {
            mediaView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.f29624f);
        }
        this.f29623e = false;
        this.f29622d = false;
        this.f29624f = null;
    }

    @Override // com.vivo.ad.nativead.d
    public void a() {
        if (this.f29622d) {
            MediaView mediaView = this.f29621c;
            if (mediaView != null) {
                if (mediaView.isShown()) {
                    NativeUnifiedADData nativeUnifiedADData = this.f29619a;
                    if (nativeUnifiedADData != null) {
                        nativeUnifiedADData.startVideo();
                        return;
                    }
                    return;
                }
                if (this.f29624f == null) {
                    this.f29624f = d();
                }
                this.f29621c.getViewTreeObserver().addOnWindowFocusChangeListener(this.f29624f);
                return;
            }
            return;
        }
        this.f29623e = true;
    }

    public void a(NativeUnifiedADData nativeUnifiedADData) {
        this.f29619a = nativeUnifiedADData;
    }

    public void a(MediaView mediaView) {
        if (mediaView == null || this.f29619a == null || this.f29625g == null) {
            return;
        }
        this.f29621c = mediaView;
        VideoOption.Builder enableUserControl = new VideoOption.Builder().setAutoPlayPolicy(2).setAutoPlayMuted(true).setEnableUserControl(true);
        this.f29619a.setVideoMute(false);
        this.f29619a.bindMediaView(mediaView, enableUserControl.build(), this.f29625g);
    }

    @Override // com.vivo.ad.nativead.d
    public void a(MediaListener mediaListener) {
        this.f29620b = mediaListener;
    }
}

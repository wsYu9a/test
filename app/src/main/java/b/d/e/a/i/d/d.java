package b.d.e.a.i.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.d.e.a.h;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.sdk.client.AdBiddingLossReason;
import com.martian.ttbook.sdk.client.AdDownloadConfirmListener;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.NativeAdAppMiitInfo;
import com.martian.ttbook.sdk.client.NativeAdListener;
import com.martian.ttbook.sdk.client.NativeAdListenerExt;
import com.martian.ttbook.sdk.client.VideoSettings;
import com.martian.ttbook.sdk.client.media.MediaAdView;
import com.martian.ttbook.sdk.client.media.NativeAdMediaListener;
import java.util.List;

/* loaded from: classes4.dex */
public class d extends h {

    /* renamed from: a */
    private com.martian.ttbook.b.c.a.a.c.l.d f4514a;

    /* renamed from: b */
    private boolean f4515b = false;

    /* renamed from: c */
    private boolean f4516c = false;

    /* renamed from: d */
    private boolean f4517d = false;

    class a implements d.b {

        /* renamed from: a */
        final /* synthetic */ NativeAdListener f4518a;

        a(d dVar, NativeAdListener nativeAdListener) {
            this.f4518a = nativeAdListener;
        }

        @Override // com.martian.ttbook.b.c.a.a.c.e
        public void a(com.martian.ttbook.b.c.a.a.c.d dVar) {
            this.f4518a.onAdError(new AdError(dVar.a(), dVar.b()));
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.d.b
        public void onADStatusChanged(int i2) {
            NativeAdListener nativeAdListener = this.f4518a;
            if (nativeAdListener instanceof NativeAdListenerExt) {
                ((NativeAdListenerExt) nativeAdListener).onADStatusChanged(i2);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.d.a
        public void onAdClicked() {
            this.f4518a.onADClicked();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.d.a
        public void onAdExposed() {
            this.f4518a.onADExposed();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.d.b
        public void onLoadApkProgress(int i2) {
            NativeAdListener nativeAdListener = this.f4518a;
            if (nativeAdListener instanceof NativeAdListenerExt) {
                ((NativeAdListenerExt) nativeAdListener).onLoadApkProgress(i2);
            }
        }
    }

    class b implements com.martian.ttbook.b.c.a.a.c.q.a {

        /* renamed from: a */
        final /* synthetic */ NativeAdMediaListener f4519a;

        b(d dVar, NativeAdMediaListener nativeAdMediaListener) {
            this.f4519a = nativeAdMediaListener;
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void a(com.martian.ttbook.b.c.a.a.c.d dVar) {
            this.f4519a.onVideoError(new AdError(dVar.a(), dVar.b()));
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoClicked() {
            this.f4519a.onVideoClicked();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoCompleted() {
            this.f4519a.onVideoCompleted();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoInit() {
            this.f4519a.onVideoInit();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoLoaded(int i2) {
            this.f4519a.onVideoLoaded(i2);
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoLoading() {
            this.f4519a.onVideoLoading();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoPause() {
            this.f4519a.onVideoPause();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoReady() {
            this.f4519a.onVideoReady();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoResume() {
            this.f4519a.onVideoResume();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoStart() {
            this.f4519a.onVideoStart();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.q.a
        public void onVideoStop() {
            this.f4519a.onVideoStop();
        }
    }

    public d(com.martian.ttbook.b.c.a.a.c.l.d dVar) {
        this.f4514a = dVar;
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void bindMediaView(MediaAdView mediaAdView, VideoSettings videoSettings, NativeAdMediaListener nativeAdMediaListener) {
        this.f4517d = true;
        this.f4514a.n(mediaAdView, new b(this, nativeAdMediaListener));
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void bindMediaView(MediaAdView mediaAdView, NativeAdMediaListener nativeAdMediaListener) {
        bindMediaView(mediaAdView, null, nativeAdMediaListener);
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdData
    public View bindView(View view, ViewGroup.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2, List<View> list, View view2, NativeAdListener nativeAdListener) {
        return bindView(view, layoutParams, layoutParams2, list, view2, null, nativeAdListener);
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdData
    public View bindView(View view, ViewGroup.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2, List<View> list, View view2, Object obj, NativeAdListener nativeAdListener) {
        return this.f4514a.h(view.getContext(), view, obj, layoutParams2, list, view2, new a(this, nativeAdListener));
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdData
    public View bindView(View view, ViewGroup.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2, List<View> list, NativeAdListener nativeAdListener) {
        return bindView(view, layoutParams, layoutParams2, list, null, null, nativeAdListener);
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public NativeAdAppMiitInfo getAdAppMiitInfo() {
        return new e(this.f4514a.d());
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public AdExtras getAdExtras() {
        AdExtras adExtras = AdExtras.EMPTY;
        com.martian.ttbook.b.c.a.a.c.l.d dVar = this.f4514a;
        return dVar != null ? b.d.e.a.a.c(dVar.a()) : adExtras;
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public int getAdPatternType() {
        return this.f4514a.getAdPatternType();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public int getAppStatus() {
        return this.f4514a.getAppStatus();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public String getDesc() {
        return this.f4514a.getDesc();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public String getIconUrl() {
        return this.f4514a.getIconUrl();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public List<String> getImageList() {
        return this.f4514a.g();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public String getImageUrl() {
        return this.f4514a.getImageUrl();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public int getMediaHeight() {
        return this.f4514a.e();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public int getMediaWidth() {
        return this.f4514a.f();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public String getTitle() {
        return this.f4514a.getTitle();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public String getVideoCoverImage() {
        return this.f4514a.getVideoCoverImage();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public int getVideoCurrentPosition() {
        return this.f4514a.getVideoCurrentPosition();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public int getVideoDuration() {
        return this.f4514a.c();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdData
    public boolean isAppAd() {
        return this.f4514a.isAppAd();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public boolean isBindedMediaView() {
        return this.f4517d;
    }

    @Override // com.martian.ttbook.sdk.client.data.AdData
    public boolean isRecycled() {
        return this.f4515b;
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public boolean isVideoAd() {
        return this.f4514a.isVideoAd();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public boolean isVideoAdExposured() {
        return this.f4516c;
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void onVideoAdExposured(View view) {
        this.f4514a.a(view);
        this.f4516c = true;
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void pauseAppDownload() {
        this.f4514a.pauseAppDownload();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void pauseVideo() {
        this.f4514a.pauseVideo();
    }

    @Override // com.martian.ttbook.sdk.client.data.AdData
    public boolean recycle() {
        this.f4514a.b();
        this.f4515b = true;
        return true;
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdData
    public void resume() {
        this.f4514a.resume();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void resumeAppDownload() {
        this.f4514a.resumeAppDownload();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void resumeVideo() {
        this.f4514a.resumeVideo();
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void sendLossNotification(AdBiddingLossReason adBiddingLossReason, int i2, String str) {
        this.f4514a.a(b.d.e.a.j.h.a(adBiddingLossReason), i2, str);
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void sendWinNotification(int i2) {
        this.f4514a.sendWinNotification(i2);
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void setAdDownloadConfirmListener(AdDownloadConfirmListener adDownloadConfirmListener) {
        this.f4514a.c(new b.d.e.a.c(adDownloadConfirmListener));
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void setVideoMute(boolean z) {
        this.f4514a.setVideoMute(z);
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void startVideo() {
        this.f4514a.startVideo();
    }

    @Override // com.martian.ttbook.sdk.client.NativeMediaAdData
    public void stopVideo() {
        this.f4514a.stopVideo();
    }
}

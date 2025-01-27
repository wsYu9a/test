package b.a.a.a.c.d.a;

import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: classes.dex */
public class e extends h implements TTFeedAd {

    /* renamed from: d */
    private final TTFeedAd f4178d;

    public e(TTFeedAd tTFeedAd, String str, int i2) {
        super(tTFeedAd, str, i2);
        this.f4178d = tTFeedAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        return this.f4178d.getAdViewHeight();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        return this.f4178d.getAdViewWidth();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public TTFeedAd.CustomizeVideo getCustomVideo() {
        return this.f4178d.getCustomVideo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        return this.f4178d.getVideoDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        this.f4178d.setVideoAdListener(videoAdListener);
    }
}

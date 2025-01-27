package b.a.a.a.c.d.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;

/* loaded from: classes.dex */
public class d extends e implements TTDrawFeedAd {

    /* renamed from: e */
    private final TTDrawFeedAd f4177e;

    public d(TTDrawFeedAd tTDrawFeedAd, String str, int i2) {
        super(tTDrawFeedAd, str, i2);
        this.f4177e = tTDrawFeedAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z) {
        this.f4177e.setCanInterruptVideoPlay(z);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.f4177e.setDrawVideoListener(drawVideoListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i2) {
        this.f4177e.setPauseIcon(bitmap, i2);
    }
}

package b.d.a;

import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.martian.apptask.data.ViewWrapper;

/* loaded from: classes2.dex */
public class c extends ViewWrapper {

    /* renamed from: a */
    private final FeedPortraitVideoView f4358a;

    public c(FeedPortraitVideoView ad2) {
        super(ad2.getRootView());
        this.f4358a = ad2;
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        FeedPortraitVideoView feedPortraitVideoView = this.f4358a;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    protected void onInit() {
        FeedPortraitVideoView feedPortraitVideoView = this.f4358a;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(true);
            this.f4358a.play();
        }
    }
}

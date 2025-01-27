package b8;

import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.martian.apptask.data.ViewWrapper;

/* loaded from: classes3.dex */
public class l extends ViewWrapper {

    /* renamed from: a */
    public final FeedPortraitVideoView f1444a;

    public l(FeedPortraitVideoView feedPortraitVideoView) {
        super(feedPortraitVideoView.getRootView());
        this.f1444a = feedPortraitVideoView;
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        FeedPortraitVideoView feedPortraitVideoView = this.f1444a;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onInit() {
        FeedPortraitVideoView feedPortraitVideoView = this.f1444a;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(true);
            this.f1444a.play();
        }
    }
}

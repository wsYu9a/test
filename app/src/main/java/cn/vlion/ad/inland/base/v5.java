package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.ad.view.video.VlionBaseVideoView;
import cn.vlion.ad.inland.ad.view.video.VolumeControlView;

/* loaded from: classes.dex */
public final class v5 implements VolumeControlView.b {

    /* renamed from: a */
    public final /* synthetic */ VlionRewardVideoActivity f3470a;

    public v5(VlionRewardVideoActivity vlionRewardVideoActivity) {
        this.f3470a = vlionRewardVideoActivity;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VolumeControlView.b
    public final void a(boolean z10) {
        VlionBaseVideoView vlionBaseVideoView = this.f3470a.f2333k;
        if (vlionBaseVideoView != null) {
            vlionBaseVideoView.setClosedVolumePlay(z10);
        }
    }
}

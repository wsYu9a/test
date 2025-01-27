package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.ad.view.video.VolumeControlView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class t1 implements VolumeControlView.b {

    /* renamed from: a */
    public final /* synthetic */ View f3371a;

    public t1(View view) {
        this.f3371a = view;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VolumeControlView.b
    public final void a(boolean z10) {
        try {
            View view = this.f3371a;
            if (view != null) {
                ((a7) view).setClosedVolumePlay(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

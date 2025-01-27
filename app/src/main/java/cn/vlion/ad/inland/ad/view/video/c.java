package cn.vlion.ad.inland.ad.view.video;

import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class c implements VlionAdClosedView.d {

    /* renamed from: a */
    public final /* synthetic */ VlionVideoEndCardView f2566a;

    public c(VlionVideoEndCardView vlionVideoEndCardView) {
        this.f2566a = vlionVideoEndCardView;
    }

    @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
    public final void a() {
        try {
            VlionVideoEndCardView.a aVar = this.f2566a.f2547k;
            if (aVar != null) {
                aVar.onAdClose();
            }
            this.f2566a.setVisibility(8);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
    public final void a(boolean z10) {
        try {
            VlionVideoEndCardView.a aVar = this.f2566a.f2547k;
            if (aVar != null) {
                aVar.onAdClose();
            }
            this.f2566a.setVisibility(8);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

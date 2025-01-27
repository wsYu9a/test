package cn.vlion.ad.inland.ad.reward;

import android.view.View;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ VlionRewardVideoActivity.d f2371a;

    public b(VlionRewardVideoActivity.d dVar) {
        this.f2371a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            VlionRewardVideoActivity.this.E.setVisibility(8);
            VlionRewardVideoActivity.this.F.setVisibility(0);
            VlionRewardVideoActivity.this.d();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

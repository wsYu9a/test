package cn.vlion.ad.inland.base;

import android.view.ViewGroup;
import cn.vlion.ad.inland.base.d1;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class f1 implements d1.a {

    /* renamed from: a */
    public final /* synthetic */ e1 f2779a;

    public f1(e1 e1Var) {
        this.f2779a = e1Var;
    }

    public final void a(int i10, int i11) {
        try {
            if (this.f2779a.f2735p != null) {
                LogVlion.e("VlionBaseVideoViewCenter mSurfaceView MeasuredDimension getWidth==" + i10 + "  ---getHeight =" + i11);
                ViewGroup.LayoutParams layoutParams = this.f2779a.f2735p.getLayoutParams();
                layoutParams.width = i10;
                layoutParams.height = i11;
                this.f2779a.f2735p.setLayoutParams(layoutParams);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.h5;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class g5 implements ImageCallback {

    /* renamed from: a */
    public final /* synthetic */ h5 f2818a;

    public g5(h5 h5Var) {
        this.f2818a = h5Var;
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        h5.a aVar;
        h5 h5Var = this.f2818a;
        int i10 = h5Var.f2854g + 1;
        h5Var.f2854g = i10;
        if (i10 != h5Var.f2853f || h5Var.f2849b || (aVar = this.f2818a.f2848a) == null || vlionAdBaseError == null) {
            return;
        }
        i1 i1Var = new i1(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
        g0 g0Var = f7.this.f2803a;
        if (g0Var != null) {
            g0Var.a(i1Var);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        f7 f7Var;
        g0 g0Var;
        try {
            LogVlion.e("VlionImageViewGroup  downloadBitmap vlionImg=" + vlionImageSuccessData.getWidth() + "  " + vlionImageSuccessData.getHeight());
            h5 h5Var = this.f2818a;
            h5Var.f2854g = h5Var.f2854g + 1;
            h5Var.f2855h = vlionImageSuccessData.getWidth();
            this.f2818a.f2856i = vlionImageSuccessData.getHeight();
            if (this.f2818a.f2849b) {
                return;
            }
            this.f2818a.f2849b = true;
            h5.a aVar = this.f2818a.f2848a;
            if (aVar == null || (g0Var = (f7Var = f7.this).f2803a) == null) {
                return;
            }
            g0Var.onAdRenderSuccess(f7Var.f2808f);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

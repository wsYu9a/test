package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class e5 implements ImageCallback {

    /* renamed from: a */
    public final /* synthetic */ f5 f2765a;

    public e5(f5 f5Var) {
        this.f2765a = f5Var;
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        try {
            if (this.f2765a.f2799a == null || vlionAdBaseError == null) {
                return;
            }
            new i1(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        try {
            this.f2765a.getClass();
            if (vlionImageSuccessData != null) {
                this.f2765a.f2800b = vlionImageSuccessData.getWidth();
                this.f2765a.f2801c = vlionImageSuccessData.getHeight();
                b bVar = this.f2765a.f2799a;
            } else if (this.f2765a.f2799a != null) {
                i1 i1Var = i1.f2913c;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            if (this.f2765a.f2799a != null) {
                i1 i1Var2 = i1.f2913c;
            }
        }
    }
}

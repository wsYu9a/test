package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class s5 implements ImageCallback {

    /* renamed from: a */
    public final /* synthetic */ t5 f3365a;

    public s5(t5 t5Var) {
        this.f3365a = t5Var;
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        try {
            this.f3365a.f3384i = u.b().a(this.f3365a.f3383h);
            this.f3365a.d();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

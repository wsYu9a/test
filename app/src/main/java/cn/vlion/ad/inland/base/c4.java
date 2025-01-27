package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class c4 implements q0.c {

    /* renamed from: a */
    public final /* synthetic */ VlionADClickType f2680a;

    /* renamed from: b */
    public final /* synthetic */ b4 f2681b;

    public class a implements VlionDownloadSecondConfirmActivity.d {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a(VlionADClickType vlionADClickType) {
            LogVlion.e("VlionCustomNativeAdManager onDownloadClick  onAdClick");
            b4.a(c4.this.f2681b, vlionADClickType);
        }
    }

    public c4(b4 b4Var, VlionADClickType vlionADClickType) {
        this.f2681b = b4Var;
        this.f2680a = vlionADClickType;
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void a() {
        b4.a(this.f2681b, this.f2680a);
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void b() {
        try {
            b4 b4Var = this.f2681b;
            if (b4Var.f2660q.f3542c != null && b4Var.f2658o != null) {
                LogVlion.e("VlionCustomNativeAdManager onNoTaskShowDownConfirm  onAdClick");
                b4 b4Var2 = this.f2681b;
                VlionDownloadSecondConfirmActivity.a(b4Var2.f2660q.f3542c, b4Var2.f2658o, new a());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void c() {
    }
}

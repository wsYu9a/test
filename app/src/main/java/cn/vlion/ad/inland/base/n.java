package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class n implements q0.c {

    /* renamed from: a */
    public final /* synthetic */ VlionADClickType f3104a;

    /* renamed from: b */
    public final /* synthetic */ j f3105b;

    public class a implements VlionDownloadSecondConfirmActivity.d {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a(VlionADClickType vlionADClickType) {
            j.a(n.this.f3105b, vlionADClickType);
        }
    }

    public n(j jVar, VlionADClickType vlionADClickType) {
        this.f3105b = jVar;
        this.f3104a = vlionADClickType;
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void a() {
        LogVlion.e("CustomVlionSplashView onClickAction ");
        j.a(this.f3105b, this.f3104a);
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void b() {
        try {
            VlionAdapterADConfig vlionAdapterADConfig = this.f3105b.f2974w;
            if (vlionAdapterADConfig == null || vlionAdapterADConfig.getSecondPop() != 0) {
                VlionDownloadSecondConfirmActivity.a(this.f3105b.getContext(), this.f3105b.f2973v, new a());
            } else {
                j.a(this.f3105b, this.f3104a);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void c() {
    }
}

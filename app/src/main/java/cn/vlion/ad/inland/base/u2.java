package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class u2 implements q0.c {

    /* renamed from: a */
    public final /* synthetic */ VlionADClickType f3392a;

    /* renamed from: b */
    public final /* synthetic */ y2 f3393b;

    public class a implements VlionDownloadSecondConfirmActivity.d {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a(VlionADClickType vlionADClickType) {
            y2.a(u2.this.f3393b, vlionADClickType);
        }
    }

    public u2(y2 y2Var, VlionADClickType vlionADClickType) {
        this.f3393b = y2Var;
        this.f3392a = vlionADClickType;
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void a() {
        try {
            if (VlionServiceConfigParse.getInstance().isHotspot()) {
                y2.a(this.f3393b, this.f3392a);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void b() {
        try {
            if (VlionServiceConfigParse.getInstance().isHotspot()) {
                y2.a(this.f3393b, this.f3392a);
            } else {
                VlionDownloadSecondConfirmActivity.a(this.f3393b.getContext(), this.f3393b.f3527z, new a());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void c() {
    }
}

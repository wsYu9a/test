package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class f2 implements q0.c {

    /* renamed from: a */
    public final /* synthetic */ VlionADClickType f2780a;

    /* renamed from: b */
    public final /* synthetic */ i2 f2781b;

    public class a implements VlionDownloadSecondConfirmActivity.d {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a(VlionADClickType vlionADClickType) {
            i2.a(f2.this.f2781b, vlionADClickType);
        }
    }

    public f2(i2 i2Var, VlionADClickType vlionADClickType) {
        this.f2781b = i2Var;
        this.f2780a = vlionADClickType;
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void a() {
        try {
            if (VlionServiceConfigParse.getInstance().isHotspot()) {
                i2.a(this.f2781b, this.f2780a);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void b() {
        try {
            if (VlionServiceConfigParse.getInstance().isHotspot()) {
                i2.a(this.f2781b, this.f2780a);
            } else {
                i2 i2Var = this.f2781b;
                VlionDownloadSecondConfirmActivity.a(i2Var.f2935u, i2Var.A, new a());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void c() {
    }
}

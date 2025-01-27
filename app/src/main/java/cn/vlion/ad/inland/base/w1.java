package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class w1 implements q0.c {

    /* renamed from: a */
    public final /* synthetic */ VlionADClickType f3478a;

    /* renamed from: b */
    public final /* synthetic */ v1 f3479b;

    public class a implements VlionDownloadSecondConfirmActivity.d {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity.d
        public final void a(VlionADClickType vlionADClickType) {
            v1.a(w1.this.f3479b, vlionADClickType);
        }
    }

    public w1(v1 v1Var, VlionADClickType vlionADClickType) {
        this.f3479b = v1Var;
        this.f3478a = vlionADClickType;
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void a() {
        try {
            if (VlionServiceConfigParse.getInstance().isHotspot()) {
                v1.a(this.f3479b, this.f3478a);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void b() {
        try {
            if (VlionServiceConfigParse.getInstance().isHotspot()) {
                v1.a(this.f3479b, this.f3478a);
            } else {
                new x4(this.f3479b.f3445x).a(this.f3479b.f3445x.getWindow().getDecorView(), this.f3479b.f3429h, new a());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void c() {
    }
}

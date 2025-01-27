package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.v3;

/* loaded from: classes.dex */
public final class q3 implements q0.c {

    /* renamed from: a */
    public final /* synthetic */ VlionADClickType f3322a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomInterstitialActivity f3323b;

    public class a implements z1 {
        public a() {
        }

        @Override // cn.vlion.ad.inland.base.z1
        public final void a() {
        }

        @Override // cn.vlion.ad.inland.base.z1
        public final void a(VlionADClickType vlionADClickType) {
            VlionCustomInterstitialActivity.a(q3.this.f3323b, vlionADClickType);
        }
    }

    public q3(VlionCustomInterstitialActivity vlionCustomInterstitialActivity, VlionADClickType vlionADClickType) {
        this.f3323b = vlionCustomInterstitialActivity;
        this.f3322a = vlionADClickType;
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void a() {
        try {
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3323b;
            if (vlionCustomInterstitialActivity.C) {
                VlionCustomInterstitialActivity.a(vlionCustomInterstitialActivity, this.f3322a);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void b() {
        try {
            LogVlion.e("VlionCustomInterstitialActivity onNoTaskShowDownConfirm ");
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3323b;
            if (vlionCustomInterstitialActivity.C) {
                VlionCustomInterstitialActivity.a(vlionCustomInterstitialActivity, this.f3322a);
            } else {
                vlionCustomInterstitialActivity.f2253q.a(VlionCustomInterstitialActivity.I, new a());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void c() {
        try {
            LogVlion.e("VlionCustomInterstitialActivity onAlreadyDownLoadBegin ");
            this.f3322a.setTarget(VlionCustomAdActiveType$VlionCustomTarget.downloading.toString());
            j1 j1Var = VlionCustomInterstitialActivity.F;
            if (j1Var != null) {
                ((v3.a) j1Var).a(this.f3322a);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

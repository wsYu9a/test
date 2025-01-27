package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class a6 implements q0.c {

    /* renamed from: a */
    public final /* synthetic */ VlionADClickType f2615a;

    /* renamed from: b */
    public final /* synthetic */ VlionRewardVideoActivity f2616b;

    public class a implements z1 {
        public a() {
        }

        @Override // cn.vlion.ad.inland.base.z1
        public final void a() {
        }

        @Override // cn.vlion.ad.inland.base.z1
        public final void a(VlionADClickType vlionADClickType) {
            LogVlion.e("VlionRewardVideoViewActivity onShowShowDownConfirm  onButtonArea");
            VlionRewardVideoActivity.a(a6.this.f2616b, vlionADClickType);
        }
    }

    public a6(VlionRewardVideoActivity vlionRewardVideoActivity, VlionADClickType vlionADClickType) {
        this.f2616b = vlionRewardVideoActivity;
        this.f2615a = vlionADClickType;
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void a() {
        try {
            LogVlion.e("VlionRewardVideoViewActivity onShowShowDownConfirm  onClickAction");
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f2616b;
            if (vlionRewardVideoActivity.A) {
                VlionRewardVideoActivity.a(vlionRewardVideoActivity, this.f2615a);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void b() {
        try {
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f2616b;
            if (vlionRewardVideoActivity.A) {
                VlionRewardVideoActivity.a(vlionRewardVideoActivity, this.f2615a);
            } else {
                vlionRewardVideoActivity.f2340r.a(vlionRewardVideoActivity.f2327e, new a());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.q0.c
    public final void c() {
        try {
            LogVlion.e("VlionRewardVideoViewActivity onShowShowDownConfirm  onAlreadyDownLoadBegin");
            if (this.f2616b.f2323a != null) {
                this.f2615a.setTarget(VlionCustomAdActiveType$VlionCustomTarget.downloading.toString());
                this.f2616b.f2323a.a(this.f2615a);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

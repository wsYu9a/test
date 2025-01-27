package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class d4 implements y4 {

    /* renamed from: a */
    public final /* synthetic */ b4 f2707a;

    public class a implements VlionDownloadHoldDialogActivity.c {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void a() {
            z3 z3Var = d4.this.f2707a.f2660q;
            q0 q0Var = z3Var.f3546g;
            if (q0Var != null) {
                q0Var.a(z3Var.f3542c);
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void b() {
        }
    }

    public d4(b4 b4Var) {
        this.f2707a = b4Var;
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a(int i10) {
        try {
            b4 b4Var = this.f2707a;
            if (b4Var.f2660q.f3542c == null) {
                return;
            }
            b4Var.a();
            VlionDownloadHoldDialogActivity.a(this.f2707a.f2660q.f3542c, i10, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void b() {
        LogVlion.e(".......... onDownloadNoMission ");
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadApkProgress(int i10) {
        VlionDownloadHoldDialogActivity vlionDownloadHoldDialogActivity;
        try {
            LogVlion.e("VlionCustomFeedAdLayout onDownloadApkProgress " + i10);
            this.f2707a.a();
            WeakReference<VlionDownloadHoldDialogActivity> weakReference = VlionDownloadHoldDialogActivity.f2444e;
            if (weakReference == null || (vlionDownloadHoldDialogActivity = weakReference.get()) == null) {
                return;
            }
            vlionDownloadHoldDialogActivity.a(i10);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadFailed() {
        b4 b4Var = this.f2707a;
        b4Var.getClass();
        try {
            if (b4Var.f2644a) {
                VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), b4Var.f2647d);
                LogVlion.e("端策略 :  ---注册摇一摇监听---= ");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadPaused() {
        this.f2707a.a();
        LogVlion.e("VlionCustomFeedAdLayout onDownloadPaused ");
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadSuccess(String str) {
        this.f2707a.a();
        LogVlion.e("VlionCustomFeedAdLayout onDownloadSuccess " + str);
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onInstallComplete() {
        b4 b4Var = this.f2707a;
        b4Var.getClass();
        try {
            if (b4Var.f2644a) {
                VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), b4Var.f2647d);
                LogVlion.e("端策略 :  ---注册摇一摇监听---= ");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        LogVlion.e("VlionCustomFeedAdLayout onInstallComplete ");
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a() {
        this.f2707a.a();
    }
}

package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class o implements y4 {

    /* renamed from: a */
    public final /* synthetic */ j f3237a;

    public class a implements VlionDownloadHoldDialogActivity.c {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void a() {
            j jVar = o.this.f3237a;
            q0 q0Var = jVar.f2972u;
            if (q0Var != null) {
                q0Var.a(jVar.getContext());
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void b() {
        }
    }

    public o(j jVar) {
        this.f3237a = jVar;
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a() {
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
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadPaused() {
        LogVlion.e("VlionCustomFeedAdLayout onDownloadPaused ");
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadSuccess(String str) {
        y.a("VlionCustomFeedAdLayout onDownloadSuccess ", str);
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onInstallComplete() {
        LogVlion.e("VlionCustomFeedAdLayout onInstallComplete ");
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a(int i10) {
        try {
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3237a.f2969r);
            VlionDownloadHoldDialogActivity.a(this.f3237a.getContext(), i10, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

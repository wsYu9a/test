package cn.vlion.ad.inland.base;

import android.content.res.Resources;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class v2 implements y4 {

    /* renamed from: a */
    public final /* synthetic */ y2 f3453a;

    public class a implements VlionDownloadHoldDialogActivity.c {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void a() {
            y2 y2Var = v2.this.f3453a;
            q0 q0Var = y2Var.B;
            if (q0Var != null) {
                q0Var.a(y2Var.getContext());
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void b() {
        }
    }

    public v2(y2 y2Var) {
        this.f3453a = y2Var;
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a(int i10) {
        try {
            this.f3453a.c();
            VlionDownloadHoldDialogActivity.a(this.f3453a.getContext(), i10, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void b() {
        try {
            LogVlion.e(".......... onDownloadNoMission ");
            String string = this.f3453a.getResources().getString(R.string.vlion_custom_ad_click_download);
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f3453a.f3516o;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(string, false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadApkProgress(int i10) {
        VlionDownloadHoldDialogActivity vlionDownloadHoldDialogActivity;
        try {
            LogVlion.e("VlionCustomFeedAdLayout onDownloadApkProgress " + i10);
            this.f3453a.c();
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f3453a.f3516o;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setProgress(i10);
            }
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
        Resources resources;
        int i10;
        try {
            LogVlion.e("VlionCustomFeedAdLayout onDownloadFailed ");
            y2 y2Var = this.f3453a;
            if (y2Var.G) {
                resources = y2Var.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake;
            } else {
                resources = y2Var.getResources();
                i10 = R.string.vlion_custom_ad_click_download;
            }
            String string = resources.getString(i10);
            y2 y2Var2 = this.f3453a;
            VlionDownloadProgressBar vlionDownloadProgressBar = y2Var2.f3516o;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(string, y2Var2.G);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadPaused() {
        try {
            LogVlion.e("VlionCustomFeedAdLayout onDownloadPaused ");
            this.f3453a.c();
            y2 y2Var = this.f3453a;
            VlionDownloadProgressBar vlionDownloadProgressBar = y2Var.f3516o;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(y2Var.getResources().getString(R.string.vlion_custom_ad_click_paused), false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadSuccess(String str) {
        try {
            LogVlion.e("VlionCustomFeedAdLayout onDownloadSuccess " + str);
            this.f3453a.c();
            y2 y2Var = this.f3453a;
            VlionDownloadProgressBar vlionDownloadProgressBar = y2Var.f3516o;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(y2Var.getResources().getString(R.string.vlion_custom_ad_click_install), false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onInstallComplete() {
        Resources resources;
        int i10;
        try {
            LogVlion.e("VlionCustomFeedAdLayout onInstallComplete ");
            y2 y2Var = this.f3453a;
            y2Var.getClass();
            try {
                if (y2Var.G) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), y2Var.f3521t);
                    LogVlion.e("端策略 :  ---注册摇一摇监听---= ");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            y2 y2Var2 = this.f3453a;
            if (y2Var2.G) {
                resources = y2Var2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake_open;
            } else {
                resources = y2Var2.getResources();
                i10 = R.string.vlion_custom_ad_click_open_now;
            }
            String string = resources.getString(i10);
            y2 y2Var3 = this.f3453a;
            VlionDownloadProgressBar vlionDownloadProgressBar = y2Var3.f3516o;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(string, y2Var3.G);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a() {
        try {
            this.f3453a.c();
            LogVlion.e("VlionCustomFeedAdLayout onDownloadPending ");
            y2 y2Var = this.f3453a;
            VlionDownloadProgressBar vlionDownloadProgressBar = y2Var.f3516o;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(y2Var.getResources().getString(R.string.vlion_custom_ad_click_pending), false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

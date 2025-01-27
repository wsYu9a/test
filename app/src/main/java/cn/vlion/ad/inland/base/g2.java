package cn.vlion.ad.inland.base;

import android.content.res.Resources;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g2 implements y4 {

    /* renamed from: a */
    public final /* synthetic */ i2 f2814a;

    public class a implements VlionDownloadHoldDialogActivity.c {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void a() {
            try {
                i2 i2Var = g2.this.f2814a;
                q0 q0Var = i2Var.C;
                if (q0Var != null) {
                    q0Var.a(i2Var.f2935u);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void b() {
        }
    }

    public g2(i2 i2Var) {
        this.f2814a = i2Var;
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a(int i10) {
        try {
            this.f2814a.c();
            VlionDownloadHoldDialogActivity.a(this.f2814a.f2935u, i10, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void b() {
        try {
            LogVlion.e(".......... onDownloadNoMission ");
            String string = this.f2814a.getResources().getString(R.string.vlion_custom_ad_click_download);
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f2814a.f2925k;
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
            LogVlion.e("VlionCustomDrawAdLayout onDownloadApkProgress " + i10);
            this.f2814a.c();
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f2814a.f2925k;
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
            LogVlion.e("VlionCustomDrawAdLayout onDownloadFailed ");
            i2 i2Var = this.f2814a;
            if (i2Var.f2940z) {
                resources = i2Var.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake;
            } else {
                resources = i2Var.getResources();
                i10 = R.string.vlion_custom_ad_click_download;
            }
            String string = resources.getString(i10);
            i2 i2Var2 = this.f2814a;
            VlionDownloadProgressBar vlionDownloadProgressBar = i2Var2.f2925k;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(string, i2Var2.f2940z);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadPaused() {
        try {
            LogVlion.e("VlionCustomDrawAdLayout onDownloadPaused ");
            this.f2814a.c();
            i2 i2Var = this.f2814a;
            VlionDownloadProgressBar vlionDownloadProgressBar = i2Var.f2925k;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(i2Var.getResources().getString(R.string.vlion_custom_ad_click_paused), false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadSuccess(String str) {
        try {
            LogVlion.e("VlionCustomDrawAdLayout onDownloadSuccess " + str);
            this.f2814a.c();
            i2 i2Var = this.f2814a;
            VlionDownloadProgressBar vlionDownloadProgressBar = i2Var.f2925k;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(i2Var.getResources().getString(R.string.vlion_custom_ad_click_install), false);
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
            LogVlion.e("VlionCustomDrawAdLayout onInstallComplete ");
            i2 i2Var = this.f2814a;
            i2Var.getClass();
            try {
                if (i2Var.f2940z) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), i2Var.f2929o);
                    LogVlion.e("端策略 :  ---注册摇一摇监听---= ");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            i2 i2Var2 = this.f2814a;
            if (i2Var2.f2940z) {
                resources = i2Var2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake_open;
            } else {
                resources = i2Var2.getResources();
                i10 = R.string.vlion_custom_ad_click_open_now;
            }
            String string = resources.getString(i10);
            i2 i2Var3 = this.f2814a;
            VlionDownloadProgressBar vlionDownloadProgressBar = i2Var3.f2925k;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(string, i2Var3.f2940z);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a() {
        try {
            this.f2814a.c();
            LogVlion.e("VlionCustomDrawAdLayout onDownloadPending ");
            i2 i2Var = this.f2814a;
            VlionDownloadProgressBar vlionDownloadProgressBar = i2Var.f2925k;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(i2Var.getResources().getString(R.string.vlion_custom_ad_click_pending), false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

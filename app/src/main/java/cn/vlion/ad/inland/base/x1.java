package cn.vlion.ad.inland.base;

import android.content.res.Resources;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class x1 implements y4 {

    /* renamed from: a */
    public final /* synthetic */ v1 f3489a;

    public x1(v1 v1Var) {
        this.f3489a = v1Var;
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a(int i10) {
        this.f3489a.d();
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void b() {
        try {
            LogVlion.e("VlionCustomBannerLayout.......... onDownloadNoMission ");
            this.f3489a.d();
            String string = this.f3489a.getResources().getString(R.string.vlion_custom_ad_click_download_paused);
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f3489a.f3440s;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(string, false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadApkProgress(int i10) {
        try {
            LogVlion.e("VlionCustomBannerLayout onDownloadApkProgress " + i10);
            this.f3489a.d();
            v1 v1Var = this.f3489a;
            VlionDownloadProgressBar vlionDownloadProgressBar = v1Var.f3440s;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(v1Var.getResources().getString(R.string.vlion_custom_ad_click_downloading), false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadFailed() {
        Resources resources;
        int i10;
        try {
            v1 v1Var = this.f3489a;
            v1Var.getClass();
            try {
                if (v1Var.f3446y) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), v1Var.A);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionCustomBannerLayout onDownloadFailed ");
            v1 v1Var2 = this.f3489a;
            if (v1Var2.f3446y) {
                resources = v1Var2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake;
            } else {
                resources = v1Var2.getResources();
                i10 = R.string.vlion_custom_ad_click_download;
            }
            String string = resources.getString(i10);
            v1 v1Var3 = this.f3489a;
            VlionDownloadProgressBar vlionDownloadProgressBar = v1Var3.f3440s;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(string, v1Var3.f3446y);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadPaused() {
        try {
            LogVlion.e("VlionCustomBannerLayout onDownloadPaused ");
            this.f3489a.d();
            v1 v1Var = this.f3489a;
            VlionDownloadProgressBar vlionDownloadProgressBar = v1Var.f3440s;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(v1Var.getResources().getString(R.string.vlion_custom_ad_click_paused), false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadSuccess(String str) {
        try {
            LogVlion.e("VlionCustomBannerLayout onDownloadSuccess " + str);
            this.f3489a.d();
            v1 v1Var = this.f3489a;
            VlionDownloadProgressBar vlionDownloadProgressBar = v1Var.f3440s;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(v1Var.getResources().getString(R.string.vlion_custom_ad_click_install), false);
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
            LogVlion.e("VlionCustomBannerLayout onInstallComplete ");
            v1 v1Var = this.f3489a;
            v1Var.getClass();
            try {
                if (v1Var.f3446y) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), v1Var.A);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            v1 v1Var2 = this.f3489a;
            if (v1Var2.f3446y) {
                resources = v1Var2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake_open;
            } else {
                resources = v1Var2.getResources();
                i10 = R.string.vlion_custom_ad_click_open_now;
            }
            String string = resources.getString(i10);
            v1 v1Var3 = this.f3489a;
            VlionDownloadProgressBar vlionDownloadProgressBar = v1Var3.f3440s;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(string, v1Var3.f3446y);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a() {
        try {
            this.f3489a.d();
            LogVlion.e("VlionCustomBannerLayout onDownloadPending ");
            v1 v1Var = this.f3489a;
            VlionDownloadProgressBar vlionDownloadProgressBar = v1Var.f3440s;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(v1Var.getResources().getString(R.string.vlion_custom_ad_click_pending), false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

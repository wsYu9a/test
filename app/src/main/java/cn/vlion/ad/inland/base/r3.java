package cn.vlion.ad.inland.base;

import android.content.res.Resources;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class r3 implements y4 {

    /* renamed from: a */
    public final /* synthetic */ VlionCustomInterstitialActivity f3345a;

    public class a implements VlionDownloadHoldDialogActivity.c {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void a() {
            LogVlion.e("VlionCustomInterstitialActivity onSuspendClick ");
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = r3.this.f3345a;
            q0 q0Var = vlionCustomInterstitialActivity.f2254r;
            if (q0Var != null) {
                q0Var.a(vlionCustomInterstitialActivity.getApplicationContext());
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void b() {
        }
    }

    public r3(VlionCustomInterstitialActivity vlionCustomInterstitialActivity) {
        this.f3345a = vlionCustomInterstitialActivity;
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a(int i10) {
        try {
            LogVlion.e("VlionCustomInterstitialActivity onDownloadLoading ");
            VlionDownloadHoldDialogActivity.a(this.f3345a, i10, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void b() {
        Resources resources;
        int i10;
        try {
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3345a;
            j1 j1Var = VlionCustomInterstitialActivity.F;
            vlionCustomInterstitialActivity.getClass();
            try {
                vlionCustomInterstitialActivity.f2255s = false;
                if (vlionCustomInterstitialActivity.f2257u) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(vlionCustomInterstitialActivity.getApplicationContext(), vlionCustomInterstitialActivity.f2243g);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionCustomInterstitialActivity onDownloadNoMission ");
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity2 = this.f3345a;
            if (vlionCustomInterstitialActivity2.f2247k) {
                resources = vlionCustomInterstitialActivity2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake;
            } else {
                resources = vlionCustomInterstitialActivity2.getResources();
                i10 = R.string.vlion_custom_ad_click_download;
            }
            String string = resources.getString(i10);
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity3 = this.f3345a;
            x3 x3Var = vlionCustomInterstitialActivity3.f2244h;
            if (x3Var != null) {
                x3Var.a(string, vlionCustomInterstitialActivity3.f2247k);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadApkProgress(int i10) {
        VlionDownloadHoldDialogActivity vlionDownloadHoldDialogActivity;
        try {
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3345a;
            j1 j1Var = VlionCustomInterstitialActivity.F;
            vlionCustomInterstitialActivity.getClass();
            try {
                vlionCustomInterstitialActivity.f2255s = true;
                if (vlionCustomInterstitialActivity.f2257u) {
                    VlionSensorManagerHelper.getInstance().unregisterShakeListener(vlionCustomInterstitialActivity.f2243g);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionCustomInterstitialActivity onDownloadApkProgress " + i10);
            x3 x3Var = this.f3345a.f2244h;
            if (x3Var != null) {
                x3Var.setProgress(i10);
            }
            WeakReference<VlionDownloadHoldDialogActivity> weakReference = VlionDownloadHoldDialogActivity.f2444e;
            if (weakReference == null || (vlionDownloadHoldDialogActivity = weakReference.get()) == null) {
                return;
            }
            vlionDownloadHoldDialogActivity.a(i10);
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadFailed() {
        Resources resources;
        int i10;
        try {
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3345a;
            j1 j1Var = VlionCustomInterstitialActivity.F;
            vlionCustomInterstitialActivity.getClass();
            try {
                vlionCustomInterstitialActivity.f2255s = false;
                if (vlionCustomInterstitialActivity.f2257u) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(vlionCustomInterstitialActivity.getApplicationContext(), vlionCustomInterstitialActivity.f2243g);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionCustomInterstitialActivity onDownloadFailed ");
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity2 = this.f3345a;
            if (vlionCustomInterstitialActivity2.f2247k) {
                resources = vlionCustomInterstitialActivity2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake;
            } else {
                resources = vlionCustomInterstitialActivity2.getResources();
                i10 = R.string.vlion_custom_ad_click_download;
            }
            String string = resources.getString(i10);
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity3 = this.f3345a;
            x3 x3Var = vlionCustomInterstitialActivity3.f2244h;
            if (x3Var != null) {
                x3Var.a(string, vlionCustomInterstitialActivity3.f2247k);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadPaused() {
        try {
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3345a;
            j1 j1Var = VlionCustomInterstitialActivity.F;
            vlionCustomInterstitialActivity.getClass();
            try {
                vlionCustomInterstitialActivity.f2255s = true;
                if (vlionCustomInterstitialActivity.f2257u) {
                    VlionSensorManagerHelper.getInstance().unregisterShakeListener(vlionCustomInterstitialActivity.f2243g);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionCustomInterstitialActivity onDownloadPaused ");
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity2 = this.f3345a;
            x3 x3Var = vlionCustomInterstitialActivity2.f2244h;
            if (x3Var != null) {
                x3Var.a(vlionCustomInterstitialActivity2.getResources().getString(R.string.vlion_custom_ad_click_paused), false);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadSuccess(String str) {
        try {
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3345a;
            j1 j1Var = VlionCustomInterstitialActivity.F;
            vlionCustomInterstitialActivity.getClass();
            try {
                vlionCustomInterstitialActivity.f2255s = true;
                if (vlionCustomInterstitialActivity.f2257u) {
                    VlionSensorManagerHelper.getInstance().unregisterShakeListener(vlionCustomInterstitialActivity.f2243g);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionCustomInterstitialActivity onDownloadSuccess " + str);
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity2 = this.f3345a;
            x3 x3Var = vlionCustomInterstitialActivity2.f2244h;
            if (x3Var != null) {
                x3Var.a(vlionCustomInterstitialActivity2.getResources().getString(R.string.vlion_custom_ad_click_install), false);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onInstallComplete() {
        Resources resources;
        int i10;
        try {
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3345a;
            j1 j1Var = VlionCustomInterstitialActivity.F;
            vlionCustomInterstitialActivity.getClass();
            try {
                vlionCustomInterstitialActivity.f2255s = false;
                if (vlionCustomInterstitialActivity.f2257u) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(vlionCustomInterstitialActivity.getApplicationContext(), vlionCustomInterstitialActivity.f2243g);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionCustomInterstitialActivity onInstallComplete ");
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity2 = this.f3345a;
            if (vlionCustomInterstitialActivity2.f2247k) {
                resources = vlionCustomInterstitialActivity2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake_open;
            } else {
                resources = vlionCustomInterstitialActivity2.getResources();
                i10 = R.string.vlion_custom_ad_click_open_now;
            }
            String string = resources.getString(i10);
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity3 = this.f3345a;
            x3 x3Var = vlionCustomInterstitialActivity3.f2244h;
            if (x3Var != null) {
                x3Var.a(string, vlionCustomInterstitialActivity3.f2247k);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a() {
        try {
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity = this.f3345a;
            j1 j1Var = VlionCustomInterstitialActivity.F;
            vlionCustomInterstitialActivity.getClass();
            try {
                vlionCustomInterstitialActivity.f2255s = true;
                if (vlionCustomInterstitialActivity.f2257u) {
                    VlionSensorManagerHelper.getInstance().unregisterShakeListener(vlionCustomInterstitialActivity.f2243g);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionCustomInterstitialActivity onDownloadPending ");
            VlionCustomInterstitialActivity vlionCustomInterstitialActivity2 = this.f3345a;
            x3 x3Var = vlionCustomInterstitialActivity2.f2244h;
            if (x3Var != null) {
                x3Var.a(vlionCustomInterstitialActivity2.getResources().getString(R.string.vlion_custom_ad_click_pending), false);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}

package cn.vlion.ad.inland.base;

import android.content.res.Resources;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class u5 implements y4 {

    /* renamed from: a */
    public final /* synthetic */ VlionRewardVideoActivity f3398a;

    public class a implements VlionDownloadHoldDialogActivity.c {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void a() {
            VlionRewardVideoActivity vlionRewardVideoActivity = u5.this.f3398a;
            q0 q0Var = vlionRewardVideoActivity.f2341s;
            if (q0Var != null) {
                q0Var.a(vlionRewardVideoActivity.getApplicationContext());
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity.c
        public final void b() {
        }
    }

    public u5(VlionRewardVideoActivity vlionRewardVideoActivity) {
        this.f3398a = vlionRewardVideoActivity;
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a(int i10) {
        try {
            LogVlion.e("VlionRewardVideoViewActivity onDownloadLoading ");
            VlionDownloadHoldDialogActivity.a(this.f3398a, i10, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void b() {
        Resources resources;
        int i10;
        try {
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f3398a;
            int i11 = VlionRewardVideoActivity.I;
            vlionRewardVideoActivity.getClass();
            try {
                vlionRewardVideoActivity.f2342t = false;
                if (vlionRewardVideoActivity.f2348z) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(vlionRewardVideoActivity.getApplicationContext(), vlionRewardVideoActivity.B);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionRewardVideoViewActivity onDownloadNoMission ");
            VlionRewardVideoActivity vlionRewardVideoActivity2 = this.f3398a;
            if (vlionRewardVideoActivity2.f2346x) {
                resources = vlionRewardVideoActivity2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake;
            } else {
                resources = vlionRewardVideoActivity2.getResources();
                i10 = R.string.vlion_custom_ad_click_download;
            }
            String string = resources.getString(i10);
            VlionRewardVideoActivity vlionRewardVideoActivity3 = this.f3398a;
            h4 h4Var = vlionRewardVideoActivity3.f2339q;
            if (h4Var != null) {
                h4Var.a(string, vlionRewardVideoActivity3.f2346x);
            }
            VlionRewardVideoActivity vlionRewardVideoActivity4 = this.f3398a;
            VlionVideoEndCardView vlionVideoEndCardView = vlionRewardVideoActivity4.f2335m;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.a(string, vlionRewardVideoActivity4.f2346x);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadApkProgress(int i10) {
        VlionDownloadHoldDialogActivity vlionDownloadHoldDialogActivity;
        try {
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f3398a;
            int i11 = VlionRewardVideoActivity.I;
            vlionRewardVideoActivity.getClass();
            try {
                vlionRewardVideoActivity.f2342t = true;
                if (vlionRewardVideoActivity.f2348z) {
                    VlionSensorManagerHelper.getInstance().unregisterShakeListener(vlionRewardVideoActivity.B);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionRewardVideoViewActivity onDownloadApkProgress " + i10);
            h4 h4Var = this.f3398a.f2339q;
            if (h4Var != null) {
                h4Var.setProgress(i10);
            }
            VlionVideoEndCardView vlionVideoEndCardView = this.f3398a.f2335m;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.setProgress(i10);
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
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f3398a;
            int i11 = VlionRewardVideoActivity.I;
            vlionRewardVideoActivity.getClass();
            try {
                vlionRewardVideoActivity.f2342t = false;
                if (vlionRewardVideoActivity.f2348z) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(vlionRewardVideoActivity.getApplicationContext(), vlionRewardVideoActivity.B);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionRewardVideoViewActivity onDownloadFailed ");
            VlionRewardVideoActivity vlionRewardVideoActivity2 = this.f3398a;
            if (vlionRewardVideoActivity2.f2346x) {
                resources = vlionRewardVideoActivity2.getResources();
                i10 = R.string.vlion_custom_ad_download_now_shake;
            } else {
                resources = vlionRewardVideoActivity2.getResources();
                i10 = R.string.vlion_custom_ad_click_download;
            }
            String string = resources.getString(i10);
            VlionRewardVideoActivity vlionRewardVideoActivity3 = this.f3398a;
            h4 h4Var = vlionRewardVideoActivity3.f2339q;
            if (h4Var != null) {
                h4Var.a(string, vlionRewardVideoActivity3.f2346x);
            }
            VlionRewardVideoActivity vlionRewardVideoActivity4 = this.f3398a;
            VlionVideoEndCardView vlionVideoEndCardView = vlionRewardVideoActivity4.f2335m;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.a(string, vlionRewardVideoActivity4.f2346x);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadPaused() {
        try {
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f3398a;
            int i10 = VlionRewardVideoActivity.I;
            vlionRewardVideoActivity.getClass();
            try {
                vlionRewardVideoActivity.f2342t = true;
                if (vlionRewardVideoActivity.f2348z) {
                    VlionSensorManagerHelper.getInstance().unregisterShakeListener(vlionRewardVideoActivity.B);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionRewardVideoViewActivity onDownloadPaused ");
            String string = this.f3398a.getResources().getString(R.string.vlion_custom_ad_click_paused);
            h4 h4Var = this.f3398a.f2339q;
            if (h4Var != null) {
                h4Var.a(string, false);
            }
            VlionVideoEndCardView vlionVideoEndCardView = this.f3398a.f2335m;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.a(string, false);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadSuccess(String str) {
        try {
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f3398a;
            int i10 = VlionRewardVideoActivity.I;
            vlionRewardVideoActivity.getClass();
            try {
                vlionRewardVideoActivity.f2342t = true;
                if (vlionRewardVideoActivity.f2348z) {
                    VlionSensorManagerHelper.getInstance().unregisterShakeListener(vlionRewardVideoActivity.B);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionRewardVideoViewActivity onDownloadSuccess " + str);
            String string = this.f3398a.getResources().getString(R.string.vlion_custom_ad_click_install);
            h4 h4Var = this.f3398a.f2339q;
            if (h4Var != null) {
                h4Var.a(string, false);
            }
            VlionVideoEndCardView vlionVideoEndCardView = this.f3398a.f2335m;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.a(string, false);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onInstallComplete() {
        String string;
        VlionVideoEndCardView vlionVideoEndCardView;
        Resources resources;
        int i10;
        try {
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f3398a;
            int i11 = VlionRewardVideoActivity.I;
            vlionRewardVideoActivity.getClass();
            try {
                vlionRewardVideoActivity.f2342t = false;
                if (vlionRewardVideoActivity.f2348z) {
                    VlionSensorManagerHelper.getInstance().registerShakeListener(vlionRewardVideoActivity.getApplicationContext(), vlionRewardVideoActivity.B);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionRewardVideoViewActivity onInstallComplete ");
            if (q.a(this.f3398a.getApplicationContext(), this.f3398a.f2327e.getDp())) {
                VlionRewardVideoActivity vlionRewardVideoActivity2 = this.f3398a;
                if (vlionRewardVideoActivity2.f2346x) {
                    resources = vlionRewardVideoActivity2.getResources();
                    i10 = R.string.vlion_custom_ad_download_now_shake_open;
                } else {
                    resources = vlionRewardVideoActivity2.getResources();
                    i10 = R.string.vlion_custom_ad_click_open_now;
                }
                string = resources.getString(i10);
                h4 h4Var = this.f3398a.f2339q;
                if (h4Var != null) {
                    h4Var.a(string, false);
                }
                vlionVideoEndCardView = this.f3398a.f2335m;
                if (vlionVideoEndCardView == null) {
                    return;
                }
            } else {
                string = this.f3398a.getResources().getString(R.string.vlion_custom_ad_click_install);
                h4 h4Var2 = this.f3398a.f2339q;
                if (h4Var2 != null) {
                    h4Var2.a(string, false);
                }
                vlionVideoEndCardView = this.f3398a.f2335m;
                if (vlionVideoEndCardView == null) {
                    return;
                }
            }
            vlionVideoEndCardView.a(string, false);
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a() {
        try {
            VlionRewardVideoActivity vlionRewardVideoActivity = this.f3398a;
            int i10 = VlionRewardVideoActivity.I;
            vlionRewardVideoActivity.getClass();
            try {
                vlionRewardVideoActivity.f2342t = true;
                if (vlionRewardVideoActivity.f2348z) {
                    VlionSensorManagerHelper.getInstance().unregisterShakeListener(vlionRewardVideoActivity.B);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionRewardVideoViewActivity onDownloadPending ");
            String string = this.f3398a.getResources().getString(R.string.vlion_custom_ad_click_pending);
            h4 h4Var = this.f3398a.f2339q;
            if (h4Var != null) {
                h4Var.a(string, false);
            }
            VlionVideoEndCardView vlionVideoEndCardView = this.f3398a.f2335m;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.a(string, false);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}

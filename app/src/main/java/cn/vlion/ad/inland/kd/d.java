package cn.vlion.ad.inland.kd;

import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class d implements SensorManagerManager.OnShakeListener {

    /* renamed from: a */
    public final /* synthetic */ VlionDownloadProgressBar f3903a;

    /* renamed from: b */
    public final /* synthetic */ View f3904b;

    /* renamed from: c */
    public final /* synthetic */ c f3905c;

    public d(ViewGroup viewGroup, VlionDownloadProgressBar vlionDownloadProgressBar, c cVar) {
        this.f3905c = cVar;
        this.f3903a = vlionDownloadProgressBar;
        this.f3904b = viewGroup;
    }

    @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
    public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
        try {
            LogVlion.e("VlionKdBannerVideo onShake =");
            if (this.f3905c.f3892e) {
                return;
            }
            this.f3905c.f3892e = true;
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3905c.f3893f);
            this.f3905c.f3893f = null;
            this.f3905c.f3891d = false;
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f3903a;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(this.f3905c.context.getResources().getString(cn.vlion.ad.inland.base.R.string.vlion_custom_ad_click_look), this.f3905c.f3891d);
            }
            if (this.f3905c.f3889b != null) {
                LogVlion.e("VlionKdBannerVideo onShake isClick=" + this.f3905c.f3889b.onClick(this.f3904b, 2));
            }
            VlionBiddingActionListener vlionBiddingActionListener = this.f3905c.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

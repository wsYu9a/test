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
public final class b implements SensorManagerManager.OnShakeListener {

    /* renamed from: a */
    public final /* synthetic */ VlionDownloadProgressBar f3885a;

    /* renamed from: b */
    public final /* synthetic */ View f3886b;

    /* renamed from: c */
    public final /* synthetic */ a f3887c;

    public b(a aVar, VlionDownloadProgressBar vlionDownloadProgressBar, ViewGroup viewGroup) {
        this.f3887c = aVar;
        this.f3885a = vlionDownloadProgressBar;
        this.f3886b = viewGroup;
    }

    @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
    public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
        try {
            LogVlion.e("VlionKdBanner onShake =");
            if (this.f3887c.f3876g) {
                return;
            }
            this.f3887c.f3876g = true;
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3887c.f3875f);
            this.f3887c.f3875f = null;
            this.f3887c.f3874e = false;
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f3885a;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(this.f3887c.context.getResources().getString(cn.vlion.ad.inland.base.R.string.vlion_custom_ad_click_look), this.f3887c.f3874e);
            }
            if (this.f3887c.f3871b != null) {
                LogVlion.e("VlionKdBanner onShake isClick=" + this.f3887c.f3871b.onClick(this.f3886b, 2));
            }
            VlionBiddingActionListener vlionBiddingActionListener = this.f3887c.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}

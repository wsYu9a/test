package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes.dex */
public final class d5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Context f2709a;

    public d5(Context context) {
        this.f2709a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f2709a);
            if (advertisingIdInfo != null) {
                boolean isLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                LogVlion.e("获取Gaid isLimitAdTrackingEnabled=:" + isLimitAdTrackingEnabled);
                if (isLimitAdTrackingEnabled) {
                    return;
                }
                String id2 = advertisingIdInfo.getId();
                LogVlion.e("获取Gaid:" + id2);
                VlionDeviceInfo.getInstance().SetGaid(id2);
            }
        } catch (RuntimeException e10) {
            StringBuilder a10 = l1.a("Gaid RuntimeException--------");
            a10.append(e10.getMessage());
            LogVlion.e(a10.toString());
        } catch (GooglePlayServicesNotAvailableException e11) {
            StringBuilder a11 = l1.a("Gaid GooglePlayServicesNotAvailableException--------");
            a11.append(e11.getMessage());
            LogVlion.e(a11.toString());
            e11.printStackTrace();
        } catch (GooglePlayServicesRepairableException e12) {
            StringBuilder a12 = l1.a("Gaid GooglePlayServicesRepairableException--------");
            a12.append(e12.getMessage());
            LogVlion.e(a12.toString());
            e12.printStackTrace();
        } catch (IOException e13) {
            StringBuilder a13 = l1.a("Gaid IOException--------");
            a13.append(e13.getMessage());
            LogVlion.e(a13.toString());
            e13.printStackTrace();
        } catch (Exception e14) {
            StringBuilder a14 = l1.a("Gaid Exception--------");
            a14.append(e14.getMessage());
            LogVlion.e(a14.toString());
        } catch (Throwable th2) {
            StringBuilder a15 = l1.a("Gaid Throwable--------");
            a15.append(th2.getMessage());
            LogVlion.e(a15.toString());
        }
    }
}

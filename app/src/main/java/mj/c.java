package mj;

import android.content.Context;
import bh.b;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.sigmob.sdk.base.common.y;
import com.umeng.analytics.pro.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    public static String f28711a;

    public static void a(Context context) {
        AMapLocationClient aMapLocationClient;
        if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11107h) == 0 || context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11106g) == 0) {
            try {
                aMapLocationClient = new AMapLocationClient(context.getApplicationContext());
            } catch (Exception unused) {
                aMapLocationClient = null;
            }
            if (aMapLocationClient == null) {
                return;
            }
            AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
            aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            aMapLocationClientOption.setGpsFirst(false);
            aMapLocationClientOption.setHttpTimeOut(30000L);
            aMapLocationClientOption.setInterval(y.f.f18076n);
            aMapLocationClientOption.setNeedAddress(true);
            aMapLocationClientOption.setOnceLocation(true);
            aMapLocationClientOption.setOnceLocationLatest(false);
            AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);
            aMapLocationClientOption.setSensorEnable(false);
            aMapLocationClientOption.setWifiScan(true);
            aMapLocationClientOption.setLocationCacheEnable(true);
            aMapLocationClientOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.DEFAULT);
            aMapLocationClient.setLocationOption(aMapLocationClientOption);
            aMapLocationClient.setLocationListener(new AMapLocationListener() { // from class: mj.b

                /* renamed from: a */
                public final /* synthetic */ AMapLocationClient f28710a;

                public /* synthetic */ b(AMapLocationClient aMapLocationClient2) {
                    aMapLocationClient = aMapLocationClient2;
                }

                public final void a(AMapLocation aMapLocation) {
                    c.b(aMapLocationClient, aMapLocation);
                }
            });
            aMapLocationClient2.startLocation();
        }
    }

    public static /* synthetic */ void b(AMapLocationClient aMapLocationClient, AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("longitude", aMapLocation.getLongitude());
                jSONObject.put("latitude", aMapLocation.getLatitude());
                jSONObject.put(bt.O, aMapLocation.getCountry());
                jSONObject.put("province", aMapLocation.getProvince());
                jSONObject.put("city", aMapLocation.getCity());
                jSONObject.put("district", aMapLocation.getDistrict());
                f28711a = jSONObject.toString();
                b.a.f1608a.f(c.class.getSimpleName(), "last_location: " + f28711a);
                j.d("last_known_location", f28711a);
            } catch (JSONException e10) {
                if (yk.b.a()) {
                    e10.printStackTrace();
                }
            }
        }
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            aMapLocationClient.onDestroy();
        }
    }
}

package cn.vlion.ad.inland.jd;

import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;

/* loaded from: classes.dex */
public final class f extends JADPrivateController {
    @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
    public final String getIP() {
        return "";
    }

    @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
    public final String getImei() {
        return VlionPrivateInfo.getImei();
    }

    @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
    public final JADLocation getLocation() {
        return new JADLocation(VlionPrivateInfo.getLocationLat(), VlionPrivateInfo.getLocationLon(), l5.c.f27899e);
    }

    @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
    public final String getOaid() {
        return VlionPrivateInfo.getOaid();
    }

    @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
    public final boolean isCanUseIP() {
        return false;
    }

    @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
    public final boolean isCanUseLocation() {
        return VlionPrivateInfo.isCanUseLocation();
    }

    @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
    public final boolean isCanUsePhoneState() {
        return VlionPrivateInfo.isCanUsePhoneState();
    }
}

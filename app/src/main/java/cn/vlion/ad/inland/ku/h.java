package cn.vlion.ad.inland.ku;

import android.content.Context;
import android.location.Location;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import com.kwad.sdk.api.KsCustomController;
import java.util.List;

/* loaded from: classes.dex */
public final class h extends KsCustomController {

    /* renamed from: a */
    public final /* synthetic */ Context f4008a;

    public h(Context context) {
        this.f4008a = context;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final boolean canReadInstalledPackages() {
        return VlionPrivateInfo.isCanReadAppList();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final boolean canReadLocation() {
        return VlionPrivateInfo.isCanUseLocation();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final boolean canUseMacAddress() {
        return VlionPrivateInfo.isCanUseMacAddress();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final boolean canUseOaid() {
        return true;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final boolean canUsePhoneState() {
        return VlionPrivateInfo.isCanUsePhoneState();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final boolean canUseStoragePermission() {
        return true;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final String getAndroidId() {
        return VlionDeviceInfo.getInstance().getAndroidId(this.f4008a);
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final String getImei() {
        return VlionPrivateInfo.getImei();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final String[] getImeis() {
        return null;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final List<String> getInstalledPackages() {
        return null;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final Location getLocation() {
        Location location = new Location("");
        location.setLatitude(VlionPrivateInfo.getLocationLat());
        location.setLongitude(VlionPrivateInfo.getLocationLon());
        return location;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final String getMacAddress() {
        return "";
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public final String getOaid() {
        return VlionPrivateInfo.getOaid();
    }
}

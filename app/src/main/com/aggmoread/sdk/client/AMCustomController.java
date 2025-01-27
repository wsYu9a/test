package com.aggmoread.sdk.client;

import android.content.pm.PackageInfo;
import android.location.Location;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AMCustomController {
    public boolean canReadInstalledPackages() {
        return true;
    }

    public boolean canReadLocation() {
        return true;
    }

    public boolean canUseAndroidId() {
        return true;
    }

    public boolean canUseMacAddress() {
        return true;
    }

    public boolean canUseNetworkState() {
        return true;
    }

    public boolean canUsePhoneState() {
        return true;
    }

    public boolean canUseStoragePermission() {
        return true;
    }

    public String getAndroidId() {
        return "";
    }

    public String getDevOaid() {
        return "";
    }

    public String getIMSI() {
        return "";
    }

    public String getImei() {
        return "";
    }

    public List<PackageInfo> getInstalledPackages() {
        return null;
    }

    public Location getLocation() {
        return null;
    }

    public String getMacAddress() {
        return "";
    }

    public String getSerialNumberInner() {
        return "";
    }
}

package cn.vlion.ad.inland.base.util.init;

import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;

/* loaded from: classes.dex */
public class VlionPrivateInfo {
    public static String getImei() {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        return privateController != null ? privateController.getImei() : "";
    }

    public static double getLocationLat() {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (privateController == null || privateController.getLocation() == null) {
            return -1.0d;
        }
        return privateController.getLocation().getLatitude();
    }

    public static double getLocationLon() {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (privateController == null || privateController.getLocation() == null) {
            return -1.0d;
        }
        return privateController.getLocation().getLongitude();
    }

    public static String getOaid() {
        return VlionDeviceInfo.getInstance().getOaid();
    }

    public static boolean isCanReadAppList() {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (privateController != null) {
            return privateController.isCanReadAppList();
        }
        return true;
    }

    public static boolean isCanUseLocation() {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (privateController != null) {
            return privateController.isCanUseLocation();
        }
        return true;
    }

    public static boolean isCanUseMacAddress() {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (privateController != null) {
            return privateController.isCanUseMacAddress();
        }
        return true;
    }

    public static boolean isCanUsePhoneState() {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (privateController != null) {
            return privateController.isCanUsePhoneState();
        }
        return true;
    }
}

package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class az {
    private static boolean Oa() {
        if (!com.kwad.framework.a.a.ns.booleanValue()) {
            return false;
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    public static boolean Ob() {
        KsCustomController ksCustomController;
        if (Oa()) {
            return true;
        }
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Location Oc() {
        KsCustomController ksCustomController;
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB == null || (ksCustomController = MB.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String Od() {
        KsCustomController ksCustomController;
        try {
            SdkConfig MB = ServiceProvider.MB();
            return (MB == null || (ksCustomController = MB.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] Oe() {
        KsCustomController ksCustomController;
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String Of() {
        KsCustomController ksCustomController;
        try {
            SdkConfig MB = ServiceProvider.MB();
            return (MB == null || (ksCustomController = MB.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Og() {
        KsCustomController ksCustomController;
        if (Oa()) {
            return true;
        }
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String Oh() {
        KsCustomController ksCustomController;
        try {
            SdkConfig MB = ServiceProvider.MB();
            return (MB == null || (ksCustomController = MB.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Oi() {
        KsCustomController ksCustomController;
        if (Oa()) {
            return true;
        }
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String Oj() {
        KsCustomController ksCustomController;
        try {
            SdkConfig MB = ServiceProvider.MB();
            return (MB == null || (ksCustomController = MB.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Ok() {
        KsCustomController ksCustomController;
        if (Oa()) {
            return true;
        }
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Ol() {
        KsCustomController ksCustomController;
        if (Oa()) {
            return true;
        }
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Om() {
        KsCustomController ksCustomController;
        if (Oa()) {
            return true;
        }
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<String> On() {
        KsCustomController ksCustomController;
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static boolean Oo() {
        KsCustomController ksCustomController;
        if (Op()) {
            return true;
        }
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                if (!ksCustomController.canUseSensorManager()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean Op() {
        if (!com.kwad.sdk.core.d.a.ns.booleanValue()) {
            return false;
        }
        try {
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        if (Oa()) {
            return true;
        }
        try {
            SdkConfig MB = ServiceProvider.MB();
            if (MB != null && (ksCustomController = MB.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}

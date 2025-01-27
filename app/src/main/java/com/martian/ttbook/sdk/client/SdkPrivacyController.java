package com.martian.ttbook.sdk.client;

import android.content.pm.PackageInfo;
import android.location.Location;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class SdkPrivacyController {
    public static SdkPrivacyController DEFAULT = new SdkPrivacyController() { // from class: com.martian.ttbook.sdk.client.SdkPrivacyController.1
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.SdkPrivacyController
        public String getAndroidId() {
            return null;
        }

        @Override // com.martian.ttbook.sdk.client.SdkPrivacyController
        public String getImei() {
            return null;
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.SdkPrivacyController$1 */
    static class AnonymousClass1 extends SdkPrivacyController {
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.SdkPrivacyController
        public String getAndroidId() {
            return null;
        }

        @Override // com.martian.ttbook.sdk.client.SdkPrivacyController
        public String getImei() {
            return null;
        }
    }

    public boolean canReadInstalledPackages() {
        return true;
    }

    public boolean canReadLocation() {
        return true;
    }

    public boolean canUseMacAddress() {
        return true;
    }

    public boolean canUseNetworkState() {
        return true;
    }

    public boolean canUseOaid() {
        return true;
    }

    public boolean canUsePhoneState() {
        return true;
    }

    public boolean canUseStoragePermission() {
        return true;
    }

    public abstract String getAndroidId();

    public abstract String getImei();

    public String[] getImeis() {
        return null;
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

    public String getOaid() {
        return "";
    }
}

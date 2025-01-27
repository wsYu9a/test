package com.vivo.advv.vaf.virtualview.Helper;

/* loaded from: classes4.dex */
public class VVFeatureConfig {
    private static boolean sliderCompat = false;

    public static boolean isRtlAvailable() {
        return RtlHelper.isEnable();
    }

    public static boolean isSliderCompat() {
        return sliderCompat;
    }

    public static void setEnableBorderRadius(boolean z) {
        VirtualViewUtils.setEnableBorderRadius(z);
    }

    public static void setRtlAvailable(boolean z) {
        RtlHelper.setEnable(z);
    }

    public static void setSliderCompat(boolean z) {
        sliderCompat = z;
    }
}

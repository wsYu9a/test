package com.vivo.mobilead.util;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;

/* loaded from: classes4.dex */
public class b0 {
    public static int a(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return -1;
        }
        com.vivo.ad.model.a0 Q = bVar.Q();
        if (Q != null && !TextUtils.isEmpty(Q.g())) {
            return Q.h() >= Q.c() ? 4 : 5;
        }
        if (bVar.f() != null && bVar.f().b() != null && bVar.f().b().size() > 0) {
            if (bVar.f().b().size() > 2) {
                return 1;
            }
            if (!TextUtils.isEmpty(bVar.f().a()) && bVar.f().a().contains("*")) {
                String[] split = bVar.f().a().split("\\*");
                if (d0.a(split[0]) > 240) {
                    return d0.a(split[0]) >= d0.a(split[1]) ? 2 : 6;
                }
                return 3;
            }
        }
        return -1;
    }

    public static int a(TTNativeAd tTNativeAd) {
        if (tTNativeAd == null) {
            return -1;
        }
        int imageMode = tTNativeAd.getImageMode();
        if (imageMode == 2) {
            return 3;
        }
        if (imageMode == 3) {
            return 2;
        }
        if (imageMode == 4) {
            return 1;
        }
        if (imageMode != 15) {
            return imageMode != 16 ? -1 : 6;
        }
        return 5;
    }

    public static int a(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData == null) {
            return -1;
        }
        int adPatternType = nativeUnifiedADData.getAdPatternType();
        if (adPatternType == 1) {
            return nativeUnifiedADData.getPictureWidth() >= nativeUnifiedADData.getPictureHeight() ? 2 : 6;
        }
        if (adPatternType == 2) {
            return nativeUnifiedADData.getPictureWidth() >= nativeUnifiedADData.getPictureHeight() ? 4 : 5;
        }
        if (adPatternType != 3) {
            return adPatternType != 4 ? -1 : 3;
        }
        return 1;
    }

    public static int a(KsNativeAd ksNativeAd) {
        if (ksNativeAd == null) {
            return -1;
        }
        int materialType = ksNativeAd.getMaterialType();
        if (materialType == 1) {
            return ksNativeAd.getVideoWidth() < ksNativeAd.getVideoHeight() ? 6 : 2;
        }
        if (materialType != 2) {
            return materialType != 3 ? -1 : 1;
        }
        KsImage ksImage = ksNativeAd.getImageList().get(0);
        return ksImage.getWidth() < ksImage.getHeight() ? 6 : 2;
    }
}

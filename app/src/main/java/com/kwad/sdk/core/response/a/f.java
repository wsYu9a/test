package com.kwad.sdk.core.response.a;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.PhotoInfo;

/* loaded from: classes2.dex */
public final class f {
    public static String a(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    public static boolean a(@Nullable Matrix matrix, int i2, int i3, PhotoInfo.VideoInfo videoInfo) {
        if (matrix != null) {
            matrix.reset();
        }
        if (videoInfo == null) {
            return false;
        }
        float f2 = videoInfo.width;
        float f3 = videoInfo.height;
        if (f2 >= f3) {
            return false;
        }
        float f4 = (float) videoInfo.leftRatio;
        float f5 = (float) videoInfo.topRatio;
        float f6 = (float) videoInfo.widthRatio;
        float f7 = (float) videoInfo.heightRatio;
        float f8 = i2;
        float f9 = f8 / f2;
        float f10 = i3;
        float f11 = f10 / f3;
        float f12 = f9 / f11;
        if (Math.abs(f12 - 1.0f) < 0.01d) {
            return false;
        }
        if (f9 > f11) {
            float f13 = f11 / f9;
            float f14 = (1.0f - f13) / 2.0f;
            float f15 = (f13 + 1.0f) / 2.0f;
            if (f5 < f14 || f5 + f7 > f15) {
                return false;
            }
        } else {
            float f16 = (1.0f - f12) / 2.0f;
            float f17 = (f12 + 1.0f) / 2.0f;
            if (f4 < f16 || f4 + f6 > f17) {
                return false;
            }
            f9 = f11;
        }
        if (matrix == null) {
            return true;
        }
        matrix.preTranslate((f8 - f2) / 2.0f, (f10 - f3) / 2.0f);
        matrix.preScale(f2 / f8, f3 / f10);
        matrix.postScale(f9, f9, f8 / 2.0f, f10 / 2.0f);
        return true;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.manifest;
    }

    public static String c(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.sdkExtraData;
    }
}

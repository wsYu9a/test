package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class d {
    public static boolean bW(@NonNull Context context) {
        boolean isExternalStorageLegacy;
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                isExternalStorageLegacy = Environment.isExternalStorageLegacy();
                if (!isExternalStorageLegacy) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}

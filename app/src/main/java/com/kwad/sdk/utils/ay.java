package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class ay {
    private static String TAG = "plugin.signature";

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] cM(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            com.kwad.sdk.core.d.b.w(TAG, "Can not get signature, error = " + e2.getLocalizedMessage());
            com.kwad.sdk.core.d.b.w(TAG, e2);
            return null;
        }
    }

    public static String cN(Context context) {
        try {
            Signature[] cM = cM(context);
            if (cM != null && cM.length > 0) {
                return ad.l(cM[0].toByteArray());
            }
            return "";
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w(TAG, e2);
            return "";
        }
    }
}

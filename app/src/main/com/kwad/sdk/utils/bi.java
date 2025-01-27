package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class bi {
    private static String TAG = "plugin.signature";
    public static Signature[] aUK = new Signature[0];

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] dm(Context context) {
        Signature[] signatureArr = aUK;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        PackageInfo packageInfo = ao.getPackageInfo(context, context.getPackageName(), 64);
        if (packageInfo != null) {
            aUK = packageInfo.signatures;
        }
        return aUK;
    }

    public static String dn(Context context) {
        try {
            Signature[] dm = dm(context);
            if (dm != null && dm.length > 0) {
                return ai.l(dm[0].toByteArray());
            }
            return "";
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.w(TAG, e10);
            return "";
        }
    }
}

package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class f {
    private static HashMap<String, ArrayList<String>> aSv = new HashMap<>();
    private static String aSw;

    @Nullable
    private static ArrayList<String> L(Context context, String str) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (aSv.get(str) != null) {
            return aSv.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : M(context, packageName)) {
                String str2 = "error!";
                if ("MD5".equals(str)) {
                    str2 = a(signature, "MD5");
                } else if ("SHA1".equals(str)) {
                    str2 = a(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    str2 = a(signature, "SHA256");
                }
                arrayList.add(str2);
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", "签名信息列表获取失败 " + e10.getMessage());
        }
        aSv.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] M(Context context, String str) {
        try {
            PackageInfo packageInfo = ao.getPackageInfo(context, str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", e10.getMessage());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3).toUpperCase());
                sb2.append(":");
            }
            return sb2.substring(0, sb2.length() - 1);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", e10.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static String bX(Context context) {
        if (!TextUtils.isEmpty(aSw)) {
            return aSw;
        }
        ArrayList<String> L = L(context, "SHA1");
        if (L != null && L.size() != 0) {
            aSw = L.get(0);
        }
        return aSw;
    }
}

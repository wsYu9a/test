package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.bu;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class e {
    private static HashMap<String, ArrayList<String>> ayR = new HashMap<>();
    private static String ayS;

    @Nullable
    private static ArrayList<String> D(Context context, String str) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (ayR.get(str) != null) {
            return ayR.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : E(context, packageName)) {
                String str2 = "error!";
                if (bu.f5659a.equals(str)) {
                    str2 = a(signature, bu.f5659a);
                } else if ("SHA1".equals(str)) {
                    str2 = a(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    str2 = a(signature, "SHA256");
                }
                arrayList.add(str2);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", "签名信息列表获取失败 " + e2.getMessage());
        }
        ayR.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] E(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", e2.getMessage());
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
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", e2.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static String bx(Context context) {
        if (!TextUtils.isEmpty(ayS)) {
            return ayS;
        }
        ArrayList<String> D = D(context, "SHA1");
        if (D != null && D.size() != 0) {
            ayS = D.get(0);
        }
        return ayS;
    }
}

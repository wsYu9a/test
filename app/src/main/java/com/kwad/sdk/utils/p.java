package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class p {
    private static String azu = "";
    private static String azv = "";
    private static String azw = "";

    private static String a(String str, InputStream inputStream) {
        String eq;
        synchronized (p.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.BR();
            eq = oVar.BQ().eq(str);
            oVar.end();
        }
        return eq;
    }

    public static String ce(int i2) {
        String str;
        String str2;
        Context CA = ServiceProvider.CA();
        if (i2 == 0) {
            str = azu;
            str2 = "aes_key";
        } else if (i2 == 1) {
            str = azv;
            str2 = "rsa_public_key";
        } else if (i2 != 2) {
            str = "";
            str2 = str;
        } else {
            str = azw;
            str2 = "rsa_private_key";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get id is error ");
        }
        InputStream inputStream = null;
        try {
            try {
                inputStream = CA.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get InputStream from loader is null,  e: " + th);
            }
            if (inputStream == null) {
                inputStream = CA.getAssets().open("ksad_common_encrypt_image.png");
            }
            String a2 = a(str2, inputStream);
            if (TextUtils.isEmpty(a2)) {
                com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
            }
            if (i2 == 0) {
                azu = a2;
            } else if (i2 == 1) {
                azv = a2;
            } else if (i2 == 2) {
                azw = a2;
            }
            return a2;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
            return "";
        }
    }
}

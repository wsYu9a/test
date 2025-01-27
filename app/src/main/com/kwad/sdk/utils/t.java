package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class t {
    private static String aSZ = "";
    private static String aTa = "";
    private static String aTb = "";

    private static String a(String str, InputStream inputStream) {
        String gA;
        synchronized (t.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.LT();
            gA = oVar.LS().gA(str);
            oVar.end();
        }
        return gA;
    }

    public static String ec(int i10) {
        InputStream inputStream;
        Context MA = ServiceProvider.MA();
        String str = aSZ;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty("aes_key")) {
            Log.e("EncryptUtils", "EncryptUtils getKey get id is error ");
        }
        try {
            try {
                inputStream = MA.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th2) {
                Log.e("EncryptUtils", "EncryptUtils getKey get InputStream from loader is null,  e: " + th2);
                inputStream = null;
            }
            if (inputStream == null) {
                inputStream = MA.getAssets().open("ksad_common_encrypt_image.png");
            }
            String a10 = a("aes_key", inputStream);
            if (TextUtils.isEmpty(a10)) {
                Log.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
            }
            aSZ = a10;
            return a10;
        } catch (Throwable unused) {
            return "";
        }
    }
}

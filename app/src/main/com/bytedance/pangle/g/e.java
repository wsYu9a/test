package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* loaded from: classes2.dex */
public final class e {
    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            o a10 = com.bytedance.pangle.util.i.a() ? d.a(str) : a.a(str);
            Signature[] signatureArr = a10 != null ? a10.f7654b : null;
            byte[] decode = Base64.decode(Zeus.getPlugin(str2).mSignature, 0);
            if (decode == null || decode.length == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
                return false;
            }
            int i10 = 0;
            for (Signature signature : signatureArr) {
                i10 += signature.toByteArray().length;
            }
            byte[] bArr = new byte[i10];
            int i11 = 0;
            for (Signature signature2 : signatureArr) {
                System.arraycopy(signature2.toByteArray(), 0, bArr, i11, signature2.toByteArray().length);
                i11 += signature2.toByteArray().length;
            }
            boolean a11 = o.a(bArr, decode);
            if (!a11) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            }
            return a11;
        } catch (q e10) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e10);
            return false;
        }
    }
}

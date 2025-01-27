package com.vivo.advv.vaf.virtualview.Helper;

import android.text.TextUtils;
import com.vivo.advv.vaf.virtualview.loader.CodeReader;
import com.vivo.advv.virtualview.common.Common;

/* loaded from: classes4.dex */
public class VerificationUtil {
    private static CodeReader codeReader = new CodeReader();

    public static boolean checkContentLength(byte[] bArr) {
        return bArr != null && bArr.length >= 58;
    }

    public static boolean checkFormat(byte[] bArr) {
        if (bArr != null && bArr.length >= 5) {
            return TextUtils.equals(Common.TAG, new String(bArr, 0, 5));
        }
        return false;
    }

    public static boolean checkMajorMinorVersion(byte[] bArr) {
        codeReader.release();
        codeReader.setCode(bArr);
        codeReader.seekBy(5);
        return codeReader.readShort() == 1 && codeReader.readShort() == 0;
    }

    public static boolean checkPatchVersion(byte[] bArr, short s) {
        codeReader.release();
        codeReader.setCode(bArr);
        codeReader.seekBy(9);
        return codeReader.readShort() == s;
    }
}

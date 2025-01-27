package com.tencent.open.web.security;

import com.tencent.open.a;
import com.tencent.open.a.f;

/* loaded from: classes4.dex */
public class SecureJsInterface extends a.b {
    public static boolean isPWDEdit = false;

    /* renamed from: a */
    private String f25560a;

    public void clearAllEdit() {
        f.c("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e2) {
            f.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void curPosFromJS(String str) {
        int i2;
        f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e2);
            i2 = -1;
        }
        if (i2 < 0) {
            throw new RuntimeException("position is illegal.");
        }
        boolean z = a.f25563c;
        boolean z2 = a.f25562b;
        if (z2) {
            if (Boolean.valueOf(JniInterface.BackSpaceChar(z2, i2)).booleanValue()) {
                a.f25562b = false;
                return;
            }
            return;
        }
        String str2 = a.f25561a;
        this.f25560a = str2;
        JniInterface.insetTextToArray(i2, str2, str2.length());
        f.a("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f25560a);
    }

    @Override // com.tencent.open.a.b
    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        f.c("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            f.a("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e2) {
            f.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void isPasswordEdit(String str) {
        int i2;
        f.c("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i2 = Integer.parseInt(str);
        } catch (Exception e2) {
            f.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e2.getMessage());
            i2 = -1;
        }
        if (i2 != 0 && i2 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i2 == 0) {
            isPWDEdit = false;
        } else if (i2 == 1) {
            isPWDEdit = true;
        }
    }
}

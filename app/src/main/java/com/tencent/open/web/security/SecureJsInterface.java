package com.tencent.open.web.security;

import com.tencent.open.a;
import com.tencent.open.a.f;

/* loaded from: classes4.dex */
public class SecureJsInterface extends a.b {
    public static boolean isPWDEdit = false;

    /* renamed from: a */
    private String f23294a;

    public void clearAllEdit() {
        f.c("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e10) {
            f.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e10.getMessage());
            throw new RuntimeException(e10);
        }
    }

    public void curPosFromJS(String str) {
        int i10;
        f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i10 = Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e10);
            i10 = -1;
        }
        if (i10 < 0) {
            throw new RuntimeException("position is illegal.");
        }
        boolean z10 = a.f23297c;
        boolean z11 = a.f23296b;
        if (z11) {
            if (JniInterface.BackSpaceChar(z11, i10)) {
                a.f23296b = false;
                return;
            }
            return;
        }
        String str2 = a.f23295a;
        this.f23294a = str2;
        JniInterface.insetTextToArray(i10, str2, str2.length());
        f.a("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f23294a);
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
        } catch (Exception e10) {
            f.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e10.getMessage());
            throw new RuntimeException(e10);
        }
    }

    public void isPasswordEdit(String str) {
        int i10;
        f.c("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i10 = Integer.parseInt(str);
        } catch (Exception e10) {
            f.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e10.getMessage());
            i10 = -1;
        }
        if (i10 != 0 && i10 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i10 == 0) {
            isPWDEdit = false;
        } else if (i10 == 1) {
            isPWDEdit = true;
        }
    }
}

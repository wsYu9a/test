package com.tencent.open.web.security;

/* loaded from: classes4.dex */
public class JniInterface {
    public static native boolean BackSpaceChar(boolean z, int i2);

    public static native boolean clearAllPWD();

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i2, String str, int i3);
}

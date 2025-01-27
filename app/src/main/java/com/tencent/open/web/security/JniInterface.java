package com.tencent.open.web.security;

/* loaded from: classes4.dex */
public class JniInterface {
    public static native boolean BackSpaceChar(boolean z10, int i10);

    public static native boolean clearAllPWD();

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i10, String str, int i11);
}

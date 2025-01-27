package com.tan.mark;

/* loaded from: classes4.dex */
public class TanId {
    static {
        System.loadLibrary("tanId");
    }

    public static native byte[] getBootFromJNI();

    public static native String getUpdateFromJNI();
}

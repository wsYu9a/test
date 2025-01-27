package com.kwad.sdk.crash;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes3.dex */
public class FakeNativeCrash {
    public static final String TAG = "FakeNativeCrash";

    @Keep
    public static native void init(boolean z10, int i10);

    @Keep
    public static void upload(int i10, int i11, String str) {
        com.kwad.sdk.core.d.c.e(TAG, "upload: signal=" + i10 + ", code=" + i11 + ", nativeBacktraceStr=" + str);
    }
}

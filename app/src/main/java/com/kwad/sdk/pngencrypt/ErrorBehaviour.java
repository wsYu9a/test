package com.kwad.sdk.pngencrypt;

/* loaded from: classes2.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);


    /* renamed from: c, reason: collision with root package name */
    final int f9541c;

    ErrorBehaviour(int i2) {
        this.f9541c = i2;
    }
}

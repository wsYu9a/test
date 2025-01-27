package com.kwad.sdk.pngencrypt;

/* loaded from: classes3.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);


    /* renamed from: c, reason: collision with root package name */
    final int f11979c;

    ErrorBehaviour(int i10) {
        this.f11979c = i10;
    }
}

package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;

/* loaded from: classes4.dex */
public class b {
    public static final void a(d dVar, int i10) throws IOException {
        int b10 = dVar.b();
        if (b10 == i10) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i10) + ", read 0x" + Integer.toHexString(b10) + p1.b.f29697h);
    }
}

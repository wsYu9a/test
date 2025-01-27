package com.ss.android.socialbase.appdownloader.gv.j;

import java.io.IOException;

/* loaded from: classes4.dex */
public class zx {
    public static final void j(g gVar, int i2) throws IOException {
        int zx = gVar.zx();
        if (zx == i2) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i2) + ", read 0x" + Integer.toHexString(zx) + ".");
    }
}

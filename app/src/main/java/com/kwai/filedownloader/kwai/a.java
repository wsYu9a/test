package com.kwai.filedownloader.kwai;

import com.kwai.filedownloader.e.c;

/* loaded from: classes2.dex */
public final class a implements c.a {
    @Override // com.kwai.filedownloader.e.c.a
    public final int ak(long j2) {
        if (j2 < 1048576) {
            return 1;
        }
        if (j2 < 5242880) {
            return 2;
        }
        if (j2 < 52428800) {
            return 3;
        }
        return j2 < 104857600 ? 4 : 5;
    }
}

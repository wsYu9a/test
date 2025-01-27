package com.opos.exoplayer.core.c.d;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.c.n;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a */
    public final boolean f17914a;

    /* renamed from: b */
    @Nullable
    public final String f17915b;

    /* renamed from: c */
    public final n.a f17916c;

    /* renamed from: d */
    public final int f17917d;

    /* renamed from: e */
    public final byte[] f17918e;

    public f(boolean z, @Nullable String str, int i2, byte[] bArr, int i3, int i4, @Nullable byte[] bArr2) {
        com.opos.exoplayer.core.i.a.a((bArr2 == null) ^ (i2 == 0));
        this.f17914a = z;
        this.f17915b = str;
        this.f17917d = i2;
        this.f17918e = bArr2;
        this.f17916c = new n.a(a(str), bArr, i3, i4);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(@Nullable String str) {
        if (str != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals("cbc1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3046671:
                    if (str.equals("cbcs")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3049879:
                    if (str.equals("cenc")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3049895:
                    if (str.equals("cens")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                    return 2;
                default:
                    com.opos.cmn.an.f.a.c("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                case 2:
                case 3:
                    return 1;
            }
        }
        return 1;
    }
}

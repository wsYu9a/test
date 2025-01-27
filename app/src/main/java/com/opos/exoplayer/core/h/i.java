package com.opos.exoplayer.core.h;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a */
    public final Uri f18918a;

    /* renamed from: b */
    public final byte[] f18919b;

    /* renamed from: c */
    public final long f18920c;

    /* renamed from: d */
    public final long f18921d;

    /* renamed from: e */
    public final long f18922e;

    /* renamed from: f */
    @Nullable
    public final String f18923f;

    /* renamed from: g */
    public final int f18924g;

    public i(Uri uri, long j2, long j3, long j4, String str, int i2) {
        this(uri, null, j2, j3, j4, str, i2);
    }

    public i(Uri uri, long j2, long j3, @Nullable String str) {
        this(uri, j2, j2, j3, str, 0);
    }

    public i(Uri uri, byte[] bArr, long j2, long j3, long j4, @Nullable String str, int i2) {
        boolean z = true;
        com.opos.exoplayer.core.i.a.a(j2 >= 0);
        com.opos.exoplayer.core.i.a.a(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z = false;
        }
        com.opos.exoplayer.core.i.a.a(z);
        this.f18918a = uri;
        this.f18919b = bArr;
        this.f18920c = j2;
        this.f18921d = j3;
        this.f18922e = j4;
        this.f18923f = str;
        this.f18924g = i2;
    }

    public boolean a(int i2) {
        return (this.f18924g & i2) == i2;
    }

    public String toString() {
        return "DataSpec[" + this.f18918a + ", " + Arrays.toString(this.f18919b) + ", " + this.f18920c + ", " + this.f18921d + ", " + this.f18922e + ", " + this.f18923f + ", " + this.f18924g + "]";
    }
}

package com.bytedance.pangle.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    InputStream f6107a;

    /* renamed from: b, reason: collision with root package name */
    private int f6108b;

    public b(InputStream inputStream) {
        a(inputStream);
    }

    final void a(InputStream inputStream) {
        this.f6107a = inputStream;
        this.f6108b = 0;
    }

    public final void b() {
        long skip = this.f6107a.skip(4L);
        this.f6108b = (int) (this.f6108b + skip);
        if (skip != 4) {
            throw new EOFException();
        }
    }

    public final int a() {
        int i2 = 0;
        for (int i3 = 0; i3 != 32; i3 += 8) {
            int read = this.f6107a.read();
            if (read == -1) {
                throw new EOFException();
            }
            this.f6108b++;
            i2 |= read << i3;
        }
        return i2;
    }

    public final void b(int i2) {
        int a2 = a();
        if (a2 != i2) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i2), Integer.valueOf(a2)));
        }
    }

    public final int[] a(int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i2 > 0) {
            iArr[i3] = a();
            i2--;
            i3++;
        }
        return iArr;
    }
}

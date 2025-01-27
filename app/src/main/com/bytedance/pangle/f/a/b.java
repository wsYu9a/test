package com.bytedance.pangle.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    InputStream f7609a;

    /* renamed from: b, reason: collision with root package name */
    private int f7610b;

    public b(InputStream inputStream) {
        a(inputStream);
    }

    public final void a(InputStream inputStream) {
        this.f7609a = inputStream;
        this.f7610b = 0;
    }

    public final void b() {
        long skip = this.f7609a.skip(4L);
        this.f7610b = (int) (this.f7610b + skip);
        if (skip != 4) {
            throw new EOFException();
        }
    }

    public final int a() {
        int i10 = 0;
        for (int i11 = 0; i11 != 32; i11 += 8) {
            int read = this.f7609a.read();
            if (read == -1) {
                throw new EOFException();
            }
            this.f7610b++;
            i10 |= read << i11;
        }
        return i10;
    }

    public final void b(int i10) {
        int a10 = a();
        if (a10 != i10) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i10), Integer.valueOf(a10)));
        }
    }

    public final int[] a(int i10) {
        int[] iArr = new int[i10];
        int i11 = 0;
        while (i10 > 0) {
            iArr[i11] = a();
            i10--;
            i11++;
        }
        return iArr;
    }
}

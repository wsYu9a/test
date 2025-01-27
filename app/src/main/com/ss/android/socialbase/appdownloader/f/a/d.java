package com.ss.android.socialbase.appdownloader.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private InputStream f21900a;

    /* renamed from: b */
    private boolean f21901b;

    /* renamed from: c */
    private int f21902c;

    public d() {
    }

    public final void a(InputStream inputStream, boolean z10) {
        this.f21900a = inputStream;
        this.f21901b = z10;
        this.f21902c = 0;
    }

    public final int b() throws IOException {
        return a(4);
    }

    public final void c(int i10) throws IOException {
        if (i10 > 0) {
            long j10 = i10;
            long skip = this.f21900a.skip(j10);
            this.f21902c = (int) (this.f21902c + skip);
            if (skip != j10) {
                throw new EOFException();
            }
        }
    }

    public d(InputStream inputStream, boolean z10) {
        a(inputStream, z10);
    }

    public final int[] b(int i10) throws IOException {
        int[] iArr = new int[i10];
        a(iArr, 0, i10);
        return iArr;
    }

    public final void a() {
        InputStream inputStream = this.f21900a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            a(null, false);
        }
    }

    public final void c() throws IOException {
        c(4);
    }

    public final int a(int i10) throws IOException {
        if (i10 >= 0 && i10 <= 4) {
            int i11 = 0;
            if (this.f21901b) {
                for (int i12 = (i10 - 1) * 8; i12 >= 0; i12 -= 8) {
                    int read = this.f21900a.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f21902c++;
                    i11 |= read << i12;
                }
                return i11;
            }
            int i13 = i10 * 8;
            int i14 = 0;
            while (i11 != i13) {
                int read2 = this.f21900a.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.f21902c++;
                i14 |= read2 << i11;
                i11 += 8;
            }
            return i14;
        }
        throw new IllegalArgumentException();
    }

    public final void a(int[] iArr, int i10, int i11) throws IOException {
        while (i11 > 0) {
            iArr[i10] = b();
            i11--;
            i10++;
        }
    }
}

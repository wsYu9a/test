package com.ss.android.socialbase.appdownloader.gv.j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: i */
    private int f24448i;

    /* renamed from: j */
    private InputStream f24449j;
    private boolean zx;

    public g() {
    }

    public final void i(int i2) throws IOException {
        if (i2 > 0) {
            long j2 = i2;
            long skip = this.f24449j.skip(j2);
            this.f24448i = (int) (this.f24448i + skip);
            if (skip != j2) {
                throw new EOFException();
            }
        }
    }

    public final void j(InputStream inputStream, boolean z) {
        this.f24449j = inputStream;
        this.zx = z;
        this.f24448i = 0;
    }

    public final int zx() throws IOException {
        return j(4);
    }

    public g(InputStream inputStream, boolean z) {
        j(inputStream, z);
    }

    public final int[] zx(int i2) throws IOException {
        int[] iArr = new int[i2];
        j(iArr, 0, i2);
        return iArr;
    }

    public final void i() throws IOException {
        i(4);
    }

    public final void j() {
        InputStream inputStream = this.f24449j;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            j(null, false);
        }
    }

    public final int j(int i2) throws IOException {
        if (i2 >= 0 && i2 <= 4) {
            int i3 = 0;
            if (this.zx) {
                for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
                    int read = this.f24449j.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f24448i++;
                    i3 |= read << i4;
                }
                return i3;
            }
            int i5 = i2 * 8;
            int i6 = 0;
            while (i3 != i5) {
                int read2 = this.f24449j.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.f24448i++;
                i6 |= read2 << i3;
                i3 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final void j(int[] iArr, int i2, int i3) throws IOException {
        while (i3 > 0) {
            iArr[i2] = zx();
            i3--;
            i2++;
        }
    }
}

package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public abstract class CharsetProber {

    /* renamed from: b */
    public static final float f29246b = 0.95f;

    /* renamed from: c */
    public static final int f29247c = 97;

    /* renamed from: d */
    public static final int f29248d = 122;

    /* renamed from: e */
    public static final int f29249e = 65;

    /* renamed from: f */
    public static final int f29250f = 90;

    /* renamed from: g */
    public static final int f29251g = 60;

    /* renamed from: h */
    public static final int f29252h = 62;

    /* renamed from: i */
    public static final int f29253i = 32;

    /* renamed from: a */
    public boolean f29254a = true;

    public enum ProbingState {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    public ByteBuffer a(byte[] bArr, int i10, int i11) {
        ByteBuffer allocate = ByteBuffer.allocate(i11);
        int i12 = i11 + i10;
        int i13 = i10;
        boolean z10 = false;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (b10 == 62) {
                z10 = false;
            } else if (b10 == 60) {
                z10 = true;
            }
            if (h(b10) && i(b10)) {
                if (i10 > i13 && !z10) {
                    allocate.put(bArr, i13, i10 - i13);
                    allocate.put((byte) 32);
                }
                i13 = i10 + 1;
            }
            i10++;
        }
        if (!z10 && i10 > i13) {
            allocate.put(bArr, i13, i10 - i13);
        }
        return allocate;
    }

    public ByteBuffer b(byte[] bArr, int i10, int i11) {
        ByteBuffer allocate = ByteBuffer.allocate(i11);
        int i12 = i11 + i10;
        int i13 = i10;
        boolean z10 = false;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (!h(b10)) {
                z10 = true;
            } else if (i(b10)) {
                if (!z10 || i10 <= i13) {
                    i13 = i10 + 1;
                } else {
                    allocate.put(bArr, i13, i10 - i13);
                    allocate.put((byte) 32);
                    i13 = i10 + 1;
                    z10 = false;
                }
            }
            i10++;
        }
        if (z10 && i10 > i13) {
            allocate.put(bArr, i13, i10 - i13);
        }
        return allocate;
    }

    public abstract String c();

    public abstract float d();

    public abstract ProbingState e();

    public abstract ProbingState f(byte[] bArr, int i10, int i11);

    public boolean g() {
        return this.f29254a;
    }

    public final boolean h(byte b10) {
        return (b10 & 128) == 0;
    }

    public final boolean i(byte b10) {
        int i10 = b10 & 255;
        return i10 < 65 || (i10 > 90 && i10 < 97) || i10 > 122;
    }

    public abstract void j();

    public void k(boolean z10) {
        this.f29254a = z10;
    }

    public abstract void l();
}

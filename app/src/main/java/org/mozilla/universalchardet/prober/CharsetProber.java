package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes5.dex */
public abstract class CharsetProber {

    /* renamed from: a */
    public static final float f35416a = 0.95f;

    /* renamed from: b */
    public static final int f35417b = 97;

    /* renamed from: c */
    public static final int f35418c = 122;

    /* renamed from: d */
    public static final int f35419d = 65;

    /* renamed from: e */
    public static final int f35420e = 90;

    /* renamed from: f */
    public static final int f35421f = 60;

    /* renamed from: g */
    public static final int f35422g = 62;

    /* renamed from: h */
    public static final int f35423h = 32;

    public enum ProbingState {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    private boolean g(byte b2) {
        return (b2 & ByteCompanionObject.MIN_VALUE) == 0;
    }

    private boolean h(byte b2) {
        int i2 = b2 & 255;
        return i2 < 65 || (i2 > 90 && i2 < 97) || i2 > 122;
    }

    public ByteBuffer a(byte[] bArr, int i2, int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        int i4 = i3 + i2;
        int i5 = i2;
        boolean z = false;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (b2 == 62) {
                z = false;
            } else if (b2 == 60) {
                z = true;
            }
            if (g(b2) && h(b2)) {
                if (i2 > i5 && !z) {
                    allocate.put(bArr, i5, i2 - i5);
                    allocate.put(g.s);
                }
                i5 = i2 + 1;
            }
            i2++;
        }
        if (!z && i2 > i5) {
            allocate.put(bArr, i5, i2 - i5);
        }
        return allocate;
    }

    public ByteBuffer b(byte[] bArr, int i2, int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        int i4 = i3 + i2;
        int i5 = i2;
        boolean z = false;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (!g(b2)) {
                z = true;
            } else if (h(b2)) {
                if (!z || i2 <= i5) {
                    i5 = i2 + 1;
                } else {
                    allocate.put(bArr, i5, i2 - i5);
                    allocate.put(g.s);
                    i5 = i2 + 1;
                    z = false;
                }
            }
            i2++;
        }
        if (z && i2 > i5) {
            allocate.put(bArr, i5, i2 - i5);
        }
        return allocate;
    }

    public abstract String c();

    public abstract float d();

    public abstract ProbingState e();

    public abstract ProbingState f(byte[] bArr, int i2, int i3);

    public abstract void i();

    public abstract void j();
}

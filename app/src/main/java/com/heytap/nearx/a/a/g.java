package com.heytap.nearx.a.a;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    private final BufferedSink f9043a;

    public g(BufferedSink bufferedSink) {
        this.f9043a = bufferedSink;
    }

    static int a(int i2) {
        return c(b(i2, a.VARINT));
    }

    static int a(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    static int a(String str) {
        int i2;
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i4 += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i4 += 3;
                } else if (charAt <= 56319 && (i2 = i3 + 1) < length && str.charAt(i2) >= 56320 && str.charAt(i2) <= 57343) {
                    i4 += 4;
                    i3 = i2;
                }
                i3++;
            }
            i4++;
            i3++;
        }
        return i4;
    }

    static int b(int i2) {
        if (i2 >= 0) {
            return c(i2);
        }
        return 10;
    }

    private static int b(int i2, a aVar) {
        return (i2 << 3) | aVar.f9011e;
    }

    static long b(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    static int c(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    static int d(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    static int e(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public void a(int i2, a aVar) throws IOException {
        g(b(i2, aVar));
    }

    public void a(ByteString byteString) throws IOException {
        this.f9043a.write(byteString);
    }

    public void b(String str) throws IOException {
        this.f9043a.writeUtf8(str);
    }

    public void d(long j2) throws IOException {
        while (true) {
            long j3 = (-128) & j2;
            BufferedSink bufferedSink = this.f9043a;
            if (j3 == 0) {
                bufferedSink.writeByte((int) j2);
                return;
            } else {
                bufferedSink.writeByte((((int) j2) & 127) | 128);
                j2 >>>= 7;
            }
        }
    }

    public void e(long j2) throws IOException {
        this.f9043a.writeLongLe(j2);
    }

    void f(int i2) throws IOException {
        if (i2 >= 0) {
            g(i2);
        } else {
            d(i2);
        }
    }

    public void g(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            this.f9043a.writeByte((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.f9043a.writeByte(i2);
    }

    public void h(int i2) throws IOException {
        this.f9043a.writeIntLe(i2);
    }
}

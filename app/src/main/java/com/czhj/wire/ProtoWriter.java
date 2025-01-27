package com.czhj.wire;

import com.czhj.wire.okio.BufferedSink;
import com.czhj.wire.okio.ByteString;
import d3.a;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class ProtoWriter {

    /* renamed from: a */
    public final BufferedSink f8876a;

    public ProtoWriter(BufferedSink bufferedSink) {
        this.f8876a = bufferedSink;
    }

    public static int a(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static int b(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static int c(long j10) {
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (((-16384) & j10) == 0) {
            return 2;
        }
        if (((-2097152) & j10) == 0) {
            return 3;
        }
        if (((-268435456) & j10) == 0) {
            return 4;
        }
        if (((-34359738368L) & j10) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j10) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j10) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j10) == 0) {
            return 8;
        }
        return (j10 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int d(int i10) {
        return e(a(i10, FieldEncoding.VARINT));
    }

    public static int e(int i10) {
        if ((i10 & a.f25243g) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public void f(int i10) throws IOException {
        if (i10 >= 0) {
            writeVarint32(i10);
        } else {
            writeVarint64(i10);
        }
    }

    public void writeBytes(ByteString byteString) throws IOException {
        this.f8876a.write(byteString);
    }

    public void writeFixed32(int i10) throws IOException {
        this.f8876a.writeIntLe(i10);
    }

    public void writeFixed64(long j10) throws IOException {
        this.f8876a.writeLongLe(j10);
    }

    public void writeString(String str) throws IOException {
        this.f8876a.writeUtf8(str);
    }

    public void writeTag(int i10, FieldEncoding fieldEncoding) throws IOException {
        writeVarint32(a(i10, fieldEncoding));
    }

    public void writeVarint32(int i10) throws IOException {
        while ((i10 & a.f25243g) != 0) {
            this.f8876a.writeByte((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f8876a.writeByte(i10);
    }

    public void writeVarint64(long j10) throws IOException {
        while (true) {
            long j11 = (-128) & j10;
            BufferedSink bufferedSink = this.f8876a;
            if (j11 == 0) {
                bufferedSink.writeByte((int) j10);
                return;
            } else {
                bufferedSink.writeByte((((int) j10) & 127) | 128);
                j10 >>>= 7;
            }
        }
    }

    public static long a(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static long b(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int c(int i10) {
        if (i10 >= 0) {
            return e(i10);
        }
        return 10;
    }

    public static int a(int i10, FieldEncoding fieldEncoding) {
        return (i10 << 3) | fieldEncoding.value;
    }
}

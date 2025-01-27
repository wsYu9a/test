package com.czhj.wire.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.C;
import b5.a;
import com.sigmob.sdk.archives.tar.e;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nf.c;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes2.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable {

    /* renamed from: c */
    public static final byte[] f8897c = {e.E, e.F, e.G, e.H, e.I, e.J, e.K, e.L, c.f28888t, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: d */
    public static final int f8898d = 65533;

    /* renamed from: a */
    public Segment f8899a;

    /* renamed from: b */
    public long f8900b;

    /* renamed from: com.czhj.wire.okio.Buffer$1 */
    public class AnonymousClass1 extends OutputStream {
        public AnonymousClass1() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            Buffer.this.writeByte((int) ((byte) i10));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            Buffer.this.write(bArr, i10, i11);
        }
    }

    /* renamed from: com.czhj.wire.okio.Buffer$2 */
    public class AnonymousClass2 extends InputStream {
        public AnonymousClass2() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(Buffer.this.f8900b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            Buffer buffer = Buffer.this;
            if (buffer.f8900b > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return Buffer.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            return Buffer.this.read(bArr, i10, i11);
        }
    }

    public final ByteString a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.f8899a;
            byte[] bArr = segment.f8950a;
            int i10 = segment.f8951b;
            messageDigest.update(bArr, i10, segment.f8952c - i10);
            Segment segment2 = this.f8899a;
            while (true) {
                segment2 = segment2.f8955f;
                if (segment2 == this.f8899a) {
                    return ByteString.of(messageDigest.digest());
                }
                byte[] bArr2 = segment2.f8950a;
                int i11 = segment2.f8951b;
                messageDigest.update(bArr2, i11, segment2.f8952c - i11);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource, com.czhj.wire.okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public void clear() {
        try {
            skip(this.f8900b);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: clone */
    public Buffer m31clone() {
        Buffer buffer = new Buffer();
        if (this.f8900b == 0) {
            return buffer;
        }
        Segment segment = new Segment(this.f8899a);
        buffer.f8899a = segment;
        segment.f8956g = segment;
        segment.f8955f = segment;
        Segment segment2 = this.f8899a;
        while (true) {
            segment2 = segment2.f8955f;
            if (segment2 == this.f8899a) {
                buffer.f8900b = this.f8900b;
                return buffer;
            }
            buffer.f8899a.f8956g.push(new Segment(segment2));
        }
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public long completeSegmentByteCount() {
        long j10 = this.f8900b;
        if (j10 == 0) {
            return 0L;
        }
        Segment segment = this.f8899a.f8956g;
        return (segment.f8952c >= 8192 || !segment.f8954e) ? j10 : j10 - (r3 - segment.f8951b);
    }

    public Buffer copyTo(Buffer buffer, long j10, long j11) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.f8900b, j10, j11);
        if (j11 == 0) {
            return this;
        }
        buffer.f8900b += j11;
        Segment segment = this.f8899a;
        while (true) {
            long j12 = segment.f8952c - segment.f8951b;
            if (j10 < j12) {
                break;
            }
            j10 -= j12;
            segment = segment.f8955f;
        }
        while (j11 > 0) {
            Segment segment2 = new Segment(segment);
            int i10 = (int) (segment2.f8951b + j10);
            segment2.f8951b = i10;
            segment2.f8952c = Math.min(i10 + ((int) j11), segment2.f8952c);
            Segment segment3 = buffer.f8899a;
            if (segment3 == null) {
                segment2.f8956g = segment2;
                segment2.f8955f = segment2;
                buffer.f8899a = segment2;
            } else {
                segment3.f8956g.push(segment2);
            }
            j11 -= segment2.f8952c - segment2.f8951b;
            segment = segment.f8955f;
            j10 = 0;
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j10 = this.f8900b;
        if (j10 != buffer.f8900b) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        Segment segment = this.f8899a;
        Segment segment2 = buffer.f8899a;
        int i10 = segment.f8951b;
        int i11 = segment2.f8951b;
        while (j11 < this.f8900b) {
            long min = Math.min(segment.f8952c - i10, segment2.f8952c - i11);
            int i12 = 0;
            while (i12 < min) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (segment.f8950a[i10] != segment2.f8950a[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == segment.f8952c) {
                segment = segment.f8955f;
                i10 = segment.f8951b;
            }
            if (i11 == segment2.f8952c) {
                segment2 = segment2.f8955f;
                i11 = segment2.f8951b;
            }
            j11 += min;
        }
        return true;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean exhausted() {
        return this.f8900b == 0;
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() {
    }

    public byte getByte(long j10) {
        Util.checkOffsetAndCount(this.f8900b, j10, 1L);
        Segment segment = this.f8899a;
        while (true) {
            int i10 = segment.f8952c;
            int i11 = segment.f8951b;
            long j11 = i10 - i11;
            if (j10 < j11) {
                return segment.f8950a[i11 + ((int) j10)];
            }
            j10 -= j11;
            segment = segment.f8955f;
        }
    }

    public int hashCode() {
        Segment segment = this.f8899a;
        if (segment == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = segment.f8952c;
            for (int i12 = segment.f8951b; i12 < i11; i12++) {
                i10 = (i10 * 31) + segment.f8950a[i12];
            }
            segment = segment.f8955f;
        } while (segment != this.f8899a);
        return i10;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b10) {
        return indexOf(b10, 0L);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.czhj.wire.okio.Buffer.2
            public AnonymousClass2() {
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.f8900b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.f8900b > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) {
                return Buffer.this.read(bArr, i10, i11);
            }
        };
    }

    public ByteString md5() {
        return a("MD5");
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.czhj.wire.okio.Buffer.1
            public AnonymousClass1() {
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i10) {
                Buffer.this.writeByte((int) ((byte) i10));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                Buffer.this.write(bArr, i10, i11);
            }
        };
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j10 = this.f8900b;
        if (j10 > 0) {
            sink.write(this, j10);
        }
        return j10;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte readByte() {
        long j10 = this.f8900b;
        if (j10 == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.f8899a;
        int i10 = segment.f8951b;
        int i11 = segment.f8952c;
        int i12 = i10 + 1;
        byte b10 = segment.f8950a[i10];
        this.f8900b = j10 - 1;
        if (i12 == i11) {
            this.f8899a = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.f8951b = i12;
        }
        return b10;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.f8900b);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00af A[EDGE_INSN: B:46:0x00af->B:40:0x00af BREAK  A[LOOP:0: B:4:0x0011->B:45:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7  */
    @Override // com.czhj.wire.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f8900b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lba
            r1 = 0
            r5 = -7
            r6 = r5
            r2 = 0
            r4 = r3
            r3 = 0
        L11:
            com.czhj.wire.okio.Segment r8 = r0.f8899a
            byte[] r9 = r8.f8950a
            int r10 = r8.f8951b
            int r11 = r8.f8952c
        L19:
            if (r10 >= r11) goto L9b
            r12 = r9[r10]
            r13 = 48
            if (r12 < r13) goto L6c
            r13 = 57
            if (r12 > r13) goto L6c
            int r13 = 48 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L3f
            if (r16 != 0) goto L38
            long r14 = (long) r13
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 >= 0) goto L38
            goto L3f
        L38:
            r14 = 10
            long r4 = r4 * r14
            long r12 = (long) r13
            long r4 = r4 + r12
            goto L77
        L3f:
            com.czhj.wire.okio.Buffer r1 = new com.czhj.wire.okio.Buffer
            r1.<init>()
            com.czhj.wire.okio.Buffer r1 = r1.writeDecimalLong(r4)
            com.czhj.wire.okio.Buffer r1 = r1.writeByte(r12)
            if (r2 != 0) goto L51
            r1.readByte()
        L51:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6c:
            r13 = 45
            r14 = 1
            if (r12 != r13) goto L7c
            if (r1 != 0) goto L7c
            r12 = 1
            long r6 = r6 - r12
            r2 = 1
        L77:
            int r10 = r10 + 1
            int r1 = r1 + 1
            goto L19
        L7c:
            if (r1 == 0) goto L80
            r3 = 1
            goto L9b
        L80:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9b:
            if (r10 != r11) goto La7
            com.czhj.wire.okio.Segment r9 = r8.pop()
            r0.f8899a = r9
            com.czhj.wire.okio.SegmentPool.a(r8)
            goto La9
        La7:
            r8.f8951b = r10
        La9:
            if (r3 != 0) goto Laf
            com.czhj.wire.okio.Segment r8 = r0.f8899a
            if (r8 != 0) goto L11
        Laf:
            long r6 = r0.f8900b
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.f8900b = r6
            if (r2 == 0) goto Lb8
            goto Lb9
        Lb8:
            long r4 = -r4
        Lb9:
            return r4
        Lba:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.Buffer.readDecimalLong():long");
    }

    public Buffer readFrom(InputStream inputStream) throws IOException {
        a(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(Buffer buffer, long j10) throws EOFException {
        long j11 = this.f8900b;
        if (j11 >= j10) {
            buffer.write(this, j10);
        } else {
            buffer.write(this, j11);
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[EDGE_INSN: B:40:0x00a2->B:37:0x00a2 BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    @Override // com.czhj.wire.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.f8900b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La9
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.czhj.wire.okio.Segment r6 = r15.f8899a
            byte[] r7 = r6.f8950a
            int r8 = r6.f8951b
            int r9 = r6.f8952c
        L13:
            if (r8 >= r9) goto L8e
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L37
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-87)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L6f
            r11 = 70
            if (r10 > r11) goto L6f
            int r11 = r10 + (-55)
        L37:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L47
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L47:
            com.czhj.wire.okio.Buffer r0 = new com.czhj.wire.okio.Buffer
            r0.<init>()
            com.czhj.wire.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            com.czhj.wire.okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L6f:
            if (r0 == 0) goto L73
            r1 = 1
            goto L8e
        L73:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8e:
            if (r8 != r9) goto L9a
            com.czhj.wire.okio.Segment r7 = r6.pop()
            r15.f8899a = r7
            com.czhj.wire.okio.SegmentPool.a(r6)
            goto L9c
        L9a:
            r6.f8951b = r8
        L9c:
            if (r1 != 0) goto La2
            com.czhj.wire.okio.Segment r6 = r15.f8899a
            if (r6 != 0) goto Lb
        La2:
            long r1 = r15.f8900b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f8900b = r1
            return r4
        La9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readInt() {
        long j10 = this.f8900b;
        if (j10 < 4) {
            throw new IllegalStateException("size < 4: " + this.f8900b);
        }
        Segment segment = this.f8899a;
        int i10 = segment.f8951b;
        int i11 = segment.f8952c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.f8950a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        this.f8900b = j10 - 4;
        if (i14 == i11) {
            this.f8899a = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.f8951b = i14;
        }
        return i15;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLong() {
        long j10 = this.f8900b;
        if (j10 < 8) {
            throw new IllegalStateException("size < 8: " + this.f8900b);
        }
        Segment segment = this.f8899a;
        int i10 = segment.f8951b;
        int i11 = segment.f8952c;
        if (i11 - i10 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.f8950a;
        int i12 = i10 + 7;
        long j11 = ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10] & 255) << 56) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
        int i13 = i10 + 8;
        long j12 = j11 | (bArr[i12] & 255);
        this.f8900b = j10 - 8;
        if (i13 == i11) {
            this.f8899a = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.f8951b = i13;
        }
        return j12;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShort() {
        long j10 = this.f8900b;
        if (j10 < 2) {
            throw new IllegalStateException("size < 2: " + this.f8900b);
        }
        Segment segment = this.f8899a;
        int i10 = segment.f8951b;
        int i11 = segment.f8952c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.f8950a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        this.f8900b = j10 - 2;
        if (i14 == i11) {
            this.f8899a = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.f8951b = i14;
        }
        return (short) i15;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(long j10, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.f8900b, 0L, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j10 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        }
        if (j10 == 0) {
            return "";
        }
        Segment segment = this.f8899a;
        int i10 = segment.f8951b;
        if (i10 + j10 > segment.f8952c) {
            return new String(readByteArray(j10), charset);
        }
        String str = new String(segment.f8950a, i10, (int) j10, charset);
        int i11 = (int) (segment.f8951b + j10);
        segment.f8951b = i11;
        this.f8900b -= j10;
        if (i11 == segment.f8952c) {
            this.f8899a = segment.pop();
            SegmentPool.a(segment);
        }
        return str;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.f8900b, Util.UTF_8);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (this.f8900b == 0) {
            throw new EOFException();
        }
        byte b10 = getByte(0L);
        if ((b10 & 128) == 0) {
            i10 = b10 & Byte.MAX_VALUE;
            i11 = 1;
            i12 = 0;
        } else if ((b10 & 224) == 192) {
            i10 = b10 & a.I;
            i11 = 2;
            i12 = 128;
        } else if ((b10 & 240) == 224) {
            i10 = b10 & 15;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((b10 & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i10 = b10 & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (this.f8900b < j10) {
            throw new EOFException("size < " + i11 + ": " + this.f8900b + " (to read code point prefixed 0x" + Integer.toHexString(b10) + ")");
        }
        for (int i13 = 1; i13 < i11; i13++) {
            long j11 = i13;
            byte b11 = getByte(j11);
            if ((b11 & 192) != 128) {
                skip(j11);
                return 65533;
            }
            i10 = (i10 << 6) | (b11 & okio.Utf8.REPLACEMENT_BYTE);
        }
        skip(j10);
        if (i10 > 1114111) {
            return 65533;
        }
        if ((i10 < 55296 || i10 > 57343) && i10 >= i12) {
            return i10;
        }
        return 65533;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return a(indexOf);
        }
        long j10 = this.f8900b;
        if (j10 != 0) {
            return readUtf8(j10);
        }
        return null;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return a(indexOf);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, this.f8900b));
        throw new EOFException("\\n not found: size=" + size() + " content=" + buffer.readByteString().hex() + "…");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean request(long j10) {
        return this.f8900b >= j10;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void require(long j10) throws EOFException {
        if (this.f8900b < j10) {
            throw new EOFException();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int select(Options options) {
        Segment segment = this.f8899a;
        if (segment == null) {
            return options.indexOf(ByteString.EMPTY);
        }
        ByteString[] byteStringArr = options.f8943a;
        int length = byteStringArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            ByteString byteString = byteStringArr[i10];
            if (this.f8900b >= byteString.size() && a(segment, segment.f8951b, byteString, 0, byteString.size())) {
                try {
                    skip(byteString.size());
                    return i10;
                } catch (EOFException e10) {
                    throw new AssertionError(e10);
                }
            }
        }
        return -1;
    }

    public ByteString sha1() {
        return a("SHA-1");
    }

    public ByteString sha256() {
        return a("SHA-256");
    }

    public long size() {
        return this.f8900b;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            if (this.f8899a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j10, r0.f8952c - r0.f8951b);
            long j11 = min;
            this.f8900b -= j11;
            j10 -= j11;
            Segment segment = this.f8899a;
            int i10 = segment.f8951b + min;
            segment.f8951b = i10;
            if (i10 == segment.f8952c) {
                this.f8899a = segment.pop();
                SegmentPool.a(segment);
            }
        }
    }

    public ByteString snapshot() {
        long j10 = this.f8900b;
        if (j10 <= 2147483647L) {
            return snapshot((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f8900b);
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.a(this);
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeByte(int i10) {
        Segment a10 = a(1);
        byte[] bArr = a10.f8950a;
        int i11 = a10.f8952c;
        a10.f8952c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.f8900b++;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeDecimalLong(long j10) {
        boolean z10;
        if (j10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j10 < C.NANOS_PER_SECOND ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < C.MICROS_PER_SECOND ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        Segment a10 = a(i10);
        byte[] bArr = a10.f8950a;
        int i11 = a10.f8952c + i10;
        while (j10 != 0) {
            i11--;
            bArr[i11] = f8897c[(int) (j10 % 10)];
            j10 /= 10;
        }
        if (z10) {
            bArr[i11 - 1] = 45;
        }
        a10.f8952c += i10;
        this.f8900b += i10;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        Segment a10 = a(numberOfTrailingZeros);
        byte[] bArr = a10.f8950a;
        int i10 = a10.f8952c;
        for (int i11 = (i10 + numberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = f8897c[(int) (15 & j10)];
            j10 >>>= 4;
        }
        a10.f8952c += numberOfTrailingZeros;
        this.f8900b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeInt(int i10) {
        Segment a10 = a(4);
        byte[] bArr = a10.f8950a;
        int i11 = a10.f8952c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        a10.f8952c = i11 + 4;
        this.f8900b += 4;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeIntLe(int i10) {
        return writeInt(Util.reverseBytesInt(i10));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeLong(long j10) {
        Segment a10 = a(8);
        byte[] bArr = a10.f8950a;
        int i10 = a10.f8952c;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        bArr[i10 + 1] = (byte) ((j10 >>> 48) & 255);
        bArr[i10 + 2] = (byte) ((j10 >>> 40) & 255);
        bArr[i10 + 3] = (byte) ((j10 >>> 32) & 255);
        bArr[i10 + 4] = (byte) ((j10 >>> 24) & 255);
        bArr[i10 + 5] = (byte) ((j10 >>> 16) & 255);
        bArr[i10 + 6] = (byte) ((j10 >>> 8) & 255);
        bArr[i10 + 7] = (byte) (j10 & 255);
        a10.f8952c = i10 + 8;
        this.f8900b += 8;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeLongLe(long j10) {
        return writeLong(Util.reverseBytesLong(j10));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeShort(int i10) {
        Segment a10 = a(2);
        byte[] bArr = a10.f8950a;
        int i11 = a10.f8952c;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        a10.f8952c = i11 + 2;
        this.f8900b += 2;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeShortLe(int i10) {
        return writeShort((int) Util.reverseBytesShort((short) i10));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeString(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(Util.UTF_8)) {
                return writeUtf8(str);
            }
            byte[] bytes = str.substring(i10, i11).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
    }

    public Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.f8900b);
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i10) {
        int i11;
        int i12;
        if (i10 >= 128) {
            if (i10 < 2048) {
                i12 = (i10 >> 6) | 192;
            } else {
                if (i10 < 65536) {
                    if (i10 >= 55296 && i10 <= 57343) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
                    }
                    i11 = (i10 >> 12) | 224;
                } else {
                    if (i10 > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
                    }
                    writeByte((i10 >> 18) | 240);
                    i11 = ((i10 >> 12) & 63) | 128;
                }
                writeByte(i11);
                i12 = ((i10 >> 6) & 63) | 128;
            }
            writeByte(i12);
            i10 = (i10 & 63) | 128;
        }
        writeByte(i10);
        return this;
    }

    public boolean a(long j10, ByteString byteString) {
        int size = byteString.size();
        if (this.f8900b - j10 < size) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (getByte(i10 + j10) != byteString.getByte(i10)) {
                return false;
            }
        }
        return true;
    }

    public Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.f8900b);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b10, long j10) {
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.f8899a;
        if (segment == null) {
            return -1L;
        }
        long j12 = this.f8900b;
        if (j12 - j10 < j10) {
            while (j12 > j10) {
                segment = segment.f8956g;
                j12 -= segment.f8952c - segment.f8951b;
            }
        } else {
            while (true) {
                long j13 = (segment.f8952c - segment.f8951b) + j11;
                if (j13 >= j10) {
                    break;
                }
                segment = segment.f8955f;
                j11 = j13;
            }
            j12 = j11;
        }
        while (j12 < this.f8900b) {
            byte[] bArr = segment.f8950a;
            int i10 = segment.f8952c;
            for (int i11 = (int) ((segment.f8951b + j10) - j12); i11 < i10; i11++) {
                if (bArr[i11] == b10) {
                    return (i11 - segment.f8951b) + j12;
                }
            }
            j12 += segment.f8952c - segment.f8951b;
            segment = segment.f8955f;
            j10 = j12;
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j10) {
        int i10;
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.f8899a;
        if (segment == null) {
            return -1L;
        }
        long j12 = this.f8900b;
        if (j12 - j10 < j10) {
            while (j12 > j10) {
                segment = segment.f8956g;
                j12 -= segment.f8952c - segment.f8951b;
            }
        } else {
            while (true) {
                long j13 = (segment.f8952c - segment.f8951b) + j11;
                if (j13 >= j10) {
                    break;
                }
                segment = segment.f8955f;
                j11 = j13;
            }
            j12 = j11;
        }
        if (byteString.size() == 2) {
            byte b10 = byteString.getByte(0);
            byte b11 = byteString.getByte(1);
            while (j12 < this.f8900b) {
                byte[] bArr = segment.f8950a;
                i10 = (int) ((segment.f8951b + j10) - j12);
                int i11 = segment.f8952c;
                while (i10 < i11) {
                    byte b12 = bArr[i10];
                    if (b12 != b10 && b12 != b11) {
                        i10++;
                    }
                    return (i10 - segment.f8951b) + j12;
                }
                j12 += segment.f8952c - segment.f8951b;
                segment = segment.f8955f;
                j10 = j12;
            }
            return -1L;
        }
        byte[] a10 = byteString.a();
        while (j12 < this.f8900b) {
            byte[] bArr2 = segment.f8950a;
            i10 = (int) ((segment.f8951b + j10) - j12);
            int i12 = segment.f8952c;
            while (i10 < i12) {
                byte b13 = bArr2[i10];
                for (byte b14 : a10) {
                    if (b13 == b14) {
                        return (i10 - segment.f8951b) + j12;
                    }
                }
                i10++;
            }
            j12 += segment.f8952c - segment.f8951b;
            segment = segment.f8955f;
            j10 = j12;
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr, int i10, int i11) {
        Util.checkOffsetAndCount(bArr.length, i10, i11);
        Segment segment = this.f8899a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i11, segment.f8952c - segment.f8951b);
        System.arraycopy(segment.f8950a, segment.f8951b, bArr, i10, min);
        int i12 = segment.f8951b + min;
        segment.f8951b = i12;
        this.f8900b -= min;
        if (i12 == segment.f8952c) {
            this.f8899a = segment.pop();
            SegmentPool.a(segment);
        }
        return min;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray(long j10) throws EOFException {
        Util.checkOffsetAndCount(this.f8900b, 0L, j10);
        if (j10 <= 2147483647L) {
            byte[] bArr = new byte[(int) j10];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString(long j10) throws EOFException {
        return new ByteString(readByteArray(j10));
    }

    public Buffer readFrom(InputStream inputStream, long j10) throws IOException {
        if (j10 >= 0) {
            a(inputStream, j10, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j10);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int read = read(bArr, i10, bArr.length - i10);
            if (read == -1) {
                throw new EOFException();
            }
            i10 += read;
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.f8900b, charset);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8(long j10) throws EOFException {
        return readString(j10, Util.UTF_8);
    }

    public ByteString snapshot(int i10) {
        return i10 == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i10);
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeTo(OutputStream outputStream, long j10) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.f8900b, 0L, j10);
        Segment segment = this.f8899a;
        while (j10 > 0) {
            int min = (int) Math.min(j10, segment.f8952c - segment.f8951b);
            outputStream.write(segment.f8950a, segment.f8951b, min);
            int i10 = segment.f8951b + min;
            segment.f8951b = i10;
            long j11 = min;
            this.f8900b -= j11;
            j10 -= j11;
            if (i10 == segment.f8952c) {
                Segment pop = segment.pop();
                this.f8899a = pop;
                SegmentPool.a(segment);
                segment = pop;
            }
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8(String str, int i10, int i11) {
        char charAt;
        int i12;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
        while (i10 < i11) {
            char charAt2 = str.charAt(i10);
            if (charAt2 < 128) {
                Segment a10 = a(1);
                byte[] bArr = a10.f8950a;
                int i13 = a10.f8952c - i10;
                int min = Math.min(i11, 8192 - i13);
                int i14 = i10 + 1;
                bArr[i10 + i13] = (byte) charAt2;
                while (true) {
                    i10 = i14;
                    if (i10 >= min || (charAt = str.charAt(i10)) >= 128) {
                        break;
                    }
                    i14 = i10 + 1;
                    bArr[i10 + i13] = (byte) charAt;
                }
                int i15 = a10.f8952c;
                int i16 = (i13 + i10) - i15;
                a10.f8952c = i15 + i16;
                this.f8900b += i16;
            } else {
                if (charAt2 < 2048) {
                    i12 = (charAt2 >> 6) | 192;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    writeByte((charAt2 >> '\f') | 224);
                    i12 = ((charAt2 >> 6) & 63) | 128;
                } else {
                    int i17 = i10 + 1;
                    char charAt3 = i17 < i11 ? str.charAt(i17) : (char) 0;
                    if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        writeByte(63);
                        i10 = i17;
                    } else {
                        int i18 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                        writeByte((i18 >> 18) | 240);
                        writeByte(((i18 >> 12) & 63) | 128);
                        writeByte(((i18 >> 6) & 63) | 128);
                        writeByte((i18 & 63) | 128);
                        i10 += 2;
                    }
                }
                writeByte(i12);
                writeByte((charAt2 & '?') | 128);
                i10++;
            }
        }
        return this;
    }

    public final boolean a(Segment segment, int i10, ByteString byteString, int i11, int i12) {
        int i13 = segment.f8952c;
        byte[] bArr = segment.f8950a;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.f8955f;
                byte[] bArr2 = segment.f8950a;
                bArr = bArr2;
                i10 = segment.f8951b;
                i13 = segment.f8952c;
            }
            if (bArr[i10] != byteString.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public Buffer copyTo(OutputStream outputStream, long j10, long j11) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.f8900b, j10, j11);
        if (j11 == 0) {
            return this;
        }
        Segment segment = this.f8899a;
        while (true) {
            long j12 = segment.f8952c - segment.f8951b;
            if (j10 < j12) {
                break;
            }
            j10 -= j12;
            segment = segment.f8955f;
        }
        while (j11 > 0) {
            int min = (int) Math.min(segment.f8952c - r8, j11);
            outputStream.write(segment.f8950a, (int) (segment.f8951b + j10), min);
            j11 -= min;
            segment = segment.f8955f;
            j10 = 0;
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j10) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        long j11 = this.f8900b;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        buffer.write(this, j10);
        return j10;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = i11;
        Util.checkOffsetAndCount(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            Segment a10 = a(1);
            int min = Math.min(i12 - i10, 8192 - a10.f8952c);
            System.arraycopy(bArr, i10, a10.f8950a, a10.f8952c, min);
            i10 += min;
            a10.f8952c += min;
        }
        this.f8900b += j10;
        return this;
    }

    public final void a(InputStream inputStream, long j10, boolean z10) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j10 <= 0 && !z10) {
                return;
            }
            Segment a10 = a(1);
            int read = inputStream.read(a10.f8950a, a10.f8952c, (int) Math.min(j10, 8192 - a10.f8952c));
            if (read == -1) {
                if (!z10) {
                    throw new EOFException();
                }
                return;
            } else {
                a10.f8952c += read;
                long j11 = read;
                this.f8900b += j11;
                j10 -= j11;
            }
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString, long j10) throws IOException {
        byte[] bArr;
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.f8899a;
        long j12 = -1;
        if (segment == null) {
            return -1L;
        }
        long j13 = this.f8900b;
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                segment = segment.f8956g;
                j13 -= segment.f8952c - segment.f8951b;
            }
        } else {
            while (true) {
                long j14 = (segment.f8952c - segment.f8951b) + j11;
                if (j14 >= j10) {
                    break;
                }
                segment = segment.f8955f;
                j11 = j14;
            }
            j13 = j11;
        }
        byte b10 = byteString.getByte(0);
        int size = byteString.size();
        long j15 = 1 + (this.f8900b - size);
        long j16 = j10;
        Segment segment2 = segment;
        long j17 = j13;
        while (j17 < j15) {
            byte[] bArr2 = segment2.f8950a;
            int min = (int) Math.min(segment2.f8952c, (segment2.f8951b + j15) - j17);
            int i10 = (int) ((segment2.f8951b + j16) - j17);
            while (i10 < min) {
                if (bArr2[i10] == b10) {
                    bArr = bArr2;
                    if (a(segment2, i10 + 1, byteString, 1, size)) {
                        return (i10 - segment2.f8951b) + j17;
                    }
                } else {
                    bArr = bArr2;
                }
                i10++;
                bArr2 = bArr;
            }
            j17 += segment2.f8952c - segment2.f8951b;
            segment2 = segment2.f8955f;
            j16 = j17;
            j12 = -1;
        }
        return j12;
    }

    public String a(long j10) throws EOFException {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (getByte(j11) == 13) {
                String readUtf8 = readUtf8(j11);
                skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j10);
        skip(1L);
        return readUtf82;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(Source source, long j10) throws IOException {
        while (j10 > 0) {
            long read = source.read(this, j10);
            if (read == -1) {
                throw new EOFException();
            }
            j10 -= read;
        }
        return this;
    }

    public List<Integer> a() {
        if (this.f8899a == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.f8899a;
        arrayList.add(Integer.valueOf(segment.f8952c - segment.f8951b));
        Segment segment2 = this.f8899a;
        while (true) {
            segment2 = segment2.f8955f;
            if (segment2 == this.f8899a) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.f8952c - segment2.f8951b));
        }
    }

    public int a(Options options) {
        Segment segment = this.f8899a;
        ByteString[] byteStringArr = options.f8943a;
        int length = byteStringArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            ByteString byteString = byteStringArr[i10];
            int min = (int) Math.min(this.f8900b, byteString.size());
            if (min == 0 || a(segment, segment.f8951b, byteString, 0, min)) {
                return i10;
            }
        }
        return -1;
    }

    public Segment a(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.f8899a;
        if (segment != null) {
            Segment segment2 = segment.f8956g;
            return (segment2.f8952c + i10 > 8192 || !segment2.f8954e) ? segment2.push(SegmentPool.a()) : segment2;
        }
        Segment a10 = SegmentPool.a();
        this.f8899a = a10;
        a10.f8956g = a10;
        a10.f8955f = a10;
        return a10;
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j10) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.f8900b, 0L, j10);
        while (j10 > 0) {
            Segment segment = buffer.f8899a;
            if (j10 < segment.f8952c - segment.f8951b) {
                Segment segment2 = this.f8899a;
                Segment segment3 = segment2 != null ? segment2.f8956g : null;
                if (segment3 != null && segment3.f8954e) {
                    if ((segment3.f8952c + j10) - (segment3.f8953d ? 0 : segment3.f8951b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        segment.writeTo(segment3, (int) j10);
                        buffer.f8900b -= j10;
                        this.f8900b += j10;
                        return;
                    }
                }
                buffer.f8899a = segment.split((int) j10);
            }
            Segment segment4 = buffer.f8899a;
            long j11 = segment4.f8952c - segment4.f8951b;
            buffer.f8899a = segment4.pop();
            Segment segment5 = this.f8899a;
            if (segment5 == null) {
                this.f8899a = segment4;
                segment4.f8956g = segment4;
                segment4.f8955f = segment4;
            } else {
                segment5.f8956g.push(segment4).compact();
            }
            buffer.f8900b -= j11;
            this.f8900b += j11;
            j10 -= j11;
        }
    }
}

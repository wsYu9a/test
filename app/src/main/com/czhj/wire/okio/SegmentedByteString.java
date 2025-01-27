package com.czhj.wire.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class SegmentedByteString extends ByteString {

    /* renamed from: e */
    public final transient byte[][] f8960e;

    /* renamed from: f */
    public final transient int[] f8961f;

    public SegmentedByteString(Buffer buffer, int i10) {
        super(null);
        Util.checkOffsetAndCount(buffer.f8900b, 0L, i10);
        Segment segment = buffer.f8899a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = segment.f8952c;
            int i15 = segment.f8951b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            segment = segment.f8955f;
        }
        this.f8960e = new byte[i13][];
        this.f8961f = new int[i13 * 2];
        Segment segment2 = buffer.f8899a;
        int i16 = 0;
        while (i11 < i10) {
            byte[][] bArr = this.f8960e;
            bArr[i16] = segment2.f8950a;
            int i17 = segment2.f8952c;
            int i18 = segment2.f8951b;
            i11 += i17 - i18;
            if (i11 > i10) {
                i11 = i10;
            }
            int[] iArr = this.f8961f;
            iArr[i16] = i11;
            iArr[bArr.length + i16] = i18;
            segment2.f8953d = true;
            i16++;
            segment2 = segment2.f8955f;
        }
    }

    private Object writeReplace() {
        return b();
    }

    @Override // com.czhj.wire.okio.ByteString
    public byte[] a() {
        return toByteArray();
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public final ByteString b() {
        return new ByteString(toByteArray());
    }

    @Override // com.czhj.wire.okio.ByteString
    public String base64() {
        return b().base64();
    }

    @Override // com.czhj.wire.okio.ByteString
    public String base64Url() {
        return b().base64Url();
    }

    @Override // com.czhj.wire.okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.czhj.wire.okio.ByteString
    public byte getByte(int i10) {
        Util.checkOffsetAndCount(this.f8961f[this.f8960e.length - 1], i10, 1L);
        int a10 = a(i10);
        int i11 = a10 == 0 ? 0 : this.f8961f[a10 - 1];
        int[] iArr = this.f8961f;
        byte[][] bArr = this.f8960e;
        return bArr[a10][(i10 - i11) + iArr[bArr.length + a10]];
    }

    @Override // com.czhj.wire.okio.ByteString
    public int hashCode() {
        int i10 = this.f8905b;
        if (i10 != 0) {
            return i10;
        }
        int length = this.f8960e.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (i11 < length) {
            byte[] bArr = this.f8960e[i11];
            int[] iArr = this.f8961f;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            int i16 = (i15 - i12) + i14;
            while (i14 < i16) {
                i13 = (i13 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i12 = i15;
        }
        this.f8905b = i13;
        return i13;
    }

    @Override // com.czhj.wire.okio.ByteString
    public String hex() {
        return b().hex();
    }

    @Override // com.czhj.wire.okio.ByteString
    public int indexOf(byte[] bArr, int i10) {
        return b().indexOf(bArr, i10);
    }

    @Override // com.czhj.wire.okio.ByteString
    public int lastIndexOf(byte[] bArr, int i10) {
        return b().lastIndexOf(bArr, i10);
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString md5() {
        return b().md5();
    }

    @Override // com.czhj.wire.okio.ByteString
    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        if (i10 < 0 || i10 > size() - i12) {
            return false;
        }
        int a10 = a(i10);
        while (i12 > 0) {
            int i13 = a10 == 0 ? 0 : this.f8961f[a10 - 1];
            int min = Math.min(i12, ((this.f8961f[a10] - i13) + i13) - i10);
            int[] iArr = this.f8961f;
            byte[][] bArr = this.f8960e;
            if (!byteString.rangeEquals(i11, bArr[a10], (i10 - i13) + iArr[bArr.length + a10], min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            a10++;
        }
        return true;
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString sha256() {
        return b().sha256();
    }

    @Override // com.czhj.wire.okio.ByteString
    public int size() {
        return this.f8961f[this.f8960e.length - 1];
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString substring(int i10) {
        return b().substring(i10);
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString toAsciiLowercase() {
        return b().toAsciiLowercase();
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString toAsciiUppercase() {
        return b().toAsciiUppercase();
    }

    @Override // com.czhj.wire.okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.f8961f;
        byte[][] bArr = this.f8960e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr2 = this.f8961f;
            int i12 = iArr2[length + i10];
            int i13 = iArr2[i10];
            System.arraycopy(this.f8960e[i10], i12, bArr2, i11, i13 - i11);
            i10++;
            i11 = i13;
        }
        return bArr2;
    }

    @Override // com.czhj.wire.okio.ByteString
    public String toString() {
        return b().toString();
    }

    @Override // com.czhj.wire.okio.ByteString
    public String utf8() {
        return b().utf8();
    }

    @Override // com.czhj.wire.okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.f8960e.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.f8961f;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            outputStream.write(this.f8960e[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
    }

    public final int a(int i10) {
        int binarySearch = Arrays.binarySearch(this.f8961f, 0, this.f8960e.length, i10 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.czhj.wire.okio.ByteString
    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        if (i10 < 0 || i10 > size() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int a10 = a(i10);
        while (i12 > 0) {
            int i13 = a10 == 0 ? 0 : this.f8961f[a10 - 1];
            int min = Math.min(i12, ((this.f8961f[a10] - i13) + i13) - i10);
            int[] iArr = this.f8961f;
            byte[][] bArr2 = this.f8960e;
            if (!Util.arrayRangeEquals(bArr2[a10], (i10 - i13) + iArr[bArr2.length + a10], bArr, i11, min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            a10++;
        }
        return true;
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString substring(int i10, int i11) {
        return b().substring(i10, i11);
    }

    @Override // com.czhj.wire.okio.ByteString
    public void a(Buffer buffer) {
        int length = this.f8960e.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.f8961f;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            Segment segment = new Segment(this.f8960e[i10], i12, (i12 + i13) - i11);
            Segment segment2 = buffer.f8899a;
            if (segment2 == null) {
                segment.f8956g = segment;
                segment.f8955f = segment;
                buffer.f8899a = segment;
            } else {
                segment2.f8956g.push(segment);
            }
            i10++;
            i11 = i13;
        }
        buffer.f8900b += i11;
    }
}

package k5;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

@p
@a5.c
/* loaded from: classes2.dex */
public final class c0 extends InputStream {

    /* renamed from: b */
    public final Reader f27622b;

    /* renamed from: c */
    public final CharsetEncoder f27623c;

    /* renamed from: d */
    public final byte[] f27624d;

    /* renamed from: e */
    public CharBuffer f27625e;

    /* renamed from: f */
    public ByteBuffer f27626f;

    /* renamed from: g */
    public boolean f27627g;

    /* renamed from: h */
    public boolean f27628h;

    /* renamed from: i */
    public boolean f27629i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c0(java.io.Reader r2, java.nio.charset.Charset r3, int r4) {
        /*
            r1 = this;
            java.nio.charset.CharsetEncoder r3 = r3.newEncoder()
            java.nio.charset.CodingErrorAction r0 = java.nio.charset.CodingErrorAction.REPLACE
            java.nio.charset.CharsetEncoder r3 = r3.onMalformedInput(r0)
            java.nio.charset.CharsetEncoder r3 = r3.onUnmappableCharacter(r0)
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.c0.<init>(java.io.Reader, java.nio.charset.Charset, int):void");
    }

    public static int a(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    public static CharBuffer c(CharBuffer charBuffer) {
        CharBuffer wrap = CharBuffer.wrap(Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        s.e(wrap, charBuffer.position());
        s.c(wrap, charBuffer.limit());
        return wrap;
    }

    public final int b(byte[] bArr, int i10, int i11) {
        int min = Math.min(i11, this.f27626f.remaining());
        this.f27626f.get(bArr, i10, min);
        return min;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27622b.close();
    }

    public final void d() throws IOException {
        if (a(this.f27625e) == 0) {
            if (this.f27625e.position() > 0) {
                s.b(this.f27625e.compact());
            } else {
                this.f27625e = c(this.f27625e);
            }
        }
        int limit = this.f27625e.limit();
        int read = this.f27622b.read(this.f27625e.array(), limit, a(this.f27625e));
        if (read == -1) {
            this.f27627g = true;
        } else {
            s.c(this.f27625e, limit + read);
        }
    }

    public final void e(boolean z10) {
        s.b(this.f27626f);
        if (z10 && this.f27626f.remaining() == 0) {
            this.f27626f = ByteBuffer.allocate(this.f27626f.capacity() * 2);
        } else {
            this.f27628h = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f27624d) == 1) {
            return UnsignedBytes.p(this.f27624d[0]);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r2 <= 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return r2;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r8, int r9, int r10) throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r9 + r10
            int r1 = r8.length
            b5.u.f0(r9, r0, r1)
            r0 = 0
            if (r10 != 0) goto La
            return r0
        La:
            boolean r1 = r7.f27627g
            r2 = 0
        Ld:
            boolean r3 = r7.f27628h
            if (r3 == 0) goto L2e
            int r3 = r9 + r2
            int r4 = r10 - r2
            int r3 = r7.b(r8, r3, r4)
            int r2 = r2 + r3
            if (r2 == r10) goto L29
            boolean r3 = r7.f27629i
            if (r3 == 0) goto L21
            goto L29
        L21:
            r7.f27628h = r0
            java.nio.ByteBuffer r3 = r7.f27626f
            k5.s.a(r3)
            goto L2e
        L29:
            if (r2 <= 0) goto L2c
            goto L2d
        L2c:
            r2 = -1
        L2d:
            return r2
        L2e:
            boolean r3 = r7.f27629i
            if (r3 == 0) goto L35
            java.nio.charset.CoderResult r3 = java.nio.charset.CoderResult.UNDERFLOW
            goto L4c
        L35:
            if (r1 == 0) goto L40
            java.nio.charset.CharsetEncoder r3 = r7.f27623c
            java.nio.ByteBuffer r4 = r7.f27626f
            java.nio.charset.CoderResult r3 = r3.flush(r4)
            goto L4c
        L40:
            java.nio.charset.CharsetEncoder r3 = r7.f27623c
            java.nio.CharBuffer r4 = r7.f27625e
            java.nio.ByteBuffer r5 = r7.f27626f
            boolean r6 = r7.f27627g
            java.nio.charset.CoderResult r3 = r3.encode(r4, r5, r6)
        L4c:
            boolean r4 = r3.isOverflow()
            r5 = 1
            if (r4 == 0) goto L57
            r7.e(r5)
            goto Ld
        L57:
            boolean r4 = r3.isUnderflow()
            if (r4 == 0) goto L6f
            if (r1 == 0) goto L65
            r7.f27629i = r5
            r7.e(r0)
            goto Ld
        L65:
            boolean r3 = r7.f27627g
            if (r3 == 0) goto L6b
            r1 = 1
            goto L2e
        L6b:
            r7.d()
            goto L2e
        L6f:
            boolean r4 = r3.isError()
            if (r4 == 0) goto L2e
            r3.throwException()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.c0.read(byte[], int, int):int");
    }

    public c0(Reader reader, CharsetEncoder charsetEncoder, int i10) {
        this.f27624d = new byte[1];
        this.f27622b = (Reader) b5.u.E(reader);
        this.f27623c = (CharsetEncoder) b5.u.E(charsetEncoder);
        b5.u.k(i10 > 0, "bufferSize must be positive: %s", i10);
        charsetEncoder.reset();
        CharBuffer allocate = CharBuffer.allocate(i10);
        this.f27625e = allocate;
        s.b(allocate);
        this.f27626f = ByteBuffer.allocate(i10);
    }
}

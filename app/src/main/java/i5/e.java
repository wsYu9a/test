package i5;

import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

@Immutable
@h
/* loaded from: classes2.dex */
public abstract class e extends c {

    public final class a extends d {

        /* renamed from: a */
        public final b f26882a;

        public a(int i10) {
            this.f26882a = new b(i10);
        }

        @Override // i5.m
        public HashCode i() {
            return e.this.hashBytes(this.f26882a.a(), 0, this.f26882a.b());
        }

        @Override // i5.d, i5.m, i5.u
        public m c(byte b10) {
            this.f26882a.write(b10);
            return this;
        }

        @Override // i5.d, i5.m, i5.u
        public m e(byte[] bArr, int i10, int i11) {
            this.f26882a.write(bArr, i10, i11);
            return this;
        }

        @Override // i5.d, i5.m, i5.u
        public m f(ByteBuffer byteBuffer) {
            this.f26882a.c(byteBuffer);
            return this;
        }
    }

    public static final class b extends ByteArrayOutputStream {
        public b(int i10) {
            super(i10);
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int b() {
            return ((ByteArrayOutputStream) this).count;
        }

        public void c(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i10 = ((ByteArrayOutputStream) this).count;
            int i11 = i10 + remaining;
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            if (i11 > bArr.length) {
                ((ByteArrayOutputStream) this).buf = Arrays.copyOf(bArr, i10 + remaining);
            }
            byteBuffer.get(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count, remaining);
            ((ByteArrayOutputStream) this).count += remaining;
        }
    }

    @Override // i5.c, i5.k
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).f(byteBuffer).i();
    }

    @Override // i5.c, i5.k
    public abstract HashCode hashBytes(byte[] bArr, int i10, int i11);

    @Override // i5.c, i5.k
    public HashCode hashInt(int i10) {
        return hashBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i10).array());
    }

    @Override // i5.c, i5.k
    public HashCode hashLong(long j10) {
        return hashBytes(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j10).array());
    }

    @Override // i5.c, i5.k
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // i5.c, i5.k
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        ByteBuffer order = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i10 = 0; i10 < length; i10++) {
            order.putChar(charSequence.charAt(i10));
        }
        return hashBytes(order.array());
    }

    @Override // i5.k
    public m newHasher() {
        return newHasher(32);
    }

    @Override // i5.c, i5.k
    public m newHasher(int i10) {
        b5.u.d(i10 >= 0);
        return new a(i10);
    }
}

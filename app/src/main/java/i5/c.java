package i5;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
@h
/* loaded from: classes2.dex */
public abstract class c implements k {
    @Override // i5.k
    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    @Override // i5.k
    public HashCode hashInt(int i10) {
        return newHasher(4).putInt(i10).i();
    }

    @Override // i5.k
    public HashCode hashLong(long j10) {
        return newHasher(8).putLong(j10).i();
    }

    @Override // i5.k
    public <T> HashCode hashObject(@t T t10, Funnel<? super T> funnel) {
        return newHasher().h(t10, funnel).i();
    }

    @Override // i5.k
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().g(charSequence, charset).i();
    }

    @Override // i5.k
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).d(charSequence).i();
    }

    @Override // i5.k
    public m newHasher(int i10) {
        b5.u.k(i10 >= 0, "expectedInputSize must be >= 0 but was %s", i10);
        return newHasher();
    }

    @Override // i5.k
    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        b5.u.f0(i10, i10 + i11, bArr.length);
        return newHasher(i11).e(bArr, i10, i11).i();
    }

    @Override // i5.k
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).f(byteBuffer).i();
    }
}

package i5;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
@h
/* loaded from: classes2.dex */
public interface k {
    int bits();

    HashCode hashBytes(ByteBuffer byteBuffer);

    HashCode hashBytes(byte[] bArr);

    HashCode hashBytes(byte[] bArr, int i10, int i11);

    HashCode hashInt(int i10);

    HashCode hashLong(long j10);

    <T> HashCode hashObject(@t T t10, Funnel<? super T> funnel);

    HashCode hashString(CharSequence charSequence, Charset charset);

    HashCode hashUnencodedChars(CharSequence charSequence);

    m newHasher();

    m newHasher(int i10);
}

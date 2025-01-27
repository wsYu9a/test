package i5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@a5.a
@h
/* loaded from: classes2.dex */
public interface u {
    u a(byte[] bArr);

    u b(char c10);

    u c(byte b10);

    u d(CharSequence charSequence);

    u e(byte[] bArr, int i10, int i11);

    u f(ByteBuffer byteBuffer);

    u g(CharSequence charSequence, Charset charset);

    u putBoolean(boolean z10);

    u putDouble(double d10);

    u putFloat(float f10);

    u putInt(int i10);

    u putLong(long j10);

    u putShort(short s10);
}

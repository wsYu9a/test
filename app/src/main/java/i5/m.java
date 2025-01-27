package i5;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@a5.a
@h
/* loaded from: classes2.dex */
public interface m extends u {
    @Override // i5.u
    m a(byte[] bArr);

    @Override // i5.u
    /* bridge */ /* synthetic */ u a(byte[] bArr);

    @Override // i5.u
    m b(char c10);

    @Override // i5.u
    /* bridge */ /* synthetic */ u b(char c10);

    @Override // i5.u
    m c(byte b10);

    @Override // i5.u
    /* bridge */ /* synthetic */ u c(byte b10);

    @Override // i5.u
    m d(CharSequence charSequence);

    @Override // i5.u
    /* bridge */ /* synthetic */ u d(CharSequence charSequence);

    @Override // i5.u
    m e(byte[] bArr, int i10, int i11);

    @Override // i5.u
    /* bridge */ /* synthetic */ u e(byte[] bArr, int i10, int i11);

    @Override // i5.u
    m f(ByteBuffer byteBuffer);

    @Override // i5.u
    /* bridge */ /* synthetic */ u f(ByteBuffer byteBuffer);

    @Override // i5.u
    m g(CharSequence charSequence, Charset charset);

    @Override // i5.u
    /* bridge */ /* synthetic */ u g(CharSequence charSequence, Charset charset);

    <T> m h(@t T t10, Funnel<? super T> funnel);

    @Deprecated
    int hashCode();

    HashCode i();

    @Override // i5.u
    m putBoolean(boolean z10);

    @Override // i5.u
    /* bridge */ /* synthetic */ u putBoolean(boolean z10);

    @Override // i5.u
    m putDouble(double d10);

    @Override // i5.u
    /* bridge */ /* synthetic */ u putDouble(double d10);

    @Override // i5.u
    m putFloat(float f10);

    @Override // i5.u
    /* bridge */ /* synthetic */ u putFloat(float f10);

    @Override // i5.u
    m putInt(int i10);

    @Override // i5.u
    /* bridge */ /* synthetic */ u putInt(int i10);

    @Override // i5.u
    m putLong(long j10);

    @Override // i5.u
    /* bridge */ /* synthetic */ u putLong(long j10);

    @Override // i5.u
    m putShort(short s10);

    @Override // i5.u
    /* bridge */ /* synthetic */ u putShort(short s10);
}

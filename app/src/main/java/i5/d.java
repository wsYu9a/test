package i5;

import com.google.common.hash.Funnel;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@h
/* loaded from: classes2.dex */
public abstract class d implements m {
    @Override // i5.m, i5.u
    public /* bridge */ /* synthetic */ u c(byte b10) {
        u c10;
        c10 = c(b10);
        return c10;
    }

    @Override // i5.m
    public <T> m h(@t T t10, Funnel<? super T> funnel) {
        funnel.funnel(t10, this);
        return this;
    }

    @Override // i5.m, i5.u
    public m a(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    @Override // i5.m, i5.u
    public m b(char c10) {
        c((byte) c10);
        c((byte) (c10 >>> '\b'));
        return this;
    }

    @Override // i5.m, i5.u
    public m d(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            b(charSequence.charAt(i10));
        }
        return this;
    }

    @Override // i5.m, i5.u
    public m e(byte[] bArr, int i10, int i11) {
        b5.u.f0(i10, i10 + i11, bArr.length);
        for (int i12 = 0; i12 < i11; i12++) {
            c(bArr[i10 + i12]);
        }
        return this;
    }

    @Override // i5.m, i5.u
    public m f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            e(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            q.d(byteBuffer, byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                c(byteBuffer.get());
            }
        }
        return this;
    }

    @Override // i5.m, i5.u
    public m g(CharSequence charSequence, Charset charset) {
        return a(charSequence.toString().getBytes(charset));
    }

    @Override // i5.m, i5.u
    public final m putBoolean(boolean z10) {
        return c(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // i5.m, i5.u
    public final m putDouble(double d10) {
        return putLong(Double.doubleToRawLongBits(d10));
    }

    @Override // i5.m, i5.u
    public final m putFloat(float f10) {
        return putInt(Float.floatToRawIntBits(f10));
    }

    @Override // i5.m, i5.u
    public m putInt(int i10) {
        c((byte) i10);
        c((byte) (i10 >>> 8));
        c((byte) (i10 >>> 16));
        c((byte) (i10 >>> 24));
        return this;
    }

    @Override // i5.m, i5.u
    public m putLong(long j10) {
        for (int i10 = 0; i10 < 64; i10 += 8) {
            c((byte) (j10 >>> i10));
        }
        return this;
    }

    @Override // i5.m, i5.u
    public m putShort(short s10) {
        c((byte) s10);
        c((byte) (s10 >>> 8));
        return this;
    }
}

package i5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@CanIgnoreReturnValue
@h
/* loaded from: classes2.dex */
public abstract class a extends d {

    /* renamed from: a */
    public final ByteBuffer f26877a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    public abstract void update(byte b10);

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // i5.d, i5.m, i5.u
    public m a(byte[] bArr) {
        b5.u.E(bArr);
        update(bArr);
        return this;
    }

    @Override // i5.d, i5.m, i5.u
    public m b(char c10) {
        this.f26877a.putChar(c10);
        return update(2);
    }

    @Override // i5.d, i5.m, i5.u
    public m c(byte b10) {
        update(b10);
        return this;
    }

    @Override // i5.d, i5.m, i5.u
    public m e(byte[] bArr, int i10, int i11) {
        b5.u.f0(i10, i10 + i11, bArr.length);
        update(bArr, i10, i11);
        return this;
    }

    @Override // i5.d, i5.m, i5.u
    public m f(ByteBuffer byteBuffer) {
        update(byteBuffer);
        return this;
    }

    @Override // i5.d, i5.m, i5.u
    public m putInt(int i10) {
        this.f26877a.putInt(i10);
        return update(4);
    }

    @Override // i5.d, i5.m, i5.u
    public m putLong(long j10) {
        this.f26877a.putLong(j10);
        return update(8);
    }

    @Override // i5.d, i5.m, i5.u
    public m putShort(short s10) {
        this.f26877a.putShort(s10);
        return update(2);
    }

    public void update(byte[] bArr, int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            update(bArr[i12]);
        }
    }

    public void update(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            q.d(byteBuffer, byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                update(byteBuffer.get());
            }
        }
    }

    private m update(int i10) {
        try {
            update(this.f26877a.array(), 0, i10);
            return this;
        } finally {
            q.a(this.f26877a);
        }
    }
}

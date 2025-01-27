package i5;

import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@CanIgnoreReturnValue
@h
/* loaded from: classes2.dex */
public abstract class f extends d {

    /* renamed from: a */
    public final ByteBuffer f26884a;

    /* renamed from: b */
    public final int f26885b;

    /* renamed from: c */
    public final int f26886c;

    public f(int i10) {
        this(i10, i10);
    }

    @Override // i5.m
    public final HashCode i() {
        k();
        q.b(this.f26884a);
        if (this.f26884a.remaining() > 0) {
            n(this.f26884a);
            ByteBuffer byteBuffer = this.f26884a;
            q.d(byteBuffer, byteBuffer.limit());
        }
        return j();
    }

    public abstract HashCode j();

    public final void k() {
        q.b(this.f26884a);
        while (this.f26884a.remaining() >= this.f26886c) {
            m(this.f26884a);
        }
        this.f26884a.compact();
    }

    public final void l() {
        if (this.f26884a.remaining() < 8) {
            k();
        }
    }

    public abstract void m(ByteBuffer byteBuffer);

    public void n(ByteBuffer byteBuffer) {
        q.d(byteBuffer, byteBuffer.limit());
        q.c(byteBuffer, this.f26886c + 7);
        while (true) {
            int position = byteBuffer.position();
            int i10 = this.f26886c;
            if (position >= i10) {
                q.c(byteBuffer, i10);
                q.b(byteBuffer);
                m(byteBuffer);
                return;
            }
            byteBuffer.putLong(0L);
        }
    }

    public final m o(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f26884a.remaining()) {
            this.f26884a.put(byteBuffer);
            l();
            return this;
        }
        int position = this.f26885b - this.f26884a.position();
        for (int i10 = 0; i10 < position; i10++) {
            this.f26884a.put(byteBuffer.get());
        }
        k();
        while (byteBuffer.remaining() >= this.f26886c) {
            m(byteBuffer);
        }
        this.f26884a.put(byteBuffer);
        return this;
    }

    public f(int i10, int i11) {
        b5.u.d(i11 % i10 == 0);
        this.f26884a = ByteBuffer.allocate(i11 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f26885b = i11;
        this.f26886c = i10;
    }

    @Override // i5.d, i5.m, i5.u
    public final m b(char c10) {
        this.f26884a.putChar(c10);
        l();
        return this;
    }

    @Override // i5.d, i5.m, i5.u
    public final m c(byte b10) {
        this.f26884a.put(b10);
        l();
        return this;
    }

    @Override // i5.d, i5.m, i5.u
    public final m e(byte[] bArr, int i10, int i11) {
        return o(ByteBuffer.wrap(bArr, i10, i11).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // i5.d, i5.m, i5.u
    public final m f(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return o(byteBuffer);
        } finally {
            byteBuffer.order(order);
        }
    }

    @Override // i5.d, i5.m, i5.u
    public final m putInt(int i10) {
        this.f26884a.putInt(i10);
        l();
        return this;
    }

    @Override // i5.d, i5.m, i5.u
    public final m putLong(long j10) {
        this.f26884a.putLong(j10);
        l();
        return this;
    }

    @Override // i5.d, i5.m, i5.u
    public final m putShort(short s10) {
        this.f26884a.putShort(s10);
        l();
        return this;
    }
}

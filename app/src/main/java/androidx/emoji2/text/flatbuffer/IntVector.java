package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class IntVector extends BaseVector {
    public IntVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 4, byteBuffer);
        return this;
    }

    public int get(int i10) {
        return this.f362bb.getInt(__element(i10));
    }

    public long getAsUnsigned(int i10) {
        return get(i10) & 4294967295L;
    }
}

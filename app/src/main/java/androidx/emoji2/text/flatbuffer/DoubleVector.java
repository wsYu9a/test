package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class DoubleVector extends BaseVector {
    public DoubleVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 8, byteBuffer);
        return this;
    }

    public double get(int i10) {
        return this.f362bb.getDouble(__element(i10));
    }
}

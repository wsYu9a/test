package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class Struct {

    /* renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f367bb;
    protected int bb_pos;

    public void __reset(int i10, ByteBuffer byteBuffer) {
        this.f367bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i10;
        } else {
            this.bb_pos = 0;
        }
    }

    public void __reset() {
        __reset(0, null);
    }
}

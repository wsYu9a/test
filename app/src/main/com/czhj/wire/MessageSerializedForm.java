package com.czhj.wire;

import com.czhj.wire.Message;
import com.czhj.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* loaded from: classes2.dex */
final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final byte[] f8850a;

    /* renamed from: b */
    public final Class<M> f8851b;

    public MessageSerializedForm(byte[] bArr, Class<M> cls) {
        this.f8850a = bArr;
        this.f8851b = cls;
    }

    public Object readResolve() throws ObjectStreamException {
        try {
            return ProtoAdapter.get(this.f8851b).decode(this.f8850a);
        } catch (IOException e10) {
            throw new StreamCorruptedException(e10.getMessage());
        }
    }
}

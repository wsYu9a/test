package com.czhj.wire;

import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.WireEnum;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public EnumAdapter(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
    }

    @Override // com.czhj.wire.ProtoAdapter
    public final E decode(ProtoReader protoReader) throws IOException {
        int readVarint32 = protoReader.readVarint32();
        E fromValue = fromValue(readVarint32);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, this.javaType);
    }

    @Override // com.czhj.wire.ProtoAdapter
    public final void encode(ProtoWriter protoWriter, E e10) throws IOException {
        protoWriter.writeVarint32(e10.getValue());
    }

    @Override // com.czhj.wire.ProtoAdapter
    public final int encodedSize(E e10) {
        return ProtoWriter.e(e10.getValue());
    }

    public abstract E fromValue(int i10);
}

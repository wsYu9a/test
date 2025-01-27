package com.czhj.wire.protobuf;

import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class OneofDescriptorProto extends Message<OneofDescriptorProto, Builder> {
    public static final ProtoAdapter<OneofDescriptorProto> ADAPTER = new ProtoAdapter_OneofDescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    public static final class Builder extends Message.Builder<OneofDescriptorProto, Builder> {
        public String name;

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public OneofDescriptorProto build() {
            return new OneofDescriptorProto(this.name, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_OneofDescriptorProto extends ProtoAdapter<OneofDescriptorProto> {
        public ProtoAdapter_OneofDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, OneofDescriptorProto.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public OneofDescriptorProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.name(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, OneofDescriptorProto oneofDescriptorProto) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, oneofDescriptorProto.name);
            protoWriter.writeBytes(oneofDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(OneofDescriptorProto oneofDescriptorProto) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, oneofDescriptorProto.name) + oneofDescriptorProto.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public OneofDescriptorProto redact(OneofDescriptorProto oneofDescriptorProto) {
            Builder newBuilder = oneofDescriptorProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public OneofDescriptorProto(String str) {
        this(str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OneofDescriptorProto)) {
            return false;
        }
        OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj;
        return unknownFields().equals(oneofDescriptorProto.unknownFields()) && Internal.equals(this.name, oneofDescriptorProto.name);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.name != null) {
            sb2.append(", name=");
            sb2.append(this.name);
        }
        StringBuilder replace = sb2.replace(0, 2, "OneofDescriptorProto{");
        replace.append('}');
        return replace.toString();
    }

    public OneofDescriptorProto(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

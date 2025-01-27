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
public final class EnumValueDescriptorProto extends Message<EnumValueDescriptorProto, Builder> {
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer number;

    @WireField(adapter = "com.google.protobuf.EnumValueOptions#ADAPTER", tag = 3)
    public final EnumValueOptions options;
    public static final ProtoAdapter<EnumValueDescriptorProto> ADAPTER = new ProtoAdapter_EnumValueDescriptorProto();
    public static final Integer DEFAULT_NUMBER = 0;

    public static final class Builder extends Message.Builder<EnumValueDescriptorProto, Builder> {
        public String name;
        public Integer number;
        public EnumValueOptions options;

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder number(Integer num) {
            this.number = num;
            return this;
        }

        public Builder options(EnumValueOptions enumValueOptions) {
            this.options = enumValueOptions;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public EnumValueDescriptorProto build() {
            return new EnumValueDescriptorProto(this.name, this.number, this.options, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_EnumValueDescriptorProto extends ProtoAdapter<EnumValueDescriptorProto> {
        public ProtoAdapter_EnumValueDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, EnumValueDescriptorProto.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public EnumValueDescriptorProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.number(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.options(EnumValueOptions.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, EnumValueDescriptorProto enumValueDescriptorProto) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, enumValueDescriptorProto.name);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, enumValueDescriptorProto.number);
            EnumValueOptions.ADAPTER.encodeWithTag(protoWriter, 3, enumValueDescriptorProto.options);
            protoWriter.writeBytes(enumValueDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(EnumValueDescriptorProto enumValueDescriptorProto) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, enumValueDescriptorProto.name) + ProtoAdapter.INT32.encodedSizeWithTag(2, enumValueDescriptorProto.number) + EnumValueOptions.ADAPTER.encodedSizeWithTag(3, enumValueDescriptorProto.options) + enumValueDescriptorProto.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public EnumValueDescriptorProto redact(EnumValueDescriptorProto enumValueDescriptorProto) {
            Builder newBuilder = enumValueDescriptorProto.newBuilder();
            EnumValueOptions enumValueOptions = newBuilder.options;
            if (enumValueOptions != null) {
                newBuilder.options = EnumValueOptions.ADAPTER.redact(enumValueOptions);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public EnumValueDescriptorProto(String str, Integer num, EnumValueOptions enumValueOptions) {
        this(str, num, enumValueOptions, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnumValueDescriptorProto)) {
            return false;
        }
        EnumValueDescriptorProto enumValueDescriptorProto = (EnumValueDescriptorProto) obj;
        return unknownFields().equals(enumValueDescriptorProto.unknownFields()) && Internal.equals(this.name, enumValueDescriptorProto.name) && Internal.equals(this.number, enumValueDescriptorProto.number) && Internal.equals(this.options, enumValueDescriptorProto.options);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.number;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        EnumValueOptions enumValueOptions = this.options;
        int hashCode4 = hashCode3 + (enumValueOptions != null ? enumValueOptions.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.name != null) {
            sb2.append(", name=");
            sb2.append(this.name);
        }
        if (this.number != null) {
            sb2.append(", number=");
            sb2.append(this.number);
        }
        if (this.options != null) {
            sb2.append(", options=");
            sb2.append(this.options);
        }
        StringBuilder replace = sb2.replace(0, 2, "EnumValueDescriptorProto{");
        replace.append('}');
        return replace.toString();
    }

    public EnumValueDescriptorProto(String str, Integer num, EnumValueOptions enumValueOptions, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.number = num;
        this.options = enumValueOptions;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.number = this.number;
        builder.options = this.options;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

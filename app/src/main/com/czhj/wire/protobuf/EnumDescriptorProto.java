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
import java.util.List;

/* loaded from: classes2.dex */
public final class EnumDescriptorProto extends Message<EnumDescriptorProto, Builder> {
    public static final ProtoAdapter<EnumDescriptorProto> ADAPTER = new ProtoAdapter_EnumDescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.google.protobuf.EnumOptions#ADAPTER", tag = 3)
    public final EnumOptions options;

    @WireField(adapter = "com.google.protobuf.EnumValueDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<EnumValueDescriptorProto> value;

    public static final class Builder extends Message.Builder<EnumDescriptorProto, Builder> {
        public String name;
        public EnumOptions options;
        public List<EnumValueDescriptorProto> value = Internal.newMutableList();

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder options(EnumOptions enumOptions) {
            this.options = enumOptions;
            return this;
        }

        public Builder value(List<EnumValueDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.value = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public EnumDescriptorProto build() {
            return new EnumDescriptorProto(this.name, this.value, this.options, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_EnumDescriptorProto extends ProtoAdapter<EnumDescriptorProto> {
        public ProtoAdapter_EnumDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, EnumDescriptorProto.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public EnumDescriptorProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.value.add(EnumValueDescriptorProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.options(EnumOptions.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, EnumDescriptorProto enumDescriptorProto) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, enumDescriptorProto.name);
            EnumValueDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, enumDescriptorProto.value);
            EnumOptions.ADAPTER.encodeWithTag(protoWriter, 3, enumDescriptorProto.options);
            protoWriter.writeBytes(enumDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(EnumDescriptorProto enumDescriptorProto) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, enumDescriptorProto.name) + EnumValueDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, enumDescriptorProto.value) + EnumOptions.ADAPTER.encodedSizeWithTag(3, enumDescriptorProto.options) + enumDescriptorProto.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public EnumDescriptorProto redact(EnumDescriptorProto enumDescriptorProto) {
            Builder newBuilder = enumDescriptorProto.newBuilder();
            Internal.redactElements(newBuilder.value, EnumValueDescriptorProto.ADAPTER);
            EnumOptions enumOptions = newBuilder.options;
            if (enumOptions != null) {
                newBuilder.options = EnumOptions.ADAPTER.redact(enumOptions);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public EnumDescriptorProto(String str, List<EnumValueDescriptorProto> list, EnumOptions enumOptions) {
        this(str, list, enumOptions, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnumDescriptorProto)) {
            return false;
        }
        EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) obj;
        return unknownFields().equals(enumDescriptorProto.unknownFields()) && Internal.equals(this.name, enumDescriptorProto.name) && this.value.equals(enumDescriptorProto.value) && Internal.equals(this.options, enumDescriptorProto.options);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.value.hashCode()) * 37;
        EnumOptions enumOptions = this.options;
        int hashCode3 = hashCode2 + (enumOptions != null ? enumOptions.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.name != null) {
            sb2.append(", name=");
            sb2.append(this.name);
        }
        if (!this.value.isEmpty()) {
            sb2.append(", value=");
            sb2.append(this.value);
        }
        if (this.options != null) {
            sb2.append(", options=");
            sb2.append(this.options);
        }
        StringBuilder replace = sb2.replace(0, 2, "EnumDescriptorProto{");
        replace.append('}');
        return replace.toString();
    }

    public EnumDescriptorProto(String str, List<EnumValueDescriptorProto> list, EnumOptions enumOptions, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.value = Internal.immutableCopyOf("value", list);
        this.options = enumOptions;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.value = Internal.copyOf("value", this.value);
        builder.options = this.options;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

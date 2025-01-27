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
public final class MethodOptions extends Message<MethodOptions, Builder> {
    public static final ProtoAdapter<MethodOptions> ADAPTER = new ProtoAdapter_MethodOptions();
    public static final Boolean DEFAULT_DEPRECATED = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 33)
    public final Boolean deprecated;

    @WireField(adapter = "com.google.protobuf.UninterpretedOption#ADAPTER", label = WireField.Label.REPEATED, tag = 999)
    public final List<UninterpretedOption> uninterpreted_option;

    public static final class Builder extends Message.Builder<MethodOptions, Builder> {
        public Boolean deprecated;
        public List<UninterpretedOption> uninterpreted_option = Internal.newMutableList();

        public Builder deprecated(Boolean bool) {
            this.deprecated = bool;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> list) {
            Internal.checkElementsNotNull(list);
            this.uninterpreted_option = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public MethodOptions build() {
            return new MethodOptions(this.deprecated, this.uninterpreted_option, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_MethodOptions extends ProtoAdapter<MethodOptions> {
        public ProtoAdapter_MethodOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, MethodOptions.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public MethodOptions decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 33) {
                    builder.deprecated(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 999) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, MethodOptions methodOptions) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 33, methodOptions.deprecated);
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(protoWriter, 999, methodOptions.uninterpreted_option);
            protoWriter.writeBytes(methodOptions.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(MethodOptions methodOptions) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(33, methodOptions.deprecated) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, methodOptions.uninterpreted_option) + methodOptions.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public MethodOptions redact(MethodOptions methodOptions) {
            Builder newBuilder = methodOptions.newBuilder();
            Internal.redactElements(newBuilder.uninterpreted_option, UninterpretedOption.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MethodOptions(Boolean bool, List<UninterpretedOption> list) {
        this(bool, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MethodOptions)) {
            return false;
        }
        MethodOptions methodOptions = (MethodOptions) obj;
        return unknownFields().equals(methodOptions.unknownFields()) && Internal.equals(this.deprecated, methodOptions.deprecated) && this.uninterpreted_option.equals(methodOptions.uninterpreted_option);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.deprecated;
        int hashCode2 = ((hashCode + (bool != null ? bool.hashCode() : 0)) * 37) + this.uninterpreted_option.hashCode();
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.deprecated != null) {
            sb2.append(", deprecated=");
            sb2.append(this.deprecated);
        }
        if (!this.uninterpreted_option.isEmpty()) {
            sb2.append(", uninterpreted_option=");
            sb2.append(this.uninterpreted_option);
        }
        StringBuilder replace = sb2.replace(0, 2, "MethodOptions{");
        replace.append('}');
        return replace.toString();
    }

    public MethodOptions(Boolean bool, List<UninterpretedOption> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.deprecated = bool;
        this.uninterpreted_option = Internal.immutableCopyOf("uninterpreted_option", list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.deprecated = this.deprecated;
        builder.uninterpreted_option = Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

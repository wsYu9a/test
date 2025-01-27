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
public final class DescriptorProto extends Message<DescriptorProto, Builder> {
    public static final ProtoAdapter<DescriptorProto> ADAPTER = new ProtoAdapter_DescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.EnumDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<EnumDescriptorProto> enum_type;

    @WireField(adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<FieldDescriptorProto> extension;

    @WireField(adapter = "com.google.protobuf.DescriptorProto$ExtensionRange#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ExtensionRange> extension_range;

    @WireField(adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<FieldDescriptorProto> field;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.google.protobuf.DescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<DescriptorProto> nested_type;

    @WireField(adapter = "com.google.protobuf.OneofDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 8)
    public final List<OneofDescriptorProto> oneof_decl;

    @WireField(adapter = "com.google.protobuf.MessageOptions#ADAPTER", tag = 7)
    public final MessageOptions options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 10)
    public final List<String> reserved_name;

    @WireField(adapter = "com.google.protobuf.DescriptorProto$ReservedRange#ADAPTER", label = WireField.Label.REPEATED, tag = 9)
    public final List<ReservedRange> reserved_range;

    public static final class Builder extends Message.Builder<DescriptorProto, Builder> {
        public String name;
        public MessageOptions options;
        public List<FieldDescriptorProto> field = Internal.newMutableList();
        public List<FieldDescriptorProto> extension = Internal.newMutableList();
        public List<DescriptorProto> nested_type = Internal.newMutableList();
        public List<EnumDescriptorProto> enum_type = Internal.newMutableList();
        public List<ExtensionRange> extension_range = Internal.newMutableList();
        public List<OneofDescriptorProto> oneof_decl = Internal.newMutableList();
        public List<ReservedRange> reserved_range = Internal.newMutableList();
        public List<String> reserved_name = Internal.newMutableList();

        public Builder enum_type(List<EnumDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.enum_type = list;
            return this;
        }

        public Builder extension(List<FieldDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.extension = list;
            return this;
        }

        public Builder extension_range(List<ExtensionRange> list) {
            Internal.checkElementsNotNull(list);
            this.extension_range = list;
            return this;
        }

        public Builder field(List<FieldDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.field = list;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder nested_type(List<DescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.nested_type = list;
            return this;
        }

        public Builder oneof_decl(List<OneofDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.oneof_decl = list;
            return this;
        }

        public Builder options(MessageOptions messageOptions) {
            this.options = messageOptions;
            return this;
        }

        public Builder reserved_name(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.reserved_name = list;
            return this;
        }

        public Builder reserved_range(List<ReservedRange> list) {
            Internal.checkElementsNotNull(list);
            this.reserved_range = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public DescriptorProto build() {
            return new DescriptorProto(this.name, this.field, this.extension, this.nested_type, this.enum_type, this.extension_range, this.oneof_decl, this.options, this.reserved_range, this.reserved_name, super.buildUnknownFields());
        }
    }

    public static final class ExtensionRange extends Message<ExtensionRange, Builder> {
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
        public final Integer end;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
        public final Integer start;
        public static final ProtoAdapter<ExtensionRange> ADAPTER = new ProtoAdapter_ExtensionRange();
        public static final Integer DEFAULT_START = 0;
        public static final Integer DEFAULT_END = 0;

        public static final class Builder extends Message.Builder<ExtensionRange, Builder> {
            public Integer end;
            public Integer start;

            public Builder end(Integer num) {
                this.end = num;
                return this;
            }

            public Builder start(Integer num) {
                this.start = num;
                return this;
            }

            @Override // com.czhj.wire.Message.Builder
            public ExtensionRange build() {
                return new ExtensionRange(this.start, this.end, super.buildUnknownFields());
            }
        }

        public static final class ProtoAdapter_ExtensionRange extends ProtoAdapter<ExtensionRange> {
            public ProtoAdapter_ExtensionRange() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtensionRange.class);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public ExtensionRange decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.build();
                    }
                    if (nextTag == 1) {
                        builder.start(ProtoAdapter.INT32.decode(protoReader));
                    } else if (nextTag != 2) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.end(ProtoAdapter.INT32.decode(protoReader));
                    }
                }
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, ExtensionRange extensionRange) throws IOException {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                protoAdapter.encodeWithTag(protoWriter, 1, extensionRange.start);
                protoAdapter.encodeWithTag(protoWriter, 2, extensionRange.end);
                protoWriter.writeBytes(extensionRange.unknownFields());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(ExtensionRange extensionRange) {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                return protoAdapter.encodedSizeWithTag(1, extensionRange.start) + protoAdapter.encodedSizeWithTag(2, extensionRange.end) + extensionRange.unknownFields().size();
            }

            @Override // com.czhj.wire.ProtoAdapter
            public ExtensionRange redact(ExtensionRange extensionRange) {
                Builder newBuilder = extensionRange.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        public ExtensionRange(Integer num, Integer num2) {
            this(num, num2, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ExtensionRange)) {
                return false;
            }
            ExtensionRange extensionRange = (ExtensionRange) obj;
            return unknownFields().equals(extensionRange.unknownFields()) && Internal.equals(this.start, extensionRange.start) && Internal.equals(this.end, extensionRange.end);
        }

        public int hashCode() {
            int i10 = this.hashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.start;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.end;
            int hashCode3 = hashCode2 + (num2 != null ? num2.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.czhj.wire.Message
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.start != null) {
                sb2.append(", start=");
                sb2.append(this.start);
            }
            if (this.end != null) {
                sb2.append(", end=");
                sb2.append(this.end);
            }
            StringBuilder replace = sb2.replace(0, 2, "ExtensionRange{");
            replace.append('}');
            return replace.toString();
        }

        public ExtensionRange(Integer num, Integer num2, ByteString byteString) {
            super(ADAPTER, byteString);
            this.start = num;
            this.end = num2;
        }

        @Override // com.czhj.wire.Message
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.start = this.start;
            builder.end = this.end;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    public static final class ProtoAdapter_DescriptorProto extends ProtoAdapter<DescriptorProto> {
        public ProtoAdapter_DescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, DescriptorProto.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public DescriptorProto decode(ProtoReader protoReader) throws IOException {
            List list;
            Object obj;
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 1:
                        builder.name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        list = builder.field;
                        obj = (FieldDescriptorProto) FieldDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 3:
                        list = builder.nested_type;
                        obj = (DescriptorProto) DescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 4:
                        list = builder.enum_type;
                        obj = (EnumDescriptorProto) EnumDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 5:
                        list = builder.extension_range;
                        obj = (ExtensionRange) ExtensionRange.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 6:
                        list = builder.extension;
                        obj = (FieldDescriptorProto) FieldDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 7:
                        builder.options(MessageOptions.ADAPTER.decode(protoReader));
                        break;
                    case 8:
                        list = builder.oneof_decl;
                        obj = (OneofDescriptorProto) OneofDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 9:
                        list = builder.reserved_range;
                        obj = (ReservedRange) ReservedRange.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 10:
                        list = builder.reserved_name;
                        obj = (String) ProtoAdapter.STRING.decode(protoReader);
                        list.add(obj);
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, DescriptorProto descriptorProto) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, descriptorProto.name);
            ProtoAdapter<FieldDescriptorProto> protoAdapter2 = FieldDescriptorProto.ADAPTER;
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 2, descriptorProto.field);
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 6, descriptorProto.extension);
            DescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, descriptorProto.nested_type);
            EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, descriptorProto.enum_type);
            ExtensionRange.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, descriptorProto.extension_range);
            OneofDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 8, descriptorProto.oneof_decl);
            MessageOptions.ADAPTER.encodeWithTag(protoWriter, 7, descriptorProto.options);
            ReservedRange.ADAPTER.asRepeated().encodeWithTag(protoWriter, 9, descriptorProto.reserved_range);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 10, descriptorProto.reserved_name);
            protoWriter.writeBytes(descriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(DescriptorProto descriptorProto) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, descriptorProto.name);
            ProtoAdapter<FieldDescriptorProto> protoAdapter2 = FieldDescriptorProto.ADAPTER;
            return encodedSizeWithTag + protoAdapter2.asRepeated().encodedSizeWithTag(2, descriptorProto.field) + protoAdapter2.asRepeated().encodedSizeWithTag(6, descriptorProto.extension) + DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(3, descriptorProto.nested_type) + EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, descriptorProto.enum_type) + ExtensionRange.ADAPTER.asRepeated().encodedSizeWithTag(5, descriptorProto.extension_range) + OneofDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(8, descriptorProto.oneof_decl) + MessageOptions.ADAPTER.encodedSizeWithTag(7, descriptorProto.options) + ReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(9, descriptorProto.reserved_range) + protoAdapter.asRepeated().encodedSizeWithTag(10, descriptorProto.reserved_name) + descriptorProto.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public DescriptorProto redact(DescriptorProto descriptorProto) {
            Builder newBuilder = descriptorProto.newBuilder();
            List<FieldDescriptorProto> list = newBuilder.field;
            ProtoAdapter<FieldDescriptorProto> protoAdapter = FieldDescriptorProto.ADAPTER;
            Internal.redactElements(list, protoAdapter);
            Internal.redactElements(newBuilder.extension, protoAdapter);
            Internal.redactElements(newBuilder.nested_type, DescriptorProto.ADAPTER);
            Internal.redactElements(newBuilder.enum_type, EnumDescriptorProto.ADAPTER);
            Internal.redactElements(newBuilder.extension_range, ExtensionRange.ADAPTER);
            Internal.redactElements(newBuilder.oneof_decl, OneofDescriptorProto.ADAPTER);
            MessageOptions messageOptions = newBuilder.options;
            if (messageOptions != null) {
                newBuilder.options = MessageOptions.ADAPTER.redact(messageOptions);
            }
            Internal.redactElements(newBuilder.reserved_range, ReservedRange.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public static final class ReservedRange extends Message<ReservedRange, Builder> {
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
        public final Integer end;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
        public final Integer start;
        public static final ProtoAdapter<ReservedRange> ADAPTER = new ProtoAdapter_ReservedRange();
        public static final Integer DEFAULT_START = 0;
        public static final Integer DEFAULT_END = 0;

        public static final class Builder extends Message.Builder<ReservedRange, Builder> {
            public Integer end;
            public Integer start;

            public Builder end(Integer num) {
                this.end = num;
                return this;
            }

            public Builder start(Integer num) {
                this.start = num;
                return this;
            }

            @Override // com.czhj.wire.Message.Builder
            public ReservedRange build() {
                return new ReservedRange(this.start, this.end, super.buildUnknownFields());
            }
        }

        public static final class ProtoAdapter_ReservedRange extends ProtoAdapter<ReservedRange> {
            public ProtoAdapter_ReservedRange() {
                super(FieldEncoding.LENGTH_DELIMITED, ReservedRange.class);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public ReservedRange decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.build();
                    }
                    if (nextTag == 1) {
                        builder.start(ProtoAdapter.INT32.decode(protoReader));
                    } else if (nextTag != 2) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.end(ProtoAdapter.INT32.decode(protoReader));
                    }
                }
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, ReservedRange reservedRange) throws IOException {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                protoAdapter.encodeWithTag(protoWriter, 1, reservedRange.start);
                protoAdapter.encodeWithTag(protoWriter, 2, reservedRange.end);
                protoWriter.writeBytes(reservedRange.unknownFields());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(ReservedRange reservedRange) {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                return protoAdapter.encodedSizeWithTag(1, reservedRange.start) + protoAdapter.encodedSizeWithTag(2, reservedRange.end) + reservedRange.unknownFields().size();
            }

            @Override // com.czhj.wire.ProtoAdapter
            public ReservedRange redact(ReservedRange reservedRange) {
                Builder newBuilder = reservedRange.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        public ReservedRange(Integer num, Integer num2) {
            this(num, num2, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ReservedRange)) {
                return false;
            }
            ReservedRange reservedRange = (ReservedRange) obj;
            return unknownFields().equals(reservedRange.unknownFields()) && Internal.equals(this.start, reservedRange.start) && Internal.equals(this.end, reservedRange.end);
        }

        public int hashCode() {
            int i10 = this.hashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.start;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.end;
            int hashCode3 = hashCode2 + (num2 != null ? num2.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.czhj.wire.Message
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.start != null) {
                sb2.append(", start=");
                sb2.append(this.start);
            }
            if (this.end != null) {
                sb2.append(", end=");
                sb2.append(this.end);
            }
            StringBuilder replace = sb2.replace(0, 2, "ReservedRange{");
            replace.append('}');
            return replace.toString();
        }

        public ReservedRange(Integer num, Integer num2, ByteString byteString) {
            super(ADAPTER, byteString);
            this.start = num;
            this.end = num2;
        }

        @Override // com.czhj.wire.Message
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.start = this.start;
            builder.end = this.end;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    public DescriptorProto(String str, List<FieldDescriptorProto> list, List<FieldDescriptorProto> list2, List<DescriptorProto> list3, List<EnumDescriptorProto> list4, List<ExtensionRange> list5, List<OneofDescriptorProto> list6, MessageOptions messageOptions, List<ReservedRange> list7, List<String> list8) {
        this(str, list, list2, list3, list4, list5, list6, messageOptions, list7, list8, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DescriptorProto)) {
            return false;
        }
        DescriptorProto descriptorProto = (DescriptorProto) obj;
        return unknownFields().equals(descriptorProto.unknownFields()) && Internal.equals(this.name, descriptorProto.name) && this.field.equals(descriptorProto.field) && this.extension.equals(descriptorProto.extension) && this.nested_type.equals(descriptorProto.nested_type) && this.enum_type.equals(descriptorProto.enum_type) && this.extension_range.equals(descriptorProto.extension_range) && this.oneof_decl.equals(descriptorProto.oneof_decl) && Internal.equals(this.options, descriptorProto.options) && this.reserved_range.equals(descriptorProto.reserved_range) && this.reserved_name.equals(descriptorProto.reserved_name);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int hashCode2 = (((((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.field.hashCode()) * 37) + this.extension.hashCode()) * 37) + this.nested_type.hashCode()) * 37) + this.enum_type.hashCode()) * 37) + this.extension_range.hashCode()) * 37) + this.oneof_decl.hashCode()) * 37;
        MessageOptions messageOptions = this.options;
        int hashCode3 = ((((hashCode2 + (messageOptions != null ? messageOptions.hashCode() : 0)) * 37) + this.reserved_range.hashCode()) * 37) + this.reserved_name.hashCode();
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
        if (!this.field.isEmpty()) {
            sb2.append(", field=");
            sb2.append(this.field);
        }
        if (!this.extension.isEmpty()) {
            sb2.append(", extension=");
            sb2.append(this.extension);
        }
        if (!this.nested_type.isEmpty()) {
            sb2.append(", nested_type=");
            sb2.append(this.nested_type);
        }
        if (!this.enum_type.isEmpty()) {
            sb2.append(", enum_type=");
            sb2.append(this.enum_type);
        }
        if (!this.extension_range.isEmpty()) {
            sb2.append(", extension_range=");
            sb2.append(this.extension_range);
        }
        if (!this.oneof_decl.isEmpty()) {
            sb2.append(", oneof_decl=");
            sb2.append(this.oneof_decl);
        }
        if (this.options != null) {
            sb2.append(", options=");
            sb2.append(this.options);
        }
        if (!this.reserved_range.isEmpty()) {
            sb2.append(", reserved_range=");
            sb2.append(this.reserved_range);
        }
        if (!this.reserved_name.isEmpty()) {
            sb2.append(", reserved_name=");
            sb2.append(this.reserved_name);
        }
        StringBuilder replace = sb2.replace(0, 2, "DescriptorProto{");
        replace.append('}');
        return replace.toString();
    }

    public DescriptorProto(String str, List<FieldDescriptorProto> list, List<FieldDescriptorProto> list2, List<DescriptorProto> list3, List<EnumDescriptorProto> list4, List<ExtensionRange> list5, List<OneofDescriptorProto> list6, MessageOptions messageOptions, List<ReservedRange> list7, List<String> list8, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.field = Internal.immutableCopyOf("field", list);
        this.extension = Internal.immutableCopyOf("extension", list2);
        this.nested_type = Internal.immutableCopyOf("nested_type", list3);
        this.enum_type = Internal.immutableCopyOf("enum_type", list4);
        this.extension_range = Internal.immutableCopyOf("extension_range", list5);
        this.oneof_decl = Internal.immutableCopyOf("oneof_decl", list6);
        this.options = messageOptions;
        this.reserved_range = Internal.immutableCopyOf("reserved_range", list7);
        this.reserved_name = Internal.immutableCopyOf("reserved_name", list8);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.field = Internal.copyOf("field", this.field);
        builder.extension = Internal.copyOf("extension", this.extension);
        builder.nested_type = Internal.copyOf("nested_type", this.nested_type);
        builder.enum_type = Internal.copyOf("enum_type", this.enum_type);
        builder.extension_range = Internal.copyOf("extension_range", this.extension_range);
        builder.oneof_decl = Internal.copyOf("oneof_decl", this.oneof_decl);
        builder.options = this.options;
        builder.reserved_range = Internal.copyOf("reserved_range", this.reserved_range);
        builder.reserved_name = Internal.copyOf("reserved_name", this.reserved_name);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

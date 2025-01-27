package com.czhj.wire.protobuf;

import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import h3.e;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public final class ServiceDescriptorProto extends Message<ServiceDescriptorProto, Builder> {
    public static final ProtoAdapter<ServiceDescriptorProto> ADAPTER = new ProtoAdapter_ServiceDescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.MethodDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<MethodDescriptorProto> method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.google.protobuf.ServiceOptions#ADAPTER", tag = 3)
    public final ServiceOptions options;

    public static final class Builder extends Message.Builder<ServiceDescriptorProto, Builder> {
        public List<MethodDescriptorProto> method = Internal.newMutableList();
        public String name;
        public ServiceOptions options;

        public Builder method(List<MethodDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.method = list;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder options(ServiceOptions serviceOptions) {
            this.options = serviceOptions;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public ServiceDescriptorProto build() {
            return new ServiceDescriptorProto(this.name, this.method, this.options, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ServiceDescriptorProto extends ProtoAdapter<ServiceDescriptorProto> {
        public ProtoAdapter_ServiceDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, ServiceDescriptorProto.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ServiceDescriptorProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.method.add(MethodDescriptorProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.options(ServiceOptions.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ServiceDescriptorProto serviceDescriptorProto) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, serviceDescriptorProto.name);
            MethodDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, serviceDescriptorProto.method);
            ServiceOptions.ADAPTER.encodeWithTag(protoWriter, 3, serviceDescriptorProto.options);
            protoWriter.writeBytes(serviceDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ServiceDescriptorProto serviceDescriptorProto) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, serviceDescriptorProto.name) + MethodDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, serviceDescriptorProto.method) + ServiceOptions.ADAPTER.encodedSizeWithTag(3, serviceDescriptorProto.options) + serviceDescriptorProto.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ServiceDescriptorProto redact(ServiceDescriptorProto serviceDescriptorProto) {
            Builder newBuilder = serviceDescriptorProto.newBuilder();
            Internal.redactElements(newBuilder.method, MethodDescriptorProto.ADAPTER);
            ServiceOptions serviceOptions = newBuilder.options;
            if (serviceOptions != null) {
                newBuilder.options = ServiceOptions.ADAPTER.redact(serviceOptions);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ServiceDescriptorProto(String str, List<MethodDescriptorProto> list, ServiceOptions serviceOptions) {
        this(str, list, serviceOptions, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServiceDescriptorProto)) {
            return false;
        }
        ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) obj;
        return unknownFields().equals(serviceDescriptorProto.unknownFields()) && Internal.equals(this.name, serviceDescriptorProto.name) && this.method.equals(serviceDescriptorProto.method) && Internal.equals(this.options, serviceDescriptorProto.options);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.method.hashCode()) * 37;
        ServiceOptions serviceOptions = this.options;
        int hashCode3 = hashCode2 + (serviceOptions != null ? serviceOptions.hashCode() : 0);
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
        if (!this.method.isEmpty()) {
            sb2.append(", method=");
            sb2.append(this.method);
        }
        if (this.options != null) {
            sb2.append(", options=");
            sb2.append(this.options);
        }
        StringBuilder replace = sb2.replace(0, 2, "ServiceDescriptorProto{");
        replace.append('}');
        return replace.toString();
    }

    public ServiceDescriptorProto(String str, List<MethodDescriptorProto> list, ServiceOptions serviceOptions, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.method = Internal.immutableCopyOf(e.f26414s, list);
        this.options = serviceOptions;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.method = Internal.copyOf(e.f26414s, this.method);
        builder.options = this.options;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

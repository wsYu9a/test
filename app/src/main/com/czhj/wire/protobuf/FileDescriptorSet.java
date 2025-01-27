package com.czhj.wire.protobuf;

import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.k;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public final class FileDescriptorSet extends Message<FileDescriptorSet, Builder> {
    public static final ProtoAdapter<FileDescriptorSet> ADAPTER = new ProtoAdapter_FileDescriptorSet();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.FileDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<FileDescriptorProto> file;

    public static final class Builder extends Message.Builder<FileDescriptorSet, Builder> {
        public List<FileDescriptorProto> file = Internal.newMutableList();

        public Builder file(List<FileDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.file = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public FileDescriptorSet build() {
            return new FileDescriptorSet(this.file, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_FileDescriptorSet extends ProtoAdapter<FileDescriptorSet> {
        public ProtoAdapter_FileDescriptorSet() {
            super(FieldEncoding.LENGTH_DELIMITED, FileDescriptorSet.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FileDescriptorSet decode(ProtoReader protoReader) throws IOException {
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
                    builder.file.add(FileDescriptorProto.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, FileDescriptorSet fileDescriptorSet) throws IOException {
            FileDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, fileDescriptorSet.file);
            protoWriter.writeBytes(fileDescriptorSet.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(FileDescriptorSet fileDescriptorSet) {
            return FileDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(1, fileDescriptorSet.file) + fileDescriptorSet.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FileDescriptorSet redact(FileDescriptorSet fileDescriptorSet) {
            Builder newBuilder = fileDescriptorSet.newBuilder();
            Internal.redactElements(newBuilder.file, FileDescriptorProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public FileDescriptorSet(List<FileDescriptorProto> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileDescriptorSet)) {
            return false;
        }
        FileDescriptorSet fileDescriptorSet = (FileDescriptorSet) obj;
        return unknownFields().equals(fileDescriptorSet.unknownFields()) && this.file.equals(fileDescriptorSet.file);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = (unknownFields().hashCode() * 37) + this.file.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.file.isEmpty()) {
            sb2.append(", file=");
            sb2.append(this.file);
        }
        StringBuilder replace = sb2.replace(0, 2, "FileDescriptorSet{");
        replace.append('}');
        return replace.toString();
    }

    public FileDescriptorSet(List<FileDescriptorProto> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.file = Internal.immutableCopyOf(k.f18193y, list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.file = Internal.copyOf(k.f18193y, this.file);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

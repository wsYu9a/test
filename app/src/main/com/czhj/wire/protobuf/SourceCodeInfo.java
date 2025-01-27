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
import t8.a;

/* loaded from: classes2.dex */
public final class SourceCodeInfo extends Message<SourceCodeInfo, Builder> {
    public static final ProtoAdapter<SourceCodeInfo> ADAPTER = new ProtoAdapter_SourceCodeInfo();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.SourceCodeInfo$Location#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Location> location;

    public static final class Builder extends Message.Builder<SourceCodeInfo, Builder> {
        public List<Location> location = Internal.newMutableList();

        public Builder location(List<Location> list) {
            Internal.checkElementsNotNull(list);
            this.location = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SourceCodeInfo build() {
            return new SourceCodeInfo(this.location, super.buildUnknownFields());
        }
    }

    public static final class Location extends Message<Location, Builder> {
        public static final ProtoAdapter<Location> ADAPTER = new ProtoAdapter_Location();
        public static final String DEFAULT_LEADING_COMMENTS = "";
        public static final String DEFAULT_TRAILING_COMMENTS = "";
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
        public final String leading_comments;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 6)
        public final List<String> leading_detached_comments;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.PACKED, tag = 1)
        public final List<Integer> path;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.PACKED, tag = 2)
        public final List<Integer> span;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
        public final String trailing_comments;

        public static final class Builder extends Message.Builder<Location, Builder> {
            public String leading_comments;
            public String trailing_comments;
            public List<Integer> path = Internal.newMutableList();
            public List<Integer> span = Internal.newMutableList();
            public List<String> leading_detached_comments = Internal.newMutableList();

            public Builder leading_comments(String str) {
                this.leading_comments = str;
                return this;
            }

            public Builder leading_detached_comments(List<String> list) {
                Internal.checkElementsNotNull(list);
                this.leading_detached_comments = list;
                return this;
            }

            public Builder path(List<Integer> list) {
                Internal.checkElementsNotNull(list);
                this.path = list;
                return this;
            }

            public Builder span(List<Integer> list) {
                Internal.checkElementsNotNull(list);
                this.span = list;
                return this;
            }

            public Builder trailing_comments(String str) {
                this.trailing_comments = str;
                return this;
            }

            @Override // com.czhj.wire.Message.Builder
            public Location build() {
                return new Location(this.path, this.span, this.leading_comments, this.trailing_comments, this.leading_detached_comments, super.buildUnknownFields());
            }
        }

        public static final class ProtoAdapter_Location extends ProtoAdapter<Location> {
            public ProtoAdapter_Location() {
                super(FieldEncoding.LENGTH_DELIMITED, Location.class);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Location decode(ProtoReader protoReader) throws IOException {
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
                    if (nextTag == 1) {
                        list = builder.path;
                    } else if (nextTag == 2) {
                        list = builder.span;
                    } else if (nextTag == 3) {
                        builder.leading_comments(ProtoAdapter.STRING.decode(protoReader));
                    } else if (nextTag == 4) {
                        builder.trailing_comments(ProtoAdapter.STRING.decode(protoReader));
                    } else if (nextTag != 6) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        list = builder.leading_detached_comments;
                        obj = (String) ProtoAdapter.STRING.decode(protoReader);
                        list.add(obj);
                    }
                    obj = (Integer) ProtoAdapter.INT32.decode(protoReader);
                    list.add(obj);
                }
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Location location) throws IOException {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                protoAdapter.asPacked().encodeWithTag(protoWriter, 1, location.path);
                protoAdapter.asPacked().encodeWithTag(protoWriter, 2, location.span);
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(protoWriter, 3, location.leading_comments);
                protoAdapter2.encodeWithTag(protoWriter, 4, location.trailing_comments);
                protoAdapter2.asRepeated().encodeWithTag(protoWriter, 6, location.leading_detached_comments);
                protoWriter.writeBytes(location.unknownFields());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Location location) {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter.asPacked().encodedSizeWithTag(1, location.path) + protoAdapter.asPacked().encodedSizeWithTag(2, location.span);
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(3, location.leading_comments) + protoAdapter2.encodedSizeWithTag(4, location.trailing_comments) + protoAdapter2.asRepeated().encodedSizeWithTag(6, location.leading_detached_comments) + location.unknownFields().size();
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Location redact(Location location) {
                Builder newBuilder = location.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        public Location(List<Integer> list, List<Integer> list2, String str, String str2, List<String> list3) {
            this(list, list2, str, str2, list3, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Location)) {
                return false;
            }
            Location location = (Location) obj;
            return unknownFields().equals(location.unknownFields()) && this.path.equals(location.path) && this.span.equals(location.span) && Internal.equals(this.leading_comments, location.leading_comments) && Internal.equals(this.trailing_comments, location.trailing_comments) && this.leading_detached_comments.equals(location.leading_detached_comments);
        }

        public int hashCode() {
            int i10 = this.hashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((unknownFields().hashCode() * 37) + this.path.hashCode()) * 37) + this.span.hashCode()) * 37;
            String str = this.leading_comments;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.trailing_comments;
            int hashCode3 = ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.leading_detached_comments.hashCode();
            this.hashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.czhj.wire.Message
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (!this.path.isEmpty()) {
                sb2.append(", path=");
                sb2.append(this.path);
            }
            if (!this.span.isEmpty()) {
                sb2.append(", span=");
                sb2.append(this.span);
            }
            if (this.leading_comments != null) {
                sb2.append(", leading_comments=");
                sb2.append(this.leading_comments);
            }
            if (this.trailing_comments != null) {
                sb2.append(", trailing_comments=");
                sb2.append(this.trailing_comments);
            }
            if (!this.leading_detached_comments.isEmpty()) {
                sb2.append(", leading_detached_comments=");
                sb2.append(this.leading_detached_comments);
            }
            StringBuilder replace = sb2.replace(0, 2, "Location{");
            replace.append('}');
            return replace.toString();
        }

        public Location(List<Integer> list, List<Integer> list2, String str, String str2, List<String> list3, ByteString byteString) {
            super(ADAPTER, byteString);
            this.path = Internal.immutableCopyOf(a.f30751f, list);
            this.span = Internal.immutableCopyOf("span", list2);
            this.leading_comments = str;
            this.trailing_comments = str2;
            this.leading_detached_comments = Internal.immutableCopyOf("leading_detached_comments", list3);
        }

        @Override // com.czhj.wire.Message
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.path = Internal.copyOf(a.f30751f, this.path);
            builder.span = Internal.copyOf("span", this.span);
            builder.leading_comments = this.leading_comments;
            builder.trailing_comments = this.trailing_comments;
            builder.leading_detached_comments = Internal.copyOf("leading_detached_comments", this.leading_detached_comments);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    public static final class ProtoAdapter_SourceCodeInfo extends ProtoAdapter<SourceCodeInfo> {
        public ProtoAdapter_SourceCodeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SourceCodeInfo.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SourceCodeInfo decode(ProtoReader protoReader) throws IOException {
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
                    builder.location.add(Location.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SourceCodeInfo sourceCodeInfo) throws IOException {
            Location.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, sourceCodeInfo.location);
            protoWriter.writeBytes(sourceCodeInfo.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SourceCodeInfo sourceCodeInfo) {
            return Location.ADAPTER.asRepeated().encodedSizeWithTag(1, sourceCodeInfo.location) + sourceCodeInfo.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SourceCodeInfo redact(SourceCodeInfo sourceCodeInfo) {
            Builder newBuilder = sourceCodeInfo.newBuilder();
            Internal.redactElements(newBuilder.location, Location.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SourceCodeInfo(List<Location> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SourceCodeInfo)) {
            return false;
        }
        SourceCodeInfo sourceCodeInfo = (SourceCodeInfo) obj;
        return unknownFields().equals(sourceCodeInfo.unknownFields()) && this.location.equals(sourceCodeInfo.location);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = (unknownFields().hashCode() * 37) + this.location.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.location.isEmpty()) {
            sb2.append(", location=");
            sb2.append(this.location);
        }
        StringBuilder replace = sb2.replace(0, 2, "SourceCodeInfo{");
        replace.append('}');
        return replace.toString();
    }

    public SourceCodeInfo(List<Location> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.location = Internal.immutableCopyOf("location", list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.location = Internal.copyOf("location", this.location);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

package com.sigmob.sdk.base.models;

import android.os.Parcelable;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class WebEvent extends AndroidMessage<WebEvent, Builder> {
    public static final ProtoAdapter<WebEvent> ADAPTER;
    public static final Parcelable.Creator<WebEvent> CREATOR;
    public static final String DEFAULT_EVENT_NAME = "";
    public static final String DEFAULT_EVENT_TYPE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String event_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String event_type;

    public static final class Builder extends Message.Builder<WebEvent, Builder> {
        public String event_type = "";
        public String event_name = "";

        public Builder event_name(String str) {
            this.event_name = str;
            return this;
        }

        public Builder event_type(String str) {
            this.event_type = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public WebEvent build() {
            return new WebEvent(this.event_type, this.event_name, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_WebEvent extends ProtoAdapter<WebEvent> {
        public ProtoAdapter_WebEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, WebEvent.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public WebEvent decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.event_type(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.event_name(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, WebEvent webEvent) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, webEvent.event_type);
            protoAdapter.encodeWithTag(protoWriter, 2, webEvent.event_name);
            protoWriter.writeBytes(webEvent.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(WebEvent webEvent) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, webEvent.event_type) + protoAdapter.encodedSizeWithTag(2, webEvent.event_name) + webEvent.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public WebEvent redact(WebEvent webEvent) {
            Builder newBuilder = webEvent.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_WebEvent protoAdapter_WebEvent = new ProtoAdapter_WebEvent();
        ADAPTER = protoAdapter_WebEvent;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WebEvent);
    }

    public WebEvent(String str, String str2) {
        this(str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebEvent)) {
            return false;
        }
        WebEvent webEvent = (WebEvent) obj;
        return unknownFields().equals(webEvent.unknownFields()) && Internal.equals(this.event_type, webEvent.event_type) && Internal.equals(this.event_name, webEvent.event_name);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.event_type;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.event_name;
        int hashCode3 = hashCode2 + (str2 != null ? str2.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.event_type != null) {
            sb2.append(", event_type=");
            sb2.append(this.event_type);
        }
        if (this.event_name != null) {
            sb2.append(", event_name=");
            sb2.append(this.event_name);
        }
        StringBuilder replace = sb2.replace(0, 2, "WebEvent{");
        replace.append('}');
        return replace.toString();
    }

    public WebEvent(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.event_type = str;
        this.event_name = str2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.event_type = this.event_type;
        builder.event_name = this.event_name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

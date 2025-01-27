package com.sigmob.sdk.base.models.rtb;

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
public final class Widget extends AndroidMessage<Widget, Builder> {
    public static final ProtoAdapter<Widget> ADAPTER;
    public static final Parcelable.Creator<Widget> CREATOR;
    public static final Long DEFAULT_WIDGET_ID;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 1)
    public final Long widget_id;

    public static final class Builder extends Message.Builder<Widget, Builder> {
        public Long widget_id = Widget.DEFAULT_WIDGET_ID;

        public Builder widget_id(Long l10) {
            this.widget_id = l10;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Widget build() {
            return new Widget(this.widget_id, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Widget extends ProtoAdapter<Widget> {
        public ProtoAdapter_Widget() {
            super(FieldEncoding.LENGTH_DELIMITED, Widget.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Widget decode(ProtoReader protoReader) throws IOException {
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
                    builder.widget_id(ProtoAdapter.UINT64.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Widget widget) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 1, widget.widget_id);
            protoWriter.writeBytes(widget.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Widget widget) {
            return ProtoAdapter.UINT64.encodedSizeWithTag(1, widget.widget_id) + widget.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Widget redact(Widget widget) {
            Builder newBuilder = widget.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Widget protoAdapter_Widget = new ProtoAdapter_Widget();
        ADAPTER = protoAdapter_Widget;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Widget);
        DEFAULT_WIDGET_ID = 0L;
    }

    public Widget(Long l10) {
        this(l10, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Widget)) {
            return false;
        }
        Widget widget = (Widget) obj;
        return unknownFields().equals(widget.unknownFields()) && Internal.equals(this.widget_id, widget.widget_id);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Long l10 = this.widget_id;
        int hashCode2 = hashCode + (l10 != null ? l10.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.widget_id != null) {
            sb2.append(", widget_id=");
            sb2.append(this.widget_id);
        }
        StringBuilder replace = sb2.replace(0, 2, "Widget{");
        replace.append('}');
        return replace.toString();
    }

    public Widget(Long l10, ByteString byteString) {
        super(ADAPTER, byteString);
        this.widget_id = l10;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.widget_id = this.widget_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

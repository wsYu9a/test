package com.czhj.sdk.common.models;

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
import java.util.Map;

/* loaded from: classes2.dex */
public final class HeaderBidding extends AndroidMessage<HeaderBidding, Builder> {
    public static final ProtoAdapter<HeaderBidding> ADAPTER;
    public static final Parcelable.Creator<HeaderBidding> CREATOR;
    public static final String DEFAULT_BID_TOKEN = "";
    public static final Integer DEFAULT_CHANNEL_ID;
    public static final String DEFAULT_CUR = "";
    public static final String DEFAULT_P_ID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String bid_token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer channel_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String cur;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String p_id;

    public static final class Builder extends Message.Builder<HeaderBidding, Builder> {
        public String bid_token = "";
        public Integer channel_id = HeaderBidding.DEFAULT_CHANNEL_ID;
        public String p_id = "";
        public String cur = "";
        public Map<String, String> options = Internal.newMutableMap();

        public Builder bid_token(String str) {
            this.bid_token = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public HeaderBidding build() {
            return new HeaderBidding(this.bid_token, this.channel_id, this.options, this.p_id, this.cur, super.buildUnknownFields());
        }

        public Builder channel_id(Integer num) {
            this.channel_id = num;
            return this;
        }

        public Builder cur(String str) {
            this.cur = str;
            return this;
        }

        public Builder options(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.options = map;
            return this;
        }

        public Builder p_id(String str) {
            this.p_id = str;
            return this;
        }
    }

    public static final class ProtoAdapter_HeaderBidding extends ProtoAdapter<HeaderBidding> {
        private final ProtoAdapter<Map<String, String>> options;

        public ProtoAdapter_HeaderBidding() {
            super(FieldEncoding.LENGTH_DELIMITED, HeaderBidding.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.options = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public HeaderBidding decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.bid_token(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.channel_id(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.options.putAll(this.options.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.p_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.cur(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, HeaderBidding headerBidding) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, headerBidding.bid_token);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, headerBidding.channel_id);
            this.options.encodeWithTag(protoWriter, 3, headerBidding.options);
            protoAdapter.encodeWithTag(protoWriter, 4, headerBidding.p_id);
            protoAdapter.encodeWithTag(protoWriter, 5, headerBidding.cur);
            protoWriter.writeBytes(headerBidding.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(HeaderBidding headerBidding) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, headerBidding.bid_token) + ProtoAdapter.UINT32.encodedSizeWithTag(2, headerBidding.channel_id) + this.options.encodedSizeWithTag(3, headerBidding.options) + protoAdapter.encodedSizeWithTag(4, headerBidding.p_id) + protoAdapter.encodedSizeWithTag(5, headerBidding.cur) + headerBidding.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public HeaderBidding redact(HeaderBidding headerBidding) {
            Builder newBuilder = headerBidding.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_HeaderBidding protoAdapter_HeaderBidding = new ProtoAdapter_HeaderBidding();
        ADAPTER = protoAdapter_HeaderBidding;
        CREATOR = AndroidMessage.newCreator(protoAdapter_HeaderBidding);
        DEFAULT_CHANNEL_ID = 0;
    }

    public HeaderBidding(String str, Integer num, Map<String, String> map, String str2, String str3) {
        this(str, num, map, str2, str3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeaderBidding)) {
            return false;
        }
        HeaderBidding headerBidding = (HeaderBidding) obj;
        return unknownFields().equals(headerBidding.unknownFields()) && Internal.equals(this.bid_token, headerBidding.bid_token) && Internal.equals(this.channel_id, headerBidding.channel_id) && this.options.equals(headerBidding.options) && Internal.equals(this.p_id, headerBidding.p_id) && Internal.equals(this.cur, headerBidding.cur);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.bid_token;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.channel_id;
        int hashCode3 = (((hashCode2 + (num != null ? num.hashCode() : 0)) * 37) + this.options.hashCode()) * 37;
        String str2 = this.p_id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cur;
        int hashCode5 = hashCode4 + (str3 != null ? str3.hashCode() : 0);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.bid_token = this.bid_token;
        builder.channel_id = this.channel_id;
        builder.options = Internal.copyOf("options", this.options);
        builder.p_id = this.p_id;
        builder.cur = this.cur;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.bid_token != null) {
            sb2.append(", bid_token=");
            sb2.append(this.bid_token);
        }
        if (this.channel_id != null) {
            sb2.append(", channel_id=");
            sb2.append(this.channel_id);
        }
        if (!this.options.isEmpty()) {
            sb2.append(", options=");
            sb2.append(this.options);
        }
        if (this.p_id != null) {
            sb2.append(", p_id=");
            sb2.append(this.p_id);
        }
        if (this.cur != null) {
            sb2.append(", cur=");
            sb2.append(this.cur);
        }
        StringBuilder replace = sb2.replace(0, 2, "HeaderBidding{");
        replace.append('}');
        return replace.toString();
    }

    public HeaderBidding(String str, Integer num, Map<String, String> map, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.bid_token = str;
        this.channel_id = num;
        this.options = Internal.immutableCopyOf("options", map);
        this.p_id = str2;
        this.cur = str3;
    }
}

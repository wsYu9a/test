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
public final class BiddingResponse extends AndroidMessage<BiddingResponse, Builder> {
    public static final ProtoAdapter<BiddingResponse> ADAPTER;
    public static final Parcelable.Creator<BiddingResponse> CREATOR;
    public static final Integer DEFAULT_ECPM;
    public static final String DEFAULT_LOSE_URL = "";
    public static final String DEFAULT_WIN_URL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer ecpm;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String lose_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String win_url;

    public static final class Builder extends Message.Builder<BiddingResponse, Builder> {
        public String win_url = "";
        public String lose_url = "";
        public Integer ecpm = BiddingResponse.DEFAULT_ECPM;

        public Builder ecpm(Integer num) {
            this.ecpm = num;
            return this;
        }

        public Builder lose_url(String str) {
            this.lose_url = str;
            return this;
        }

        public Builder win_url(String str) {
            this.win_url = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public BiddingResponse build() {
            return new BiddingResponse(this.win_url, this.lose_url, this.ecpm, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_BiddingResponse extends ProtoAdapter<BiddingResponse> {
        public ProtoAdapter_BiddingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BiddingResponse.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public BiddingResponse decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.win_url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.lose_url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.ecpm(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, BiddingResponse biddingResponse) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, biddingResponse.win_url);
            protoAdapter.encodeWithTag(protoWriter, 2, biddingResponse.lose_url);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, biddingResponse.ecpm);
            protoWriter.writeBytes(biddingResponse.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(BiddingResponse biddingResponse) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, biddingResponse.win_url) + protoAdapter.encodedSizeWithTag(2, biddingResponse.lose_url) + ProtoAdapter.UINT32.encodedSizeWithTag(3, biddingResponse.ecpm) + biddingResponse.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public BiddingResponse redact(BiddingResponse biddingResponse) {
            Builder newBuilder = biddingResponse.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_BiddingResponse protoAdapter_BiddingResponse = new ProtoAdapter_BiddingResponse();
        ADAPTER = protoAdapter_BiddingResponse;
        CREATOR = AndroidMessage.newCreator(protoAdapter_BiddingResponse);
        DEFAULT_ECPM = 0;
    }

    public BiddingResponse(String str, String str2, Integer num) {
        this(str, str2, num, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BiddingResponse)) {
            return false;
        }
        BiddingResponse biddingResponse = (BiddingResponse) obj;
        return unknownFields().equals(biddingResponse.unknownFields()) && Internal.equals(this.win_url, biddingResponse.win_url) && Internal.equals(this.lose_url, biddingResponse.lose_url) && Internal.equals(this.ecpm, biddingResponse.ecpm);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.win_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.lose_url;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.ecpm;
        int hashCode4 = hashCode3 + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.win_url != null) {
            sb2.append(", win_url=");
            sb2.append(this.win_url);
        }
        if (this.lose_url != null) {
            sb2.append(", lose_url=");
            sb2.append(this.lose_url);
        }
        if (this.ecpm != null) {
            sb2.append(", ecpm=");
            sb2.append(this.ecpm);
        }
        StringBuilder replace = sb2.replace(0, 2, "BiddingResponse{");
        replace.append('}');
        return replace.toString();
    }

    public BiddingResponse(String str, String str2, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.win_url = str;
        this.lose_url = str2;
        this.ecpm = num;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.win_url = this.win_url;
        builder.lose_url = this.lose_url;
        builder.ecpm = this.ecpm;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

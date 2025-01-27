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
public final class ResponseAssetVideo extends AndroidMessage<ResponseAssetVideo, Builder> {
    public static final ProtoAdapter<ResponseAssetVideo> ADAPTER;
    public static final Parcelable.Creator<ResponseAssetVideo> CREATOR;
    public static final Integer DEFAULT_DURATION;
    public static final Integer DEFAULT_H;
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_W;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer duration;

    /* renamed from: h */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer f18256h;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String url;

    /* renamed from: w */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer f18257w;

    public static final class Builder extends Message.Builder<ResponseAssetVideo, Builder> {
        public String url = "";

        /* renamed from: w */
        public Integer f18259w = ResponseAssetVideo.DEFAULT_W;

        /* renamed from: h */
        public Integer f18258h = ResponseAssetVideo.DEFAULT_H;
        public Integer duration = ResponseAssetVideo.DEFAULT_DURATION;

        public Builder duration(Integer num) {
            this.duration = num;
            return this;
        }

        public Builder h(Integer num) {
            this.f18258h = num;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder w(Integer num) {
            this.f18259w = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public ResponseAssetVideo build() {
            return new ResponseAssetVideo(this.url, this.f18259w, this.f18258h, this.duration, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ResponseAssetVideo extends ProtoAdapter<ResponseAssetVideo> {
        public ProtoAdapter_ResponseAssetVideo() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAssetVideo.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ResponseAssetVideo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.w(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.h(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.duration(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ResponseAssetVideo responseAssetVideo) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, responseAssetVideo.url);
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 2, responseAssetVideo.f18257w);
            protoAdapter.encodeWithTag(protoWriter, 3, responseAssetVideo.f18256h);
            protoAdapter.encodeWithTag(protoWriter, 4, responseAssetVideo.duration);
            protoWriter.writeBytes(responseAssetVideo.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ResponseAssetVideo responseAssetVideo) {
            int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, responseAssetVideo.url);
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return encodedSizeWithTag + protoAdapter.encodedSizeWithTag(2, responseAssetVideo.f18257w) + protoAdapter.encodedSizeWithTag(3, responseAssetVideo.f18256h) + protoAdapter.encodedSizeWithTag(4, responseAssetVideo.duration) + responseAssetVideo.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ResponseAssetVideo redact(ResponseAssetVideo responseAssetVideo) {
            Builder newBuilder = responseAssetVideo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAssetVideo protoAdapter_ResponseAssetVideo = new ProtoAdapter_ResponseAssetVideo();
        ADAPTER = protoAdapter_ResponseAssetVideo;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAssetVideo);
        DEFAULT_W = 0;
        DEFAULT_H = 0;
        DEFAULT_DURATION = 0;
    }

    public ResponseAssetVideo(String str, Integer num, Integer num2, Integer num3) {
        this(str, num, num2, num3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAssetVideo)) {
            return false;
        }
        ResponseAssetVideo responseAssetVideo = (ResponseAssetVideo) obj;
        return unknownFields().equals(responseAssetVideo.unknownFields()) && Internal.equals(this.url, responseAssetVideo.url) && Internal.equals(this.f18257w, responseAssetVideo.f18257w) && Internal.equals(this.f18256h, responseAssetVideo.f18256h) && Internal.equals(this.duration, responseAssetVideo.duration);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f18257w;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.f18256h;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.duration;
        int hashCode5 = hashCode4 + (num3 != null ? num3.hashCode() : 0);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.url != null) {
            sb2.append(", url=");
            sb2.append(this.url);
        }
        if (this.f18257w != null) {
            sb2.append(", w=");
            sb2.append(this.f18257w);
        }
        if (this.f18256h != null) {
            sb2.append(", h=");
            sb2.append(this.f18256h);
        }
        if (this.duration != null) {
            sb2.append(", duration=");
            sb2.append(this.duration);
        }
        StringBuilder replace = sb2.replace(0, 2, "ResponseAssetVideo{");
        replace.append('}');
        return replace.toString();
    }

    public ResponseAssetVideo(String str, Integer num, Integer num2, Integer num3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.url = str;
        this.f18257w = num;
        this.f18256h = num2;
        this.duration = num3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.f18259w = this.f18257w;
        builder.f18258h = this.f18256h;
        builder.duration = this.duration;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

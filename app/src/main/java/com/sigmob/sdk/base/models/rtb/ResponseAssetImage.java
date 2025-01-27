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
public final class ResponseAssetImage extends AndroidMessage<ResponseAssetImage, Builder> {
    public static final ProtoAdapter<ResponseAssetImage> ADAPTER;
    public static final Parcelable.Creator<ResponseAssetImage> CREATOR;
    public static final Integer DEFAULT_H;
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_W;
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer f18252h;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String url;

    /* renamed from: w */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer f18253w;

    public static final class Builder extends Message.Builder<ResponseAssetImage, Builder> {
        public String url = "";

        /* renamed from: w */
        public Integer f18255w = ResponseAssetImage.DEFAULT_W;

        /* renamed from: h */
        public Integer f18254h = ResponseAssetImage.DEFAULT_H;

        public Builder h(Integer num) {
            this.f18254h = num;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder w(Integer num) {
            this.f18255w = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public ResponseAssetImage build() {
            return new ResponseAssetImage(this.url, this.f18255w, this.f18254h, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ResponseAssetImage extends ProtoAdapter<ResponseAssetImage> {
        public ProtoAdapter_ResponseAssetImage() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAssetImage.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ResponseAssetImage decode(ProtoReader protoReader) throws IOException {
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
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.h(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ResponseAssetImage responseAssetImage) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, responseAssetImage.url);
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 2, responseAssetImage.f18253w);
            protoAdapter.encodeWithTag(protoWriter, 3, responseAssetImage.f18252h);
            protoWriter.writeBytes(responseAssetImage.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ResponseAssetImage responseAssetImage) {
            int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, responseAssetImage.url);
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return encodedSizeWithTag + protoAdapter.encodedSizeWithTag(2, responseAssetImage.f18253w) + protoAdapter.encodedSizeWithTag(3, responseAssetImage.f18252h) + responseAssetImage.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ResponseAssetImage redact(ResponseAssetImage responseAssetImage) {
            Builder newBuilder = responseAssetImage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAssetImage protoAdapter_ResponseAssetImage = new ProtoAdapter_ResponseAssetImage();
        ADAPTER = protoAdapter_ResponseAssetImage;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAssetImage);
        DEFAULT_W = 0;
        DEFAULT_H = 0;
    }

    public ResponseAssetImage(String str, Integer num, Integer num2) {
        this(str, num, num2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAssetImage)) {
            return false;
        }
        ResponseAssetImage responseAssetImage = (ResponseAssetImage) obj;
        return unknownFields().equals(responseAssetImage.unknownFields()) && Internal.equals(this.url, responseAssetImage.url) && Internal.equals(this.f18253w, responseAssetImage.f18253w) && Internal.equals(this.f18252h, responseAssetImage.f18252h);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f18253w;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.f18252h;
        int hashCode4 = hashCode3 + (num2 != null ? num2.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.url != null) {
            sb2.append(", url=");
            sb2.append(this.url);
        }
        if (this.f18253w != null) {
            sb2.append(", w=");
            sb2.append(this.f18253w);
        }
        if (this.f18252h != null) {
            sb2.append(", h=");
            sb2.append(this.f18252h);
        }
        StringBuilder replace = sb2.replace(0, 2, "ResponseAssetImage{");
        replace.append('}');
        return replace.toString();
    }

    public ResponseAssetImage(String str, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.url = str;
        this.f18253w = num;
        this.f18252h = num2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.f18255w = this.f18253w;
        builder.f18254h = this.f18252h;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

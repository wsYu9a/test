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
import java.util.List;

/* loaded from: classes2.dex */
public final class AdCache extends AndroidMessage<AdCache, Builder> {
    public static final ProtoAdapter<AdCache> ADAPTER;
    public static final Parcelable.Creator<AdCache> CREATOR;
    public static final Integer DEFAULT_AD_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer ad_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> crids;

    public static final class Builder extends Message.Builder<AdCache, Builder> {
        public Integer ad_type;
        public List<String> crids = Internal.newMutableList();

        public Builder ad_type(Integer num) {
            this.ad_type = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public AdCache build() {
            return new AdCache(this.ad_type, this.crids, super.buildUnknownFields());
        }

        public Builder crids(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.crids = list;
            return this;
        }
    }

    public static final class ProtoAdapter_AdCache extends ProtoAdapter<AdCache> {
        public ProtoAdapter_AdCache() {
            super(FieldEncoding.LENGTH_DELIMITED, AdCache.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public AdCache decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.ad_type(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.crids.add(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, AdCache adCache) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, adCache.ad_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, adCache.crids);
            protoWriter.writeBytes(adCache.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(AdCache adCache) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, adCache.ad_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, adCache.crids) + adCache.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public AdCache redact(AdCache adCache) {
            Builder newBuilder = adCache.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdCache protoAdapter_AdCache = new ProtoAdapter_AdCache();
        ADAPTER = protoAdapter_AdCache;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdCache);
        DEFAULT_AD_TYPE = 0;
    }

    public AdCache(Integer num, List<String> list) {
        this(num, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdCache)) {
            return false;
        }
        AdCache adCache = (AdCache) obj;
        return unknownFields().equals(adCache.unknownFields()) && Internal.equals(this.ad_type, adCache.ad_type) && this.crids.equals(adCache.crids);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.ad_type;
        int hashCode2 = ((hashCode + (num != null ? num.hashCode() : 0)) * 37) + this.crids.hashCode();
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.ad_type = this.ad_type;
        builder.crids = Internal.copyOf("crids", this.crids);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.ad_type != null) {
            sb2.append(", ad_type=");
            sb2.append(this.ad_type);
        }
        if (!this.crids.isEmpty()) {
            sb2.append(", crids=");
            sb2.append(this.crids);
        }
        StringBuilder replace = sb2.replace(0, 2, "AdCache{");
        replace.append('}');
        return replace.toString();
    }

    public AdCache(Integer num, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_type = num;
        this.crids = Internal.immutableCopyOf("crids", list);
    }
}

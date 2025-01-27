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
public final class SingleNativeAdSetting extends AndroidMessage<SingleNativeAdSetting, Builder> {
    public static final ProtoAdapter<SingleNativeAdSetting> ADAPTER;
    public static final Parcelable.Creator<SingleNativeAdSetting> CREATOR;
    public static final Boolean DEFAULT_USE_NA_VIDEO_COMPONENT;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean use_na_video_component;

    public static final class Builder extends Message.Builder<SingleNativeAdSetting, Builder> {
        public Boolean use_na_video_component = SingleNativeAdSetting.DEFAULT_USE_NA_VIDEO_COMPONENT;

        public Builder use_na_video_component(Boolean bool) {
            this.use_na_video_component = bool;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SingleNativeAdSetting build() {
            return new SingleNativeAdSetting(this.use_na_video_component, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SingleNativeAdSetting extends ProtoAdapter<SingleNativeAdSetting> {
        public ProtoAdapter_SingleNativeAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SingleNativeAdSetting.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SingleNativeAdSetting decode(ProtoReader protoReader) throws IOException {
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
                    builder.use_na_video_component(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SingleNativeAdSetting singleNativeAdSetting) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, singleNativeAdSetting.use_na_video_component);
            protoWriter.writeBytes(singleNativeAdSetting.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SingleNativeAdSetting singleNativeAdSetting) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, singleNativeAdSetting.use_na_video_component) + singleNativeAdSetting.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SingleNativeAdSetting redact(SingleNativeAdSetting singleNativeAdSetting) {
            Builder newBuilder = singleNativeAdSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SingleNativeAdSetting protoAdapter_SingleNativeAdSetting = new ProtoAdapter_SingleNativeAdSetting();
        ADAPTER = protoAdapter_SingleNativeAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SingleNativeAdSetting);
        DEFAULT_USE_NA_VIDEO_COMPONENT = Boolean.FALSE;
    }

    public SingleNativeAdSetting(Boolean bool) {
        this(bool, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SingleNativeAdSetting)) {
            return false;
        }
        SingleNativeAdSetting singleNativeAdSetting = (SingleNativeAdSetting) obj;
        return unknownFields().equals(singleNativeAdSetting.unknownFields()) && Internal.equals(this.use_na_video_component, singleNativeAdSetting.use_na_video_component);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.use_na_video_component;
        int hashCode2 = hashCode + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.use_na_video_component != null) {
            sb2.append(", use_na_video_component=");
            sb2.append(this.use_na_video_component);
        }
        StringBuilder replace = sb2.replace(0, 2, "SingleNativeAdSetting{");
        replace.append('}');
        return replace.toString();
    }

    public SingleNativeAdSetting(Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.use_na_video_component = bool;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.use_na_video_component = this.use_na_video_component;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

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
public final class NativeAdSetting extends AndroidMessage<NativeAdSetting, Builder> {
    public static final ProtoAdapter<NativeAdSetting> ADAPTER;
    public static final Parcelable.Creator<NativeAdSetting> CREATOR;
    public static final Integer DEFAULT_DETAIL_PAGE_VIDEO_MUTE;
    public static final Integer DEFAULT_END_IMPRESSION_TIME;
    public static final Integer DEFAULT_IMPRESSION_PERCENT;
    public static final Integer DEFAULT_IMPRESSION_TIME;
    public static final Integer DEFAULT_PREVIEW_PAGE_VIDEO_MUTE;
    public static final Integer DEFAULT_VIDEO_AUTO_PLAY;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer detail_page_video_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer end_impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer impression_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer preview_page_video_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer video_auto_play;

    public static final class Builder extends Message.Builder<NativeAdSetting, Builder> {
        public Integer video_auto_play = NativeAdSetting.DEFAULT_VIDEO_AUTO_PLAY;
        public Integer preview_page_video_mute = NativeAdSetting.DEFAULT_PREVIEW_PAGE_VIDEO_MUTE;
        public Integer detail_page_video_mute = NativeAdSetting.DEFAULT_DETAIL_PAGE_VIDEO_MUTE;
        public Integer impression_percent = NativeAdSetting.DEFAULT_IMPRESSION_PERCENT;
        public Integer impression_time = NativeAdSetting.DEFAULT_IMPRESSION_TIME;
        public Integer end_impression_time = NativeAdSetting.DEFAULT_END_IMPRESSION_TIME;

        public Builder detail_page_video_mute(Integer num) {
            this.detail_page_video_mute = num;
            return this;
        }

        public Builder end_impression_time(Integer num) {
            this.end_impression_time = num;
            return this;
        }

        public Builder impression_percent(Integer num) {
            this.impression_percent = num;
            return this;
        }

        public Builder impression_time(Integer num) {
            this.impression_time = num;
            return this;
        }

        public Builder preview_page_video_mute(Integer num) {
            this.preview_page_video_mute = num;
            return this;
        }

        public Builder video_auto_play(Integer num) {
            this.video_auto_play = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public NativeAdSetting build() {
            return new NativeAdSetting(this.video_auto_play, this.preview_page_video_mute, this.detail_page_video_mute, this.impression_percent, this.impression_time, this.end_impression_time, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_NativeAdSetting extends ProtoAdapter<NativeAdSetting> {
        public ProtoAdapter_NativeAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, NativeAdSetting.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public NativeAdSetting decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 1:
                        builder.video_auto_play(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 2:
                        builder.preview_page_video_mute(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.detail_page_video_mute(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 4:
                        builder.impression_percent(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 5:
                        builder.impression_time(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 6:
                        builder.end_impression_time(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, NativeAdSetting nativeAdSetting) throws IOException {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, nativeAdSetting.video_auto_play);
            protoAdapter.encodeWithTag(protoWriter, 2, nativeAdSetting.preview_page_video_mute);
            protoAdapter.encodeWithTag(protoWriter, 3, nativeAdSetting.detail_page_video_mute);
            protoAdapter.encodeWithTag(protoWriter, 4, nativeAdSetting.impression_percent);
            protoAdapter.encodeWithTag(protoWriter, 5, nativeAdSetting.impression_time);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 6, nativeAdSetting.end_impression_time);
            protoWriter.writeBytes(nativeAdSetting.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(NativeAdSetting nativeAdSetting) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return protoAdapter.encodedSizeWithTag(1, nativeAdSetting.video_auto_play) + protoAdapter.encodedSizeWithTag(2, nativeAdSetting.preview_page_video_mute) + protoAdapter.encodedSizeWithTag(3, nativeAdSetting.detail_page_video_mute) + protoAdapter.encodedSizeWithTag(4, nativeAdSetting.impression_percent) + protoAdapter.encodedSizeWithTag(5, nativeAdSetting.impression_time) + ProtoAdapter.INT32.encodedSizeWithTag(6, nativeAdSetting.end_impression_time) + nativeAdSetting.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public NativeAdSetting redact(NativeAdSetting nativeAdSetting) {
            Builder newBuilder = nativeAdSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_NativeAdSetting protoAdapter_NativeAdSetting = new ProtoAdapter_NativeAdSetting();
        ADAPTER = protoAdapter_NativeAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_NativeAdSetting);
        DEFAULT_VIDEO_AUTO_PLAY = 0;
        DEFAULT_PREVIEW_PAGE_VIDEO_MUTE = 0;
        DEFAULT_DETAIL_PAGE_VIDEO_MUTE = 0;
        DEFAULT_IMPRESSION_PERCENT = 0;
        DEFAULT_IMPRESSION_TIME = 0;
        DEFAULT_END_IMPRESSION_TIME = 0;
    }

    public NativeAdSetting(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this(num, num2, num3, num4, num5, num6, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NativeAdSetting)) {
            return false;
        }
        NativeAdSetting nativeAdSetting = (NativeAdSetting) obj;
        return unknownFields().equals(nativeAdSetting.unknownFields()) && Internal.equals(this.video_auto_play, nativeAdSetting.video_auto_play) && Internal.equals(this.preview_page_video_mute, nativeAdSetting.preview_page_video_mute) && Internal.equals(this.detail_page_video_mute, nativeAdSetting.detail_page_video_mute) && Internal.equals(this.impression_percent, nativeAdSetting.impression_percent) && Internal.equals(this.impression_time, nativeAdSetting.impression_time) && Internal.equals(this.end_impression_time, nativeAdSetting.end_impression_time);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.video_auto_play;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.preview_page_video_mute;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.detail_page_video_mute;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.impression_percent;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.impression_time;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.end_impression_time;
        int hashCode7 = hashCode6 + (num6 != null ? num6.hashCode() : 0);
        this.hashCode = hashCode7;
        return hashCode7;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.video_auto_play != null) {
            sb2.append(", video_auto_play=");
            sb2.append(this.video_auto_play);
        }
        if (this.preview_page_video_mute != null) {
            sb2.append(", preview_page_video_mute=");
            sb2.append(this.preview_page_video_mute);
        }
        if (this.detail_page_video_mute != null) {
            sb2.append(", detail_page_video_mute=");
            sb2.append(this.detail_page_video_mute);
        }
        if (this.impression_percent != null) {
            sb2.append(", impression_percent=");
            sb2.append(this.impression_percent);
        }
        if (this.impression_time != null) {
            sb2.append(", impression_time=");
            sb2.append(this.impression_time);
        }
        if (this.end_impression_time != null) {
            sb2.append(", end_impression_time=");
            sb2.append(this.end_impression_time);
        }
        StringBuilder replace = sb2.replace(0, 2, "NativeAdSetting{");
        replace.append('}');
        return replace.toString();
    }

    public NativeAdSetting(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, ByteString byteString) {
        super(ADAPTER, byteString);
        this.video_auto_play = num;
        this.preview_page_video_mute = num2;
        this.detail_page_video_mute = num3;
        this.impression_percent = num4;
        this.impression_time = num5;
        this.end_impression_time = num6;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.video_auto_play = this.video_auto_play;
        builder.preview_page_video_mute = this.preview_page_video_mute;
        builder.detail_page_video_mute = this.detail_page_video_mute;
        builder.impression_percent = this.impression_percent;
        builder.impression_time = this.impression_time;
        builder.end_impression_time = this.end_impression_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

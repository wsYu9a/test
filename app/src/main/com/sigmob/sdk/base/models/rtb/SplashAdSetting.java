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
public final class SplashAdSetting extends AndroidMessage<SplashAdSetting, Builder> {
    public static final ProtoAdapter<SplashAdSetting> ADAPTER;
    public static final Parcelable.Creator<SplashAdSetting> CREATOR;
    public static final Boolean DEFAULT_ENABLE_CLOSE_ON_CLICK;
    public static final Boolean DEFAULT_ENABLE_FULL_CLICK;
    public static final Boolean DEFAULT_INVISIBLE_AD_LABEL;
    public static final Integer DEFAULT_SHOW_DURATION;
    public static final Boolean DEFAULT_USE_FLOATING_BTN;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean enable_close_on_click;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean enable_full_click;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean invisible_ad_label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer show_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean use_floating_btn;

    public static final class Builder extends Message.Builder<SplashAdSetting, Builder> {
        public Integer show_duration = SplashAdSetting.DEFAULT_SHOW_DURATION;
        public Boolean enable_close_on_click = SplashAdSetting.DEFAULT_ENABLE_CLOSE_ON_CLICK;
        public Boolean enable_full_click = SplashAdSetting.DEFAULT_ENABLE_FULL_CLICK;
        public Boolean invisible_ad_label = SplashAdSetting.DEFAULT_INVISIBLE_AD_LABEL;
        public Boolean use_floating_btn = SplashAdSetting.DEFAULT_USE_FLOATING_BTN;

        public Builder enable_close_on_click(Boolean bool) {
            this.enable_close_on_click = bool;
            return this;
        }

        public Builder enable_full_click(Boolean bool) {
            this.enable_full_click = bool;
            return this;
        }

        public Builder invisible_ad_label(Boolean bool) {
            this.invisible_ad_label = bool;
            return this;
        }

        public Builder show_duration(Integer num) {
            this.show_duration = num;
            return this;
        }

        public Builder use_floating_btn(Boolean bool) {
            this.use_floating_btn = bool;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SplashAdSetting build() {
            return new SplashAdSetting(this.show_duration, this.enable_close_on_click, this.enable_full_click, this.invisible_ad_label, this.use_floating_btn, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SplashAdSetting extends ProtoAdapter<SplashAdSetting> {
        public ProtoAdapter_SplashAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SplashAdSetting.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SplashAdSetting decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.show_duration(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.enable_close_on_click(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 5) {
                    builder.enable_full_click(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 6) {
                    builder.invisible_ad_label(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 7) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.use_floating_btn(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SplashAdSetting splashAdSetting) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, splashAdSetting.show_duration);
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            protoAdapter.encodeWithTag(protoWriter, 2, splashAdSetting.enable_close_on_click);
            protoAdapter.encodeWithTag(protoWriter, 5, splashAdSetting.enable_full_click);
            protoAdapter.encodeWithTag(protoWriter, 6, splashAdSetting.invisible_ad_label);
            protoAdapter.encodeWithTag(protoWriter, 7, splashAdSetting.use_floating_btn);
            protoWriter.writeBytes(splashAdSetting.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SplashAdSetting splashAdSetting) {
            int encodedSizeWithTag = ProtoAdapter.INT32.encodedSizeWithTag(1, splashAdSetting.show_duration);
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            return encodedSizeWithTag + protoAdapter.encodedSizeWithTag(2, splashAdSetting.enable_close_on_click) + protoAdapter.encodedSizeWithTag(5, splashAdSetting.enable_full_click) + protoAdapter.encodedSizeWithTag(6, splashAdSetting.invisible_ad_label) + protoAdapter.encodedSizeWithTag(7, splashAdSetting.use_floating_btn) + splashAdSetting.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SplashAdSetting redact(SplashAdSetting splashAdSetting) {
            Builder newBuilder = splashAdSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SplashAdSetting protoAdapter_SplashAdSetting = new ProtoAdapter_SplashAdSetting();
        ADAPTER = protoAdapter_SplashAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SplashAdSetting);
        DEFAULT_SHOW_DURATION = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_ENABLE_CLOSE_ON_CLICK = bool;
        DEFAULT_ENABLE_FULL_CLICK = bool;
        DEFAULT_INVISIBLE_AD_LABEL = bool;
        DEFAULT_USE_FLOATING_BTN = bool;
    }

    public SplashAdSetting(Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this(num, bool, bool2, bool3, bool4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SplashAdSetting)) {
            return false;
        }
        SplashAdSetting splashAdSetting = (SplashAdSetting) obj;
        return unknownFields().equals(splashAdSetting.unknownFields()) && Internal.equals(this.show_duration, splashAdSetting.show_duration) && Internal.equals(this.enable_close_on_click, splashAdSetting.enable_close_on_click) && Internal.equals(this.enable_full_click, splashAdSetting.enable_full_click) && Internal.equals(this.invisible_ad_label, splashAdSetting.invisible_ad_label) && Internal.equals(this.use_floating_btn, splashAdSetting.use_floating_btn);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.show_duration;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.enable_close_on_click;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.enable_full_click;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.invisible_ad_label;
        int hashCode5 = (hashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.use_floating_btn;
        int hashCode6 = hashCode5 + (bool4 != null ? bool4.hashCode() : 0);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.show_duration != null) {
            sb2.append(", show_duration=");
            sb2.append(this.show_duration);
        }
        if (this.enable_close_on_click != null) {
            sb2.append(", enable_close_on_click=");
            sb2.append(this.enable_close_on_click);
        }
        if (this.enable_full_click != null) {
            sb2.append(", enable_full_click=");
            sb2.append(this.enable_full_click);
        }
        if (this.invisible_ad_label != null) {
            sb2.append(", invisible_ad_label=");
            sb2.append(this.invisible_ad_label);
        }
        if (this.use_floating_btn != null) {
            sb2.append(", use_floating_btn=");
            sb2.append(this.use_floating_btn);
        }
        StringBuilder replace = sb2.replace(0, 2, "SplashAdSetting{");
        replace.append('}');
        return replace.toString();
    }

    public SplashAdSetting(Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.show_duration = num;
        this.enable_close_on_click = bool;
        this.enable_full_click = bool2;
        this.invisible_ad_label = bool3;
        this.use_floating_btn = bool4;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.show_duration = this.show_duration;
        builder.enable_close_on_click = this.enable_close_on_click;
        builder.enable_full_click = this.enable_full_click;
        builder.invisible_ad_label = this.invisible_ad_label;
        builder.use_floating_btn = this.use_floating_btn;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

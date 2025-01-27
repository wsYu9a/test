package com.sigmob.sdk.base.models.config;

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
public final class SigmobCommonEndpointsConfig extends AndroidMessage<SigmobCommonEndpointsConfig, Builder> {
    public static final ProtoAdapter<SigmobCommonEndpointsConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobCommonEndpointsConfig> CREATOR;
    public static final String DEFAULT_ADS = "";
    public static final String DEFAULT_CONFIG = "";
    public static final String DEFAULT_FEEDBACK = "";
    public static final String DEFAULT_HB_ADS = "";
    public static final String DEFAULT_LOG = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String ads;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String feedback;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String hb_ads;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String log;

    public static final class Builder extends Message.Builder<SigmobCommonEndpointsConfig, Builder> {
        public String ads;
        public String config;
        public String feedback;
        public String hb_ads;
        public String log;

        public Builder ads(String str) {
            this.ads = str;
            return this;
        }

        public Builder config(String str) {
            this.config = str;
            return this;
        }

        public Builder feedback(String str) {
            this.feedback = str;
            return this;
        }

        public Builder hb_ads(String str) {
            this.hb_ads = str;
            return this;
        }

        public Builder log(String str) {
            this.log = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobCommonEndpointsConfig build() {
            return new SigmobCommonEndpointsConfig(this.log, this.ads, this.hb_ads, this.feedback, this.config, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobCommonEndpointsConfig extends ProtoAdapter<SigmobCommonEndpointsConfig> {
        public ProtoAdapter_SigmobCommonEndpointsConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobCommonEndpointsConfig.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobCommonEndpointsConfig decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.log(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.ads(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.hb_ads(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.feedback(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.config(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, sigmobCommonEndpointsConfig.log);
            protoAdapter.encodeWithTag(protoWriter, 2, sigmobCommonEndpointsConfig.ads);
            protoAdapter.encodeWithTag(protoWriter, 3, sigmobCommonEndpointsConfig.hb_ads);
            protoAdapter.encodeWithTag(protoWriter, 4, sigmobCommonEndpointsConfig.feedback);
            protoAdapter.encodeWithTag(protoWriter, 5, sigmobCommonEndpointsConfig.config);
            protoWriter.writeBytes(sigmobCommonEndpointsConfig.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, sigmobCommonEndpointsConfig.log) + protoAdapter.encodedSizeWithTag(2, sigmobCommonEndpointsConfig.ads) + protoAdapter.encodedSizeWithTag(3, sigmobCommonEndpointsConfig.hb_ads) + protoAdapter.encodedSizeWithTag(4, sigmobCommonEndpointsConfig.feedback) + protoAdapter.encodedSizeWithTag(5, sigmobCommonEndpointsConfig.config) + sigmobCommonEndpointsConfig.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobCommonEndpointsConfig redact(SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig) {
            Builder newBuilder = sigmobCommonEndpointsConfig.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobCommonEndpointsConfig protoAdapter_SigmobCommonEndpointsConfig = new ProtoAdapter_SigmobCommonEndpointsConfig();
        ADAPTER = protoAdapter_SigmobCommonEndpointsConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobCommonEndpointsConfig);
    }

    public SigmobCommonEndpointsConfig(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobCommonEndpointsConfig)) {
            return false;
        }
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig = (SigmobCommonEndpointsConfig) obj;
        return unknownFields().equals(sigmobCommonEndpointsConfig.unknownFields()) && Internal.equals(this.log, sigmobCommonEndpointsConfig.log) && Internal.equals(this.ads, sigmobCommonEndpointsConfig.ads) && Internal.equals(this.hb_ads, sigmobCommonEndpointsConfig.hb_ads) && Internal.equals(this.feedback, sigmobCommonEndpointsConfig.feedback) && Internal.equals(this.config, sigmobCommonEndpointsConfig.config);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.log;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.ads;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.hb_ads;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.feedback;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.config;
        int hashCode6 = hashCode5 + (str5 != null ? str5.hashCode() : 0);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.log != null) {
            sb2.append(", log=");
            sb2.append(this.log);
        }
        if (this.ads != null) {
            sb2.append(", ads=");
            sb2.append(this.ads);
        }
        if (this.hb_ads != null) {
            sb2.append(", hb_ads=");
            sb2.append(this.hb_ads);
        }
        if (this.feedback != null) {
            sb2.append(", feedback=");
            sb2.append(this.feedback);
        }
        if (this.config != null) {
            sb2.append(", config=");
            sb2.append(this.config);
        }
        StringBuilder replace = sb2.replace(0, 2, "SigmobCommonEndpointsConfig{");
        replace.append('}');
        return replace.toString();
    }

    public SigmobCommonEndpointsConfig(String str, String str2, String str3, String str4, String str5, ByteString byteString) {
        super(ADAPTER, byteString);
        this.log = str;
        this.ads = str2;
        this.hb_ads = str3;
        this.feedback = str4;
        this.config = str5;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.log = this.log;
        builder.ads = this.ads;
        builder.hb_ads = this.hb_ads;
        builder.feedback = this.feedback;
        builder.config = this.config;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

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
public final class SigmobRvConfig extends AndroidMessage<SigmobRvConfig, Builder> {
    public static final ProtoAdapter<SigmobRvConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobRvConfig> CREATOR;
    public static final Integer DEFAULT_AD_LOAD_TIMEOUT;
    public static final Integer DEFAULT_CACHETOP;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer ad_load_timeout;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer cacheTop;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobDialogSetting#ADAPTER", tag = 3)
    public final SigmobDialogSetting close_dialog_setting;

    public static final class Builder extends Message.Builder<SigmobRvConfig, Builder> {
        public Integer ad_load_timeout;
        public Integer cacheTop;
        public SigmobDialogSetting close_dialog_setting;

        public Builder ad_load_timeout(Integer num) {
            this.ad_load_timeout = num;
            return this;
        }

        public Builder cacheTop(Integer num) {
            this.cacheTop = num;
            return this;
        }

        public Builder close_dialog_setting(SigmobDialogSetting sigmobDialogSetting) {
            this.close_dialog_setting = sigmobDialogSetting;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobRvConfig build() {
            return new SigmobRvConfig(this.cacheTop, this.ad_load_timeout, this.close_dialog_setting, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobRvConfig extends ProtoAdapter<SigmobRvConfig> {
        public ProtoAdapter_SigmobRvConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobRvConfig.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobRvConfig decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.cacheTop(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.ad_load_timeout(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.close_dialog_setting(SigmobDialogSetting.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobRvConfig sigmobRvConfig) throws IOException {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, sigmobRvConfig.cacheTop);
            protoAdapter.encodeWithTag(protoWriter, 2, sigmobRvConfig.ad_load_timeout);
            SigmobDialogSetting.ADAPTER.encodeWithTag(protoWriter, 3, sigmobRvConfig.close_dialog_setting);
            protoWriter.writeBytes(sigmobRvConfig.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobRvConfig sigmobRvConfig) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return protoAdapter.encodedSizeWithTag(1, sigmobRvConfig.cacheTop) + protoAdapter.encodedSizeWithTag(2, sigmobRvConfig.ad_load_timeout) + SigmobDialogSetting.ADAPTER.encodedSizeWithTag(3, sigmobRvConfig.close_dialog_setting) + sigmobRvConfig.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobRvConfig redact(SigmobRvConfig sigmobRvConfig) {
            Builder newBuilder = sigmobRvConfig.newBuilder();
            SigmobDialogSetting sigmobDialogSetting = newBuilder.close_dialog_setting;
            if (sigmobDialogSetting != null) {
                newBuilder.close_dialog_setting = SigmobDialogSetting.ADAPTER.redact(sigmobDialogSetting);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobRvConfig protoAdapter_SigmobRvConfig = new ProtoAdapter_SigmobRvConfig();
        ADAPTER = protoAdapter_SigmobRvConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobRvConfig);
        DEFAULT_CACHETOP = 0;
        DEFAULT_AD_LOAD_TIMEOUT = 0;
    }

    public SigmobRvConfig(Integer num, Integer num2, SigmobDialogSetting sigmobDialogSetting) {
        this(num, num2, sigmobDialogSetting, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobRvConfig)) {
            return false;
        }
        SigmobRvConfig sigmobRvConfig = (SigmobRvConfig) obj;
        return unknownFields().equals(sigmobRvConfig.unknownFields()) && Internal.equals(this.cacheTop, sigmobRvConfig.cacheTop) && Internal.equals(this.ad_load_timeout, sigmobRvConfig.ad_load_timeout) && Internal.equals(this.close_dialog_setting, sigmobRvConfig.close_dialog_setting);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.cacheTop;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ad_load_timeout;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        SigmobDialogSetting sigmobDialogSetting = this.close_dialog_setting;
        int hashCode4 = hashCode3 + (sigmobDialogSetting != null ? sigmobDialogSetting.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.cacheTop != null) {
            sb2.append(", cacheTop=");
            sb2.append(this.cacheTop);
        }
        if (this.ad_load_timeout != null) {
            sb2.append(", ad_load_timeout=");
            sb2.append(this.ad_load_timeout);
        }
        if (this.close_dialog_setting != null) {
            sb2.append(", close_dialog_setting=");
            sb2.append(this.close_dialog_setting);
        }
        StringBuilder replace = sb2.replace(0, 2, "SigmobRvConfig{");
        replace.append('}');
        return replace.toString();
    }

    public SigmobRvConfig(Integer num, Integer num2, SigmobDialogSetting sigmobDialogSetting, ByteString byteString) {
        super(ADAPTER, byteString);
        this.cacheTop = num;
        this.ad_load_timeout = num2;
        this.close_dialog_setting = sigmobDialogSetting;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.cacheTop = this.cacheTop;
        builder.ad_load_timeout = this.ad_load_timeout;
        builder.close_dialog_setting = this.close_dialog_setting;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

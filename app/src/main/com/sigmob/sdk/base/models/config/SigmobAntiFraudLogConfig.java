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
import com.umeng.analytics.pro.f;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class SigmobAntiFraudLogConfig extends AndroidMessage<SigmobAntiFraudLogConfig, Builder> {
    public static final ProtoAdapter<SigmobAntiFraudLogConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobAntiFraudLogConfig> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> events;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobMotionConfig#ADAPTER", tag = 1)
    public final SigmobMotionConfig motion_config;

    public static final class Builder extends Message.Builder<SigmobAntiFraudLogConfig, Builder> {
        public List<String> events = Internal.newMutableList();
        public SigmobMotionConfig motion_config;

        public Builder events(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.events = list;
            return this;
        }

        public Builder motion_config(SigmobMotionConfig sigmobMotionConfig) {
            this.motion_config = sigmobMotionConfig;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobAntiFraudLogConfig build() {
            return new SigmobAntiFraudLogConfig(this.motion_config, this.events, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobAntiFraudLogConfig extends ProtoAdapter<SigmobAntiFraudLogConfig> {
        public ProtoAdapter_SigmobAntiFraudLogConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobAntiFraudLogConfig.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobAntiFraudLogConfig decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.motion_config(SigmobMotionConfig.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.events.add(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) throws IOException {
            SigmobMotionConfig.ADAPTER.encodeWithTag(protoWriter, 1, sigmobAntiFraudLogConfig.motion_config);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, sigmobAntiFraudLogConfig.events);
            protoWriter.writeBytes(sigmobAntiFraudLogConfig.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            return SigmobMotionConfig.ADAPTER.encodedSizeWithTag(1, sigmobAntiFraudLogConfig.motion_config) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, sigmobAntiFraudLogConfig.events) + sigmobAntiFraudLogConfig.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobAntiFraudLogConfig redact(SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            Builder newBuilder = sigmobAntiFraudLogConfig.newBuilder();
            SigmobMotionConfig sigmobMotionConfig = newBuilder.motion_config;
            if (sigmobMotionConfig != null) {
                newBuilder.motion_config = SigmobMotionConfig.ADAPTER.redact(sigmobMotionConfig);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobAntiFraudLogConfig protoAdapter_SigmobAntiFraudLogConfig = new ProtoAdapter_SigmobAntiFraudLogConfig();
        ADAPTER = protoAdapter_SigmobAntiFraudLogConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobAntiFraudLogConfig);
    }

    public SigmobAntiFraudLogConfig(SigmobMotionConfig sigmobMotionConfig, List<String> list) {
        this(sigmobMotionConfig, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobAntiFraudLogConfig)) {
            return false;
        }
        SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig = (SigmobAntiFraudLogConfig) obj;
        return unknownFields().equals(sigmobAntiFraudLogConfig.unknownFields()) && Internal.equals(this.motion_config, sigmobAntiFraudLogConfig.motion_config) && this.events.equals(sigmobAntiFraudLogConfig.events);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        SigmobMotionConfig sigmobMotionConfig = this.motion_config;
        int hashCode2 = ((hashCode + (sigmobMotionConfig != null ? sigmobMotionConfig.hashCode() : 0)) * 37) + this.events.hashCode();
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.motion_config != null) {
            sb2.append(", motion_config=");
            sb2.append(this.motion_config);
        }
        if (!this.events.isEmpty()) {
            sb2.append(", events=");
            sb2.append(this.events);
        }
        StringBuilder replace = sb2.replace(0, 2, "SigmobAntiFraudLogConfig{");
        replace.append('}');
        return replace.toString();
    }

    public SigmobAntiFraudLogConfig(SigmobMotionConfig sigmobMotionConfig, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.motion_config = sigmobMotionConfig;
        this.events = Internal.immutableCopyOf(f.ax, list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.motion_config = this.motion_config;
        builder.events = Internal.copyOf(f.ax, this.events);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

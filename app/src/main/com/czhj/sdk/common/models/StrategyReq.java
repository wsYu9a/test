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

/* loaded from: classes2.dex */
public final class StrategyReq extends AndroidMessage<StrategyReq, Builder> {
    public static final ProtoAdapter<StrategyReq> ADAPTER;
    public static final Parcelable.Creator<StrategyReq> CREATOR;
    public static final String DEFAULT_LAST_STRATEGY_ID = "";
    public static final Boolean DEFAULT_STRATEGY_INIT;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String last_strategy_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean strategy_init;

    public static final class Builder extends Message.Builder<StrategyReq, Builder> {
        public Boolean strategy_init = StrategyReq.DEFAULT_STRATEGY_INIT;
        public String last_strategy_id = "";

        @Override // com.czhj.wire.Message.Builder
        public StrategyReq build() {
            return new StrategyReq(this.strategy_init, this.last_strategy_id, super.buildUnknownFields());
        }

        public Builder last_strategy_id(String str) {
            this.last_strategy_id = str;
            return this;
        }

        public Builder strategy_init(Boolean bool) {
            this.strategy_init = bool;
            return this;
        }
    }

    public static final class ProtoAdapter_StrategyReq extends ProtoAdapter<StrategyReq> {
        public ProtoAdapter_StrategyReq() {
            super(FieldEncoding.LENGTH_DELIMITED, StrategyReq.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public StrategyReq decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.strategy_init(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.last_strategy_id(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, StrategyReq strategyReq) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, strategyReq.strategy_init);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, strategyReq.last_strategy_id);
            protoWriter.writeBytes(strategyReq.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(StrategyReq strategyReq) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, strategyReq.strategy_init) + ProtoAdapter.STRING.encodedSizeWithTag(2, strategyReq.last_strategy_id) + strategyReq.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public StrategyReq redact(StrategyReq strategyReq) {
            Builder newBuilder = strategyReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_StrategyReq protoAdapter_StrategyReq = new ProtoAdapter_StrategyReq();
        ADAPTER = protoAdapter_StrategyReq;
        CREATOR = AndroidMessage.newCreator(protoAdapter_StrategyReq);
        DEFAULT_STRATEGY_INIT = Boolean.FALSE;
    }

    public StrategyReq(Boolean bool, String str) {
        this(bool, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StrategyReq)) {
            return false;
        }
        StrategyReq strategyReq = (StrategyReq) obj;
        return unknownFields().equals(strategyReq.unknownFields()) && Internal.equals(this.strategy_init, strategyReq.strategy_init) && Internal.equals(this.last_strategy_id, strategyReq.last_strategy_id);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.strategy_init;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.last_strategy_id;
        int hashCode3 = hashCode2 + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.strategy_init = this.strategy_init;
        builder.last_strategy_id = this.last_strategy_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.strategy_init != null) {
            sb2.append(", strategy_init=");
            sb2.append(this.strategy_init);
        }
        if (this.last_strategy_id != null) {
            sb2.append(", last_strategy_id=");
            sb2.append(this.last_strategy_id);
        }
        StringBuilder replace = sb2.replace(0, 2, "StrategyReq{");
        replace.append('}');
        return replace.toString();
    }

    public StrategyReq(Boolean bool, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.strategy_init = bool;
        this.last_strategy_id = str;
    }
}

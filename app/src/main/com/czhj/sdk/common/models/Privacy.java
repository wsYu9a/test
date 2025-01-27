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
public final class Privacy extends AndroidMessage<Privacy, Builder> {
    public static final ProtoAdapter<Privacy> ADAPTER;
    public static final Parcelable.Creator<Privacy> CREATOR;
    public static final Integer DEFAULT_AGE;
    public static final Integer DEFAULT_CHILD_PROTECTION;
    public static final Integer DEFAULT_GDPR_CONSENT;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer age;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer child_protection;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer gdpr_consent;

    public static final class Builder extends Message.Builder<Privacy, Builder> {
        public Integer gdpr_consent = Privacy.DEFAULT_GDPR_CONSENT;
        public Integer child_protection = Privacy.DEFAULT_CHILD_PROTECTION;
        public Integer age = Privacy.DEFAULT_AGE;

        public Builder age(Integer num) {
            this.age = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Privacy build() {
            return new Privacy(this.gdpr_consent, this.child_protection, this.age, super.buildUnknownFields());
        }

        public Builder child_protection(Integer num) {
            this.child_protection = num;
            return this;
        }

        public Builder gdpr_consent(Integer num) {
            this.gdpr_consent = num;
            return this;
        }
    }

    public static final class ProtoAdapter_Privacy extends ProtoAdapter<Privacy> {
        public ProtoAdapter_Privacy() {
            super(FieldEncoding.LENGTH_DELIMITED, Privacy.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Privacy decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.gdpr_consent(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.child_protection(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.age(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Privacy privacy) throws IOException {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, privacy.gdpr_consent);
            protoAdapter.encodeWithTag(protoWriter, 2, privacy.child_protection);
            protoAdapter.encodeWithTag(protoWriter, 3, privacy.age);
            protoWriter.writeBytes(privacy.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Privacy privacy) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return protoAdapter.encodedSizeWithTag(1, privacy.gdpr_consent) + protoAdapter.encodedSizeWithTag(2, privacy.child_protection) + protoAdapter.encodedSizeWithTag(3, privacy.age) + privacy.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Privacy redact(Privacy privacy) {
            Builder newBuilder = privacy.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Privacy protoAdapter_Privacy = new ProtoAdapter_Privacy();
        ADAPTER = protoAdapter_Privacy;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Privacy);
        DEFAULT_GDPR_CONSENT = 0;
        DEFAULT_CHILD_PROTECTION = 0;
        DEFAULT_AGE = 0;
    }

    public Privacy(Integer num, Integer num2, Integer num3) {
        this(num, num2, num3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Privacy)) {
            return false;
        }
        Privacy privacy = (Privacy) obj;
        return unknownFields().equals(privacy.unknownFields()) && Internal.equals(this.gdpr_consent, privacy.gdpr_consent) && Internal.equals(this.child_protection, privacy.child_protection) && Internal.equals(this.age, privacy.age);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.gdpr_consent;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.child_protection;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.age;
        int hashCode4 = hashCode3 + (num3 != null ? num3.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.gdpr_consent = this.gdpr_consent;
        builder.child_protection = this.child_protection;
        builder.age = this.age;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.gdpr_consent != null) {
            sb2.append(", gdpr_consent=");
            sb2.append(this.gdpr_consent);
        }
        if (this.child_protection != null) {
            sb2.append(", child_protection=");
            sb2.append(this.child_protection);
        }
        if (this.age != null) {
            sb2.append(", age=");
            sb2.append(this.age);
        }
        StringBuilder replace = sb2.replace(0, 2, "Privacy{");
        replace.append('}');
        return replace.toString();
    }

    public Privacy(Integer num, Integer num2, Integer num3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.gdpr_consent = num;
        this.child_protection = num2;
        this.age = num3;
    }
}

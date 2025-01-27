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
public final class ClickAreaSetting extends AndroidMessage<ClickAreaSetting, Builder> {
    public static final ProtoAdapter<ClickAreaSetting> ADAPTER;
    public static final Parcelable.Creator<ClickAreaSetting> CREATOR;
    public static final Float DEFAULT_BOTTOM;
    public static final Float DEFAULT_LEFT;
    public static final Float DEFAULT_RIGHT;
    public static final Float DEFAULT_TOP;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float bottom;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float left;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float right;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float top;

    public static final class Builder extends Message.Builder<ClickAreaSetting, Builder> {
        public Float top = ClickAreaSetting.DEFAULT_TOP;
        public Float left = ClickAreaSetting.DEFAULT_LEFT;
        public Float bottom = ClickAreaSetting.DEFAULT_BOTTOM;
        public Float right = ClickAreaSetting.DEFAULT_RIGHT;

        public Builder bottom(Float f10) {
            this.bottom = f10;
            return this;
        }

        public Builder left(Float f10) {
            this.left = f10;
            return this;
        }

        public Builder right(Float f10) {
            this.right = f10;
            return this;
        }

        public Builder top(Float f10) {
            this.top = f10;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public ClickAreaSetting build() {
            return new ClickAreaSetting(this.top, this.left, this.bottom, this.right, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ClickAreaSetting extends ProtoAdapter<ClickAreaSetting> {
        public ProtoAdapter_ClickAreaSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ClickAreaSetting.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ClickAreaSetting decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.top(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.left(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.bottom(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.right(ProtoAdapter.FLOAT.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ClickAreaSetting clickAreaSetting) throws IOException {
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            protoAdapter.encodeWithTag(protoWriter, 1, clickAreaSetting.top);
            protoAdapter.encodeWithTag(protoWriter, 2, clickAreaSetting.left);
            protoAdapter.encodeWithTag(protoWriter, 3, clickAreaSetting.bottom);
            protoAdapter.encodeWithTag(protoWriter, 4, clickAreaSetting.right);
            protoWriter.writeBytes(clickAreaSetting.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ClickAreaSetting clickAreaSetting) {
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            return protoAdapter.encodedSizeWithTag(1, clickAreaSetting.top) + protoAdapter.encodedSizeWithTag(2, clickAreaSetting.left) + protoAdapter.encodedSizeWithTag(3, clickAreaSetting.bottom) + protoAdapter.encodedSizeWithTag(4, clickAreaSetting.right) + clickAreaSetting.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ClickAreaSetting redact(ClickAreaSetting clickAreaSetting) {
            Builder newBuilder = clickAreaSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ClickAreaSetting protoAdapter_ClickAreaSetting = new ProtoAdapter_ClickAreaSetting();
        ADAPTER = protoAdapter_ClickAreaSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ClickAreaSetting);
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_TOP = valueOf;
        DEFAULT_LEFT = valueOf;
        DEFAULT_BOTTOM = valueOf;
        DEFAULT_RIGHT = valueOf;
    }

    public ClickAreaSetting(Float f10, Float f11, Float f12, Float f13) {
        this(f10, f11, f12, f13, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClickAreaSetting)) {
            return false;
        }
        ClickAreaSetting clickAreaSetting = (ClickAreaSetting) obj;
        return unknownFields().equals(clickAreaSetting.unknownFields()) && Internal.equals(this.top, clickAreaSetting.top) && Internal.equals(this.left, clickAreaSetting.left) && Internal.equals(this.bottom, clickAreaSetting.bottom) && Internal.equals(this.right, clickAreaSetting.right);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Float f10 = this.top;
        int hashCode2 = (hashCode + (f10 != null ? f10.hashCode() : 0)) * 37;
        Float f11 = this.left;
        int hashCode3 = (hashCode2 + (f11 != null ? f11.hashCode() : 0)) * 37;
        Float f12 = this.bottom;
        int hashCode4 = (hashCode3 + (f12 != null ? f12.hashCode() : 0)) * 37;
        Float f13 = this.right;
        int hashCode5 = hashCode4 + (f13 != null ? f13.hashCode() : 0);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.top != null) {
            sb2.append(", top=");
            sb2.append(this.top);
        }
        if (this.left != null) {
            sb2.append(", left=");
            sb2.append(this.left);
        }
        if (this.bottom != null) {
            sb2.append(", bottom=");
            sb2.append(this.bottom);
        }
        if (this.right != null) {
            sb2.append(", right=");
            sb2.append(this.right);
        }
        StringBuilder replace = sb2.replace(0, 2, "ClickAreaSetting{");
        replace.append('}');
        return replace.toString();
    }

    public ClickAreaSetting(Float f10, Float f11, Float f12, Float f13, ByteString byteString) {
        super(ADAPTER, byteString);
        this.top = f10;
        this.left = f11;
        this.bottom = f12;
        this.right = f13;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.top = this.top;
        builder.left = this.left;
        builder.bottom = this.bottom;
        builder.right = this.right;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}

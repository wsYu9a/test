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
import l5.c;

/* loaded from: classes2.dex */
public final class Geo extends AndroidMessage<Geo, Builder> {
    public static final ProtoAdapter<Geo> ADAPTER;
    public static final Parcelable.Creator<Geo> CREATOR;
    public static final Double DEFAULT_ACCURACY;
    public static final Long DEFAULT_CITY_CODE;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_LANGUAGE = "";
    public static final Float DEFAULT_LAT;
    public static final Float DEFAULT_LON;
    public static final String DEFAULT_REGION_CODE = "";
    public static final String DEFAULT_SECONDSFROMGMT = "";
    public static final String DEFAULT_TIMEZONE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 9)
    public final Double accuracy;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 5)
    public final Long city_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String country;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String language;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float lat;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float lon;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String region_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String secondsFromGMT;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String timeZone;

    public static final class Builder extends Message.Builder<Geo, Builder> {
        public Float lat = Geo.DEFAULT_LAT;
        public Float lon = Geo.DEFAULT_LON;
        public String language = "";
        public String timeZone = "";
        public Long city_code = Geo.DEFAULT_CITY_CODE;
        public String country = "";
        public String region_code = "";
        public String secondsFromGMT = "";
        public Double accuracy = Geo.DEFAULT_ACCURACY;

        public Builder accuracy(Double d10) {
            this.accuracy = d10;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Geo build() {
            return new Geo(this.lat, this.lon, this.language, this.timeZone, this.city_code, this.country, this.region_code, this.secondsFromGMT, this.accuracy, super.buildUnknownFields());
        }

        public Builder city_code(Long l10) {
            this.city_code = l10;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder lat(Float f10) {
            this.lat = f10;
            return this;
        }

        public Builder lon(Float f10) {
            this.lon = f10;
            return this;
        }

        public Builder region_code(String str) {
            this.region_code = str;
            return this;
        }

        public Builder secondsFromGMT(String str) {
            this.secondsFromGMT = str;
            return this;
        }

        public Builder timeZone(String str) {
            this.timeZone = str;
            return this;
        }
    }

    public static final class ProtoAdapter_Geo extends ProtoAdapter<Geo> {
        public ProtoAdapter_Geo() {
            super(FieldEncoding.LENGTH_DELIMITED, Geo.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Geo decode(ProtoReader protoReader) throws IOException {
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
                        builder.lat(ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 2:
                        builder.lon(ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 3:
                        builder.language(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 4:
                        builder.timeZone(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 5:
                        builder.city_code(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 6:
                        builder.country(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 7:
                        builder.region_code(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 8:
                        builder.secondsFromGMT(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 9:
                        builder.accuracy(ProtoAdapter.DOUBLE.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Geo geo) throws IOException {
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            protoAdapter.encodeWithTag(protoWriter, 1, geo.lat);
            protoAdapter.encodeWithTag(protoWriter, 2, geo.lon);
            ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
            protoAdapter2.encodeWithTag(protoWriter, 3, geo.language);
            protoAdapter2.encodeWithTag(protoWriter, 4, geo.timeZone);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 5, geo.city_code);
            protoAdapter2.encodeWithTag(protoWriter, 6, geo.country);
            protoAdapter2.encodeWithTag(protoWriter, 7, geo.region_code);
            protoAdapter2.encodeWithTag(protoWriter, 8, geo.secondsFromGMT);
            ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 9, geo.accuracy);
            protoWriter.writeBytes(geo.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Geo geo) {
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, geo.lat) + protoAdapter.encodedSizeWithTag(2, geo.lon);
            ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(3, geo.language) + protoAdapter2.encodedSizeWithTag(4, geo.timeZone) + ProtoAdapter.UINT64.encodedSizeWithTag(5, geo.city_code) + protoAdapter2.encodedSizeWithTag(6, geo.country) + protoAdapter2.encodedSizeWithTag(7, geo.region_code) + protoAdapter2.encodedSizeWithTag(8, geo.secondsFromGMT) + ProtoAdapter.DOUBLE.encodedSizeWithTag(9, geo.accuracy) + geo.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Geo redact(Geo geo) {
            Builder newBuilder = geo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Geo protoAdapter_Geo = new ProtoAdapter_Geo();
        ADAPTER = protoAdapter_Geo;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Geo);
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_LAT = valueOf;
        DEFAULT_LON = valueOf;
        DEFAULT_CITY_CODE = 0L;
        DEFAULT_ACCURACY = Double.valueOf(c.f27899e);
    }

    public Geo(Float f10, Float f11, String str, String str2, Long l10, String str3, String str4, String str5, Double d10) {
        this(f10, f11, str, str2, l10, str3, str4, str5, d10, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Geo)) {
            return false;
        }
        Geo geo = (Geo) obj;
        return unknownFields().equals(geo.unknownFields()) && Internal.equals(this.lat, geo.lat) && Internal.equals(this.lon, geo.lon) && Internal.equals(this.language, geo.language) && Internal.equals(this.timeZone, geo.timeZone) && Internal.equals(this.city_code, geo.city_code) && Internal.equals(this.country, geo.country) && Internal.equals(this.region_code, geo.region_code) && Internal.equals(this.secondsFromGMT, geo.secondsFromGMT) && Internal.equals(this.accuracy, geo.accuracy);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Float f10 = this.lat;
        int hashCode2 = (hashCode + (f10 != null ? f10.hashCode() : 0)) * 37;
        Float f11 = this.lon;
        int hashCode3 = (hashCode2 + (f11 != null ? f11.hashCode() : 0)) * 37;
        String str = this.language;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.timeZone;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l10 = this.city_code;
        int hashCode6 = (hashCode5 + (l10 != null ? l10.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.region_code;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.secondsFromGMT;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Double d10 = this.accuracy;
        int hashCode10 = hashCode9 + (d10 != null ? d10.hashCode() : 0);
        this.hashCode = hashCode10;
        return hashCode10;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.lat = this.lat;
        builder.lon = this.lon;
        builder.language = this.language;
        builder.timeZone = this.timeZone;
        builder.city_code = this.city_code;
        builder.country = this.country;
        builder.region_code = this.region_code;
        builder.secondsFromGMT = this.secondsFromGMT;
        builder.accuracy = this.accuracy;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.lat != null) {
            sb2.append(", lat=");
            sb2.append(this.lat);
        }
        if (this.lon != null) {
            sb2.append(", lon=");
            sb2.append(this.lon);
        }
        if (this.language != null) {
            sb2.append(", language=");
            sb2.append(this.language);
        }
        if (this.timeZone != null) {
            sb2.append(", timeZone=");
            sb2.append(this.timeZone);
        }
        if (this.city_code != null) {
            sb2.append(", city_code=");
            sb2.append(this.city_code);
        }
        if (this.country != null) {
            sb2.append(", country=");
            sb2.append(this.country);
        }
        if (this.region_code != null) {
            sb2.append(", region_code=");
            sb2.append(this.region_code);
        }
        if (this.secondsFromGMT != null) {
            sb2.append(", secondsFromGMT=");
            sb2.append(this.secondsFromGMT);
        }
        if (this.accuracy != null) {
            sb2.append(", accuracy=");
            sb2.append(this.accuracy);
        }
        StringBuilder replace = sb2.replace(0, 2, "Geo{");
        replace.append('}');
        return replace.toString();
    }

    public Geo(Float f10, Float f11, String str, String str2, Long l10, String str3, String str4, String str5, Double d10, ByteString byteString) {
        super(ADAPTER, byteString);
        this.lat = f10;
        this.lon = f11;
        this.language = str;
        this.timeZone = str2;
        this.city_code = l10;
        this.country = str3;
        this.region_code = str4;
        this.secondsFromGMT = str5;
        this.accuracy = d10;
    }
}

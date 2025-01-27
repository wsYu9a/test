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
import java.util.Map;

/* loaded from: classes2.dex */
public final class Network extends AndroidMessage<Network, Builder> {
    public static final ProtoAdapter<Network> ADAPTER;
    public static final Parcelable.Creator<Network> CREATOR;
    public static final String DEFAULT_CARRIER_NAME = "";
    public static final Integer DEFAULT_CONNECTION_TYPE;
    public static final String DEFAULT_IPV4 = "";
    public static final String DEFAULT_MAC = "";
    public static final String DEFAULT_OPERATOR = "";
    public static final Integer DEFAULT_OPERATOR_TYPE;
    public static final String DEFAULT_UA = "";
    public static final String DEFAULT_WIFI_ID = "";
    public static final String DEFAULT_WIFI_MAC = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String carrier_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer connection_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> ips;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String ipv4;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String mac;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String operator;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer operator_type;

    /* renamed from: ua */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String f8469ua;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String wifi_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String wifi_mac;

    public static final class Builder extends Message.Builder<Network, Builder> {
        public String ipv4 = "";
        public Integer connection_type = Network.DEFAULT_CONNECTION_TYPE;
        public Integer operator_type = Network.DEFAULT_OPERATOR_TYPE;

        /* renamed from: ua */
        public String f8470ua = "";
        public String operator = "";
        public String mac = "";
        public String wifi_mac = "";
        public String wifi_id = "";
        public String carrier_name = "";
        public Map<String, String> ips = Internal.newMutableMap();

        @Override // com.czhj.wire.Message.Builder
        public Network build() {
            return new Network(this.ipv4, this.connection_type, this.operator_type, this.f8470ua, this.operator, this.mac, this.wifi_mac, this.wifi_id, this.ips, this.carrier_name, super.buildUnknownFields());
        }

        public Builder carrier_name(String str) {
            this.carrier_name = str;
            return this;
        }

        public Builder connection_type(Integer num) {
            this.connection_type = num;
            return this;
        }

        public Builder ips(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.ips = map;
            return this;
        }

        public Builder ipv4(String str) {
            this.ipv4 = str;
            return this;
        }

        public Builder mac(String str) {
            this.mac = str;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder operator_type(Integer num) {
            this.operator_type = num;
            return this;
        }

        public Builder ua(String str) {
            this.f8470ua = str;
            return this;
        }

        public Builder wifi_id(String str) {
            this.wifi_id = str;
            return this;
        }

        public Builder wifi_mac(String str) {
            this.wifi_mac = str;
            return this;
        }
    }

    public static final class ProtoAdapter_Network extends ProtoAdapter<Network> {
        private final ProtoAdapter<Map<String, String>> ips;

        public ProtoAdapter_Network() {
            super(FieldEncoding.LENGTH_DELIMITED, Network.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.ips = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Network decode(ProtoReader protoReader) throws IOException {
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
                        builder.ipv4(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.connection_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.operator_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 4:
                        builder.ua(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 5:
                        builder.operator(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 6:
                        builder.mac(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 7:
                        builder.wifi_mac(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 8:
                        builder.wifi_id(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 9:
                        builder.ips.putAll(this.ips.decode(protoReader));
                        break;
                    case 10:
                        builder.carrier_name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Network network) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, network.ipv4);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.encodeWithTag(protoWriter, 2, network.connection_type);
            protoAdapter2.encodeWithTag(protoWriter, 3, network.operator_type);
            protoAdapter.encodeWithTag(protoWriter, 4, network.f8469ua);
            protoAdapter.encodeWithTag(protoWriter, 5, network.operator);
            protoAdapter.encodeWithTag(protoWriter, 6, network.mac);
            protoAdapter.encodeWithTag(protoWriter, 7, network.wifi_mac);
            protoAdapter.encodeWithTag(protoWriter, 8, network.wifi_id);
            this.ips.encodeWithTag(protoWriter, 9, network.ips);
            protoAdapter.encodeWithTag(protoWriter, 10, network.carrier_name);
            protoWriter.writeBytes(network.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Network network) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, network.ipv4);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(2, network.connection_type) + protoAdapter2.encodedSizeWithTag(3, network.operator_type) + protoAdapter.encodedSizeWithTag(4, network.f8469ua) + protoAdapter.encodedSizeWithTag(5, network.operator) + protoAdapter.encodedSizeWithTag(6, network.mac) + protoAdapter.encodedSizeWithTag(7, network.wifi_mac) + protoAdapter.encodedSizeWithTag(8, network.wifi_id) + this.ips.encodedSizeWithTag(9, network.ips) + protoAdapter.encodedSizeWithTag(10, network.carrier_name) + network.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Network redact(Network network) {
            Builder newBuilder = network.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Network protoAdapter_Network = new ProtoAdapter_Network();
        ADAPTER = protoAdapter_Network;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Network);
        DEFAULT_CONNECTION_TYPE = 0;
        DEFAULT_OPERATOR_TYPE = 0;
    }

    public Network(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, String str7) {
        this(str, num, num2, str2, str3, str4, str5, str6, map, str7, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        return unknownFields().equals(network.unknownFields()) && Internal.equals(this.ipv4, network.ipv4) && Internal.equals(this.connection_type, network.connection_type) && Internal.equals(this.operator_type, network.operator_type) && Internal.equals(this.f8469ua, network.f8469ua) && Internal.equals(this.operator, network.operator) && Internal.equals(this.mac, network.mac) && Internal.equals(this.wifi_mac, network.wifi_mac) && Internal.equals(this.wifi_id, network.wifi_id) && this.ips.equals(network.ips) && Internal.equals(this.carrier_name, network.carrier_name);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.ipv4;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.connection_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.operator_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.f8469ua;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.operator;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.mac;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.wifi_mac;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.wifi_id;
        int hashCode9 = (((hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37) + this.ips.hashCode()) * 37;
        String str7 = this.carrier_name;
        int hashCode10 = hashCode9 + (str7 != null ? str7.hashCode() : 0);
        this.hashCode = hashCode10;
        return hashCode10;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.ipv4 = this.ipv4;
        builder.connection_type = this.connection_type;
        builder.operator_type = this.operator_type;
        builder.f8470ua = this.f8469ua;
        builder.operator = this.operator;
        builder.mac = this.mac;
        builder.wifi_mac = this.wifi_mac;
        builder.wifi_id = this.wifi_id;
        builder.ips = Internal.copyOf("ips", this.ips);
        builder.carrier_name = this.carrier_name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.ipv4 != null) {
            sb2.append(", ipv4=");
            sb2.append(this.ipv4);
        }
        if (this.connection_type != null) {
            sb2.append(", connection_type=");
            sb2.append(this.connection_type);
        }
        if (this.operator_type != null) {
            sb2.append(", operator_type=");
            sb2.append(this.operator_type);
        }
        if (this.f8469ua != null) {
            sb2.append(", ua=");
            sb2.append(this.f8469ua);
        }
        if (this.operator != null) {
            sb2.append(", operator=");
            sb2.append(this.operator);
        }
        if (this.mac != null) {
            sb2.append(", mac=");
            sb2.append(this.mac);
        }
        if (this.wifi_mac != null) {
            sb2.append(", wifi_mac=");
            sb2.append(this.wifi_mac);
        }
        if (this.wifi_id != null) {
            sb2.append(", wifi_id=");
            sb2.append(this.wifi_id);
        }
        if (!this.ips.isEmpty()) {
            sb2.append(", ips=");
            sb2.append(this.ips);
        }
        if (this.carrier_name != null) {
            sb2.append(", carrier_name=");
            sb2.append(this.carrier_name);
        }
        StringBuilder replace = sb2.replace(0, 2, "Network{");
        replace.append('}');
        return replace.toString();
    }

    public Network(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, String str7, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ipv4 = str;
        this.connection_type = num;
        this.operator_type = num2;
        this.f8469ua = str2;
        this.operator = str3;
        this.mac = str4;
        this.wifi_mac = str5;
        this.wifi_id = str6;
        this.ips = Internal.immutableCopyOf("ips", map);
        this.carrier_name = str7;
    }
}

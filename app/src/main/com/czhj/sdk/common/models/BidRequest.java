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
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class BidRequest extends AndroidMessage<BidRequest, Builder> {
    public static final ProtoAdapter<BidRequest> ADAPTER;
    public static final Parcelable.Creator<BidRequest> CREATOR;
    public static final Boolean DEFAULT_AD_IS_EXPIRED;
    public static final Boolean DEFAULT_DISABLE_INSTALL_PACKAGE;
    public static final Boolean DEFAULT_DISABLE_MEDIATION;
    public static final String DEFAULT_REQUEST_ID = "";
    public static final Integer DEFAULT_REQUEST_SCENE_TYPE;
    public static final Long DEFAULT_REQ_TIMESTAMP;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean ad_is_expired;

    @WireField(adapter = "com.sigmob.sdk.common.models.Version#ADAPTER", tag = 2)
    public final Version api_version;

    @WireField(adapter = "com.sigmob.sdk.common.models.App#ADAPTER", tag = 3)
    public final App app;

    @WireField(adapter = "com.sigmob.sdk.common.models.Device#ADAPTER", tag = 4)
    public final Device device;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 23)
    public final Boolean disable_install_package;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean disable_mediation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    public final Map<String, String> ext_options;

    @WireField(adapter = "com.sigmob.sdk.common.models.HeaderBidding#ADAPTER", label = WireField.Label.REPEATED, tag = 18)
    public final List<HeaderBidding> hbs;

    @WireField(adapter = "com.sigmob.sdk.common.models.HeaderBidding#ADAPTER", tag = 16)
    public final HeaderBidding header_bidding;

    @WireField(adapter = "com.sigmob.sdk.common.models.Network#ADAPTER", tag = 5)
    public final Network network;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final Map<String, String> options;

    @WireField(adapter = "com.sigmob.sdk.common.models.Privacy#ADAPTER", tag = 10)
    public final Privacy privacy;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    public final Long req_timestamp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String request_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer request_scene_type;

    @WireField(adapter = "com.sigmob.sdk.common.models.Version#ADAPTER", tag = 20)
    public final Version sdk_version;

    @WireField(adapter = "com.sigmob.sdk.common.models.AdSlot#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<AdSlot> slots;

    @WireField(adapter = "com.sigmob.sdk.common.models.User#ADAPTER", tag = 17)
    public final User user;

    @WireField(adapter = "com.sigmob.sdk.common.models.WXProgramReq#ADAPTER", tag = 21)
    public final WXProgramReq wx_program_req;

    public static final class Builder extends Message.Builder<BidRequest, Builder> {
        public Boolean ad_is_expired;
        public Version api_version;
        public App app;
        public Device device;
        public Boolean disable_install_package;
        public Boolean disable_mediation;
        public HeaderBidding header_bidding;
        public Network network;
        public Privacy privacy;
        public Long req_timestamp;
        public String request_id;
        public Integer request_scene_type;
        public Version sdk_version;
        public User user;
        public WXProgramReq wx_program_req;
        public List<AdSlot> slots = Internal.newMutableList();
        public Map<String, String> options = Internal.newMutableMap();
        public List<HeaderBidding> hbs = Internal.newMutableList();
        public Map<String, String> ext_options = Internal.newMutableMap();

        public Builder ad_is_expired(Boolean bool) {
            this.ad_is_expired = bool;
            return this;
        }

        public Builder api_version(Version version) {
            this.api_version = version;
            return this;
        }

        public Builder app(App app) {
            this.app = app;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public BidRequest build() {
            return new BidRequest(this.request_id, this.api_version, this.app, this.device, this.network, this.slots, this.req_timestamp, this.request_scene_type, this.ad_is_expired, this.privacy, this.disable_mediation, this.options, this.header_bidding, this.user, this.hbs, this.ext_options, this.sdk_version, this.wx_program_req, this.disable_install_package, super.buildUnknownFields());
        }

        public Builder device(Device device) {
            this.device = device;
            return this;
        }

        public Builder disable_install_package(Boolean bool) {
            this.disable_install_package = bool;
            return this;
        }

        public Builder disable_mediation(Boolean bool) {
            this.disable_mediation = bool;
            return this;
        }

        public Builder ext_options(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.ext_options = map;
            return this;
        }

        public Builder hbs(List<HeaderBidding> list) {
            Internal.checkElementsNotNull(list);
            this.hbs = list;
            return this;
        }

        public Builder header_bidding(HeaderBidding headerBidding) {
            this.header_bidding = headerBidding;
            return this;
        }

        public Builder network(Network network) {
            this.network = network;
            return this;
        }

        public Builder options(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.options = map;
            return this;
        }

        public Builder privacy(Privacy privacy) {
            this.privacy = privacy;
            return this;
        }

        public Builder req_timestamp(Long l10) {
            this.req_timestamp = l10;
            return this;
        }

        public Builder request_id(String str) {
            this.request_id = str;
            return this;
        }

        public Builder request_scene_type(Integer num) {
            this.request_scene_type = num;
            return this;
        }

        public Builder sdk_version(Version version) {
            this.sdk_version = version;
            return this;
        }

        public Builder slots(List<AdSlot> list) {
            Internal.checkElementsNotNull(list);
            this.slots = list;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder wx_program_req(WXProgramReq wXProgramReq) {
            this.wx_program_req = wXProgramReq;
            return this;
        }
    }

    public static final class ProtoAdapter_BidRequest extends ProtoAdapter<BidRequest> {
        private final ProtoAdapter<Map<String, String>> ext_options;
        private final ProtoAdapter<Map<String, String>> options;

        public ProtoAdapter_BidRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BidRequest.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.options = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
            this.ext_options = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public BidRequest decode(ProtoReader protoReader) throws IOException {
            List list;
            Parcelable parcelable;
            Map<String, String> map;
            ProtoAdapter<Map<String, String>> protoAdapter;
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
                        builder.request_id(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.api_version(Version.ADAPTER.decode(protoReader));
                        break;
                    case 3:
                        builder.app(App.ADAPTER.decode(protoReader));
                        break;
                    case 4:
                        builder.device(Device.ADAPTER.decode(protoReader));
                        break;
                    case 5:
                        builder.network(Network.ADAPTER.decode(protoReader));
                        break;
                    case 6:
                        list = builder.slots;
                        parcelable = (AdSlot) AdSlot.ADAPTER.decode(protoReader);
                        list.add(parcelable);
                        break;
                    case 7:
                        builder.req_timestamp(ProtoAdapter.INT64.decode(protoReader));
                        break;
                    case 8:
                        builder.request_scene_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 9:
                        builder.ad_is_expired(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 10:
                        builder.privacy(Privacy.ADAPTER.decode(protoReader));
                        break;
                    case 11:
                        builder.disable_mediation(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 12:
                    case 13:
                    case 14:
                    case 22:
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                    case 15:
                        map = builder.options;
                        protoAdapter = this.options;
                        map.putAll(protoAdapter.decode(protoReader));
                        break;
                    case 16:
                        builder.header_bidding(HeaderBidding.ADAPTER.decode(protoReader));
                        break;
                    case 17:
                        builder.user(User.ADAPTER.decode(protoReader));
                        break;
                    case 18:
                        list = builder.hbs;
                        parcelable = (HeaderBidding) HeaderBidding.ADAPTER.decode(protoReader);
                        list.add(parcelable);
                        break;
                    case 19:
                        map = builder.ext_options;
                        protoAdapter = this.ext_options;
                        map.putAll(protoAdapter.decode(protoReader));
                        break;
                    case 20:
                        builder.sdk_version(Version.ADAPTER.decode(protoReader));
                        break;
                    case 21:
                        builder.wx_program_req(WXProgramReq.ADAPTER.decode(protoReader));
                        break;
                    case 23:
                        builder.disable_install_package(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, BidRequest bidRequest) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, bidRequest.request_id);
            ProtoAdapter<Version> protoAdapter = Version.ADAPTER;
            protoAdapter.encodeWithTag(protoWriter, 2, bidRequest.api_version);
            App.ADAPTER.encodeWithTag(protoWriter, 3, bidRequest.app);
            Device.ADAPTER.encodeWithTag(protoWriter, 4, bidRequest.device);
            Network.ADAPTER.encodeWithTag(protoWriter, 5, bidRequest.network);
            AdSlot.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, bidRequest.slots);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 7, bidRequest.req_timestamp);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 8, bidRequest.request_scene_type);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 9, bidRequest.ad_is_expired);
            Privacy.ADAPTER.encodeWithTag(protoWriter, 10, bidRequest.privacy);
            protoAdapter2.encodeWithTag(protoWriter, 11, bidRequest.disable_mediation);
            this.options.encodeWithTag(protoWriter, 15, bidRequest.options);
            ProtoAdapter<HeaderBidding> protoAdapter3 = HeaderBidding.ADAPTER;
            protoAdapter3.encodeWithTag(protoWriter, 16, bidRequest.header_bidding);
            User.ADAPTER.encodeWithTag(protoWriter, 17, bidRequest.user);
            protoAdapter3.asRepeated().encodeWithTag(protoWriter, 18, bidRequest.hbs);
            this.ext_options.encodeWithTag(protoWriter, 19, bidRequest.ext_options);
            protoAdapter.encodeWithTag(protoWriter, 20, bidRequest.sdk_version);
            WXProgramReq.ADAPTER.encodeWithTag(protoWriter, 21, bidRequest.wx_program_req);
            protoAdapter2.encodeWithTag(protoWriter, 23, bidRequest.disable_install_package);
            protoWriter.writeBytes(bidRequest.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(BidRequest bidRequest) {
            int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, bidRequest.request_id);
            ProtoAdapter<Version> protoAdapter = Version.ADAPTER;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter.encodedSizeWithTag(2, bidRequest.api_version) + App.ADAPTER.encodedSizeWithTag(3, bidRequest.app) + Device.ADAPTER.encodedSizeWithTag(4, bidRequest.device) + Network.ADAPTER.encodedSizeWithTag(5, bidRequest.network) + AdSlot.ADAPTER.asRepeated().encodedSizeWithTag(6, bidRequest.slots) + ProtoAdapter.INT64.encodedSizeWithTag(7, bidRequest.req_timestamp) + ProtoAdapter.UINT32.encodedSizeWithTag(8, bidRequest.request_scene_type);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter2.encodedSizeWithTag(9, bidRequest.ad_is_expired) + Privacy.ADAPTER.encodedSizeWithTag(10, bidRequest.privacy) + protoAdapter2.encodedSizeWithTag(11, bidRequest.disable_mediation) + this.options.encodedSizeWithTag(15, bidRequest.options);
            ProtoAdapter<HeaderBidding> protoAdapter3 = HeaderBidding.ADAPTER;
            return encodedSizeWithTag3 + protoAdapter3.encodedSizeWithTag(16, bidRequest.header_bidding) + User.ADAPTER.encodedSizeWithTag(17, bidRequest.user) + protoAdapter3.asRepeated().encodedSizeWithTag(18, bidRequest.hbs) + this.ext_options.encodedSizeWithTag(19, bidRequest.ext_options) + protoAdapter.encodedSizeWithTag(20, bidRequest.sdk_version) + WXProgramReq.ADAPTER.encodedSizeWithTag(21, bidRequest.wx_program_req) + protoAdapter2.encodedSizeWithTag(23, bidRequest.disable_install_package) + bidRequest.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public BidRequest redact(BidRequest bidRequest) {
            Builder newBuilder = bidRequest.newBuilder();
            Version version = newBuilder.api_version;
            if (version != null) {
                newBuilder.api_version = Version.ADAPTER.redact(version);
            }
            App app = newBuilder.app;
            if (app != null) {
                newBuilder.app = App.ADAPTER.redact(app);
            }
            Device device = newBuilder.device;
            if (device != null) {
                newBuilder.device = Device.ADAPTER.redact(device);
            }
            Network network = newBuilder.network;
            if (network != null) {
                newBuilder.network = Network.ADAPTER.redact(network);
            }
            Internal.redactElements(newBuilder.slots, AdSlot.ADAPTER);
            Privacy privacy = newBuilder.privacy;
            if (privacy != null) {
                newBuilder.privacy = Privacy.ADAPTER.redact(privacy);
            }
            HeaderBidding headerBidding = newBuilder.header_bidding;
            if (headerBidding != null) {
                newBuilder.header_bidding = HeaderBidding.ADAPTER.redact(headerBidding);
            }
            User user = newBuilder.user;
            if (user != null) {
                newBuilder.user = User.ADAPTER.redact(user);
            }
            Internal.redactElements(newBuilder.hbs, HeaderBidding.ADAPTER);
            Version version2 = newBuilder.sdk_version;
            if (version2 != null) {
                newBuilder.sdk_version = Version.ADAPTER.redact(version2);
            }
            WXProgramReq wXProgramReq = newBuilder.wx_program_req;
            if (wXProgramReq != null) {
                newBuilder.wx_program_req = WXProgramReq.ADAPTER.redact(wXProgramReq);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_BidRequest protoAdapter_BidRequest = new ProtoAdapter_BidRequest();
        ADAPTER = protoAdapter_BidRequest;
        CREATOR = AndroidMessage.newCreator(protoAdapter_BidRequest);
        DEFAULT_REQ_TIMESTAMP = 0L;
        DEFAULT_REQUEST_SCENE_TYPE = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_AD_IS_EXPIRED = bool;
        DEFAULT_DISABLE_MEDIATION = bool;
        DEFAULT_DISABLE_INSTALL_PACKAGE = bool;
    }

    public BidRequest(String str, Version version, App app, Device device, Network network, List<AdSlot> list, Long l10, Integer num, Boolean bool, Privacy privacy, Boolean bool2, Map<String, String> map, HeaderBidding headerBidding, User user, List<HeaderBidding> list2, Map<String, String> map2, Version version2, WXProgramReq wXProgramReq, Boolean bool3) {
        this(str, version, app, device, network, list, l10, num, bool, privacy, bool2, map, headerBidding, user, list2, map2, version2, wXProgramReq, bool3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BidRequest)) {
            return false;
        }
        BidRequest bidRequest = (BidRequest) obj;
        return unknownFields().equals(bidRequest.unknownFields()) && Internal.equals(this.request_id, bidRequest.request_id) && Internal.equals(this.api_version, bidRequest.api_version) && Internal.equals(this.app, bidRequest.app) && Internal.equals(this.device, bidRequest.device) && Internal.equals(this.network, bidRequest.network) && this.slots.equals(bidRequest.slots) && Internal.equals(this.req_timestamp, bidRequest.req_timestamp) && Internal.equals(this.request_scene_type, bidRequest.request_scene_type) && Internal.equals(this.ad_is_expired, bidRequest.ad_is_expired) && Internal.equals(this.privacy, bidRequest.privacy) && Internal.equals(this.disable_mediation, bidRequest.disable_mediation) && this.options.equals(bidRequest.options) && Internal.equals(this.header_bidding, bidRequest.header_bidding) && Internal.equals(this.user, bidRequest.user) && this.hbs.equals(bidRequest.hbs) && this.ext_options.equals(bidRequest.ext_options) && Internal.equals(this.sdk_version, bidRequest.sdk_version) && Internal.equals(this.wx_program_req, bidRequest.wx_program_req) && Internal.equals(this.disable_install_package, bidRequest.disable_install_package);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.request_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Version version = this.api_version;
        int hashCode3 = (hashCode2 + (version != null ? version.hashCode() : 0)) * 37;
        App app = this.app;
        int hashCode4 = (hashCode3 + (app != null ? app.hashCode() : 0)) * 37;
        Device device = this.device;
        int hashCode5 = (hashCode4 + (device != null ? device.hashCode() : 0)) * 37;
        Network network = this.network;
        int hashCode6 = (((hashCode5 + (network != null ? network.hashCode() : 0)) * 37) + this.slots.hashCode()) * 37;
        Long l10 = this.req_timestamp;
        int hashCode7 = (hashCode6 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Integer num = this.request_scene_type;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.ad_is_expired;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Privacy privacy = this.privacy;
        int hashCode10 = (hashCode9 + (privacy != null ? privacy.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_mediation;
        int hashCode11 = (((hashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 37) + this.options.hashCode()) * 37;
        HeaderBidding headerBidding = this.header_bidding;
        int hashCode12 = (hashCode11 + (headerBidding != null ? headerBidding.hashCode() : 0)) * 37;
        User user = this.user;
        int hashCode13 = (((((hashCode12 + (user != null ? user.hashCode() : 0)) * 37) + this.hbs.hashCode()) * 37) + this.ext_options.hashCode()) * 37;
        Version version2 = this.sdk_version;
        int hashCode14 = (hashCode13 + (version2 != null ? version2.hashCode() : 0)) * 37;
        WXProgramReq wXProgramReq = this.wx_program_req;
        int hashCode15 = (hashCode14 + (wXProgramReq != null ? wXProgramReq.hashCode() : 0)) * 37;
        Boolean bool3 = this.disable_install_package;
        int hashCode16 = hashCode15 + (bool3 != null ? bool3.hashCode() : 0);
        this.hashCode = hashCode16;
        return hashCode16;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.request_id = this.request_id;
        builder.api_version = this.api_version;
        builder.app = this.app;
        builder.device = this.device;
        builder.network = this.network;
        builder.slots = Internal.copyOf("slots", this.slots);
        builder.req_timestamp = this.req_timestamp;
        builder.request_scene_type = this.request_scene_type;
        builder.ad_is_expired = this.ad_is_expired;
        builder.privacy = this.privacy;
        builder.disable_mediation = this.disable_mediation;
        builder.options = Internal.copyOf("options", this.options);
        builder.header_bidding = this.header_bidding;
        builder.user = this.user;
        builder.hbs = Internal.copyOf("hbs", this.hbs);
        builder.ext_options = Internal.copyOf("ext_options", this.ext_options);
        builder.sdk_version = this.sdk_version;
        builder.wx_program_req = this.wx_program_req;
        builder.disable_install_package = this.disable_install_package;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.request_id != null) {
            sb2.append(", request_id=");
            sb2.append(this.request_id);
        }
        if (this.api_version != null) {
            sb2.append(", api_version=");
            sb2.append(this.api_version);
        }
        if (this.app != null) {
            sb2.append(", app=");
            sb2.append(this.app);
        }
        if (this.device != null) {
            sb2.append(", device=");
            sb2.append(this.device);
        }
        if (this.network != null) {
            sb2.append(", network=");
            sb2.append(this.network);
        }
        if (!this.slots.isEmpty()) {
            sb2.append(", slots=");
            sb2.append(this.slots);
        }
        if (this.req_timestamp != null) {
            sb2.append(", req_timestamp=");
            sb2.append(this.req_timestamp);
        }
        if (this.request_scene_type != null) {
            sb2.append(", request_scene_type=");
            sb2.append(this.request_scene_type);
        }
        if (this.ad_is_expired != null) {
            sb2.append(", ad_is_expired=");
            sb2.append(this.ad_is_expired);
        }
        if (this.privacy != null) {
            sb2.append(", privacy=");
            sb2.append(this.privacy);
        }
        if (this.disable_mediation != null) {
            sb2.append(", disable_mediation=");
            sb2.append(this.disable_mediation);
        }
        if (!this.options.isEmpty()) {
            sb2.append(", options=");
            sb2.append(this.options);
        }
        if (this.header_bidding != null) {
            sb2.append(", header_bidding=");
            sb2.append(this.header_bidding);
        }
        if (this.user != null) {
            sb2.append(", user=");
            sb2.append(this.user);
        }
        if (!this.hbs.isEmpty()) {
            sb2.append(", hbs=");
            sb2.append(this.hbs);
        }
        if (!this.ext_options.isEmpty()) {
            sb2.append(", ext_options=");
            sb2.append(this.ext_options);
        }
        if (this.sdk_version != null) {
            sb2.append(", sdk_version=");
            sb2.append(this.sdk_version);
        }
        if (this.wx_program_req != null) {
            sb2.append(", wx_program_req=");
            sb2.append(this.wx_program_req);
        }
        if (this.disable_install_package != null) {
            sb2.append(", disable_install_package=");
            sb2.append(this.disable_install_package);
        }
        StringBuilder replace = sb2.replace(0, 2, "BidRequest{");
        replace.append('}');
        return replace.toString();
    }

    public BidRequest(String str, Version version, App app, Device device, Network network, List<AdSlot> list, Long l10, Integer num, Boolean bool, Privacy privacy, Boolean bool2, Map<String, String> map, HeaderBidding headerBidding, User user, List<HeaderBidding> list2, Map<String, String> map2, Version version2, WXProgramReq wXProgramReq, Boolean bool3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.request_id = str;
        this.api_version = version;
        this.app = app;
        this.device = device;
        this.network = network;
        this.slots = Internal.immutableCopyOf("slots", list);
        this.req_timestamp = l10;
        this.request_scene_type = num;
        this.ad_is_expired = bool;
        this.privacy = privacy;
        this.disable_mediation = bool2;
        this.options = Internal.immutableCopyOf("options", map);
        this.header_bidding = headerBidding;
        this.user = user;
        this.hbs = Internal.immutableCopyOf("hbs", list2);
        this.ext_options = Internal.immutableCopyOf("ext_options", map2);
        this.sdk_version = version2;
        this.wx_program_req = wXProgramReq;
        this.disable_install_package = bool3;
    }
}

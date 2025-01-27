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
public final class AdSlot extends AndroidMessage<AdSlot, Builder> {
    public static final ProtoAdapter<AdSlot> ADAPTER;
    public static final Parcelable.Creator<AdSlot> CREATOR;
    public static final String DEFAULT_ADSLOT_ID = "";
    public static final Integer DEFAULT_ADX_ECPM;
    public static final Integer DEFAULT_AD_COUNT;
    public static final Integer DEFAULT_ALGORITHM_FLOOR;
    public static final Integer DEFAULT_ALG_BID_TYPE;
    public static final Integer DEFAULT_API_STRATEGY_INDEX;
    public static final Integer DEFAULT_BIDFLOOR;
    public static final Integer DEFAULT_COMMER_ECPM;
    public static final Integer DEFAULT_COMMER_ECPM_STATE;
    public static final Boolean DEFAULT_DISABLE_MRAID2;
    public static final Integer DEFAULT_ECPM_TARGET;
    public static final Integer DEFAULT_EXPECTED_FLOOR;
    public static final String DEFAULT_LATEST_CAMP_ID = "";
    public static final String DEFAULT_LATEST_CRID = "";
    public static final Integer DEFAULT_SDK_STRATEGY_INDEX;
    public static final Integer DEFAULT_SETTLEMENT_MODE;
    public static final Integer DEFAULT_SETTLEMENT_SETTING;
    public static final String DEFAULT_VID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.common.models.AdCache#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final Map<String, AdCache> ad_caches;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 28)
    public final Integer ad_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String adslot_id;

    @WireField(adapter = "com.sigmob.sdk.common.models.Size#ADAPTER", tag = 2)
    public final Size adslot_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 3)
    public final List<Integer> adslot_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 24)
    public final Integer adx_ecpm;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 20)
    public final Integer alg_bid_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 13)
    public final Integer algorithm_floor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer api_strategy_index;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer bidfloor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 23)
    public final Integer commer_ecpm;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 25)
    public final Integer commer_ecpm_state;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 12)
    public final List<Integer> creative_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 48)
    public final Boolean disable_mraid2;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 21)
    public final Integer ecpm_target;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 17)
    public final Integer expected_floor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final Map<String, String> ext;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String latest_camp_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String latest_crid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 8)
    public final List<Integer> material_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final Map<String, String> sdk_cached_ads;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer sdk_strategy_index;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 19)
    public final Integer settlement_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 22)
    public final Integer settlement_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 46)
    public final List<Integer> support_template_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String vid;

    @WireField(adapter = "com.sigmob.sdk.common.models.Video#ADAPTER", tag = 16)
    public final Video video;

    public static final class Builder extends Message.Builder<AdSlot, Builder> {
        public Integer ad_count;
        public String adslot_id;
        public Size adslot_size;
        public Integer adx_ecpm;
        public Integer alg_bid_type;
        public Integer algorithm_floor;
        public Integer api_strategy_index;
        public Integer bidfloor;
        public Integer commer_ecpm;
        public Integer commer_ecpm_state;
        public Boolean disable_mraid2;
        public Integer ecpm_target;
        public Integer expected_floor;
        public String latest_camp_id;
        public String latest_crid;
        public Integer sdk_strategy_index;
        public Integer settlement_mode;
        public Integer settlement_setting;
        public String vid;
        public Video video;
        public List<Integer> adslot_type = Internal.newMutableList();
        public List<Integer> material_type = Internal.newMutableList();
        public Map<String, String> sdk_cached_ads = Internal.newMutableMap();
        public List<Integer> creative_type = Internal.newMutableList();
        public Map<String, String> ext = Internal.newMutableMap();
        public Map<String, AdCache> ad_caches = Internal.newMutableMap();
        public List<Integer> support_template_id = Internal.newMutableList();

        public Builder ad_caches(Map<String, AdCache> map) {
            Internal.checkElementsNotNull(map);
            this.ad_caches = map;
            return this;
        }

        public Builder ad_count(Integer num) {
            this.ad_count = num;
            return this;
        }

        public Builder adslot_id(String str) {
            this.adslot_id = str;
            return this;
        }

        public Builder adslot_size(Size size) {
            this.adslot_size = size;
            return this;
        }

        public Builder adslot_type(List<Integer> list) {
            Internal.checkElementsNotNull(list);
            this.adslot_type = list;
            return this;
        }

        public Builder adx_ecpm(Integer num) {
            this.adx_ecpm = num;
            return this;
        }

        public Builder alg_bid_type(Integer num) {
            this.alg_bid_type = num;
            return this;
        }

        public Builder algorithm_floor(Integer num) {
            this.algorithm_floor = num;
            return this;
        }

        public Builder api_strategy_index(Integer num) {
            this.api_strategy_index = num;
            return this;
        }

        public Builder bidfloor(Integer num) {
            this.bidfloor = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public AdSlot build() {
            return new AdSlot(this.adslot_id, this.adslot_size, this.adslot_type, this.bidfloor, this.vid, this.latest_camp_id, this.latest_crid, this.material_type, this.sdk_strategy_index, this.api_strategy_index, this.sdk_cached_ads, this.creative_type, this.algorithm_floor, this.ext, this.ad_caches, this.video, this.expected_floor, this.settlement_mode, this.alg_bid_type, this.ecpm_target, this.settlement_setting, this.commer_ecpm, this.adx_ecpm, this.commer_ecpm_state, this.ad_count, this.support_template_id, this.disable_mraid2, super.buildUnknownFields());
        }

        public Builder commer_ecpm(Integer num) {
            this.commer_ecpm = num;
            return this;
        }

        public Builder commer_ecpm_state(Integer num) {
            this.commer_ecpm_state = num;
            return this;
        }

        public Builder creative_type(List<Integer> list) {
            Internal.checkElementsNotNull(list);
            this.creative_type = list;
            return this;
        }

        public Builder disable_mraid2(Boolean bool) {
            this.disable_mraid2 = bool;
            return this;
        }

        public Builder ecpm_target(Integer num) {
            this.ecpm_target = num;
            return this;
        }

        public Builder expected_floor(Integer num) {
            this.expected_floor = num;
            return this;
        }

        public Builder ext(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.ext = map;
            return this;
        }

        public Builder latest_camp_id(String str) {
            this.latest_camp_id = str;
            return this;
        }

        public Builder latest_crid(String str) {
            this.latest_crid = str;
            return this;
        }

        public Builder material_type(List<Integer> list) {
            Internal.checkElementsNotNull(list);
            this.material_type = list;
            return this;
        }

        public Builder sdk_cached_ads(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.sdk_cached_ads = map;
            return this;
        }

        public Builder sdk_strategy_index(Integer num) {
            this.sdk_strategy_index = num;
            return this;
        }

        public Builder settlement_mode(Integer num) {
            this.settlement_mode = num;
            return this;
        }

        public Builder settlement_setting(Integer num) {
            this.settlement_setting = num;
            return this;
        }

        public Builder support_template_id(List<Integer> list) {
            Internal.checkElementsNotNull(list);
            this.support_template_id = list;
            return this;
        }

        public Builder vid(String str) {
            this.vid = str;
            return this;
        }

        public Builder video(Video video) {
            this.video = video;
            return this;
        }
    }

    public static final class ProtoAdapter_AdSlot extends ProtoAdapter<AdSlot> {
        private final ProtoAdapter<Map<String, AdCache>> ad_caches;
        private final ProtoAdapter<Map<String, String>> ext;
        private final ProtoAdapter<Map<String, String>> sdk_cached_ads;

        public ProtoAdapter_AdSlot() {
            super(FieldEncoding.LENGTH_DELIMITED, AdSlot.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.sdk_cached_ads = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
            this.ext = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
            this.ad_caches = ProtoAdapter.newMapAdapter(protoAdapter, AdCache.ADAPTER);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public AdSlot decode(ProtoReader protoReader) throws IOException {
            List<Integer> list;
            Map map;
            ProtoAdapter protoAdapter;
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag != 28) {
                    if (nextTag == 46) {
                        list = builder.support_template_id;
                    } else if (nextTag != 48) {
                        switch (nextTag) {
                            case 1:
                                builder.adslot_id(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 2:
                                builder.adslot_size(Size.ADAPTER.decode(protoReader));
                                break;
                            case 3:
                                list = builder.adslot_type;
                                break;
                            case 4:
                                builder.bidfloor(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 5:
                                builder.vid(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 6:
                                builder.latest_camp_id(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 7:
                                builder.latest_crid(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 8:
                                list = builder.material_type;
                                break;
                            case 9:
                                builder.sdk_strategy_index(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 10:
                                builder.api_strategy_index(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 11:
                                map = builder.sdk_cached_ads;
                                protoAdapter = this.sdk_cached_ads;
                                map.putAll((Map) protoAdapter.decode(protoReader));
                                break;
                            case 12:
                                list = builder.creative_type;
                                break;
                            case 13:
                                builder.algorithm_floor(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 14:
                                map = builder.ext;
                                protoAdapter = this.ext;
                                map.putAll((Map) protoAdapter.decode(protoReader));
                                break;
                            case 15:
                                map = builder.ad_caches;
                                protoAdapter = this.ad_caches;
                                map.putAll((Map) protoAdapter.decode(protoReader));
                                break;
                            case 16:
                                builder.video(Video.ADAPTER.decode(protoReader));
                                break;
                            case 17:
                                builder.expected_floor(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            default:
                                switch (nextTag) {
                                    case 19:
                                        builder.settlement_mode(ProtoAdapter.UINT32.decode(protoReader));
                                        break;
                                    case 20:
                                        builder.alg_bid_type(ProtoAdapter.UINT32.decode(protoReader));
                                        break;
                                    case 21:
                                        builder.ecpm_target(ProtoAdapter.UINT32.decode(protoReader));
                                        break;
                                    case 22:
                                        builder.settlement_setting(ProtoAdapter.UINT32.decode(protoReader));
                                        break;
                                    case 23:
                                        builder.commer_ecpm(ProtoAdapter.UINT32.decode(protoReader));
                                        break;
                                    case 24:
                                        builder.adx_ecpm(ProtoAdapter.UINT32.decode(protoReader));
                                        break;
                                    case 25:
                                        builder.commer_ecpm_state(ProtoAdapter.UINT32.decode(protoReader));
                                        break;
                                    default:
                                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                        break;
                                }
                        }
                    } else {
                        builder.disable_mraid2(ProtoAdapter.BOOL.decode(protoReader));
                    }
                    list.add(ProtoAdapter.UINT32.decode(protoReader));
                } else {
                    builder.ad_count(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, AdSlot adSlot) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, adSlot.adslot_id);
            Size.ADAPTER.encodeWithTag(protoWriter, 2, adSlot.adslot_size);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 3, adSlot.adslot_type);
            protoAdapter2.encodeWithTag(protoWriter, 4, adSlot.bidfloor);
            protoAdapter.encodeWithTag(protoWriter, 5, adSlot.vid);
            protoAdapter.encodeWithTag(protoWriter, 6, adSlot.latest_camp_id);
            protoAdapter.encodeWithTag(protoWriter, 7, adSlot.latest_crid);
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 8, adSlot.material_type);
            protoAdapter2.encodeWithTag(protoWriter, 9, adSlot.sdk_strategy_index);
            protoAdapter2.encodeWithTag(protoWriter, 10, adSlot.api_strategy_index);
            this.sdk_cached_ads.encodeWithTag(protoWriter, 11, adSlot.sdk_cached_ads);
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 12, adSlot.creative_type);
            protoAdapter2.encodeWithTag(protoWriter, 13, adSlot.algorithm_floor);
            this.ext.encodeWithTag(protoWriter, 14, adSlot.ext);
            this.ad_caches.encodeWithTag(protoWriter, 15, adSlot.ad_caches);
            Video.ADAPTER.encodeWithTag(protoWriter, 16, adSlot.video);
            protoAdapter2.encodeWithTag(protoWriter, 17, adSlot.expected_floor);
            protoAdapter2.encodeWithTag(protoWriter, 19, adSlot.settlement_mode);
            protoAdapter2.encodeWithTag(protoWriter, 20, adSlot.alg_bid_type);
            protoAdapter2.encodeWithTag(protoWriter, 21, adSlot.ecpm_target);
            protoAdapter2.encodeWithTag(protoWriter, 22, adSlot.settlement_setting);
            protoAdapter2.encodeWithTag(protoWriter, 23, adSlot.commer_ecpm);
            protoAdapter2.encodeWithTag(protoWriter, 24, adSlot.adx_ecpm);
            protoAdapter2.encodeWithTag(protoWriter, 25, adSlot.commer_ecpm_state);
            protoAdapter2.encodeWithTag(protoWriter, 28, adSlot.ad_count);
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 46, adSlot.support_template_id);
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 48, adSlot.disable_mraid2);
            protoWriter.writeBytes(adSlot.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(AdSlot adSlot) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, adSlot.adslot_id) + Size.ADAPTER.encodedSizeWithTag(2, adSlot.adslot_size);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            return encodedSizeWithTag + protoAdapter2.asRepeated().encodedSizeWithTag(3, adSlot.adslot_type) + protoAdapter2.encodedSizeWithTag(4, adSlot.bidfloor) + protoAdapter.encodedSizeWithTag(5, adSlot.vid) + protoAdapter.encodedSizeWithTag(6, adSlot.latest_camp_id) + protoAdapter.encodedSizeWithTag(7, adSlot.latest_crid) + protoAdapter2.asRepeated().encodedSizeWithTag(8, adSlot.material_type) + protoAdapter2.encodedSizeWithTag(9, adSlot.sdk_strategy_index) + protoAdapter2.encodedSizeWithTag(10, adSlot.api_strategy_index) + this.sdk_cached_ads.encodedSizeWithTag(11, adSlot.sdk_cached_ads) + protoAdapter2.asRepeated().encodedSizeWithTag(12, adSlot.creative_type) + protoAdapter2.encodedSizeWithTag(13, adSlot.algorithm_floor) + this.ext.encodedSizeWithTag(14, adSlot.ext) + this.ad_caches.encodedSizeWithTag(15, adSlot.ad_caches) + Video.ADAPTER.encodedSizeWithTag(16, adSlot.video) + protoAdapter2.encodedSizeWithTag(17, adSlot.expected_floor) + protoAdapter2.encodedSizeWithTag(19, adSlot.settlement_mode) + protoAdapter2.encodedSizeWithTag(20, adSlot.alg_bid_type) + protoAdapter2.encodedSizeWithTag(21, adSlot.ecpm_target) + protoAdapter2.encodedSizeWithTag(22, adSlot.settlement_setting) + protoAdapter2.encodedSizeWithTag(23, adSlot.commer_ecpm) + protoAdapter2.encodedSizeWithTag(24, adSlot.adx_ecpm) + protoAdapter2.encodedSizeWithTag(25, adSlot.commer_ecpm_state) + protoAdapter2.encodedSizeWithTag(28, adSlot.ad_count) + protoAdapter2.asRepeated().encodedSizeWithTag(46, adSlot.support_template_id) + ProtoAdapter.BOOL.encodedSizeWithTag(48, adSlot.disable_mraid2) + adSlot.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public AdSlot redact(AdSlot adSlot) {
            Builder newBuilder = adSlot.newBuilder();
            Size size = newBuilder.adslot_size;
            if (size != null) {
                newBuilder.adslot_size = Size.ADAPTER.redact(size);
            }
            Internal.redactElements(newBuilder.ad_caches, AdCache.ADAPTER);
            Video video = newBuilder.video;
            if (video != null) {
                newBuilder.video = Video.ADAPTER.redact(video);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdSlot protoAdapter_AdSlot = new ProtoAdapter_AdSlot();
        ADAPTER = protoAdapter_AdSlot;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdSlot);
        DEFAULT_BIDFLOOR = 0;
        DEFAULT_SDK_STRATEGY_INDEX = 0;
        DEFAULT_API_STRATEGY_INDEX = 0;
        DEFAULT_ALGORITHM_FLOOR = 0;
        DEFAULT_EXPECTED_FLOOR = 0;
        DEFAULT_SETTLEMENT_MODE = 0;
        DEFAULT_ALG_BID_TYPE = 0;
        DEFAULT_ECPM_TARGET = 0;
        DEFAULT_SETTLEMENT_SETTING = 0;
        DEFAULT_COMMER_ECPM = 0;
        DEFAULT_ADX_ECPM = 0;
        DEFAULT_COMMER_ECPM_STATE = 0;
        DEFAULT_AD_COUNT = 0;
        DEFAULT_DISABLE_MRAID2 = Boolean.FALSE;
    }

    public AdSlot(String str, Size size, List<Integer> list, Integer num, String str2, String str3, String str4, List<Integer> list2, Integer num2, Integer num3, Map<String, String> map, List<Integer> list3, Integer num4, Map<String, String> map2, Map<String, AdCache> map3, Video video, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, List<Integer> list4, Boolean bool) {
        this(str, size, list, num, str2, str3, str4, list2, num2, num3, map, list3, num4, map2, map3, video, num5, num6, num7, num8, num9, num10, num11, num12, num13, list4, bool, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSlot)) {
            return false;
        }
        AdSlot adSlot = (AdSlot) obj;
        return unknownFields().equals(adSlot.unknownFields()) && Internal.equals(this.adslot_id, adSlot.adslot_id) && Internal.equals(this.adslot_size, adSlot.adslot_size) && this.adslot_type.equals(adSlot.adslot_type) && Internal.equals(this.bidfloor, adSlot.bidfloor) && Internal.equals(this.vid, adSlot.vid) && Internal.equals(this.latest_camp_id, adSlot.latest_camp_id) && Internal.equals(this.latest_crid, adSlot.latest_crid) && this.material_type.equals(adSlot.material_type) && Internal.equals(this.sdk_strategy_index, adSlot.sdk_strategy_index) && Internal.equals(this.api_strategy_index, adSlot.api_strategy_index) && this.sdk_cached_ads.equals(adSlot.sdk_cached_ads) && this.creative_type.equals(adSlot.creative_type) && Internal.equals(this.algorithm_floor, adSlot.algorithm_floor) && this.ext.equals(adSlot.ext) && this.ad_caches.equals(adSlot.ad_caches) && Internal.equals(this.video, adSlot.video) && Internal.equals(this.expected_floor, adSlot.expected_floor) && Internal.equals(this.settlement_mode, adSlot.settlement_mode) && Internal.equals(this.alg_bid_type, adSlot.alg_bid_type) && Internal.equals(this.ecpm_target, adSlot.ecpm_target) && Internal.equals(this.settlement_setting, adSlot.settlement_setting) && Internal.equals(this.commer_ecpm, adSlot.commer_ecpm) && Internal.equals(this.adx_ecpm, adSlot.adx_ecpm) && Internal.equals(this.commer_ecpm_state, adSlot.commer_ecpm_state) && Internal.equals(this.ad_count, adSlot.ad_count) && this.support_template_id.equals(adSlot.support_template_id) && Internal.equals(this.disable_mraid2, adSlot.disable_mraid2);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.adslot_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Size size = this.adslot_size;
        int hashCode3 = (((hashCode2 + (size != null ? size.hashCode() : 0)) * 37) + this.adslot_type.hashCode()) * 37;
        Integer num = this.bidfloor;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.vid;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.latest_camp_id;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.latest_crid;
        int hashCode7 = (((hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37) + this.material_type.hashCode()) * 37;
        Integer num2 = this.sdk_strategy_index;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.api_strategy_index;
        int hashCode9 = (((((hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37) + this.sdk_cached_ads.hashCode()) * 37) + this.creative_type.hashCode()) * 37;
        Integer num4 = this.algorithm_floor;
        int hashCode10 = (((((hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37) + this.ext.hashCode()) * 37) + this.ad_caches.hashCode()) * 37;
        Video video = this.video;
        int hashCode11 = (hashCode10 + (video != null ? video.hashCode() : 0)) * 37;
        Integer num5 = this.expected_floor;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.settlement_mode;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.alg_bid_type;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.ecpm_target;
        int hashCode15 = (hashCode14 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.settlement_setting;
        int hashCode16 = (hashCode15 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.commer_ecpm;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.adx_ecpm;
        int hashCode18 = (hashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.commer_ecpm_state;
        int hashCode19 = (hashCode18 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.ad_count;
        int hashCode20 = (((hashCode19 + (num13 != null ? num13.hashCode() : 0)) * 37) + this.support_template_id.hashCode()) * 37;
        Boolean bool = this.disable_mraid2;
        int hashCode21 = hashCode20 + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode21;
        return hashCode21;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.adslot_id = this.adslot_id;
        builder.adslot_size = this.adslot_size;
        builder.adslot_type = Internal.copyOf("adslot_type", this.adslot_type);
        builder.bidfloor = this.bidfloor;
        builder.vid = this.vid;
        builder.latest_camp_id = this.latest_camp_id;
        builder.latest_crid = this.latest_crid;
        builder.material_type = Internal.copyOf("material_type", this.material_type);
        builder.sdk_strategy_index = this.sdk_strategy_index;
        builder.api_strategy_index = this.api_strategy_index;
        builder.sdk_cached_ads = Internal.copyOf("sdk_cached_ads", this.sdk_cached_ads);
        builder.creative_type = Internal.copyOf("creative_type", this.creative_type);
        builder.algorithm_floor = this.algorithm_floor;
        builder.ext = Internal.copyOf("ext", this.ext);
        builder.ad_caches = Internal.copyOf("ad_caches", this.ad_caches);
        builder.video = this.video;
        builder.expected_floor = this.expected_floor;
        builder.settlement_mode = this.settlement_mode;
        builder.alg_bid_type = this.alg_bid_type;
        builder.ecpm_target = this.ecpm_target;
        builder.settlement_setting = this.settlement_setting;
        builder.commer_ecpm = this.commer_ecpm;
        builder.adx_ecpm = this.adx_ecpm;
        builder.commer_ecpm_state = this.commer_ecpm_state;
        builder.ad_count = this.ad_count;
        builder.support_template_id = Internal.copyOf("support_template_id", this.support_template_id);
        builder.disable_mraid2 = this.disable_mraid2;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.adslot_id != null) {
            sb2.append(", adslot_id=");
            sb2.append(this.adslot_id);
        }
        if (this.adslot_size != null) {
            sb2.append(", adslot_size=");
            sb2.append(this.adslot_size);
        }
        if (!this.adslot_type.isEmpty()) {
            sb2.append(", adslot_type=");
            sb2.append(this.adslot_type);
        }
        if (this.bidfloor != null) {
            sb2.append(", bidfloor=");
            sb2.append(this.bidfloor);
        }
        if (this.vid != null) {
            sb2.append(", vid=");
            sb2.append(this.vid);
        }
        if (this.latest_camp_id != null) {
            sb2.append(", latest_camp_id=");
            sb2.append(this.latest_camp_id);
        }
        if (this.latest_crid != null) {
            sb2.append(", latest_crid=");
            sb2.append(this.latest_crid);
        }
        if (!this.material_type.isEmpty()) {
            sb2.append(", material_type=");
            sb2.append(this.material_type);
        }
        if (this.sdk_strategy_index != null) {
            sb2.append(", sdk_strategy_index=");
            sb2.append(this.sdk_strategy_index);
        }
        if (this.api_strategy_index != null) {
            sb2.append(", api_strategy_index=");
            sb2.append(this.api_strategy_index);
        }
        if (!this.sdk_cached_ads.isEmpty()) {
            sb2.append(", sdk_cached_ads=");
            sb2.append(this.sdk_cached_ads);
        }
        if (!this.creative_type.isEmpty()) {
            sb2.append(", creative_type=");
            sb2.append(this.creative_type);
        }
        if (this.algorithm_floor != null) {
            sb2.append(", algorithm_floor=");
            sb2.append(this.algorithm_floor);
        }
        if (!this.ext.isEmpty()) {
            sb2.append(", ext=");
            sb2.append(this.ext);
        }
        if (!this.ad_caches.isEmpty()) {
            sb2.append(", ad_caches=");
            sb2.append(this.ad_caches);
        }
        if (this.video != null) {
            sb2.append(", video=");
            sb2.append(this.video);
        }
        if (this.expected_floor != null) {
            sb2.append(", expected_floor=");
            sb2.append(this.expected_floor);
        }
        if (this.settlement_mode != null) {
            sb2.append(", settlement_mode=");
            sb2.append(this.settlement_mode);
        }
        if (this.alg_bid_type != null) {
            sb2.append(", alg_bid_type=");
            sb2.append(this.alg_bid_type);
        }
        if (this.ecpm_target != null) {
            sb2.append(", ecpm_target=");
            sb2.append(this.ecpm_target);
        }
        if (this.settlement_setting != null) {
            sb2.append(", settlement_setting=");
            sb2.append(this.settlement_setting);
        }
        if (this.commer_ecpm != null) {
            sb2.append(", commer_ecpm=");
            sb2.append(this.commer_ecpm);
        }
        if (this.adx_ecpm != null) {
            sb2.append(", adx_ecpm=");
            sb2.append(this.adx_ecpm);
        }
        if (this.commer_ecpm_state != null) {
            sb2.append(", commer_ecpm_state=");
            sb2.append(this.commer_ecpm_state);
        }
        if (this.ad_count != null) {
            sb2.append(", ad_count=");
            sb2.append(this.ad_count);
        }
        if (!this.support_template_id.isEmpty()) {
            sb2.append(", support_template_id=");
            sb2.append(this.support_template_id);
        }
        if (this.disable_mraid2 != null) {
            sb2.append(", disable_mraid2=");
            sb2.append(this.disable_mraid2);
        }
        StringBuilder replace = sb2.replace(0, 2, "AdSlot{");
        replace.append('}');
        return replace.toString();
    }

    public AdSlot(String str, Size size, List<Integer> list, Integer num, String str2, String str3, String str4, List<Integer> list2, Integer num2, Integer num3, Map<String, String> map, List<Integer> list3, Integer num4, Map<String, String> map2, Map<String, AdCache> map3, Video video, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, List<Integer> list4, Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.adslot_id = str;
        this.adslot_size = size;
        this.adslot_type = Internal.immutableCopyOf("adslot_type", list);
        this.bidfloor = num;
        this.vid = str2;
        this.latest_camp_id = str3;
        this.latest_crid = str4;
        this.material_type = Internal.immutableCopyOf("material_type", list2);
        this.sdk_strategy_index = num2;
        this.api_strategy_index = num3;
        this.sdk_cached_ads = Internal.immutableCopyOf("sdk_cached_ads", map);
        this.creative_type = Internal.immutableCopyOf("creative_type", list3);
        this.algorithm_floor = num4;
        this.ext = Internal.immutableCopyOf("ext", map2);
        this.ad_caches = Internal.immutableCopyOf("ad_caches", map3);
        this.video = video;
        this.expected_floor = num5;
        this.settlement_mode = num6;
        this.alg_bid_type = num7;
        this.ecpm_target = num8;
        this.settlement_setting = num9;
        this.commer_ecpm = num10;
        this.adx_ecpm = num11;
        this.commer_ecpm_state = num12;
        this.ad_count = num13;
        this.support_template_id = Internal.immutableCopyOf("support_template_id", list4);
        this.disable_mraid2 = bool;
    }
}

package com.martian.ads.data;

import com.martian.ads.ad.AdConfig;
import java.util.Map;

/* loaded from: classes2.dex */
public class AdSlot {
    private String aliasUnion;
    private String appid;
    private Integer bidding;
    private Integer ecpm;
    private Map<String, Object> ext;
    private Integer interval;
    private String sid;
    private String type;
    private String union;
    private Integer weight;
    private String weightName;

    public String getAliasUnion() {
        return this.aliasUnion;
    }

    public String getAppid() {
        return this.appid;
    }

    public int getBidding() {
        Integer num = this.bidding;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getEcpm() {
        Integer num = this.ecpm;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Double getEcpmPercent() {
        Map<String, Object> map = this.ext;
        Double valueOf = Double.valueOf(-1.0d);
        if (map == null) {
            return valueOf;
        }
        Object obj = map.get("ecpmPercent");
        return obj instanceof Double ? (Double) obj : valueOf;
    }

    public Map<String, Object> getExt() {
        return this.ext;
    }

    public int getInterval() {
        Integer num = this.interval;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getSid() {
        return this.sid;
    }

    public String getType() {
        return this.type;
    }

    public String getUnion() {
        return this.union;
    }

    public int getWeight() {
        Integer num = this.weight;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public String getWeightName() {
        return this.weightName;
    }

    public boolean isApiUnion() {
        return AdConfig.UnionType.API.equalsIgnoreCase(this.union);
    }

    public boolean isBidding() {
        Integer num = this.bidding;
        return num != null && (num.intValue() == 1 || this.bidding.intValue() == 2 || this.bidding.intValue() == 3 || this.bidding.intValue() == 5 || this.bidding.intValue() == 6);
    }

    public boolean isBqtUnion() {
        return AdConfig.UnionType.BQT.equalsIgnoreCase(this.union);
    }

    public boolean isCsjUnion() {
        return AdConfig.UnionType.CSJ.equalsIgnoreCase(this.union);
    }

    public boolean isDxUnion() {
        return AdConfig.UnionType.DX.equalsIgnoreCase(this.union);
    }

    public boolean isExtraBidding() {
        Integer num = this.bidding;
        return num != null && (num.intValue() == 2 || this.bidding.intValue() == 3 || this.bidding.intValue() == 5 || this.bidding.intValue() == 6);
    }

    public boolean isExtraVideoAd() {
        Integer num = this.bidding;
        return num != null && num.intValue() == 4;
    }

    public boolean isGdtUnion() {
        return AdConfig.UnionType.GDT.equalsIgnoreCase(this.union);
    }

    public boolean isHwUnion() {
        return AdConfig.UnionType.HW.equalsIgnoreCase(this.union);
    }

    public boolean isKsUnion() {
        return "KS".equalsIgnoreCase(this.union);
    }

    public boolean isMiUnion() {
        return AdConfig.UnionType.MI.equalsIgnoreCase(this.union);
    }

    public boolean isOppoUnion() {
        return "OPPO".equalsIgnoreCase(this.union);
    }

    public boolean isShakeStyle() {
        Map<String, Object> map = this.ext;
        if (map == null) {
            return false;
        }
        Object obj = map.get("shakeStyle");
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    public boolean isSupportAd() {
        Integer num = this.bidding;
        return num == null || num.intValue() <= 6;
    }

    public boolean isVivoUnion() {
        return "VIVO".equalsIgnoreCase(this.union);
    }

    public void setAliasUnion(String aliasUnion) {
        this.aliasUnion = aliasUnion;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setBidding(Integer bidding) {
        this.bidding = bidding;
    }

    public AdSlot setEcpm(Integer ecpm) {
        this.ecpm = ecpm;
        return this;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    public AdSlot setInterval(Integer interval) {
        this.interval = interval;
        return this;
    }

    public AdSlot setSid(String sid) {
        this.sid = sid;
        return this;
    }

    public AdSlot setType(String type) {
        this.type = type;
        return this;
    }

    public AdSlot setUnion(String union) {
        this.union = union;
        return this;
    }

    public AdSlot setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    public boolean sourceEnable() {
        return isCsjUnion() || isBqtUnion() || isDxUnion() || isGdtUnion() || isKsUnion() || isVivoUnion() || isMiUnion() || isHwUnion() || isApiUnion() || isOppoUnion();
    }
}

package com.martian.ads.data;

import com.martian.ads.ad.AdConfig;
import com.umeng.ccg.a;
import java.util.Map;
import l5.c;

/* loaded from: classes3.dex */
public class AdSlot {
    private String aliasUnion;
    private String appid;
    private Integer autoEcpmPercent;
    private Integer bidding;
    private Integer ecpm;
    private Map<String, Object> ext;
    private String sid;
    private String type;
    private String union;
    private Integer weight;

    public String getAliasUnion() {
        return this.aliasUnion;
    }

    public String getAppid() {
        return this.appid;
    }

    public int getAutoEcpmPercent() {
        Integer num = this.autoEcpmPercent;
        if (num == null) {
            return 0;
        }
        return num.intValue();
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

    public int getMinEcpm() {
        Map<String, Object> map = this.ext;
        if (map == null) {
            return 0;
        }
        Object obj = map.get("minEcpm");
        if (obj instanceof Double) {
            return (int) ((Double) obj).doubleValue();
        }
        return 0;
    }

    public double getPrice() {
        return this.ecpm == null ? c.f27899e : r0.intValue() / 100.0d;
    }

    public String getScene() {
        Map<String, Object> map = this.ext;
        if (map == null) {
            return "";
        }
        Object obj = map.get(a.f24233j);
        return obj instanceof String ? (String) obj : "";
    }

    public int getShakeMinEcpm() {
        Map<String, Object> map = this.ext;
        if (map == null) {
            return 0;
        }
        Object obj = map.get("shakeMinEcpm");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
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
            return 0;
        }
        return num.intValue();
    }

    public boolean isApiUnion() {
        return AdConfig.UnionType.API.equalsIgnoreCase(this.union);
    }

    public boolean isBidding() {
        Integer num = this.bidding;
        return num != null && (num.intValue() == 1 || this.bidding.intValue() == 3);
    }

    public boolean isBqtUnion() {
        return AdConfig.UnionType.BQT.equalsIgnoreCase(this.union);
    }

    public boolean isCoolId() {
        Map<String, Object> map = this.ext;
        if (map == null) {
            return false;
        }
        Object obj = map.get("coolRequest");
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    public boolean isCsjUnion() {
        return AdConfig.UnionType.CSJ.equalsIgnoreCase(this.union);
    }

    public boolean isDxUnion() {
        return AdConfig.UnionType.DX.equalsIgnoreCase(this.union);
    }

    public boolean isExpress() {
        Map<String, Object> map = this.ext;
        if (map == null) {
            return false;
        }
        Object obj = map.get("isExpress");
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    public boolean isGdtUnion() {
        return AdConfig.UnionType.GDT.equalsIgnoreCase(this.union);
    }

    public boolean isHotStartId() {
        Map<String, Object> map = this.ext;
        if (map == null) {
            return false;
        }
        Object obj = map.get("hotStart");
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    public boolean isHwUnion() {
        return AdConfig.UnionType.HW.equalsIgnoreCase(this.union);
    }

    public boolean isKsUnion() {
        return "KS".equalsIgnoreCase(this.union);
    }

    public boolean isMentaUnion() {
        return AdConfig.UnionType.MENTA.equalsIgnoreCase(this.union);
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

    public boolean isSigmobUnion() {
        return AdConfig.UnionType.SIGMOB.equalsIgnoreCase(this.union);
    }

    public boolean isVivoUnion() {
        return AdConfig.UnionType.VIVO.equalsIgnoreCase(this.union);
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setAutoEcpmPercent(Integer num) {
        this.autoEcpmPercent = num;
    }

    public void setBidding(Integer num) {
        this.bidding = num;
    }

    public AdSlot setEcpm(Integer num) {
        this.ecpm = num;
        return this;
    }

    public AdSlot setSid(String str) {
        this.sid = str;
        return this;
    }

    public AdSlot setType(String str) {
        this.type = str;
        return this;
    }

    public AdSlot setUnion(String str) {
        this.union = str;
        return this;
    }

    public AdSlot setWeight(Integer num) {
        this.weight = num;
        return this;
    }
}

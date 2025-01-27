package com.martian.ads.data;

import com.martian.ads.ad.AdConfig;
import com.martian.libmars.common.ConfigSingleton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AdSlots {
    private Integer bestOffset;
    private Integer coolDuration;
    private Integer coolPlatform;
    private Integer coolThreshold;
    private Double downRatio;
    private Integer dynamicUnion;
    private String gid;
    private Integer groPercent;
    private Integer limitDuration;
    private Integer maxOffset;
    private Integer minEcpm;
    private Integer minGroupSlots;
    private Integer parallel;
    private String pid;
    private Integer slotTimeout;
    private List<AdSlot> slots;
    private Integer timeout;
    private Double upRatio;

    public boolean coolPlatformBqt() {
        return (getCoolPlatform() & 4) > 0;
    }

    public boolean coolPlatformCsj() {
        return (getCoolPlatform() & 1) > 0;
    }

    public boolean coolPlatformGdt() {
        return (getCoolPlatform() & 2) > 0;
    }

    public boolean coolPlatformKs() {
        return (getCoolPlatform() & 8) > 0;
    }

    public boolean dynamicPlatformBqt() {
        return (getDynamicUnion() & 4) > 0;
    }

    public boolean dynamicPlatformCsj() {
        return (getDynamicUnion() & 1) > 0;
    }

    public boolean dynamicPlatformGdt() {
        return (getDynamicUnion() & 2) > 0;
    }

    public boolean dynamicPlatformKs() {
        return (getDynamicUnion() & 8) > 0;
    }

    public int getBestOffset() {
        Integer num = this.bestOffset;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getCoolDuration() {
        Integer num = this.coolDuration;
        if (num == null) {
            return 600;
        }
        return num.intValue();
    }

    public int getCoolPlatform() {
        Integer num = this.coolPlatform;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getCoolThreshold() {
        Integer num = this.coolThreshold;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public double getDownRatio() {
        Double d10 = this.downRatio;
        if (d10 == null) {
            return 0.5d;
        }
        return d10.doubleValue();
    }

    public int getDynamicUnion() {
        Integer num = this.dynamicUnion;
        if (num == null) {
            return 3;
        }
        return num.intValue();
    }

    public String getGid() {
        return this.gid;
    }

    public int getGroPercent() {
        Integer num = this.groPercent;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getLimitDuration() {
        Integer num = this.limitDuration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMaxOffset() {
        Integer num = this.maxOffset;
        if (num == null) {
            return 6;
        }
        return num.intValue();
    }

    public int getMinEcpm() {
        Integer num = this.minEcpm;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMinGroupSlots() {
        Integer num = this.minGroupSlots;
        if (num == null) {
            return 3;
        }
        return num.intValue();
    }

    public int getParallel() {
        Integer num = this.parallel;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public String getPid() {
        return this.pid;
    }

    public double getRatio(int i10) {
        return i10 > 0 ? getDownRatio() : getUpRatio();
    }

    public int getSlotTimeout() {
        Integer num = this.slotTimeout;
        if (num == null) {
            return 3;
        }
        return num.intValue();
    }

    public List<AdSlot> getSlots() {
        if (this.slots == null) {
            this.slots = new ArrayList();
        }
        return this.slots;
    }

    public int getTimeout() {
        Integer num = this.timeout;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public double getUpRatio() {
        Double d10 = this.upRatio;
        if (d10 == null) {
            return 1.0d;
        }
        return d10.doubleValue();
    }

    public boolean isDynamicUnion(String str) {
        if (AdConfig.UnionType.CSJ.equalsIgnoreCase(str)) {
            return dynamicPlatformCsj();
        }
        if (AdConfig.UnionType.GDT.equalsIgnoreCase(str)) {
            return dynamicPlatformGdt();
        }
        if ("KS".equalsIgnoreCase(str)) {
            return dynamicPlatformKs();
        }
        if (AdConfig.UnionType.BQT.equalsIgnoreCase(str)) {
            return dynamicPlatformBqt();
        }
        return false;
    }

    public boolean loadGromoreAd() {
        if (ConfigSingleton.D().B0()) {
            return false;
        }
        return ConfigSingleton.D().C0(getGroPercent());
    }

    public void setBestOffset(Integer num) {
        this.bestOffset = num;
    }

    public void setCoolDuration(Integer num) {
        this.coolDuration = num;
    }

    public void setCoolPlatform(Integer num) {
        this.coolPlatform = num;
    }

    public void setCoolThreshold(Integer num) {
        this.coolThreshold = num;
    }

    public void setDownRatio(Double d10) {
        this.downRatio = d10;
    }

    public void setDynamicUnion(Integer num) {
        this.dynamicUnion = num;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public void setGroPercent(Integer num) {
        this.groPercent = num;
    }

    public void setLimitDuration(Integer num) {
        this.limitDuration = num;
    }

    public void setMaxOffset(Integer num) {
        this.maxOffset = num;
    }

    public void setMinEcpm(Integer num) {
        this.minEcpm = num;
    }

    public void setMinGroupSlots(int i10) {
        this.minGroupSlots = Integer.valueOf(i10);
    }

    public void setParallel(Integer num) {
        this.parallel = num;
    }

    public AdSlots setPid(String str) {
        this.pid = str;
        return this;
    }

    public void setSlotTimeout(Integer num) {
        this.slotTimeout = num;
    }

    public void setSlots(List<AdSlot> list) {
        ArrayList arrayList = new ArrayList();
        this.slots = arrayList;
        arrayList.addAll(list);
    }

    public void setTimeout(Integer num) {
        this.timeout = num;
    }

    public void setUpRatio(Double d10) {
        this.upRatio = d10;
    }

    public void setMinGroupSlots(Integer num) {
        this.minGroupSlots = num;
    }
}

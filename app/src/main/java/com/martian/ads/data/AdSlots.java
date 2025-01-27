package com.martian.ads.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AdSlots {
    private Integer bestOffset;
    private Double downRatio;
    private Integer maxOffset;
    private Integer minGroupSlots;
    private Integer parallel;
    private String pid;
    private List<AdSlot> slots;
    private Double upRatio;

    public int getBestOffset() {
        Integer num = this.bestOffset;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public double getDownRatio() {
        Double d2 = this.downRatio;
        if (d2 == null) {
            return 0.5d;
        }
        return d2.doubleValue();
    }

    public int getMaxOffset() {
        Integer num = this.maxOffset;
        if (num == null) {
            return 6;
        }
        return num.intValue();
    }

    public int getMinGroupSlots() {
        Integer num = this.minGroupSlots;
        if (num == null) {
            return 2;
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

    public double getRatio(int offset) {
        return offset > 0 ? getDownRatio() : getUpRatio();
    }

    public List<AdSlot> getSlots() {
        if (this.slots == null) {
            this.slots = new ArrayList();
        }
        return this.slots;
    }

    public double getUpRatio() {
        Double d2 = this.upRatio;
        if (d2 == null) {
            return 1.0d;
        }
        return d2.doubleValue();
    }

    public void setBestOffset(Integer bestOffset) {
        this.bestOffset = bestOffset;
    }

    public void setDownRatio(Double downRatio) {
        this.downRatio = downRatio;
    }

    public void setMaxOffset(Integer maxOffset) {
        this.maxOffset = maxOffset;
    }

    public void setMinGroupSlots(int minGroupSlots) {
        this.minGroupSlots = Integer.valueOf(minGroupSlots);
    }

    public void setParallel(Integer parallel) {
        this.parallel = parallel;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setSlots(List<AdSlot> adSlots) {
        ArrayList arrayList = new ArrayList();
        this.slots = arrayList;
        arrayList.addAll(adSlots);
    }

    public void setUpRatio(Double upRatio) {
        this.upRatio = upRatio;
    }
}

package com.martian.libugrowth.data;

/* loaded from: classes3.dex */
public class AdEvent {
    private Integer ecpm;
    private String type;
    private Integer value;

    public Integer getEcpm() {
        return this.ecpm;
    }

    public String getType() {
        return this.type;
    }

    public Integer getValue() {
        return this.value;
    }

    public void inrcEcpm(int cpm) {
        if (this.ecpm == null) {
            this.ecpm = 0;
        }
        this.ecpm = Integer.valueOf(this.ecpm.intValue() + cpm);
    }

    public void inrcValue() {
        if (this.value == null) {
            this.value = 1;
        }
        this.value = Integer.valueOf(this.value.intValue() + 1);
    }

    public AdEvent setEcpm(Integer ecpm) {
        this.ecpm = ecpm;
        return this;
    }

    public AdEvent setType(String type) {
        this.type = type;
        return this;
    }

    public AdEvent setValue(Integer value) {
        this.value = value;
        return this;
    }
}

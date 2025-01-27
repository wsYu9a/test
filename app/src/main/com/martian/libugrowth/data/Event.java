package com.martian.libugrowth.data;

/* loaded from: classes3.dex */
public class Event {
    private String itemId;
    private String typeId;
    private Integer count = 1;
    private Integer value = 0;

    public Integer getCount() {
        return this.count;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public Integer getValue() {
        return this.value;
    }

    public void increaseCount() {
        this.count = Integer.valueOf(this.count.intValue() + 1);
    }

    public void increaseValue(int i10) {
        this.value = Integer.valueOf(this.value.intValue() + i10);
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public Event setItemId(String str) {
        this.itemId = str;
        return this;
    }

    public Event setTypeId(String str) {
        this.typeId = str;
        return this;
    }

    public Event setValue(Integer num) {
        this.value = num;
        return this;
    }
}

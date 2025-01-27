package com.martian.libugrowth.data;

/* loaded from: classes3.dex */
public class Event {
    private String itemId;
    private String typeId;
    private Integer value = 1;

    public String getItemId() {
        return this.itemId;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public Integer getValue() {
        return this.value;
    }

    public void inrcValue() {
        if (this.value == null) {
            this.value = 1;
        }
        this.value = Integer.valueOf(this.value.intValue() + 1);
    }

    public Event setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public Event setTypeId(String typeId) {
        this.typeId = typeId;
        return this;
    }

    public Event setValue(Integer value) {
        this.value = value;
        return this;
    }
}

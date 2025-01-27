package com.martian.libugrowth.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AdsEvent {
    private List<AdEvent> eventValues;
    private String itemId;
    private String pid;
    private String slotId;
    private String unionType;

    public String getAdActionsString() {
        StringBuilder sb = new StringBuilder();
        for (AdEvent adEvent : getEventValues()) {
            sb.append(adEvent.getType());
            sb.append(":");
            sb.append(adEvent.getValue());
            sb.append("   ");
        }
        return sb.toString();
    }

    public List<AdEvent> getEventValues() {
        if (this.eventValues == null) {
            this.eventValues = new ArrayList();
        }
        return this.eventValues;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getPid() {
        return this.pid;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public String getUnionType() {
        return this.unionType;
    }

    public AdsEvent setEventValues(List<AdEvent> eventValues) {
        this.eventValues = eventValues;
        return this;
    }

    public AdsEvent setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public AdsEvent setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public AdsEvent setSlotId(String slotId) {
        this.slotId = slotId;
        return this;
    }

    public AdsEvent setUnionType(String unionType) {
        this.unionType = unionType;
        return this;
    }
}

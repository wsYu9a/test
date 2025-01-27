package com.martian.libugrowth.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x8.c;

/* loaded from: classes3.dex */
public class AdsEvent {
    private Map<Long, Integer> errCodes;
    private List<AdEvent> eventValues;
    private String itemId;
    private String pid;
    private String slotId;
    private String unionType;

    public String getAdActionsString() {
        StringBuilder sb2 = new StringBuilder();
        for (AdEvent adEvent : getEventValues()) {
            sb2.append(adEvent.getType());
            sb2.append(":");
            sb2.append(adEvent.getValue());
            sb2.append("   ");
        }
        return sb2.toString();
    }

    public Map<Long, Integer> getErrCodes() {
        return this.errCodes;
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

    public void increaseErrCode(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.errCodes == null) {
            this.errCodes = new HashMap();
        }
        long c10 = cVar.c();
        Integer num = this.errCodes.get(Long.valueOf(c10));
        if (num == null) {
            this.errCodes.put(Long.valueOf(c10), 1);
        } else {
            this.errCodes.put(Long.valueOf(c10), Integer.valueOf(num.intValue() + 1));
        }
    }

    public boolean isPidEvent() {
        return TextUtils.isEmpty(this.unionType) && TextUtils.isEmpty(this.slotId);
    }

    public void setErrCodes(Map<Long, Integer> map) {
        this.errCodes = map;
    }

    public AdsEvent setEventValues(List<AdEvent> list) {
        this.eventValues = list;
        return this;
    }

    public AdsEvent setItemId(String str) {
        this.itemId = str;
        return this;
    }

    public AdsEvent setPid(String str) {
        this.pid = str;
        return this;
    }

    public AdsEvent setSlotId(String str) {
        this.slotId = str;
        return this;
    }

    public AdsEvent setUnionType(String str) {
        this.unionType = str;
        return this;
    }
}

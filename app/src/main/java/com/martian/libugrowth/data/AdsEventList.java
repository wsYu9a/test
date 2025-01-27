package com.martian.libugrowth.data;

import com.martian.libcomm.utils.GsonUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AdsEventList {
    private List<AdsEvent> events;

    public static AdsEventList fromJson(String jsonString) {
        return (AdsEventList) GsonUtils.b().fromJson(jsonString, AdsEventList.class);
    }

    public List<AdsEvent> getEvents() {
        if (this.events == null) {
            this.events = new ArrayList();
        }
        return this.events;
    }

    public void setEvents(List<AdsEvent> events) {
        this.events = events;
    }

    public String toJsonString() {
        return GsonUtils.b().toJson(this);
    }
}

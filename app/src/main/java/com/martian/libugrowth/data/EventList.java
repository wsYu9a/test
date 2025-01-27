package com.martian.libugrowth.data;

import com.martian.libcomm.utils.GsonUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class EventList {
    private List<Event> events;

    public static EventList fromJson(String str) {
        return (EventList) GsonUtils.b().fromJson(str, EventList.class);
    }

    public List<Event> getEvents() {
        if (this.events == null) {
            this.events = new ArrayList();
        }
        return this.events;
    }

    public void setEvents(List<Event> list) {
        this.events = list;
    }

    public String toJsonString() {
        return GsonUtils.b().toJson(this);
    }
}

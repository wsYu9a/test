package com.martian.libugrowth.data;

import com.martian.libcomm.utils.GsonUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class EventList {
    private List<Event> events;

    public static EventList fromJson(String jsonString) {
        return (EventList) GsonUtils.b().fromJson(jsonString, EventList.class);
    }

    public List<Event> getEvents() {
        if (this.events == null) {
            this.events = new ArrayList();
        }
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String toJsonString() {
        return GsonUtils.b().toJson(this);
    }
}

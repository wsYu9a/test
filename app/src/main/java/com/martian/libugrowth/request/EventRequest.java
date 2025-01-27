package com.martian.libugrowth.request;

import com.martian.libcomm.utils.GsonUtils;
import com.martian.libugrowth.data.Event;
import com.umeng.analytics.pro.f;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public class EventRequest extends UGrowthRequest {
    private List<Event> events;

    public List<Event> getEvents() {
        return this.events;
    }

    @Override // com.martian.libmars.comm.request.MTRequest
    public String getRequestMethod() {
        return f.ax;
    }

    public void setEvents(List<Event> list) {
        this.events = list;
    }

    @Override // com.martian.libmars.comm.request.MTRequest
    public RequestBody toPostContent(String str) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.c().toJson(this.events));
    }
}

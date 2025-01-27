package com.martian.mibook.lib.account.request;

import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.lib.account.response.BookEvent;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public class BookEventRequest extends MiBookRequest {
    private List<BookEvent> events;

    public List<BookEvent> getEvents() {
        return this.events;
    }

    @Override // com.martian.libmars.comm.request.MTRequest
    public String getRequestMethod() {
        return "authopt/stat/book_events";
    }

    public void setEvents(List<BookEvent> events) {
        this.events = events;
    }

    @Override // com.martian.libmars.comm.request.MTRequest
    public RequestBody toPostContent(String charset) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.c().toJson(this.events));
    }
}

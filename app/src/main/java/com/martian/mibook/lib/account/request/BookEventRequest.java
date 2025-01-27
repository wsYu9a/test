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

    public void setEvents(List<BookEvent> list) {
        this.events = list;
    }

    @Override // com.martian.libmars.comm.request.MTRequest
    public RequestBody toPostContent(String str) {
        String str2;
        MediaType parse = MediaType.parse("application/json; charset=utf-8");
        try {
            str2 = GsonUtils.c().toJson(this.events);
        } catch (Exception e10) {
            e10.printStackTrace();
            str2 = "";
        }
        return RequestBody.create(parse, str2);
    }
}

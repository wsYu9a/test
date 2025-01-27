package com.martian.libugrowth.request;

import com.martian.libcomm.utils.GsonUtils;
import com.martian.libugrowth.data.AdsEvent;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public class AdsEventRequest extends UGrowthRequest {
    private List<AdsEvent> adEvents;

    public List<AdsEvent> getAdEvents() {
        return this.adEvents;
    }

    @Override // com.martian.libmars.comm.request.MTRequest
    public String getRequestMethod() {
        return "ads/events";
    }

    public void setAdEvents(List<AdsEvent> list) {
        this.adEvents = list;
    }

    @Override // com.martian.libmars.comm.request.MTRequest
    public RequestBody toPostContent(String str) {
        String str2;
        try {
            str2 = GsonUtils.c().toJson(this.adEvents);
        } catch (Exception e10) {
            e10.printStackTrace();
            str2 = "";
        }
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str2);
    }
}

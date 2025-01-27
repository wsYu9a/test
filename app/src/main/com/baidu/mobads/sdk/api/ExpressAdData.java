package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.a;
import java.util.List;

/* loaded from: classes2.dex */
public class ExpressAdData {
    private String adPlaceId;
    private String desc;
    private String iconUrl;
    private String imageUrl;
    private List<String> multiPicUrls;

    /* renamed from: pk */
    private String f6634pk;
    private String title;
    private String videoUrl;

    public ExpressAdData(a aVar, String str) {
        this.title = "";
        this.desc = "";
        this.iconUrl = "";
        this.f6634pk = "";
        this.imageUrl = "";
        this.videoUrl = "";
        this.multiPicUrls = null;
        this.adPlaceId = str;
        this.title = aVar.a();
        this.desc = aVar.b();
        this.iconUrl = aVar.c();
        this.f6634pk = aVar.m();
        this.imageUrl = aVar.d();
        this.videoUrl = aVar.n();
        this.multiPicUrls = aVar.H();
    }

    public String getAdPlaceId() {
        return this.adPlaceId;
    }

    public String getAppPackage() {
        return this.f6634pk;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<String> getMultiPicUrls() {
        return this.multiPicUrls;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }
}

package com.martian.libugrowth.adx.response;

import java.util.List;

/* loaded from: classes3.dex */
public class LmUdef {

    /* renamed from: t, reason: collision with root package name */
    private Integer f13012t;
    private List<String> url;

    public int getT() {
        Integer num = this.f13012t;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public List<String> getUrl() {
        return this.url;
    }

    public void setT(Integer num) {
        this.f13012t = num;
    }

    public void setUrl(List<String> list) {
        this.url = list;
    }
}

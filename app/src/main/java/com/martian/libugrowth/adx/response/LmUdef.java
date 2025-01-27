package com.martian.libugrowth.adx.response;

import java.util.List;

/* loaded from: classes3.dex */
public class LmUdef {
    private Integer t;
    private List<String> url;

    public int getT() {
        Integer num = this.t;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public List<String> getUrl() {
        return this.url;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}

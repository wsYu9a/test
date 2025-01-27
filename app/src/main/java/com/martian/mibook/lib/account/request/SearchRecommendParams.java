package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class SearchRecommendParams extends TYHttpGetParams {

    @a
    private Integer ctype;

    @a
    private String keywords;

    public Integer getCtype() {
        return this.ctype;
    }

    public String getKeywords() {
        return this.keywords;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "ty/search_recommend";
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}

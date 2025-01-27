package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
public class YWBookMallRecommendParams extends TYHttpGetParams {

    @a
    private Integer count;

    @a
    private Integer ctype;

    @a
    private Integer page;

    @a
    private Integer seed;

    public int getCType() {
        Integer num = this.ctype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getCount() {
        Integer num = this.count;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getCtype() {
        return this.ctype;
    }

    public Integer getPage() {
        return this.page;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "book_mall/recommend";
    }

    public int getSeed() {
        Integer num = this.seed;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }
}

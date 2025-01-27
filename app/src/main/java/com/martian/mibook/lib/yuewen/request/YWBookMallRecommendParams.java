package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
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

    @Override // u8.b
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

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setSeed(Integer num) {
        this.seed = num;
    }
}

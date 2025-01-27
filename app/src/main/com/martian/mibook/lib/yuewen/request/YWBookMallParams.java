package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
public class YWBookMallParams extends TYAuthoptParams {

    @a
    private Integer count;

    @a
    private Integer ctype;

    @a
    private Integer page;

    @a
    private Integer pageSize;

    @a
    private Integer seed;

    @a
    private Integer tid;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "book_mall";
    }

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

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public int getSeed() {
        Integer num = this.seed;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getTid() {
        return this.tid;
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

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public void setSeed(Integer num) {
        this.seed = num;
    }

    public void setTid(Integer num) {
        this.tid = num;
    }
}

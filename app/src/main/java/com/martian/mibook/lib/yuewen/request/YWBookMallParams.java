package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYAuthoptParams;

/* loaded from: classes4.dex */
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

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}

package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
public class YWRankBooksParams extends TYHttpGetParams {

    @a
    private Integer brtype;

    @a
    private String category;

    @a
    private Integer ctype;

    @a
    private Integer page;

    @a
    private Integer pageSize = 10;

    @a
    private Integer status;

    public int getBrType() {
        Integer num = this.brtype;
        if (num == null) {
            return 2;
        }
        return num.intValue();
    }

    public Integer getBrtype() {
        Integer num = this.brtype;
        return Integer.valueOf(num == null ? 3 : num.intValue());
    }

    public String getCategory() {
        return this.category;
    }

    public int getCtype() {
        Integer num = this.ctype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPageSize() {
        return this.pageSize.intValue();
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "book_mall/book_rank";
    }

    public Integer getStatus() {
        Integer num = this.status;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public void setBrtype(Integer brtype) {
        this.brtype = brtype;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
public class YWChannelBooksParams extends TYHttpGetParams {

    @a
    private String category;

    @a
    private String ext;

    @a
    private Integer mcid;

    @a
    private Integer page;

    @a
    private Integer pageSize = 10;

    @a
    private Integer seed;

    public String getCategory() {
        return this.category;
    }

    public String getExt() {
        return this.ext;
    }

    public int getMcid() {
        Integer num = this.mcid;
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
        return "book_mall/channel_books";
    }

    public int getSeed() {
        Integer num = this.seed;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public void setMcid(Integer mcid) {
        this.mcid = mcid;
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
}

package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
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

    @Override // u8.b
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

    public void setCategory(String str) {
        this.category = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setMcid(Integer num) {
        this.mcid = num;
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
}

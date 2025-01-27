package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.List;

/* loaded from: classes3.dex */
public class YWCategoryBookList {
    private List<TYBookItem> bookList;
    private Integer maxPage;
    private Integer page;

    public List<TYBookItem> getBookList() {
        return this.bookList;
    }

    public int getMaxPage() {
        return this.maxPage.intValue();
    }

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setBookList(List<TYBookItem> list) {
        this.bookList = list;
    }

    public void setMaxPage(Integer num) {
        this.maxPage = num;
    }

    public void setPage(Integer num) {
        this.page = num;
    }
}

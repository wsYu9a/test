package com.martian.mibook.lib.model.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TYSearchBookList {
    private List<TYBookItem> bookList;
    private int maxPage;
    private int page;

    public List<TYBookItem> getBookItemList() {
        if (this.bookList == null) {
            this.bookList = new ArrayList();
        }
        return this.bookList;
    }

    public int getMaxPage() {
        return this.maxPage;
    }

    public int getPage() {
        return this.page;
    }

    public void setBookItemList(List<TYBookItem> bookList) {
        this.bookList = bookList;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

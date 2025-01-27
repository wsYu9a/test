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

    public void setBookItemList(List<TYBookItem> list) {
        this.bookList = list;
    }

    public void setMaxPage(int i10) {
        this.maxPage = i10;
    }

    public void setPage(int i10) {
        this.page = i10;
    }
}

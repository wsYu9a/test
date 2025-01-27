package com.martian.mibook.lib.model.data;

import java.util.List;

/* loaded from: classes.dex */
public class MiBookShelfItemList {
    private List<MiBookShelfItem> bookList;

    public MiBookShelfItemList(List<MiBookShelfItem> bookList) {
        this.bookList = bookList;
    }

    public List<MiBookShelfItem> getBookList() {
        return this.bookList;
    }

    public void setBookList(List<MiBookShelfItem> bookList) {
        this.bookList = bookList;
    }
}

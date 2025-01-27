package com.martian.mibook.lib.model.data;

import java.util.List;

/* loaded from: classes3.dex */
public class MiBookShelfItemList {
    private List<MiBookShelfItem> bookList;

    public MiBookShelfItemList(List<MiBookShelfItem> list) {
        this.bookList = list;
    }

    public List<MiBookShelfItem> getBookList() {
        return this.bookList;
    }

    public void setBookList(List<MiBookShelfItem> list) {
        this.bookList = list;
    }
}

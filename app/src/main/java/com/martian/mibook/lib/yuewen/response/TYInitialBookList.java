package com.martian.mibook.lib.yuewen.response;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TYInitialBookList {
    private List<TYInitialBook> bookList;

    public List<TYInitialBook> getBookList() {
        if (this.bookList == null) {
            this.bookList = new ArrayList();
        }
        return this.bookList;
    }

    public boolean isEmpty() {
        List<TYInitialBook> list = this.bookList;
        return list == null || list.isEmpty();
    }

    public void setBookList(List<TYInitialBook> list) {
        this.bookList = list;
    }
}

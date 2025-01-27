package com.martian.mibook.lib.model.data;

import java.util.List;

/* loaded from: classes3.dex */
public class BookSyncList {
    private List<BookSyncInfo> oplist;

    public BookSyncList(List<BookSyncInfo> oplist) {
        this.oplist = oplist;
    }

    public List<BookSyncInfo> getOplist() {
        return this.oplist;
    }

    public void setOplist(List<BookSyncInfo> oplist) {
        this.oplist = oplist;
    }
}

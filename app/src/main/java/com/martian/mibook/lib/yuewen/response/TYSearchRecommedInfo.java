package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TYSearchRecommedInfo {
    private List<TYBookItem> books;
    private List<TYSearchTag> tags;
    private String tip;

    public List<TYBookItem> getBooks() {
        if (this.books == null) {
            this.books = new ArrayList();
        }
        return this.books;
    }

    public List<TYSearchTag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public String getTip() {
        return this.tip;
    }

    public void setBooks(List<TYBookItem> list) {
        this.books = list;
    }

    public void setTags(List<TYSearchTag> list) {
        this.tags = list;
    }

    public void setTip(String str) {
        this.tip = str;
    }
}

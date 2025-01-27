package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
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

    public void setBooks(List<TYBookItem> books) {
        this.books = books;
    }

    public void setTags(List<TYSearchTag> tags) {
        this.tags = tags;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}

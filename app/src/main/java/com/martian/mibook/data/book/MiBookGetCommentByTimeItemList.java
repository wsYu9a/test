package com.martian.mibook.data.book;

import java.util.List;

/* loaded from: classes3.dex */
public class MiBookGetCommentByTimeItemList {
    private List<Comment> comments;

    public MiBookGetCommentByTimeItemList(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getCommentList() {
        return this.comments;
    }

    public void setCommentList(List<Comment> comments) {
        this.comments = comments;
    }
}

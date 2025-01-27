package com.martian.mibook.data.book;

import java.util.List;

/* loaded from: classes3.dex */
public class MiBookPostCommentItemList {
    private List<Comment> commentList;

    public MiBookPostCommentItemList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Comment> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}

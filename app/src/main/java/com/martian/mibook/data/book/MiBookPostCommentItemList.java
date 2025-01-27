package com.martian.mibook.data.book;

import com.martian.mibook.mvvm.read.comment.Comment;
import java.util.List;

/* loaded from: classes3.dex */
public class MiBookPostCommentItemList {
    private List<Comment> commentList;

    public MiBookPostCommentItemList(List<Comment> list) {
        this.commentList = list;
    }

    public List<Comment> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(List<Comment> list) {
        this.commentList = list;
    }
}

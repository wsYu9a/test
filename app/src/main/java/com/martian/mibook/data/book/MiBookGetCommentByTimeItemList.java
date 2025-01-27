package com.martian.mibook.data.book;

import com.martian.mibook.mvvm.read.comment.Comment;
import java.util.List;

/* loaded from: classes3.dex */
public class MiBookGetCommentByTimeItemList {
    private List<Comment> comments;

    public MiBookGetCommentByTimeItemList(List<Comment> list) {
        this.comments = list;
    }

    public List<Comment> getCommentList() {
        return this.comments;
    }

    public void setCommentList(List<Comment> list) {
        this.comments = list;
    }
}

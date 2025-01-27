package com.martian.mibook.data.book;

import com.martian.mibook.mvvm.read.comment.Comment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MiBookGetCommentByScoreItemList {
    private List<Comment> comments;

    public MiBookGetCommentByScoreItemList(List<Comment> list) {
        this.comments = list;
    }

    public List<Comment> getCommentList() {
        if (this.comments == null) {
            this.comments = new ArrayList();
        }
        return this.comments;
    }

    public void setCommentList(List<Comment> list) {
        this.comments = list;
    }
}

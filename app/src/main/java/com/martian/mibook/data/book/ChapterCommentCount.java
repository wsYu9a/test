package com.martian.mibook.data.book;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChapterCommentCount {
    private String chapterId;
    private List<Comment> list;
    private Integer nComments;

    public void addComment(Comment comment) {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        this.list.add(0, comment);
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public List<Comment> getList() {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        return this.list;
    }

    public int getNComments() {
        Integer num = this.nComments;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void incrNComments() {
        this.nComments = Integer.valueOf(this.nComments.intValue() + 1);
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }

    public void setNComments(Integer nComments) {
        this.nComments = nComments;
    }
}

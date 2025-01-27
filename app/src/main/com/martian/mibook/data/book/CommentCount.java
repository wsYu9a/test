package com.martian.mibook.data.book;

import com.martian.mibook.mvvm.read.comment.Comment;
import hf.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CommentCount {
    private String chapterId;
    private Boolean hasComment;
    private List<Comment> list;
    private Integer nComments;
    private Integer paragraphIdx;
    private int type;

    public void addComment(Comment comment) {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        this.list.add(0, comment);
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public String getEditTag() {
        if (isChapterComment()) {
            return this.chapterId;
        }
        if (!isParagraphComment()) {
            return this.type + "";
        }
        return this.chapterId + e.f26694a + this.paragraphIdx;
    }

    public Boolean getHasComment() {
        return this.hasComment;
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

    public Integer getParagraphIdx() {
        return this.paragraphIdx;
    }

    public int getType() {
        return this.type;
    }

    public void incrNComments() {
        if (this.nComments == null) {
            this.nComments = 0;
        }
        this.nComments = Integer.valueOf(this.nComments.intValue() + 1);
    }

    public boolean isBookComment() {
        return this.type == 1;
    }

    public boolean isChapterComment() {
        return this.type == 2;
    }

    public boolean isParagraphComment() {
        return this.type == 3;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setHasComment(Boolean bool) {
        this.hasComment = bool;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }

    public void setNComments(Integer num) {
        this.nComments = num;
    }

    public void setParagraphIdx(Integer num) {
        this.paragraphIdx = num;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setnComments(Integer num) {
        this.nComments = num;
    }
}

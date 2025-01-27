package com.martian.mibook.data.book;

import com.martian.mibook.mvvm.read.comment.Comment;
import java.util.List;

/* loaded from: classes3.dex */
public class MiBookCommentItemList {
    private Integer bookShelfCount;
    private Integer clickCount;
    private List<Comment> comments;
    private Integer nComments;
    private Integer nStars;
    private Integer readingCount;
    private Integer score;
    private Integer scores;

    public MiBookCommentItemList(List<Comment> list) {
        this.comments = list;
    }

    public int getBookShelfCount() {
        Integer num = this.bookShelfCount;
        if (num == null) {
            return 3000;
        }
        return num.intValue();
    }

    public int getClickCount() {
        Integer num = this.clickCount;
        if (num == null) {
            return 3000;
        }
        return num.intValue();
    }

    public List<Comment> getCommentList() {
        return this.comments;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public Integer getNComments() {
        Integer num = this.nComments;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getNStars() {
        Integer num = this.nStars;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getReadingCount() {
        Integer num = this.readingCount;
        return Integer.valueOf(num == null ? 3000 : num.intValue());
    }

    public float getScore() {
        if (this.score == null) {
            return -1.0f;
        }
        return r0.intValue() / 10.0f;
    }

    public Integer getScores() {
        Integer num = this.scores;
        return Integer.valueOf(num == null ? -1 : num.intValue());
    }

    public void setBookShelfCount(Integer num) {
        this.bookShelfCount = num;
    }

    public void setClickCount(Integer num) {
        this.clickCount = num;
    }

    public void setCommentList(List<Comment> list) {
        this.comments = list;
    }

    public void setComments(List<Comment> list) {
        this.comments = list;
    }

    public void setNComments(Integer num) {
        this.nComments = num;
    }

    public void setNStars(Integer num) {
        this.nStars = num;
    }

    public void setReadingCount(Integer num) {
        this.readingCount = num;
    }

    public void setScore(Integer num) {
        this.score = num;
    }

    public void setScores(Integer num) {
        this.scores = num;
    }
}

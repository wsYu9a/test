package com.martian.mibook.data.book;

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

    public MiBookCommentItemList(List<Comment> comments) {
        this.comments = comments;
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

    public void setBookShelfCount(Integer bookShelfCount) {
        this.bookShelfCount = bookShelfCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public void setCommentList(List<Comment> comments) {
        this.comments = comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setNComments(Integer nComments) {
        this.nComments = nComments;
    }

    public void setNStars(Integer nStars) {
        this.nStars = nStars;
    }

    public void setReadingCount(Integer readingCount) {
        this.readingCount = readingCount;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }
}

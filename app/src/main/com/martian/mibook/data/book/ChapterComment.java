package com.martian.mibook.data.book;

import java.util.List;

/* loaded from: classes3.dex */
public class ChapterComment {
    private List<CommentCount> chapterComments;
    private List<CommentCount> paragraphComments;

    public List<CommentCount> getChapterComments() {
        return this.chapterComments;
    }

    public List<CommentCount> getParagraphComments() {
        return this.paragraphComments;
    }

    public void setChapterComments(List<CommentCount> list) {
        this.chapterComments = list;
    }

    public void setParagraphComments(List<CommentCount> list) {
        this.paragraphComments = list;
    }
}

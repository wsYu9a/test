package com.martian.mibook.data.book;

import com.martian.mibook.mvvm.read.comment.Comment;
import java.util.List;
import kotlin.Metadata;
import xi.l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001e\u0010#\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001e\u0010&\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001e\u0010)\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001e\u0010,\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001f¨\u00062"}, d2 = {"Lcom/martian/mibook/data/book/ReadingInfo;", "", "()V", "allWords", "", "getAllWords", "()Ljava/lang/Integer;", "setAllWords", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "brtype", "getBrtype", "setBrtype", "categoryName", "", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "clickCount", "getClickCount", "setClickCount", "freeType", "getFreeType", "setFreeType", "hotComments", "", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "getHotComments", "()Ljava/util/List;", "setHotComments", "(Ljava/util/List;)V", "intro", "getIntro", "setIntro", "nComments", "getNComments", "setNComments", "rank", "getRank", "setRank", "readingCount", "getReadingCount", "setReadingCount", "score", "getScore", "setScore", "tagList", "getTagList", "setTagList", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReadingInfo {

    @l
    private Integer allWords;

    @l
    private Integer brtype;

    @l
    private String categoryName;

    @l
    private Integer clickCount;

    @l
    private Integer freeType;

    @l
    private List<Comment> hotComments;

    @l
    private String intro;

    @l
    private Integer nComments;

    @l
    private Integer rank;

    @l
    private Integer readingCount;

    @l
    private Integer score;

    @l
    private List<String> tagList;

    @l
    public final Integer getAllWords() {
        return this.allWords;
    }

    @l
    public final Integer getBrtype() {
        return this.brtype;
    }

    @l
    public final String getCategoryName() {
        return this.categoryName;
    }

    @l
    public final Integer getClickCount() {
        return this.clickCount;
    }

    @l
    public final Integer getFreeType() {
        return this.freeType;
    }

    @l
    public final List<Comment> getHotComments() {
        return this.hotComments;
    }

    @l
    public final String getIntro() {
        return this.intro;
    }

    @l
    public final Integer getNComments() {
        return this.nComments;
    }

    @l
    public final Integer getRank() {
        return this.rank;
    }

    @l
    public final Integer getReadingCount() {
        return this.readingCount;
    }

    @l
    public final Integer getScore() {
        return this.score;
    }

    @l
    public final List<String> getTagList() {
        return this.tagList;
    }

    public final void setAllWords(@l Integer num) {
        this.allWords = num;
    }

    public final void setBrtype(@l Integer num) {
        this.brtype = num;
    }

    public final void setCategoryName(@l String str) {
        this.categoryName = str;
    }

    public final void setClickCount(@l Integer num) {
        this.clickCount = num;
    }

    public final void setFreeType(@l Integer num) {
        this.freeType = num;
    }

    public final void setHotComments(@l List<Comment> list) {
        this.hotComments = list;
    }

    public final void setIntro(@l String str) {
        this.intro = str;
    }

    public final void setNComments(@l Integer num) {
        this.nComments = num;
    }

    public final void setRank(@l Integer num) {
        this.rank = num;
    }

    public final void setReadingCount(@l Integer num) {
        this.readingCount = num;
    }

    public final void setScore(@l Integer num) {
        this.score = num;
    }

    public final void setTagList(@l List<String> list) {
        this.tagList = list;
    }
}

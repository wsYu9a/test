package com.martian.mibook.mvvm.book.viewmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.umeng.analytics.pro.f;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vb.e;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\bL\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010T\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010W\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010X\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017HÆ\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010HJ\u0010\u0010c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$Jò\u0001\u0010d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020\u00102\b\u0010g\u001a\u0004\u0018\u00010hHÖ\u0003J\u0006\u0010i\u001a\u00020\u0003J\t\u0010j\u001a\u00020\u0007HÖ\u0001J\t\u0010k\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001e\"\u0004\bM\u0010 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001e\"\u0004\bO\u0010 R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010+\"\u0004\bQ\u0010-¨\u0006l"}, d2 = {"Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "Ljava/io/Serializable;", "sourceId", "", "sourceName", "bookName", "price", "", f.X, "recommend", "recommendId", "score", "", "nComments", "nStars", "postComment", "", "authorName", "clickCount", "readingCount", "myComment", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "tagList", "", "hotCommentList", "", "rankInfo", "Lcom/martian/mibook/activity/book/BookRankActivity$RankInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/martian/mibook/mvvm/read/comment/Comment;Ljava/util/List;Ljava/util/List;Lcom/martian/mibook/activity/book/BookRankActivity$RankInfo;)V", "getAuthorName", "()Ljava/lang/String;", "setAuthorName", "(Ljava/lang/String;)V", "getBookName", "setBookName", "getClickCount", "()Ljava/lang/Integer;", "setClickCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContext", "setContext", "getHotCommentList", "()Ljava/util/List;", "setHotCommentList", "(Ljava/util/List;)V", "getMyComment", "()Lcom/martian/mibook/mvvm/read/comment/Comment;", "setMyComment", "(Lcom/martian/mibook/mvvm/read/comment/Comment;)V", "getNComments", "setNComments", "getNStars", "setNStars", "getPostComment", "()Ljava/lang/Boolean;", "setPostComment", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPrice", "setPrice", "getRankInfo", "()Lcom/martian/mibook/activity/book/BookRankActivity$RankInfo;", "setRankInfo", "(Lcom/martian/mibook/activity/book/BookRankActivity$RankInfo;)V", "getReadingCount", "setReadingCount", "getRecommend", "setRecommend", "getRecommendId", "setRecommendId", "getScore", "()Ljava/lang/Float;", "setScore", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getSourceId", "setSourceId", "getSourceName", "setSourceName", "getTagList", "setTagList", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/martian/mibook/mvvm/read/comment/Comment;Ljava/util/List;Ljava/util/List;Lcom/martian/mibook/activity/book/BookRankActivity$RankInfo;)Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "equals", AdnName.OTHER, "", "getSourceString", TTDownloadField.TT_HASHCODE, "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BookInfo implements Serializable {

    @l
    private String authorName;

    @l
    private String bookName;

    @l
    private Integer clickCount;

    @l
    private String context;

    @l
    private List<Comment> hotCommentList;

    @l
    private Comment myComment;

    @l
    private Integer nComments;

    @l
    private Integer nStars;

    @l
    private Boolean postComment;

    @l
    private Integer price;

    @l
    private BookRankActivity.RankInfo rankInfo;

    @l
    private Integer readingCount;

    @l
    private String recommend;

    @l
    private String recommendId;

    @l
    private Float score;

    @l
    private String sourceId;

    @l
    private String sourceName;

    @l
    private List<String> tagList;

    public BookInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    /* renamed from: component10, reason: from getter */
    public final Integer getNStars() {
        return this.nStars;
    }

    @l
    /* renamed from: component11, reason: from getter */
    public final Boolean getPostComment() {
        return this.postComment;
    }

    @l
    /* renamed from: component12, reason: from getter */
    public final String getAuthorName() {
        return this.authorName;
    }

    @l
    /* renamed from: component13, reason: from getter */
    public final Integer getClickCount() {
        return this.clickCount;
    }

    @l
    /* renamed from: component14, reason: from getter */
    public final Integer getReadingCount() {
        return this.readingCount;
    }

    @l
    /* renamed from: component15, reason: from getter */
    public final Comment getMyComment() {
        return this.myComment;
    }

    @l
    public final List<String> component16() {
        return this.tagList;
    }

    @l
    public final List<Comment> component17() {
        return this.hotCommentList;
    }

    @l
    /* renamed from: component18, reason: from getter */
    public final BookRankActivity.RankInfo getRankInfo() {
        return this.rankInfo;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final String getBookName() {
        return this.bookName;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final Integer getPrice() {
        return this.price;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final String getContext() {
        return this.context;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final String getRecommend() {
        return this.recommend;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final String getRecommendId() {
        return this.recommendId;
    }

    @l
    /* renamed from: component8, reason: from getter */
    public final Float getScore() {
        return this.score;
    }

    @l
    /* renamed from: component9, reason: from getter */
    public final Integer getNComments() {
        return this.nComments;
    }

    @k
    public final BookInfo copy(@l String sourceId, @l String sourceName, @l String bookName, @l Integer price, @l String r25, @l String recommend, @l String recommendId, @l Float score, @l Integer nComments, @l Integer nStars, @l Boolean postComment, @l String authorName, @l Integer clickCount, @l Integer readingCount, @l Comment myComment, @l List<String> tagList, @l List<Comment> hotCommentList, @l BookRankActivity.RankInfo rankInfo) {
        return new BookInfo(sourceId, sourceName, bookName, price, r25, recommend, recommendId, score, nComments, nStars, postComment, authorName, clickCount, readingCount, myComment, tagList, hotCommentList, rankInfo);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof BookInfo)) {
            return false;
        }
        BookInfo bookInfo = (BookInfo) r52;
        return Intrinsics.areEqual(this.sourceId, bookInfo.sourceId) && Intrinsics.areEqual(this.sourceName, bookInfo.sourceName) && Intrinsics.areEqual(this.bookName, bookInfo.bookName) && Intrinsics.areEqual(this.price, bookInfo.price) && Intrinsics.areEqual(this.context, bookInfo.context) && Intrinsics.areEqual(this.recommend, bookInfo.recommend) && Intrinsics.areEqual(this.recommendId, bookInfo.recommendId) && Intrinsics.areEqual((Object) this.score, (Object) bookInfo.score) && Intrinsics.areEqual(this.nComments, bookInfo.nComments) && Intrinsics.areEqual(this.nStars, bookInfo.nStars) && Intrinsics.areEqual(this.postComment, bookInfo.postComment) && Intrinsics.areEqual(this.authorName, bookInfo.authorName) && Intrinsics.areEqual(this.clickCount, bookInfo.clickCount) && Intrinsics.areEqual(this.readingCount, bookInfo.readingCount) && Intrinsics.areEqual(this.myComment, bookInfo.myComment) && Intrinsics.areEqual(this.tagList, bookInfo.tagList) && Intrinsics.areEqual(this.hotCommentList, bookInfo.hotCommentList) && Intrinsics.areEqual(this.rankInfo, bookInfo.rankInfo);
    }

    @l
    public final String getAuthorName() {
        return this.authorName;
    }

    @l
    public final String getBookName() {
        return this.bookName;
    }

    @l
    public final Integer getClickCount() {
        return this.clickCount;
    }

    @l
    public final String getContext() {
        return this.context;
    }

    @l
    public final List<Comment> getHotCommentList() {
        return this.hotCommentList;
    }

    @l
    public final Comment getMyComment() {
        return this.myComment;
    }

    @l
    public final Integer getNComments() {
        return this.nComments;
    }

    @l
    public final Integer getNStars() {
        return this.nStars;
    }

    @l
    public final Boolean getPostComment() {
        return this.postComment;
    }

    @l
    public final Integer getPrice() {
        return this.price;
    }

    @l
    public final BookRankActivity.RankInfo getRankInfo() {
        return this.rankInfo;
    }

    @l
    public final Integer getReadingCount() {
        return this.readingCount;
    }

    @l
    public final String getRecommend() {
        return this.recommend;
    }

    @l
    public final String getRecommendId() {
        return this.recommendId;
    }

    @l
    public final Float getScore() {
        return this.score;
    }

    @l
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    public final String getSourceName() {
        return this.sourceName;
    }

    @k
    public final String getSourceString() {
        String j10 = e.j(this.sourceName, this.sourceId);
        Intrinsics.checkNotNullExpressionValue(j10, "getSourceString(...)");
        return j10;
    }

    @l
    public final List<String> getTagList() {
        return this.tagList;
    }

    public int hashCode() {
        String str = this.sourceId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sourceName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bookName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.price;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.context;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.recommend;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.recommendId;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Float f10 = this.score;
        int hashCode8 = (hashCode7 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Integer num2 = this.nComments;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.nStars;
        int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.postComment;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str7 = this.authorName;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num4 = this.clickCount;
        int hashCode13 = (hashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.readingCount;
        int hashCode14 = (hashCode13 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Comment comment = this.myComment;
        int hashCode15 = (hashCode14 + (comment == null ? 0 : comment.hashCode())) * 31;
        List<String> list = this.tagList;
        int hashCode16 = (hashCode15 + (list == null ? 0 : list.hashCode())) * 31;
        List<Comment> list2 = this.hotCommentList;
        int hashCode17 = (hashCode16 + (list2 == null ? 0 : list2.hashCode())) * 31;
        BookRankActivity.RankInfo rankInfo = this.rankInfo;
        return hashCode17 + (rankInfo != null ? rankInfo.hashCode() : 0);
    }

    public final void setAuthorName(@l String str) {
        this.authorName = str;
    }

    public final void setBookName(@l String str) {
        this.bookName = str;
    }

    public final void setClickCount(@l Integer num) {
        this.clickCount = num;
    }

    public final void setContext(@l String str) {
        this.context = str;
    }

    public final void setHotCommentList(@l List<Comment> list) {
        this.hotCommentList = list;
    }

    public final void setMyComment(@l Comment comment) {
        this.myComment = comment;
    }

    public final void setNComments(@l Integer num) {
        this.nComments = num;
    }

    public final void setNStars(@l Integer num) {
        this.nStars = num;
    }

    public final void setPostComment(@l Boolean bool) {
        this.postComment = bool;
    }

    public final void setPrice(@l Integer num) {
        this.price = num;
    }

    public final void setRankInfo(@l BookRankActivity.RankInfo rankInfo) {
        this.rankInfo = rankInfo;
    }

    public final void setReadingCount(@l Integer num) {
        this.readingCount = num;
    }

    public final void setRecommend(@l String str) {
        this.recommend = str;
    }

    public final void setRecommendId(@l String str) {
        this.recommendId = str;
    }

    public final void setScore(@l Float f10) {
        this.score = f10;
    }

    public final void setSourceId(@l String str) {
        this.sourceId = str;
    }

    public final void setSourceName(@l String str) {
        this.sourceName = str;
    }

    public final void setTagList(@l List<String> list) {
        this.tagList = list;
    }

    @k
    public String toString() {
        return "BookInfo(sourceId=" + this.sourceId + ", sourceName=" + this.sourceName + ", bookName=" + this.bookName + ", price=" + this.price + ", context=" + this.context + ", recommend=" + this.recommend + ", recommendId=" + this.recommendId + ", score=" + this.score + ", nComments=" + this.nComments + ", nStars=" + this.nStars + ", postComment=" + this.postComment + ", authorName=" + this.authorName + ", clickCount=" + this.clickCount + ", readingCount=" + this.readingCount + ", myComment=" + this.myComment + ", tagList=" + this.tagList + ", hotCommentList=" + this.hotCommentList + ", rankInfo=" + this.rankInfo + ")";
    }

    public BookInfo(@l String str, @l String str2, @l String str3, @l Integer num, @l String str4, @l String str5, @l String str6, @l Float f10, @l Integer num2, @l Integer num3, @l Boolean bool, @l String str7, @l Integer num4, @l Integer num5, @l Comment comment, @l List<String> list, @l List<Comment> list2, @l BookRankActivity.RankInfo rankInfo) {
        this.sourceId = str;
        this.sourceName = str2;
        this.bookName = str3;
        this.price = num;
        this.context = str4;
        this.recommend = str5;
        this.recommendId = str6;
        this.score = f10;
        this.nComments = num2;
        this.nStars = num3;
        this.postComment = bool;
        this.authorName = str7;
        this.clickCount = num4;
        this.readingCount = num5;
        this.myComment = comment;
        this.tagList = list;
        this.hotCommentList = list2;
        this.rankInfo = rankInfo;
    }

    public /* synthetic */ BookInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, Float f10, Integer num2, Integer num3, Boolean bool, String str7, Integer num4, Integer num5, Comment comment, List list, List list2, BookRankActivity.RankInfo rankInfo, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? Float.valueOf(-1.0f) : f10, (i10 & 256) != 0 ? null : num2, (i10 & 512) != 0 ? null : num3, (i10 & 1024) != 0 ? Boolean.FALSE : bool, (i10 & 2048) != 0 ? null : str7, (i10 & 4096) != 0 ? null : num4, (i10 & 8192) != 0 ? null : num5, (i10 & 16384) != 0 ? null : comment, (i10 & 32768) != 0 ? null : list, (i10 & 65536) != 0 ? null : list2, (i10 & 131072) != 0 ? null : rankInfo);
    }
}

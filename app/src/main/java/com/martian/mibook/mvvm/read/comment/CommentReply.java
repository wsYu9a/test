package com.martian.mibook.mvvm.read.comment;

import bb.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.libmars.widget.FoldedTextView;
import com.martian.mibook.mvvm.extensions.ExtKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bU\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010X\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010[\u001a\u00020\tHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010`\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010SJ\u000b\u0010b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J¾\u0001\u0010f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0000HÆ\u0001¢\u0006\u0002\u0010gJ\u0013\u0010h\u001a\u00020\t2\b\u0010i\u001a\u0004\u0018\u00010jHÖ\u0003J\u0006\u0010k\u001a\u00020\u0007J\t\u0010l\u001a\u00020\u0003HÖ\u0001J\u0006\u0010m\u001a\u00020\tJ\u0006\u0010n\u001a\u00020\tJ\u0006\u0010o\u001a\u00020\tJ\t\u0010p\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\u001e\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\u001a\u00100\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u001a\u00108\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010+\"\u0004\b:\u0010-R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010\u001aR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\bG\u0010\u0018\"\u0004\bH\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001d\"\u0004\bJ\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001d\"\u0004\bL\u0010\u001fR\u001a\u0010M\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00102\"\u0004\bO\u00104R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00102\"\u0004\bQ\u00104R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010V\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006q"}, d2 = {"Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "Ljava/io/Serializable;", "rid", "", "cid", "refRid", "cuid", "", "vip", "", "nickname", "header", "toUid", "toNickname", "content", "upCount", "createdOn", "", "hasUp", "refComment", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "refReply", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;ZLcom/martian/mibook/mvvm/read/comment/Comment;Lcom/martian/mibook/mvvm/read/comment/CommentReply;)V", "getCid", "()Ljava/lang/Integer;", "setCid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreatedOn", "()Ljava/lang/Long;", "setCreatedOn", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCuid", "setCuid", "expLevel", "getExpLevel", "setExpLevel", "getHasUp", "()Z", "setHasUp", "(Z)V", "getHeader", "setHeader", "index", "getIndex", "()I", "setIndex", "(I)V", "loadedCommentSize", "getLoadedCommentSize", "setLoadedCommentSize", "loading", "getLoading", "setLoading", "getNickname", "setNickname", "getRefComment", "()Lcom/martian/mibook/mvvm/read/comment/Comment;", "setRefComment", "(Lcom/martian/mibook/mvvm/read/comment/Comment;)V", "getRefReply", "()Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "setRefReply", "(Lcom/martian/mibook/mvvm/read/comment/CommentReply;)V", "getRefRid", "setRefRid", "getRid", "setRid", "getToNickname", "setToNickname", "getToUid", "setToUid", "totalCommentSize", "getTotalCommentSize", "setTotalCommentSize", "getUpCount", "setUpCount", "getVip", "()Ljava/lang/Boolean;", "setVip", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;ZLcom/martian/mibook/mvvm/read/comment/Comment;Lcom/martian/mibook/mvvm/read/comment/CommentReply;)Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "equals", AdnName.OTHER, "", "getExpandDesc", TTDownloadField.TT_HASHCODE, "isHasMore", "showExpand", "showMoreReply", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CommentReply implements Serializable {

    @l
    private Integer cid;

    @l
    private String content;

    @l
    private Long createdOn;

    @l
    private String cuid;

    @l
    private Integer expLevel;
    private boolean hasUp;

    @l
    private String header;
    private int index;
    private int loadedCommentSize;
    private boolean loading;

    @l
    private String nickname;

    @l
    private Comment refComment;

    @l
    private CommentReply refReply;

    @l
    private Integer refRid;

    @l
    private Integer rid;

    @l
    private String toNickname;

    @l
    private String toUid;
    private int totalCommentSize;
    private int upCount;

    @l
    private Boolean vip;

    public CommentReply(@l Integer num, @l Integer num2, @l Integer num3, @l String str, @l Boolean bool, @l String str2, @l String str3, @l String str4, @l String str5, @l String str6, int i10, @l Long l10, boolean z10, @l Comment comment, @l CommentReply commentReply) {
        this.rid = num;
        this.cid = num2;
        this.refRid = num3;
        this.cuid = str;
        this.vip = bool;
        this.nickname = str2;
        this.header = str3;
        this.toUid = str4;
        this.toNickname = str5;
        this.content = str6;
        this.upCount = i10;
        this.createdOn = l10;
        this.hasUp = z10;
        this.refComment = comment;
        this.refReply = commentReply;
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Integer getRid() {
        return this.rid;
    }

    @l
    /* renamed from: component10, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component11, reason: from getter */
    public final int getUpCount() {
        return this.upCount;
    }

    @l
    /* renamed from: component12, reason: from getter */
    public final Long getCreatedOn() {
        return this.createdOn;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getHasUp() {
        return this.hasUp;
    }

    @l
    /* renamed from: component14, reason: from getter */
    public final Comment getRefComment() {
        return this.refComment;
    }

    @l
    /* renamed from: component15, reason: from getter */
    public final CommentReply getRefReply() {
        return this.refReply;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final Integer getCid() {
        return this.cid;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final Integer getRefRid() {
        return this.refRid;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final String getCuid() {
        return this.cuid;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final Boolean getVip() {
        return this.vip;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    @l
    /* renamed from: component8, reason: from getter */
    public final String getToUid() {
        return this.toUid;
    }

    @l
    /* renamed from: component9, reason: from getter */
    public final String getToNickname() {
        return this.toNickname;
    }

    @k
    public final CommentReply copy(@l Integer rid, @l Integer cid, @l Integer refRid, @l String cuid, @l Boolean vip, @l String nickname, @l String header, @l String toUid, @l String toNickname, @l String content, int upCount, @l Long createdOn, boolean hasUp, @l Comment refComment, @l CommentReply refReply) {
        return new CommentReply(rid, cid, refRid, cuid, vip, nickname, header, toUid, toNickname, content, upCount, createdOn, hasUp, refComment, refReply);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof CommentReply)) {
            return false;
        }
        CommentReply commentReply = (CommentReply) r52;
        return Intrinsics.areEqual(this.rid, commentReply.rid) && Intrinsics.areEqual(this.cid, commentReply.cid) && Intrinsics.areEqual(this.refRid, commentReply.refRid) && Intrinsics.areEqual(this.cuid, commentReply.cuid) && Intrinsics.areEqual(this.vip, commentReply.vip) && Intrinsics.areEqual(this.nickname, commentReply.nickname) && Intrinsics.areEqual(this.header, commentReply.header) && Intrinsics.areEqual(this.toUid, commentReply.toUid) && Intrinsics.areEqual(this.toNickname, commentReply.toNickname) && Intrinsics.areEqual(this.content, commentReply.content) && this.upCount == commentReply.upCount && Intrinsics.areEqual(this.createdOn, commentReply.createdOn) && this.hasUp == commentReply.hasUp && Intrinsics.areEqual(this.refComment, commentReply.refComment) && Intrinsics.areEqual(this.refReply, commentReply.refReply);
    }

    @l
    public final Integer getCid() {
        return this.cid;
    }

    @l
    public final String getContent() {
        return this.content;
    }

    @l
    public final Long getCreatedOn() {
        return this.createdOn;
    }

    @l
    public final String getCuid() {
        return this.cuid;
    }

    @l
    public final Integer getExpLevel() {
        return this.expLevel;
    }

    @k
    public final String getExpandDesc() {
        if (!isHasMore()) {
            return ExtKt.c("收起回复");
        }
        if (showMoreReply()) {
            return ExtKt.c("查看更多回复");
        }
        if (this.index != 0) {
            return ExtKt.c("展开更多回复");
        }
        return ExtKt.c(FoldedTextView.A + (this.totalCommentSize - this.loadedCommentSize) + "条回复");
    }

    public final boolean getHasUp() {
        return this.hasUp;
    }

    @l
    public final String getHeader() {
        return this.header;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getLoadedCommentSize() {
        return this.loadedCommentSize;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    @l
    public final String getNickname() {
        return this.nickname;
    }

    @l
    public final Comment getRefComment() {
        return this.refComment;
    }

    @l
    public final CommentReply getRefReply() {
        return this.refReply;
    }

    @l
    public final Integer getRefRid() {
        return this.refRid;
    }

    @l
    public final Integer getRid() {
        return this.rid;
    }

    @l
    public final String getToNickname() {
        return this.toNickname;
    }

    @l
    public final String getToUid() {
        return this.toUid;
    }

    public final int getTotalCommentSize() {
        return this.totalCommentSize;
    }

    public final int getUpCount() {
        return this.upCount;
    }

    @l
    public final Boolean getVip() {
        return this.vip;
    }

    public int hashCode() {
        Integer num = this.rid;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.cid;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.refRid;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.cuid;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.vip;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.nickname;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.header;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.toUid;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.toNickname;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.content;
        int hashCode10 = (((hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.upCount) * 31;
        Long l10 = this.createdOn;
        int hashCode11 = (((hashCode10 + (l10 == null ? 0 : l10.hashCode())) * 31) + a.a(this.hasUp)) * 31;
        Comment comment = this.refComment;
        int hashCode12 = (hashCode11 + (comment == null ? 0 : comment.hashCode())) * 31;
        CommentReply commentReply = this.refReply;
        return hashCode12 + (commentReply != null ? commentReply.hashCode() : 0);
    }

    public final boolean isHasMore() {
        int i10;
        int i11 = this.index;
        int i12 = this.loadedCommentSize;
        return i11 == i12 + (-1) && i12 < (i10 = this.totalCommentSize) && i10 > 1;
    }

    public final void setCid(@l Integer num) {
        this.cid = num;
    }

    public final void setContent(@l String str) {
        this.content = str;
    }

    public final void setCreatedOn(@l Long l10) {
        this.createdOn = l10;
    }

    public final void setCuid(@l String str) {
        this.cuid = str;
    }

    public final void setExpLevel(@l Integer num) {
        this.expLevel = num;
    }

    public final void setHasUp(boolean z10) {
        this.hasUp = z10;
    }

    public final void setHeader(@l String str) {
        this.header = str;
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }

    public final void setLoadedCommentSize(int i10) {
        this.loadedCommentSize = i10;
    }

    public final void setLoading(boolean z10) {
        this.loading = z10;
    }

    public final void setNickname(@l String str) {
        this.nickname = str;
    }

    public final void setRefComment(@l Comment comment) {
        this.refComment = comment;
    }

    public final void setRefReply(@l CommentReply commentReply) {
        this.refReply = commentReply;
    }

    public final void setRefRid(@l Integer num) {
        this.refRid = num;
    }

    public final void setRid(@l Integer num) {
        this.rid = num;
    }

    public final void setToNickname(@l String str) {
        this.toNickname = str;
    }

    public final void setToUid(@l String str) {
        this.toUid = str;
    }

    public final void setTotalCommentSize(int i10) {
        this.totalCommentSize = i10;
    }

    public final void setUpCount(int i10) {
        this.upCount = i10;
    }

    public final void setVip(@l Boolean bool) {
        this.vip = bool;
    }

    public final boolean showExpand() {
        return this.index == this.loadedCommentSize - 1 && this.totalCommentSize > 1;
    }

    public final boolean showMoreReply() {
        return this.totalCommentSize > 50 && this.index >= 9;
    }

    @k
    public String toString() {
        return "CommentReply(rid=" + this.rid + ", cid=" + this.cid + ", refRid=" + this.refRid + ", cuid=" + this.cuid + ", vip=" + this.vip + ", nickname=" + this.nickname + ", header=" + this.header + ", toUid=" + this.toUid + ", toNickname=" + this.toNickname + ", content=" + this.content + ", upCount=" + this.upCount + ", createdOn=" + this.createdOn + ", hasUp=" + this.hasUp + ", refComment=" + this.refComment + ", refReply=" + this.refReply + ")";
    }

    public /* synthetic */ CommentReply(Integer num, Integer num2, Integer num3, String str, Boolean bool, String str2, String str3, String str4, String str5, String str6, int i10, Long l10, boolean z10, Comment comment, CommentReply commentReply, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : num2, (i11 & 4) != 0 ? null : num3, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? Boolean.FALSE : bool, (i11 & 32) != 0 ? null : str2, (i11 & 64) != 0 ? null : str3, (i11 & 128) != 0 ? null : str4, (i11 & 256) != 0 ? null : str5, (i11 & 512) != 0 ? null : str6, (i11 & 1024) != 0 ? 0 : i10, (i11 & 2048) != 0 ? 0L : l10, z10, (i11 & 8192) != 0 ? null : comment, (i11 & 16384) != 0 ? null : commentReply);
    }
}

package com.martian.mibook.mvvm.read.comment;

import bb.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.libmars.widget.FoldedTextView;
import com.martian.mibook.mvvm.extensions.ExtKt;
import h3.e;
import id.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\bZ\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u008b\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0010¢\u0006\u0002\u0010 J\u0010\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010s0rH\u0016J\u0016\u0010t\u001a\u00020u2\u000e\u0010v\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010rJ\u0016\u0010w\u001a\u00020u2\u000e\u0010v\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u000b\u0010x\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010z\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00106J\t\u0010{\u001a\u00020\u0006HÆ\u0003J\t\u0010|\u001a\u00020\u0006HÆ\u0003J\t\u0010}\u001a\u00020\u0006HÆ\u0003J\u000f\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0003J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\n\u0010\u0085\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0010HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u000bHÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0006HÆ\u0003J\u0096\u0002\u0010\u008f\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0003\u0010\u0090\u0001J\u0015\u0010\u0091\u0001\u001a\u00020\u000b2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010sHÖ\u0003J\u001a\u0010\u0093\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010r2\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0006J\u0007\u0010\u0095\u0001\u001a\u00020\u0004J\u000f\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020s0rH\u0016J\n\u0010\u0097\u0001\u001a\u00020\u0006HÖ\u0001J\u001b\u0010\u0098\u0001\u001a\u00020u2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010\u009a\u0001\u001a\u00020\u0006J\u0007\u0010\u009b\u0001\u001a\u00020uJ\n\u0010\u009c\u0001\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\bA\u0010*\"\u0004\bB\u0010,R\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\"\"\u0004\bH\u0010$R\u001a\u0010I\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR\u001a\u0010K\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010=\"\u0004\bM\u0010?R\u001a\u0010N\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010D\"\u0004\bP\u0010FR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\bQ\u00106\"\u0004\bR\u00108R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\"\"\u0004\bT\u0010$R\u001a\u0010U\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010=\"\u0004\bW\u0010?R\u0014\u0010X\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bY\u0010=R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\bZ\u0010*\"\u0004\b[\u0010,R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010=\"\u0004\b]\u0010?R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010=\"\u0004\b_\u0010?R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00100\"\u0004\ba\u00102R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010=\"\u0004\bc\u0010?R\u0011\u0010\u001f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u001a\u0010\u001e\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010e\"\u0004\bg\u0010hR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\bi\u0010*\"\u0004\bj\u0010,R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\"\"\u0004\bl\u0010$R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010=\"\u0004\bn\u0010?R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010D\"\u0004\bp\u0010F¨\u0006\u009d\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/read/comment/Comment;", "Lcom/martian/mibook/mvvm/read/comment/ItemExpand;", "Ljava/io/Serializable;", "uid", "", "type", "", "bookId", "nickname", "header", "vip", "", "content", "score", "readDuration", "createdOn", "", "modifiedOn", "upCount", "downCount", "replyCount", "replyList", "", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "cid", "cuid", "chapterId", "chapterName", "paragraphIdx", "hasUp", "topTime", "siftTime", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Long;Ljava/lang/Long;IIILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZJJ)V", "getBookId", "()Ljava/lang/String;", "setBookId", "(Ljava/lang/String;)V", "getChapterId", "setChapterId", "getChapterName", "setChapterName", "getCid", "()Ljava/lang/Integer;", "setCid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "commentReplyList", "getCommentReplyList", "()Ljava/util/List;", "setCommentReplyList", "(Ljava/util/List;)V", "getContent", "setContent", "getCreatedOn", "()Ljava/lang/Long;", "setCreatedOn", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCuid", "setCuid", "getDownCount", "()I", "setDownCount", "(I)V", "expLevel", "getExpLevel", "setExpLevel", "getHasUp", "()Z", "setHasUp", "(Z)V", "getHeader", "setHeader", "isExpand", "setExpand", "itemGroupPosition", "getItemGroupPosition", "setItemGroupPosition", "loading", "getLoading", "setLoading", "getModifiedOn", "setModifiedOn", "getNickname", "setNickname", "page", "getPage", "setPage", "pageSize", "getPageSize", "getParagraphIdx", "setParagraphIdx", "getReadDuration", "setReadDuration", "getReplyCount", "setReplyCount", "getReplyList", "setReplyList", "getScore", "setScore", "getSiftTime", "()J", "getTopTime", "setTopTime", "(J)V", "getType", "setType", "getUid", "setUid", "getUpCount", "setUpCount", "getVip", "setVip", "addDefaultExpandItemSubList", "", "", "addExpandCommentReplyList", "", e.f26408m, "addNetMoreCommentReply", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Long;Ljava/lang/Long;IIILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZJJ)Lcom/martian/mibook/mvvm/read/comment/Comment;", "equals", AdnName.OTHER, "getCacheMoreCommentReply", "size", "getExpandDesc", "getItemSublist", TTDownloadField.TT_HASHCODE, "insertNewCommentReply", "commentReply", c.f26972i, "removeExpandCommentReplyList", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comment.kt\ncom/martian/mibook/mvvm/read/comment/Comment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n1864#2,3:133\n1864#2,3:136\n*S KotlinDebug\n*F\n+ 1 Comment.kt\ncom/martian/mibook/mvvm/read/comment/Comment\n*L\n82#1:133,3\n96#1:136,3\n*E\n"})
/* loaded from: classes3.dex */
public final /* data */ class Comment implements ItemExpand, Serializable {

    @l
    private String bookId;

    @l
    private String chapterId;

    @l
    private String chapterName;

    @l
    private Integer cid;

    @k
    private transient List<CommentReply> commentReplyList;

    @l
    private String content;

    @l
    private Long createdOn;

    @l
    private String cuid;
    private int downCount;

    @l
    private Integer expLevel;
    private boolean hasUp;

    @l
    private String header;
    private boolean isExpand;
    private int itemGroupPosition;
    private boolean loading;

    @l
    private Long modifiedOn;

    @l
    private String nickname;
    private int page;
    private final int pageSize;

    @l
    private Integer paragraphIdx;
    private int readDuration;
    private int replyCount;

    @k
    private List<CommentReply> replyList;
    private int score;
    private final long siftTime;
    private long topTime;

    @l
    private Integer type;

    @l
    private String uid;
    private int upCount;
    private boolean vip;

    public Comment() {
        this(null, null, null, null, null, false, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, null, null, false, 0L, 0L, 8388607, null);
    }

    public static /* synthetic */ List getCacheMoreCommentReply$default(Comment comment, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = comment.pageSize;
        }
        return comment.getCacheMoreCommentReply(i10);
    }

    @Override // com.martian.mibook.mvvm.read.comment.ItemExpand
    @k
    public List<Object> addDefaultExpandItemSubList() {
        if (this.commentReplyList.isEmpty() && (!this.replyList.isEmpty())) {
            CommentReply commentReply = this.replyList.get(0);
            commentReply.setLoadedCommentSize(1);
            commentReply.setTotalCommentSize(this.replyCount);
            commentReply.setIndex(0);
            this.commentReplyList.add(0, commentReply);
            CollectionsKt.retainAll((List) this.replyList, (Function1) new Function1<CommentReply, Boolean>() { // from class: com.martian.mibook.mvvm.read.comment.Comment$addDefaultExpandItemSubList$2
                public Comment$addDefaultExpandItemSubList$2() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @k
                public final Boolean invoke(@k CommentReply it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it, CollectionsKt.firstOrNull((List) Comment.this.getReplyList())));
                }
            });
        }
        return this.commentReplyList;
    }

    public final void addExpandCommentReplyList(@l List<CommentReply> r62) {
        List<CommentReply> list = r62;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.commentReplyList.addAll(list);
        int size = this.commentReplyList.size();
        int i10 = 0;
        for (Object obj : this.commentReplyList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CommentReply commentReply = (CommentReply) obj;
            commentReply.setLoadedCommentSize(size);
            commentReply.setTotalCommentSize(this.replyCount);
            commentReply.setIndex(i10);
            i10 = i11;
        }
    }

    public final void addNetMoreCommentReply(@l List<CommentReply> r22) {
        List<CommentReply> list = r22;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.replyList.addAll(list);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    @l
    /* renamed from: component10, reason: from getter */
    public final Long getCreatedOn() {
        return this.createdOn;
    }

    @l
    /* renamed from: component11, reason: from getter */
    public final Long getModifiedOn() {
        return this.modifiedOn;
    }

    /* renamed from: component12, reason: from getter */
    public final int getUpCount() {
        return this.upCount;
    }

    /* renamed from: component13, reason: from getter */
    public final int getDownCount() {
        return this.downCount;
    }

    /* renamed from: component14, reason: from getter */
    public final int getReplyCount() {
        return this.replyCount;
    }

    @k
    public final List<CommentReply> component15() {
        return this.replyList;
    }

    @l
    /* renamed from: component16, reason: from getter */
    public final Integer getCid() {
        return this.cid;
    }

    @l
    /* renamed from: component17, reason: from getter */
    public final String getCuid() {
        return this.cuid;
    }

    @l
    /* renamed from: component18, reason: from getter */
    public final String getChapterId() {
        return this.chapterId;
    }

    @l
    /* renamed from: component19, reason: from getter */
    public final String getChapterName() {
        return this.chapterName;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @l
    /* renamed from: component20, reason: from getter */
    public final Integer getParagraphIdx() {
        return this.paragraphIdx;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getHasUp() {
        return this.hasUp;
    }

    /* renamed from: component22, reason: from getter */
    public final long getTopTime() {
        return this.topTime;
    }

    /* renamed from: component23, reason: from getter */
    public final long getSiftTime() {
        return this.siftTime;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final String getBookId() {
        return this.bookId;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getVip() {
        return this.vip;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component8, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* renamed from: component9, reason: from getter */
    public final int getReadDuration() {
        return this.readDuration;
    }

    @k
    public final Comment copy(@l String uid, @l Integer type, @l String bookId, @l String nickname, @l String header, boolean vip, @l String content, int score, int readDuration, @l Long createdOn, @l Long modifiedOn, int upCount, int downCount, int replyCount, @k List<CommentReply> replyList, @l Integer cid, @l String cuid, @l String chapterId, @l String chapterName, @l Integer paragraphIdx, boolean hasUp, long topTime, long siftTime) {
        Intrinsics.checkNotNullParameter(replyList, "replyList");
        return new Comment(uid, type, bookId, nickname, header, vip, content, score, readDuration, createdOn, modifiedOn, upCount, downCount, replyCount, replyList, cid, cuid, chapterId, chapterName, paragraphIdx, hasUp, topTime, siftTime);
    }

    public boolean equals(@l Object r82) {
        if (this == r82) {
            return true;
        }
        if (!(r82 instanceof Comment)) {
            return false;
        }
        Comment comment = (Comment) r82;
        return Intrinsics.areEqual(this.uid, comment.uid) && Intrinsics.areEqual(this.type, comment.type) && Intrinsics.areEqual(this.bookId, comment.bookId) && Intrinsics.areEqual(this.nickname, comment.nickname) && Intrinsics.areEqual(this.header, comment.header) && this.vip == comment.vip && Intrinsics.areEqual(this.content, comment.content) && this.score == comment.score && this.readDuration == comment.readDuration && Intrinsics.areEqual(this.createdOn, comment.createdOn) && Intrinsics.areEqual(this.modifiedOn, comment.modifiedOn) && this.upCount == comment.upCount && this.downCount == comment.downCount && this.replyCount == comment.replyCount && Intrinsics.areEqual(this.replyList, comment.replyList) && Intrinsics.areEqual(this.cid, comment.cid) && Intrinsics.areEqual(this.cuid, comment.cuid) && Intrinsics.areEqual(this.chapterId, comment.chapterId) && Intrinsics.areEqual(this.chapterName, comment.chapterName) && Intrinsics.areEqual(this.paragraphIdx, comment.paragraphIdx) && this.hasUp == comment.hasUp && this.topTime == comment.topTime && this.siftTime == comment.siftTime;
    }

    @l
    public final String getBookId() {
        return this.bookId;
    }

    @l
    public final List<CommentReply> getCacheMoreCommentReply(int size) {
        int size2 = this.replyList.size();
        if (size2 <= 0) {
            return null;
        }
        int lastIndex = this.commentReplyList.isEmpty() ? 0 : CollectionsKt.getLastIndex(this.commentReplyList) + 1;
        return this.replyList.subList(lastIndex, RangesKt.coerceAtMost(size + lastIndex, size2));
    }

    @l
    public final String getChapterId() {
        return this.chapterId;
    }

    @l
    public final String getChapterName() {
        return this.chapterName;
    }

    @l
    public final Integer getCid() {
        return this.cid;
    }

    @k
    public final List<CommentReply> getCommentReplyList() {
        return this.commentReplyList;
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

    public final int getDownCount() {
        return this.downCount;
    }

    @l
    public final Integer getExpLevel() {
        return this.expLevel;
    }

    @k
    public final String getExpandDesc() {
        return ExtKt.c(FoldedTextView.A + this.replyCount + "条回复");
    }

    public final boolean getHasUp() {
        return this.hasUp;
    }

    @l
    public final String getHeader() {
        return this.header;
    }

    @Override // com.martian.mibook.mvvm.read.comment.ItemExpand
    public int getItemGroupPosition() {
        return this.itemGroupPosition;
    }

    @Override // com.martian.mibook.mvvm.read.comment.ItemExpand
    @k
    public List<Object> getItemSublist() {
        return this.commentReplyList;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    @l
    public final Long getModifiedOn() {
        return this.modifiedOn;
    }

    @l
    public final String getNickname() {
        return this.nickname;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @l
    public final Integer getParagraphIdx() {
        return this.paragraphIdx;
    }

    public final int getReadDuration() {
        return this.readDuration;
    }

    public final int getReplyCount() {
        return this.replyCount;
    }

    @k
    public final List<CommentReply> getReplyList() {
        return this.replyList;
    }

    public final int getScore() {
        return this.score;
    }

    public final long getSiftTime() {
        return this.siftTime;
    }

    public final long getTopTime() {
        return this.topTime;
    }

    @l
    public final Integer getType() {
        return this.type;
    }

    @l
    public final String getUid() {
        return this.uid;
    }

    public final int getUpCount() {
        return this.upCount;
    }

    public final boolean getVip() {
        return this.vip;
    }

    public int hashCode() {
        String str = this.uid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.type;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.bookId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nickname;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.header;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + a.a(this.vip)) * 31;
        String str5 = this.content;
        int hashCode6 = (((((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.score) * 31) + this.readDuration) * 31;
        Long l10 = this.createdOn;
        int hashCode7 = (hashCode6 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.modifiedOn;
        int hashCode8 = (((((((((hashCode7 + (l11 == null ? 0 : l11.hashCode())) * 31) + this.upCount) * 31) + this.downCount) * 31) + this.replyCount) * 31) + this.replyList.hashCode()) * 31;
        Integer num2 = this.cid;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.cuid;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.chapterId;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.chapterName;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num3 = this.paragraphIdx;
        return ((((((hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 31) + a.a(this.hasUp)) * 31) + uc.c.a(this.topTime)) * 31) + uc.c.a(this.siftTime);
    }

    public final void insertNewCommentReply(@l CommentReply commentReply, int r62) {
        if (commentReply == null) {
            return;
        }
        this.replyList.add(r62, commentReply);
        this.replyCount++;
        this.commentReplyList.add(r62, commentReply);
        int size = this.commentReplyList.size();
        int i10 = 0;
        for (Object obj : this.commentReplyList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CommentReply commentReply2 = (CommentReply) obj;
            commentReply2.setLoadedCommentSize(size);
            commentReply2.setTotalCommentSize(this.replyCount);
            commentReply2.setIndex(i10);
            i10 = i11;
        }
    }

    @Override // com.martian.mibook.mvvm.read.comment.ItemExpand
    /* renamed from: isExpand, reason: from getter */
    public boolean getIsExpand() {
        return this.isExpand;
    }

    public final void removeExpandCommentReplyList() {
        this.commentReplyList.clear();
    }

    public final void setBookId(@l String str) {
        this.bookId = str;
    }

    public final void setChapterId(@l String str) {
        this.chapterId = str;
    }

    public final void setChapterName(@l String str) {
        this.chapterName = str;
    }

    public final void setCid(@l Integer num) {
        this.cid = num;
    }

    public final void setCommentReplyList(@k List<CommentReply> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.commentReplyList = list;
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

    public final void setDownCount(int i10) {
        this.downCount = i10;
    }

    public final void setExpLevel(@l Integer num) {
        this.expLevel = num;
    }

    @Override // com.martian.mibook.mvvm.read.comment.ItemExpand
    public void setExpand(boolean z10) {
        this.isExpand = z10;
    }

    public final void setHasUp(boolean z10) {
        this.hasUp = z10;
    }

    public final void setHeader(@l String str) {
        this.header = str;
    }

    @Override // com.martian.mibook.mvvm.read.comment.ItemExpand
    public void setItemGroupPosition(int i10) {
        this.itemGroupPosition = i10;
    }

    public final void setLoading(boolean z10) {
        this.loading = z10;
    }

    public final void setModifiedOn(@l Long l10) {
        this.modifiedOn = l10;
    }

    public final void setNickname(@l String str) {
        this.nickname = str;
    }

    public final void setPage(int i10) {
        this.page = i10;
    }

    public final void setParagraphIdx(@l Integer num) {
        this.paragraphIdx = num;
    }

    public final void setReadDuration(int i10) {
        this.readDuration = i10;
    }

    public final void setReplyCount(int i10) {
        this.replyCount = i10;
    }

    public final void setReplyList(@k List<CommentReply> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.replyList = list;
    }

    public final void setScore(int i10) {
        this.score = i10;
    }

    public final void setTopTime(long j10) {
        this.topTime = j10;
    }

    public final void setType(@l Integer num) {
        this.type = num;
    }

    public final void setUid(@l String str) {
        this.uid = str;
    }

    public final void setUpCount(int i10) {
        this.upCount = i10;
    }

    public final void setVip(boolean z10) {
        this.vip = z10;
    }

    @k
    public String toString() {
        return "Comment(uid=" + this.uid + ", type=" + this.type + ", bookId=" + this.bookId + ", nickname=" + this.nickname + ", header=" + this.header + ", vip=" + this.vip + ", content=" + this.content + ", score=" + this.score + ", readDuration=" + this.readDuration + ", createdOn=" + this.createdOn + ", modifiedOn=" + this.modifiedOn + ", upCount=" + this.upCount + ", downCount=" + this.downCount + ", replyCount=" + this.replyCount + ", replyList=" + this.replyList + ", cid=" + this.cid + ", cuid=" + this.cuid + ", chapterId=" + this.chapterId + ", chapterName=" + this.chapterName + ", paragraphIdx=" + this.paragraphIdx + ", hasUp=" + this.hasUp + ", topTime=" + this.topTime + ", siftTime=" + this.siftTime + ")";
    }

    public Comment(@l String str, @l Integer num, @l String str2, @l String str3, @l String str4, boolean z10, @l String str5, int i10, int i11, @l Long l10, @l Long l11, int i12, int i13, int i14, @k List<CommentReply> replyList, @l Integer num2, @l String str6, @l String str7, @l String str8, @l Integer num3, boolean z11, long j10, long j11) {
        Intrinsics.checkNotNullParameter(replyList, "replyList");
        this.uid = str;
        this.type = num;
        this.bookId = str2;
        this.nickname = str3;
        this.header = str4;
        this.vip = z10;
        this.content = str5;
        this.score = i10;
        this.readDuration = i11;
        this.createdOn = l10;
        this.modifiedOn = l11;
        this.upCount = i12;
        this.downCount = i13;
        this.replyCount = i14;
        this.replyList = replyList;
        this.cid = num2;
        this.cuid = str6;
        this.chapterId = str7;
        this.chapterName = str8;
        this.paragraphIdx = num3;
        this.hasUp = z11;
        this.topTime = j10;
        this.siftTime = j11;
        this.pageSize = 5;
        this.commentReplyList = new ArrayList();
    }

    public /* synthetic */ Comment(String str, Integer num, String str2, String str3, String str4, boolean z10, String str5, int i10, int i11, Long l10, Long l11, int i12, int i13, int i14, List list, Integer num2, String str6, String str7, String str8, Integer num3, boolean z11, long j10, long j11, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? null : str, (i15 & 2) != 0 ? null : num, (i15 & 4) != 0 ? null : str2, (i15 & 8) != 0 ? null : str3, (i15 & 16) != 0 ? null : str4, (i15 & 32) != 0 ? false : z10, (i15 & 64) != 0 ? null : str5, (i15 & 128) != 0 ? 100 : i10, (i15 & 256) != 0 ? 0 : i11, (i15 & 512) != 0 ? null : l10, (i15 & 1024) != 0 ? null : l11, (i15 & 2048) != 0 ? 0 : i12, (i15 & 4096) != 0 ? 0 : i13, (i15 & 8192) != 0 ? 0 : i14, (i15 & 16384) != 0 ? new ArrayList() : list, (i15 & 32768) != 0 ? null : num2, (i15 & 65536) != 0 ? null : str6, (i15 & 131072) != 0 ? null : str7, (i15 & 262144) != 0 ? null : str8, (i15 & 524288) != 0 ? null : num3, (i15 & 1048576) != 0 ? false : z11, (i15 & 2097152) != 0 ? 0L : j10, (i15 & 4194304) == 0 ? j11 : 0L);
    }
}

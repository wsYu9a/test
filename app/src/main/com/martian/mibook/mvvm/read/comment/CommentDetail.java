package com.martian.mibook.mvvm.read.comment;

import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.List;
import kotlin.Metadata;
import xi.l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/martian/mibook/mvvm/read/comment/CommentDetail;", "", "()V", "book", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "getBook", "()Lcom/martian/mibook/lib/model/data/TYBookItem;", "setBook", "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "comment", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "getComment", "()Lcom/martian/mibook/mvvm/read/comment/Comment;", "setComment", "(Lcom/martian/mibook/mvvm/read/comment/Comment;)V", "replyList", "", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "getReplyList", "()Ljava/util/List;", "setReplyList", "(Ljava/util/List;)V", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CommentDetail {

    @l
    private TYBookItem book;

    @l
    private Comment comment;

    @l
    private List<CommentReply> replyList;

    @l
    public final TYBookItem getBook() {
        return this.book;
    }

    @l
    public final Comment getComment() {
        return this.comment;
    }

    @l
    public final List<CommentReply> getReplyList() {
        return this.replyList;
    }

    public final void setBook(@l TYBookItem tYBookItem) {
        this.book = tYBookItem;
    }

    public final void setComment(@l Comment comment) {
        this.comment = comment;
    }

    public final void setReplyList(@l List<CommentReply> list) {
        this.replyList = list;
    }
}

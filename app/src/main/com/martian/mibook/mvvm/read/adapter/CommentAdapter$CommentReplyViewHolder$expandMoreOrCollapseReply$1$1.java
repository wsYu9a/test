package com.martian.mibook.mvvm.read.adapter;

import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentDetail;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$1", f = "CommentAdapter.kt", i = {}, l = {462}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends CommentReply>>, Object> {
    final /* synthetic */ Comment $comment;
    int label;
    final /* synthetic */ CommentAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$1(Comment comment, CommentAdapter commentAdapter, Continuation<? super CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$1> continuation) {
        super(2, continuation);
        this.$comment = comment;
        this.this$0 = commentAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$1(this.$comment, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends CommentReply>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<CommentReply>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        List<CommentReply> replyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$comment.getReplyList().size() - this.$comment.getCommentReplyList().size() > 0) {
                return Comment.getCacheMoreCommentReply$default(this.$comment, 0, 1, null);
            }
            ReaderCommentViewModel mViewModel = this.this$0.getMViewModel();
            Integer cid = this.$comment.getCid();
            int page = this.$comment.getPage();
            int pageSize = this.$comment.getPageSize();
            this.label = 1;
            obj = mViewModel.t(cid, page, pageSize, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CommentDetail commentDetail = (CommentDetail) obj;
        if (commentDetail == null || (replyList = commentDetail.getReplyList()) == null) {
            return null;
        }
        Comment comment = this.$comment;
        if (comment.getPage() == 0) {
            replyList.remove(0);
        }
        int replyCount = comment.getReplyCount() - comment.getReplyList().size();
        if (replyCount < replyList.size()) {
            replyList.subList(replyCount, replyList.size()).clear();
        }
        comment.addNetMoreCommentReply(replyList);
        comment.setPage(comment.getPage() + 1);
        return replyList;
    }

    @l
    /* renamed from: invoke */
    public final Object invoke2(@k CoroutineScope coroutineScope, @l Continuation<? super List<CommentReply>> continuation) {
        return ((CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.martian.mibook.mvvm.read.adapter;

import com.martian.mibook.mvvm.read.adapter.CommentAdapter;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3", f = "CommentAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3 extends SuspendLambda implements Function3<CoroutineScope, List<? extends CommentReply>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Comment $comment;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CommentAdapter this$0;
    final /* synthetic */ CommentAdapter.CommentReplyViewHolder this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3(Comment comment, CommentAdapter commentAdapter, CommentAdapter.CommentReplyViewHolder commentReplyViewHolder, Continuation<? super CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3> continuation) {
        super(3, continuation);
        this.$comment = comment;
        this.this$0 = commentAdapter;
        this.this$1 = commentReplyViewHolder;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, List<? extends CommentReply> list, Continuation<? super Unit> continuation) {
        return invoke2(coroutineScope, (List<CommentReply>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<CommentReply> list = (List) this.L$0;
        List<CommentReply> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            this.$comment.addExpandCommentReplyList(list);
            this.this$0.notifyItemChanged(this.this$1.l(), Boxing.boxInt(1));
            BaseCommentAdapter.p(this.this$0, list, false, this.this$1.l() + 1, 2, null);
        }
        return Unit.INSTANCE;
    }

    @l
    /* renamed from: invoke */
    public final Object invoke2(@k CoroutineScope coroutineScope, @l List<CommentReply> list, @l Continuation<? super Unit> continuation) {
        CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3 commentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3 = new CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3(this.$comment, this.this$0, this.this$1, continuation);
        commentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3.L$0 = list;
        return commentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3.invokeSuspend(Unit.INSTANCE);
    }
}

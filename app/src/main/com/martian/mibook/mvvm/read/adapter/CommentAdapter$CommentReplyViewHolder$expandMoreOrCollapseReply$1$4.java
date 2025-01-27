package com.martian.mibook.mvvm.read.adapter;

import com.martian.mibook.databinding.ItemBookCommentReplyBinding;
import com.martian.mibook.mvvm.read.comment.CommentReply;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$4", f = "CommentAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommentReply $last;
    final /* synthetic */ ItemBookCommentReplyBinding $viewBinding;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$4(CommentReply commentReply, ItemBookCommentReplyBinding itemBookCommentReplyBinding, Continuation<? super CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$4> continuation) {
        super(2, continuation);
        this.$last = commentReply;
        this.$viewBinding = itemBookCommentReplyBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$4(this.$last, this.$viewBinding, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$last.setLoading(false);
        this.$viewBinding.pbExpandLoading.setVisibility(8);
        this.$viewBinding.ivMoreReply.setVisibility(0);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

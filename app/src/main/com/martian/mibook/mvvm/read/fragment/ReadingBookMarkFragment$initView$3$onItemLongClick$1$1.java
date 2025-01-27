package com.martian.mibook.mvvm.read.fragment;

import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.mvvm.read.adapter.BookMarkListAdapter;
import com.martian.mibook.mvvm.read.widget.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment$initView$3$onItemLongClick$1$1", f = "ReadingBookMarkFragment.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingBookMarkFragment$initView$3$onItemLongClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ ReadingBookMarkFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingBookMarkFragment$initView$3$onItemLongClick$1$1(ReadingBookMarkFragment readingBookMarkFragment, int i10, Continuation<? super ReadingBookMarkFragment$initView$3$onItemLongClick$1$1> continuation) {
        super(2, continuation);
        this.this$0 = readingBookMarkFragment;
        this.$position = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingBookMarkFragment$initView$3$onItemLongClick$1$1(this.this$0, this.$position, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        BookMarkListAdapter bookMarkListAdapter;
        a q02;
        BookMarkListAdapter bookMarkListAdapter2;
        BookMarkListAdapter bookMarkListAdapter3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            bookMarkListAdapter = this.this$0.bookMarkListAdapter;
            MiBookMark k10 = bookMarkListAdapter != null ? bookMarkListAdapter.k(this.$position) : null;
            q02 = this.this$0.q0();
            if (q02 != null && q02.Q(false, k10)) {
                bookMarkListAdapter2 = this.this$0.bookMarkListAdapter;
                if (bookMarkListAdapter2 != null) {
                    bookMarkListAdapter2.p(this.$position);
                }
                this.label = 1;
                if (DelayKt.delay(300L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        bookMarkListAdapter3 = this.this$0.bookMarkListAdapter;
        if ((bookMarkListAdapter3 != null ? bookMarkListAdapter3.getPageSize() : 0) <= 0) {
            ReadingBookMarkFragment.m0(this.this$0).rvMarks.setVisibility(8);
            ReadingBookMarkFragment.m0(this.this$0).llEmpty.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingBookMarkFragment$initView$3$onItemLongClick$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

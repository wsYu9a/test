package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import uc.d;
import vc.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Luc/d;", "Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.repository.TagBookListRepository$getCategoryBookList$2", f = "TagBookListRepository.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TagBookListRepository$getCategoryBookList$2 extends SuspendLambda implements Function1<Continuation<? super d<YWCategoryBookList>>, Object> {
    final /* synthetic */ Map<String, String> $param;
    int label;
    final /* synthetic */ TagBookListRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagBookListRepository$getCategoryBookList$2(TagBookListRepository tagBookListRepository, Map<String, String> map, Continuation<? super TagBookListRepository$getCategoryBookList$2> continuation) {
        super(1, continuation);
        this.this$0 = tagBookListRepository;
        this.$param = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new TagBookListRepository$getCategoryBookList$2(this.this$0, this.$param, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object a10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            a10 = this.this$0.a(a.class);
            Map<String, String> map = this.$param;
            this.label = 1;
            obj = ((a) a10).I(map, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function1
    @l
    public final Object invoke(@l Continuation<? super d<YWCategoryBookList>> continuation) {
        return ((TagBookListRepository$getCategoryBookList$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

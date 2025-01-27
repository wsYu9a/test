package com.martian.mibook.mvvm.category.repository;

import com.martian.mibook.lib.yuewen.response.TYCategoryTagGroup;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Luc/d;", "", "Lcom/martian/mibook/lib/yuewen/response/TYCategoryTagGroup;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.category.repository.CategoryRepository$getCategoryTagList$2", f = "CategoryRepository.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CategoryRepository$getCategoryTagList$2 extends SuspendLambda implements Function1<Continuation<? super d<List<TYCategoryTagGroup>>>, Object> {
    final /* synthetic */ int $freeType;
    int label;
    final /* synthetic */ CategoryRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryRepository$getCategoryTagList$2(CategoryRepository categoryRepository, int i10, Continuation<? super CategoryRepository$getCategoryTagList$2> continuation) {
        super(1, continuation);
        this.this$0 = categoryRepository;
        this.$freeType = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new CategoryRepository$getCategoryTagList$2(this.this$0, this.$freeType, continuation);
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
            int i11 = this.$freeType;
            this.label = 1;
            obj = ((a) a10).B(i11, this);
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
    public final Object invoke(@l Continuation<? super d<List<TYCategoryTagGroup>>> continuation) {
        return ((CategoryRepository$getCategoryTagList$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

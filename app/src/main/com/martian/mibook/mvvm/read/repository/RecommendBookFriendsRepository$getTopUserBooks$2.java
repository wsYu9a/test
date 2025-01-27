package com.martian.mibook.mvvm.read.repository;

import com.martian.mibook.lib.model.data.TYBookItem;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Luc/d;", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.read.repository.RecommendBookFriendsRepository$getTopUserBooks$2", f = "RecommendBookFriendsRepository.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class RecommendBookFriendsRepository$getTopUserBooks$2 extends SuspendLambda implements Function1<Continuation<? super d<List<? extends TYBookItem>>>, Object> {
    final /* synthetic */ String $cuid;
    final /* synthetic */ int $page;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ String $sourceId;
    final /* synthetic */ String $sourceName;
    int label;
    final /* synthetic */ RecommendBookFriendsRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendBookFriendsRepository$getTopUserBooks$2(RecommendBookFriendsRepository recommendBookFriendsRepository, String str, String str2, String str3, int i10, int i11, Continuation<? super RecommendBookFriendsRepository$getTopUserBooks$2> continuation) {
        super(1, continuation);
        this.this$0 = recommendBookFriendsRepository;
        this.$sourceName = str;
        this.$sourceId = str2;
        this.$cuid = str3;
        this.$page = i10;
        this.$pageSize = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new RecommendBookFriendsRepository$getTopUserBooks$2(this.this$0, this.$sourceName, this.$sourceId, this.$cuid, this.$page, this.$pageSize, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super d<List<? extends TYBookItem>>> continuation) {
        return invoke2((Continuation<? super d<List<TYBookItem>>>) continuation);
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
            String str = this.$sourceName;
            String str2 = this.$sourceId;
            String str3 = this.$cuid;
            int i11 = this.$page;
            int i12 = this.$pageSize;
            this.label = 1;
            obj = ((a) a10).t(str, str2, str3, i11, i12, this);
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

    @l
    /* renamed from: invoke */
    public final Object invoke2(@l Continuation<? super d<List<TYBookItem>>> continuation) {
        return ((RecommendBookFriendsRepository$getTopUserBooks$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

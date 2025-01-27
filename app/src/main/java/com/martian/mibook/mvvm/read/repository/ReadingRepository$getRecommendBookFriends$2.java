package com.martian.mibook.mvvm.read.repository;

import com.martian.mibook.mvvm.net.result.TYBookTopUser;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Luc/d;", "", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.read.repository.ReadingRepository$getRecommendBookFriends$2", f = "ReadingRepository.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingRepository$getRecommendBookFriends$2 extends SuspendLambda implements Function1<Continuation<? super d<List<? extends TYBookTopUser>>>, Object> {
    final /* synthetic */ int $page;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ Integer $scene;
    final /* synthetic */ Integer $seed;
    final /* synthetic */ String $sourceId;
    final /* synthetic */ String $sourceName;
    int label;
    final /* synthetic */ ReadingRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingRepository$getRecommendBookFriends$2(ReadingRepository readingRepository, String str, String str2, int i10, int i11, Integer num, Integer num2, Continuation<? super ReadingRepository$getRecommendBookFriends$2> continuation) {
        super(1, continuation);
        this.this$0 = readingRepository;
        this.$sourceName = str;
        this.$sourceId = str2;
        this.$page = i10;
        this.$pageSize = i11;
        this.$seed = num;
        this.$scene = num2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new ReadingRepository$getRecommendBookFriends$2(this.this$0, this.$sourceName, this.$sourceId, this.$page, this.$pageSize, this.$seed, this.$scene, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super d<List<? extends TYBookTopUser>>> continuation) {
        return invoke2((Continuation<? super d<List<TYBookTopUser>>>) continuation);
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
            int i11 = this.$page;
            int i12 = this.$pageSize;
            Integer num = this.$seed;
            Integer num2 = this.$scene;
            this.label = 1;
            obj = ((a) a10).w(str, str2, i11, i12, num, num2, this);
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
    public final Object invoke2(@l Continuation<? super d<List<TYBookTopUser>>> continuation) {
        return ((ReadingRepository$getRecommendBookFriends$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

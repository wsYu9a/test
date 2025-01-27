package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.repository.RecommendBookFriendsRepository;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.RecommendBookFriendsViewModel$getRecommendBookFriends$1", f = "RecommendBookFriendsViewModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class RecommendBookFriendsViewModel$getRecommendBookFriends$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RecommendBookFriendsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendBookFriendsViewModel$getRecommendBookFriends$1(RecommendBookFriendsViewModel recommendBookFriendsViewModel, Continuation<? super RecommendBookFriendsViewModel$getRecommendBookFriends$1> continuation) {
        super(2, continuation);
        this.this$0 = recommendBookFriendsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new RecommendBookFriendsViewModel$getRecommendBookFriends$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            RecommendBookFriendsRepository f10 = this.this$0.f();
            String sourceName = this.this$0.getSourceName();
            Intrinsics.checkNotNull(sourceName);
            String sourceId = this.this$0.getSourceId();
            Intrinsics.checkNotNull(sourceId);
            int pageIndex = this.this$0.getPageIndex();
            int pageSize = this.this$0.getPageSize();
            this.label = 1;
            obj = f10.f(sourceName, sourceId, pageIndex, pageSize, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        List list2 = TypeIntrinsics.isMutableList(list) ? list : null;
        ListIterator listIterator = list2 != null ? list2.listIterator() : null;
        while (listIterator != null && listIterator.hasNext()) {
            TYBookTopUser tYBookTopUser = (TYBookTopUser) listIterator.next();
            if (Intrinsics.areEqual(tYBookTopUser.getCuid(), MiConfigSingleton.b2().t2())) {
                listIterator.remove();
            } else {
                List<TYBookItem> readBooks = tYBookTopUser.getReadBooks();
                if (!TypeIntrinsics.isMutableList(readBooks)) {
                    readBooks = null;
                }
                if (readBooks != null) {
                    ListIterator<TYBookItem> listIterator2 = readBooks.listIterator();
                    while (listIterator2.hasNext()) {
                        TYBookItem next = listIterator2.next();
                        if (Intrinsics.areEqual(next.getSourceName(), this.this$0.getSourceName()) && Intrinsics.areEqual(next.getSourceId(), this.this$0.getSourceId())) {
                            listIterator2.remove();
                        } else {
                            next.setInBookStore(MiConfigSingleton.b2().M1().T().v(next.getSourceString()));
                        }
                    }
                }
            }
        }
        mutableLiveData = this.this$0._mRecommendBookFriendsLiveData;
        mutableLiveData.postValue(list);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((RecommendBookFriendsViewModel$getRecommendBookFriends$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

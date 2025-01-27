package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.read.repository.RecommendBookFriendsRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.RecommendBookFriendsViewModel$getTopUserBooks$1", f = "RecommendBookFriendsViewModel.kt", i = {}, l = {TTDownloadField.CALL_EVENT_CONFIG_IS_ENABLE_V3_EVENT}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nRecommendBookFriendsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecommendBookFriendsViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/RecommendBookFriendsViewModel$getTopUserBooks$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1855#2,2:81\n*S KotlinDebug\n*F\n+ 1 RecommendBookFriendsViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/RecommendBookFriendsViewModel$getTopUserBooks$1\n*L\n70#1:81,2\n*E\n"})
/* loaded from: classes3.dex */
public final class RecommendBookFriendsViewModel$getTopUserBooks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RecommendBookFriendsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendBookFriendsViewModel$getTopUserBooks$1(RecommendBookFriendsViewModel recommendBookFriendsViewModel, Continuation<? super RecommendBookFriendsViewModel$getTopUserBooks$1> continuation) {
        super(2, continuation);
        this.this$0 = recommendBookFriendsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new RecommendBookFriendsViewModel$getTopUserBooks$1(this.this$0, continuation);
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
            String cuid = this.this$0.getCuid();
            Intrinsics.checkNotNull(cuid);
            int pageIndex = this.this$0.getPageIndex();
            int pageSize = this.this$0.getPageSize();
            this.label = 1;
            obj = f10.g(sourceName, sourceId, cuid, pageIndex, pageSize, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List<TYBookItem> list = (List) obj;
        if (list != null) {
            for (TYBookItem tYBookItem : list) {
                tYBookItem.setInBookStore(MiConfigSingleton.b2().M1().T().v(tYBookItem.getSourceString()));
            }
        }
        mutableLiveData = this.this$0._mTopUserBooksLiveData;
        mutableLiveData.postValue(list);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((RecommendBookFriendsViewModel$getTopUserBooks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

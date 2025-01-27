package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import me.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$getBookwormRecommend$1", f = "ReadingViewModel.kt", i = {}, l = {1108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$getBookwormRecommend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isDialog;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$getBookwormRecommend$1(ReadingViewModel readingViewModel, boolean z10, Continuation<? super ReadingViewModel$getBookwormRecommend$1> continuation) {
        super(2, continuation);
        this.this$0 = readingViewModel;
        this.$isDialog = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$getBookwormRecommend$1(this.this$0, this.$isDialog, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Long uid;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ReadingRepository f10 = this.this$0.f();
            String sourceName = this.this$0.getSourceName();
            Intrinsics.checkNotNull(sourceName);
            String sourceId = this.this$0.getSourceId();
            Intrinsics.checkNotNull(sourceId);
            Integer boxInt = Boxing.boxInt(new Random().nextInt(10000));
            Integer boxInt2 = Boxing.boxInt(this.$isDialog ? 1 : 2);
            this.label = 1;
            obj = f10.l(sourceName, sourceId, 0, 1, boxInt, boxInt2, this);
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
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            this.this$0.q3(null);
        } else {
            Object first = CollectionsKt.first((List<? extends Object>) list);
            ReadingViewModel readingViewModel = this.this$0;
            TYBookTopUser tYBookTopUser = (TYBookTopUser) first;
            List<TYBookItem> readBooks = tYBookTopUser.getReadBooks();
            if (!TypeIntrinsics.isMutableList(readBooks)) {
                readBooks = null;
            }
            ListIterator<TYBookItem> listIterator = readBooks != null ? readBooks.listIterator() : null;
            while (listIterator != null && listIterator.hasNext()) {
                TYBookItem next = listIterator.next();
                if (Intrinsics.areEqual(next.getSourceName(), readingViewModel.getSourceName()) && Intrinsics.areEqual(next.getSourceId(), readingViewModel.getSourceId())) {
                    listIterator.remove();
                } else {
                    next.setInBookStore(MiConfigSingleton.b2().M1().T().v(next.getSourceString()));
                }
            }
            String cuid = tYBookTopUser.getCuid();
            b s10 = MiConfigSingleton.b2().u2().s();
            if (Intrinsics.areEqual(cuid, (s10 == null || (uid = s10.getUid()) == null) ? null : String.valueOf(uid))) {
                readingViewModel.q3(null);
            } else {
                readingViewModel.q3(tYBookTopUser);
            }
        }
        if (this.$isDialog) {
            mutableLiveData2 = this.this$0._mDialogBookwormLiveData;
            mutableLiveData2.postValue(this.this$0.getTyBookTopUser());
        } else {
            mutableLiveData = this.this$0._mLastPageBookwormLiveData;
            mutableLiveData.postValue(this.this$0.getTyBookTopUser());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingViewModel$getBookwormRecommend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

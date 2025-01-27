package com.martian.mibook.mvvm.ui.viewmodel;

import ac.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.lib.yuewen.response.TYInitialBookList;
import com.martian.mibook.mvvm.ui.repository.AppRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$initBookShelf$1", f = "AppViewModel.kt", i = {}, l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AppViewModel$initBookShelf$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ boolean $bookshelfNeedInitial;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$initBookShelf$1(AppViewModel appViewModel, boolean z10, FragmentActivity fragmentActivity, Continuation<? super AppViewModel$initBookShelf$1> continuation) {
        super(1, continuation);
        this.this$0 = appViewModel;
        this.$bookshelfNeedInitial = z10;
        this.$activity = fragmentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new AppViewModel$initBookShelf$1(this.this$0, this.$bookshelfNeedInitial, this.$activity, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            AppRepository f10 = this.this$0.f();
            boolean z10 = this.$bookshelfNeedInitial;
            this.label = 1;
            obj = f10.i(z10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        TYInitialBookList tYInitialBookList = (TYInitialBookList) obj;
        if (tYInitialBookList != null) {
            FragmentActivity fragmentActivity = this.$activity;
            boolean z11 = this.$bookshelfNeedInitial;
            AppViewModel appViewModel = this.this$0;
            MiConfigSingleton.b2().M1().C2(fragmentActivity);
            if (z11) {
                a.v(fragmentActivity, "投放引流-初始化");
                TYInitialBook R1 = MiConfigSingleton.b2().M1().R1(fragmentActivity, tYInitialBookList.getBookList());
                if (R1 != null) {
                    appViewModel.H0(R1);
                    MiConfigSingleton.b2().M1().F2(1);
                    a.v(fragmentActivity, "投放引流-初始化匹配");
                } else {
                    MiConfigSingleton.b2().M1().F2(2);
                    AppViewModel.L0(appViewModel, fragmentActivity, null, 2, null);
                }
            } else {
                MiConfigSingleton.b2().M1().S1(fragmentActivity, tYInitialBookList.getBookList(), false);
            }
        }
        mutableLiveData = this.this$0._mInitBookShelfLiveData;
        mutableLiveData.postValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    @l
    public final Object invoke(@l Continuation<? super Unit> continuation) {
        return ((AppViewModel$initBookShelf$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

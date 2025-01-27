package com.martian.mibook.mvvm.ui.viewmodel;

import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.tinker.TinkerReport;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$tryPromoteBook$1", f = "AppViewModel.kt", i = {}, l = {TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AppViewModel$tryPromoteBook$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Boolean $immediately;
    int label;
    final /* synthetic */ AppViewModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$tryPromoteBook$1$1", f = "AppViewModel.kt", i = {0, 1, 2, 3}, l = {359, 363, 367, 371}, m = "invokeSuspend", n = {"tryCounter", "tryCounter", "tryCounter", "tryCounter"}, s = {"I$0", "I$0", "I$0", "I$0"})
    /* renamed from: com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$tryPromoteBook$1$1 */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ Boolean $immediately;
        int I$0;
        int label;
        final /* synthetic */ AppViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Boolean bool, AppViewModel appViewModel, FragmentActivity fragmentActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$immediately = bool;
            this.this$0 = appViewModel;
            this.$activity = fragmentActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            return new AnonymousClass1(this.$immediately, this.this$0, this.$activity, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0085 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00e9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0083 -> B:8:0x0086). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @xi.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 276
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$tryPromoteBook$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$tryPromoteBook$1(Boolean bool, AppViewModel appViewModel, FragmentActivity fragmentActivity, Continuation<? super AppViewModel$tryPromoteBook$1> continuation) {
        super(1, continuation);
        this.$immediately = bool;
        this.this$0 = appViewModel;
        this.$activity = fragmentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new AppViewModel$tryPromoteBook$1(this.$immediately, this.this$0, this.$activity, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$immediately, this.this$0, this.$activity, null);
            this.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    @l
    public final Object invoke(@l Continuation<? super Unit> continuation) {
        return ((AppViewModel$tryPromoteBook$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.martian.mibook.mvvm.utils.coroutine;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.utils.coroutine.Coroutine$cancel$1$1", f = "Coroutine.kt", i = {}, l = {219, 221}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class Coroutine$cancel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Coroutine<T>.VoidCallback $it;
    int label;
    final /* synthetic */ Coroutine<T> this$0;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.utils.coroutine.Coroutine$cancel$1$1$1", f = "Coroutine.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.utils.coroutine.Coroutine$cancel$1$1$1 */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Coroutine<T>.VoidCallback $it;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Coroutine<T>.VoidCallback voidCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$it = voidCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$it, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function2<CoroutineScope, Continuation<? super Unit>, Object> block = this.$it.getBlock();
                this.label = 1;
                if (block.invoke(coroutineScope, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Coroutine$cancel$1$1(Coroutine<T>.VoidCallback voidCallback, Coroutine<T> coroutine, Continuation<? super Coroutine$cancel$1$1> continuation) {
        super(2, continuation);
        this.$it = voidCallback;
        this.this$0 = coroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new Coroutine$cancel$1$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$it.getContext() == null) {
                Function2<CoroutineScope, Continuation<? super Unit>, Object> block = this.$it.getBlock();
                CoroutineScope scope = this.this$0.getScope();
                this.label = 1;
                if (block.invoke(scope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                CoroutineContext plus = this.this$0.getScope().getCoroutineContext().plus(this.$it.getContext());
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$it, null);
                this.label = 2;
                if (BuildersKt.withContext(plus, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i10 != 1 && i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((Coroutine$cancel$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

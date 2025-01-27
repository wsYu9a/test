package com.martian.mibook.mvvm.read.activity;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.mvvm.read.activity.ReadingNewActivity$initListener$21;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import l9.i0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReadingNewActivity$initListener$21 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ReadingNewActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.read.activity.ReadingNewActivity$initListener$21$1", f = "ReadingNewActivity.kt", i = {}, l = {678}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.read.activity.ReadingNewActivity$initListener$21$1 */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ReadingNewActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReadingNewActivity readingNewActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = readingNewActivity;
        }

        public static final void invokeSuspend$lambda$0(ReadingNewActivity readingNewActivity) {
            MiConfigSingleton.b2().h2().c();
            readingNewActivity.F0("主题失效");
        }

        public static final void invokeSuspend$lambda$1(ReadingNewActivity readingNewActivity) {
            MiConfigSingleton.b2().h2().t();
            MiConfigSingleton.b2().i2().q();
            readingNewActivity.m4();
            readingNewActivity.y0();
            readingNewActivity.m1().f3(true);
            readingNewActivity.m1().g3(true);
            AppViewModel l12 = readingNewActivity.l1();
            if (l12 != null) {
                l12.x0();
            }
            AppViewModel l13 = readingNewActivity.l1();
            if (l13 != null) {
                l13.y0();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReadingNewActivity readingNewActivity = this.this$0;
            i0.x0(readingNewActivity, readingNewActivity.getResources().getString(R.string.tips), this.this$0.getResources().getString(R.string.vip_theme_expired_tips), this.this$0.getResources().getString(R.string.video_ads_cancel), this.this$0.getResources().getString(R.string.activate_vip), false, new i0.l() { // from class: com.martian.mibook.mvvm.read.activity.c
                public /* synthetic */ c() {
                }

                @Override // l9.i0.l
                public final void a() {
                    ReadingNewActivity$initListener$21.AnonymousClass1.invokeSuspend$lambda$0(ReadingNewActivity.this);
                }
            }, new i0.k() { // from class: com.martian.mibook.mvvm.read.activity.d
                public /* synthetic */ d() {
                }

                @Override // l9.i0.k
                public final void a() {
                    ReadingNewActivity$initListener$21.AnonymousClass1.invokeSuspend$lambda$1(ReadingNewActivity.this);
                }
            });
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingNewActivity$initListener$21(ReadingNewActivity readingNewActivity) {
        super(1);
        this.this$0 = readingNewActivity;
    }

    public static final void invoke$lambda$0() {
    }

    public static final void invoke$lambda$1(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiConfigSingleton.b2().h2().t();
        MiConfigSingleton.b2().i2().q();
        this$0.m4();
        this$0.y0();
        this$0.m1().f3(true);
        this$0.m1().g3(true);
        AppViewModel l12 = this$0.l1();
        if (l12 != null) {
            l12.x0();
        }
        AppViewModel l13 = this$0.l1();
        if (l13 != null) {
            l13.y0();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final void invoke2(@l Boolean bool) {
        MutableLiveData<Boolean> b02;
        AppViewModel l12 = this.this$0.l1();
        if (l12 != null && (b02 = l12.b0()) != null) {
            b02.postValue(null);
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE) && !MiConfigSingleton.b2().K2()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new AnonymousClass1(this.this$0, null), 3, null);
        } else if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            ReadingNewActivity readingNewActivity = this.this$0;
            i0.G0(readingNewActivity, readingNewActivity.getString(R.string.tips), this.this$0.getString(R.string.vip_theme_expired_tips_2), this.this$0.getString(R.string.king_known), false, new i0.k() { // from class: com.martian.mibook.mvvm.read.activity.a
                @Override // l9.i0.k
                public final void a() {
                    ReadingNewActivity$initListener$21.invoke$lambda$0();
                }
            }, new i0.l() { // from class: com.martian.mibook.mvvm.read.activity.b
                public /* synthetic */ b() {
                }

                @Override // l9.i0.l
                public final void a() {
                    ReadingNewActivity$initListener$21.invoke$lambda$1(ReadingNewActivity.this);
                }
            });
        }
    }
}

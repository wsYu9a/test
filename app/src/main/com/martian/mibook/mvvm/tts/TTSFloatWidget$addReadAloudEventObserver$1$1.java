package com.martian.mibook.mvvm.tts;

import android.app.Activity;
import com.martian.mibook.mvvm.tts.activity.AudiobookActivity;
import java.lang.ref.WeakReference;
import java.util.List;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;
import ya.n0;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.TTSFloatWidget$addReadAloudEventObserver$1$1", f = "TTSFloatWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nTTSFloatWidget.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TTSFloatWidget.kt\ncom/martian/mibook/mvvm/tts/TTSFloatWidget$addReadAloudEventObserver$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,307:1\n1864#2,3:308\n*S KotlinDebug\n*F\n+ 1 TTSFloatWidget.kt\ncom/martian/mibook/mvvm/tts/TTSFloatWidget$addReadAloudEventObserver$1$1\n*L\n173#1:308,3\n*E\n"})
/* loaded from: classes3.dex */
public final class TTSFloatWidget$addReadAloudEventObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public TTSFloatWidget$addReadAloudEventObserver$1$1(Continuation<? super TTSFloatWidget$addReadAloudEventObserver$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new TTSFloatWidget$addReadAloudEventObserver$1$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<WeakReference<Activity>> d10 = n0.f33313a.d(AudiobookActivity.class);
        if (d10 != null) {
            int i10 = 0;
            for (Object obj2 : d10) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Activity activity = (Activity) ((WeakReference) obj2).get();
                if (activity != null && (activity instanceof AudiobookActivity)) {
                    if (i10 == n0.f33313a.a() - 1) {
                        return Boxing.boxBoolean(false);
                    }
                    ((AudiobookActivity) activity).finish();
                }
                i10 = i11;
            }
        }
        return Boxing.boxBoolean(true);
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Boolean> continuation) {
        return ((TTSFloatWidget$addReadAloudEventObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

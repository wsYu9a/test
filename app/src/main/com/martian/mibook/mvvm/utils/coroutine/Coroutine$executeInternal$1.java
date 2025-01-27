package com.martian.mibook.mvvm.utils.coroutine;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.m.e;
import com.tencent.bugly.beta.tinker.TinkerReport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.utils.coroutine.Coroutine$executeInternal$1", f = "Coroutine.kt", i = {0, 1, 2, 3, 4, 7, 7, 8, 8, 9, 10}, l = {TinkerReport.KEY_LOADED_EXCEPTION_DEX, 256, 261, 264, 266, 272, 276, 283, 285, 292, 294, 300, 304, 300, 304}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch", "$this$launch", "$this$launch", e.TAG, "$this$launch", e.TAG, "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
@SourceDebugExtension({"SMAP\nCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Coroutine.kt\ncom/martian/mibook/mvvm/utils/coroutine/Coroutine$executeInternal$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Coroutine.kt\ncom/martian/mibook/mvvm/utils/coroutine/Coroutine\n*L\n1#1,249:1\n1#2:250\n170#3,10:251\n187#3:261\n201#3,9:262\n170#3,10:271\n201#3,9:281\n201#3,9:290\n170#3,10:299\n*S KotlinDebug\n*F\n+ 1 Coroutine.kt\ncom/martian/mibook/mvvm/utils/coroutine/Coroutine$executeInternal$1\n*L\n145#1:251,10\n148#1:261\n150#1:262,9\n164#1:271,10\n157#1:281,9\n161#1:290,9\n164#1:299,10\n*E\n"})
/* loaded from: classes3.dex */
public final class Coroutine$executeInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> $block;
    final /* synthetic */ CoroutineContext $context;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Coroutine<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Coroutine$executeInternal$1(Coroutine<T> coroutine, CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super Coroutine$executeInternal$1> continuation) {
        super(2, continuation);
        this.this$0 = coroutine;
        this.$context = coroutineContext;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        Coroutine$executeInternal$1 coroutine$executeInternal$1 = new Coroutine$executeInternal$1(this.this$0, this.$context, this.$block, continuation);
        coroutine$executeInternal$1.L$0 = obj;
        return coroutine$executeInternal$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f0 A[Catch: all -> 0x0025, TRY_ENTER, TryCatch #0 {all -> 0x0025, blocks: (B:11:0x0020, B:33:0x01f0, B:35:0x01f8, B:37:0x01fe, B:39:0x0204, B:42:0x0217), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02c9 A[ORIG_RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fb A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:63:0x0054, B:76:0x0068, B:77:0x00f0, B:79:0x00fb, B:81:0x0101, B:83:0x0107, B:86:0x0117, B:90:0x0071, B:91:0x00c1, B:93:0x00ce, B:94:0x00d5, B:100:0x0082, B:102:0x008a, B:104:0x0090, B:107:0x00a4), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0107 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:63:0x0054, B:76:0x0068, B:77:0x00f0, B:79:0x00fb, B:81:0x0101, B:83:0x0107, B:86:0x0117, B:90:0x0071, B:91:0x00c1, B:93:0x00ce, B:94:0x00d5, B:100:0x0082, B:102:0x008a, B:104:0x0090, B:107:0x00a4), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0117 A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #1 {all -> 0x0059, blocks: (B:63:0x0054, B:76:0x0068, B:77:0x00f0, B:79:0x00fb, B:81:0x0101, B:83:0x0107, B:86:0x0117, B:90:0x0071, B:91:0x00c1, B:93:0x00ce, B:94:0x00d5, B:100:0x0082, B:102:0x008a, B:104:0x0090, B:107:0x00a4), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ce A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:63:0x0054, B:76:0x0068, B:77:0x00f0, B:79:0x00fb, B:81:0x0101, B:83:0x0107, B:86:0x0117, B:90:0x0071, B:91:0x00c1, B:93:0x00ce, B:94:0x00d5, B:100:0x0082, B:102:0x008a, B:104:0x0090, B:107:0x00a4), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00d3  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlinx.coroutines.CoroutineScope] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.utils.coroutine.Coroutine$executeInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((Coroutine$executeInternal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

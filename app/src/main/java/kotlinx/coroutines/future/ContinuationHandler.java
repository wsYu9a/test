package kotlinx.coroutines.future;

import androidx.exifinterface.media.ExifInterface;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import p3.i;
import xi.l;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/future/ContinuationHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/function/BiFunction;", "", "", "cont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "apply", i.f29758c, "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ContinuationHandler<T> implements BiFunction<T, Throwable, Unit> {

    @JvmField
    @l
    public volatile Continuation<? super T> cont;

    public ContinuationHandler(@l Continuation<? super T> continuation) {
        this.cont = continuation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ Unit apply(Object obj, Throwable th2) {
        apply2((ContinuationHandler<T>) obj, th2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r2 = r2.getCause();
     */
    /* renamed from: apply */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void apply2(@xi.l T r2, @xi.l java.lang.Throwable r3) {
        /*
            r1 = this;
            kotlin.coroutines.Continuation<? super T> r0 = r1.cont
            if (r0 != 0) goto L5
            return
        L5:
            if (r3 != 0) goto L11
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.Result.m58constructorimpl(r2)
            r0.resumeWith(r2)
            goto L34
        L11:
            boolean r2 = hi.c.a(r3)
            if (r2 == 0) goto L1c
            java.util.concurrent.CompletionException r2 = hi.d.a(r3)
            goto L1d
        L1c:
            r2 = 0
        L1d:
            if (r2 == 0) goto L27
            java.lang.Throwable r2 = hi.e.a(r2)
            if (r2 != 0) goto L26
            goto L27
        L26:
            r3 = r2
        L27:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r3)
            java.lang.Object r2 = kotlin.Result.m58constructorimpl(r2)
            r0.resumeWith(r2)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.future.ContinuationHandler.apply2(java.lang.Object, java.lang.Throwable):void");
    }
}

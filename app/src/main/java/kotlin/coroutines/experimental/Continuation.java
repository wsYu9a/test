package kotlin.coroutines.experimental;

import androidx.exifinterface.media.ExifInterface;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/experimental/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "", Downloads.RequestHeaders.COLUMN_VALUE, "", "resume", "(Ljava/lang/Object;)V", "", "exception", "resumeWithException", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "context", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public interface Continuation<T> {
    @d
    CoroutineContext getContext();

    void resume(T r1);

    void resumeWithException(@d Throwable exception);
}

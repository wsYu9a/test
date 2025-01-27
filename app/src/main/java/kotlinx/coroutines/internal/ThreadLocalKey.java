package kotlinx.coroutines.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/internal/ThreadLocalKey;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/internal/ThreadLocalElement;", "threadLocal", "Ljava/lang/ThreadLocal;", "(Ljava/lang/ThreadLocal;)V", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@PublishedApi
/* loaded from: classes4.dex */
public final /* data */ class ThreadLocalKey implements CoroutineContext.Key<ThreadLocal<?>> {

    @k
    private final ThreadLocal<?> threadLocal;

    public ThreadLocalKey(@k ThreadLocal<?> threadLocal) {
        this.threadLocal = threadLocal;
    }

    private final ThreadLocal<?> component1() {
        return this.threadLocal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThreadLocalKey copy$default(ThreadLocalKey threadLocalKey, ThreadLocal threadLocal, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            threadLocal = threadLocalKey.threadLocal;
        }
        return threadLocalKey.copy(threadLocal);
    }

    @k
    public final ThreadLocalKey copy(@k ThreadLocal<?> threadLocal) {
        return new ThreadLocalKey(threadLocal);
    }

    public boolean equals(@l Object r42) {
        if (this == r42) {
            return true;
        }
        return (r42 instanceof ThreadLocalKey) && Intrinsics.areEqual(this.threadLocal, ((ThreadLocalKey) r42).threadLocal);
    }

    public int hashCode() {
        return this.threadLocal.hashCode();
    }

    @k
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.threadLocal + ')';
    }
}

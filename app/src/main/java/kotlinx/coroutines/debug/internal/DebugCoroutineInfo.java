package kotlinx.coroutines.debug.internal;

import com.umeng.analytics.pro.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8G¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "source", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", f.X, "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCreationStackBottom", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "lastObservedFrame", "getLastObservedFrame", "lastObservedStackTrace", "lastObservedThread", "Ljava/lang/Thread;", "getLastObservedThread", "()Ljava/lang/Thread;", "sequenceNumber", "", "getSequenceNumber", "()J", "state", "", "getState", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@PublishedApi
/* loaded from: classes4.dex */
public final class DebugCoroutineInfo {

    @k
    private final CoroutineContext context;

    @l
    private final CoroutineStackFrame creationStackBottom;

    @k
    private final List<StackTraceElement> creationStackTrace;

    @l
    private final CoroutineStackFrame lastObservedFrame;

    @k
    private final List<StackTraceElement> lastObservedStackTrace;

    @l
    private final Thread lastObservedThread;
    private final long sequenceNumber;

    @k
    private final String state;

    public DebugCoroutineInfo(@k kotlinx.coroutines.debug.internal.DebugCoroutineInfo debugCoroutineInfo, @k CoroutineContext coroutineContext) {
        this.context = coroutineContext;
        this.creationStackBottom = debugCoroutineInfo.getCreationStackBottom();
        this.sequenceNumber = debugCoroutineInfo.sequenceNumber;
        this.creationStackTrace = debugCoroutineInfo.getCreationStackTrace();
        this.state = debugCoroutineInfo.get_state();
        this.lastObservedThread = debugCoroutineInfo.lastObservedThread;
        this.lastObservedFrame = debugCoroutineInfo.getLastObservedFrame$kotlinx_coroutines_core();
        this.lastObservedStackTrace = debugCoroutineInfo.lastObservedStackTrace();
    }

    @k
    public final CoroutineContext getContext() {
        return this.context;
    }

    @l
    public final CoroutineStackFrame getCreationStackBottom() {
        return this.creationStackBottom;
    }

    @k
    public final List<StackTraceElement> getCreationStackTrace() {
        return this.creationStackTrace;
    }

    @l
    public final CoroutineStackFrame getLastObservedFrame() {
        return this.lastObservedFrame;
    }

    @l
    public final Thread getLastObservedThread() {
        return this.lastObservedThread;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @k
    public final String getState() {
        return this.state;
    }

    @k
    @JvmName(name = "lastObservedStackTrace")
    public final List<StackTraceElement> lastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }
}

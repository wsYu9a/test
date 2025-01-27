package kotlin.coroutines.experimental.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.application.MiConfigSingleton;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B!\u0012\u0006\u0010!\u001a\u00020\u0015\u0012\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0003¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH$¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0012R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00038\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lkotlin/coroutines/experimental/jvm/internal/CoroutineImpl;", "Lkotlin/jvm/internal/Lambda;", "", "Lkotlin/coroutines/experimental/Continuation;", Downloads.RequestHeaders.COLUMN_VALUE, "", "resume", "(Ljava/lang/Object;)V", "", "exception", "resumeWithException", "(Ljava/lang/Throwable;)V", MiConfigSingleton.t0, "doResume", "(Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object;", "completion", "create", "(Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "Lkotlin/coroutines/experimental/Continuation;", "_facade", "", TTDownloadField.TT_LABEL, "I", "Lkotlin/coroutines/experimental/CoroutineContext;", "_context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "context", "getFacade", "()Lkotlin/coroutines/experimental/Continuation;", "facade", "arity", "<init>", "(ILkotlin/coroutines/experimental/Continuation;)V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public abstract class CoroutineImpl extends Lambda<Object> implements Continuation<Object> {
    private final CoroutineContext _context;
    private Continuation<Object> _facade;

    @e
    @JvmField
    protected Continuation<Object> completion;

    @JvmField
    protected int label;

    public CoroutineImpl(int i2, @e Continuation<Object> continuation) {
        super(i2);
        this.completion = continuation;
        this.label = continuation != null ? 0 : -1;
        this._context = continuation != null ? continuation.getContext() : null;
    }

    @d
    public Continuation<Unit> create(@d Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        throw new IllegalStateException("create(Continuation) has not been overridden");
    }

    @e
    protected abstract Object doResume(@e Object r1, @e Throwable exception);

    @Override // kotlin.coroutines.experimental.Continuation
    @d
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        if (coroutineContext == null) {
            Intrinsics.throwNpe();
        }
        return coroutineContext;
    }

    @d
    public final Continuation<Object> getFacade() {
        if (this._facade == null) {
            CoroutineContext coroutineContext = this._context;
            if (coroutineContext == null) {
                Intrinsics.throwNpe();
            }
            this._facade = CoroutineIntrinsics.interceptContinuationIfNeeded(coroutineContext, this);
        }
        Continuation<Object> continuation = this._facade;
        if (continuation == null) {
            Intrinsics.throwNpe();
        }
        return continuation;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resume(@e Object r3) {
        Object coroutine_suspended;
        Continuation<Object> continuation = this.completion;
        if (continuation == null) {
            Intrinsics.throwNpe();
        }
        try {
            Object doResume = doResume(r3, null);
            coroutine_suspended = IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
            if (doResume != coroutine_suspended) {
                if (continuation == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                continuation.resume(doResume);
            }
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resumeWithException(@d Throwable exception) {
        Object coroutine_suspended;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Continuation<Object> continuation = this.completion;
        if (continuation == null) {
            Intrinsics.throwNpe();
        }
        try {
            Object doResume = doResume(null, exception);
            coroutine_suspended = IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
            if (doResume != coroutine_suspended) {
                if (continuation == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                continuation.resume(doResume);
            }
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    @d
    public Continuation<Unit> create(@e Object r1, @d Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        throw new IllegalStateException("create(Any?;Continuation) has not been overridden");
    }
}

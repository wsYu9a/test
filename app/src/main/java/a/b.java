package a;

import hf.e;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;

@SourceDebugExtension({"SMAP\nCoroutineDebugging.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineDebugging.kt\n_COROUTINE/CoroutineDebuggingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @k
    public static final String f44a = "_COROUTINE";

    public static final StackTraceElement b(Throwable th2, String str) {
        StackTraceElement stackTraceElement = th2.getStackTrace()[0];
        return new StackTraceElement(f44a + '.' + str, e.f26694a, stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }

    @k
    public static final String c() {
        return f44a;
    }
}

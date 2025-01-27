package kotlin.internal;

import f.b.a.d;
import f.b.a.e;
import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "", "cause", "exception", "", "addSuppressed", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "Lkotlin/text/MatchGroup;", "getMatchResultNamedGroup", "(Ljava/util/regex/MatchResult;Ljava/lang/String;)Lkotlin/text/MatchGroup;", "Lkotlin/random/Random;", "defaultPlatformRandom", "()Lkotlin/random/Random;", "<init>", "()V", "ReflectAddSuppressedMethod", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public class PlatformImplementations {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectAddSuppressedMethod;", "", "Ljava/lang/reflect/Method;", "method", "Ljava/lang/reflect/Method;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    private static final class ReflectAddSuppressedMethod {
        public static final ReflectAddSuppressedMethod INSTANCE = new ReflectAddSuppressedMethod();

        @e
        @JvmField
        public static final Method method;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0049 A[EDGE_INSN: B:10:0x0049->B:11:0x0049 BREAK  A[LOOP:0: B:2:0x0015->B:9:0x0045], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0045 A[LOOP:0: B:2:0x0015->B:9:0x0045, LOOP_END] */
        static {
            /*
                kotlin.internal.PlatformImplementations$ReflectAddSuppressedMethod r0 = new kotlin.internal.PlatformImplementations$ReflectAddSuppressedMethod
                r0.<init>()
                kotlin.internal.PlatformImplementations.ReflectAddSuppressedMethod.INSTANCE = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableClass.methods"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                if (r4 >= r2) goto L48
                r5 = r1[r4]
                java.lang.String r6 = "it"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
                if (r6 == 0) goto L41
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
                java.lang.Object r6 = kotlin.collections.ArraysKt.singleOrNull(r6)
                java.lang.Class r6 = (java.lang.Class) r6
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
                if (r6 == 0) goto L41
                r6 = 1
                goto L42
            L41:
                r6 = 0
            L42:
                if (r6 == 0) goto L45
                goto L49
            L45:
                int r4 = r4 + 1
                goto L15
            L48:
                r5 = 0
            L49:
                kotlin.internal.PlatformImplementations.ReflectAddSuppressedMethod.method = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.ReflectAddSuppressedMethod.<clinit>():void");
        }

        private ReflectAddSuppressedMethod() {
        }
    }

    public void addSuppressed(@d Throwable cause, @d Throwable exception) {
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Method method = ReflectAddSuppressedMethod.method;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @d
    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    @e
    public MatchGroup getMatchResultNamedGroup(@d MatchResult matchResult, @d String name) {
        Intrinsics.checkParameterIsNotNull(matchResult, "matchResult");
        Intrinsics.checkParameterIsNotNull(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}

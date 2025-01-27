package kotlin.system;

import f.b.a.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u001e\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"Lkotlin/Function0;", "", "block", "", "measureTimeMillis", "(Lkotlin/jvm/functions/Function0;)J", "measureNanoTime", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "TimingKt")
/* loaded from: classes5.dex */
public final class TimingKt {
    public static final long measureNanoTime(@d Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        long nanoTime = System.nanoTime();
        block.invoke();
        return System.nanoTime() - nanoTime;
    }

    public static final long measureTimeMillis(@d Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        long currentTimeMillis = System.currentTimeMillis();
        block.invoke();
        return System.currentTimeMillis() - currentTimeMillis;
    }
}

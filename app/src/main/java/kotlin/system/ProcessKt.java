package kotlin.system;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b¨\u0006\u0004"}, d2 = {"exitProcess", "", "status", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "ProcessKt")
/* loaded from: classes4.dex */
public final class ProcessKt {
    @InlineOnly
    private static final Void exitProcess(int i10) {
        System.exit(i10);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}

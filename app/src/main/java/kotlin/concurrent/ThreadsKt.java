package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import b7.d;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", d.D, "", e.f19025e, "Lkotlin/Function0;", "", "getOrSet", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/ThreadLocal;", DownloadSettingKeys.BugFix.DEFAULT, "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "ThreadsKt")
@SourceDebugExtension({"SMAP\nThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Thread.kt\nkotlin/concurrent/ThreadsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
/* loaded from: classes4.dex */
public final class ThreadsKt {
    @InlineOnly
    private static final <T> T getOrSet(ThreadLocal<T> threadLocal, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(threadLocal, "<this>");
        Intrinsics.checkNotNullParameter(function0, "default");
        T t10 = threadLocal.get();
        if (t10 != null) {
            return t10;
        }
        T invoke = function0.invoke();
        threadLocal.set(invoke);
        return invoke;
    }

    @k
    public static final Thread thread(boolean z10, boolean z11, @l ClassLoader classLoader, @l String str, int i10, @k Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadsKt$thread$thread$1 threadsKt$thread$thread$1 = new Thread() { // from class: kotlin.concurrent.ThreadsKt$thread$thread$1
            final /* synthetic */ Function0<Unit> $block;

            public ThreadsKt$thread$thread$1(Function0<Unit> block2) {
                block = block2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                block.invoke();
            }
        };
        if (z11) {
            threadsKt$thread$thread$1.setDaemon(true);
        }
        if (i10 > 0) {
            threadsKt$thread$thread$1.setPriority(i10);
        }
        if (str != null) {
            threadsKt$thread$thread$1.setName(str);
        }
        if (classLoader != null) {
            threadsKt$thread$thread$1.setContextClassLoader(classLoader);
        }
        if (z10) {
            threadsKt$thread$thread$1.start();
        }
        return threadsKt$thread$thread$1;
    }
}

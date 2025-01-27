package kotlinx.coroutines.internal;

import com.martian.libmars.activity.PermissionActivity;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0002`\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000bH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/ClassValueCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "()V", "cache", "kotlinx/coroutines/internal/ClassValueCtorCache$cache$1", "Lkotlinx/coroutines/internal/ClassValueCtorCache$cache$1;", MonitorConstants.CONNECT_TYPE_GET, "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", PermissionActivity.f12046p, "Ljava/lang/Class;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@IgnoreJRERequirement
/* loaded from: classes4.dex */
final class ClassValueCtorCache extends CtorCache {

    @k
    public static final ClassValueCtorCache INSTANCE = new ClassValueCtorCache();

    @k
    private static final ClassValueCtorCache$cache$1 cache = new ClassValue<Function1<? super Throwable, ? extends Throwable>>() { // from class: kotlinx.coroutines.internal.ClassValueCtorCache$cache$1
        @Override // java.lang.ClassValue
        public /* bridge */ /* synthetic */ Function1<? super Throwable, ? extends Throwable> computeValue(Class cls) {
            return computeValue2((Class<?>) cls);
        }

        @Override // java.lang.ClassValue
        @k
        /* renamed from: computeValue */
        public Function1<? super Throwable, ? extends Throwable> computeValue2(@l Class<?> type) {
            Function1<? super Throwable, ? extends Throwable> createConstructor;
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
            createConstructor = ExceptionsConstructorKt.createConstructor(type);
            return createConstructor;
        }
    };

    private ClassValueCtorCache() {
    }

    @Override // kotlinx.coroutines.internal.CtorCache
    @k
    public Function1<Throwable, Throwable> get(@k Class<? extends Throwable> cls) {
        return (Function1) cache.get(cls);
    }
}

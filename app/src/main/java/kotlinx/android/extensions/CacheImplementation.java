package kotlinx.android.extensions;

import com.martian.ads.ad.AdConfig;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public enum CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    @d
    private static final CacheImplementation DEFAULT;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"kotlinx/android/extensions/CacheImplementation$a", "", "Lkotlinx/android/extensions/CacheImplementation;", AdConfig.UnionType.DEFAULT, "Lkotlinx/android/extensions/CacheImplementation;", "a", "()Lkotlinx/android/extensions/CacheImplementation;", "<init>", "()V", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.android.extensions.CacheImplementation$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        @d
        public final CacheImplementation a() {
            return CacheImplementation.DEFAULT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        CacheImplementation cacheImplementation = HASH_MAP;
        INSTANCE = new Companion(null);
        DEFAULT = cacheImplementation;
    }
}

package kotlinx.android.extensions;

import com.martian.ads.ad.AdConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import xi.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "(Ljava/lang/String;I)V", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "Companion", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CacheImplementation extends Enum<CacheImplementation> {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CacheImplementation[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE;

    @k
    private static final CacheImplementation DEFAULT;
    public static final CacheImplementation HASH_MAP;
    public static final CacheImplementation NO_CACHE;
    public static final CacheImplementation SPARSE_ARRAY = new CacheImplementation("SPARSE_ARRAY", 0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation$Companion;", "", "()V", AdConfig.UnionType.DEFAULT, "Lkotlinx/android/extensions/CacheImplementation;", "getDEFAULT", "()Lkotlinx/android/extensions/CacheImplementation;", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final CacheImplementation getDEFAULT() {
            return CacheImplementation.DEFAULT;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ CacheImplementation[] $values() {
        return new CacheImplementation[]{SPARSE_ARRAY, HASH_MAP, NO_CACHE};
    }

    static {
        CacheImplementation cacheImplementation = new CacheImplementation("HASH_MAP", 1);
        HASH_MAP = cacheImplementation;
        NO_CACHE = new CacheImplementation("NO_CACHE", 2);
        CacheImplementation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        DEFAULT = cacheImplementation;
    }

    private CacheImplementation(String str, int i10) {
        super(str, i10);
    }

    @k
    public static EnumEntries<CacheImplementation> getEntries() {
        return $ENTRIES;
    }

    public static CacheImplementation valueOf(String str) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, str);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) $VALUES.clone();
    }
}

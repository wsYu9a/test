package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class FragmentManagerNonConfig {

    /* renamed from: a */
    @Nullable
    private final Collection<Fragment> f2391a;

    /* renamed from: b */
    @Nullable
    private final Map<String, FragmentManagerNonConfig> f2392b;

    /* renamed from: c */
    @Nullable
    private final Map<String, ViewModelStore> f2393c;

    FragmentManagerNonConfig(@Nullable Collection<Fragment> collection, @Nullable Map<String, FragmentManagerNonConfig> map, @Nullable Map<String, ViewModelStore> map2) {
        this.f2391a = collection;
        this.f2392b = map;
        this.f2393c = map2;
    }

    @Nullable
    Map<String, FragmentManagerNonConfig> a() {
        return this.f2392b;
    }

    @Nullable
    Collection<Fragment> b() {
        return this.f2391a;
    }

    @Nullable
    Map<String, ViewModelStore> c() {
        return this.f2393c;
    }

    boolean d(Fragment fragment) {
        Collection<Fragment> collection = this.f2391a;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}

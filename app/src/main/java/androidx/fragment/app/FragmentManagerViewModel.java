package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
class FragmentManagerViewModel extends ViewModel {

    /* renamed from: c */
    private static final ViewModelProvider.Factory f2399c = new ViewModelProvider.Factory() { // from class: androidx.fragment.app.FragmentManagerViewModel.1
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    };

    /* renamed from: g */
    private final boolean f2403g;

    /* renamed from: d */
    private final HashSet<Fragment> f2400d = new HashSet<>();

    /* renamed from: e */
    private final HashMap<String, FragmentManagerViewModel> f2401e = new HashMap<>();

    /* renamed from: f */
    private final HashMap<String, ViewModelStore> f2402f = new HashMap<>();

    /* renamed from: h */
    private boolean f2404h = false;

    /* renamed from: i */
    private boolean f2405i = false;

    /* renamed from: androidx.fragment.app.FragmentManagerViewModel$1 */
    static class AnonymousClass1 implements ViewModelProvider.Factory {
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    }

    FragmentManagerViewModel(boolean z) {
        this.f2403g = z;
    }

    @NonNull
    static FragmentManagerViewModel i(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, f2399c).get(FragmentManagerViewModel.class);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void d() {
        if (FragmentManagerImpl.f2354c) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2404h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        return this.f2400d.equals(fragmentManagerViewModel.f2400d) && this.f2401e.equals(fragmentManagerViewModel.f2401e) && this.f2402f.equals(fragmentManagerViewModel.f2402f);
    }

    boolean f(@NonNull Fragment fragment) {
        return this.f2400d.add(fragment);
    }

    void g(@NonNull Fragment fragment) {
        if (FragmentManagerImpl.f2354c) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.f2401e.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.d();
            this.f2401e.remove(fragment.mWho);
        }
        ViewModelStore viewModelStore = this.f2402f.get(fragment.mWho);
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.f2402f.remove(fragment.mWho);
        }
    }

    @NonNull
    FragmentManagerViewModel h(@NonNull Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.f2401e.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            return fragmentManagerViewModel;
        }
        FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.f2403g);
        this.f2401e.put(fragment.mWho, fragmentManagerViewModel2);
        return fragmentManagerViewModel2;
    }

    public int hashCode() {
        return (((this.f2400d.hashCode() * 31) + this.f2401e.hashCode()) * 31) + this.f2402f.hashCode();
    }

    @NonNull
    Collection<Fragment> j() {
        return this.f2400d;
    }

    @Nullable
    @Deprecated
    FragmentManagerNonConfig k() {
        if (this.f2400d.isEmpty() && this.f2401e.isEmpty() && this.f2402f.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, FragmentManagerViewModel> entry : this.f2401e.entrySet()) {
            FragmentManagerNonConfig k = entry.getValue().k();
            if (k != null) {
                hashMap.put(entry.getKey(), k);
            }
        }
        this.f2405i = true;
        if (this.f2400d.isEmpty() && hashMap.isEmpty() && this.f2402f.isEmpty()) {
            return null;
        }
        return new FragmentManagerNonConfig(new ArrayList(this.f2400d), hashMap, new HashMap(this.f2402f));
    }

    @NonNull
    ViewModelStore l(@NonNull Fragment fragment) {
        ViewModelStore viewModelStore = this.f2402f.get(fragment.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f2402f.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    boolean m() {
        return this.f2404h;
    }

    boolean n(@NonNull Fragment fragment) {
        return this.f2400d.remove(fragment);
    }

    @Deprecated
    void o(@Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f2400d.clear();
        this.f2401e.clear();
        this.f2402f.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> b2 = fragmentManagerNonConfig.b();
            if (b2 != null) {
                this.f2400d.addAll(b2);
            }
            Map<String, FragmentManagerNonConfig> a2 = fragmentManagerNonConfig.a();
            if (a2 != null) {
                for (Map.Entry<String, FragmentManagerNonConfig> entry : a2.entrySet()) {
                    FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.f2403g);
                    fragmentManagerViewModel.o(entry.getValue());
                    this.f2401e.put(entry.getKey(), fragmentManagerViewModel);
                }
            }
            Map<String, ViewModelStore> c2 = fragmentManagerNonConfig.c();
            if (c2 != null) {
                this.f2402f.putAll(c2);
            }
        }
        this.f2405i = false;
    }

    boolean p(@NonNull Fragment fragment) {
        if (this.f2400d.contains(fragment)) {
            return this.f2403g ? this.f2404h : !this.f2405i;
        }
        return true;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f2400d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f2401e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2402f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}

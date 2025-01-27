package androidx.navigation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes.dex */
class NavControllerViewModel extends ViewModel {

    /* renamed from: c */
    private static final ViewModelProvider.Factory f2971c = new ViewModelProvider.Factory() { // from class: androidx.navigation.NavControllerViewModel.1
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new NavControllerViewModel();
        }
    };

    /* renamed from: d */
    private final HashMap<UUID, ViewModelStore> f2972d = new HashMap<>();

    /* renamed from: androidx.navigation.NavControllerViewModel$1 */
    class AnonymousClass1 implements ViewModelProvider.Factory {
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new NavControllerViewModel();
        }
    }

    NavControllerViewModel() {
    }

    @NonNull
    static NavControllerViewModel g(ViewModelStore viewModelStore) {
        return (NavControllerViewModel) new ViewModelProvider(viewModelStore, f2971c).get(NavControllerViewModel.class);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void d() {
        Iterator<ViewModelStore> it = this.f2972d.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f2972d.clear();
    }

    void f(@NonNull UUID uuid) {
        ViewModelStore remove = this.f2972d.remove(uuid);
        if (remove != null) {
            remove.clear();
        }
    }

    @NonNull
    ViewModelStore h(@NonNull UUID uuid) {
        ViewModelStore viewModelStore = this.f2972d.get(uuid);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f2972d.put(uuid, viewModelStore2);
        return viewModelStore2;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.f2972d.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}

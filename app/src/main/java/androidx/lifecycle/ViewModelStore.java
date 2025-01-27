package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class ViewModelStore {

    /* renamed from: a */
    private final HashMap<String, ViewModel> f2661a = new HashMap<>();

    final ViewModel a(String str) {
        return this.f2661a.get(str);
    }

    Set<String> b() {
        return new HashSet(this.f2661a.keySet());
    }

    final void c(String str, ViewModel viewModel) {
        ViewModel put = this.f2661a.put(str, viewModel);
        if (put != null) {
            put.d();
        }
    }

    public final void clear() {
        Iterator<ViewModel> it = this.f2661a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f2661a.clear();
    }
}

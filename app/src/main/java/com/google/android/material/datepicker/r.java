package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
abstract class r<S> extends Fragment {

    /* renamed from: a */
    protected final LinkedHashSet<q<S>> f7091a = new LinkedHashSet<>();

    r() {
    }

    boolean a(q<S> qVar) {
        return this.f7091a.add(qVar);
    }

    void b() {
        this.f7091a.clear();
    }

    abstract f<S> c();

    boolean d(q<S> qVar) {
        return this.f7091a.remove(qVar);
    }
}

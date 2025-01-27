package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class m<S> extends r<S> {

    /* renamed from: b */
    private static final String f7066b = "DATE_SELECTOR_KEY";

    /* renamed from: c */
    private static final String f7067c = "CALENDAR_CONSTRAINTS_KEY";

    /* renamed from: d */
    @Nullable
    private f<S> f7068d;

    /* renamed from: e */
    @Nullable
    private com.google.android.material.datepicker.a f7069e;

    class a extends q<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.q
        void a() {
            Iterator<q<S>> it = m.this.f7091a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.q
        public void b(S s) {
            Iterator<q<S>> it = m.this.f7091a.iterator();
            while (it.hasNext()) {
                it.next().b(s);
            }
        }
    }

    @NonNull
    static <T> m<T> e(@NonNull f<T> fVar, @NonNull com.google.android.material.datepicker.a aVar) {
        m<T> mVar = new m<>();
        Bundle bundle = new Bundle();
        bundle.putParcelable(f7066b, fVar);
        bundle.putParcelable(f7067c, aVar);
        mVar.setArguments(bundle);
        return mVar;
    }

    @Override // com.google.android.material.datepicker.r
    @NonNull
    public f<S> c() {
        f<S> fVar = this.f7068d;
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f7068d = (f) bundle.getParcelable(f7066b);
        this.f7069e = (com.google.android.material.datepicker.a) bundle.getParcelable(f7067c);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.f7068d.f0(layoutInflater, viewGroup, bundle, this.f7069e, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(f7066b, this.f7068d);
        bundle.putParcelable(f7067c, this.f7069e);
    }
}

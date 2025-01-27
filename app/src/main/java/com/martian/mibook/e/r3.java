package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class r3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final View f12607a;

    /* renamed from: b */
    @NonNull
    public final o3 f12608b;

    /* renamed from: c */
    @NonNull
    public final p3 f12609c;

    /* renamed from: d */
    @NonNull
    public final q3 f12610d;

    private r3(@NonNull View rootView, @NonNull o3 errorView, @NonNull p3 loadingView, @NonNull q3 theEndView) {
        this.f12607a = rootView;
        this.f12608b = errorView;
        this.f12609c = loadingView;
        this.f12610d = theEndView;
    }

    @NonNull
    public static r3 a(@NonNull View rootView) {
        int i2 = R.id.errorView;
        View findViewById = rootView.findViewById(R.id.errorView);
        if (findViewById != null) {
            o3 a2 = o3.a(findViewById);
            View findViewById2 = rootView.findViewById(R.id.loadingView);
            if (findViewById2 != null) {
                p3 a3 = p3.a(findViewById2);
                View findViewById3 = rootView.findViewById(R.id.theEndView);
                if (findViewById3 != null) {
                    return new r3(rootView, a2, a3, q3.a(findViewById3));
                }
                i2 = R.id.theEndView;
            } else {
                i2 = R.id.loadingView;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static r3 b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.layout_reader_irecyclerview_load_more_footer_view, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f12607a;
    }
}

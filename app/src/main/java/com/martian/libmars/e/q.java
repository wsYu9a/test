package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class q implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final View f10033a;

    /* renamed from: b */
    @NonNull
    public final n f10034b;

    /* renamed from: c */
    @NonNull
    public final o f10035c;

    /* renamed from: d */
    @NonNull
    public final p f10036d;

    private q(@NonNull View rootView, @NonNull n errorView, @NonNull o loadingView, @NonNull p theEndView) {
        this.f10033a = rootView;
        this.f10034b = errorView;
        this.f10035c = loadingView;
        this.f10036d = theEndView;
    }

    @NonNull
    public static q a(@NonNull View rootView) {
        int i2 = R.id.errorView;
        View findViewById = rootView.findViewById(i2);
        if (findViewById != null) {
            n a2 = n.a(findViewById);
            int i3 = R.id.loadingView;
            View findViewById2 = rootView.findViewById(i3);
            if (findViewById2 != null) {
                o a3 = o.a(findViewById2);
                int i4 = R.id.theEndView;
                View findViewById3 = rootView.findViewById(i4);
                if (findViewById3 != null) {
                    return new q(rootView, a2, a3, p.a(findViewById3));
                }
                i2 = i4;
            } else {
                i2 = i3;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static q b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.layout_irecyclerview_load_more_footer_view, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f10033a;
    }
}

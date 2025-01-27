package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11801a;

    /* renamed from: b */
    @NonNull
    public final RoundedLayout f11802b;

    private c5(@NonNull RelativeLayout rootView, @NonNull RoundedLayout readingAddRack) {
        this.f11801a = rootView;
        this.f11802b = readingAddRack;
    }

    @NonNull
    public static c5 a(@NonNull View rootView) {
        RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.reading_add_rack);
        if (roundedLayout != null) {
            return new c5((RelativeLayout) rootView, roundedLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.reading_add_rack)));
    }

    @NonNull
    public static c5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_add_rack_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11801a;
    }
}

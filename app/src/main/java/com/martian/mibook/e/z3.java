package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class z3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f13016a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f13017b;

    private z3(@NonNull LinearLayout rootView, @NonNull FrameLayout fragmentContainer) {
        this.f13016a = rootView;
        this.f13017b = fragmentContainer;
    }

    @NonNull
    public static z3 a(@NonNull View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.fragmentContainer);
        if (frameLayout != null) {
            return new z3((LinearLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.fragmentContainer)));
    }

    @NonNull
    public static z3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static z3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_activity_withdraw_order_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13016a;
    }
}

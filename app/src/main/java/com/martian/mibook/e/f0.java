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
public final class f0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11930a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f11931b;

    private f0(@NonNull LinearLayout rootView, @NonNull FrameLayout fragmentContainer) {
        this.f11930a = rootView;
        this.f11931b = fragmentContainer;
    }

    @NonNull
    public static f0 a(@NonNull View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.fragmentContainer);
        if (frameLayout != null) {
            return new f0((LinearLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.fragmentContainer)));
    }

    @NonNull
    public static f0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_yw_new_books, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11930a;
    }
}

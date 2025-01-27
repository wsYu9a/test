package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;

/* loaded from: classes3.dex */
public final class FragmentStrBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f12194a;

    /* renamed from: b */
    @NonNull
    public final ThemeIRecyclerView f12195b;

    /* renamed from: c */
    @NonNull
    public final FrameLayout f12196c;

    public FragmentStrBinding(@NonNull FrameLayout frameLayout, @NonNull ThemeIRecyclerView themeIRecyclerView, @NonNull FrameLayout frameLayout2) {
        this.f12194a = frameLayout;
        this.f12195b = themeIRecyclerView;
        this.f12196c = frameLayout2;
    }

    @NonNull
    public static FragmentStrBinding a(@NonNull View view) {
        int i10 = R.id.str_irc;
        ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) ViewBindings.findChildViewById(view, i10);
        if (themeIRecyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new FragmentStrBinding(frameLayout, themeIRecyclerView, frameLayout);
    }

    @NonNull
    public static FragmentStrBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentStrBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_str, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f12194a;
    }
}

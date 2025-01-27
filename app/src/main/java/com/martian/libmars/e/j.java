package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;

/* loaded from: classes2.dex */
public final class j implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final FrameLayout f10008a;

    /* renamed from: b */
    @NonNull
    public final ThemeIRecyclerView f10009b;

    /* renamed from: c */
    @NonNull
    public final FrameLayout f10010c;

    private j(@NonNull FrameLayout rootView, @NonNull ThemeIRecyclerView strIrc, @NonNull FrameLayout svContainer) {
        this.f10008a = rootView;
        this.f10009b = strIrc;
        this.f10010c = svContainer;
    }

    @NonNull
    public static j a(@NonNull View rootView) {
        int i2 = R.id.str_irc;
        ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(i2);
        if (themeIRecyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
        }
        FrameLayout frameLayout = (FrameLayout) rootView;
        return new j(frameLayout, themeIRecyclerView, frameLayout);
    }

    @NonNull
    public static j c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_str, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f10008a;
    }
}

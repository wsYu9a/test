package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class g3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final NestedScrollView f12000a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12001b;

    /* renamed from: c */
    @NonNull
    public final ThemeIRecyclerView f12002c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12003d;

    /* renamed from: e */
    @NonNull
    public final NestedScrollView f12004e;

    private g3(@NonNull NestedScrollView rootView, @NonNull LinearLayout bsChannels, @NonNull ThemeIRecyclerView originalIrc, @NonNull LinearLayout originalTitle, @NonNull NestedScrollView svContainer) {
        this.f12000a = rootView;
        this.f12001b = bsChannels;
        this.f12002c = originalIrc;
        this.f12003d = originalTitle;
        this.f12004e = svContainer;
    }

    @NonNull
    public static g3 a(@NonNull View rootView) {
        int i2 = R.id.bs_channels;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bs_channels);
        if (linearLayout != null) {
            i2 = R.id.original_irc;
            ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.original_irc);
            if (themeIRecyclerView != null) {
                i2 = R.id.original_title;
                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.original_title);
                if (linearLayout2 != null) {
                    NestedScrollView nestedScrollView = (NestedScrollView) rootView;
                    return new g3(nestedScrollView, linearLayout, themeIRecyclerView, linearLayout2, nestedScrollView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static g3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_discount_bookstores, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public NestedScrollView getRoot() {
        return this.f12000a;
    }
}

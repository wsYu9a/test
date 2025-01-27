package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class e3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f11897a;

    /* renamed from: b */
    @NonNull
    public final ThemeIRecyclerView f11898b;

    /* renamed from: c */
    @NonNull
    public final ThemeRelativeLayout f11899c;

    private e3(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeIRecyclerView commentsIrc, @NonNull ThemeRelativeLayout svContainer) {
        this.f11897a = rootView;
        this.f11898b = commentsIrc;
        this.f11899c = svContainer;
    }

    @NonNull
    public static e3 a(@NonNull View rootView) {
        ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.comments_irc);
        if (themeIRecyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.comments_irc)));
        }
        ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) rootView;
        return new e3(themeRelativeLayout, themeIRecyclerView, themeRelativeLayout);
    }

    @NonNull
    public static e3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_comments, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f11897a;
    }
}

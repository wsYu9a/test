package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class b1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11729a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11730b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f11731c;

    private b1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout bookAdderGridContainer, @NonNull RelativeLayout ivBookMoreView) {
        this.f11729a = rootView;
        this.f11730b = bookAdderGridContainer;
        this.f11731c = ivBookMoreView;
    }

    @NonNull
    public static b1 a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.iv_book_more_view);
        if (relativeLayout != null) {
            return new b1((ThemeLinearLayout) rootView, themeLinearLayout, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.iv_book_more_view)));
    }

    @NonNull
    public static b1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_store_grid_book_more_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11729a;
    }
}

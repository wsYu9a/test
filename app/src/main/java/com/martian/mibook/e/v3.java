package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeListView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class v3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12824a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12825b;

    /* renamed from: c */
    @NonNull
    public final ThemeListView f12826c;

    private v3(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeTextView emptyText, @NonNull ThemeListView list) {
        this.f12824a = rootView;
        this.f12825b = emptyText;
        this.f12826c = list;
    }

    @NonNull
    public static v3 a(@NonNull View rootView) {
        int i2 = R.id.empty_text;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.empty_text);
        if (themeTextView != null) {
            i2 = android.R.id.list;
            ThemeListView themeListView = (ThemeListView) rootView.findViewById(android.R.id.list);
            if (themeListView != null) {
                return new v3((ThemeRelativeLayout) rootView, themeTextView, themeListView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static v3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.list_with_empty_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12824a;
    }
}

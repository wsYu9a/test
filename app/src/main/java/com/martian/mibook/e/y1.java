package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class y1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12962a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12963b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12964c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12965d;

    /* renamed from: e */
    @NonNull
    public final a2 f12966e;

    private y1(@NonNull ThemeLinearLayout rootView, @NonNull LinearLayout bookmallItemRoot, @NonNull LinearLayout bookmallListView, @NonNull ThemeLinearLayout listItemRoot, @NonNull a2 titleView) {
        this.f12962a = rootView;
        this.f12963b = bookmallItemRoot;
        this.f12964c = bookmallListView;
        this.f12965d = listItemRoot;
        this.f12966e = titleView;
    }

    @NonNull
    public static y1 a(@NonNull View rootView) {
        int i2 = R.id.bookmall_item_root;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bookmall_item_root);
        if (linearLayout != null) {
            i2 = R.id.bookmall_list_view;
            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.bookmall_list_view);
            if (linearLayout2 != null) {
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
                i2 = R.id.title_view;
                View findViewById = rootView.findViewById(R.id.title_view);
                if (findViewById != null) {
                    return new y1(themeLinearLayout, linearLayout, linearLayout2, themeLinearLayout, a2.a(findViewById));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static y1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_item_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12962a;
    }
}

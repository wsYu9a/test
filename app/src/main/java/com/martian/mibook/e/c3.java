package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11788a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f11789b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f11790c;

    /* renamed from: d */
    @NonNull
    public final ThemeIRecyclerView f11791d;

    private c3(@NonNull RelativeLayout rootView, @NonNull ThemeTextView bookOrder, @NonNull ThemeLinearLayout bookOrderView, @NonNull ThemeIRecyclerView categoryIrc) {
        this.f11788a = rootView;
        this.f11789b = bookOrder;
        this.f11790c = bookOrderView;
        this.f11791d = categoryIrc;
    }

    @NonNull
    public static c3 a(@NonNull View rootView) {
        int i2 = R.id.book_order;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.book_order);
        if (themeTextView != null) {
            i2 = R.id.book_order_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.book_order_view);
            if (themeLinearLayout != null) {
                i2 = R.id.category_irc;
                ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.category_irc);
                if (themeIRecyclerView != null) {
                    return new c3((RelativeLayout) rootView, themeTextView, themeLinearLayout, themeIRecyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static c3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_category_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11788a;
    }
}

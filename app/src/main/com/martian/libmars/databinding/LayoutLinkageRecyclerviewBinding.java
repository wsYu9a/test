package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;

/* loaded from: classes3.dex */
public final class LayoutLinkageRecyclerviewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeLinearLayout f12219a;

    /* renamed from: b */
    @NonNull
    public final RecyclerView f12220b;

    /* renamed from: c */
    @NonNull
    public final RecyclerView f12221c;

    public LayoutLinkageRecyclerviewBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.f12219a = themeLinearLayout;
        this.f12220b = recyclerView;
        this.f12221c = recyclerView2;
    }

    @NonNull
    public static LayoutLinkageRecyclerviewBinding a(@NonNull View view) {
        int i10 = R.id.rv_child;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
        if (recyclerView != null) {
            i10 = R.id.rv_group;
            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
            if (recyclerView2 != null) {
                return new LayoutLinkageRecyclerviewBinding((ThemeLinearLayout) view, recyclerView, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutLinkageRecyclerviewBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutLinkageRecyclerviewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_linkage_recyclerview, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12219a;
    }
}

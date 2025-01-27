package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class MartianActivityYwBookRankListBinding implements ViewBinding {

    @NonNull
    public final ViewPager lbContent;

    @NonNull
    public final ThemeLinearLayout llMain;

    @NonNull
    private final ThemeLinearLayout rootView;

    private MartianActivityYwBookRankListBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ViewPager viewPager, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.rootView = themeLinearLayout;
        this.lbContent = viewPager;
        this.llMain = themeLinearLayout2;
    }

    @NonNull
    public static MartianActivityYwBookRankListBinding bind(@NonNull View view) {
        int i10 = R.id.lb_content;
        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i10);
        if (viewPager == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        return new MartianActivityYwBookRankListBinding(themeLinearLayout, viewPager, themeLinearLayout);
    }

    @NonNull
    public static MartianActivityYwBookRankListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MartianActivityYwBookRankListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_activity_yw_book_rank_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}

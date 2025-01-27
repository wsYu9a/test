package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.payment.ui.ThemeVipRelativeLayout;

/* loaded from: classes3.dex */
public final class VipPopupwindowRightsBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeVipRelativeLayout vipRightsButton;

    @NonNull
    public final RecyclerView vipRightsRecyclerView;

    @NonNull
    public final ThemeTextView vipRightsTitle;

    private VipPopupwindowRightsBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeVipRelativeLayout themeVipRelativeLayout, @NonNull RecyclerView recyclerView, @NonNull ThemeTextView themeTextView) {
        this.rootView = relativeLayout;
        this.vipRightsButton = themeVipRelativeLayout;
        this.vipRightsRecyclerView = recyclerView;
        this.vipRightsTitle = themeTextView;
    }

    @NonNull
    public static VipPopupwindowRightsBinding bind(@NonNull View view) {
        int i10 = R.id.vipRightsButton;
        ThemeVipRelativeLayout themeVipRelativeLayout = (ThemeVipRelativeLayout) ViewBindings.findChildViewById(view, i10);
        if (themeVipRelativeLayout != null) {
            i10 = R.id.vipRightsRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
            if (recyclerView != null) {
                i10 = R.id.vipRightsTitle;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    return new VipPopupwindowRightsBinding((RelativeLayout) view, themeVipRelativeLayout, recyclerView, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static VipPopupwindowRightsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VipPopupwindowRightsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.vip_popupwindow_rights, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}

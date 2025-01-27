package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.DropDownMenuLayout;
import com.martian.mibook.ui.FlexboxTagLayout;

/* loaded from: classes3.dex */
public final class LayoutSearchFilterViewBinding implements ViewBinding {

    @NonNull
    public final FlexboxTagLayout flexboxChannel;

    @NonNull
    public final FlexboxTagLayout flexboxStatus;

    @NonNull
    public final FlexboxTagLayout flexboxWordNumber;

    @NonNull
    private final DropDownMenuLayout rootView;

    @NonNull
    public final ThemeTextView tvConfirm;

    @NonNull
    public final ThemeTextView tvReset;

    private LayoutSearchFilterViewBinding(@NonNull DropDownMenuLayout dropDownMenuLayout, @NonNull FlexboxTagLayout flexboxTagLayout, @NonNull FlexboxTagLayout flexboxTagLayout2, @NonNull FlexboxTagLayout flexboxTagLayout3, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = dropDownMenuLayout;
        this.flexboxChannel = flexboxTagLayout;
        this.flexboxStatus = flexboxTagLayout2;
        this.flexboxWordNumber = flexboxTagLayout3;
        this.tvConfirm = themeTextView;
        this.tvReset = themeTextView2;
    }

    @NonNull
    public static LayoutSearchFilterViewBinding bind(@NonNull View view) {
        int i10 = R.id.flexbox_channel;
        FlexboxTagLayout flexboxTagLayout = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
        if (flexboxTagLayout != null) {
            i10 = R.id.flexbox_status;
            FlexboxTagLayout flexboxTagLayout2 = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
            if (flexboxTagLayout2 != null) {
                i10 = R.id.flexbox_word_number;
                FlexboxTagLayout flexboxTagLayout3 = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                if (flexboxTagLayout3 != null) {
                    i10 = R.id.tv_confirm;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.tv_reset;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            return new LayoutSearchFilterViewBinding((DropDownMenuLayout) view, flexboxTagLayout, flexboxTagLayout2, flexboxTagLayout3, themeTextView, themeTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutSearchFilterViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutSearchFilterViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_search_filter_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public DropDownMenuLayout getRoot() {
        return this.rootView;
    }
}

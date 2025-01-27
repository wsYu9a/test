package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class VipRightsItemBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView desc;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ThemeTextView title;

    private VipRightsItemBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = linearLayout;
        this.desc = themeTextView;
        this.title = themeTextView2;
    }

    @NonNull
    public static VipRightsItemBinding bind(@NonNull View view) {
        int i10 = R.id.desc;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.title;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                return new VipRightsItemBinding((LinearLayout) view, themeTextView, themeTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static VipRightsItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VipRightsItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.vip_rights_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}

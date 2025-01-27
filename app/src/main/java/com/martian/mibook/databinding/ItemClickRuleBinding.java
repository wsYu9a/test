package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemClickRuleBinding implements ViewBinding {

    @NonNull
    public final ImageView ivRule;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final RoundedLayout roundLayout;

    private ItemClickRuleBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull RoundedLayout roundedLayout) {
        this.rootView = linearLayout;
        this.ivRule = imageView;
        this.roundLayout = roundedLayout;
    }

    @NonNull
    public static ItemClickRuleBinding bind(@NonNull View view) {
        int i10 = R.id.iv_rule;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.round_layout;
            RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
            if (roundedLayout != null) {
                return new ItemClickRuleBinding((LinearLayout) view, imageView, roundedLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemClickRuleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemClickRuleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_click_rule, viewGroup, false);
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

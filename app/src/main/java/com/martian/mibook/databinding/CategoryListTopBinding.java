package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlowLayout;

/* loaded from: classes3.dex */
public final class CategoryListTopBinding implements ViewBinding {

    @NonNull
    public final ThemeView categoryDivider;

    @NonNull
    public final FlowLayout categoryFlowLayout;

    @NonNull
    public final FlowLayout categoryNumberWord;

    @NonNull
    public final FlowLayout categoryOrder;

    @NonNull
    public final FlowLayout categoryStatus;

    @NonNull
    public final LinearLayout categoryTopView;

    @NonNull
    private final LinearLayout rootView;

    private CategoryListTopBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeView themeView, @NonNull FlowLayout flowLayout, @NonNull FlowLayout flowLayout2, @NonNull FlowLayout flowLayout3, @NonNull FlowLayout flowLayout4, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.categoryDivider = themeView;
        this.categoryFlowLayout = flowLayout;
        this.categoryNumberWord = flowLayout2;
        this.categoryOrder = flowLayout3;
        this.categoryStatus = flowLayout4;
        this.categoryTopView = linearLayout2;
    }

    @NonNull
    public static CategoryListTopBinding bind(@NonNull View view) {
        int i10 = R.id.category_divider;
        ThemeView themeView = (ThemeView) ViewBindings.findChildViewById(view, i10);
        if (themeView != null) {
            i10 = R.id.category_flowLayout;
            FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, i10);
            if (flowLayout != null) {
                i10 = R.id.category_number_word;
                FlowLayout flowLayout2 = (FlowLayout) ViewBindings.findChildViewById(view, i10);
                if (flowLayout2 != null) {
                    i10 = R.id.category_order;
                    FlowLayout flowLayout3 = (FlowLayout) ViewBindings.findChildViewById(view, i10);
                    if (flowLayout3 != null) {
                        i10 = R.id.category_status;
                        FlowLayout flowLayout4 = (FlowLayout) ViewBindings.findChildViewById(view, i10);
                        if (flowLayout4 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            return new CategoryListTopBinding(linearLayout, themeView, flowLayout, flowLayout2, flowLayout3, flowLayout4, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static CategoryListTopBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CategoryListTopBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.category_list_top, viewGroup, false);
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

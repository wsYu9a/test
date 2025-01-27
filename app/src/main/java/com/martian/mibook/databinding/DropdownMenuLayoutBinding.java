package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DropdownMenuLayoutBinding implements ViewBinding {

    @NonNull
    public final LinearLayout contentLayout;

    @NonNull
    private final View rootView;

    @NonNull
    public final View transparentBackground;

    private DropdownMenuLayoutBinding(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull View view2) {
        this.rootView = view;
        this.contentLayout = linearLayout;
        this.transparentBackground = view2;
    }

    @NonNull
    public static DropdownMenuLayoutBinding bind(@NonNull View view) {
        View findChildViewById;
        int i10 = R.id.contentLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout == null || (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.transparentBackground))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        return new DropdownMenuLayoutBinding(view, linearLayout, findChildViewById);
    }

    @NonNull
    public static DropdownMenuLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.dropdown_menu_layout, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}

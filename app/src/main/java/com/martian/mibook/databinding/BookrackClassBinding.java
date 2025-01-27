package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.PopListView;

/* loaded from: classes3.dex */
public final class BookrackClassBinding implements ViewBinding {

    @NonNull
    public final PopListView brClassList;

    @NonNull
    private final LinearLayout rootView;

    private BookrackClassBinding(@NonNull LinearLayout linearLayout, @NonNull PopListView popListView) {
        this.rootView = linearLayout;
        this.brClassList = popListView;
    }

    @NonNull
    public static BookrackClassBinding bind(@NonNull View view) {
        int i10 = R.id.br_class_list;
        PopListView popListView = (PopListView) ViewBindings.findChildViewById(view, i10);
        if (popListView != null) {
            return new BookrackClassBinding((LinearLayout) view, popListView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookrackClassBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookrackClassBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bookrack_class, viewGroup, false);
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

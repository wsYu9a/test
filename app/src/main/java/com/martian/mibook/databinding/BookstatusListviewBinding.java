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
public final class BookstatusListviewBinding implements ViewBinding {

    @NonNull
    public final PopListView brClassList;

    @NonNull
    private final LinearLayout rootView;

    private BookstatusListviewBinding(@NonNull LinearLayout linearLayout, @NonNull PopListView popListView) {
        this.rootView = linearLayout;
        this.brClassList = popListView;
    }

    @NonNull
    public static BookstatusListviewBinding bind(@NonNull View view) {
        int i10 = R.id.br_class_list;
        PopListView popListView = (PopListView) ViewBindings.findChildViewById(view, i10);
        if (popListView != null) {
            return new BookstatusListviewBinding((LinearLayout) view, popListView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookstatusListviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookstatusListviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bookstatus_listview, viewGroup, false);
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

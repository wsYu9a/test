package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class LayoutIrecyclerviewLoadMoreFooterViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f12215a;

    /* renamed from: b */
    @NonNull
    public final LayoutIrecyclerviewLoadMoreFooterErrorViewBinding f12216b;

    /* renamed from: c */
    @NonNull
    public final LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding f12217c;

    /* renamed from: d */
    @NonNull
    public final LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding f12218d;

    public LayoutIrecyclerviewLoadMoreFooterViewBinding(@NonNull View view, @NonNull LayoutIrecyclerviewLoadMoreFooterErrorViewBinding layoutIrecyclerviewLoadMoreFooterErrorViewBinding, @NonNull LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding layoutIrecyclerviewLoadMoreFooterLoadingViewBinding, @NonNull LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding layoutIrecyclerviewLoadMoreFooterTheEndViewBinding) {
        this.f12215a = view;
        this.f12216b = layoutIrecyclerviewLoadMoreFooterErrorViewBinding;
        this.f12217c = layoutIrecyclerviewLoadMoreFooterLoadingViewBinding;
        this.f12218d = layoutIrecyclerviewLoadMoreFooterTheEndViewBinding;
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterViewBinding a(@NonNull View view) {
        int i10 = R.id.errorView;
        View findChildViewById = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById != null) {
            LayoutIrecyclerviewLoadMoreFooterErrorViewBinding a10 = LayoutIrecyclerviewLoadMoreFooterErrorViewBinding.a(findChildViewById);
            int i11 = R.id.loadingView;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i11);
            if (findChildViewById2 != null) {
                LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding a11 = LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding.a(findChildViewById2);
                int i12 = R.id.theEndView;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i12);
                if (findChildViewById3 != null) {
                    return new LayoutIrecyclerviewLoadMoreFooterViewBinding(view, a10, a11, LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding.a(findChildViewById3));
                }
                i10 = i12;
            } else {
                i10 = i11;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterViewBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.layout_irecyclerview_load_more_footer_view, viewGroup);
        return a(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f12215a;
    }
}

package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.PopListView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12285a;

    /* renamed from: b */
    @NonNull
    public final PopListView f12286b;

    private l1(@NonNull LinearLayout rootView, @NonNull PopListView brClassList) {
        this.f12285a = rootView;
        this.f12286b = brClassList;
    }

    @NonNull
    public static l1 a(@NonNull View rootView) {
        PopListView popListView = (PopListView) rootView.findViewById(R.id.br_class_list);
        if (popListView != null) {
            return new l1((LinearLayout) rootView, popListView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.br_class_list)));
    }

    @NonNull
    public static l1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookrack_class, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12285a;
    }
}

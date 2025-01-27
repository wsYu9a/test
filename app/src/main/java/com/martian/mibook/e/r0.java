package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class r0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12590a;

    /* renamed from: b */
    @NonNull
    public final TextView f12591b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12592c;

    private r0(@NonNull LinearLayout rootView, @NonNull TextView categoryTitle, @NonNull LinearLayout categoryTitleView) {
        this.f12590a = rootView;
        this.f12591b = categoryTitle;
        this.f12592c = categoryTitleView;
    }

    @NonNull
    public static r0 a(@NonNull View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.category_title);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.category_title)));
        }
        LinearLayout linearLayout = (LinearLayout) rootView;
        return new r0(linearLayout, textView, linearLayout);
    }

    @NonNull
    public static r0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static r0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_category_title_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12590a;
    }
}

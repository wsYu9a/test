package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class q0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12549a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12550b;

    /* renamed from: c */
    @NonNull
    public final TextView f12551c;

    private q0(@NonNull LinearLayout rootView, @NonNull ImageView tvCategoryDot, @NonNull TextView tvCategoryName) {
        this.f12549a = rootView;
        this.f12550b = tvCategoryDot;
        this.f12551c = tvCategoryName;
    }

    @NonNull
    public static q0 a(@NonNull View rootView) {
        int i2 = R.id.tv_category_dot;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.tv_category_dot);
        if (imageView != null) {
            i2 = R.id.tv_category_name;
            TextView textView = (TextView) rootView.findViewById(R.id.tv_category_name);
            if (textView != null) {
                return new q0((LinearLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static q0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static q0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_category_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12549a;
    }
}

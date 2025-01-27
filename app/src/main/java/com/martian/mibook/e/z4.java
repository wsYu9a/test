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
public final class z4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f13018a;

    /* renamed from: b */
    @NonNull
    public final TextView f13019b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f13020c;

    private z4(@NonNull LinearLayout rootView, @NonNull TextView tagTitle, @NonNull LinearLayout tagView) {
        this.f13018a = rootView;
        this.f13019b = tagTitle;
        this.f13020c = tagView;
    }

    @NonNull
    public static z4 a(@NonNull View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.tag_title);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.tag_title)));
        }
        LinearLayout linearLayout = (LinearLayout) rootView;
        return new z4(linearLayout, textView, linearLayout);
    }

    @NonNull
    public static z4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static z4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rank_tag_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13018a;
    }
}

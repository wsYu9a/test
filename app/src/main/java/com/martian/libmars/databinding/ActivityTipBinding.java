package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class ActivityTipBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12125a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12126b;

    /* renamed from: c */
    @NonNull
    public final TextView f12127c;

    /* renamed from: d */
    @NonNull
    public final RelativeLayout f12128d;

    public ActivityTipBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2) {
        this.f12125a = relativeLayout;
        this.f12126b = imageView;
        this.f12127c = textView;
        this.f12128d = relativeLayout2;
    }

    @NonNull
    public static ActivityTipBinding a(@NonNull View view) {
        int i10 = R.id.icon_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.open_hint;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                return new ActivityTipBinding(relativeLayout, imageView, textView, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityTipBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTipBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_tip, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12125a;
    }
}

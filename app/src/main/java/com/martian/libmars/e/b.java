package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class b implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9909a;

    /* renamed from: b */
    @NonNull
    public final ImageView f9910b;

    /* renamed from: c */
    @NonNull
    public final TextView f9911c;

    /* renamed from: d */
    @NonNull
    public final RelativeLayout f9912d;

    private b(@NonNull RelativeLayout rootView, @NonNull ImageView iconLogo, @NonNull TextView openHint, @NonNull RelativeLayout tipParentView) {
        this.f9909a = rootView;
        this.f9910b = iconLogo;
        this.f9911c = openHint;
        this.f9912d = tipParentView;
    }

    @NonNull
    public static b a(@NonNull View rootView) {
        int i2 = R.id.icon_logo;
        ImageView imageView = (ImageView) rootView.findViewById(i2);
        if (imageView != null) {
            i2 = R.id.open_hint;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                return new b(relativeLayout, imageView, textView, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_tip, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9909a;
    }
}

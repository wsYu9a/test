package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11807a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11808b;

    private c7(@NonNull RelativeLayout rootView, @NonNull ImageView imgBanner) {
        this.f11807a = rootView;
        this.f11808b = imgBanner;
    }

    @NonNull
    public static c7 a(@NonNull View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.img_banner);
        if (imageView != null) {
            return new c7((RelativeLayout) rootView, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.img_banner)));
    }

    @NonNull
    public static c7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.similarity_item_banner, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11807a;
    }
}

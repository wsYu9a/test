package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12149a;

    /* renamed from: b */
    @NonNull
    public final ViewStub f12150b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12151c;

    /* renamed from: d */
    @NonNull
    public final FrameLayout f12152d;

    private j(@NonNull RelativeLayout rootView, @NonNull ViewStub genderGuide, @NonNull ImageView iconLogo, @NonNull FrameLayout splashContainer) {
        this.f12149a = rootView;
        this.f12150b = genderGuide;
        this.f12151c = iconLogo;
        this.f12152d = splashContainer;
    }

    @NonNull
    public static j a(@NonNull View rootView) {
        int i2 = R.id.gender_guide;
        ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.gender_guide);
        if (viewStub != null) {
            i2 = R.id.icon_logo;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_logo);
            if (imageView != null) {
                i2 = R.id.splash_container;
                FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.splash_container);
                if (frameLayout != null) {
                    return new j((RelativeLayout) rootView, viewStub, imageView, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static j c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_enter, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12149a;
    }
}

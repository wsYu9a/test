package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class t implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12701a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12702b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12703c;

    /* renamed from: d */
    @NonNull
    public final RelativeLayout f12704d;

    private t(@NonNull RelativeLayout rootView, @NonNull ImageView shareImage, @NonNull LinearLayout shareLoadingHint, @NonNull RelativeLayout shareView) {
        this.f12701a = rootView;
        this.f12702b = shareImage;
        this.f12703c = shareLoadingHint;
        this.f12704d = shareView;
    }

    @NonNull
    public static t a(@NonNull View rootView) {
        int i2 = R.id.share_image;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.share_image);
        if (imageView != null) {
            i2 = R.id.share_loading_hint;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.share_loading_hint);
            if (linearLayout != null) {
                i2 = R.id.share_view;
                RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.share_view);
                if (relativeLayout != null) {
                    return new t((RelativeLayout) rootView, imageView, linearLayout, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static t c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_share_image_url, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12701a;
    }
}

package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class q5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12571a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f12572b;

    /* renamed from: c */
    @NonNull
    public final FrameLayout f12573c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12574d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeImageView f12575e;

    private q5(@NonNull RelativeLayout rootView, @NonNull FrameLayout readingBanner, @NonNull FrameLayout readingBannerJoint, @NonNull LinearLayout readingBannerLayout, @NonNull ReaderThemeImageView readingBannerPlaceholder) {
        this.f12571a = rootView;
        this.f12572b = readingBanner;
        this.f12573c = readingBannerJoint;
        this.f12574d = readingBannerLayout;
        this.f12575e = readingBannerPlaceholder;
    }

    @NonNull
    public static q5 a(@NonNull View rootView) {
        int i2 = R.id.reading_banner;
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.reading_banner);
        if (frameLayout != null) {
            i2 = R.id.reading_banner_joint;
            FrameLayout frameLayout2 = (FrameLayout) rootView.findViewById(R.id.reading_banner_joint);
            if (frameLayout2 != null) {
                i2 = R.id.reading_banner_layout;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.reading_banner_layout);
                if (linearLayout != null) {
                    i2 = R.id.reading_banner_placeholder;
                    ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.reading_banner_placeholder);
                    if (readerThemeImageView != null) {
                        return new q5((RelativeLayout) rootView, frameLayout, frameLayout2, linearLayout, readerThemeImageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static q5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static q5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_banner, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12571a;
    }
}

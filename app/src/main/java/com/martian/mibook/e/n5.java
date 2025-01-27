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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class n5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12431a;

    /* renamed from: b */
    @NonNull
    public final RoundedLayout f12432b;

    /* renamed from: c */
    @NonNull
    public final FrameLayout f12433c;

    /* renamed from: d */
    @NonNull
    public final FrameLayout f12434d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12435e;

    /* renamed from: f */
    @NonNull
    public final FrameLayout f12436f;

    /* renamed from: g */
    @NonNull
    public final FrameLayout f12437g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f12438h;

    /* renamed from: i */
    @NonNull
    public final LinearLayout f12439i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeImageView f12440j;

    @NonNull
    public final ReaderThemeImageView k;

    @NonNull
    public final ReaderThemeTextView l;

    @NonNull
    public final ThemeLinearLayout m;

    private n5(@NonNull RelativeLayout rootView, @NonNull RoundedLayout adsView, @NonNull FrameLayout flAdsContainer, @NonNull FrameLayout flAdsContainer2, @NonNull LinearLayout flAdsContainer3, @NonNull FrameLayout flAdsContainerJoint2, @NonNull FrameLayout flAdsContainerJoint3, @NonNull LinearLayout flCloseAdsIcon, @NonNull LinearLayout flCloseAdsVideo, @NonNull ReaderThemeImageView readingAdsCloseIcon, @NonNull ReaderThemeImageView readingAdsCloseMore, @NonNull ReaderThemeTextView readingAdsCloseTitle, @NonNull ThemeLinearLayout readingAdsCloseTitleLayout) {
        this.f12431a = rootView;
        this.f12432b = adsView;
        this.f12433c = flAdsContainer;
        this.f12434d = flAdsContainer2;
        this.f12435e = flAdsContainer3;
        this.f12436f = flAdsContainerJoint2;
        this.f12437g = flAdsContainerJoint3;
        this.f12438h = flCloseAdsIcon;
        this.f12439i = flCloseAdsVideo;
        this.f12440j = readingAdsCloseIcon;
        this.k = readingAdsCloseMore;
        this.l = readingAdsCloseTitle;
        this.m = readingAdsCloseTitleLayout;
    }

    @NonNull
    public static n5 a(@NonNull View rootView) {
        int i2 = R.id.ads_view;
        RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.ads_view);
        if (roundedLayout != null) {
            i2 = R.id.fl_ads_container;
            FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.fl_ads_container);
            if (frameLayout != null) {
                i2 = R.id.fl_ads_container_2;
                FrameLayout frameLayout2 = (FrameLayout) rootView.findViewById(R.id.fl_ads_container_2);
                if (frameLayout2 != null) {
                    i2 = R.id.fl_ads_container_3;
                    LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.fl_ads_container_3);
                    if (linearLayout != null) {
                        i2 = R.id.fl_ads_container_joint_2;
                        FrameLayout frameLayout3 = (FrameLayout) rootView.findViewById(R.id.fl_ads_container_joint_2);
                        if (frameLayout3 != null) {
                            i2 = R.id.fl_ads_container_joint_3;
                            FrameLayout frameLayout4 = (FrameLayout) rootView.findViewById(R.id.fl_ads_container_joint_3);
                            if (frameLayout4 != null) {
                                i2 = R.id.fl_close_ads_icon;
                                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.fl_close_ads_icon);
                                if (linearLayout2 != null) {
                                    i2 = R.id.fl_close_ads_video;
                                    LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.fl_close_ads_video);
                                    if (linearLayout3 != null) {
                                        i2 = R.id.reading_ads_close_icon;
                                        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.reading_ads_close_icon);
                                        if (readerThemeImageView != null) {
                                            i2 = R.id.reading_ads_close_more;
                                            ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) rootView.findViewById(R.id.reading_ads_close_more);
                                            if (readerThemeImageView2 != null) {
                                                i2 = R.id.reading_ads_close_title;
                                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.reading_ads_close_title);
                                                if (readerThemeTextView != null) {
                                                    i2 = R.id.reading_ads_close_title_layout;
                                                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.reading_ads_close_title_layout);
                                                    if (themeLinearLayout != null) {
                                                        return new n5((RelativeLayout) rootView, roundedLayout, frameLayout, frameLayout2, linearLayout, frameLayout3, frameLayout4, linearLayout2, linearLayout3, readerThemeImageView, readerThemeImageView2, readerThemeTextView, themeLinearLayout);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static n5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12431a;
    }
}

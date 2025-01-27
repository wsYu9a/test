package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class v implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12800a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12801b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12802c;

    /* renamed from: d */
    @NonNull
    public final FrameLayout f12803d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12804e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12805f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12806g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12807h;

    private v(@NonNull ThemeRelativeLayout rootView, @NonNull ImageView teenagerBookmallBg, @NonNull ThemeTextView teenagerBookmallButton, @NonNull FrameLayout teenagerBookmallContainer, @NonNull ThemeTextView teenagerBookmallExit, @NonNull LinearLayout teenagerBookmallHeader, @NonNull ImageView teenagerBookmallLogo, @NonNull ThemeTextView teenagerBookmallTitle) {
        this.f12800a = rootView;
        this.f12801b = teenagerBookmallBg;
        this.f12802c = teenagerBookmallButton;
        this.f12803d = teenagerBookmallContainer;
        this.f12804e = teenagerBookmallExit;
        this.f12805f = teenagerBookmallHeader;
        this.f12806g = teenagerBookmallLogo;
        this.f12807h = teenagerBookmallTitle;
    }

    @NonNull
    public static v a(@NonNull View rootView) {
        int i2 = R.id.teenager_bookmall_bg;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.teenager_bookmall_bg);
        if (imageView != null) {
            i2 = R.id.teenager_bookmall_button;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.teenager_bookmall_button);
            if (themeTextView != null) {
                i2 = R.id.teenager_bookmall_container;
                FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.teenager_bookmall_container);
                if (frameLayout != null) {
                    i2 = R.id.teenager_bookmall_exit;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.teenager_bookmall_exit);
                    if (themeTextView2 != null) {
                        i2 = R.id.teenager_bookmall_header;
                        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.teenager_bookmall_header);
                        if (linearLayout != null) {
                            i2 = R.id.teenager_bookmall_logo;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.teenager_bookmall_logo);
                            if (imageView2 != null) {
                                i2 = R.id.teenager_bookmall_title;
                                ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.teenager_bookmall_title);
                                if (themeTextView3 != null) {
                                    return new v((ThemeRelativeLayout) rootView, imageView, themeTextView, frameLayout, themeTextView2, linearLayout, imageView2, themeTextView3);
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
    public static v c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_teenager_bookmall, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12800a;
    }
}

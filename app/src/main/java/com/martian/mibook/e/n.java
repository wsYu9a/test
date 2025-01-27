package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class n implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12388a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12389b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12390c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12391d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12392e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12393f;

    private n(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout appAuthority, @NonNull ThemeLinearLayout personalInfoLink, @NonNull ThemeLinearLayout privacyLink, @NonNull ThemeLinearLayout privacySetting, @NonNull ThemeLinearLayout shareLink) {
        this.f12388a = rootView;
        this.f12389b = appAuthority;
        this.f12390c = personalInfoLink;
        this.f12391d = privacyLink;
        this.f12392e = privacySetting;
        this.f12393f = shareLink;
    }

    @NonNull
    public static n a(@NonNull View rootView) {
        int i2 = R.id.app_authority;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.app_authority);
        if (themeLinearLayout != null) {
            i2 = R.id.personal_info_link;
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.personal_info_link);
            if (themeLinearLayout2 != null) {
                i2 = R.id.privacy_link;
                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.privacy_link);
                if (themeLinearLayout3 != null) {
                    i2 = R.id.privacy_setting;
                    ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) rootView.findViewById(R.id.privacy_setting);
                    if (themeLinearLayout4 != null) {
                        i2 = R.id.share_link;
                        ThemeLinearLayout themeLinearLayout5 = (ThemeLinearLayout) rootView.findViewById(R.id.share_link);
                        if (themeLinearLayout5 != null) {
                            return new n((ThemeLinearLayout) rootView, themeLinearLayout, themeLinearLayout2, themeLinearLayout3, themeLinearLayout4, themeLinearLayout5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static n c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_privacy, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12388a;
    }
}

package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class s implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12634a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12635b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12636c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12637d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f12638e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12639f;

    /* renamed from: g */
    @NonNull
    public final MiSwitchButton f12640g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12641h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12642i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f12643j;

    @NonNull
    public final ThemeTextView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final ThemeTextView m;

    @NonNull
    public final ThemeLinearLayout n;

    @NonNull
    public final MiSwitchButton o;

    @NonNull
    public final MiSwitchButton p;

    @NonNull
    public final MiSwitchButton q;

    private s(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout acAccountLogout, @NonNull ThemeImageView acAccountLogoutDivider, @NonNull ThemeLinearLayout acAccountSecurity, @NonNull ThemeImageView acAccountSecurityDivider, @NonNull ThemeLinearLayout acAccountTeenager, @NonNull MiSwitchButton bookrackArchive, @NonNull ThemeTextView checkAppUpdateDesc, @NonNull ThemeTextView checkUpdateDesc, @NonNull ThemeTextView checkUpdateIntervalDesc, @NonNull ThemeTextView clearCacheSize, @NonNull ImageView notificationDot, @NonNull ThemeTextView pushNotificationStatus, @NonNull ThemeLinearLayout qrcodeView, @NonNull MiSwitchButton receiveBookrackRecommend, @NonNull MiSwitchButton recordBookrackCategory, @NonNull MiSwitchButton showImage) {
        this.f12634a = rootView;
        this.f12635b = acAccountLogout;
        this.f12636c = acAccountLogoutDivider;
        this.f12637d = acAccountSecurity;
        this.f12638e = acAccountSecurityDivider;
        this.f12639f = acAccountTeenager;
        this.f12640g = bookrackArchive;
        this.f12641h = checkAppUpdateDesc;
        this.f12642i = checkUpdateDesc;
        this.f12643j = checkUpdateIntervalDesc;
        this.k = clearCacheSize;
        this.l = notificationDot;
        this.m = pushNotificationStatus;
        this.n = qrcodeView;
        this.o = receiveBookrackRecommend;
        this.p = recordBookrackCategory;
        this.q = showImage;
    }

    @NonNull
    public static s a(@NonNull View rootView) {
        int i2 = R.id.ac_account_logout;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.ac_account_logout);
        if (themeLinearLayout != null) {
            i2 = R.id.ac_account_logout_divider;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.ac_account_logout_divider);
            if (themeImageView != null) {
                i2 = R.id.ac_account_security;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.ac_account_security);
                if (themeLinearLayout2 != null) {
                    i2 = R.id.ac_account_security_divider;
                    ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.ac_account_security_divider);
                    if (themeImageView2 != null) {
                        i2 = R.id.ac_account_teenager;
                        ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.ac_account_teenager);
                        if (themeLinearLayout3 != null) {
                            i2 = R.id.bookrack_archive;
                            MiSwitchButton miSwitchButton = (MiSwitchButton) rootView.findViewById(R.id.bookrack_archive);
                            if (miSwitchButton != null) {
                                i2 = R.id.check_app_update_desc;
                                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.check_app_update_desc);
                                if (themeTextView != null) {
                                    i2 = R.id.check_update_desc;
                                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.check_update_desc);
                                    if (themeTextView2 != null) {
                                        i2 = R.id.check_update_interval_desc;
                                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.check_update_interval_desc);
                                        if (themeTextView3 != null) {
                                            i2 = R.id.clear_cache_size;
                                            ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.clear_cache_size);
                                            if (themeTextView4 != null) {
                                                i2 = R.id.notification_dot;
                                                ImageView imageView = (ImageView) rootView.findViewById(R.id.notification_dot);
                                                if (imageView != null) {
                                                    i2 = R.id.push_notification_status;
                                                    ThemeTextView themeTextView5 = (ThemeTextView) rootView.findViewById(R.id.push_notification_status);
                                                    if (themeTextView5 != null) {
                                                        i2 = R.id.qrcode_view;
                                                        ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) rootView.findViewById(R.id.qrcode_view);
                                                        if (themeLinearLayout4 != null) {
                                                            i2 = R.id.receive_bookrack_recommend;
                                                            MiSwitchButton miSwitchButton2 = (MiSwitchButton) rootView.findViewById(R.id.receive_bookrack_recommend);
                                                            if (miSwitchButton2 != null) {
                                                                i2 = R.id.record_bookrack_category;
                                                                MiSwitchButton miSwitchButton3 = (MiSwitchButton) rootView.findViewById(R.id.record_bookrack_category);
                                                                if (miSwitchButton3 != null) {
                                                                    i2 = R.id.show_image;
                                                                    MiSwitchButton miSwitchButton4 = (MiSwitchButton) rootView.findViewById(R.id.show_image);
                                                                    if (miSwitchButton4 != null) {
                                                                        return new s((ThemeLinearLayout) rootView, themeLinearLayout, themeImageView, themeLinearLayout2, themeImageView2, themeLinearLayout3, miSwitchButton, themeTextView, themeTextView2, themeTextView3, themeTextView4, imageView, themeTextView5, themeLinearLayout4, miSwitchButton2, miSwitchButton3, miSwitchButton4);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static s c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static s d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_settings, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12634a;
    }
}

package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivitySettingsBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout acAccountLogout;

    @NonNull
    public final ThemeImageView acAccountLogoutDivider;

    @NonNull
    public final ThemeLinearLayout acAccountSecurity;

    @NonNull
    public final ThemeImageView acAccountSecurityDivider;

    @NonNull
    public final ThemeLinearLayout acAccountTeenager;

    @NonNull
    public final MiSwitchButton bookrackArchive;

    @NonNull
    public final ThemeTextView checkAppUpdateDesc;

    @NonNull
    public final ThemeTextView checkUpdateDesc;

    @NonNull
    public final ThemeTextView checkUpdateIntervalDesc;

    @NonNull
    public final ThemeTextView clearCacheSize;

    @NonNull
    public final ImageView notificationDot;

    @NonNull
    public final ThemeTextView pushNotificationStatus;

    @NonNull
    public final ThemeLinearLayout qrcodeView;

    @NonNull
    public final MiSwitchButton receiveBookrackRecommend;

    @NonNull
    public final MiSwitchButton recordBookrackCategory;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final MiSwitchButton showImage;

    private ActivitySettingsBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeImageView themeImageView2, @NonNull ThemeLinearLayout themeLinearLayout4, @NonNull MiSwitchButton miSwitchButton, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView5, @NonNull ThemeLinearLayout themeLinearLayout5, @NonNull MiSwitchButton miSwitchButton2, @NonNull MiSwitchButton miSwitchButton3, @NonNull MiSwitchButton miSwitchButton4) {
        this.rootView = themeLinearLayout;
        this.acAccountLogout = themeLinearLayout2;
        this.acAccountLogoutDivider = themeImageView;
        this.acAccountSecurity = themeLinearLayout3;
        this.acAccountSecurityDivider = themeImageView2;
        this.acAccountTeenager = themeLinearLayout4;
        this.bookrackArchive = miSwitchButton;
        this.checkAppUpdateDesc = themeTextView;
        this.checkUpdateDesc = themeTextView2;
        this.checkUpdateIntervalDesc = themeTextView3;
        this.clearCacheSize = themeTextView4;
        this.notificationDot = imageView;
        this.pushNotificationStatus = themeTextView5;
        this.qrcodeView = themeLinearLayout5;
        this.receiveBookrackRecommend = miSwitchButton2;
        this.recordBookrackCategory = miSwitchButton3;
        this.showImage = miSwitchButton4;
    }

    @NonNull
    public static ActivitySettingsBinding bind(@NonNull View view) {
        int i10 = R.id.ac_account_logout;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.ac_account_logout_divider;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.ac_account_security;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout2 != null) {
                    i10 = R.id.ac_account_security_divider;
                    ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView2 != null) {
                        i10 = R.id.ac_account_teenager;
                        ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout3 != null) {
                            i10 = R.id.bookrack_archive;
                            MiSwitchButton miSwitchButton = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
                            if (miSwitchButton != null) {
                                i10 = R.id.check_app_update_desc;
                                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView != null) {
                                    i10 = R.id.check_update_desc;
                                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView2 != null) {
                                        i10 = R.id.check_update_interval_desc;
                                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView3 != null) {
                                            i10 = R.id.clear_cache_size;
                                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView4 != null) {
                                                i10 = R.id.notification_dot;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                if (imageView != null) {
                                                    i10 = R.id.push_notification_status;
                                                    ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeTextView5 != null) {
                                                        i10 = R.id.qrcode_view;
                                                        ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (themeLinearLayout4 != null) {
                                                            i10 = R.id.receive_bookrack_recommend;
                                                            MiSwitchButton miSwitchButton2 = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                            if (miSwitchButton2 != null) {
                                                                i10 = R.id.record_bookrack_category;
                                                                MiSwitchButton miSwitchButton3 = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                if (miSwitchButton3 != null) {
                                                                    i10 = R.id.show_image;
                                                                    MiSwitchButton miSwitchButton4 = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                    if (miSwitchButton4 != null) {
                                                                        return new ActivitySettingsBinding((ThemeLinearLayout) view, themeLinearLayout, themeImageView, themeLinearLayout2, themeImageView2, themeLinearLayout3, miSwitchButton, themeTextView, themeTextView2, themeTextView3, themeTextView4, imageView, themeTextView5, themeLinearLayout4, miSwitchButton2, miSwitchButton3, miSwitchButton4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivitySettingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySettingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_settings, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}

package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeProgressBar;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class UpgradeDialogBinding implements ViewBinding {

    @NonNull
    public final ThemeProgressBar rbsProgressBar;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeTextView tvUpgradeConfirm;

    @NonNull
    public final RoundedLayout updateHome;

    @NonNull
    public final ImageView upgradeClose;

    @NonNull
    public final ThemeTextView upgradeFeature;

    @NonNull
    public final RelativeLayout upgradeHeader;

    @NonNull
    public final TextView upgradeName;

    private UpgradeDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeProgressBar themeProgressBar, @NonNull ThemeTextView themeTextView, @NonNull RoundedLayout roundedLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView2, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.rbsProgressBar = themeProgressBar;
        this.tvUpgradeConfirm = themeTextView;
        this.updateHome = roundedLayout;
        this.upgradeClose = imageView;
        this.upgradeFeature = themeTextView2;
        this.upgradeHeader = relativeLayout2;
        this.upgradeName = textView;
    }

    @NonNull
    public static UpgradeDialogBinding bind(@NonNull View view) {
        int i10 = R.id.rbs_progress_bar;
        ThemeProgressBar themeProgressBar = (ThemeProgressBar) ViewBindings.findChildViewById(view, i10);
        if (themeProgressBar != null) {
            i10 = R.id.tv_upgrade_confirm;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.update_home;
                RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                if (roundedLayout != null) {
                    i10 = R.id.upgrade_close;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.upgrade_feature;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.upgrade_header;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                            if (relativeLayout != null) {
                                i10 = R.id.upgrade_name;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView != null) {
                                    return new UpgradeDialogBinding((RelativeLayout) view, themeProgressBar, themeTextView, roundedLayout, imageView, themeTextView2, relativeLayout, textView);
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
    public static UpgradeDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static UpgradeDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.upgrade_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}

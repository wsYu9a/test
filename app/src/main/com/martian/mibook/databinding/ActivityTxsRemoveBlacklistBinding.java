package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityTxsRemoveBlacklistBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView inviteFriendNumber;

    @NonNull
    public final LinearLayout removeBlackLoading;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final CheckBox ruleConfirm;

    @NonNull
    public final ThemeTextView withdrawLeftCount;

    private ActivityTxsRemoveBlacklistBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeTextView themeTextView, @NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeRelativeLayout;
        this.inviteFriendNumber = themeTextView;
        this.removeBlackLoading = linearLayout;
        this.ruleConfirm = checkBox;
        this.withdrawLeftCount = themeTextView2;
    }

    @NonNull
    public static ActivityTxsRemoveBlacklistBinding bind(@NonNull View view) {
        int i10 = R.id.invite_friend_number;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.remove_black_loading;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.rule_confirm;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i10);
                if (checkBox != null) {
                    i10 = R.id.withdraw_left_count;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        return new ActivityTxsRemoveBlacklistBinding((ThemeRelativeLayout) view, themeTextView, linearLayout, checkBox, themeTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityTxsRemoveBlacklistBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTxsRemoveBlacklistBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_txs_remove_blacklist, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}

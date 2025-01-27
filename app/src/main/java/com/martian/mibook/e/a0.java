package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class a0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f11661a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f11662b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f11663c;

    /* renamed from: d */
    @NonNull
    public final CheckBox f11664d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f11665e;

    private a0(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeTextView inviteFriendNumber, @NonNull LinearLayout removeBlackLoading, @NonNull CheckBox ruleConfirm, @NonNull ThemeTextView withdrawLeftCount) {
        this.f11661a = rootView;
        this.f11662b = inviteFriendNumber;
        this.f11663c = removeBlackLoading;
        this.f11664d = ruleConfirm;
        this.f11665e = withdrawLeftCount;
    }

    @NonNull
    public static a0 a(@NonNull View rootView) {
        int i2 = R.id.invite_friend_number;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.invite_friend_number);
        if (themeTextView != null) {
            i2 = R.id.remove_black_loading;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.remove_black_loading);
            if (linearLayout != null) {
                i2 = R.id.rule_confirm;
                CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.rule_confirm);
                if (checkBox != null) {
                    i2 = R.id.withdraw_left_count;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.withdraw_left_count);
                    if (themeTextView2 != null) {
                        return new a0((ThemeRelativeLayout) rootView, themeTextView, linearLayout, checkBox, themeTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static a0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_txs_remove_blacklist, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f11661a;
    }
}

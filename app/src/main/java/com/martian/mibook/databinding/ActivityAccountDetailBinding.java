package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityAccountDetailBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout acAccountSecurity;

    @NonNull
    public final ImageView accountHead;

    @NonNull
    public final TextView nicknameAccount;

    @NonNull
    public final ThemeLinearLayout nicknameAccountId;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final TextView sexAccount;

    @NonNull
    public final ThemeLinearLayout sexAccountId;

    @NonNull
    public final ThemeTextView totalReadDuration;

    @NonNull
    public final TextView uid;

    private ActivityAccountDetailBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull TextView textView2, @NonNull ThemeLinearLayout themeLinearLayout4, @NonNull ThemeTextView themeTextView, @NonNull TextView textView3) {
        this.rootView = themeLinearLayout;
        this.acAccountSecurity = themeLinearLayout2;
        this.accountHead = imageView;
        this.nicknameAccount = textView;
        this.nicknameAccountId = themeLinearLayout3;
        this.sexAccount = textView2;
        this.sexAccountId = themeLinearLayout4;
        this.totalReadDuration = themeTextView;
        this.uid = textView3;
    }

    @NonNull
    public static ActivityAccountDetailBinding bind(@NonNull View view) {
        int i10 = R.id.ac_account_security;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.account_head;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.nickname_account;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.nickname_accountId;
                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (themeLinearLayout2 != null) {
                        i10 = R.id.sex_account;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.sex_accountId;
                            ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeLinearLayout3 != null) {
                                i10 = R.id.total_read_duration;
                                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView != null) {
                                    i10 = R.id.uid;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView3 != null) {
                                        return new ActivityAccountDetailBinding((ThemeLinearLayout) view, themeLinearLayout, imageView, textView, themeLinearLayout2, textView2, themeLinearLayout3, themeTextView, textView3);
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
    public static ActivityAccountDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAccountDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_account_detail, viewGroup, false);
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

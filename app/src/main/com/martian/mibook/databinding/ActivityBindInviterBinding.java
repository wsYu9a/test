package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityBindInviterBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bindInviterView;

    @NonNull
    public final RelativeLayout bindedInviterView;

    @NonNull
    public final ThemeTextView inviteBindHint;

    @NonNull
    public final EditText inviteCode;

    @NonNull
    public final ThemeTextView myInviteCode;

    @NonNull
    private final ThemeLinearLayout rootView;

    private ActivityBindInviterBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull EditText editText, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeLinearLayout;
        this.bindInviterView = linearLayout;
        this.bindedInviterView = relativeLayout;
        this.inviteBindHint = themeTextView;
        this.inviteCode = editText;
        this.myInviteCode = themeTextView2;
    }

    @NonNull
    public static ActivityBindInviterBinding bind(@NonNull View view) {
        int i10 = R.id.bind_inviter_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.binded_inviter_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
            if (relativeLayout != null) {
                i10 = R.id.invite_bind_hint;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.invite_code;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i10);
                    if (editText != null) {
                        i10 = R.id.my_invite_code;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            return new ActivityBindInviterBinding((ThemeLinearLayout) view, linearLayout, relativeLayout, themeTextView, editText, themeTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityBindInviterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityBindInviterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_bind_inviter, viewGroup, false);
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

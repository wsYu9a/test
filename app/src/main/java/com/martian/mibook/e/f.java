package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class f implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11924a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f11925b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f11926c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f11927d;

    /* renamed from: e */
    @NonNull
    public final EditText f11928e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f11929f;

    private f(@NonNull ThemeLinearLayout rootView, @NonNull LinearLayout bindInviterView, @NonNull RelativeLayout bindedInviterView, @NonNull ThemeTextView inviteBindHint, @NonNull EditText inviteCode, @NonNull ThemeTextView myInviteCode) {
        this.f11924a = rootView;
        this.f11925b = bindInviterView;
        this.f11926c = bindedInviterView;
        this.f11927d = inviteBindHint;
        this.f11928e = inviteCode;
        this.f11929f = myInviteCode;
    }

    @NonNull
    public static f a(@NonNull View rootView) {
        int i2 = R.id.bind_inviter_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bind_inviter_view);
        if (linearLayout != null) {
            i2 = R.id.binded_inviter_view;
            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.binded_inviter_view);
            if (relativeLayout != null) {
                i2 = R.id.invite_bind_hint;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.invite_bind_hint);
                if (themeTextView != null) {
                    i2 = R.id.invite_code;
                    EditText editText = (EditText) rootView.findViewById(R.id.invite_code);
                    if (editText != null) {
                        i2 = R.id.my_invite_code;
                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.my_invite_code);
                        if (themeTextView2 != null) {
                            return new f((ThemeLinearLayout) rootView, linearLayout, relativeLayout, themeTextView, editText, themeTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_bind_inviter, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11924a;
    }
}

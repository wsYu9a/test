package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class b implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11716a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11717b;

    /* renamed from: c */
    @NonNull
    public final ImageView f11718c;

    /* renamed from: d */
    @NonNull
    public final TextView f11719d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f11720e;

    /* renamed from: f */
    @NonNull
    public final TextView f11721f;

    /* renamed from: g */
    @NonNull
    public final ThemeLinearLayout f11722g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f11723h;

    /* renamed from: i */
    @NonNull
    public final TextView f11724i;

    private b(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout acAccountSecurity, @NonNull ImageView accountHead, @NonNull TextView nicknameAccount, @NonNull ThemeLinearLayout nicknameAccountId, @NonNull TextView sexAccount, @NonNull ThemeLinearLayout sexAccountId, @NonNull ThemeTextView totalReadDuration, @NonNull TextView uid) {
        this.f11716a = rootView;
        this.f11717b = acAccountSecurity;
        this.f11718c = accountHead;
        this.f11719d = nicknameAccount;
        this.f11720e = nicknameAccountId;
        this.f11721f = sexAccount;
        this.f11722g = sexAccountId;
        this.f11723h = totalReadDuration;
        this.f11724i = uid;
    }

    @NonNull
    public static b a(@NonNull View rootView) {
        int i2 = R.id.ac_account_security;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.ac_account_security);
        if (themeLinearLayout != null) {
            i2 = R.id.account_head;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.account_head);
            if (imageView != null) {
                i2 = R.id.nickname_account;
                TextView textView = (TextView) rootView.findViewById(R.id.nickname_account);
                if (textView != null) {
                    i2 = R.id.nickname_accountId;
                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.nickname_accountId);
                    if (themeLinearLayout2 != null) {
                        i2 = R.id.sex_account;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.sex_account);
                        if (textView2 != null) {
                            i2 = R.id.sex_accountId;
                            ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.sex_accountId);
                            if (themeLinearLayout3 != null) {
                                i2 = R.id.total_read_duration;
                                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.total_read_duration);
                                if (themeTextView != null) {
                                    i2 = R.id.uid;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.uid);
                                    if (textView3 != null) {
                                        return new b((ThemeLinearLayout) rootView, themeLinearLayout, imageView, textView, themeLinearLayout2, textView2, themeLinearLayout3, themeTextView, textView3);
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
    public static b c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_account_detail, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11716a;
    }
}

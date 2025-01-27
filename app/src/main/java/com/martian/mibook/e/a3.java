package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class a3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11686a;

    /* renamed from: b */
    @NonNull
    public final a f11687b;

    /* renamed from: c */
    @NonNull
    public final ThemeIRecyclerView f11688c;

    /* renamed from: d */
    @NonNull
    public final c1 f11689d;

    private a3(@NonNull ThemeLinearLayout rootView, @NonNull a actionbarBookrack, @NonNull ThemeIRecyclerView bookrackIrc, @NonNull c1 bookrackSettingHeader) {
        this.f11686a = rootView;
        this.f11687b = actionbarBookrack;
        this.f11688c = bookrackIrc;
        this.f11689d = bookrackSettingHeader;
    }

    @NonNull
    public static a3 a(@NonNull View rootView) {
        int i2 = R.id.actionbar_bookrack;
        View findViewById = rootView.findViewById(R.id.actionbar_bookrack);
        if (findViewById != null) {
            a a2 = a.a(findViewById);
            ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.bookrack_irc);
            if (themeIRecyclerView != null) {
                View findViewById2 = rootView.findViewById(R.id.bookrack_setting_header);
                if (findViewById2 != null) {
                    return new a3((ThemeLinearLayout) rootView, a2, themeIRecyclerView, c1.a(findViewById2));
                }
                i2 = R.id.bookrack_setting_header;
            } else {
                i2 = R.id.bookrack_irc;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static a3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_bookrack, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11686a;
    }
}

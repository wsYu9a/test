package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class x2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12923a;

    /* renamed from: b */
    @NonNull
    public final ThemeView f12924b;

    /* renamed from: c */
    @NonNull
    public final ThemeIRecyclerView f12925c;

    /* renamed from: d */
    @NonNull
    public final ViewStub f12926d;

    /* renamed from: e */
    @NonNull
    public final ThemeRelativeLayout f12927e;

    private x2(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeView bookmallHeaderBg, @NonNull ThemeIRecyclerView bookmallIrc, @NonNull ViewStub readingRecord, @NonNull ThemeRelativeLayout svContainer) {
        this.f12923a = rootView;
        this.f12924b = bookmallHeaderBg;
        this.f12925c = bookmallIrc;
        this.f12926d = readingRecord;
        this.f12927e = svContainer;
    }

    @NonNull
    public static x2 a(@NonNull View rootView) {
        int i2 = R.id.bookmall_header_bg;
        ThemeView themeView = (ThemeView) rootView.findViewById(R.id.bookmall_header_bg);
        if (themeView != null) {
            i2 = R.id.bookmall_irc;
            ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.bookmall_irc);
            if (themeIRecyclerView != null) {
                i2 = R.id.reading_record;
                ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.reading_record);
                if (viewStub != null) {
                    ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) rootView;
                    return new x2(themeRelativeLayout, themeView, themeIRecyclerView, viewStub, themeRelativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static x2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_bookmall, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12923a;
    }
}

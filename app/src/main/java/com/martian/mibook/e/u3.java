package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class u3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12779a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12780b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12781c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12782d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12783e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12784f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12785g;

    /* renamed from: h */
    @NonNull
    public final ThemeImageView f12786h;

    private u3(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView bsAlreadyIn, @NonNull ImageView cbTrackMultiple, @NonNull ThemeTextView textviewBookDate, @NonNull ThemeTextView textviewBookName, @NonNull ThemeTextView textviewBookSize, @NonNull LinearLayout trackInfo, @NonNull ThemeImageView tvType) {
        this.f12779a = rootView;
        this.f12780b = bsAlreadyIn;
        this.f12781c = cbTrackMultiple;
        this.f12782d = textviewBookDate;
        this.f12783e = textviewBookName;
        this.f12784f = textviewBookSize;
        this.f12785g = trackInfo;
        this.f12786h = tvType;
    }

    @NonNull
    public static u3 a(@NonNull View rootView) {
        int i2 = R.id.bs_already_in;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bs_already_in);
        if (themeTextView != null) {
            i2 = R.id.cb_track_multiple;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.cb_track_multiple);
            if (imageView != null) {
                i2 = R.id.textview_book_date;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.textview_book_date);
                if (themeTextView2 != null) {
                    i2 = R.id.textview_book_name;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.textview_book_name);
                    if (themeTextView3 != null) {
                        i2 = R.id.textview_book_size;
                        ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.textview_book_size);
                        if (themeTextView4 != null) {
                            i2 = R.id.track_info;
                            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.track_info);
                            if (linearLayout != null) {
                                i2 = R.id.tv_type;
                                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.tv_type);
                                if (themeImageView != null) {
                                    return new u3((ThemeLinearLayout) rootView, themeTextView, imageView, themeTextView2, themeTextView3, themeTextView4, linearLayout, themeImageView);
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
    public static u3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.list_item_track_mutiple, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12779a;
    }
}

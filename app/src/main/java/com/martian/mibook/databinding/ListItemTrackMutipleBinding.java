package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ListItemTrackMutipleBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bsAlreadyIn;

    @NonNull
    public final ImageView cbTrackMultiple;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView textviewBookDate;

    @NonNull
    public final ThemeTextView textviewBookName;

    @NonNull
    public final ThemeTextView textviewBookSize;

    @NonNull
    public final LinearLayout trackInfo;

    @NonNull
    public final ThemeImageView tvType;

    private ListItemTrackMutipleBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull LinearLayout linearLayout, @NonNull ThemeImageView themeImageView) {
        this.rootView = themeLinearLayout;
        this.bsAlreadyIn = themeTextView;
        this.cbTrackMultiple = imageView;
        this.textviewBookDate = themeTextView2;
        this.textviewBookName = themeTextView3;
        this.textviewBookSize = themeTextView4;
        this.trackInfo = linearLayout;
        this.tvType = themeImageView;
    }

    @NonNull
    public static ListItemTrackMutipleBinding bind(@NonNull View view) {
        int i10 = R.id.bs_already_in;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.cb_track_multiple;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.textview_book_date;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.textview_book_name;
                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView3 != null) {
                        i10 = R.id.textview_book_size;
                        ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView4 != null) {
                            i10 = R.id.track_info;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout != null) {
                                i10 = R.id.tv_type;
                                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (themeImageView != null) {
                                    return new ListItemTrackMutipleBinding((ThemeLinearLayout) view, themeTextView, imageView, themeTextView2, themeTextView3, themeTextView4, linearLayout, themeImageView);
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
    public static ListItemTrackMutipleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemTrackMutipleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.list_item_track_mutiple, viewGroup, false);
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

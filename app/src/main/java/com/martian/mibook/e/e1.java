package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class e1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11880a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11881b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f11882c;

    /* renamed from: d */
    @NonNull
    public final ImageView f11883d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f11884e;

    /* renamed from: f */
    @NonNull
    public final TextView f11885f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f11886g;

    /* renamed from: h */
    @NonNull
    public final TextView f11887h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f11888i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f11889j;

    private e1(@NonNull LinearLayout rootView, @NonNull ImageView bgBookrackPromote, @NonNull LinearLayout bookListItemContainer, @NonNull ImageView bpItemSelect, @NonNull ThemeImageView ivCover, @NonNull TextView ivUpdateSign, @NonNull ThemeTextView tvReadingRecord, @NonNull TextView tvTitleName, @NonNull ThemeTextView tvUrl, @NonNull ThemeTextView tvUrlName) {
        this.f11880a = rootView;
        this.f11881b = bgBookrackPromote;
        this.f11882c = bookListItemContainer;
        this.f11883d = bpItemSelect;
        this.f11884e = ivCover;
        this.f11885f = ivUpdateSign;
        this.f11886g = tvReadingRecord;
        this.f11887h = tvTitleName;
        this.f11888i = tvUrl;
        this.f11889j = tvUrlName;
    }

    @NonNull
    public static e1 a(@NonNull View rootView) {
        int i2 = R.id.bg_bookrack_promote;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bg_bookrack_promote);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i2 = R.id.bp_item_select;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bp_item_select);
            if (imageView2 != null) {
                i2 = R.id.iv_cover;
                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.iv_cover);
                if (themeImageView != null) {
                    i2 = R.id.iv_update_sign;
                    TextView textView = (TextView) rootView.findViewById(R.id.iv_update_sign);
                    if (textView != null) {
                        i2 = R.id.tv_reading_record;
                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tv_reading_record);
                        if (themeTextView != null) {
                            i2 = R.id.tv_title_name;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.tv_title_name);
                            if (textView2 != null) {
                                i2 = R.id.tv_url;
                                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.tv_url);
                                if (themeTextView2 != null) {
                                    i2 = R.id.tv_url_name;
                                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.tv_url_name);
                                    if (themeTextView3 != null) {
                                        return new e1(linearLayout, imageView, linearLayout, imageView2, themeImageView, textView, themeTextView, textView2, themeTextView2, themeTextView3);
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
    public static e1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_store_list_book_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11880a;
    }
}

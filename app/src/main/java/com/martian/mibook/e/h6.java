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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class h6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12083a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12084b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12085c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12086d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12087e;

    /* renamed from: f */
    @NonNull
    public final ThemeImageView f12088f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12089g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12090h;

    private h6(@NonNull LinearLayout rootView, @NonNull ImageView bpItemSelect, @NonNull ThemeTextView recordAddBookrack, @NonNull ThemeTextView tvBookName, @NonNull ThemeTextView tvChapterTitle, @NonNull ThemeImageView tvHistoryIcon, @NonNull ThemeTextView tvLastReadingTime, @NonNull ThemeTextView tvRecordAuthor) {
        this.f12083a = rootView;
        this.f12084b = bpItemSelect;
        this.f12085c = recordAddBookrack;
        this.f12086d = tvBookName;
        this.f12087e = tvChapterTitle;
        this.f12088f = tvHistoryIcon;
        this.f12089g = tvLastReadingTime;
        this.f12090h = tvRecordAuthor;
    }

    @NonNull
    public static h6 a(@NonNull View rootView) {
        int i2 = R.id.bp_item_select;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bp_item_select);
        if (imageView != null) {
            i2 = R.id.record_add_bookrack;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.record_add_bookrack);
            if (themeTextView != null) {
                i2 = R.id.tv_book_name;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.tv_book_name);
                if (themeTextView2 != null) {
                    i2 = R.id.tv_chapter_title;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.tv_chapter_title);
                    if (themeTextView3 != null) {
                        i2 = R.id.tv_history_icon;
                        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.tv_history_icon);
                        if (themeImageView != null) {
                            i2 = R.id.tv_last_reading_time;
                            ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.tv_last_reading_time);
                            if (themeTextView4 != null) {
                                i2 = R.id.tv_record_author;
                                ThemeTextView themeTextView5 = (ThemeTextView) rootView.findViewById(R.id.tv_record_author);
                                if (themeTextView5 != null) {
                                    return new h6((LinearLayout) rootView, imageView, themeTextView, themeTextView2, themeTextView3, themeImageView, themeTextView4, themeTextView5);
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
    public static h6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_record_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12083a;
    }
}

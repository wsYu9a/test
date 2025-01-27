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
public final class h0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12035a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12036b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12037c;

    /* renamed from: d */
    @NonNull
    public final TextView f12038d;

    /* renamed from: e */
    @NonNull
    public final TextView f12039e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12040f;

    /* renamed from: g */
    @NonNull
    public final TextView f12041g;

    private h0(@NonNull ThemeLinearLayout rootView, @NonNull ImageView ivCover, @NonNull ImageView ivPopupHint, @NonNull TextView tvArchiveDate, @NonNull TextView tvAuthor, @NonNull ThemeTextView tvBookname, @NonNull TextView tvUrlOrChapter) {
        this.f12035a = rootView;
        this.f12036b = ivCover;
        this.f12037c = ivPopupHint;
        this.f12038d = tvArchiveDate;
        this.f12039e = tvAuthor;
        this.f12040f = tvBookname;
        this.f12041g = tvUrlOrChapter;
    }

    @NonNull
    public static h0 a(@NonNull View rootView) {
        int i2 = R.id.iv_cover;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_cover);
        if (imageView != null) {
            i2 = R.id.iv_popup_hint;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_popup_hint);
            if (imageView2 != null) {
                i2 = R.id.tv_archive_date;
                TextView textView = (TextView) rootView.findViewById(R.id.tv_archive_date);
                if (textView != null) {
                    i2 = R.id.tv_author;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.tv_author);
                    if (textView2 != null) {
                        i2 = R.id.tv_bookname;
                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tv_bookname);
                        if (themeTextView != null) {
                            i2 = R.id.tv_url_or_chapter;
                            TextView textView3 = (TextView) rootView.findViewById(R.id.tv_url_or_chapter);
                            if (textView3 != null) {
                                return new h0((ThemeLinearLayout) rootView, imageView, imageView2, textView, textView2, themeTextView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static h0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.archive_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12035a;
    }
}

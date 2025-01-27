package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class e5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ReaderThemeLinearLayout f11909a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11910b;

    /* renamed from: c */
    @NonNull
    public final ImageView f11911c;

    /* renamed from: d */
    @NonNull
    public final TextView f11912d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f11913e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f11914f;

    private e5(@NonNull ReaderThemeLinearLayout rootView, @NonNull ImageView ivBookCover, @NonNull ImageView ivBookCoverBg, @NonNull TextView ivBookCreative, @NonNull ReaderThemeTextView ivBookDesc, @NonNull ReaderThemeTextView ivBookTitle) {
        this.f11909a = rootView;
        this.f11910b = ivBookCover;
        this.f11911c = ivBookCoverBg;
        this.f11912d = ivBookCreative;
        this.f11913e = ivBookDesc;
        this.f11914f = ivBookTitle;
    }

    @NonNull
    public static e5 a(@NonNull View rootView) {
        int i2 = R.id.iv_book_cover;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_book_cover);
        if (imageView != null) {
            i2 = R.id.iv_book_cover_bg;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_book_cover_bg);
            if (imageView2 != null) {
                i2 = R.id.iv_book_creative;
                TextView textView = (TextView) rootView.findViewById(R.id.iv_book_creative);
                if (textView != null) {
                    i2 = R.id.iv_book__desc;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.iv_book__desc);
                    if (readerThemeTextView != null) {
                        i2 = R.id.iv_book__title;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.iv_book__title);
                        if (readerThemeTextView2 != null) {
                            return new e5((ReaderThemeLinearLayout) rootView, imageView, imageView2, textView, readerThemeTextView, readerThemeTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_book, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ReaderThemeLinearLayout getRoot() {
        return this.f11909a;
    }
}

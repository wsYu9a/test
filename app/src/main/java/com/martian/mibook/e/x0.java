package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class x0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12911a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f12912b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f12913c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeTextView f12914d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12915e;

    private x0(@NonNull LinearLayout rootView, @NonNull ReaderThemeTextView tvChapterTitle, @NonNull ReaderThemeTextView tvDimiPercent, @NonNull ReaderThemeTextView tvMarkTime, @NonNull ReaderThemeTextView tvSummary) {
        this.f12911a = rootView;
        this.f12912b = tvChapterTitle;
        this.f12913c = tvDimiPercent;
        this.f12914d = tvMarkTime;
        this.f12915e = tvSummary;
    }

    @NonNull
    public static x0 a(@NonNull View rootView) {
        int i2 = R.id.tv_chapter_title;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_chapter_title);
        if (readerThemeTextView != null) {
            i2 = R.id.tv_dimi_percent;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_dimi_percent);
            if (readerThemeTextView2 != null) {
                i2 = R.id.tv_mark_time;
                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_mark_time);
                if (readerThemeTextView3 != null) {
                    i2 = R.id.tv_summary;
                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_summary);
                    if (readerThemeTextView4 != null) {
                        return new x0((LinearLayout) rootView, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static x0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_mark_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12911a;
    }
}

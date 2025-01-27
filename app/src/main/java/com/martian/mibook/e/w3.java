package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class w3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12879a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f12880b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f12881c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeItemTextView f12882d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12883e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12884f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeItemTextView f12885g;

    private w3(@NonNull LinearLayout rootView, @NonNull ReaderThemeTextView tvActiveReadingBookname, @NonNull ReaderThemeTextView tvActiveReadingContent, @NonNull ReaderThemeItemTextView tvActiveReadingPurchaseVideo, @NonNull ReaderThemeTextView tvActiveReadingTitle, @NonNull LinearLayout tvActiveReadingTitleView, @NonNull ReaderThemeItemTextView tvActiveReadingVip) {
        this.f12879a = rootView;
        this.f12880b = tvActiveReadingBookname;
        this.f12881c = tvActiveReadingContent;
        this.f12882d = tvActiveReadingPurchaseVideo;
        this.f12883e = tvActiveReadingTitle;
        this.f12884f = tvActiveReadingTitleView;
        this.f12885g = tvActiveReadingVip;
    }

    @NonNull
    public static w3 a(@NonNull View rootView) {
        int i2 = R.id.tv_active_reading_bookname;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_active_reading_bookname);
        if (readerThemeTextView != null) {
            i2 = R.id.tv_active_reading_content;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_active_reading_content);
            if (readerThemeTextView2 != null) {
                i2 = R.id.tv_active_reading_purchase_video;
                ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.tv_active_reading_purchase_video);
                if (readerThemeItemTextView != null) {
                    i2 = R.id.tv_active_reading_title;
                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_active_reading_title);
                    if (readerThemeTextView3 != null) {
                        i2 = R.id.tv_active_reading_title_view;
                        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.tv_active_reading_title_view);
                        if (linearLayout != null) {
                            i2 = R.id.tv_active_reading_vip;
                            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) rootView.findViewById(R.id.tv_active_reading_vip);
                            if (readerThemeItemTextView2 != null) {
                                return new w3((LinearLayout) rootView, readerThemeTextView, readerThemeTextView2, readerThemeItemTextView, readerThemeTextView3, linearLayout, readerThemeItemTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static w3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.loading_book_active, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12879a;
    }
}

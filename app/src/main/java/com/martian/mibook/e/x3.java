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
public final class x3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12928a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeItemTextView f12929b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f12930c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeTextView f12931d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12932e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f12933f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeItemTextView f12934g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeItemTextView f12935h;

    private x3(@NonNull LinearLayout rootView, @NonNull ReaderThemeItemTextView tvChapterFeedback, @NonNull ReaderThemeTextView tvErrorMsg, @NonNull ReaderThemeTextView tvFailBookname, @NonNull LinearLayout tvFailTitleView, @NonNull ReaderThemeTextView tvFailingReadingTitle, @NonNull ReaderThemeItemTextView tvFeedback, @NonNull ReaderThemeItemTextView tvRefresh) {
        this.f12928a = rootView;
        this.f12929b = tvChapterFeedback;
        this.f12930c = tvErrorMsg;
        this.f12931d = tvFailBookname;
        this.f12932e = tvFailTitleView;
        this.f12933f = tvFailingReadingTitle;
        this.f12934g = tvFeedback;
        this.f12935h = tvRefresh;
    }

    @NonNull
    public static x3 a(@NonNull View rootView) {
        int i2 = R.id.tv_chapter_feedback;
        ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.tv_chapter_feedback);
        if (readerThemeItemTextView != null) {
            i2 = R.id.tv_error_msg;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_error_msg);
            if (readerThemeTextView != null) {
                i2 = R.id.tv_fail_bookname;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_fail_bookname);
                if (readerThemeTextView2 != null) {
                    i2 = R.id.tv_fail_title_view;
                    LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.tv_fail_title_view);
                    if (linearLayout != null) {
                        i2 = R.id.tv_failing_reading_title;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_failing_reading_title);
                        if (readerThemeTextView3 != null) {
                            i2 = R.id.tv_feedback;
                            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) rootView.findViewById(R.id.tv_feedback);
                            if (readerThemeItemTextView2 != null) {
                                i2 = R.id.tv_refresh;
                                ReaderThemeItemTextView readerThemeItemTextView3 = (ReaderThemeItemTextView) rootView.findViewById(R.id.tv_refresh);
                                if (readerThemeItemTextView3 != null) {
                                    return new x3((LinearLayout) rootView, readerThemeItemTextView, readerThemeTextView, readerThemeTextView2, linearLayout, readerThemeTextView3, readerThemeItemTextView2, readerThemeItemTextView3);
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
    public static x3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.loading_failure, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12928a;
    }
}

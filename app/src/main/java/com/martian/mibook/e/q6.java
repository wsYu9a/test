package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class q6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12576a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f12577b;

    /* renamed from: c */
    @NonNull
    public final ListView f12578c;

    /* renamed from: d */
    @NonNull
    public final RelativeLayout f12579d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeImageView f12580e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeItemTextView f12581f;

    /* renamed from: g */
    @NonNull
    public final RoundedLayout f12582g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeLinearLayout f12583h;

    private q6(@NonNull RelativeLayout rootView, @NonNull ReaderThemeTextView bookChapterNumber, @NonNull ListView tfListview, @NonNull RelativeLayout typeFace, @NonNull ReaderThemeImageView typeFaceClose, @NonNull ReaderThemeItemTextView typeFaceImport, @NonNull RoundedLayout typeFaceRoundView, @NonNull ReaderThemeLinearLayout typeFaceView) {
        this.f12576a = rootView;
        this.f12577b = bookChapterNumber;
        this.f12578c = tfListview;
        this.f12579d = typeFace;
        this.f12580e = typeFaceClose;
        this.f12581f = typeFaceImport;
        this.f12582g = typeFaceRoundView;
        this.f12583h = typeFaceView;
    }

    @NonNull
    public static q6 a(@NonNull View rootView) {
        int i2 = R.id.book_chapter_number;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.book_chapter_number);
        if (readerThemeTextView != null) {
            i2 = R.id.tf_listview;
            ListView listView = (ListView) rootView.findViewById(R.id.tf_listview);
            if (listView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                i2 = R.id.type_face_close;
                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.type_face_close);
                if (readerThemeImageView != null) {
                    i2 = R.id.type_face_import;
                    ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.type_face_import);
                    if (readerThemeItemTextView != null) {
                        i2 = R.id.type_face_round_view;
                        RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.type_face_round_view);
                        if (roundedLayout != null) {
                            i2 = R.id.type_face_view;
                            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.type_face_view);
                            if (readerThemeLinearLayout != null) {
                                return new q6(relativeLayout, readerThemeTextView, listView, relativeLayout, readerThemeImageView, readerThemeItemTextView, roundedLayout, readerThemeLinearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static q6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static q6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_typeface, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12576a;
    }
}

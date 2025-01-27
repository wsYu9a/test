package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;

/* loaded from: classes3.dex */
public final class TtsPositionControlViewBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ReaderThemeImageView ttsPositionBack;

    @NonNull
    public final ReaderThemeLinearLayout ttsReadCurrentPage;

    private TtsPositionControlViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout) {
        this.rootView = relativeLayout;
        this.ttsPositionBack = readerThemeImageView;
        this.ttsReadCurrentPage = readerThemeLinearLayout;
    }

    @NonNull
    public static TtsPositionControlViewBinding bind(@NonNull View view) {
        int i10 = R.id.tts_position_back;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.tts_read_current_page;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (readerThemeLinearLayout != null) {
                return new TtsPositionControlViewBinding((RelativeLayout) view, readerThemeImageView, readerThemeLinearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static TtsPositionControlViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TtsPositionControlViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.tts_position_control_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}

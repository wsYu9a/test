package com.martian.mibook.fragment.dialog;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import ba.l;
import com.gyf.immersionbar.d;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.data.TypoItem;
import com.martian.mibook.databinding.ReaderPostCommentFragmentBinding;
import com.martian.mibook.fragment.dialog.TypoFeedbackFragment;
import l9.i0;
import l9.t0;

/* loaded from: classes3.dex */
public class TypoFeedbackFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: i */
    public static final String f13782i = "TAG_TYPO_FEEDBACK";

    /* renamed from: j */
    public static final String f13783j = "INTENT_TYPO_ITEM";

    /* renamed from: f */
    public ReaderPostCommentFragmentBinding f13784f;

    /* renamed from: g */
    public TypoItem f13785g;

    /* renamed from: h */
    public boolean f13786h;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            TypoFeedbackFragment.this.f13784f.postCommentButton.setAlpha(!l.q(String.valueOf(charSequence)) ? 1.0f : 0.4f);
        }
    }

    public class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b */
        public boolean f13789b;

        /* renamed from: c */
        public final /* synthetic */ View f13790c;

        public c(View view) {
            this.f13790c = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            Rect rect = new Rect();
            this.f13790c.getWindowVisibleDisplayFrame(rect);
            int height = this.f13790c.getHeight();
            int i10 = height - rect.bottom;
            double d10 = height;
            boolean z10 = ((double) i10) > 0.15d * d10 || ((double) (this.f13790c.getRootView().getHeight() - height)) > d10 * 0.25d;
            if (z10 != this.f13789b) {
                if (!z10) {
                    TypoFeedbackFragment.this.dismiss();
                } else if (i10 > 0) {
                    this.f13790c.setPadding(0, 0, 0, i10);
                }
            }
            this.f13789b = z10;
            return true;
        }
    }

    public static /* synthetic */ void H(DialogFragment dialogFragment) {
        boolean s10 = MiConfigSingleton.b2().h2().s();
        d.y3(dialogFragment).T2(!s10).G1(!s10).B1(MiConfigSingleton.b2().h2().k().getNavigationBarBackgroundColor(false), 0.0f).a1();
    }

    public static void K(FragmentActivity fragmentActivity, TypoItem typoItem) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.reader_post_comment_fragment, (ViewGroup) null)).k0(true).j0(true).E0(false).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEdit).s0(new MartianBottomSheetDialogFragment.b() { // from class: eb.k0
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                TypoFeedbackFragment.H(dialogFragment);
            }
        });
        TypoFeedbackFragment typoFeedbackFragment = new TypoFeedbackFragment();
        Bundle bundle = new Bundle();
        bundle.putString(f13783j, GsonUtils.b().toJson(typoItem));
        typoFeedbackFragment.setArguments(bundle);
        a10.b0(fragmentActivity, typoFeedbackFragment, f13782i);
    }

    private void M() {
        if (this.f13785g == null) {
            return;
        }
        this.f13784f.bdEditComment.requestFocus();
        i0.L0(getActivity(), this.f13784f.bdEditComment);
        this.f13784f.bdEditComment.addTextChangedListener(new a());
        this.f13784f.bdEditComment.setHint(getString(R.string.wrong_words_feedback_hint));
        this.f13784f.postCommentButton.setText(getString(R.string.submit));
        this.f13784f.postCommentParagraphView.setVisibility(0);
        this.f13784f.postCommentParagraphLine.setVisibility(8);
        this.f13784f.postCommentParagraph.setText(ConfigSingleton.D().s("「" + this.f13785g.getTypo() + "」为错别字，正确的字是："));
        this.f13784f.postCommentButton.setOnClickListener(new View.OnClickListener() { // from class: eb.j0
            public /* synthetic */ j0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TypoFeedbackFragment.this.I(view);
            }
        });
        View view = getView();
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new c(view));
    }

    public final /* synthetic */ void I(View view) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.f13784f.bdEditComment.getText() != null && l.q(this.f13784f.bdEditComment.getText().toString())) {
            this.f13784f.postCommentButton.setAlpha(0.4f);
            t0.b(activity, "反馈内容不能为空");
        } else if (this.f13786h) {
            t0.b(activity, "反馈中，请稍候");
        } else if (MiConfigSingleton.b2().G1().f(activity)) {
            this.f13786h = true;
            this.f13785g.setCorrectWords(this.f13784f.bdEditComment.getText().toString());
            ReadingInstance.z().q(getActivity(), "错字反馈", GsonUtils.b().toJson(this.f13785g), 1, JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_SPLASH9_16_SINGLE_VIDEO, true, new b());
        }
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(f13783j);
            if (!l.q(string)) {
                this.f13785g = (TypoItem) GsonUtils.b().fromJson(string, TypoItem.class);
            }
        }
        if (this.f13785g == null) {
            dismiss();
        }
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        View m10 = m();
        if (m10 != null) {
            this.f13784f = ReaderPostCommentFragmentBinding.bind(m10);
            M();
        }
    }

    public class b implements ReadingInstance.c {
        public b() {
        }

        @Override // com.martian.mibook.application.ReadingInstance.c
        public void success() {
            TypoFeedbackFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.ReadingInstance.c
        public void onResultError(x8.c cVar) {
        }
    }
}

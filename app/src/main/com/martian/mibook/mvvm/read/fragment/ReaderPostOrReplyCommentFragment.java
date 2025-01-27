package com.martian.mibook.mvvm.read.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import ba.l;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.CommentCount;
import com.martian.mibook.databinding.ReaderPostCommentFragmentBinding;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment;
import l9.i0;
import l9.t0;

/* loaded from: classes3.dex */
public class ReaderPostOrReplyCommentFragment extends MartianBottomSheetDialogFragment {
    public static final int A = 2;
    public static final String B = "INTENT_COMMENT_COUNT";
    public static final String C = "INTENT_SOURCE_NAME";
    public static final String D = "INTENT_SOURCE_ID";
    public static final String E = "INTENT_COMMENT_CID";
    public static final String F = "INTENT_SOURCE_NICKNAME";
    public static final String G = "INTENT_COMMENT_RID";

    /* renamed from: t */
    public static final String f14677t = "TAG_POST_COMMENT";

    /* renamed from: u */
    public static final String f14678u = "INTENT_COMMENT_STRING";

    /* renamed from: v */
    public static final String f14679v = "INTENT_QUOTE_CONTENT_STRING";

    /* renamed from: w */
    public static final String f14680w = "INTENT_PARAGRAPH_CONTENT";

    /* renamed from: x */
    public static final String f14681x = "INTENT_SELECT_PARAGRAPH_TEXT";

    /* renamed from: y */
    public static final String f14682y = "INTENT_COMMENT_TYPE";

    /* renamed from: z */
    public static final int f14683z = 1;

    /* renamed from: f */
    public ReaderPostCommentFragmentBinding f14684f;

    /* renamed from: g */
    public e f14685g;

    /* renamed from: h */
    public String f14686h;

    /* renamed from: i */
    public int f14687i;

    /* renamed from: j */
    public boolean f14688j = false;

    /* renamed from: k */
    public CommentCount f14689k;

    /* renamed from: l */
    public String f14690l;

    /* renamed from: m */
    public String f14691m;

    /* renamed from: n */
    public String f14692n;

    /* renamed from: o */
    public String f14693o;

    /* renamed from: p */
    public Integer f14694p;

    /* renamed from: q */
    public Integer f14695q;

    /* renamed from: r */
    public String f14696r;

    /* renamed from: s */
    public String f14697s;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        @SuppressLint({"SetTextI18n"})
        public void afterTextChanged(Editable editable) {
            ReaderPostOrReplyCommentFragment.this.f14684f.tvTextCount.setText(editable.length() + "/300");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ReaderPostOrReplyCommentFragment.this.f14684f.postCommentButton.setAlpha(!l.q(String.valueOf(charSequence)) ? 1.0f : 0.4f);
            if (ReaderPostOrReplyCommentFragment.this.f14685g != null) {
                ReaderPostOrReplyCommentFragment.this.f14685g.c(ReaderPostOrReplyCommentFragment.this.O(), String.valueOf(charSequence));
            }
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b */
        public boolean f14699b;

        /* renamed from: c */
        public final /* synthetic */ View f14700c;

        public b(View view) {
            this.f14700c = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            Rect rect = new Rect();
            this.f14700c.getWindowVisibleDisplayFrame(rect);
            int height = this.f14700c.getHeight();
            int i10 = height - rect.bottom;
            double d10 = height;
            boolean z10 = ((double) i10) > 0.15d * d10 || ((double) (this.f14700c.getRootView().getHeight() - height)) > d10 * 0.25d;
            if (z10 != this.f14699b) {
                if (!z10) {
                    ReaderPostOrReplyCommentFragment.this.dismiss();
                } else if (i10 > 0) {
                    this.f14700c.setPadding(0, 0, 0, i10);
                }
            }
            this.f14699b = z10;
            return true;
        }
    }

    public class c implements MiBookManager.e0 {

        /* renamed from: a */
        public final /* synthetic */ Activity f14702a;

        public c(Activity activity) {
            this.f14702a = activity;
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        public void a(x8.c cVar) {
            ReaderPostOrReplyCommentFragment.this.f14688j = false;
            Activity activity = this.f14702a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ReaderPostOrReplyCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        public void b(Comment comment) {
            ReaderPostOrReplyCommentFragment.this.f14688j = false;
            Activity activity = this.f14702a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ac.a.L(this.f14702a, "发表章评");
            if (ReaderPostOrReplyCommentFragment.this.f14685g != null) {
                ReaderPostOrReplyCommentFragment.this.f14685g.b(comment);
                ReaderPostOrReplyCommentFragment.this.f14685g.c(ReaderPostOrReplyCommentFragment.this.f14689k.getChapterId(), "");
            }
            ReaderPostOrReplyCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean z10) {
            Activity activity = this.f14702a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (!z10) {
                ReaderPostOrReplyCommentFragment.this.f14684f.postCommentButton.setText(this.f14702a.getString(R.string.post));
                return;
            }
            ReaderPostOrReplyCommentFragment.this.f14684f.postCommentButton.setText(this.f14702a.getString(R.string.post) + "中...");
        }
    }

    public class d implements MiBookManager.g0 {

        /* renamed from: a */
        public final /* synthetic */ Activity f14704a;

        public d(Activity activity) {
            this.f14704a = activity;
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void a(x8.c cVar) {
            ReaderPostOrReplyCommentFragment.this.f14688j = false;
            Activity activity = this.f14704a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ReaderPostOrReplyCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void b(CommentReply commentReply) {
            ReaderPostOrReplyCommentFragment.this.f14688j = false;
            Activity activity = this.f14704a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ac.a.L(this.f14704a, "发表章评");
            if (ReaderPostOrReplyCommentFragment.this.f14685g != null) {
                ReaderPostOrReplyCommentFragment.this.f14685g.a(commentReply);
                ReaderPostOrReplyCommentFragment.this.f14685g.c(ReaderPostOrReplyCommentFragment.this.O(), "");
            }
            ReaderPostOrReplyCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean z10) {
            Activity activity = this.f14704a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (!z10) {
                ReaderPostOrReplyCommentFragment.this.f14684f.postCommentButton.setText(this.f14704a.getString(R.string.post));
                return;
            }
            ReaderPostOrReplyCommentFragment.this.f14684f.postCommentButton.setText(this.f14704a.getString(R.string.post) + "中...");
        }
    }

    public interface e {
        void a(CommentReply commentReply);

        void b(Comment comment);

        void c(String str, String str2);
    }

    public String O() {
        if (this.f14687i == 1) {
            return this.f14689k.getChapterId();
        }
        Integer num = this.f14695q;
        if (num != null && num.intValue() != 0) {
            return this.f14695q.toString();
        }
        Integer num2 = this.f14694p;
        return (num2 == null || num2.intValue() == 0) ? "" : this.f14694p.toString();
    }

    private boolean P() {
        int i10 = this.f14687i;
        if (i10 == 0) {
            return true;
        }
        if (i10 == 1 && this.f14689k == null) {
            return true;
        }
        return i10 == 2 && this.f14694p == null;
    }

    public static /* synthetic */ void Q(DialogFragment dialogFragment) {
        boolean s10 = MiConfigSingleton.b2().h2().s();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!s10).G1(!s10).B1(MiConfigSingleton.b2().h2().k().getNavigationBarBackgroundColor(false), 0.0f).a1();
    }

    public static /* synthetic */ void R(DialogFragment dialogFragment) {
        boolean s10 = MiConfigSingleton.b2().h2().s();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!s10).G1(!s10).B1(MiConfigSingleton.b2().h2().k().getNavigationBarBackgroundColor(false), 0.0f).a1();
    }

    public /* synthetic */ void S(View view) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.f14684f.bdEditComment.getText() != null && l.q(this.f14684f.bdEditComment.getText().toString())) {
            this.f14684f.postCommentButton.setAlpha(0.4f);
            t0.b(activity, "评论内容不能为空");
            return;
        }
        if (this.f14688j) {
            t0.b(activity, "评论发表中，请稍候");
            return;
        }
        if (MiConfigSingleton.b2().G1().f(activity)) {
            this.f14688j = true;
            String obj = this.f14684f.bdEditComment.getText().toString();
            if (this.f14687i == 1) {
                T(activity, obj);
            } else {
                U(activity, obj);
            }
        }
    }

    private void T(Activity activity, String str) {
        MiConfigSingleton.b2().M1().r2(activity, this.f14690l, this.f14691m, this.f14689k.getChapterId(), "", str, 0, this.f14689k.getType(), this.f14689k.getParagraphIdx(), this.f14693o, new c(activity));
    }

    private void U(Activity activity, String str) {
        MiConfigSingleton.b2().M1().u2(activity, this.f14694p, this.f14695q, str, new d(activity));
    }

    public static void X(FragmentActivity fragmentActivity, CommentCount commentCount, String str, String str2, String str3, String str4, String str5, boolean z10, e eVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.reader_post_comment_fragment, (ViewGroup) null)).k0(true).j0(true).E0(z10).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEditFullScreen).q0(ConfigSingleton.i(16.0f)).p0(ConfigSingleton.i(4.0f)).s0(new MartianBottomSheetDialogFragment.b() { // from class: ed.b0
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                ReaderPostOrReplyCommentFragment.Q(dialogFragment);
            }
        });
        ReaderPostOrReplyCommentFragment readerPostOrReplyCommentFragment = new ReaderPostOrReplyCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_COMMENT_COUNT", GsonUtils.b().toJson(commentCount));
        bundle.putString("INTENT_COMMENT_STRING", str3);
        bundle.putString("INTENT_SOURCE_NAME", str);
        bundle.putString("INTENT_SOURCE_ID", str2);
        bundle.putString("INTENT_PARAGRAPH_CONTENT", str4);
        bundle.putString("INTENT_SELECT_PARAGRAPH_TEXT", str5);
        bundle.putInt("INTENT_COMMENT_TYPE", 1);
        readerPostOrReplyCommentFragment.setArguments(bundle);
        readerPostOrReplyCommentFragment.W(eVar);
        a10.b0(fragmentActivity, readerPostOrReplyCommentFragment, "TAG_POST_COMMENT");
    }

    public static void Y(FragmentActivity fragmentActivity, Integer num, Integer num2, String str, String str2, String str3, e eVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.reader_post_comment_fragment, (ViewGroup) null)).k0(true).j0(true).E0(true).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEditFullScreen).q0(ConfigSingleton.i(16.0f)).p0(ConfigSingleton.i(4.0f)).s0(new MartianBottomSheetDialogFragment.b() { // from class: ed.c0
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                ReaderPostOrReplyCommentFragment.R(dialogFragment);
            }
        });
        ReaderPostOrReplyCommentFragment readerPostOrReplyCommentFragment = new ReaderPostOrReplyCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("INTENT_COMMENT_CID", num.intValue());
        if (num2 != null) {
            bundle.putInt("INTENT_COMMENT_RID", num2.intValue());
        }
        bundle.putString("INTENT_QUOTE_CONTENT_STRING", str2);
        bundle.putString("INTENT_COMMENT_STRING", str3);
        bundle.putString("INTENT_SOURCE_NICKNAME", str);
        bundle.putInt("INTENT_COMMENT_TYPE", 2);
        readerPostOrReplyCommentFragment.setArguments(bundle);
        readerPostOrReplyCommentFragment.W(eVar);
        a10.b0(fragmentActivity, readerPostOrReplyCommentFragment, "TAG_POST_COMMENT");
    }

    private void Z() {
        if (P()) {
            return;
        }
        this.f14684f.bdEditComment.requestFocus();
        i0.L0(getActivity(), this.f14684f.bdEditComment);
        this.f14684f.bdEditComment.addTextChangedListener(new a());
        if (!l.q(this.f14686h)) {
            this.f14684f.bdEditComment.setText(this.f14686h);
            this.f14684f.bdEditComment.setSelection(this.f14686h.length());
        }
        CommentCount commentCount = this.f14689k;
        if (commentCount != null && commentCount.isParagraphComment()) {
            this.f14684f.bdEditComment.setHint(ConfigSingleton.D().s("段评千万条，友善第一条"));
        }
        if (!l.q(this.f14692n)) {
            this.f14684f.postCommentParagraphView.setVisibility(0);
            this.f14684f.postCommentParagraph.setText(this.f14692n);
        } else if (TextUtils.isEmpty(this.f14697s)) {
            this.f14684f.postCommentParagraphView.setVisibility(8);
        } else {
            this.f14684f.postCommentParagraphView.setVisibility(0);
            this.f14684f.postCommentParagraph.setText(this.f14697s);
        }
        if (!l.q(this.f14696r)) {
            this.f14684f.bdEditComment.setHint("回复 @" + this.f14696r);
        }
        this.f14684f.postCommentButton.setOnClickListener(new View.OnClickListener() { // from class: ed.d0
            public /* synthetic */ d0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPostOrReplyCommentFragment.this.S(view);
            }
        });
        View view = getView();
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new b(view));
    }

    public void W(e eVar) {
        this.f14685g = eVar;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("INTENT_COMMENT_COUNT");
            if (!l.q(string)) {
                this.f14689k = (CommentCount) GsonUtils.b().fromJson(string, CommentCount.class);
            }
            this.f14687i = arguments.getInt("INTENT_COMMENT_TYPE");
            this.f14686h = arguments.getString("INTENT_COMMENT_STRING");
            this.f14690l = arguments.getString("INTENT_SOURCE_NAME");
            this.f14691m = arguments.getString("INTENT_SOURCE_ID");
            this.f14692n = arguments.getString("INTENT_PARAGRAPH_CONTENT");
            this.f14693o = arguments.getString("INTENT_SELECT_PARAGRAPH_TEXT");
            this.f14694p = Integer.valueOf(arguments.getInt("INTENT_COMMENT_CID"));
            this.f14695q = Integer.valueOf(arguments.getInt("INTENT_COMMENT_RID"));
            this.f14696r = arguments.getString("INTENT_SOURCE_NICKNAME");
            this.f14697s = arguments.getString("INTENT_QUOTE_CONTENT_STRING");
        }
        if (P()) {
            dismiss();
        }
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        View m10 = m();
        if (m10 != null) {
            this.f14684f = ReaderPostCommentFragmentBinding.bind(m10);
            Z();
        }
    }
}

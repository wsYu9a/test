package com.martian.mibook.fragment.dialog;

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
import com.martian.mibook.databinding.PostCommentFragmentBinding;
import com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import l9.i0;
import l9.t0;

/* loaded from: classes3.dex */
public class PostOrReplyCommentFragment extends MartianBottomSheetDialogFragment {
    public static final int A = 2;
    public static final String B = "INTENT_COMMENT_COUNT";
    public static final String C = "INTENT_SOURCE_NAME";
    public static final String D = "INTENT_SOURCE_ID";
    public static final String E = "INTENT_COMMENT_CID";
    public static final String F = "INTENT_SOURCE_NICKNAME";
    public static final String G = "INTENT_COMMENT_RID";

    /* renamed from: t */
    public static final String f13753t = "TAG_POST_COMMENT";

    /* renamed from: u */
    public static final String f13754u = "INTENT_COMMENT_STRING";

    /* renamed from: v */
    public static final String f13755v = "INTENT_QUOTE_CONTENT_STRING";

    /* renamed from: w */
    public static final String f13756w = "INTENT_PARAGRAPH_CONTENT";

    /* renamed from: x */
    public static final String f13757x = "INTENT_SELECT_PARAGRAPH_TEXT";

    /* renamed from: y */
    public static final String f13758y = "INTENT_COMMENT_TYPE";

    /* renamed from: z */
    public static final int f13759z = 1;

    /* renamed from: f */
    public PostCommentFragmentBinding f13760f;

    /* renamed from: g */
    public e f13761g;

    /* renamed from: h */
    public String f13762h;

    /* renamed from: i */
    public int f13763i;

    /* renamed from: j */
    public boolean f13764j = false;

    /* renamed from: k */
    public CommentCount f13765k;

    /* renamed from: l */
    public String f13766l;

    /* renamed from: m */
    public String f13767m;

    /* renamed from: n */
    public String f13768n;

    /* renamed from: o */
    public String f13769o;

    /* renamed from: p */
    public Integer f13770p;

    /* renamed from: q */
    public Integer f13771q;

    /* renamed from: r */
    public String f13772r;

    /* renamed from: s */
    public String f13773s;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PostOrReplyCommentFragment.this.f13760f.tvTextCount.setText(editable.length() + "/300");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            PostOrReplyCommentFragment.this.f13760f.postCommentButton.setAlpha(!l.q(String.valueOf(charSequence)) ? 1.0f : 0.4f);
            if (PostOrReplyCommentFragment.this.f13761g != null) {
                PostOrReplyCommentFragment.this.f13761g.c(PostOrReplyCommentFragment.this.O(), String.valueOf(charSequence));
            }
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b */
        public boolean f13775b;

        /* renamed from: c */
        public final /* synthetic */ View f13776c;

        public b(View view) {
            this.f13776c = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            Rect rect = new Rect();
            this.f13776c.getWindowVisibleDisplayFrame(rect);
            int height = this.f13776c.getHeight();
            int i10 = height - rect.bottom;
            double d10 = height;
            boolean z10 = ((double) i10) > 0.15d * d10 || ((double) (this.f13776c.getRootView().getHeight() - height)) > d10 * 0.25d;
            if (z10 != this.f13775b) {
                if (!z10) {
                    PostOrReplyCommentFragment.this.dismiss();
                } else if (i10 > 0) {
                    this.f13776c.setPadding(0, 0, 0, i10);
                }
            }
            this.f13775b = z10;
            return true;
        }
    }

    public class c implements MiBookManager.e0 {

        /* renamed from: a */
        public final /* synthetic */ Activity f13778a;

        public c(Activity activity) {
            this.f13778a = activity;
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        public void a(x8.c cVar) {
            PostOrReplyCommentFragment.this.f13764j = false;
            Activity activity = this.f13778a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            PostOrReplyCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        public void b(Comment comment) {
            PostOrReplyCommentFragment.this.f13764j = false;
            Activity activity = this.f13778a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ac.a.L(this.f13778a, "发表章评");
            if (PostOrReplyCommentFragment.this.f13761g != null) {
                PostOrReplyCommentFragment.this.f13761g.b(comment);
                PostOrReplyCommentFragment.this.f13761g.c(PostOrReplyCommentFragment.this.f13765k.getChapterId(), "");
            }
            PostOrReplyCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean z10) {
            Activity activity = this.f13778a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (!z10) {
                PostOrReplyCommentFragment.this.f13760f.postCommentButton.setText(this.f13778a.getString(R.string.post));
                return;
            }
            PostOrReplyCommentFragment.this.f13760f.postCommentButton.setText(this.f13778a.getString(R.string.post) + "中...");
        }
    }

    public class d implements MiBookManager.g0 {

        /* renamed from: a */
        public final /* synthetic */ Activity f13780a;

        public d(Activity activity) {
            this.f13780a = activity;
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void a(x8.c cVar) {
            PostOrReplyCommentFragment.this.f13764j = false;
            Activity activity = this.f13780a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            PostOrReplyCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void b(CommentReply commentReply) {
            PostOrReplyCommentFragment.this.f13764j = false;
            Activity activity = this.f13780a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ac.a.L(this.f13780a, "发表章评");
            if (PostOrReplyCommentFragment.this.f13761g != null) {
                PostOrReplyCommentFragment.this.f13761g.a(commentReply);
                PostOrReplyCommentFragment.this.f13761g.c(PostOrReplyCommentFragment.this.O(), "");
            }
            PostOrReplyCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean z10) {
            Activity activity = this.f13780a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (!z10) {
                PostOrReplyCommentFragment.this.f13760f.postCommentButton.setText(this.f13780a.getString(R.string.post));
                return;
            }
            PostOrReplyCommentFragment.this.f13760f.postCommentButton.setText(this.f13780a.getString(R.string.post) + "中...");
        }
    }

    public interface e {
        void a(CommentReply commentReply);

        void b(Comment comment);

        void c(String str, String str2);
    }

    private boolean P() {
        int i10 = this.f13763i;
        if (i10 == 0) {
            return true;
        }
        if (i10 == 1 && this.f13765k == null) {
            return true;
        }
        return i10 == 2 && this.f13770p == null;
    }

    public static /* synthetic */ void Q(DialogFragment dialogFragment) {
        boolean A0 = MiConfigSingleton.b2().A0();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public static /* synthetic */ void R(DialogFragment dialogFragment) {
        boolean A0 = MiConfigSingleton.b2().A0();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public /* synthetic */ void S(View view) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.f13760f.bdEditComment.getText() != null && l.q(this.f13760f.bdEditComment.getText().toString())) {
            this.f13760f.postCommentButton.setAlpha(0.4f);
            t0.b(activity, "评论内容不能为空");
            return;
        }
        if (this.f13764j) {
            t0.b(activity, "评论发表中，请稍候");
            return;
        }
        if (MiConfigSingleton.b2().G1().f(activity)) {
            this.f13764j = true;
            String obj = this.f13760f.bdEditComment.getText().toString();
            if (this.f13763i == 1) {
                T(activity, obj);
            } else {
                U(activity, obj);
            }
        }
    }

    private void T(Activity activity, String str) {
        MiConfigSingleton.b2().M1().r2(activity, this.f13766l, this.f13767m, this.f13765k.getChapterId(), "", str, 0, this.f13765k.getType(), this.f13765k.getParagraphIdx(), this.f13769o, new c(activity));
    }

    private void U(Activity activity, String str) {
        MiConfigSingleton.b2().M1().u2(activity, this.f13770p, this.f13771q, str, new d(activity));
    }

    public static void X(FragmentActivity fragmentActivity, CommentCount commentCount, String str, String str2, String str3, String str4, String str5, boolean z10, e eVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.post_comment_fragment, (ViewGroup) null)).k0(true).j0(true).E0(z10).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEdit).q0(ConfigSingleton.i(16.0f)).p0(ConfigSingleton.i(4.0f)).s0(new MartianBottomSheetDialogFragment.b() { // from class: eb.h0
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                PostOrReplyCommentFragment.Q(dialogFragment);
            }
        });
        PostOrReplyCommentFragment postOrReplyCommentFragment = new PostOrReplyCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_COMMENT_COUNT", GsonUtils.b().toJson(commentCount));
        bundle.putString("INTENT_COMMENT_STRING", str3);
        bundle.putString("INTENT_SOURCE_NAME", str);
        bundle.putString("INTENT_SOURCE_ID", str2);
        bundle.putString("INTENT_PARAGRAPH_CONTENT", str4);
        bundle.putString("INTENT_SELECT_PARAGRAPH_TEXT", str5);
        bundle.putInt("INTENT_COMMENT_TYPE", 1);
        postOrReplyCommentFragment.setArguments(bundle);
        postOrReplyCommentFragment.W(eVar);
        a10.b0(fragmentActivity, postOrReplyCommentFragment, "TAG_POST_COMMENT");
    }

    public static void Y(FragmentActivity fragmentActivity, Integer num, Integer num2, String str, String str2, String str3, e eVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.post_comment_fragment, (ViewGroup) null)).k0(true).j0(true).E0(true).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEdit).q0(ConfigSingleton.i(16.0f)).p0(ConfigSingleton.i(4.0f)).s0(new MartianBottomSheetDialogFragment.b() { // from class: eb.i0
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                PostOrReplyCommentFragment.R(dialogFragment);
            }
        });
        PostOrReplyCommentFragment postOrReplyCommentFragment = new PostOrReplyCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("INTENT_COMMENT_CID", num.intValue());
        if (num2 != null) {
            bundle.putInt("INTENT_COMMENT_RID", num2.intValue());
        }
        bundle.putString("INTENT_QUOTE_CONTENT_STRING", str2);
        bundle.putString("INTENT_COMMENT_STRING", str3);
        bundle.putString("INTENT_SOURCE_NICKNAME", str);
        bundle.putInt("INTENT_COMMENT_TYPE", 2);
        postOrReplyCommentFragment.setArguments(bundle);
        postOrReplyCommentFragment.W(eVar);
        a10.b0(fragmentActivity, postOrReplyCommentFragment, "TAG_POST_COMMENT");
    }

    private void Z() {
        if (P()) {
            return;
        }
        this.f13760f.bdEditComment.requestFocus();
        i0.L0(getActivity(), this.f13760f.bdEditComment);
        this.f13760f.bdEditComment.addTextChangedListener(new a());
        if (!l.q(this.f13762h)) {
            this.f13760f.bdEditComment.setText(this.f13762h);
            this.f13760f.bdEditComment.setSelection(this.f13762h.length());
        }
        CommentCount commentCount = this.f13765k;
        if (commentCount != null && commentCount.isParagraphComment()) {
            this.f13760f.bdEditComment.setHint(ConfigSingleton.D().s("段评千万条，友善第一条"));
        }
        if (!l.q(this.f13768n)) {
            this.f13760f.postCommentParagraphView.setVisibility(0);
            this.f13760f.postCommentParagraph.setText(this.f13768n);
        } else if (TextUtils.isEmpty(this.f13773s)) {
            this.f13760f.postCommentParagraphView.setVisibility(8);
        } else {
            this.f13760f.postCommentParagraphView.setVisibility(0);
            this.f13760f.postCommentParagraph.setText(this.f13773s);
        }
        if (!l.q(this.f13772r)) {
            this.f13760f.bdEditComment.setHint("回复 @" + this.f13772r);
        }
        this.f13760f.postCommentButton.setOnClickListener(new View.OnClickListener() { // from class: eb.g0
            public /* synthetic */ g0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostOrReplyCommentFragment.this.S(view);
            }
        });
        View view = getView();
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new b(view));
    }

    public final String O() {
        if (this.f13763i == 1) {
            return this.f13765k.getChapterId();
        }
        Integer num = this.f13771q;
        if (num != null && num.intValue() != 0) {
            return this.f13771q.toString();
        }
        Integer num2 = this.f13770p;
        return (num2 == null || num2.intValue() == 0) ? "" : this.f13770p.toString();
    }

    public void W(e eVar) {
        this.f13761g = eVar;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("INTENT_COMMENT_COUNT");
            if (!l.q(string)) {
                this.f13765k = (CommentCount) GsonUtils.b().fromJson(string, CommentCount.class);
            }
            this.f13763i = arguments.getInt("INTENT_COMMENT_TYPE");
            this.f13762h = arguments.getString("INTENT_COMMENT_STRING");
            this.f13766l = arguments.getString("INTENT_SOURCE_NAME");
            this.f13767m = arguments.getString("INTENT_SOURCE_ID");
            this.f13768n = arguments.getString("INTENT_PARAGRAPH_CONTENT");
            this.f13769o = arguments.getString("INTENT_SELECT_PARAGRAPH_TEXT");
            this.f13770p = Integer.valueOf(arguments.getInt("INTENT_COMMENT_CID"));
            this.f13771q = Integer.valueOf(arguments.getInt("INTENT_COMMENT_RID"));
            this.f13772r = arguments.getString("INTENT_SOURCE_NICKNAME");
            this.f13773s = arguments.getString("INTENT_QUOTE_CONTENT_STRING");
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
            this.f13760f = PostCommentFragmentBinding.bind(m10);
            Z();
        }
    }
}

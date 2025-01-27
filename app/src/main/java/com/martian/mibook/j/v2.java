package com.martian.mibook.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.dialog.g;
import com.martian.libcomm.utils.e;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.n0;
import com.martian.libsupport.permission.TipInfo;
import com.martian.libugrowth.data.UpgradeInfo;
import com.martian.libugrowth.request.UpgradeDownloadLinkParams;
import com.martian.mibook.activity.BonusDetailActivity;
import com.martian.mibook.activity.TeenagerGuideActivity;
import com.martian.mibook.activity.account.IncomeActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.data.book.CommentReply;
import com.martian.mibook.e.c4;
import com.martian.mibook.e.e4;
import com.martian.mibook.e.h4;
import com.martian.mibook.e.i7;
import com.martian.mibook.e.o4;
import com.martian.mibook.e.q4;
import com.martian.mibook.e.u4;
import com.martian.mibook.e.v4;
import com.martian.mibook.e.x4;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.request.OfflineLinkParams;
import com.martian.mibook.lib.account.request.auth.FinishExtraBonusParams;
import com.martian.mibook.lib.account.request.auth.StartExtraBonusParams;
import com.martian.mibook.lib.account.response.CheckinResult;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.ExtraBonus;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.mibook.lib.model.data.BookCreative;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.ui.AutoScrollView;
import com.martian.mibook.ui.o.i4;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.io.File;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: classes4.dex */
public class v2 {

    static class a implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ u4 f13589a;

        /* renamed from: b */
        final /* synthetic */ b0 f13590b;

        /* renamed from: c */
        final /* synthetic */ String f13591c;

        a(final u4 val$chapterId, final b0 val$listener, final String val$postCommentBinding) {
            this.f13589a = val$chapterId;
            this.f13590b = val$listener;
            this.f13591c = val$postCommentBinding;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            ReaderThemeItemTextView readerThemeItemTextView = this.f13589a.f12790d;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) s);
            sb.append("");
            readerThemeItemTextView.setAlpha(!com.martian.libsupport.k.p(sb.toString()) ? 1.0f : 0.4f);
            b0 b0Var = this.f13590b;
            if (b0Var != null) {
                b0Var.a(this.f13591c, ((Object) s) + "");
            }
        }
    }

    public interface a0 {
        void a();
    }

    static class b implements View.OnClickListener {

        /* renamed from: a */
        private boolean f13592a = false;

        /* renamed from: b */
        final /* synthetic */ u4 f13593b;

        /* renamed from: c */
        final /* synthetic */ com.martian.libmars.activity.j1 f13594c;

        /* renamed from: d */
        final /* synthetic */ PopupWindow f13595d;

        /* renamed from: e */
        final /* synthetic */ String f13596e;

        /* renamed from: f */
        final /* synthetic */ String f13597f;

        /* renamed from: g */
        final /* synthetic */ String f13598g;

        /* renamed from: h */
        final /* synthetic */ String f13599h;

        /* renamed from: i */
        final /* synthetic */ b0 f13600i;

        class a implements MiBookManager.f0 {
            a() {
            }

            @Override // com.martian.mibook.application.MiBookManager.f0
            public void a(b.d.c.b.c errorResult) {
                com.martian.libmars.utils.w0.a(b.this.f13594c, errorResult.d());
                PopupWindow popupWindow = b.this.f13595d;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }

            @Override // com.martian.mibook.application.MiBookManager.f0
            public void b(Comment comment) {
                com.martian.libmars.utils.w0.a(b.this.f13594c, "评论成功！");
                com.martian.mibook.lib.model.g.b.V(b.this.f13594c, "发表章评");
                b0 b0Var = b.this.f13600i;
                if (b0Var != null) {
                    b0Var.b(comment);
                    b bVar = b.this;
                    bVar.f13600i.a(bVar.f13598g, "");
                }
                PopupWindow popupWindow = b.this.f13595d;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }

            @Override // com.martian.mibook.application.MiBookManager.f0
            @SuppressLint({"SetTextI18n"})
            public void onLoading(boolean show) {
                if (!show) {
                    b bVar = b.this;
                    bVar.f13593b.f12790d.setText(bVar.f13594c.getString(R.string.post));
                    return;
                }
                b.this.f13593b.f12790d.setText(b.this.f13594c.getString(R.string.post) + "中...");
            }
        }

        b(final u4 val$listener, final com.martian.libmars.activity.j1 val$chapterName, final PopupWindow val$chapterId, final String val$sourceId, final String val$sourceName, final String val$popupWindow, final String val$activity, final b0 val$postCommentBinding) {
            this.f13593b = val$listener;
            this.f13594c = val$chapterName;
            this.f13595d = val$chapterId;
            this.f13596e = val$sourceId;
            this.f13597f = val$sourceName;
            this.f13598g = val$popupWindow;
            this.f13599h = val$activity;
            this.f13600i = val$postCommentBinding;
        }

        static /* synthetic */ void b(final PopupWindow popupWindow) {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f13593b.f12788b.getText() != null && com.martian.libsupport.k.p(this.f13593b.f12788b.getText().toString())) {
                this.f13593b.f12790d.setAlpha(0.4f);
                com.martian.libmars.utils.w0.a(this.f13594c, "评论内容不能为空");
                return;
            }
            if (this.f13592a) {
                com.martian.libmars.utils.w0.a(this.f13594c, "评论发表中，请稍候");
                return;
            }
            if (MiConfigSingleton.V3().l6()) {
                this.f13592a = true;
                MiConfigSingleton.V3().l3().W2(this.f13594c, this.f13596e, this.f13597f, this.f13598g, this.f13599h, this.f13593b.f12788b.getText().toString(), 0, new a());
            } else {
                final com.martian.libmars.activity.j1 j1Var = this.f13594c;
                k0.l lVar = new k0.l() { // from class: com.martian.mibook.j.n
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        com.martian.mibook.lib.account.e.d.b(com.martian.libmars.activity.j1.this, 200, true);
                    }
                };
                final PopupWindow popupWindow = this.f13595d;
                com.martian.libmars.utils.k0.Q(j1Var, "绑定微信", "根据相关法律法规，发言评论需要先绑定微信", "暂不绑定", "立即绑定", true, lVar, new k0.j() { // from class: com.martian.mibook.j.o
                    @Override // com.martian.libmars.utils.k0.j
                    public final void a() {
                        v2.b.b(popupWindow);
                    }
                });
            }
        }
    }

    public interface b0 {
        void a(String tag, String comment);

        void b(Comment comment);
    }

    static class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        private int f13602a = 0;

        /* renamed from: b */
        final /* synthetic */ com.martian.libmars.activity.j1 f13603b;

        /* renamed from: c */
        final /* synthetic */ PopupWindow f13604c;

        /* renamed from: d */
        final /* synthetic */ u4 f13605d;

        c(final com.martian.libmars.activity.j1 val$postCommentBinding, final PopupWindow val$popupWindow, final u4 val$activity) {
            this.f13603b = val$postCommentBinding;
            this.f13604c = val$popupWindow;
            this.f13605d = val$activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f13603b.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = this.f13603b.getWindow().getDecorView().getRootView().getHeight() - rect.bottom;
            if (height > 0 || this.f13602a <= 0) {
                this.f13602a = height;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13605d.f12789c.getLayoutParams();
                layoutParams.height = height;
                this.f13605d.f12789c.setLayoutParams(layoutParams);
                return;
            }
            PopupWindow popupWindow = this.f13604c;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
    }

    public interface c0 {
        void a(String tag, String comment);

        void b(CommentReply comment);
    }

    static class d implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ u4 f13606a;

        /* renamed from: b */
        final /* synthetic */ c0 f13607b;

        /* renamed from: c */
        final /* synthetic */ Integer f13608c;

        d(final u4 val$cid, final c0 val$listener, final Integer val$postCommentBinding) {
            this.f13606a = val$cid;
            this.f13607b = val$listener;
            this.f13608c = val$postCommentBinding;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String str;
            ReaderThemeItemTextView readerThemeItemTextView = this.f13606a.f12790d;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) s);
            sb.append("");
            readerThemeItemTextView.setAlpha(!com.martian.libsupport.k.p(sb.toString()) ? 1.0f : 0.4f);
            c0 c0Var = this.f13607b;
            if (c0Var != null) {
                if (this.f13608c == null) {
                    str = "";
                } else {
                    str = this.f13608c + "";
                }
                c0Var.a(str, ((Object) s) + "");
            }
        }
    }

    public interface d0 {
        void a(int which);
    }

    static class e implements View.OnClickListener {

        /* renamed from: a */
        private boolean f13609a = false;

        /* renamed from: b */
        final /* synthetic */ u4 f13610b;

        /* renamed from: c */
        final /* synthetic */ com.martian.libmars.activity.j1 f13611c;

        /* renamed from: d */
        final /* synthetic */ PopupWindow f13612d;

        /* renamed from: e */
        final /* synthetic */ Integer f13613e;

        /* renamed from: f */
        final /* synthetic */ c0 f13614f;

        class a implements MiBookManager.i0 {
            a() {
            }

            @Override // com.martian.mibook.application.MiBookManager.i0
            public void a(b.d.c.b.c errorResult) {
                com.martian.libmars.utils.w0.a(e.this.f13611c, errorResult.d());
                PopupWindow popupWindow = e.this.f13612d;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }

            @Override // com.martian.mibook.application.MiBookManager.i0
            public void b(CommentReply commentReply) {
                String str;
                com.martian.libmars.utils.w0.a(e.this.f13611c, "评论成功！");
                com.martian.mibook.lib.model.g.b.V(e.this.f13611c, "发表章评");
                c0 c0Var = e.this.f13614f;
                if (c0Var != null) {
                    c0Var.b(commentReply);
                    e eVar = e.this;
                    c0 c0Var2 = eVar.f13614f;
                    if (eVar.f13613e == null) {
                        str = "";
                    } else {
                        str = e.this.f13613e + "";
                    }
                    c0Var2.a(str, "");
                }
                PopupWindow popupWindow = e.this.f13612d;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }

            @Override // com.martian.mibook.application.MiBookManager.i0
            @SuppressLint({"SetTextI18n"})
            public void onLoading(boolean show) {
                if (!show) {
                    e eVar = e.this;
                    eVar.f13610b.f12790d.setText(eVar.f13611c.getString(R.string.post));
                    return;
                }
                e.this.f13610b.f12790d.setText(e.this.f13611c.getString(R.string.post) + "中...");
            }
        }

        e(final u4 val$listener, final com.martian.libmars.activity.j1 val$cid, final PopupWindow val$popupWindow, final Integer val$activity, final c0 val$postCommentBinding) {
            this.f13610b = val$listener;
            this.f13611c = val$cid;
            this.f13612d = val$popupWindow;
            this.f13613e = val$activity;
            this.f13614f = val$postCommentBinding;
        }

        static /* synthetic */ void b(final PopupWindow popupWindow) {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f13610b.f12788b.getText() != null && com.martian.libsupport.k.p(this.f13610b.f12788b.getText().toString())) {
                this.f13610b.f12790d.setAlpha(0.4f);
                com.martian.libmars.utils.w0.a(this.f13611c, "评论内容不能为空");
                return;
            }
            if (this.f13609a) {
                com.martian.libmars.utils.w0.a(this.f13611c, "评论发表中，请稍候");
                return;
            }
            if (MiConfigSingleton.V3().l6()) {
                this.f13609a = true;
                MiConfigSingleton.V3().l3().Z2(this.f13611c, this.f13613e, null, this.f13610b.f12788b.getText().toString(), new a());
            } else {
                final com.martian.libmars.activity.j1 j1Var = this.f13611c;
                k0.l lVar = new k0.l() { // from class: com.martian.mibook.j.p
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        com.martian.mibook.lib.account.e.d.b(com.martian.libmars.activity.j1.this, 200, true);
                    }
                };
                final PopupWindow popupWindow = this.f13612d;
                com.martian.libmars.utils.k0.Q(j1Var, "绑定微信", "根据相关法律法规，发言评论需要先绑定微信", "暂不绑定", "立即绑定", true, lVar, new k0.j() { // from class: com.martian.mibook.j.q
                    @Override // com.martian.libmars.utils.k0.j
                    public final void a() {
                        v2.e.b(popupWindow);
                    }
                });
            }
        }
    }

    static class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        private int f13616a = 0;

        /* renamed from: b */
        final /* synthetic */ com.martian.libmars.activity.j1 f13617b;

        /* renamed from: c */
        final /* synthetic */ PopupWindow f13618c;

        /* renamed from: d */
        final /* synthetic */ x4 f13619d;

        f(final com.martian.libmars.activity.j1 val$postCommentBinding, final PopupWindow val$popupWindow, final x4 val$activity) {
            this.f13617b = val$postCommentBinding;
            this.f13618c = val$popupWindow;
            this.f13619d = val$activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f13617b.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = this.f13617b.getWindow().getDecorView().getRootView().getHeight() - rect.bottom;
            if (height > 0 || this.f13616a <= 0) {
                this.f13616a = height;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13619d.f12938c.getLayoutParams();
                layoutParams.height = height;
                this.f13619d.f12938c.setLayoutParams(layoutParams);
                return;
            }
            PopupWindow popupWindow = this.f13618c;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
    }

    static class g implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ x4 f13620a;

        /* renamed from: b */
        final /* synthetic */ c0 f13621b;

        /* renamed from: c */
        final /* synthetic */ Integer f13622c;

        g(final x4 val$cid, final c0 val$listener, final Integer val$postCommentBinding) {
            this.f13620a = val$cid;
            this.f13621b = val$listener;
            this.f13622c = val$postCommentBinding;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String str;
            ThemeTextView themeTextView = this.f13620a.f12939d;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) s);
            sb.append("");
            themeTextView.setAlpha(!com.martian.libsupport.k.p(sb.toString()) ? 1.0f : 0.4f);
            c0 c0Var = this.f13621b;
            if (c0Var != null) {
                if (this.f13622c == null) {
                    str = "";
                } else {
                    str = this.f13622c + "";
                }
                c0Var.a(str, ((Object) s) + "");
            }
        }
    }

    static class h implements View.OnClickListener {

        /* renamed from: a */
        private boolean f13623a = false;

        /* renamed from: b */
        final /* synthetic */ x4 f13624b;

        /* renamed from: c */
        final /* synthetic */ com.martian.libmars.activity.j1 f13625c;

        /* renamed from: d */
        final /* synthetic */ PopupWindow f13626d;

        /* renamed from: e */
        final /* synthetic */ Integer f13627e;

        /* renamed from: f */
        final /* synthetic */ c0 f13628f;

        class a implements MiBookManager.i0 {
            a() {
            }

            @Override // com.martian.mibook.application.MiBookManager.i0
            public void a(b.d.c.b.c errorResult) {
                com.martian.libmars.utils.w0.a(h.this.f13625c, errorResult.d());
                PopupWindow popupWindow = h.this.f13626d;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }

            @Override // com.martian.mibook.application.MiBookManager.i0
            public void b(CommentReply commentReply) {
                String str;
                com.martian.libmars.utils.w0.a(h.this.f13625c, "评论成功！");
                com.martian.mibook.lib.model.g.b.V(h.this.f13625c, "发表章评");
                c0 c0Var = h.this.f13628f;
                if (c0Var != null) {
                    c0Var.b(commentReply);
                    h hVar = h.this;
                    c0 c0Var2 = hVar.f13628f;
                    if (hVar.f13627e == null) {
                        str = "";
                    } else {
                        str = h.this.f13627e + "";
                    }
                    c0Var2.a(str, "");
                }
                PopupWindow popupWindow = h.this.f13626d;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }

            @Override // com.martian.mibook.application.MiBookManager.i0
            @SuppressLint({"SetTextI18n"})
            public void onLoading(boolean show) {
                if (!show) {
                    h hVar = h.this;
                    hVar.f13624b.f12939d.setText(hVar.f13625c.getString(R.string.post));
                    return;
                }
                h.this.f13624b.f12939d.setText(h.this.f13625c.getString(R.string.post) + "中...");
            }
        }

        h(final x4 val$listener, final com.martian.libmars.activity.j1 val$cid, final PopupWindow val$popupWindow, final Integer val$activity, final c0 val$postCommentBinding) {
            this.f13624b = val$listener;
            this.f13625c = val$cid;
            this.f13626d = val$popupWindow;
            this.f13627e = val$activity;
            this.f13628f = val$postCommentBinding;
        }

        static /* synthetic */ void b(final PopupWindow popupWindow) {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.martian.libsupport.k.p(this.f13624b.f12937b.getText().toString())) {
                this.f13624b.f12939d.setAlpha(0.4f);
                com.martian.libmars.utils.w0.a(this.f13625c, "评论内容不能为空");
                return;
            }
            if (this.f13623a) {
                com.martian.libmars.utils.w0.a(this.f13625c, "评论发表中，请稍候");
                return;
            }
            if (MiConfigSingleton.V3().l6()) {
                this.f13623a = true;
                MiConfigSingleton.V3().l3().Z2(this.f13625c, this.f13627e, null, this.f13624b.f12937b.getText().toString(), new a());
            } else {
                final com.martian.libmars.activity.j1 j1Var = this.f13625c;
                k0.l lVar = new k0.l() { // from class: com.martian.mibook.j.r
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        com.martian.mibook.lib.account.e.d.b(com.martian.libmars.activity.j1.this, 200, true);
                    }
                };
                final PopupWindow popupWindow = this.f13626d;
                com.martian.libmars.utils.k0.Q(j1Var, "绑定微信", "根据相关法律法规，发言评论需要先绑定微信", "暂不绑定", "立即绑定", true, lVar, new k0.j() { // from class: com.martian.mibook.j.s
                    @Override // com.martian.libmars.utils.k0.j
                    public final void a() {
                        v2.h.b(popupWindow);
                    }
                });
            }
        }
    }

    static class i extends b.d.c.c.g<Void, Void> {

        /* renamed from: a */
        final /* synthetic */ UpgradeInfo f13630a;

        /* renamed from: b */
        final /* synthetic */ com.martian.libmars.activity.j1 f13631b;

        /* renamed from: c */
        final /* synthetic */ i7 f13632c;

        /* renamed from: d */
        final /* synthetic */ AlertDialog f13633d;

        /* renamed from: e */
        final /* synthetic */ String f13634e;

        /* renamed from: f */
        final /* synthetic */ String f13635f;

        i(final UpgradeInfo val$fileName, final com.martian.libmars.activity.j1 val$filePath, final i7 val$alertDialog, final AlertDialog val$upgradeBinding, final String val$activity, final String val$upgradeInfo) {
            this.f13630a = val$fileName;
            this.f13631b = val$filePath;
            this.f13632c = val$alertDialog;
            this.f13633d = val$upgradeBinding;
            this.f13634e = val$activity;
            this.f13635f = val$upgradeInfo;
        }

        @Override // b.d.c.c.g
        /* renamed from: f */
        public Void doInBackground(Void... params) {
            OkHttpClient okHttpClient = new OkHttpClient();
            UpgradeDownloadLinkParams upgradeDownloadLinkParams = new UpgradeDownloadLinkParams();
            upgradeDownloadLinkParams.setId(this.f13630a.getId());
            try {
                v2.m(this.f13631b, this.f13632c, this.f13633d, okHttpClient.newCall(new Request.Builder().url(upgradeDownloadLinkParams.toHttpUrl("UTF8")).build()).execute().request().url().toString(), this.f13634e, this.f13635f);
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // b.d.c.c.g
        /* renamed from: g */
        public void onPostExecute(Void a2) {
            super.onPostExecute(a2);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    static class j implements com.martian.libsupport.permission.f {

        /* renamed from: a */
        final /* synthetic */ com.martian.libmars.activity.j1 f13636a;

        /* renamed from: b */
        final /* synthetic */ i7 f13637b;

        /* renamed from: c */
        final /* synthetic */ String f13638c;

        /* renamed from: d */
        final /* synthetic */ String f13639d;

        /* renamed from: e */
        final /* synthetic */ String f13640e;

        /* renamed from: f */
        final /* synthetic */ AlertDialog f13641f;

        class a implements e.c {

            /* renamed from: a */
            final /* synthetic */ com.martian.libmars.activity.j1 f13642a;

            /* renamed from: b */
            final /* synthetic */ String f13643b;

            /* renamed from: c */
            final /* synthetic */ i7 f13644c;

            /* renamed from: d */
            final /* synthetic */ String f13645d;

            /* renamed from: e */
            final /* synthetic */ AlertDialog f13646e;

            a(final com.martian.libmars.activity.j1 val$alertDialog, final String val$filePath, final i7 val$upgradeBinding, final String val$fileName, final AlertDialog val$activity) {
                this.f13642a = val$alertDialog;
                this.f13643b = val$filePath;
                this.f13644c = val$upgradeBinding;
                this.f13645d = val$fileName;
                this.f13646e = val$activity;
            }

            static /* synthetic */ void d(final i7 upgradeBinding, final com.martian.libmars.activity.j1 activity, final String filePath, final AlertDialog alertDialog) {
                if (upgradeBinding != null) {
                    upgradeBinding.f12145d.setText("安装中...");
                }
                com.martian.apptask.g.g.e(activity, new File(filePath));
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }

            static /* synthetic */ void e(final com.martian.libmars.activity.j1 activity, final b.d.c.b.c errorResult, final AlertDialog alertDialog) {
                com.martian.libmars.utils.w0.a(activity, errorResult.d());
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }

            static /* synthetic */ void f(final int soFarBytes, final int totalBytes, final i7 upgradeBinding, final com.martian.libmars.activity.j1 activity) {
                long j2 = (soFarBytes * 100) / totalBytes;
                if (upgradeBinding != null) {
                    upgradeBinding.f12145d.setText(activity.getString(R.string.download_desc) + j2 + "%");
                }
            }

            @Override // com.martian.libcomm.utils.e.c
            public void a(final b.d.c.b.c errorResult) {
                final com.martian.libmars.activity.j1 j1Var = this.f13642a;
                final AlertDialog alertDialog = this.f13646e;
                j1Var.runOnUiThread(new Runnable() { // from class: com.martian.mibook.j.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        v2.j.a.e(com.martian.libmars.activity.j1.this, errorResult, alertDialog);
                    }
                });
            }

            @Override // com.martian.libcomm.utils.e.c
            public void b(final int soFarBytes, final int totalBytes) {
                final com.martian.libmars.activity.j1 j1Var = this.f13642a;
                final i7 i7Var = this.f13644c;
                j1Var.runOnUiThread(new Runnable() { // from class: com.martian.mibook.j.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        v2.j.a.f(soFarBytes, totalBytes, i7Var, j1Var);
                    }
                });
            }

            @Override // com.martian.libcomm.utils.e.c
            public void c(int totalBytes) {
                final com.martian.libmars.activity.j1 j1Var = this.f13642a;
                final i7 i7Var = this.f13644c;
                final String str = this.f13645d;
                final AlertDialog alertDialog = this.f13646e;
                j1Var.runOnUiThread(new Runnable() { // from class: com.martian.mibook.j.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        v2.j.a.d(i7.this, j1Var, str, alertDialog);
                    }
                });
            }

            @Override // com.martian.libcomm.utils.e.c
            public void onCancel() {
            }

            @Override // com.martian.libcomm.utils.e.c
            public void onStart() {
                com.martian.libmars.utils.w0.a(this.f13642a, "开始下载" + this.f13643b);
            }
        }

        j(final com.martian.libmars.activity.j1 val$alertDialog, final i7 val$fileName, final String val$filePath, final String val$url, final String val$upgradeBinding, final AlertDialog val$activity) {
            this.f13636a = val$alertDialog;
            this.f13637b = val$fileName;
            this.f13638c = val$filePath;
            this.f13639d = val$url;
            this.f13640e = val$upgradeBinding;
            this.f13641f = val$activity;
        }

        /* renamed from: a */
        public /* synthetic */ void b(final i7 upgradeBinding, final String url, final String filePath, final com.martian.libmars.activity.j1 activity, final String fileName, final AlertDialog alertDialog) {
            if (upgradeBinding != null) {
                upgradeBinding.f12145d.setEnabled(false);
            }
            com.martian.libcomm.utils.e.c(url, filePath, new a(activity, fileName, upgradeBinding, filePath, alertDialog));
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            com.martian.libmars.activity.j1 j1Var = this.f13636a;
            com.martian.libmars.utils.w0.a(j1Var, j1Var.getString(R.string.lack_storage_permission));
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            final com.martian.libmars.activity.j1 j1Var = this.f13636a;
            final i7 i7Var = this.f13637b;
            final String str = this.f13638c;
            final String str2 = this.f13639d;
            final String str3 = this.f13640e;
            final AlertDialog alertDialog = this.f13641f;
            j1Var.runOnUiThread(new Runnable() { // from class: com.martian.mibook.j.w
                @Override // java.lang.Runnable
                public final void run() {
                    v2.j.this.b(i7Var, str, str2, j1Var, str3, alertDialog);
                }
            });
        }
    }

    static class k implements n0.c {

        /* renamed from: a */
        final /* synthetic */ com.martian.libmars.activity.j1 f13648a;

        /* renamed from: b */
        final /* synthetic */ TYActivity f13649b;

        /* renamed from: c */
        final /* synthetic */ com.martian.libmars.b.d f13650c;

        k(final com.martian.libmars.activity.j1 val$rxManager, final TYActivity val$tyActivity, final com.martian.libmars.b.d val$activity) {
            this.f13648a = val$rxManager;
            this.f13649b = val$tyActivity;
            this.f13650c = val$activity;
        }

        @Override // com.martian.libmars.utils.n0.c
        public void onError() {
            v2.I0(this.f13648a, this.f13649b, this.f13650c, "首页弹窗", null);
        }

        @Override // com.martian.libmars.utils.n0.c
        public void onSuccess(Drawable resource) {
            v2.I0(this.f13648a, this.f13649b, this.f13650c, "首页弹窗", resource);
        }
    }

    static class l implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        private int f13651a = 0;

        /* renamed from: b */
        final /* synthetic */ com.martian.libmars.activity.j1 f13652b;

        /* renamed from: c */
        final /* synthetic */ v4 f13653c;

        l(final com.martian.libmars.activity.j1 val$postCommentBinding, final v4 val$activity) {
            this.f13652b = val$postCommentBinding;
            this.f13653c = val$activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f13652b.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = this.f13652b.getWindow().getDecorView().getRootView().getHeight() - rect.bottom;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13653c.f12835i.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f13653c.f12829c.getLayoutParams();
            layoutParams.height = height;
            if (height > 0) {
                this.f13651a = height;
                layoutParams2.height = com.martian.libmars.d.h.b(120.0f);
            } else {
                int i2 = this.f13651a;
                if (i2 > 0) {
                    layoutParams2.height = i2 + com.martian.libmars.d.h.b(120.0f);
                }
            }
            this.f13653c.f12835i.setLayoutParams(layoutParams);
        }
    }

    static class m implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ v4 f13654a;

        /* renamed from: b */
        final /* synthetic */ b0 f13655b;

        m(final v4 val$onPostCommentListener, final b0 val$postCommentBinding) {
            this.f13654a = val$onPostCommentListener;
            this.f13655b = val$postCommentBinding;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            ThemeTextView themeTextView = this.f13654a.f12836j;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) s);
            sb.append("");
            themeTextView.setAlpha(!com.martian.libsupport.k.p(sb.toString()) ? 1.0f : 0.4f);
            b0 b0Var = this.f13655b;
            if (b0Var != null) {
                b0Var.a("", ((Object) s) + "");
            }
        }
    }

    static class n implements View.OnClickListener {

        /* renamed from: a */
        private boolean f13656a = false;

        /* renamed from: b */
        final /* synthetic */ v4 f13657b;

        /* renamed from: c */
        final /* synthetic */ com.martian.libmars.activity.j1 f13658c;

        /* renamed from: d */
        final /* synthetic */ PopupWindow f13659d;

        /* renamed from: e */
        final /* synthetic */ int f13660e;

        /* renamed from: f */
        final /* synthetic */ BookInfoActivity.o f13661f;

        /* renamed from: g */
        final /* synthetic */ b0 f13662g;

        n(final v4 val$onPostCommentListener, final com.martian.libmars.activity.j1 val$bookInfo, final PopupWindow val$score, final int val$popupWindow, final BookInfoActivity.o val$activity, final b0 val$postCommentBinding) {
            this.f13657b = val$onPostCommentListener;
            this.f13658c = val$bookInfo;
            this.f13659d = val$score;
            this.f13660e = val$popupWindow;
            this.f13661f = val$activity;
            this.f13662g = val$postCommentBinding;
        }

        static /* synthetic */ void b(final PopupWindow popupWindow) {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.martian.libsupport.k.p(this.f13657b.f12828b.getText().toString())) {
                this.f13657b.f12836j.setAlpha(0.4f);
                this.f13658c.k1("评论内容不能为空");
                return;
            }
            if (this.f13656a) {
                this.f13658c.k1("评论发表中，请稍候");
                return;
            }
            if (!MiConfigSingleton.V3().l6()) {
                final com.martian.libmars.activity.j1 j1Var = this.f13658c;
                k0.l lVar = new k0.l() { // from class: com.martian.mibook.j.y
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        com.martian.mibook.lib.account.e.d.b(com.martian.libmars.activity.j1.this, 200, true);
                    }
                };
                final PopupWindow popupWindow = this.f13659d;
                com.martian.libmars.utils.k0.Q(j1Var, "绑定微信", "根据相关法律法规，发言评论需要先绑定微信", "暂不绑定", "立即绑定", true, lVar, new k0.j() { // from class: com.martian.mibook.j.x
                    @Override // com.martian.libmars.utils.k0.j
                    public final void a() {
                        v2.n.b(popupWindow);
                    }
                });
                return;
            }
            this.f13656a = true;
            int i2 = this.f13660e;
            try {
                i2 = ((Integer) this.f13657b.l.getTag()).intValue();
            } catch (Exception unused) {
            }
            v2.F0(this.f13658c, this.f13659d, this.f13657b, this.f13661f, i2, this.f13662g);
        }
    }

    static class o implements MiBookManager.f0 {

        /* renamed from: a */
        final /* synthetic */ v4 f13663a;

        /* renamed from: b */
        final /* synthetic */ com.martian.libmars.activity.j1 f13664b;

        /* renamed from: c */
        final /* synthetic */ PopupWindow f13665c;

        /* renamed from: d */
        final /* synthetic */ b0 f13666d;

        o(final v4 val$onPostCommentListener, final com.martian.libmars.activity.j1 val$popupWindow, final PopupWindow val$activity, final b0 val$postCommentBinding) {
            this.f13663a = val$onPostCommentListener;
            this.f13664b = val$popupWindow;
            this.f13665c = val$activity;
            this.f13666d = val$postCommentBinding;
        }

        @Override // com.martian.mibook.application.MiBookManager.f0
        public void a(b.d.c.b.c errorResult) {
            v2.g(this.f13664b, this.f13665c, errorResult.d());
        }

        @Override // com.martian.mibook.application.MiBookManager.f0
        public void b(Comment comment) {
            v2.h(this.f13664b, comment, this.f13665c, this.f13666d);
        }

        @Override // com.martian.mibook.application.MiBookManager.f0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean show) {
            if (!show) {
                this.f13663a.f12836j.setText(this.f13664b.getString(R.string.post));
                return;
            }
            this.f13663a.f12836j.setText(this.f13664b.getString(R.string.post) + "中...");
        }
    }

    static class p extends com.martian.mibook.lib.account.d.q.l0 {

        /* renamed from: j */
        final /* synthetic */ com.martian.libmars.activity.j1 f13667j;
        final /* synthetic */ int k;
        final /* synthetic */ long l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(com.martian.libmars.activity.j1 x0, final com.martian.libmars.activity.j1 val$extraId, final int val$coins, final long val$activity) {
            super(x0);
            this.f13667j = val$extraId;
            this.k = val$coins;
            this.l = val$activity;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            this.f13667j.k1("获取奖励失败");
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean success) {
            if (success == null || !success.booleanValue()) {
                this.f13667j.k1("获取奖励失败");
            } else {
                v2.U0(this.f13667j, this.k, this.l);
            }
        }
    }

    static class q extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ com.martian.libmars.activity.j1 f13668a;

        /* renamed from: b */
        final /* synthetic */ int f13669b;

        /* renamed from: c */
        final /* synthetic */ long f13670c;

        q(final com.martian.libmars.activity.j1 val$extraId, final int val$coins, final long val$activity) {
            this.f13668a = val$extraId;
            this.f13669b = val$coins;
            this.f13670c = val$activity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            v2.o(this.f13668a, this.f13669b, this.f13670c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            this.f13668a.k1("视频加载失败");
        }
    }

    static class r extends com.martian.mibook.lib.account.d.q.l {

        /* renamed from: j */
        final /* synthetic */ com.martian.libmars.activity.j1 f13671j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(com.martian.libmars.activity.j1 x0, final com.martian.libmars.activity.j1 val$coins, final int val$activity) {
            super(x0);
            this.f13671j = val$coins;
            this.k = val$activity;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            this.f13671j.k1(errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ExtraBonus extraBonus) {
            if (extraBonus == null || extraBonus.getCoins().intValue() <= 0) {
                this.f13671j.k1("获取奖励失败");
            } else {
                MiConfigSingleton.V3().V8(0, extraBonus.getCoins().intValue());
                BonusDetailActivity.E3(this.f13671j, "签到", 0, this.k + extraBonus.getCoins().intValue(), 0, 0L, 0);
            }
        }
    }

    static class s implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        private int f13672a = 0;

        /* renamed from: b */
        final /* synthetic */ com.martian.libmars.activity.j1 f13673b;

        /* renamed from: c */
        final /* synthetic */ PopupWindow f13674c;

        /* renamed from: d */
        final /* synthetic */ u4 f13675d;

        s(final com.martian.libmars.activity.j1 val$postCommentBinding, final PopupWindow val$popupWindow, final u4 val$activity) {
            this.f13673b = val$postCommentBinding;
            this.f13674c = val$popupWindow;
            this.f13675d = val$activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f13673b.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = this.f13673b.getWindow().getDecorView().getRootView().getHeight() - rect.bottom;
            if (height > 0 || this.f13672a <= 0) {
                this.f13672a = height;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13675d.f12789c.getLayoutParams();
                layoutParams.height = height;
                this.f13675d.f12789c.setLayoutParams(layoutParams);
                return;
            }
            PopupWindow popupWindow = this.f13674c;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
    }

    public interface t {
        void a(TYActivity activity);
    }

    public interface u {
        void a(String text);
    }

    public interface v {
        void a();
    }

    public interface w {
        void a(int which);
    }

    public interface x {
        void a();

        void b();
    }

    public interface y {
        void a();
    }

    public interface z {
        void a();
    }

    static /* synthetic */ void A(final com.martian.mibook.e.s2 bonusBinding, final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, final x listener, CountdownNumberTextView textView) {
        bonusBinding.f12663d.o();
        bonusBinding.f12663d.setVisibility(4);
        com.martian.mibook.lib.model.g.b.u(activity, "作者红包-倒计时-自动播放");
        alertDialog.dismiss();
        if (listener != null) {
            listener.a();
        }
    }

    static /* synthetic */ void A0(final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.l(activity, "青少年模式-关闭");
        alertDialog.dismiss();
    }

    static /* synthetic */ void B(final x listener, final AlertDialog alertDialog, View v2) {
        if (listener != null) {
            listener.a();
        }
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    static /* synthetic */ void C(final x listener, final AlertDialog alertDialog, View v2) {
        if (listener != null) {
            listener.b();
        }
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    static /* synthetic */ void C0(final UpgradeInfo upgradeInfo, final com.martian.libmars.activity.j1 activity, final String filePath, final AlertDialog alertDialog, final i7 upgradeBinding, final String name, View view) {
        if (upgradeInfo.getId() == null) {
            alertDialog.dismiss();
            return;
        }
        if (com.martian.apptask.g.g.f(activity, filePath) && com.martian.apptask.g.g.e(activity, new File(filePath))) {
            alertDialog.dismiss();
            return;
        }
        if (com.martian.libmars.d.h.F().O0()) {
            com.martian.libmars.utils.w0.a(activity, "没有网络");
            alertDialog.dismiss();
        } else if (com.martian.libmars.d.h.F().U0()) {
            k1(activity, upgradeBinding, alertDialog, upgradeInfo, filePath, name);
        } else {
            com.martian.libmars.utils.k0.P(activity, activity.getString(R.string.confirm_message), activity.getString(R.string.not_wifi_hint), new k0.l() { // from class: com.martian.mibook.j.e1
                @Override // com.martian.libmars.utils.k0.l
                public final void a() {
                    v2.k1(com.martian.libmars.activity.j1.this, upgradeBinding, alertDialog, upgradeInfo, filePath, name);
                }
            });
        }
    }

    static /* synthetic */ void D0(final com.martian.libmars.activity.j1 activity, final DialogFragment fragment, View v2) {
        s2.p0(activity, "到期弹窗-点击");
        if (fragment == null || fragment.getFragmentManager() == null) {
            return;
        }
        fragment.dismissAllowingStateLoss();
    }

    static /* synthetic */ void E0(final DialogFragment fragment, View v2) {
        if (fragment == null || fragment.getFragmentManager() == null) {
            return;
        }
        fragment.dismissAllowingStateLoss();
    }

    public static void F0(final com.martian.libmars.activity.j1 activity, final PopupWindow popupWindow, final v4 postCommentBinding, final BookInfoActivity.o bookInfo, int score, final b0 onPostCommentListener) {
        if (bookInfo == null || postCommentBinding == null) {
            return;
        }
        MiConfigSingleton.V3().l3().I1(MiBookManager.I, bookInfo.o(), bookInfo.n(), bookInfo.l(), bookInfo.k(), "评论");
        MiConfigSingleton.V3().l3().W2(activity, bookInfo.o(), bookInfo.n(), "", "", postCommentBinding.f12828b.getText().toString(), score, new o(postCommentBinding, activity, popupWindow, onPostCommentListener));
    }

    public static void G0(com.martian.libmars.activity.j1 activity, int score, v4 postCommentBinding) {
        j1(activity, score, postCommentBinding);
    }

    public static void H0(final com.martian.libmars.activity.j1 activity, final TYActivity tyActivity, final com.martian.libmars.b.d rxManager) {
        if (!com.martian.libmars.utils.n0.B(activity) || tyActivity == null) {
            return;
        }
        com.martian.libmars.utils.n0.E(activity, tyActivity.getDialogImage(), new k(activity, tyActivity, rxManager));
    }

    static /* synthetic */ void I(final com.martian.libmars.activity.j1 activity, final x listener, final c4 binding, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.u(activity, "作者红包-" + q() + AdConfig.ActionString.CLICK);
        if (listener != null) {
            listener.a();
        }
        CountdownNumberTextView countdownNumberTextView = binding.f11795d;
        if (countdownNumberTextView != null) {
            countdownNumberTextView.o();
        }
        alertDialog.dismiss();
    }

    public static void I0(final com.martian.libmars.activity.j1 activity, final TYActivity tyActivity, final com.martian.libmars.b.d rxManager, final String position, Drawable resource) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_push, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.rules_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.rd_close);
        TextView textView = (TextView) inflate.findViewById(R.id.rules_button);
        if (tyActivity.getMarginx() != null) {
            imageView.setPadding(com.martian.libmars.d.h.b(tyActivity.getMarginx().intValue()), 0, com.martian.libmars.d.h.b(tyActivity.getMarginx().intValue()), 0);
        }
        if (resource != null) {
            com.martian.libmars.utils.n0.h(activity, resource, imageView, 8);
        } else {
            com.martian.libmars.utils.n0.y(activity, tyActivity.getDialogImage(), imageView, 8);
        }
        if (com.martian.libsupport.k.p(tyActivity.getButtonText())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            com.martian.libmars.utils.h0.d(textView);
        }
        com.martian.mibook.lib.model.g.b.m(activity, position + "-" + tyActivity.getTitle() + "-曝光");
        final AlertDialog i2 = i(activity, inflate, true);
        if (i2 == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.y(com.martian.libmars.activity.j1.this, position, tyActivity, rxManager, i2, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.z(com.martian.libmars.activity.j1.this, position, tyActivity, i2, view);
            }
        });
    }

    static /* synthetic */ void J(final com.martian.libmars.activity.j1 activity, final x listener, final c4 binding, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.u(activity, "作者红包-" + q() + "关闭");
        if (listener != null) {
            listener.b();
        }
        CountdownNumberTextView countdownNumberTextView = binding.f11795d;
        if (countdownNumberTextView != null) {
            countdownNumberTextView.o();
        }
        if (MiConfigSingleton.V3().d2()) {
            MiConfigSingleton.V3().D7();
        }
        alertDialog.dismiss();
    }

    @SuppressLint({"SetTextI18n"})
    public static void J0(final com.martian.libmars.activity.j1 activity, i4 slidingAdapter, boolean secondTime, final x listener) {
        if (com.martian.libmars.utils.n0.B(activity)) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_video_bonus, (ViewGroup) null);
            final com.martian.mibook.e.s2 a2 = com.martian.mibook.e.s2.a(inflate);
            final AlertDialog i2 = i(activity, inflate, false);
            if (slidingAdapter != null) {
                slidingAdapter.H2(i4.o, AdConfig.ActionString.SHOW);
            }
            a2.f12668i.setText(String.valueOf(MiConfigSingleton.V3().W2(secondTime)));
            MiReadingTheme r2 = MiConfigSingleton.V3().J4.r();
            a2.f12665f.setTextColor(r2.getTextColorThirdly(activity));
            a2.f12664e.setTextColor(r2.getTextColorPrimary(activity));
            if (secondTime) {
                a2.f12665f.setText(activity.getString(R.string.video_ads_time_up) + activity.getString(R.string.video_ads_time_out));
                a2.f12664e.setText(activity.getString(R.string.video_ads_look_title));
                a2.f12666g.setText(MiConfigSingleton.V3().n("再免"));
            } else if (n()) {
                if (!MiConfigSingleton.V3().m5() || a2.f12663d == null) {
                    com.martian.mibook.lib.model.g.b.j0(activity, "免广告-激励视频-曝光");
                    com.martian.libmars.utils.h0.d(a2.f12661b);
                } else {
                    com.martian.mibook.lib.model.g.b.j0(activity, "免广告-激励全屏-曝光");
                    a2.f12663d.setVisibility(0);
                    a2.f12663d.setSufText("秒后自动领取");
                    a2.f12663d.n(5);
                    a2.f12663d.setOnCountDownFinishListener(new CountdownNumberTextView.b() { // from class: com.martian.mibook.j.j
                        @Override // com.martian.apptask.widget.CountdownNumberTextView.b
                        public final void a(CountdownNumberTextView countdownNumberTextView) {
                            v2.A(com.martian.mibook.e.s2.this, activity, i2, listener, countdownNumberTextView);
                        }
                    });
                }
            }
            com.martian.libmars.utils.h0.d(a2.f12661b);
            a2.f12661b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.e2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.B(v2.x.this, i2, view);
                }
            });
            a2.f12662c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.v0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.C(v2.x.this, i2, view);
                }
            });
        }
    }

    static /* synthetic */ void K(final c4 binding, final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, final x listener, CountdownNumberTextView textView) {
        binding.f11795d.setVisibility(4);
        com.martian.mibook.lib.model.g.b.u(activity, "作者红包-倒计时-自动播放");
        binding.f11795d.o();
        alertDialog.dismiss();
        if (listener != null) {
            listener.a();
        }
    }

    public static void K0(final FragmentActivity context, String title, String msg, String positive, final a0 l2, final y k2) {
        new AlertDialog.Builder(context).setTitle(title).setMessage(msg).setPositiveButton(positive, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.j.r0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                v2.a0.this.a();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.j.h1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                v2.y.this.a();
            }
        }).show();
    }

    static /* synthetic */ void L(final int type, final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, View v2) {
        if (type < 3) {
            OfflineLinkParams offlineLinkParams = new OfflineLinkParams();
            if (com.martian.libsupport.l.w(activity)) {
                offlineLinkParams.setNotchHeight(com.martian.libmars.d.h.i1(ImmersionBar.getStatusBarHeight(activity)));
            }
            MiWebViewActivity.g5(activity, offlineLinkParams.toHttpUrl("UTF8"), false);
        }
        alertDialog.dismiss();
    }

    public static void L0(final FragmentActivity context, String title, String msg, String positive, String neutral, final a0 l2, final y k2, final z m2) {
        new AlertDialog.Builder(context).setTitle(title).setMessage(msg).setPositiveButton(positive, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.j.b0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                v2.a0.this.a();
            }
        }).setNegativeButton(neutral, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.j.y1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                v2.y.this.a();
            }
        }).setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.j.j0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                v2.z.this.a();
            }
        }).show();
    }

    public static void M0(final com.martian.libmars.activity.j1 activity, final x listener) {
        CountdownNumberTextView countdownNumberTextView;
        if (com.martian.libmars.utils.n0.B(activity)) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_author, (ViewGroup) null);
            final c4 a2 = c4.a(inflate);
            a2.f11798g.setText("" + MiConfigSingleton.V3().E4());
            com.martian.libmars.utils.h0.d(a2.f11796e);
            com.martian.mibook.lib.model.g.b.u(activity, "作者红包-" + q() + AdConfig.ActionString.SHOW);
            MiConfigSingleton.V3().C7();
            final AlertDialog i2 = i(activity, inflate, false);
            if (i2 == null) {
                return;
            }
            a2.f11796e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.f1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.I(com.martian.libmars.activity.j1.this, listener, a2, i2, view);
                }
            });
            a2.f11794c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.J(com.martian.libmars.activity.j1.this, listener, a2, i2, view);
                }
            });
            if (!MiConfigSingleton.V3().d2() || (countdownNumberTextView = a2.f11795d) == null) {
                return;
            }
            countdownNumberTextView.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) a2.f11794c.getLayoutParams()).setMargins(0, com.martian.libmars.d.h.b(44.0f), 0, 0);
            a2.f11795d.setSufText("秒后自动领取");
            a2.f11795d.n(5);
            a2.f11795d.setOnCountDownFinishListener(new CountdownNumberTextView.b() { // from class: com.martian.mibook.j.n1
                @Override // com.martian.apptask.widget.CountdownNumberTextView.b
                public final void a(CountdownNumberTextView countdownNumberTextView2) {
                    v2.K(c4.this, activity, i2, listener, countdownNumberTextView2);
                }
            });
        }
    }

    static /* synthetic */ void N(final com.martian.libmars.activity.j1 activity, final TYInitialBook tyInitialBook, final DialogFragment fragment, View view) {
        com.martian.mibook.lib.model.g.b.w(activity, "创意投放素材-阅读");
        s2.h0(activity, tyInitialBook);
        if (fragment == null || fragment.getFragmentManager() == null) {
            return;
        }
        fragment.dismissAllowingStateLoss();
    }

    public static void N0(final com.martian.libmars.activity.j1 activity, final int type, boolean isInBookStore) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_book_alert, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ba_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.ba_close);
        TextView textView = (TextView) inflate.findViewById(R.id.ba_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ba_title1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ba_title2);
        if (type == 1 || type == 2) {
            com.martian.libmars.utils.h0.d(textView);
            imageView.setImageResource(R.drawable.bg_book_alert_offline);
            textView.setTextColor(ContextCompat.getColor(activity, R.color.theme_default));
            textView2.setTextColor(ContextCompat.getColor(activity, R.color.theme_default));
            textView3.setTextColor(ContextCompat.getColor(activity, R.color.theme_default));
            textView.setText("领取免费小说");
            textView2.setText(type == 1 ? "由于版权合作到期，本书于4月20日将正式下架。" : "由于版权合作到期，本书于4月20日正式下架。");
            textView3.setText("为表歉意，为您准备了大量免费好书");
        } else {
            imageView.setImageResource(R.drawable.bg_book_alert_free);
            textView.setTextColor(ContextCompat.getColor(activity, R.color.theme_light_red));
            textView2.setTextColor(ContextCompat.getColor(activity, R.color.theme_light_red));
            textView3.setTextColor(ContextCompat.getColor(activity, R.color.theme_light_red));
            textView.setText("知道了");
            textView2.setText(type == 3 ? "由于版权合作升级，本书于4月20日将正式免费。" : "由于版权合作升级，本书于4月20日正式免费。");
            textView3.setText(type == 3 ? isInBookStore ? "敬请期待" : "加入书架，提前养肥" : isInBookStore ? "嗨起来" : "加入书架，嗨起来");
        }
        final AlertDialog i2 = i(activity, inflate, false);
        if (i2 == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.L(type, activity, i2, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i2.dismiss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void O0(final com.martian.libmars.activity.j1 activity, final TYInitialBook tyInitialBook) {
        com.martian.mibook.lib.model.g.b.w(activity, "创意投放素材-展示");
        View inflate = activity.getLayoutInflater().inflate(R.layout.popup_book_ad_poster, (ViewGroup) null);
        final o4 a2 = o4.a(inflate);
        final com.martian.dialog.e k2 = ((g.a) ((g.a) ((g.a) com.martian.dialog.g.i(activity).R(inflate).f(false)).j(true)).e(false)).k();
        BookCreative creative = tyInitialBook.getCreative();
        int B0 = activity.B0();
        int z0 = activity.z0() - com.martian.libmars.d.h.b(112.0f);
        int b2 = B0 - com.martian.libmars.d.h.b(84.0f);
        int i2 = (b2 * 16) / 9;
        if (i2 > z0) {
            b2 = (z0 * 9) / 16;
        } else {
            z0 = i2;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.l.getLayoutParams();
        layoutParams.width = b2;
        layoutParams.height = z0;
        float f2 = z0 / 1280.0f;
        int textRectBottom = (int) (creative.getTextRectBottom() * f2);
        com.martian.libmars.utils.n0.k(activity, creative.getBgImg(), a2.f12480b);
        if (com.martian.libsupport.k.p(creative.getTitle())) {
            a2.f12488j.setVisibility(8);
        } else {
            a2.f12488j.setText(creative.getTitle());
        }
        a2.f12487i.setText(creative.getContent());
        a2.f12487i.setPadding(0, 0, 0, com.martian.libmars.d.h.b(134.0f) - textRectBottom);
        a2.k.setPadding(0, (int) (creative.getTextRectTop() * f2), 0, textRectBottom);
        com.martian.libmars.utils.n0.k(activity, tyInitialBook.getCoverUrl(), a2.f12482d);
        a2.f12481c.setText(tyInitialBook.getTitle());
        a2.f12483e.setText(tyInitialBook.getTagInfo());
        try {
            a2.f12488j.setTextColor(Color.parseColor(creative.getTitleColor()));
            a2.f12487i.setTextColor(Color.parseColor(creative.getFontColor()));
        } catch (Exception unused) {
        }
        RelativeLayout relativeLayout = a2.f12485g;
        final AutoScrollView autoScrollView = a2.k;
        autoScrollView.getClass();
        relativeLayout.postDelayed(new Runnable() { // from class: com.martian.mibook.j.r2
            @Override // java.lang.Runnable
            public final void run() {
                AutoScrollView.this.b();
            }
        }, 1500L);
        a2.f12484f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.N(com.martian.libmars.activity.j1.this, tyInitialBook, k2, view);
            }
        });
        a2.f12487i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o4.this.k.a();
            }
        });
        a2.f12486h.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.P(com.martian.libmars.activity.j1.this, k2, view);
            }
        });
    }

    static /* synthetic */ void P(final com.martian.libmars.activity.j1 activity, final DialogFragment fragment, View view) {
        com.martian.mibook.lib.model.g.b.w(activity, "创意投放素材-关闭");
        if (fragment == null || fragment.getFragmentManager() == null) {
            return;
        }
        fragment.dismissAllowingStateLoss();
    }

    @SuppressLint({"SetTextI18n"})
    public static void P0(final com.martian.libmars.activity.j1 activity, final TYInitialBook tyInitialBook) {
        if (com.martian.libmars.utils.n0.B(activity)) {
            new Handler().post(new Runnable() { // from class: com.martian.mibook.j.n0
                @Override // java.lang.Runnable
                public final void run() {
                    v2.Q(TYInitialBook.this, activity);
                }
            });
        } else {
            MiConfigSingleton.V3().L4.v0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void Q(final TYInitialBook tyInitialBook, final com.martian.libmars.activity.j1 activity) {
        if (tyInitialBook.getCreative() != null) {
            O0(activity, tyInitialBook);
            return;
        }
        com.martian.mibook.lib.model.g.b.B(activity, "书籍推荐弹窗-展示");
        View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_book_promote, (ViewGroup) null);
        e4 a2 = e4.a(inflate);
        com.martian.libmars.utils.n0.p(activity, tyInitialBook.getCoverUrl(), a2.f11903d, MiConfigSingleton.V3().i3(), MiConfigSingleton.V3().e2(), 2);
        com.martian.libmars.utils.n0.k(activity, tyInitialBook.getCoverUrl(), a2.f11904e);
        a2.f11906g.setText(tyInitialBook.getBookName());
        if (!com.martian.libsupport.k.p(tyInitialBook.getSubTitle())) {
            a2.f11901b.setText(Html.fromHtml(tyInitialBook.getSubTitle()));
        } else if (!com.martian.libsupport.k.p(tyInitialBook.getAuthor())) {
            a2.f11901b.setText(tyInitialBook.getAuthor() + "·著");
        }
        a2.f11905f.setVisibility(tyInitialBook.isFreeBook() ? 0 : 8);
        a2.f11907h.setText(tyInitialBook.getReason());
        final com.martian.dialog.e k2 = ((g.a) ((g.a) ((g.a) com.martian.dialog.g.i(activity).R(inflate).f(false)).j(true)).e(false)).k();
        a2.f11908i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.v(com.martian.libmars.activity.j1.this, tyInitialBook, k2, view);
            }
        });
        a2.f11902c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.w(com.martian.libmars.activity.j1.this, k2, tyInitialBook, view);
            }
        });
    }

    public static void Q0(final com.martian.libmars.activity.j1 activity, String title, String content, String secContent, final String event, final String souceName, final String sourceId, final x listener) {
        if (com.martian.libmars.utils.n0.B(activity)) {
            com.martian.mibook.lib.model.g.b.k0(activity, event + "-展示");
            View inflate = activity.getLayoutInflater().inflate(R.layout.popupwindow_close_reader_ads, (ViewGroup) null);
            final com.martian.libmars.utils.r0 k2 = com.martian.libmars.utils.r0.b(activity, inflate, -1, -1).d(R.style.updownpopwindow_anim_style).h(80).g().k();
            q4 a2 = q4.a(inflate);
            a2.f12567c.setText(title);
            a2.f12568d.setText(content);
            a2.f12568d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.R(v2.x.this, k2, view);
                }
            });
            a2.f12566b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.martian.libmars.utils.r0.this.dismiss();
                }
            });
            a2.f12570f.setText(secContent);
            a2.f12570f.setVisibility(com.martian.libsupport.k.p(secContent) ? 8 : 0);
            a2.f12570f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.T(com.martian.libmars.activity.j1.this, event, souceName, sourceId, k2, view);
                }
            });
        }
    }

    static /* synthetic */ void R(final x listener, final com.martian.libmars.utils.r0 popWindow, View v2) {
        if (listener != null) {
            listener.a();
        }
        popWindow.dismiss();
    }

    @SuppressLint({"SetTextI18n"})
    public static void R0(final com.martian.libmars.activity.j1 activity, final CheckinResult checkinResult) {
        if (com.martian.libmars.utils.n0.B(activity)) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_checkined, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.checkined_close);
            TextView textView = (TextView) inflate.findViewById(R.id.checkined_video_bonus);
            ((TextView) inflate.findViewById(R.id.checkined_coins)).setText("+" + checkinResult.getCoins());
            int intValue = checkinResult.getExtraCoins().intValue() / checkinResult.getCoins().intValue();
            if (intValue > 1) {
                textView.setText("点我赚" + (intValue + 1) + "倍奖励");
            } else {
                textView.setText("点我奖励翻倍");
            }
            final AlertDialog i2 = i(activity, inflate, true);
            if (i2 == null) {
                return;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.U(com.martian.libmars.activity.j1.this, checkinResult, i2, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i2.dismiss();
                }
            });
        }
    }

    @SuppressLint({"SetTextI18n"})
    public static void S0(final com.martian.libmars.activity.j1 activity, boolean secondTime, final String sourceName, final String sourceId, final x listener) {
        if (com.martian.libmars.utils.n0.B(activity)) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.popupwindow_close_reader_ads, (ViewGroup) null);
            final com.martian.libmars.utils.r0 k2 = com.martian.libmars.utils.r0.b(activity, inflate, -1, -1).d(R.style.updownpopwindow_anim_style).h(80).g().k();
            q4 a2 = q4.a(inflate);
            a2.f12568d.setText(activity.getString(R.string.watch_video_for) + MiConfigSingleton.V3().W2(secondTime) + activity.getString(R.string.minute_ad));
            a2.f12568d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.p1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.W(v2.x.this, k2, view);
                }
            });
            com.martian.mibook.lib.model.g.b.k0(activity, "阅读页-关闭广告-vip-展示");
            a2.f12570f.setVisibility(0);
            a2.f12570f.setText(activity.getString(R.string.open_vip_for_ad_free));
            a2.f12570f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.v1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.X(com.martian.libmars.activity.j1.this, sourceName, sourceId, k2, view);
                }
            });
            a2.f12566b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.b1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.martian.libmars.utils.r0.this.dismiss();
                }
            });
        }
    }

    static /* synthetic */ void T(final com.martian.libmars.activity.j1 activity, final String event, final String souceName, final String sourceId, final com.martian.libmars.utils.r0 popWindow, View view1) {
        s2.q0(activity, event + "-点击", true, souceName, sourceId);
        popWindow.dismiss();
    }

    public static void T0(Activity context) {
        if (com.martian.libmars.utils.n0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_coins_explain, null);
            com.martian.mibook.e.k2 a2 = com.martian.mibook.e.k2.a(inflate);
            final AlertDialog i2 = i(context, inflate, true);
            if (i2 == null) {
                return;
            }
            a2.f12236d.setVisibility(MiConfigSingleton.V3().I0() ? 0 : 8);
            a2.f12235c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i2.dismiss();
                }
            });
        }
    }

    static /* synthetic */ void U(final com.martian.libmars.activity.j1 activity, final CheckinResult checkinResult, final AlertDialog alertDialog, View v2) {
        i1(activity, checkinResult.getCoins().intValue(), checkinResult.getExtraId());
        alertDialog.dismiss();
    }

    public static void U0(com.martian.libmars.activity.j1 activity, final int coins, long extraId) {
        MiConfigSingleton.V3().N4.t(activity, b.d.a.j.b.f4373f, new q(activity, coins, extraId));
    }

    @SuppressLint({"SetTextI18n"})
    public static void V0(final com.martian.libmars.activity.j1 activity, final ExchangeMoney exchangeMoney) {
        new Handler().post(new Runnable() { // from class: com.martian.mibook.j.z1
            @Override // java.lang.Runnable
            public final void run() {
                v2.a0(com.martian.libmars.activity.j1.this, exchangeMoney);
            }
        });
    }

    static /* synthetic */ void W(final x listener, final com.martian.libmars.utils.r0 window, View v2) {
        if (listener != null) {
            listener.a();
        }
        window.dismiss();
    }

    public static void W0(final FragmentActivity context, String title, String[] items, final w l2) {
        new AlertDialog.Builder(context).setTitle(title).setItems(items, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.j.i1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                v2.b0(v2.w.this, dialogInterface, i2);
            }
        }).show();
    }

    static /* synthetic */ void X(final com.martian.libmars.activity.j1 activity, final String sourceName, final String sourceId, final com.martian.libmars.utils.r0 window, View view1) {
        s2.q0(activity, "阅读页-关闭广告-vip-点击", true, sourceName, sourceId);
        window.dismiss();
    }

    public static void X0(final com.martian.libmars.activity.j1 activity, View rootView, final Book book, final Chapter chapter, final Integer cid) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.book_info_menu, (ViewGroup) null);
        com.martian.mibook.e.u0 a2 = com.martian.mibook.e.u0.a(inflate);
        final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(rootView, 0, 0);
        a2.f12761c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.c0(com.martian.libmars.activity.j1.this, book, chapter, cid, popupWindow, view);
            }
        });
    }

    public static void Y0(final com.martian.libmars.activity.j1 activity) {
        if (com.martian.libmars.utils.n0.B(activity)) {
            com.martian.mibook.lib.model.g.b.P(activity, "通知引导-展示");
            View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_notification_setting, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.rd_close);
            TextView textView = (TextView) inflate.findViewById(R.id.rules_button);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.rules_image_inform);
            final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 15.0f, 1, 0.5f, 1, 0.0f);
            rotateAnimation.setInterpolator(new CycleInterpolator(1.0f));
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1120L);
            imageView2.setAnimation(rotateAnimation);
            rotateAnimation.start();
            if (MiConfigSingleton.V3().I0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            final AlertDialog i2 = i(activity, inflate, true);
            if (i2 == null) {
                return;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.d0(com.martian.libmars.activity.j1.this, i2, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.l1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.e0(com.martian.libmars.activity.j1.this, i2, view);
                }
            });
            i2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.martian.mibook.j.o0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    rotateAnimation.cancel();
                }
            });
        }
    }

    public static void Z0(final com.martian.libmars.activity.j1 activity, String sourceName, String sourceId, String chapterId, String chapterName, String commentString, b0 listener) {
        final u4 a2 = u4.a(View.inflate(activity, R.layout.popupwindow_post_chapter_comment, null));
        PopupWindow f2 = com.martian.libmars.utils.k0.f(activity, a2.getRoot(), true, 80, true);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.j.r1
            @Override // java.lang.Runnable
            public final void run() {
                com.martian.libmars.utils.k0.c0(com.martian.libmars.activity.j1.this, a2.f12788b);
            }
        }, 100L);
        activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new s(activity, f2, a2));
        a2.f12788b.addTextChangedListener(new a(a2, listener, chapterId));
        if (!com.martian.libsupport.k.p(commentString)) {
            a2.f12788b.setText(commentString);
            a2.f12788b.setSelection(commentString.length());
        }
        a2.f12790d.setOnClickListener(new b(a2, activity, f2, sourceName, sourceId, chapterId, chapterName, listener));
    }

    static /* synthetic */ void a0(final com.martian.libmars.activity.j1 activity, final ExchangeMoney exchangeMoney) {
        if (com.martian.libmars.utils.n0.B(activity)) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_author, (ViewGroup) null);
            c4 a2 = c4.a(inflate);
            if (exchangeMoney.getMoney() > 0) {
                a2.f11798g.setText(com.martian.rpauth.d.i.p(Integer.valueOf(exchangeMoney.getMoney())));
                a2.f11800i.setText("元");
            } else {
                a2.f11798g.setText("" + exchangeMoney.getCoins());
                a2.f11800i.setText(activity.getString(R.string.bonus_unit));
            }
            com.martian.mibook.lib.model.g.b.N(activity, "新手红包-弹窗-曝光");
            a2.f11799h.setText(activity.getString(R.string.income_dialog_hint));
            a2.f11797f.setText(activity.getString(R.string.income_bonus_hint));
            com.martian.libmars.utils.h0.d(a2.f11796e);
            a2.f11796e.setText(activity.getString(R.string.withdraw));
            final AlertDialog i2 = i(activity, inflate, true);
            if (i2 == null) {
                return;
            }
            a2.f11793b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.u1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.t(com.martian.libmars.activity.j1.this, i2, view);
                }
            });
            a2.f11794c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.u(com.martian.libmars.activity.j1.this, i2, view);
                }
            });
        }
    }

    public static void a1(final com.martian.libmars.activity.j1 activity, final BookInfoActivity.o bookInfo, int score, String commentString, final b0 onPostCommentListener) {
        final v4 a2 = v4.a(View.inflate(activity, R.layout.popupwindow_post_comment, null));
        final PopupWindow f2 = com.martian.libmars.utils.k0.f(activity, a2.getRoot(), true, 80, true);
        j1(activity, score, a2);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.j.o1
            @Override // java.lang.Runnable
            public final void run() {
                com.martian.libmars.utils.k0.c0(com.martian.libmars.activity.j1.this, a2.f12828b);
            }
        }, 100L);
        activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new l(activity, a2));
        a2.f12828b.addTextChangedListener(new m(a2, onPostCommentListener));
        if (!com.martian.libsupport.k.p(commentString)) {
            a2.f12828b.setText(commentString);
            a2.f12828b.setSelection(commentString.length());
        }
        a2.f12830d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.G0(com.martian.libmars.activity.j1.this, 20, a2);
            }
        });
        a2.f12831e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.G0(com.martian.libmars.activity.j1.this, 40, a2);
            }
        });
        a2.f12832f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.G0(com.martian.libmars.activity.j1.this, 60, a2);
            }
        });
        a2.f12833g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.G0(com.martian.libmars.activity.j1.this, 80, a2);
            }
        });
        a2.f12834h.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.G0(com.martian.libmars.activity.j1.this, 100, a2);
            }
        });
        a2.k.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f2.dismiss();
            }
        });
        a2.f12836j.setOnClickListener(new n(a2, activity, f2, score, bookInfo, onPostCommentListener));
    }

    static /* synthetic */ void b0(final w l2, DialogInterface dialog, int which) {
        dialog.dismiss();
        if (l2 != null) {
            l2.a(which);
        }
    }

    public static void b1(final Activity context, final a0 listener) {
        if (com.martian.libmars.utils.n0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_rate_view, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.dialog_close);
            TextView textView = (TextView) inflate.findViewById(R.id.dialog_notarize);
            TextView textView2 = (TextView) inflate.findViewById(R.id.rate_desc);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            final AlertDialog i2 = i(context, inflate, true);
            if (i2 == null) {
                return;
            }
            if (MiConfigSingleton.V3().I0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString("应用商店发表五星好评，到账速度提升100%，还有额外金币奖励。");
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.theme_default)), 6, 10, 33);
            spannableString.setSpan(new StyleSpan(1), 6, 10, 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.theme_default)), 15, 21, 33);
            spannableString.setSpan(new StyleSpan(1), 15, 21, 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.theme_default)), 26, 30, 33);
            spannableString.setSpan(new StyleSpan(1), 26, 30, 33);
            textView2.setText(spannableString);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.a2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i2.dismiss();
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.p0(v2.a0.this, i2, view);
                }
            });
        }
    }

    static /* synthetic */ void c0(final com.martian.libmars.activity.j1 activity, final Book book, final Chapter chapter, final Integer cid, final PopupWindow menuPopupWindow, View v2) {
        com.martian.mibook.lib.model.g.b.y(activity, "举报");
        s2.a0(activity, book, chapter, cid);
        menuPopupWindow.dismiss();
    }

    public static void c1(Activity context, String title, int type, final d0 singleChoiceSelectedListener) {
        if (com.martian.libmars.utils.n0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_recharge, null);
            ThemeImageView themeImageView = (ThemeImageView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dialog_wx_check);
            final CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.dialog_zfb_check);
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) inflate.findViewById(R.id.dialog_wx_view);
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) inflate.findViewById(R.id.dialog_zfb_view);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            View findViewById = inflate.findViewById(R.id.duration_conversion_view);
            final AlertDialog i2 = i(context, inflate, true);
            if (i2 == null) {
                return;
            }
            if (com.martian.libmars.d.h.F().I0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            if (!com.martian.libsupport.k.p(title)) {
                themeTextView.setText(title);
            }
            checkBox.setChecked(type == 0);
            checkBox2.setChecked(type != 0);
            checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.r0(checkBox, checkBox2, view);
                }
            });
            checkBox2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.d2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.s0(checkBox, checkBox2, view);
                }
            });
            themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.t1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.t0(checkBox, checkBox2, view);
                }
            });
            themeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.u0(checkBox, checkBox2, view);
                }
            });
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i2.dismiss();
                }
            });
            themeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.s1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.q0(i2, checkBox, singleChoiceSelectedListener, view);
                }
            });
        }
    }

    static /* synthetic */ void d0(final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.P(activity, "通知引导-设置");
        com.martian.libsupport.f.a(activity);
        alertDialog.dismiss();
    }

    public static void d1(final com.martian.libmars.activity.j1 activity, Integer cid, String commentString, String nickname, c0 listener) {
        final u4 a2 = u4.a(View.inflate(activity, R.layout.popupwindow_post_chapter_comment, null));
        PopupWindow f2 = com.martian.libmars.utils.k0.f(activity, a2.getRoot(), true, 80, true);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.j.q1
            @Override // java.lang.Runnable
            public final void run() {
                com.martian.libmars.utils.k0.c0(com.martian.libmars.activity.j1.this, a2.f12788b);
            }
        }, 100L);
        activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new c(activity, f2, a2));
        a2.f12788b.addTextChangedListener(new d(a2, listener, cid));
        if (!com.martian.libsupport.k.p(commentString)) {
            a2.f12788b.setText(commentString);
            a2.f12788b.setSelection(commentString.length());
        }
        if (!com.martian.libsupport.k.p(nickname)) {
            a2.f12788b.setHint("回复@" + nickname);
        }
        a2.f12790d.setOnClickListener(new e(a2, activity, f2, cid, listener));
    }

    static /* synthetic */ void e0(final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.P(activity, "通知引导-关闭");
        alertDialog.dismiss();
    }

    public static void e1(final com.martian.libmars.activity.j1 activity, Integer cid, String commentString, String nickname, c0 listener) {
        final x4 a2 = x4.a(View.inflate(activity, R.layout.popupwindow_reply_comment, null));
        PopupWindow f2 = com.martian.libmars.utils.k0.f(activity, a2.getRoot(), true, 80, true);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.j.w0
            @Override // java.lang.Runnable
            public final void run() {
                com.martian.libmars.utils.k0.c0(com.martian.libmars.activity.j1.this, a2.f12937b);
            }
        }, 100L);
        activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new f(activity, f2, a2));
        a2.f12937b.addTextChangedListener(new g(a2, listener, cid));
        if (!com.martian.libsupport.k.p(commentString)) {
            a2.f12937b.setText(commentString);
            a2.f12937b.setSelection(commentString.length());
        }
        if (!com.martian.libsupport.k.p(nickname)) {
            a2.f12937b.setHint("回复@" + nickname);
        }
        a2.f12939d.setOnClickListener(new h(a2, activity, f2, cid, listener));
    }

    public static View f(Activity activity, LinearLayout ads_container, final b.d.a.j.b adsFetcher, final AppTask appTask) {
        if (!com.martian.libmars.utils.n0.C(activity) || ads_container == null || appTask == null) {
            return null;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_ads_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bonus_ads_image);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.tv_ads_logo);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bonus_ads_detail_view);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.bonus_ads_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.bonus_ads_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bonus_ads_desc);
        TextView textView3 = (TextView) inflate.findViewById(R.id.bonus_ads_button);
        textView.setText(appTask.getTitle());
        textView2.setText(appTask.getDesc());
        imageView2.setImageResource(appTask.adsIconRes());
        linearLayout.setVisibility(0);
        if (com.martian.libsupport.k.p(appTask.getIconUrl())) {
            imageView3.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
            com.martian.libmars.utils.n0.e(activity, appTask.getIconUrl(), imageView3);
        }
        if (!com.martian.libsupport.k.p(appTask.getButtonText())) {
            textView3.setText(appTask.getButtonText());
        }
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.iv_ads_video);
        if (frameLayout == null) {
            com.martian.libmars.utils.n0.l(activity.getApplicationContext(), appTask.getPosterUrl(), imageView, R.drawable.image_loading_default_horizontal);
        } else if (!appTask.isVideoAd || appTask.videoView == null) {
            frameLayout.setVisibility(8);
            com.martian.libmars.utils.n0.l(activity.getApplicationContext(), appTask.getPosterUrl(), imageView, R.drawable.image_loading_default_horizontal);
        } else {
            frameLayout.setVisibility(0);
            appTask.videoView.init();
            if (appTask.videoView.getView().getParent() == null) {
                frameLayout.removeAllViews();
                frameLayout.addView(appTask.videoView.getView());
                com.martian.mibook.lib.model.g.b.r(activity, "穿山甲_APP退出视频广告");
            }
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.d.a.j.b.this.d(appTask);
            }
        });
        ads_container.setVisibility(0);
        ads_container.addView(inflate);
        adsFetcher.g(activity, appTask, ads_container, inflate, frameLayout, textView3, false);
        return inflate;
    }

    public static void f1(final com.martian.libmars.activity.j1 activity) {
        if (com.martian.libmars.utils.n0.B(activity)) {
            com.martian.mibook.lib.model.g.b.l(activity, "青少年模式-显示");
            MiConfigSingleton.V3().L4.y0();
            View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_teenage_guide, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.teenage_open);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.teenage_close);
            TextView textView = (TextView) inflate.findViewById(R.id.teenage_button);
            final AlertDialog i2 = i(activity, inflate, true);
            if (i2 == null) {
                return;
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.h2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.y0(com.martian.libmars.activity.j1.this, i2, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.z0(com.martian.libmars.activity.j1.this, i2, view);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.A0(com.martian.libmars.activity.j1.this, i2, view);
                }
            });
        }
    }

    public static void g(com.martian.libmars.activity.j1 activity, PopupWindow popupWindow, String msg) {
        activity.k1(msg);
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public static void g1(final com.martian.libmars.activity.j1 activity, final UpgradeInfo upgradeInfo, boolean force) {
        if (!com.martian.libmars.utils.n0.B(activity) || upgradeInfo == null) {
            return;
        }
        if (force || !MiConfigSingleton.V3().L4.b0()) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.upgrade_dialog, (ViewGroup) null);
            final i7 a2 = i7.a(inflate);
            final AlertDialog i2 = i(activity, inflate, true);
            if (i2 == null) {
                return;
            }
            final String str = activity.getString(R.string.app_name) + upgradeInfo.getVersionName() + "." + upgradeInfo.getVersionCode();
            final String str2 = com.martian.libmars.d.h.F().u() + str + ".apk";
            MiConfigSingleton.V3().L4.y0();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.f12147f.getLayoutParams();
            int B0 = activity.B0() - com.martian.libmars.d.h.b(100.0f);
            layoutParams.width = B0;
            layoutParams.height = B0 / 2;
            a2.f12148g.setText(str);
            a2.f12146e.setText(upgradeInfo.getContent());
            a2.f12144c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i2.dismiss();
                }
            });
            a2.f12145d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.g2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.C0(UpgradeInfo.this, activity, str2, i2, a2, str, view);
                }
            });
        }
    }

    public static void h(Activity activity, Comment comment, PopupWindow popupWindow, b0 onPostCommentListener) {
        com.martian.libmars.utils.w0.a(activity, "评论成功！");
        com.martian.mibook.lib.model.g.b.T(activity);
        if (onPostCommentListener != null) {
            onPostCommentListener.b(comment);
            onPostCommentListener.a("", "");
        }
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h1(final com.martian.libmars.activity.j1 activity) {
        MiUser C4;
        if (com.martian.libmars.utils.n0.B(activity) && (C4 = MiConfigSingleton.V3().C4()) != null) {
            com.martian.mibook.lib.model.g.b.k0(activity, "到期弹窗-展示");
            View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_vip_end, (ViewGroup) null);
            h4 a2 = h4.a(inflate);
            com.martian.libmars.utils.n0.e(activity, C4.getHeader(), a2.f12071d);
            a2.f12072e.setText(C4.getNickname());
            final com.martian.dialog.e k2 = ((g.a) ((g.a) com.martian.dialog.g.i(activity).R(inflate).f(false)).j(true)).k();
            a2.f12069b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.D0(com.martian.libmars.activity.j1.this, k2, view);
                }
            });
            a2.f12070c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v2.E0(DialogFragment.this, view);
                }
            });
        }
    }

    public static AlertDialog i(Activity context, View view, boolean isCancelable) {
        return com.martian.libmars.utils.k0.b(context, view, isCancelable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void i1(com.martian.libmars.activity.j1 activity, final int coins, long extraId) {
        p pVar = new p(activity, activity, coins, extraId);
        ((StartExtraBonusParams) pVar.k()).setExtraId(Long.valueOf(extraId));
        pVar.j();
    }

    public static PopupWindow j(View view, View parent, final com.martian.libmars.activity.j1 activity) {
        return k(view, parent, activity, false);
    }

    private static void j1(com.martian.libmars.activity.j1 activity, int score, v4 postCommentBinding) {
        ImageView imageView = postCommentBinding.f12830d;
        int i2 = R.drawable.vote_star_red;
        imageView.setImageResource(R.drawable.vote_star_red);
        postCommentBinding.f12831e.setImageResource(score < 40 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        postCommentBinding.f12832f.setImageResource(score < 60 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        postCommentBinding.f12833g.setImageResource(score < 80 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        ImageView imageView2 = postCommentBinding.f12834h;
        if (score < 100) {
            i2 = R.drawable.vote_star_grey;
        }
        imageView2.setImageResource(i2);
        postCommentBinding.l.setText(p(activity, score));
        postCommentBinding.l.setTag(Integer.valueOf(score));
    }

    public static PopupWindow k(View view, View parent, final com.martian.libmars.activity.j1 activity, boolean isFullScreen) {
        return l(view, parent, activity, isFullScreen, true);
    }

    public static void k1(com.martian.libmars.activity.j1 activity, i7 upgradeBinding, AlertDialog alertDialog, UpgradeInfo upgradeInfo, String filePath, String fileName) {
        new i(upgradeInfo, activity, upgradeBinding, alertDialog, filePath, fileName).execute(new Void[0]);
    }

    public static PopupWindow l(View view, View parent, final com.martian.libmars.activity.j1 activity, boolean isFullScreen, final boolean isShadow) {
        PopupWindow popupWindow = new PopupWindow(view, -1, -2);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        if (isFullScreen) {
            popupWindow.setClippingEnabled(false);
        }
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        if (isShadow) {
            com.martian.libmars.utils.k0.L(activity, true);
        }
        popupWindow.setAnimationStyle(R.style.updownpopwindow_anim_style);
        popupWindow.showAtLocation(activity.getWindow().getDecorView(), 80, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.martian.mibook.j.b2
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                v2.s(isShadow, activity);
            }
        });
        return popupWindow;
    }

    public static void m(com.martian.libmars.activity.j1 activity, i7 upgradeBinding, AlertDialog alertDialog, String url, String filePath, String fileName) {
        com.martian.libsupport.permission.g.h(activity, new j(activity, upgradeBinding, url, filePath, fileName, alertDialog), new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo(activity.getString(R.string.request_permission_title), activity.getString(R.string.request_permission_download_desc), activity.getString(R.string.search_close), activity.getString(R.string.to_open)), true);
    }

    public static boolean n() {
        if (com.martian.libmars.d.h.F().J0()) {
            return true;
        }
        return MiConfigSingleton.V3().W3().getEnableVideoCountdown() && MiConfigSingleton.V3().X2() % 4 == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o(com.martian.libmars.activity.j1 activity, final int coins, long extraId) {
        r rVar = new r(activity, activity, coins);
        ((FinishExtraBonusParams) rVar.k()).setExtraId(Long.valueOf(extraId));
        rVar.j();
    }

    private static String p(com.martian.libmars.activity.j1 activity, int score) {
        return score != 20 ? score != 40 ? score != 60 ? score != 80 ? activity.getString(R.string.post_comment_status_5) : activity.getString(R.string.post_comment_status_4) : activity.getString(R.string.post_comment_status_3) : activity.getString(R.string.post_comment_status_2) : activity.getString(R.string.post_comment_status_1);
    }

    static /* synthetic */ void p0(final a0 listener, final AlertDialog alertDialog, View view) {
        if (listener != null) {
            listener.a();
        }
        alertDialog.dismiss();
    }

    private static String q() {
        return MiConfigSingleton.V3().d2() ? "倒计时-" : "";
    }

    static /* synthetic */ void q0(AlertDialog alertDialog, CheckBox checkBox, d0 d0Var, View view) {
        alertDialog.dismiss();
        int i2 = !checkBox.isChecked() ? 1 : 0;
        if (d0Var != null) {
            d0Var.a(i2);
        }
    }

    static /* synthetic */ void r0(final CheckBox dialog_wx_check, final CheckBox dialog_zfb_check, View v2) {
        dialog_wx_check.setChecked(true);
        dialog_zfb_check.setChecked(false);
    }

    static /* synthetic */ void s(final boolean isShadow, final com.martian.libmars.activity.j1 activity) {
        if (isShadow) {
            com.martian.libmars.utils.k0.L(activity, false);
        }
    }

    static /* synthetic */ void s0(final CheckBox dialog_wx_check, final CheckBox dialog_zfb_check, View v2) {
        dialog_wx_check.setChecked(false);
        dialog_zfb_check.setChecked(true);
    }

    static /* synthetic */ void t(final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.N(activity, "新手红包-弹窗-去提现");
        if (activity instanceof IncomeActivity) {
            s2.e0(activity, "我的收入", MartianRPUserManager.f14923j);
        } else {
            IncomeActivity.w2(activity, 0, "新手红包-零钱收入");
        }
        alertDialog.dismiss();
    }

    static /* synthetic */ void t0(final CheckBox dialog_wx_check, final CheckBox dialog_zfb_check, View v2) {
        dialog_wx_check.setChecked(true);
        dialog_zfb_check.setChecked(false);
    }

    static /* synthetic */ void u(final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.N(activity, "新手红包-弹窗-关闭");
        alertDialog.dismiss();
    }

    static /* synthetic */ void u0(final CheckBox dialog_wx_check, final CheckBox dialog_zfb_check, View v2) {
        dialog_wx_check.setChecked(false);
        dialog_zfb_check.setChecked(true);
    }

    static /* synthetic */ void v(final com.martian.libmars.activity.j1 activity, final TYInitialBook tyInitialBook, final DialogFragment fragment, View v2) {
        MiConfigSingleton.V3().L4.v0();
        com.martian.mibook.lib.model.g.b.B(activity, "书籍推荐弹窗-点击");
        s2.f0(activity, tyInitialBook.buildMibook(), tyInitialBook);
        if (fragment == null || fragment.getFragmentManager() == null) {
            return;
        }
        fragment.dismissAllowingStateLoss();
    }

    static /* synthetic */ void w(final com.martian.libmars.activity.j1 activity, final DialogFragment fragment, final TYInitialBook tyInitialBook, View v2) {
        MiConfigSingleton.V3().L4.v0();
        com.martian.mibook.lib.model.g.b.B(activity, "书籍推荐弹窗-关闭");
        if (fragment != null && fragment.getFragmentManager() != null) {
            fragment.dismissAllowingStateLoss();
        }
        if (MiConfigSingleton.V3().g0() == 1) {
            MiConfigSingleton.V3().l3().N1(tyInitialBook, true);
        }
    }

    static /* synthetic */ void y(final com.martian.libmars.activity.j1 activity, final String position, final TYActivity tyActivity, final com.martian.libmars.b.d rxManager, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.m(activity, position + "-" + tyActivity.getTitle() + "-点击");
        if (rxManager == null || tyActivity.getMissionType() == null) {
            if (!com.martian.libsupport.k.p(tyActivity.getDeeplink()) && com.martian.apptask.g.g.b(activity, tyActivity.getDeeplink())) {
                com.martian.apptask.g.g.u(activity, tyActivity.getDeeplink(), "", "", true);
            } else if (!com.martian.libsupport.k.p(tyActivity.getActivityUrl())) {
                MiWebViewActivity.i5(activity, tyActivity.getActivityUrl(), false, tyActivity.getShareUrl(), tyActivity.getShareable(), tyActivity.getShareImageUrl(), tyActivity.getFullscreen().booleanValue());
            }
        } else if (MiConfigSingleton.V3().L4.n(tyActivity.getMissionType().intValue())) {
            rxManager.d(com.martian.mibook.application.v0.f11601e, tyActivity.toMissionItem());
        } else {
            activity.k1("请升级到最新版");
        }
        alertDialog.dismiss();
    }

    static /* synthetic */ void y0(final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.l(activity, "青少年模式-开启");
        activity.startActivity(TeenagerGuideActivity.class);
        alertDialog.dismiss();
    }

    static /* synthetic */ void z(final com.martian.libmars.activity.j1 activity, final String position, final TYActivity tyActivity, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.m(activity, position + "-" + tyActivity.getTitle() + "-关闭");
        alertDialog.dismiss();
    }

    static /* synthetic */ void z0(final com.martian.libmars.activity.j1 activity, final AlertDialog alertDialog, View v2) {
        com.martian.mibook.lib.model.g.b.l(activity, "青少年模式-关闭");
        alertDialog.dismiss();
    }
}

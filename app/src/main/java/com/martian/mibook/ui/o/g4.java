package com.martian.mibook.ui.o;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.data.book.CommentReply;
import com.martian.mibook.data.book.VoteResult;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.ttbookhd.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class g4 extends com.martian.libmars.widget.recyclerview.e.c<Comment> {

    /* renamed from: g */
    private final com.martian.libmars.activity.j1 f14383g;

    /* renamed from: h */
    private final Map<String, String> f14384h;

    class a implements MiBookManager.l0 {

        /* renamed from: a */
        final /* synthetic */ Comment f14385a;

        a(final Comment val$comment) {
            this.f14385a = val$comment;
        }

        @Override // com.martian.mibook.application.MiBookManager.l0
        public void a(b.d.c.b.c errorResult) {
            g4.this.f14383g.k1(errorResult.d());
        }

        @Override // com.martian.mibook.application.MiBookManager.l0
        public void b(VoteResult voteResult) {
            com.martian.mibook.lib.model.g.b.E(g4.this.f14383g, "点赞");
            this.f14385a.setHasUp(Boolean.valueOf(voteResult.getHasUp()));
            this.f14385a.setUpCount(voteResult.getUpCount());
            g4.this.notifyDataSetChanged();
        }
    }

    class b extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ CommentReply f14387a;

        /* renamed from: b */
        final /* synthetic */ MiReadingTheme f14388b;

        b(final CommentReply val$miReadingTheme, final MiReadingTheme val$commentReply) {
            this.f14387a = val$miReadingTheme;
            this.f14388b = val$commentReply;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            com.martian.mibook.lib.model.g.b.E(g4.this.f14383g, "查看用户-昵称");
            com.martian.mibook.j.s2.o0(g4.this.f14383g, 1, this.f14387a.getCuid());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setColor(this.f14388b.getTextColorThirdly(g4.this.f14383g));
        }
    }

    class c extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ CommentReply f14390a;

        /* renamed from: b */
        final /* synthetic */ MiReadingTheme f14391b;

        c(final CommentReply val$miReadingTheme, final MiReadingTheme val$commentReply) {
            this.f14390a = val$miReadingTheme;
            this.f14391b = val$commentReply;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            com.martian.mibook.lib.model.g.b.E(g4.this.f14383g, "查看用户-昵称");
            com.martian.mibook.j.s2.o0(g4.this.f14383g, 1, this.f14390a.getToUid());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setColor(this.f14391b.getTextColorThirdly(g4.this.f14383g));
        }
    }

    class d implements v2.c0 {

        /* renamed from: a */
        final /* synthetic */ Comment f14393a;

        d(final Comment val$comment) {
            this.f14393a = val$comment;
        }

        @Override // com.martian.mibook.j.v2.c0
        public void a(String tag, String comment) {
            g4.this.f14384h.put(tag, comment);
        }

        @Override // com.martian.mibook.j.v2.c0
        public void b(CommentReply commentReply) {
            com.martian.mibook.lib.model.g.b.E(g4.this.f14383g, "回复章评-成功");
            this.f14393a.getReplyList().add(0, commentReply);
            Comment comment = this.f14393a;
            comment.setReplyCount(Integer.valueOf(comment.getReplyCount() + 1));
            g4.this.notifyDataSetChanged();
        }
    }

    public g4(Activity activity, final List<Comment> datas) {
        super(activity, R.layout.reader_chapter_comment_item, datas);
        this.f14384h = new HashMap();
        this.f14383g = (com.martian.libmars.activity.j1) activity;
    }

    private Integer R() {
        if (getItemCount() > 0) {
            return ((Comment) this.f10476c.get(getItemCount() - 1)).getCid();
        }
        return null;
    }

    /* renamed from: S */
    public /* synthetic */ void T(final Comment comment, View v) {
        MiConfigSingleton.V3().l3().v3(this.f14383g, comment.getCid(), 0, comment.getHasUp(), new a(comment));
    }

    /* renamed from: U */
    public /* synthetic */ void V(final com.martian.libmars.widget.recyclerview.d holder, final Comment comment, View v) {
        com.martian.mibook.lib.model.g.b.E(this.f14383g, "举报");
        com.martian.mibook.j.v2.X0(this.f14383g, holder.getView(R.id.bd_report), null, null, comment.getCid());
    }

    /* renamed from: W */
    public /* synthetic */ void X(final Comment comment, View v) {
        j0(comment);
    }

    /* renamed from: Y */
    public /* synthetic */ void Z(final Comment comment, View v) {
        if (comment.getReplyCount() > 3) {
            k0(comment);
        } else {
            j0(comment);
        }
    }

    /* renamed from: a0 */
    public /* synthetic */ void b0(final Comment comment, View v) {
        if (comment.getReplyCount() > 3) {
            k0(comment);
        } else {
            j0(comment);
        }
    }

    /* renamed from: c0 */
    public /* synthetic */ void d0(final Comment comment, View v) {
        k0(comment);
    }

    /* renamed from: e0 */
    public /* synthetic */ void f0(final Comment comment, View v) {
        com.martian.mibook.lib.model.g.b.E(this.f14383g, "查看用户-头像");
        com.martian.mibook.j.s2.o0(this.f14383g, 1, comment.getCuid());
    }

    /* renamed from: g0 */
    public /* synthetic */ void h0(final Comment comment, View v) {
        k0(comment);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e9  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i0(final com.martian.libmars.widget.recyclerview.d r18, final com.martian.mibook.data.book.Comment r19) {
        /*
            Method dump skipped, instructions count: 807
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.ui.o.g4.i0(com.martian.libmars.widget.recyclerview.d, com.martian.mibook.data.book.Comment):void");
    }

    private void j0(@NonNull final Comment comment) {
        com.martian.mibook.lib.model.g.b.E(this.f14383g, "回复章评");
        String str = "";
        if (comment.getCid() != null) {
            str = comment.getCid() + "";
        }
        com.martian.mibook.j.v2.d1(this.f14383g, comment.getCid(), this.f14384h.get(str), comment.getNickname(), new d(comment));
    }

    private void k0(Comment comment) {
        com.martian.mibook.lib.model.g.b.E(this.f14383g, "章评详情");
        com.martian.mibook.j.s2.W(this.f14383g, false, comment);
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: Q */
    public void b(com.martian.libmars.widget.recyclerview.d helper, Comment comment) {
        i0(helper, comment);
    }
}

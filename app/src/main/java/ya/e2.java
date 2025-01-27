package ya;

import android.content.Context;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import com.martian.mibook.account.request.book.MiBookGetChapterCommentCountParams;
import com.martian.mibook.data.book.ChapterComment;
import com.martian.mibook.data.book.CommentCount;
import com.martian.mibook.data.book.MiReadingContent;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment;
import com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class e2 {

    /* renamed from: a */
    public final WeakReference<FragmentActivity> f33192a;

    /* renamed from: b */
    public final ChapterList f33193b;

    /* renamed from: c */
    public final String f33194c;

    /* renamed from: d */
    public final String f33195d;

    /* renamed from: h */
    public boolean f33199h;

    /* renamed from: e */
    public final Map<String, String> f33196e = new HashMap();

    /* renamed from: f */
    public final Map<String, String> f33197f = new HashMap();

    /* renamed from: g */
    public final Map<String, CommentCount> f33198g = new HashMap();

    /* renamed from: i */
    public final Map<String, TreeMap<Integer, CommentCount>> f33200i = new HashMap();

    public interface d {
        void a(String str, Comment comment);
    }

    public e2(FragmentActivity fragmentActivity, String str, String str2, ChapterList chapterList) {
        this.f33192a = new WeakReference<>(fragmentActivity);
        this.f33194c = str;
        this.f33195d = str2;
        this.f33193b = chapterList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i(String str, Comment comment) {
        FragmentActivity fragmentActivity = this.f33192a.get();
        if (comment == null || fragmentActivity == 0) {
            return;
        }
        ac.a.A(fragmentActivity, "发表章评-阅读页");
        CommentCount commentCount = this.f33198g.get(str);
        if (commentCount == null) {
            commentCount = new CommentCount();
            commentCount.setType(2);
            commentCount.setChapterId(str);
            commentCount.setNComments(1);
            commentCount.addComment(comment);
        } else {
            commentCount.incrNComments();
            commentCount.addComment(comment);
        }
        this.f33198g.put(str, commentCount);
        if (fragmentActivity instanceof gd.a) {
            ((gd.a) fragmentActivity).a();
        }
    }

    public final void j(MiReadingContent miReadingContent, Integer num, Comment comment) {
        String chapterId = miReadingContent.getChapterId();
        if (ba.l.q(chapterId)) {
            return;
        }
        TreeMap<Integer, CommentCount> o10 = o(miReadingContent);
        if (o10 == null) {
            TreeMap<Integer, CommentCount> treeMap = new TreeMap<>();
            treeMap.put(num, l(miReadingContent, num, comment, 1));
            this.f33200i.put(chapterId, treeMap);
            return;
        }
        CommentCount commentCount = o10.get(num);
        if (commentCount == null) {
            o10.put(num, l(miReadingContent, num, comment, 1));
            return;
        }
        commentCount.incrNComments();
        commentCount.setHasComment(Boolean.TRUE);
        commentCount.addComment(comment);
    }

    public final boolean k(String str, List<CommentCount> list) {
        boolean z10 = false;
        if (list != null && !list.isEmpty()) {
            TreeMap<Integer, CommentCount> treeMap = new TreeMap<>();
            String str2 = "";
            for (CommentCount commentCount : list) {
                commentCount.setType(3);
                if (!str2.equalsIgnoreCase(commentCount.getChapterId())) {
                    if (!treeMap.isEmpty()) {
                        this.f33200i.put(str2, treeMap);
                    }
                    String chapterId = commentCount.getChapterId();
                    if (chapterId.equalsIgnoreCase(str)) {
                        z10 = true;
                    }
                    str2 = chapterId;
                    treeMap = new TreeMap<>();
                }
                treeMap.put(commentCount.getParagraphIdx(), commentCount);
            }
            if (!treeMap.isEmpty()) {
                this.f33200i.put(str2, treeMap);
            }
        }
        return z10;
    }

    public final CommentCount l(MiReadingContent miReadingContent, Integer num, Comment comment, int i10) {
        CommentCount commentCount = new CommentCount();
        commentCount.setType(3);
        commentCount.setChapterId(miReadingContent.getChapterId());
        commentCount.setParagraphIdx(num);
        commentCount.setnComments(Integer.valueOf(i10));
        commentCount.setHasComment(Boolean.valueOf(i10 > 0));
        if (comment != null) {
            commentCount.addComment(comment);
        }
        return commentCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(String str, String str2) {
        c cVar = new c(MiBookGetChapterCommentCountParams.class, ChapterComment.class, this.f33192a.get(), str);
        if (!ba.l.q(str2)) {
            ((MiBookGetChapterCommentCountParams) cVar.k()).setChapterIds(str2);
        }
        ((MiBookGetChapterCommentCountParams) cVar.k()).setSourceName(this.f33194c);
        ((MiBookGetChapterCommentCountParams) cVar.k()).setSourceId(this.f33195d);
        cVar.j();
    }

    public CommentCount n(MiReadingContent miReadingContent) {
        String chapterId = miReadingContent.getChapterId();
        if (ba.l.q(chapterId)) {
            return null;
        }
        CommentCount commentCount = this.f33198g.get(chapterId);
        if (commentCount != null) {
            return commentCount;
        }
        int chapterIndex = miReadingContent.getChapterIndex();
        if (!this.f33199h && chapterIndex >= 0 && chapterIndex < this.f33193b.getCount()) {
            int min = Math.min(this.f33193b.getCount(), chapterIndex + 5);
            StringBuilder sb2 = new StringBuilder();
            while (chapterIndex < min) {
                Chapter item = this.f33193b.getItem(chapterIndex);
                if (item != null) {
                    String chapterId2 = item.getChapterId();
                    if (!ba.l.q(chapterId2)) {
                        CommentCount commentCount2 = new CommentCount();
                        commentCount2.setType(2);
                        commentCount2.setNComments(0);
                        commentCount2.setChapterId(chapterId2);
                        this.f33198g.put(chapterId2, commentCount2);
                        if (!ba.l.q(sb2.toString())) {
                            sb2.append(",");
                        }
                        sb2.append(chapterId2);
                    }
                }
                chapterIndex++;
            }
            m(chapterId, sb2.toString());
        }
        return null;
    }

    public TreeMap<Integer, CommentCount> o(MiReadingContent miReadingContent) {
        String chapterId = miReadingContent.getChapterId();
        if (ba.l.q(chapterId)) {
            return null;
        }
        TreeMap<Integer, CommentCount> treeMap = this.f33200i.get(chapterId);
        if (treeMap == null) {
            n(miReadingContent);
        }
        return treeMap;
    }

    public final CommentCount p(MiReadingContent miReadingContent, Integer num) {
        TreeMap<Integer, CommentCount> o10 = o(miReadingContent);
        if (o10 == null || o10.isEmpty()) {
            return null;
        }
        return o10.get(num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void q(MiReadingContent miReadingContent, Integer num, String str, Comment comment) {
        j(miReadingContent, num, comment);
        FragmentActivity fragmentActivity = this.f33192a.get();
        if (fragmentActivity == 0) {
            return;
        }
        ac.a.A(fragmentActivity, "发表段评");
        if (fragmentActivity instanceof gd.a) {
            ((gd.a) fragmentActivity).a();
        }
    }

    public void r(CommentCount commentCount, String str, boolean z10) {
        if (commentCount.getNComments() <= 0 || z10) {
            ReaderPostOrReplyCommentFragment.X(this.f33192a.get(), commentCount, this.f33194c, this.f33195d, this.f33196e.get(commentCount.getChapterId()), str, "", false, new a());
        } else {
            ReaderCommentFragment.M0(this.f33192a.get(), commentCount, this.f33194c, this.f33195d, str, "", new d() { // from class: ya.d2
                public /* synthetic */ d2() {
                }

                @Override // ya.e2.d
                public final void a(String str2, Comment comment) {
                    e2.this.i(str2, comment);
                }
            });
        }
    }

    public void s(MiReadingContent miReadingContent, Integer num, String str, String str2, boolean z10) {
        CommentCount p10 = p(miReadingContent, num);
        if (p10 == null) {
            p10 = l(miReadingContent, num, null, 0);
        }
        CommentCount commentCount = p10;
        if (commentCount.getNComments() <= 0 || z10) {
            ReaderPostOrReplyCommentFragment.X(this.f33192a.get(), commentCount, this.f33194c, this.f33195d, this.f33197f.get(commentCount.getEditTag()), str, str2, false, new b(miReadingContent, num));
        } else {
            ReaderCommentFragment.M0(this.f33192a.get(), commentCount, this.f33194c, this.f33195d, str, str2, new d() { // from class: ya.c2

                /* renamed from: b */
                public final /* synthetic */ MiReadingContent f33132b;

                /* renamed from: c */
                public final /* synthetic */ Integer f33133c;

                public /* synthetic */ c2(MiReadingContent miReadingContent2, Integer num2) {
                    miReadingContent = miReadingContent2;
                    num = num2;
                }

                @Override // ya.e2.d
                public final void a(String str3, Comment comment) {
                    e2.this.q(miReadingContent, num, str3, comment);
                }
            });
        }
    }

    public class a implements ReaderPostOrReplyCommentFragment.e {
        public a() {
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void b(Comment comment) {
            e2.this.i(String.valueOf(comment.getCid()), comment);
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void c(String str, String str2) {
            e2.this.f33196e.put(str, str2);
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void a(CommentReply commentReply) {
        }
    }

    public class b implements ReaderPostOrReplyCommentFragment.e {

        /* renamed from: a */
        public final /* synthetic */ MiReadingContent f33202a;

        /* renamed from: b */
        public final /* synthetic */ Integer f33203b;

        public b(MiReadingContent miReadingContent, Integer num) {
            this.f33202a = miReadingContent;
            this.f33203b = num;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void b(Comment comment) {
            e2.this.j(this.f33202a, this.f33203b, comment);
            FragmentActivity fragmentActivity = (FragmentActivity) e2.this.f33192a.get();
            if (fragmentActivity == 0) {
                return;
            }
            ac.a.A(fragmentActivity, "发表段评");
            if (fragmentActivity instanceof gd.a) {
                ((gd.a) fragmentActivity).a();
            }
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void c(String str, String str2) {
            e2.this.f33197f.put(str, str2);
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void a(CommentReply commentReply) {
        }
    }

    public class c extends jb.e<MiBookGetChapterCommentCountParams, ChapterComment> {

        /* renamed from: h */
        public final /* synthetic */ String f33205h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Class cls, Class cls2, Context context, String str) {
            super(cls, cls2, context);
            this.f33205h = str;
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<ChapterComment> list) {
            KeyEventDispatcher.Component component;
            if (list == null || list.isEmpty()) {
                return;
            }
            if (e2.this.f33198g.size() > 20) {
                e2.this.f33198g.clear();
            }
            boolean z10 = false;
            for (CommentCount commentCount : list.get(0).getChapterComments()) {
                commentCount.setType(2);
                e2.this.f33198g.put(commentCount.getChapterId(), commentCount);
                if (this.f33205h.equalsIgnoreCase(commentCount.getChapterId())) {
                    z10 = true;
                }
            }
            boolean k10 = e2.this.k(this.f33205h, list.get(0).getParagraphComments());
            if ((z10 || k10) && (component = (FragmentActivity) e2.this.f33192a.get()) != null && (component instanceof gd.a)) {
                ((gd.a) component).a();
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            e2.this.f33199h = z10;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }
    }
}

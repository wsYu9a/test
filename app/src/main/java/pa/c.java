package pa;

import android.app.Activity;
import com.martian.mibook.account.request.book.MiBookPostCommentParams;
import com.martian.mibook.mvvm.read.comment.Comment;
import jb.k;

/* loaded from: classes3.dex */
public abstract class c extends k<MiBookPostCommentParams, Comment> {
    public c(Activity activity) {
        super(activity, MiBookPostCommentParams.class, Comment.class);
    }
}

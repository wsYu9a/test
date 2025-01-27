package ff;

import android.widget.AbsListView;

/* loaded from: classes3.dex */
public class c implements AbsListView.OnScrollListener {

    /* renamed from: a */
    public com.nostra13.universalimageloader.core.b f26026a;

    /* renamed from: b */
    public final boolean f26027b;

    /* renamed from: c */
    public final boolean f26028c;

    /* renamed from: d */
    public final AbsListView.OnScrollListener f26029d;

    public c(com.nostra13.universalimageloader.core.b bVar, boolean z10, boolean z11) {
        this(bVar, z10, z11, null);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        AbsListView.OnScrollListener onScrollListener = this.f26029d;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i10, i11, i12);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        if (i10 == 0) {
            this.f26026a.M();
        } else if (i10 != 1) {
            if (i10 == 2 && this.f26028c) {
                this.f26026a.L();
            }
        } else if (this.f26027b) {
            this.f26026a.L();
        }
        AbsListView.OnScrollListener onScrollListener = this.f26029d;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i10);
        }
    }

    public c(com.nostra13.universalimageloader.core.b bVar, boolean z10, boolean z11, AbsListView.OnScrollListener onScrollListener) {
        this.f26026a = bVar;
        this.f26027b = z10;
        this.f26028c = z11;
        this.f26029d = onScrollListener;
    }
}

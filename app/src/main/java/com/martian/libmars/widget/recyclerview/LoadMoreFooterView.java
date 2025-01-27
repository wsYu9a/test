package com.martian.libmars.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import ba.l;
import com.martian.libmars.R;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;

/* loaded from: classes3.dex */
public class LoadMoreFooterView extends FrameLayout {

    /* renamed from: b */
    public Status f12793b;

    /* renamed from: c */
    public final View f12794c;

    /* renamed from: d */
    public final View f12795d;

    /* renamed from: e */
    public final View f12796e;

    /* renamed from: f */
    public final TextView f12797f;

    /* renamed from: g */
    public b f12798g;

    public enum Status {
        GONE,
        LOADING,
        ERROR,
        THE_END
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f12799a;

        static {
            int[] iArr = new int[Status.values().length];
            f12799a = iArr;
            try {
                iArr[Status.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12799a[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12799a[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12799a[Status.THE_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface b {
        void a(LoadMoreFooterView loadMoreFooterView);
    }

    public LoadMoreFooterView(Context context) {
        this(context, null);
    }

    public boolean b() {
        Status status = this.f12793b;
        return status == Status.GONE || status == Status.ERROR;
    }

    public final void c() {
        int i10 = a.f12799a[this.f12793b.ordinal()];
        if (i10 == 1) {
            this.f12794c.setVisibility(4);
            this.f12795d.setVisibility(4);
            this.f12796e.setVisibility(4);
            this.f12797f.setVisibility(4);
            return;
        }
        if (i10 == 2) {
            this.f12794c.setVisibility(0);
            this.f12795d.setVisibility(4);
            this.f12796e.setVisibility(4);
            this.f12797f.setVisibility(4);
            return;
        }
        if (i10 == 3) {
            this.f12794c.setVisibility(4);
            this.f12795d.setVisibility(0);
            this.f12796e.setVisibility(4);
            this.f12797f.setVisibility(4);
            return;
        }
        if (i10 != 4) {
            return;
        }
        this.f12794c.setVisibility(4);
        this.f12795d.setVisibility(4);
        this.f12796e.setVisibility(0);
        this.f12797f.setVisibility(0);
    }

    public final /* synthetic */ void d(View view) {
        b bVar = this.f12798g;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public Status getStatus() {
        return this.f12793b;
    }

    public void setEndStatus(String str) {
        if (this.f12797f == null || l.q(str)) {
            return;
        }
        this.f12797f.setText(str);
    }

    public void setOnRetryListener(b bVar) {
        this.f12798g = bVar;
    }

    public void setStatus(Status status) {
        this.f12793b = status;
        c();
    }

    public LoadMoreFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadMoreFooterView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.layout_irecyclerview_load_more_footer_view, (ViewGroup) this, true);
        this.f12794c = findViewById(R.id.loadingView);
        View findViewById = findViewById(R.id.errorView);
        this.f12795d = findViewById;
        View findViewById2 = findViewById(R.id.theEndView);
        this.f12796e = findViewById2;
        this.f12797f = (TextView) findViewById2.findViewById(R.id.tvTheEnd);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: q9.a
            public /* synthetic */ a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadMoreFooterView.this.d(view);
            }
        });
        setStatus(Status.GONE);
    }
}

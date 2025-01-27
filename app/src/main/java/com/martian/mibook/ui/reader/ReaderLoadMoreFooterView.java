package com.martian.mibook.ui.reader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.martian.libsupport.k;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class ReaderLoadMoreFooterView extends FrameLayout {

    /* renamed from: a */
    private Status f14812a;

    /* renamed from: b */
    private final View f14813b;

    /* renamed from: c */
    private final View f14814c;

    /* renamed from: d */
    private final View f14815d;

    /* renamed from: e */
    private final TextView f14816e;

    /* renamed from: f */
    private b f14817f;

    public enum Status {
        GONE,
        LOADING,
        ERROR,
        THE_END
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f14818a;

        static {
            int[] iArr = new int[Status.values().length];
            f14818a = iArr;
            try {
                iArr[Status.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14818a[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14818a[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14818a[Status.THE_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface b {
        void a(ReaderLoadMoreFooterView view);
    }

    public ReaderLoadMoreFooterView(Context context) {
        this(context, null);
    }

    private void b() {
        int i2 = a.f14818a[this.f14812a.ordinal()];
        if (i2 == 1) {
            this.f14813b.setVisibility(4);
            this.f14814c.setVisibility(4);
            this.f14815d.setVisibility(4);
            this.f14816e.setVisibility(4);
            return;
        }
        if (i2 == 2) {
            this.f14813b.setVisibility(0);
            this.f14814c.setVisibility(4);
            this.f14815d.setVisibility(4);
            this.f14816e.setVisibility(4);
            return;
        }
        if (i2 == 3) {
            this.f14813b.setVisibility(4);
            this.f14814c.setVisibility(0);
            this.f14815d.setVisibility(4);
            this.f14816e.setVisibility(4);
            return;
        }
        if (i2 != 4) {
            return;
        }
        this.f14813b.setVisibility(4);
        this.f14814c.setVisibility(4);
        this.f14815d.setVisibility(0);
        this.f14816e.setVisibility(0);
    }

    /* renamed from: c */
    public /* synthetic */ void d(View v) {
        b bVar = this.f14817f;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public boolean a() {
        Status status = this.f14812a;
        return status == Status.GONE || status == Status.ERROR;
    }

    public Status getStatus() {
        return this.f14812a;
    }

    public void setEndStatus(String desc) {
        if (this.f14816e == null || k.p(desc)) {
            return;
        }
        this.f14816e.setText(desc);
    }

    public void setOnRetryListener(b listener) {
        this.f14817f = listener;
    }

    public void setStatus(Status status) {
        this.f14812a = status;
        b();
    }

    public ReaderLoadMoreFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReaderLoadMoreFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_reader_irecyclerview_load_more_footer_view, (ViewGroup) this, true);
        this.f14813b = findViewById(R.id.loadingView);
        View findViewById = findViewById(R.id.errorView);
        this.f14814c = findViewById;
        View findViewById2 = findViewById(R.id.theEndView);
        this.f14815d = findViewById2;
        this.f14816e = (TextView) findViewById2.findViewById(R.id.tvTheEnd);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.reader.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderLoadMoreFooterView.this.d(view);
            }
        });
        setStatus(Status.GONE);
    }
}

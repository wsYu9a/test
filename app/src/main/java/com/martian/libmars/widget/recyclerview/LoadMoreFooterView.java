package com.martian.libmars.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.martian.libmars.R;
import com.martian.libsupport.k;

/* loaded from: classes2.dex */
public class LoadMoreFooterView extends FrameLayout {

    /* renamed from: a */
    private Status f10439a;

    /* renamed from: b */
    private final View f10440b;

    /* renamed from: c */
    private final View f10441c;

    /* renamed from: d */
    private final View f10442d;

    /* renamed from: e */
    private final TextView f10443e;

    /* renamed from: f */
    private b f10444f;

    public enum Status {
        GONE,
        LOADING,
        ERROR,
        THE_END
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f10445a;

        static {
            int[] iArr = new int[Status.values().length];
            f10445a = iArr;
            try {
                iArr[Status.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10445a[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10445a[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10445a[Status.THE_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface b {
        void a(LoadMoreFooterView view);
    }

    public LoadMoreFooterView(Context context) {
        this(context, null);
    }

    private void b() {
        int i2 = a.f10445a[this.f10439a.ordinal()];
        if (i2 == 1) {
            this.f10440b.setVisibility(4);
            this.f10441c.setVisibility(4);
            this.f10442d.setVisibility(4);
            this.f10443e.setVisibility(4);
            return;
        }
        if (i2 == 2) {
            this.f10440b.setVisibility(0);
            this.f10441c.setVisibility(4);
            this.f10442d.setVisibility(4);
            this.f10443e.setVisibility(4);
            return;
        }
        if (i2 == 3) {
            this.f10440b.setVisibility(4);
            this.f10441c.setVisibility(0);
            this.f10442d.setVisibility(4);
            this.f10443e.setVisibility(4);
            return;
        }
        if (i2 != 4) {
            return;
        }
        this.f10440b.setVisibility(4);
        this.f10441c.setVisibility(4);
        this.f10442d.setVisibility(0);
        this.f10443e.setVisibility(0);
    }

    /* renamed from: c */
    public /* synthetic */ void d(View v) {
        b bVar = this.f10444f;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public boolean a() {
        Status status = this.f10439a;
        return status == Status.GONE || status == Status.ERROR;
    }

    public Status getStatus() {
        return this.f10439a;
    }

    public void setEndStatus(String desc) {
        if (this.f10443e == null || k.p(desc)) {
            return;
        }
        this.f10443e.setText(desc);
    }

    public void setOnRetryListener(b listener) {
        this.f10444f = listener;
    }

    public void setStatus(Status status) {
        this.f10439a = status;
        b();
    }

    public LoadMoreFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadMoreFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_irecyclerview_load_more_footer_view, (ViewGroup) this, true);
        this.f10440b = findViewById(R.id.loadingView);
        View findViewById = findViewById(R.id.errorView);
        this.f10441c = findViewById;
        View findViewById2 = findViewById(R.id.theEndView);
        this.f10442d = findViewById2;
        this.f10443e = (TextView) findViewById2.findViewById(R.id.tvTheEnd);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.widget.recyclerview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadMoreFooterView.this.d(view);
            }
        });
        setStatus(Status.GONE);
    }
}

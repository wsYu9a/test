package com.martian.ttbook.b.a.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.RotateDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.martian.ttbook.b.a.k.j;
import java.lang.reflect.Field;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes4.dex */
public class a extends FrameLayout {
    private View.OnClickListener A;

    /* renamed from: a */
    private g f15075a;

    /* renamed from: b */
    private boolean f15076b;

    /* renamed from: c */
    private boolean f15077c;

    /* renamed from: d */
    private boolean f15078d;

    /* renamed from: e */
    private boolean f15079e;

    /* renamed from: f */
    private StringBuilder f15080f;

    /* renamed from: g */
    private Formatter f15081g;

    /* renamed from: h */
    private ProgressBar f15082h;

    /* renamed from: i */
    private TextView f15083i;

    /* renamed from: j */
    private TextView f15084j;
    private TextView k;
    private ImageButton l;
    private ImageButton m;
    private ImageButton n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private RelativeLayout r;
    private ImageView s;
    protected Context t;
    private Handler u;
    boolean v;
    private View.OnTouchListener w;
    private View.OnClickListener x;
    private View.OnClickListener y;
    private View.OnClickListener z;

    /* renamed from: com.martian.ttbook.b.a.p.a$a */
    class C0284a implements Handler.Callback {
        C0284a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            a aVar;
            int i2;
            switch (message.what) {
                case 1:
                    a.this.w();
                    return false;
                case 2:
                    int K = a.this.K();
                    if (a.this.f15077c || a.this.f15075a == null || !a.this.f15075a.a()) {
                        return false;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    a.this.u.sendMessageDelayed(obtain, 1000 - (K % 1000));
                    return false;
                case 3:
                    a.this.L();
                    aVar = a.this;
                    i2 = 3;
                    break;
                case 4:
                case 6:
                case 8:
                    a.this.w();
                    a.this.y();
                    return false;
                case 5:
                    a.this.L();
                    aVar = a.this;
                    i2 = 5;
                    break;
                case 7:
                    aVar = a.this;
                    i2 = 7;
                    break;
                default:
                    return false;
            }
            aVar.l(i2);
            return false;
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a.this.f15076b) {
                return false;
            }
            a.this.w();
            a.this.v = true;
            return true;
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f15075a != null) {
                a.this.k();
                a.this.c(3000);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f15079e = !r2.f15079e;
            a.this.R();
            a.this.P();
            a.this.f15075a.a(a.this.f15079e);
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f15079e) {
                a.this.f15079e = false;
                a.this.R();
                a.this.P();
                a.this.f15075a.a(false);
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.y();
            a.this.f15075a.d();
        }
    }

    public interface g {
        void a(boolean z);

        boolean a();

        void b();

        boolean c();

        void d();

        int e();

        int f();

        int g();
    }

    protected static final class h extends Enum<h> {

        /* renamed from: b */
        public static final h f15091b = new h("SHOW_NEVER", 0);

        /* renamed from: c */
        public static final h f15092c = new h("SHOW_ALWAYS", 1);

        /* renamed from: d */
        public static final h f15093d = new h("SHOW_VISIBLE_OR_GONE", 2);

        private h(String str, int i2) {
            super(str, i2);
        }
    }

    public a(Context context) {
        super(context);
        this.f15076b = true;
        this.f15078d = true;
        this.f15079e = false;
        h hVar = h.f15093d;
        this.u = new Handler(new C0284a());
        this.v = false;
        this.w = new b();
        this.x = new c();
        this.y = new d();
        this.z = new e();
        this.A = new f();
        d(context);
    }

    private void E() {
        ImageButton imageButton = this.l;
        if (imageButton != null) {
            imageButton.requestFocus();
            this.l.setOnClickListener(this.x);
        }
        if (this.f15078d) {
            ImageButton imageButton2 = this.m;
            if (imageButton2 != null) {
                e(imageButton2, 0);
                this.m.setOnClickListener(this.y);
            }
        } else {
            e(this.m, 8);
        }
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setOnClickListener(this.A);
        }
        ImageButton imageButton3 = this.n;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this.z);
        }
    }

    public int K() {
        g gVar = this.f15075a;
        if (gVar == null || this.f15077c) {
            return 0;
        }
        int f2 = gVar.f();
        int e2 = this.f15075a.e();
        ProgressBar progressBar = this.f15082h;
        if (progressBar != null) {
            if (e2 > 0) {
                progressBar.setProgress((int) ((f2 * 1000) / e2));
            }
            this.f15082h.setSecondaryProgress(this.f15075a.g() * 10);
        }
        TextView textView = this.f15083i;
        if (textView != null) {
            textView.setText(p(e2));
        }
        TextView textView2 = this.f15084j;
        if (textView2 != null) {
            textView2.setText(p(f2));
        }
        return f2;
    }

    public void P() {
        e(this.n, this.f15079e ? 0 : 4);
    }

    private void Q() {
        ImageButton imageButton;
        String str;
        Log.e("ApiMediaControllerTAG", "updatePausePlay");
        new Exception().printStackTrace();
        g gVar = this.f15075a;
        if (gVar == null || !gVar.a()) {
            imageButton = this.l;
            str = "iVBORw0KGgoAAAANSUhEUgAAADgAAAA4CAMAAACfWMssAAAAQlBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////8IX9KGAAAAFXRSTlMAtPD8DgOeNOO+Vicd26l5PsqEYoeGu3ayAAAAlElEQVRIx+3VuxpFMBREYQkSDuduv/+r0k09q0CR6f9mybd1bW0Xr+Z5RbBE5AeBKY69Bghj+kAY/W9kMOK7QBj5j6AamVCNCIx+GwFUIwDVyIBqBKAamVDvyILaTGEsZ8ME47xZnGdln6OQB6DT5UIdSwOqigFVBcACToeqGFBVLKgqJlQVAMtw4m+uTmnt2trutx1vtyP8m6K/swAAAABJRU5ErkJggg==";
        } else {
            imageButton = this.l;
            str = "iVBORw0KGgoAAAANSUhEUgAAADgAAAA4BAMAAABaqCYtAAAAGFBMVEUAAAD///////////////////////////8jfp1fAAAAB3RSTlMAHvq+4MgxaI51OgAAAElJREFUOMtjGAXUAMLq5UVhIEYqkGGIJmleXl5eAmK4AxnFaJLq5UAgwMDACKKL0CTLkSXLRyVHJUcl4ZJ4MxLeLIg/844CKgAA/gibZXJbivoAAAAASUVORK5CYII=";
        }
        j.g(imageButton, str);
    }

    public void R() {
        ImageButton imageButton;
        String str;
        if (this.f15079e) {
            imageButton = this.m;
            str = "iVBORw0KGgoAAAANSUhEUgAAADgAAAA4BAMAAABaqCYtAAAALVBMVEUAAAD///////////////////////////////////////////////////////+hSKubAAAADnRSTlMAiHmWyg99QwOvY/5hsQj4B2EAAADWSURBVDjLYxgFVACMCsg8JgEUSblHyDy9hyga371TQNL47h1YK4KLpFUPoRTBj5RgYGicysAGV4nQ+ozV7xUDw7onAXkIjQitIu8eMzDYvXMEa0TX+g4i+Q6hEaEVJonQiABsCMkEDMkQhKQruhyrH0LySQCaJCfIIcBQkwPRE7BY+W47A0M1iBZAk+Q4KCgoWMDAwA6kpBoYBh4gO0imgZBXCAcC4eDDDHjCUUY4sjGTCd4ERnzS1AM5IxaUqK9CEjXO7IDQipmRQFoF8GVB/Jl3FFAOAMFHuuusc6BSAAAAAElFTkSuQmCC";
        } else {
            imageButton = this.m;
            str = "iVBORw0KGgoAAAANSUhEUgAAADgAAAA4CAYAAACohjseAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6NEUwNEE3ODVGODQyMTFFMzhCMTNBN0I3OUU0MDBEMDIiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6NEUwNEE3ODZGODQyMTFFMzhCMTNBN0I3OUU0MDBEMDIiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo0RTA0QTc4M0Y4NDIxMUUzOEIxM0E3Qjc5RTQwMEQwMiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo0RTA0QTc4NEY4NDIxMUUzOEIxM0E3Qjc5RTQwMEQwMiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PkG6ngcAAAJnSURBVHja7Jg7SwNBEMdzRhsLFUJa/QQWNiJopSn8CjEaEbGNyTXGZ6Px0eTy8Av4+gA2FhKwsvCBliIoKPgFrI2es7AHS7jN7e7tJiHMwJ+TdXbdnzM3s3uW67qRbraeSJcbAiIgAiIgAiIgAnax9SrMmabizX0FnYJ+JdeNgc5BM6A+js8LaAV0K7wqOYtKKAH6c4NtV3JdorIrZh8y68qm6CzIEvAbVciMe8Goj5h8B/sFfB5BiwqAF6AlhdTW/g4GwSVA34rzz+jzRDBTWl5Fr0LAeTamC84E4A4oH2J+EZTr5BQldkCfh5LzHFC23Y2+sQA8gPY5kHkNcMegdKjCI9mrlpl+dAcapONbnJ61LrCmw5lbBVnUZx5Up+M3MnuWBYyCCqBLBi4SApIHV2HgPM1R/7hJwCDxIDdCwilLdxXdA237jA/5jH35jFVBq+TN0bYjzRH0tMlE5KiJn834lXVGzpOJNkGsQJ8DoLWAvuedL7NaI0fNwi/bCIiAXQlIbgMlkC3gm6O+lpGdGGgRpHCVmPJvt7NNmIDz+7ZiB8AZg+wxkJYZn98NC45ltKer5H8kTs+QScHIuTRdLU60Zc6jyVYctmt0A+TqkmI2WuFs1AlIOVHIFHNdqpkErDMbID+nQ8CJQJI74ULD3/0xCShqjkKxcCTWbyugE6LqFTsd0NFQ2os6AXW2CXItedKwznM7L7xBVqdFQTV6jQWlI99BtoXIKCUIZzRFPwV8oqAJhWQap3N17EE5RSdBbwHRuwbFFCIYo3ObRfEdNCWzLn6yQEAEREAEREAEREAE7Fj7F2AA+Z+qB36kbeAAAAAASUVORK5CYII=";
        }
        j.g(imageButton, str);
    }

    private void b() {
        g gVar;
        try {
            if (this.l == null || (gVar = this.f15075a) == null || gVar.c()) {
                return;
            }
            this.l.setEnabled(false);
        } catch (IncompatibleClassChangeError unused) {
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void d(Context context) {
        this.t = context;
        RelativeLayout relativeLayout = new RelativeLayout(this.t);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(0);
        addView(relativeLayout, layoutParams);
        relativeLayout.setOnTouchListener(this.w);
        m(relativeLayout);
    }

    private void e(View view, int i2) {
        if (view == null || view.getVisibility() == i2) {
            return;
        }
        view.setVisibility(i2);
    }

    private void f(RelativeLayout relativeLayout) {
        this.s = new ImageView(this.t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        j.g(this.s, "iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MUVBRDQ1QjczNTA2MTFFNUFGNTk5NTgwNjE0RTM2MzYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MUVBRDQ1QjgzNTA2MTFFNUFGNTk5NTgwNjE0RTM2MzYiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDoxRUFENDVCNTM1MDYxMUU1QUY1OTk1ODA2MTRFMzYzNiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDoxRUFENDVCNjM1MDYxMUU1QUY1OTk1ODA2MTRFMzYzNiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PtvEHoEAAAa+SURBVHja7F1NTFxV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");
        e(this.s, 8);
        this.s.setContentDescription(null);
        this.s.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(this.s, layoutParams);
    }

    public void k() {
        if (this.f15075a.a()) {
            this.f15075a.b();
        } else {
            this.f15075a.d();
        }
        Q();
    }

    public void l(int i2) {
        View view;
        LinearLayout linearLayout;
        if (i2 == 3) {
            e(this.o, 0);
            view = this.s;
        } else {
            if (i2 == 5) {
                e(this.p, 0);
                e(this.s, 8);
                linearLayout = this.o;
                e(linearLayout, 8);
            }
            if (i2 != 7) {
                return;
            }
            e(this.s, 0);
            view = this.o;
        }
        e(view, 8);
        linearLayout = this.p;
        e(linearLayout, 8);
    }

    private void m(RelativeLayout relativeLayout) {
        z(relativeLayout);
        f(relativeLayout);
        u(relativeLayout);
        q(relativeLayout);
        x(relativeLayout);
        E();
        this.f15080f = new StringBuilder();
        this.f15081g = new Formatter(this.f15080f, Locale.getDefault());
    }

    private String p(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        this.f15080f.setLength(0);
        return (i6 > 0 ? this.f15081g.format("%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)) : this.f15081g.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4))).toString();
    }

    private void q(RelativeLayout relativeLayout) {
        this.o = new LinearLayout(this.t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.o.setBackgroundColor(Color.parseColor("#ff000000"));
        this.o.setGravity(17);
        this.o.setOrientation(1);
        e(this.o, 8);
        ProgressBar progressBar = new ProgressBar(this.t);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.martian.ttbook.b.a.k.b.b(this.t, 36.0d), com.martian.ttbook.b.a.k.b.b(this.t, 36.0d));
        progressBar.setBackgroundColor(0);
        RotateDrawable rotateDrawable = new RotateDrawable();
        if (Build.VERSION.SDK_INT >= 21) {
            rotateDrawable.setDrawable(j.b(getResources(), "iVBORw0KGgoAAAANSUhEUgAAAG4AAABuCAMAAADxhdbJAAAAYFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////98JRy6AAAAIHRSTlMAswGsBQsCFXilf3KFJR+WVqGKj2YtnE88D19rNEdCsCgMELYAAAU2SURBVGjetNbd0powEAbgd4GgYEIDiIgGuP+7rAedadkknxC2z6kzuNm/BIcos9j7TXf9h76+7TJM+D8KY+sH+Sr9cgqyprnOKW7V40XuXIte6at+FMnr5V7RPvnV4CRT0xGdy5Cuqemo3iHR9F4pQd0gQTZXlGZ9Fcc7RFO6XwbHPCs6Y7Ul9ivedJae9ieyo/Nag32aliTkDnsMOcXl/c0uznwMz8W+ux836YzvXB5fxNYUfFya+RrvqhHfuDU2vYtCWOFusRBtWibz1wU/UWObcr4mmJjKKnxTzA8KeSLuEopxvSvsUY45+XITj7AnX2f2z+s1lJpoGd6B4MYMB7gqEG+BoCd5HgbHTB157uFU+JFpBSZp3Tr4Mk3crUCCkbhWwTP7SciQZFmJeYObKj/lqfzIh69decuQzBLTs481PAG6wAl3YmZs1HwCFM4oNf/eJnrjr55zpvan49XeIj9rWNnxyn8qx/cOq6xE+ZZoW+YNzlMP1px/f8lp4wUJfAWbyFhWCiK6yGrR/IEhY2CnKP407bqtnIKQLngxzLxyUhxbi8Ghu0BKtm3ONsNHse1LDTk20JsD3zZisktgV1neKIJ6+tfVL52GpNe2ePhoY8tZfvQmQPFyCuJt6HgAeQlRHU/dwva2rDt/bVk2+ZL4xqr5XWchy/HcXdmdK6vZviB4MR1kTdtG5GNnIKukDSBnfydse5eW4IMorKJ/qd+919uSojAQgOFsOK6QIEgGEND3f8vt7jQTYnZcD3H/qhnnaj67Q8ry09N5H3lX+eGz8x/8TojO401sbrz5LC33h5mM8aDwy0mTCjEnOy0ZImtSTs0vrtVSiGOSXL+1pI/Oyaziz/IiB+6SQFcowQ6xOaxY+37QeY6cSfa1MjLHgWW5gqFrQhUf5kQLlAMvH+Fym4AO1uJfVVwt5I7W4do0LsfxLqGFoatFl9gct3EZY/xSxdcch9XJvt9ZfI49QQ2elqzxOU5Q2p+uSeNrzNm6b4oaPzUcN2ya9bo8kpb/nZt+A+Vq10gaFXKiwsnYgpopBpfbQk0YhFhDcI4xXApZkC+dq2YNMMrE0NjjxK7F175Ob6+TMAbxRXrvpfa8r69KRtFcwsu0LXGsfTXHt7T8VsuFX+kw1JpmfEfLsiwYzku3DiPvtLyjpehlwXCuI1mMIQfe67MxuJEiKO1IYw86da/tExzL0R8E5iJMeRhy3Spf0KZsYm4jUQsbNsvuErjunD2rZRNEniN/2HkJDGI8HFbq545tKgr2XD+taKob7tTQcDW0pk+MVmATFWhh+uQ48GryKvXoqRVb1rPivXdrWMN4vMPhcNYPYVrrwhdJu9dIGnvMIajkP9aolVI7b9pAcb8VNMYcV5blPE53BlPGGPL8AUMt9JjjZR6Iw6rzWIQ3SGbaLMtiIMs5EbQH7u3YgYQ/EGgUcdA8jErb/wIXuNDKjBR6xKm999CllQYhq0GOI6/v+zN0hIZ1XS8Xy7G3DcjaY+lDRxgdXe005OYdNwC395TnpY9f1544G2rklRuHEcfzBeNBoD2eXOtuw3zOH484ApnbvEmKp1JlHXiWY4+43T4NcyRm4tmyoXZHx5w/HoM8H07HIizyhfSMHuZz/HRunH98Bkd7LblUB5s/3S0HoOMKKV4uZbCkNg5B4vzjQw32+Fa56W+32d/MBxpzRS7er1gr9pij3NOyjiNyapIiTrka5j03g8beAAGGW4zaZIbZPSvgQXaXi8qk+ESZXsbheO7tfMfhsqgiE/+h9MV5/gCFR4YPq8+2SgAAAABJRU5ErkJggg=="));
            rotateDrawable.setFromDegrees(0.0f);
            rotateDrawable.setPivotX(0.5f);
            rotateDrawable.setPivotY(0.5f);
            rotateDrawable.setToDegrees(360.0f);
        }
        progressBar.setIndeterminateDrawable(rotateDrawable);
        try {
            Field declaredField = progressBar.getClass().getDeclaredField("mDuration");
            declaredField.setAccessible(true);
            declaredField.setInt(progressBar, 1000);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.o.addView(progressBar, layoutParams2);
        TextView textView = new TextView(this.t);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.martian.ttbook.b.a.k.b.b(this.t, 10.0d);
        textView.setText("加载中...");
        textView.setTextColor(-1);
        com.martian.ttbook.b.a.k.b.c(textView, 13);
        this.o.addView(textView, layoutParams3);
        relativeLayout.addView(this.o, layoutParams);
    }

    private void u(RelativeLayout relativeLayout) {
        this.r = new RelativeLayout(this.t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.r.setBackgroundColor(Color.parseColor("#7f000000"));
        this.r.setGravity(16);
        ProgressBar B = B(this.r);
        this.f15082h = B;
        if (B != null) {
            B.setMax(1000);
        }
        relativeLayout.addView(this.r, layoutParams);
    }

    private void x(RelativeLayout relativeLayout) {
        this.p = new LinearLayout(this.t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.p.setBackgroundColor(Color.parseColor("#ff000000"));
        this.p.setGravity(17);
        this.p.setOrientation(1);
        e(this.p, 8);
        ImageView imageView = new ImageView(this.t);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        j.g(imageView, "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");
        this.p.addView(imageView, layoutParams2);
        TextView textView = new TextView(this.t);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.martian.ttbook.b.a.k.b.b(this.t, 10.0d);
        textView.setText("出错了!");
        textView.setTextColor(-1);
        com.martian.ttbook.b.a.k.b.c(textView, 13);
        this.p.addView(textView, layoutParams3);
        relativeLayout.addView(this.p, layoutParams);
    }

    public void y() {
        e(this.s, 8);
        e(this.p, 8);
        e(this.o, 8);
    }

    private void z(RelativeLayout relativeLayout) {
        this.q = new LinearLayout(this.t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.martian.ttbook.b.a.k.b.b(this.t, 50.0d));
        layoutParams.addRule(10);
        this.q.setBackgroundColor(Color.parseColor("#7f000000"));
        this.q.setOrientation(0);
        I();
        relativeLayout.addView(this.q, layoutParams);
        e(this.q, t() == h.f15091b ? 8 : 0);
    }

    protected ProgressBar B(RelativeLayout relativeLayout) {
        throw null;
    }

    public void C() {
        this.u.sendEmptyMessage(4);
    }

    public boolean G() {
        return this.f15076b;
    }

    protected void I() {
        this.n = new ImageButton(this.t);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.martian.ttbook.b.a.k.b.b(this.t, 50.0d), -1);
        e(this.n, 4);
        j.g(this.n, "iVBORw0KGgoAAAANSUhEUgAAABcAAAAmCAMAAAAY0vCaAAAAVFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////8wXzyWAAAAG3RSTlMAD2P8Zsv2YPDGHOjghC4n13A2zExGPqufFQQwMkirAAAAeElEQVQoz7XM2Q5AMBCF4VFULbXv8/7vSSQiY6aEcC6/PznANg3a2JlxUuI6KzNmZ85wm5EZR8LFzo1HOL3mkHD+iGvzhHsHa5G7G44JtzLnvshgCXOvDqI/6hQUvg7Bj8H/LETvg3IEXThCBSxQp8EkwNaWOq5hAY/EHeIxvlzAAAAAAElFTkSuQmCC");
        this.n.setContentDescription("返回");
        this.n.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.n.setBackgroundColor(Color.parseColor("#00000000"));
        this.q.addView(this.n, layoutParams);
        this.k = new TextView(this.t);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.martian.ttbook.b.a.k.b.b(this.t, 50.0d);
        this.k.setEllipsize(TextUtils.TruncateAt.END);
        this.k.setGravity(17);
        this.k.setPadding(com.martian.ttbook.b.a.k.b.b(this.t, 30.0d), 0, com.martian.ttbook.b.a.k.b.b(this.t, 30.0d), 0);
        this.k.setSingleLine(true);
        this.k.setTextColor(Color.parseColor("#ffffff"));
        com.martian.ttbook.b.a.k.b.c(this.k, 18);
        this.q.addView(this.k, layoutParams2);
    }

    public void L() {
        c(3000);
    }

    public void M() {
        this.u.sendEmptyMessage(7);
    }

    public void N() {
        this.u.sendEmptyMessage(5);
    }

    public void O() {
        this.u.sendEmptyMessage(3);
    }

    public void c(int i2) {
        if (!this.f15076b) {
            K();
            ImageButton imageButton = this.l;
            if (imageButton != null) {
                imageButton.requestFocus();
            }
            b();
            this.f15076b = true;
        }
        Q();
        P();
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        h t = t();
        h hVar = h.f15091b;
        if (t != hVar) {
            e(this.q, 0);
        } else {
            e(this.q, 8);
        }
        if (o() != hVar) {
            e(this.r, 0);
        } else {
            e(this.r, 8);
        }
        this.u.sendEmptyMessage(2);
        Message obtainMessage = this.u.obtainMessage(1);
        if (i2 != 0) {
            this.u.removeMessages(1);
            this.u.sendMessageDelayed(obtainMessage, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
            if (z) {
                k();
                c(3000);
                ImageButton imageButton = this.l;
                if (imageButton != null) {
                    imageButton.requestFocus();
                }
            }
            return true;
        }
        if (keyCode == 126) {
            if (z && !this.f15075a.a()) {
                this.f15075a.d();
                Q();
                c(3000);
            }
            return true;
        }
        if (keyCode == 86 || keyCode == 127) {
            if (z && this.f15075a.a()) {
                this.f15075a.b();
                Q();
                c(3000);
            }
            return true;
        }
        if (keyCode == 25 || keyCode == 24 || keyCode == 164 || keyCode == 27) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode != 4 && keyCode != 82) {
            c(3000);
            return super.dispatchKeyEvent(keyEvent);
        }
        if (z) {
            w();
        }
        return true;
    }

    public void g(g gVar) {
        this.f15075a = gVar;
        Q();
    }

    protected void i(boolean z) {
        this.f15079e = z;
        R();
        P();
    }

    protected h o() {
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            c(0);
            this.v = false;
        } else if (action != 1) {
            if (action == 3) {
                w();
            }
        } else if (!this.v) {
            this.v = false;
            c(3000);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        c(3000);
        return false;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        ImageButton imageButton;
        ImageButton imageButton2 = this.l;
        if (imageButton2 != null) {
            imageButton2.setEnabled(z);
        }
        ProgressBar progressBar = this.f15082h;
        if (progressBar != null) {
            progressBar.setEnabled(z);
        }
        if (this.f15078d && (imageButton = this.m) != null) {
            imageButton.setEnabled(z);
        }
        ImageButton imageButton3 = this.n;
        if (imageButton3 != null) {
            imageButton3.setEnabled(true);
        }
    }

    protected h t() {
        throw null;
    }

    public void w() {
        if (this.f15076b) {
            h o = o();
            h hVar = h.f15093d;
            if (o == hVar) {
                this.u.removeMessages(2);
                e(this.r, 8);
            }
            if (t() == hVar) {
                e(this.q, 8);
            }
            this.f15076b = false;
        }
    }
}

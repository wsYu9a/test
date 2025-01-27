package com.aggmoread.sdk.z.b.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.RotateDrawable;
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
import com.aggmoread.sdk.z.b.m.j;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.lang.reflect.Field;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes.dex */
public class a extends FrameLayout {
    private View.OnClickListener A;
    private View.OnClickListener B;
    private View.OnClickListener C;

    /* renamed from: a */
    private g f4905a;

    /* renamed from: b */
    private boolean f4906b;

    /* renamed from: c */
    private boolean f4907c;

    /* renamed from: d */
    private boolean f4908d;

    /* renamed from: e */
    private boolean f4909e;

    /* renamed from: f */
    private StringBuilder f4910f;

    /* renamed from: g */
    private Formatter f4911g;

    /* renamed from: h */
    private ProgressBar f4912h;

    /* renamed from: i */
    private TextView f4913i;

    /* renamed from: j */
    private TextView f4914j;

    /* renamed from: k */
    private TextView f4915k;

    /* renamed from: l */
    private ImageButton f4916l;

    /* renamed from: m */
    private ImageButton f4917m;

    /* renamed from: n */
    private ImageButton f4918n;

    /* renamed from: o */
    private LinearLayout f4919o;

    /* renamed from: p */
    private LinearLayout f4920p;

    /* renamed from: q */
    private LinearLayout f4921q;

    /* renamed from: r */
    private RelativeLayout f4922r;

    /* renamed from: s */
    private ImageView f4923s;

    /* renamed from: t */
    protected Context f4924t;

    /* renamed from: u */
    private TextView f4925u;

    /* renamed from: v */
    private h f4926v;

    /* renamed from: w */
    private Handler f4927w;

    /* renamed from: x */
    boolean f4928x;

    /* renamed from: y */
    private View.OnTouchListener f4929y;

    /* renamed from: z */
    private View.OnClickListener f4930z;

    /* renamed from: com.aggmoread.sdk.z.b.t.a$a */
    public class C0098a implements Handler.Callback {
        public C0098a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            a aVar;
            int i10;
            switch (message.what) {
                case 1:
                    a.this.e();
                    return false;
                case 2:
                    int k10 = a.this.k();
                    if (a.this.f4907c || a.this.f4905a == null || !a.this.f4905a.a()) {
                        return false;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    a.this.f4927w.sendMessageDelayed(obtain, 1000 - (k10 % 1000));
                    return false;
                case 3:
                    a.this.l();
                    aVar = a.this;
                    i10 = 3;
                    break;
                case 4:
                case 6:
                case 8:
                    a.this.e();
                    a.this.f();
                    return false;
                case 5:
                    a.this.l();
                    aVar = a.this;
                    i10 = 5;
                    break;
                case 7:
                    aVar = a.this;
                    i10 = 7;
                    break;
                default:
                    return false;
            }
            aVar.c(i10);
            return false;
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a.this.f4906b) {
                return false;
            }
            a.this.e();
            a.this.f4928x = true;
            return true;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f4905a != null) {
                a.this.b();
                a.this.b(3000);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f4909e = !r2.f4909e;
            a.this.r();
            a.this.p();
            a.this.f4905a.a(a.this.f4909e);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f4909e) {
                a.this.f4909e = false;
                a.this.r();
                a.this.p();
                a.this.f4905a.a(false);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f();
            a.this.f4905a.d();
        }
    }

    public interface g {
        void a(boolean z10);

        boolean a();

        void b();

        boolean c();

        void d();

        int e();

        int f();

        int g();
    }

    public interface h {
        void a(float f10);
    }

    public static final class i extends Enum<i> {

        /* renamed from: b */
        public static final i f4937b = new i("SHOW_NEVER", 0);

        /* renamed from: c */
        public static final i f4938c = new i("SHOW_ALWAYS", 1);

        /* renamed from: d */
        public static final i f4939d = new i("SHOW_VISIBLE_OR_GONE", 2);

        private i(String str, int i10) {
            super(str, i10);
        }
    }

    public a(Context context) {
        super(context);
        this.f4906b = true;
        this.f4908d = true;
        this.f4909e = false;
        i iVar = i.f4939d;
        this.f4927w = new Handler(new C0098a());
        this.f4928x = false;
        this.f4929y = new b();
        this.f4930z = new c();
        this.A = new d();
        this.B = new e();
        this.C = new f();
        a(context);
    }

    public void b() {
        if (this.f4905a.a()) {
            this.f4905a.b();
        } else {
            this.f4905a.d();
        }
        q();
    }

    public void f() {
        a(this.f4923s, 8);
        a(this.f4920p, 8);
        a(this.f4919o, 8);
    }

    private void h() {
        ImageButton imageButton = this.f4916l;
        if (imageButton != null) {
            imageButton.requestFocus();
            this.f4916l.setOnClickListener(this.f4930z);
        }
        if (this.f4908d) {
            ImageButton imageButton2 = this.f4917m;
            if (imageButton2 != null) {
                a(imageButton2, 0);
                this.f4917m.setOnClickListener(this.A);
            }
        } else {
            a(this.f4917m, 8);
        }
        ImageView imageView = this.f4923s;
        if (imageView != null) {
            imageView.setOnClickListener(this.C);
        }
        ImageButton imageButton3 = this.f4918n;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this.B);
        }
    }

    public int k() {
        g gVar = this.f4905a;
        if (gVar == null || this.f4907c) {
            return 0;
        }
        int f10 = gVar.f();
        int e10 = this.f4905a.e();
        if (this.f4912h != null) {
            if (e10 > 0) {
                float f11 = f10 / e10;
                h hVar = this.f4926v;
                if (hVar != null) {
                    hVar.a(f11);
                }
                this.f4912h.setProgress((int) (f11 * 1000.0f));
            }
            this.f4912h.setSecondaryProgress(this.f4905a.g() * 10);
        }
        TextView textView = this.f4913i;
        if (textView != null) {
            textView.setText(d(e10));
        }
        TextView textView2 = this.f4914j;
        if (textView2 != null) {
            textView2.setText(d(f10));
        }
        return f10;
    }

    public void p() {
        a(this.f4918n, this.f4909e ? 0 : 4);
    }

    private void q() {
        ImageButton imageButton;
        String str;
        Log.e("ApiMediaControllerTAG", "updatePausePlay");
        g gVar = this.f4905a;
        if (gVar == null || !gVar.a()) {
            imageButton = this.f4916l;
            str = "iVBORw0KGgoAAAANSUhEUgAAADgAAAA4CAMAAACfWMssAAAAQlBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////8IX9KGAAAAFXRSTlMAtPD8DgOeNOO+Vicd26l5PsqEYoeGu3ayAAAAlElEQVRIx+3VuxpFMBREYQkSDuduv/+r0k09q0CR6f9mybd1bW0Xr+Z5RbBE5AeBKY69Bghj+kAY/W9kMOK7QBj5j6AamVCNCIx+GwFUIwDVyIBqBKAamVDvyILaTGEsZ8ME47xZnGdln6OQB6DT5UIdSwOqigFVBcACToeqGFBVLKgqJlQVAMtw4m+uTmnt2trutx1vtyP8m6K/swAAAABJRU5ErkJggg==";
        } else {
            imageButton = this.f4916l;
            str = "iVBORw0KGgoAAAANSUhEUgAAADgAAAA4BAMAAABaqCYtAAAAGFBMVEUAAAD///////////////////////////8jfp1fAAAAB3RSTlMAHvq+4MgxaI51OgAAAElJREFUOMtjGAXUAMLq5UVhIEYqkGGIJmleXl5eAmK4AxnFaJLq5UAgwMDACKKL0CTLkSXLRyVHJUcl4ZJ4MxLeLIg/844CKgAA/gibZXJbivoAAAAASUVORK5CYII=";
        }
        j.a(imageButton, str);
    }

    public void r() {
        ImageButton imageButton;
        String str;
        if (this.f4909e) {
            imageButton = this.f4917m;
            str = "iVBORw0KGgoAAAANSUhEUgAAADgAAAA4BAMAAABaqCYtAAAALVBMVEUAAAD///////////////////////////////////////////////////////+hSKubAAAADnRSTlMAiHmWyg99QwOvY/5hsQj4B2EAAADWSURBVDjLYxgFVACMCsg8JgEUSblHyDy9hyga371TQNL47h1YK4KLpFUPoRTBj5RgYGicysAGV4nQ+ozV7xUDw7onAXkIjQitIu8eMzDYvXMEa0TX+g4i+Q6hEaEVJonQiABsCMkEDMkQhKQruhyrH0LySQCaJCfIIcBQkwPRE7BY+W47A0M1iBZAk+Q4KCgoWMDAwA6kpBoYBh4gO0imgZBXCAcC4eDDDHjCUUY4sjGTCd4ERnzS1AM5IxaUqK9CEjXO7IDQipmRQFoF8GVB/Jl3FFAOAMFHuuusc6BSAAAAAElFTkSuQmCC";
        } else {
            imageButton = this.f4917m;
            str = "iVBORw0KGgoAAAANSUhEUgAAADgAAAA4CAYAAACohjseAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6NEUwNEE3ODVGODQyMTFFMzhCMTNBN0I3OUU0MDBEMDIiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6NEUwNEE3ODZGODQyMTFFMzhCMTNBN0I3OUU0MDBEMDIiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo0RTA0QTc4M0Y4NDIxMUUzOEIxM0E3Qjc5RTQwMEQwMiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo0RTA0QTc4NEY4NDIxMUUzOEIxM0E3Qjc5RTQwMEQwMiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PkG6ngcAAAJnSURBVHja7Jg7SwNBEMdzRhsLFUJa/QQWNiJopSn8CjEaEbGNyTXGZ6Px0eTy8Av4+gA2FhKwsvCBliIoKPgFrI2es7AHS7jN7e7tJiHMwJ+TdXbdnzM3s3uW67qRbraeSJcbAiIgAiIgAiIgAnax9SrMmabizX0FnYJ+JdeNgc5BM6A+js8LaAV0K7wqOYtKKAH6c4NtV3JdorIrZh8y68qm6CzIEvAbVciMe8Goj5h8B/sFfB5BiwqAF6AlhdTW/g4GwSVA34rzz+jzRDBTWl5Fr0LAeTamC84E4A4oH2J+EZTr5BQldkCfh5LzHFC23Y2+sQA8gPY5kHkNcMegdKjCI9mrlpl+dAcapONbnJ61LrCmw5lbBVnUZx5Up+M3MnuWBYyCCqBLBi4SApIHV2HgPM1R/7hJwCDxIDdCwilLdxXdA237jA/5jH35jFVBq+TN0bYjzRH0tMlE5KiJn834lXVGzpOJNkGsQJ8DoLWAvuedL7NaI0fNwi/bCIiAXQlIbgMlkC3gm6O+lpGdGGgRpHCVmPJvt7NNmIDz+7ZiB8AZg+wxkJYZn98NC45ltKer5H8kTs+QScHIuTRdLU60Zc6jyVYctmt0A+TqkmI2WuFs1AlIOVHIFHNdqpkErDMbID+nQ8CJQJI74ULD3/0xCShqjkKxcCTWbyugE6LqFTsd0NFQ2os6AXW2CXItedKwznM7L7xBVqdFQTV6jQWlI99BtoXIKCUIZzRFPwV8oqAJhWQap3N17EE5RSdBbwHRuwbFFCIYo3ObRfEdNCWzLn6yQEAEREAEREAEREAE7Fj7F2AA+Z+qB36kbeAAAAAASUVORK5CYII=";
        }
        j.a(imageButton, str);
    }

    public i c() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z10 = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
            if (z10) {
                b();
                b(3000);
                ImageButton imageButton = this.f4916l;
                if (imageButton != null) {
                    imageButton.requestFocus();
                }
            }
            return true;
        }
        if (keyCode == 126) {
            if (z10 && !this.f4905a.a()) {
                this.f4905a.d();
                q();
                b(3000);
            }
            return true;
        }
        if (keyCode == 86 || keyCode == 127) {
            if (z10 && this.f4905a.a()) {
                this.f4905a.b();
                q();
                b(3000);
            }
            return true;
        }
        if (keyCode == 25 || keyCode == 24 || keyCode == 164 || keyCode == 27) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode != 4 && keyCode != 82) {
            b(3000);
            return super.dispatchKeyEvent(keyEvent);
        }
        if (z10) {
            e();
        }
        return true;
    }

    public ProgressBar g(RelativeLayout relativeLayout) {
        throw null;
    }

    public boolean i() {
        return this.f4906b;
    }

    public void j() {
        this.f4918n = new ImageButton(this.f4924t);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 50.0d), -1);
        a(this.f4918n, 4);
        j.a(this.f4918n, "iVBORw0KGgoAAAANSUhEUgAAABcAAAAmCAMAAAAY0vCaAAAAVFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////8wXzyWAAAAG3RSTlMAD2P8Zsv2YPDGHOjghC4n13A2zExGPqufFQQwMkirAAAAeElEQVQoz7XM2Q5AMBCF4VFULbXv8/7vSSQiY6aEcC6/PznANg3a2JlxUuI6KzNmZ85wm5EZR8LFzo1HOL3mkHD+iGvzhHsHa5G7G44JtzLnvshgCXOvDqI/6hQUvg7Bj8H/LETvg3IEXThCBSxQp8EkwNaWOq5hAY/EHeIxvlzAAAAAAElFTkSuQmCC");
        this.f4918n.setContentDescription("返回");
        this.f4918n.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f4918n.setBackgroundColor(Color.parseColor("#00000000"));
        this.f4921q.addView(this.f4918n, layoutParams);
        this.f4915k = new TextView(this.f4924t);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 50.0d);
        this.f4915k.setEllipsize(TextUtils.TruncateAt.END);
        this.f4915k.setGravity(17);
        this.f4915k.setPadding(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 30.0d), 0, com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 30.0d), 0);
        this.f4915k.setSingleLine(true);
        this.f4915k.setTextColor(Color.parseColor("#ffffff"));
        com.aggmoread.sdk.z.b.m.b.a(this.f4915k, 18);
        this.f4921q.addView(this.f4915k, layoutParams2);
    }

    public void l() {
        b(3000);
    }

    public void m() {
        this.f4927w.sendEmptyMessage(7);
    }

    public void n() {
        this.f4927w.sendEmptyMessage(5);
    }

    public void o() {
        this.f4927w.sendEmptyMessage(3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            b(0);
            this.f4928x = false;
        } else if (action != 1) {
            if (action == 3) {
                e();
            }
        } else if (!this.f4928x) {
            this.f4928x = false;
            b(3000);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        b(3000);
        return false;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        ImageButton imageButton;
        ImageButton imageButton2 = this.f4916l;
        if (imageButton2 != null) {
            imageButton2.setEnabled(z10);
        }
        ProgressBar progressBar = this.f4912h;
        if (progressBar != null) {
            progressBar.setEnabled(z10);
        }
        if (this.f4908d && (imageButton = this.f4917m) != null) {
            imageButton.setEnabled(z10);
        }
        ImageButton imageButton3 = this.f4918n;
        if (imageButton3 != null) {
            imageButton3.setEnabled(true);
        }
    }

    private void a() {
        g gVar;
        try {
            if (this.f4916l == null || (gVar = this.f4905a) == null || gVar.c()) {
                return;
            }
            this.f4916l.setEnabled(false);
        } catch (IncompatibleClassChangeError unused) {
        }
    }

    public void c(int i10) {
        View view;
        LinearLayout linearLayout;
        if (i10 == 3) {
            a(this.f4919o, 0);
            view = this.f4923s;
        } else {
            if (i10 == 5) {
                a(this.f4920p, 0);
                a(this.f4923s, 8);
                linearLayout = this.f4919o;
                a(linearLayout, 8);
            }
            if (i10 != 7) {
                return;
            }
            a(this.f4923s, 0);
            view = this.f4919o;
        }
        a(view, 8);
        linearLayout = this.f4920p;
        a(linearLayout, 8);
    }

    private void f(RelativeLayout relativeLayout) {
        this.f4921q = new LinearLayout(this.f4924t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 50.0d));
        layoutParams.addRule(10);
        this.f4921q.setBackgroundColor(Color.parseColor("#7f000000"));
        this.f4921q.setOrientation(0);
        j();
        relativeLayout.addView(this.f4921q, layoutParams);
        a(this.f4921q, d() == i.f4937b ? 8 : 0);
    }

    public void b(int i10) {
        if (!this.f4906b) {
            k();
            ImageButton imageButton = this.f4916l;
            if (imageButton != null) {
                imageButton.requestFocus();
            }
            a();
            this.f4906b = true;
        }
        q();
        p();
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        i d10 = d();
        i iVar = i.f4937b;
        if (d10 != iVar) {
            a(this.f4921q, 0);
        } else {
            a(this.f4921q, 8);
        }
        if (c() != iVar) {
            a(this.f4922r, 0);
        } else {
            a(this.f4922r, 8);
        }
        this.f4927w.sendEmptyMessage(2);
        Message obtainMessage = this.f4927w.obtainMessage(1);
        if (i10 != 0) {
            this.f4927w.removeMessages(1);
            this.f4927w.sendMessageDelayed(obtainMessage, i10);
        }
    }

    public i d() {
        throw null;
    }

    public void e() {
        if (this.f4906b) {
            i c10 = c();
            i iVar = i.f4939d;
            if (c10 == iVar) {
                this.f4927w.removeMessages(2);
                a(this.f4922r, 8);
            }
            if (d() == iVar) {
                a(this.f4921q, 8);
            }
            this.f4906b = false;
        }
    }

    public void g() {
        this.f4927w.sendEmptyMessage(4);
    }

    private void b(RelativeLayout relativeLayout) {
        f(relativeLayout);
        a(relativeLayout);
        d(relativeLayout);
        c(relativeLayout);
        e(relativeLayout);
        h();
        this.f4910f = new StringBuilder();
        this.f4911g = new Formatter(this.f4910f, Locale.getDefault());
    }

    private void c(RelativeLayout relativeLayout) {
        this.f4919o = new LinearLayout(this.f4924t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f4919o.setBackgroundColor(Color.parseColor("#ff000000"));
        this.f4919o.setGravity(17);
        this.f4919o.setOrientation(1);
        a(this.f4919o, 8);
        ProgressBar progressBar = new ProgressBar(this.f4924t);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 36.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 36.0d));
        progressBar.setBackgroundColor(0);
        RotateDrawable rotateDrawable = new RotateDrawable();
        rotateDrawable.setDrawable(j.a(getResources(), "iVBORw0KGgoAAAANSUhEUgAAAG4AAABuCAMAAADxhdbJAAAAYFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////98JRy6AAAAIHRSTlMAswGsBQsCFXilf3KFJR+WVqGKj2YtnE88D19rNEdCsCgMELYAAAU2SURBVGjetNbd0powEAbgd4GgYEIDiIgGuP+7rAedadkknxC2z6kzuNm/BIcos9j7TXf9h76+7TJM+D8KY+sH+Sr9cgqyprnOKW7V40XuXIte6at+FMnr5V7RPvnV4CRT0xGdy5Cuqemo3iHR9F4pQd0gQTZXlGZ9Fcc7RFO6XwbHPCs6Y7Ul9ivedJae9ieyo/Nag32aliTkDnsMOcXl/c0uznwMz8W+ux836YzvXB5fxNYUfFya+RrvqhHfuDU2vYtCWOFusRBtWibz1wU/UWObcr4mmJjKKnxTzA8KeSLuEopxvSvsUY45+XITj7AnX2f2z+s1lJpoGd6B4MYMB7gqEG+BoCd5HgbHTB157uFU+JFpBSZp3Tr4Mk3crUCCkbhWwTP7SciQZFmJeYObKj/lqfzIh69decuQzBLTs481PAG6wAl3YmZs1HwCFM4oNf/eJnrjr55zpvan49XeIj9rWNnxyn8qx/cOq6xE+ZZoW+YNzlMP1px/f8lp4wUJfAWbyFhWCiK6yGrR/IEhY2CnKP407bqtnIKQLngxzLxyUhxbi8Ghu0BKtm3ONsNHse1LDTk20JsD3zZisktgV1neKIJ6+tfVL52GpNe2ePhoY8tZfvQmQPFyCuJt6HgAeQlRHU/dwva2rDt/bVk2+ZL4xqr5XWchy/HcXdmdK6vZviB4MR1kTdtG5GNnIKukDSBnfydse5eW4IMorKJ/qd+919uSojAQgOFsOK6QIEgGEND3f8vt7jQTYnZcD3H/qhnnaj67Q8ry09N5H3lX+eGz8x/8TojO401sbrz5LC33h5mM8aDwy0mTCjEnOy0ZImtSTs0vrtVSiGOSXL+1pI/Oyaziz/IiB+6SQFcowQ6xOaxY+37QeY6cSfa1MjLHgWW5gqFrQhUf5kQLlAMvH+Fym4AO1uJfVVwt5I7W4do0LsfxLqGFoatFl9gct3EZY/xSxdcch9XJvt9ZfI49QQ2elqzxOU5Q2p+uSeNrzNm6b4oaPzUcN2ya9bo8kpb/nZt+A+Vq10gaFXKiwsnYgpopBpfbQk0YhFhDcI4xXApZkC+dq2YNMMrE0NjjxK7F175Ob6+TMAbxRXrvpfa8r69KRtFcwsu0LXGsfTXHt7T8VsuFX+kw1JpmfEfLsiwYzku3DiPvtLyjpehlwXCuI1mMIQfe67MxuJEiKO1IYw86da/tExzL0R8E5iJMeRhy3Spf0KZsYm4jUQsbNsvuErjunD2rZRNEniN/2HkJDGI8HFbq545tKgr2XD+taKob7tTQcDW0pk+MVmATFWhh+uQ48GryKvXoqRVb1rPivXdrWMN4vMPhcNYPYVrrwhdJu9dIGnvMIajkP9aolVI7b9pAcb8VNMYcV5blPE53BlPGGPL8AUMt9JjjZR6Iw6rzWIQ3SGbaLMtiIMs5EbQH7u3YgYQ/EGgUcdA8jErb/wIXuNDKjBR6xKm999CllQYhq0GOI6/v+zN0hIZ1XS8Xy7G3DcjaY+lDRxgdXe005OYdNwC395TnpY9f1544G2rklRuHEcfzBeNBoD2eXOtuw3zOH484ApnbvEmKp1JlHXiWY4+43T4NcyRm4tmyoXZHx5w/HoM8H07HIizyhfSMHuZz/HRunH98Bkd7LblUB5s/3S0HoOMKKV4uZbCkNg5B4vzjQw32+Fa56W+32d/MBxpzRS7er1gr9pij3NOyjiNyapIiTrka5j03g8beAAGGW4zaZIbZPSvgQXaXi8qk+ESZXsbheO7tfMfhsqgiE/+h9MV5/gCFR4YPq8+2SgAAAABJRU5ErkJggg=="));
        rotateDrawable.setFromDegrees(0.0f);
        rotateDrawable.setPivotX(0.5f);
        rotateDrawable.setPivotY(0.5f);
        rotateDrawable.setToDegrees(360.0f);
        progressBar.setIndeterminateDrawable(rotateDrawable);
        try {
            Field declaredField = progressBar.getClass().getDeclaredField("mDuration");
            declaredField.setAccessible(true);
            declaredField.setInt(progressBar, 1000);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f4919o.addView(progressBar, layoutParams2);
        this.f4925u = new TextView(this.f4924t);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 10.0d);
        this.f4925u.setText("加载中...");
        this.f4925u.setTextColor(-1);
        com.aggmoread.sdk.z.b.m.b.a(this.f4925u, 13);
        this.f4919o.addView(this.f4925u, layoutParams3);
        relativeLayout.addView(this.f4919o, layoutParams);
    }

    private String d(int i10) {
        int i11 = i10 / 1000;
        int i12 = i11 % 60;
        int i13 = (i11 / 60) % 60;
        int i14 = i11 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        this.f4910f.setLength(0);
        return (i14 > 0 ? this.f4911g.format("%d:%02d:%02d", Integer.valueOf(i14), Integer.valueOf(i13), Integer.valueOf(i12)) : this.f4911g.format("%02d:%02d", Integer.valueOf(i13), Integer.valueOf(i12))).toString();
    }

    private void e(RelativeLayout relativeLayout) {
        this.f4920p = new LinearLayout(this.f4924t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f4920p.setBackgroundColor(Color.parseColor("#ff000000"));
        this.f4920p.setGravity(17);
        this.f4920p.setOrientation(1);
        a(this.f4920p, 8);
        ImageView imageView = new ImageView(this.f4924t);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        j.a(imageView, "iVBORw0KGgoAAAANSUhEUgAAACkAAAApCAYAAACoYAD2AAAJnklEQVR4XsWZa2xUxxXH72vv7tq7Xr8fsbG9BoNZG69doAFTEsdVoj4SiqqSxCS4RpC2IVGpVNKESNAgtVU+tLQVVQkvY2M7JoSqoVCprRoh8WiIBDEmhRjFmJq08eIHBNvg9X3s7f9c5q4We3fxQxEj/TVa78y9vz1z5pyZY37Xnr3cg2w/WL/uvmOEGQC4oWroJ9BvocPQX6HjrD/M/r6RjcP46TVpGnCLoJUczz/M87wEcabuBUggGRyXZhhGBbQS0jjDOAuAP0FnvyzIUuhlXhBKCEoQBE4URbO3Po9voVAIXAb1JAlaQjJCoU4A/AG6OBnIyfikDG0A3AqA8AQmSQQncunpaaGc7OxQRnq6npSUFLLLskHguq5ziqLwQ8PDQv/AgBAIXBep13WN0zSdvidoA7B/AcMf4ZfKTCCzAPcrWKpIkiSOZLfbuSJvoTavuFh1uVxkkXPQJegzaLjt0LtjtU+vkpkP5kHzoYW379zxfdrVJXdd6RaDwSCvaQCGYOluwG4GaN90IAsEUdwO66XabDYTMC83V/9Khf92YmLi3wDwXuvBd3qZVehlpqxm+Srmm3q+9tkMAKwYHR19sr3jgrvn2jWRIFVVpfmDIV3/KUB7pgKZIUrSWwQoyzJHkJV+v1I8Z/a/ALCz+e22Ph0v0AkOIjQTEAq3iA3Fk/+SsBJrVtemAuCFq//pqTn70Ufy2NiYBXoDz/wRQPsnAykDcBceWmh3ODhAGlVLHh6F7+1saWs7pqlYJmY9BjU5RWw2m02CZWu/3tffv/H0B2dcsC6vABY/+ipAfwhQNe7uBuBLAgMkCy5buuR2dlbW1gOtre0qAEPMelNutMuZa5DwvPfrnnsu8LWqpb84ceq0hwwGq3o5vB8Yv4sdzHnehyV6iuDoF5eXlQYBuKWppbVdUVTaleMBpwPLdr/KNTa3XERk2Aw/HyWfp/fy8Nvd+xpKYkI6HI5NAORpQlZmpl48Z85OAJ5XFYWsEGt5p21VDb6I1uktLNyel/uQboLKMg+OV6JCwrkXYhm8LNTAimXnYdWjzKm5L6FFPvf9stLSUzCQQaDgKNrTsL9yAiRi3lqCo2XOn5WnpqQkb29obDKiAC6ANkM/g2ZPkscLbWLzKqMBJ7ndO7wFBQq9nzjcblddGJJZ0Y0M4SNIarPy8k43Hmj+XJ+4g5dj7O+xsZ6Avol5bwGg/D6AJRi3G+O/TfMw5zdgeiwK52B+/qy/ozchlTGlHNZMDEO6Xa6loiiAVaBfYCDcNGvjNwlCSEJCwjqbJPG080kSGlagPh4hfU/jrDk0PyEx8QV63viWnpbWlpqSEiIOATEQc5eYkDTY4XRWUy6mlpaadhNW7GbZI4LRhMyQkRbtEXK73fmwTlRA+rvH4ymIHC9DDrs9lZ4XpQVSkpOvEwfxOJ3OGhOSDZ5tnWKcDselaLGQIAsLC0ZglHDKI//xegsHo76QzcHO7ce48BzMpzkjMSDJEB3UEw/IiixISkse6sl6dof9Qgh9tBdWlJf/2VdSoiY4nQbyt1HhL1fLfL53uTjNN7/kcGWFX3FhvBPz8FlFin0vFqTT6ThHHCaXpiUTgAQ4Cq42kLNsYnQZUSDJshhzqKzUJ0KPA0CDjiIg/zPaeBL9Hd+fqF/zfNLcOXO+AwYb9A/oYKykgJ3xKUGCB1yafBfybrwS2HIDhB+IBknW3dfYFELebRVFqdVgmYNOMvEg6XskhGNY8mN3DaJxZnqNMQc7vO/0mTNWzOfDuZuCKDqe4HqufcbHS2dkAV7QLOsSfOxMxE7llLE0QZjUnIamAzzcggBMn78HEn7JM9/LRHctFqgJFTMDzXwOzgrZt4aGiIOTbbZQOE5iIygWh6IqxdwDbFjNeaynna6EIbFTb1o7SlNU/4OEhHssjAhHX5iQ5BnJHk+3BXAnGPQR7BRaGrQCeg3aAe1iN8Et0PegvKlA4kzpt96PwN5FvUQWzMnJPn6ps3MZwSGHu9GXAL7zPnC50HqYfzmCrcizq23EspVik9TAHzfgw3kA7IUuxQPc27A/HxkpnTITsTyUk3PctCRBIl9+mJmRoVkXJ1dCwtr7AK4CVKMgitXYdGJk2sNZ8G7PPuN7XpSkSown626IVzVBwK+zslNOdpaanOz50LIkbfuRmurqi9f7+vyUtnDlXAwILyxxdRwc5bZNsNy3aJxko6OdxNF9G8B0eAgPpAMKXdYURA1NU+m+jV5bBZ/LgWV/Tu4XCYjTeI5DlqttsCIa3Uw7yPtMSCuWFRbkN3VdufLrGzdvCpIo8rzd/mpwdPRFWjmLECCLFpSV5uEoN5bkTjLsdtmApShojkI6663mhETqEd6kMSoWDA3xvb296bjSLsPJ/GQkJKz+Cgwj0kqmpaaGCgsKWu65LeJL837xjSce34VL0VyCBiBZYx8e1hJRAatkvvhfqBcaevudQwCL31Y/8zQBJ0E5bP4NWO4DMhBV1XBuXIlV2MiOf9zyZVWdiJcvRkJat0RuXf33S861t++40n1VomvDWDBoAHQrHnYq8krKM/OG0yH6OFdZ1vHheXrklZjnFwHwTZtsE2XZzs0u8moLKytfBtLlCVdaTKLDQOfqZ585Mjh447tYdp4uRYaivIGHbgPISZaLGZcx5Xt3lNC2GD/6l7AebGSjUGjgbnXEApwAiU1CAJSK9qAYUHr8xMl5IyMjlM9FaBtcYC/GtDFjTL3dW4Yh2pUAfImigwRXo6Mf3nsZn3fHLaIChHb6GI7tW5ZXVQXoDIhJVMWgqwUd+enSXsDNrOXiOW9iE/4YKyWSD+J9BvwwgJ4SgBIX0jrp7D/QPIAY9dpjjz4SQAw1Qc2YJ0nloG0AwOvQ3CnCFUG0gxsRPb4qyzbarHSvMWoefeRzLPWrIBiYdMEKIATE1detyQT0GwgZxQhPErmDDqnsDInl72FV23+z0t8XzBI2KBmaBfmgRYArIp8EoBlfyQdRANNw2r+MZd8GgP4pl/4IlJZibd0amdIfiqBPdVz4WI4shoZ0iGCZWJtY/rMiAys8oLQS8pcvUNAfZely+kVUPlwFs1HJbj6Fyt7A9flk1d5AQLSqGySDFAnI5gtMeA5ycbY+t7hYQwz8hJIMSoif4LkzL0db8ZGVX6gYSgH9SZxWFiONyn39A+KtoVvC8PAIT9BwCR7jDBn+5sId3pPkCeFcoGdlZqjwa6oKH2lpO9huVXrXr62fOSRT2CqsZg7YWsogflZ2yWeZJAFyQEGWd//HTvkfQx2obw6xmrll/Un9H+f/i++i2jSycPsAAAAASUVORK5CYII=");
        this.f4920p.addView(imageView, layoutParams2);
        TextView textView = new TextView(this.f4924t);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 10.0d);
        textView.setText("出错了!");
        textView.setTextColor(-1);
        com.aggmoread.sdk.z.b.m.b.a(textView, 13);
        this.f4920p.addView(textView, layoutParams3);
        relativeLayout.addView(this.f4920p, layoutParams);
    }

    public void a(int i10) {
        LinearLayout linearLayout = this.f4919o;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(i10);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(Context context) {
        this.f4924t = context;
        RelativeLayout relativeLayout = new RelativeLayout(this.f4924t);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(0);
        addView(relativeLayout, layoutParams);
        relativeLayout.setOnTouchListener(this.f4929y);
        b(relativeLayout);
    }

    private void d(RelativeLayout relativeLayout) {
        this.f4922r = new RelativeLayout(this.f4924t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f4922r.setBackgroundColor(Color.parseColor("#7f000000"));
        this.f4922r.setGravity(16);
        ProgressBar g10 = g(this.f4922r);
        this.f4912h = g10;
        if (g10 != null) {
            g10.setMax(1000);
        }
        relativeLayout.addView(this.f4922r, layoutParams);
    }

    private void a(View view, int i10) {
        if (view == null || view.getVisibility() == i10) {
            return;
        }
        view.setVisibility(i10);
    }

    private void a(RelativeLayout relativeLayout) {
        this.f4923s = new ImageView(this.f4924t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        j.a(this.f4923s, "iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MUVBRDQ1QjczNTA2MTFFNUFGNTk5NTgwNjE0RTM2MzYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MUVBRDQ1QjgzNTA2MTFFNUFGNTk5NTgwNjE0RTM2MzYiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDoxRUFENDVCNTM1MDYxMUU1QUY1OTk1ODA2MTRFMzYzNiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDoxRUFENDVCNjM1MDYxMUU1QUY1OTk1ODA2MTRFMzYzNiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PtvEHoEAAAa+SURBVHja7F1NTFxV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");
        a(this.f4923s, 8);
        this.f4923s.setContentDescription(null);
        this.f4923s.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(this.f4923s, layoutParams);
    }

    public void a(g gVar) {
        this.f4905a = gVar;
        q();
    }

    public void a(h hVar) {
        this.f4926v = hVar;
    }

    public void a(String str) {
        if (this.f4925u == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f4925u.setText(str);
    }

    public void a(boolean z10) {
        this.f4909e = z10;
        r();
        p();
    }
}

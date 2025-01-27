package b.d.e.c.a.l;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class g extends CountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    View f4709a;

    /* renamed from: b, reason: collision with root package name */
    a f4710b;

    public interface a {
        void a();

        void a(long j2);
    }

    public g(View view, a aVar, long j2, long j3) {
        super(j2, j3);
        this.f4709a = view;
        this.f4710b = aVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f4710b.a();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        View view = this.f4709a;
        if (view instanceof TextView) {
            ((TextView) view).setText("跳过" + (j2 / 1000) + "s");
        }
        a aVar = this.f4710b;
        if (aVar != null) {
            aVar.a(j2);
        }
    }
}

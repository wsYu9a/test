package com.opos.mobad.interstitial.a;

import android.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: classes4.dex */
public class j implements DialogInterface.OnKeyListener, DialogInterface.OnShowListener, com.opos.mobad.q.a.b.b {

    /* renamed from: a */
    private d f21048a;

    /* renamed from: b */
    private Activity f21049b;

    /* renamed from: c */
    private com.opos.mobad.q.a.b.a f21050c;

    /* renamed from: com.opos.mobad.interstitial.a.j$1 */
    class AnonymousClass1 implements View.OnTouchListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return j.this.b();
        }
    }

    private void a(Activity activity) {
        d dVar = this.f21048a;
        if (dVar != null && (dVar.getContext() instanceof Activity)) {
            if (((Activity) this.f21048a.getContext()) == activity) {
                com.opos.cmn.an.f.a.b("InterstitialDialog", "same activity");
                return;
            }
            a();
        }
        int i2 = R.style.Theme.Translucent.NoTitleBar;
        if (com.opos.cmn.an.h.f.a.a(activity)) {
            i2 = R.style.Theme.Translucent.NoTitleBar.Fullscreen;
        }
        d dVar2 = new d(activity, i2);
        this.f21048a = dVar2;
        dVar2.getWindow().getDecorView().setBackgroundColor(1711276032);
        this.f21048a.setOnKeyListener(this);
        this.f21048a.setOnShowListener(this);
    }

    @Override // com.opos.mobad.q.a.b.b
    public void a() {
        if (this.f21049b == null || !this.f21048a.isShowing()) {
            com.opos.cmn.an.f.a.b("InterstitialDialog", "dismiss dialog but fail");
        } else {
            this.f21048a.dismiss();
        }
    }

    @Override // com.opos.mobad.q.a.b.b
    public void a(Activity activity, View view) {
        this.f21049b = activity;
        a(activity);
        if (view != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                view.setForceDarkAllowed(false);
            }
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.opos.mobad.interstitial.a.j.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return j.this.b();
                }
            });
            this.f21048a.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f21048a.show();
            if (i2 >= 28) {
                WindowManager.LayoutParams attributes = this.f21048a.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                this.f21048a.getWindow().setAttributes(attributes);
            }
            if (i2 >= 16) {
                int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
                int i3 = (systemUiVisibility & 1024) == 1024 ? TTAdConstant.EXT_PLUGIN_UNINSTALL : 0;
                if ((systemUiVisibility & 4) == 4) {
                    i3 = i3 | 4 | 4096;
                }
                this.f21048a.getWindow().getDecorView().setSystemUiVisibility(i3);
            }
        }
    }

    @Override // com.opos.mobad.q.a.b.b
    public void a(com.opos.mobad.q.a.b.a aVar) {
        this.f21050c = aVar;
    }

    public boolean b() {
        boolean z;
        d dVar;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterstitialDialog", "isShowing", (Throwable) e2);
        }
        if (!this.f21049b.isFinishing() && (dVar = this.f21048a) != null) {
            if (dVar.isShowing()) {
                z = true;
                com.opos.cmn.an.f.a.b("InterstitialDialog", "isShowing=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("InterstitialDialog", "isShowing=" + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003b  */
    @Override // android.content.DialogInterface.OnKeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKey(android.content.DialogInterface r5, int r6, android.view.KeyEvent r7) {
        /*
            r4 = this;
            java.lang.String r5 = ""
            java.lang.String r0 = "InterstitialDialog"
            r1 = 4
            if (r6 == r1) goto L8
            goto L21
        L8:
            boolean r1 = r4.b()     // Catch: java.lang.Exception -> L1d
            if (r1 == 0) goto L21
            int r1 = r7.getAction()     // Catch: java.lang.Exception -> L1d
            if (r1 != 0) goto L21
            com.opos.mobad.q.a.b.a r1 = r4.f21050c     // Catch: java.lang.Exception -> L1d
            if (r1 == 0) goto L1b
            r1.a()     // Catch: java.lang.Exception -> L1d
        L1b:
            r1 = 1
            goto L22
        L1d:
            r1 = move-exception
            com.opos.cmn.an.f.a.a(r0, r5, r1)
        L21:
            r1 = 0
        L22:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "dialog onKey="
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = ",keyEvent="
            r2.append(r6)
            java.lang.String r6 = r7.toString()
            if (r6 == 0) goto L3b
            goto L3c
        L3b:
            r7 = r5
        L3c:
            r2.append(r7)
            r2.append(r1)
            java.lang.String r5 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.interstitial.a.j.onKey(android.content.DialogInterface, int, android.view.KeyEvent):boolean");
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        com.opos.cmn.an.f.a.b("InterstitialDialog", "dialog show");
    }
}

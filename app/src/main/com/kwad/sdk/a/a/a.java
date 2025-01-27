package com.kwad.sdk.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;

/* loaded from: classes3.dex */
public final class a extends g {

    @SuppressLint({"StaticFieldLeak"})
    private static a aoH;

    @Nullable
    private final DialogInterface.OnDismissListener aoI;
    private final AdTemplate mAdTemplate;

    @Nullable
    private final DialogInterface.OnClickListener mOnClickListener;

    /* renamed from: com.kwad.sdk.a.a.a$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.dismiss();
            if (a.this.mOnClickListener != null) {
                a.this.mOnClickListener.onClick(a.this, -2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.a.a.a$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ AdInfo tK;

        /* renamed from: com.kwad.sdk.a.a.a$2$1 */
        public class AnonymousClass1 implements ap.a {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.ap.a
            public final void d(Throwable th2) {
                com.kwad.sdk.commercial.a.a.i(a.this.mAdTemplate, 100003, Log.getStackTraceString(th2));
            }

            @Override // com.kwad.sdk.utils.ap.a
            public final void pa() {
                com.kwad.sdk.core.adlog.c.h(a.this.mAdTemplate, 1);
                com.kwad.sdk.commercial.a.a.bf(a.this.mAdTemplate);
            }
        }

        public AnonymousClass2(AdInfo adInfo) {
            eb2 = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (a.this.mOnClickListener != null) {
                a.this.mOnClickListener.onClick(a.this, -1);
            }
            ap.a(com.kwad.sdk.core.download.a.H(eb2), new ap.a() { // from class: com.kwad.sdk.a.a.a.2.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.ap.a
                public final void d(Throwable th2) {
                    com.kwad.sdk.commercial.a.a.i(a.this.mAdTemplate, 100003, Log.getStackTraceString(th2));
                }

                @Override // com.kwad.sdk.utils.ap.a
                public final void pa() {
                    com.kwad.sdk.core.adlog.c.h(a.this.mAdTemplate, 1);
                    com.kwad.sdk.commercial.a.a.bf(a.this.mAdTemplate);
                }
            });
        }
    }

    private a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.aoI = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    public static boolean Bb() {
        a aVar = aoH;
        if (aVar == null || !aVar.isShowing()) {
            return false;
        }
        aoH.dismiss();
        return true;
    }

    public static boolean of() {
        a aVar = aoH;
        return aVar != null && aVar.isShowing();
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            DialogInterface.OnDismissListener onDismissListener = this.aoI;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
            aoH = null;
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return R.layout.ksad_install_dialog;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ksad_install_tips_content);
        TextView textView2 = (TextView) view.findViewById(R.id.ksad_install_cancel);
        TextView textView3 = (TextView) view.findViewById(R.id.ksad_install_tv);
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        String F = d.F(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate));
        if (F.equals("")) {
            F = this.mContext.getString(R.string.ksad_install_tips, com.kwad.sdk.core.response.b.a.av(eb2));
        }
        textView.setText(F);
        textView3.setText(d.Bm());
        textView2.setText(d.Bn());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.2
            final /* synthetic */ AdInfo tK;

            /* renamed from: com.kwad.sdk.a.a.a$2$1 */
            public class AnonymousClass1 implements ap.a {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.ap.a
                public final void d(Throwable th2) {
                    com.kwad.sdk.commercial.a.a.i(a.this.mAdTemplate, 100003, Log.getStackTraceString(th2));
                }

                @Override // com.kwad.sdk.utils.ap.a
                public final void pa() {
                    com.kwad.sdk.core.adlog.c.h(a.this.mAdTemplate, 1);
                    com.kwad.sdk.commercial.a.a.bf(a.this.mAdTemplate);
                }
            }

            public AnonymousClass2(AdInfo eb22) {
                eb2 = eb22;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                ap.a(com.kwad.sdk.core.download.a.H(eb2), new ap.a() { // from class: com.kwad.sdk.a.a.a.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.ap.a
                    public final void d(Throwable th2) {
                        com.kwad.sdk.commercial.a.a.i(a.this.mAdTemplate, 100003, Log.getStackTraceString(th2));
                    }

                    @Override // com.kwad.sdk.utils.ap.a
                    public final void pa() {
                        com.kwad.sdk.core.adlog.c.h(a.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.bf(a.this.mAdTemplate);
                    }
                });
            }
        });
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = aoH;
            if (aVar != null && aVar.isShowing()) {
                aoH.dismiss();
            }
            try {
                a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
                aVar2.show();
                aoH = aVar2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate Bh;
        if (activity == null || activity.isFinishing() || (Bh = c.Bg().Bh()) == null) {
            return false;
        }
        return a(activity, Bh, onDismissListener, onClickListener);
    }
}

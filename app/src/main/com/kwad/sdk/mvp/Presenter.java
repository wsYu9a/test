package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class Presenter {
    private Object aOg;
    private View mRootView;
    private final List<Presenter> aOf = new CopyOnWriteArrayList();
    private PresenterState aOh = PresenterState.INIT;

    public static abstract class PresenterState extends Enum<PresenterState> {
        private static final /* synthetic */ PresenterState[] $VALUES;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        private int mIndex;

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$1 */
        public enum AnonymousClass1 extends PresenterState {
            public AnonymousClass1(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
            }
        }

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$2 */
        public enum AnonymousClass2 extends PresenterState {
            public AnonymousClass2(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                Iterator it = presenter.aOf.iterator();
                while (it.hasNext()) {
                    try {
                        ((Presenter) it.next()).I(presenter.mRootView);
                    } catch (Exception e10) {
                        c.gatherException(e10);
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                    }
                }
            }
        }

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$3 */
        public enum AnonymousClass3 extends PresenterState {
            public AnonymousClass3(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                Iterator it = presenter.aOf.iterator();
                while (it.hasNext()) {
                    try {
                        ((Presenter) it.next()).k(presenter.aOg);
                    } catch (Throwable th2) {
                        c.gatherException(th2);
                        com.kwad.sdk.core.d.c.printStackTrace(th2);
                    }
                }
            }
        }

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$4 */
        public enum AnonymousClass4 extends PresenterState {
            public AnonymousClass4(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                Iterator it = presenter.aOf.iterator();
                while (it.hasNext()) {
                    try {
                        ((Presenter) it.next()).mM();
                    } catch (Exception e10) {
                        c.gatherException(e10);
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                    }
                }
            }
        }

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$5 */
        public enum AnonymousClass5 extends PresenterState {
            public AnonymousClass5(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                Iterator it = presenter.aOf.iterator();
                while (it.hasNext()) {
                    try {
                        ((Presenter) it.next()).destroy();
                    } catch (Exception e10) {
                        c.gatherException(e10);
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                    }
                }
            }
        }

        static {
            AnonymousClass1 anonymousClass1 = new PresenterState("INIT", 0, 0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                public AnonymousClass1(String str, int i10, int i11) {
                    super(str, i10, i11);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                }
            };
            INIT = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new PresenterState("CREATE", 1, 1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                public AnonymousClass2(String str, int i10, int i11) {
                    super(str, i10, i11);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aOf.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).I(presenter.mRootView);
                        } catch (Exception e10) {
                            c.gatherException(e10);
                            com.kwad.sdk.core.d.c.printStackTrace(e10);
                        }
                    }
                }
            };
            CREATE = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new PresenterState("BIND", 2, 2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                public AnonymousClass3(String str, int i10, int i11) {
                    super(str, i10, i11);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aOf.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).k(presenter.aOg);
                        } catch (Throwable th2) {
                            c.gatherException(th2);
                            com.kwad.sdk.core.d.c.printStackTrace(th2);
                        }
                    }
                }
            };
            BIND = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new PresenterState("UNBIND", 3, 3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                public AnonymousClass4(String str, int i10, int i11) {
                    super(str, i10, i11);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aOf.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).mM();
                        } catch (Exception e10) {
                            c.gatherException(e10);
                            com.kwad.sdk.core.d.c.printStackTrace(e10);
                        }
                    }
                }
            };
            UNBIND = anonymousClass4;
            AnonymousClass5 anonymousClass5 = new PresenterState("DESTROY", 4, 4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                public AnonymousClass5(String str, int i10, int i11) {
                    super(str, i10, i11);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aOf.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).destroy();
                        } catch (Exception e10) {
                            c.gatherException(e10);
                            com.kwad.sdk.core.d.c.printStackTrace(e10);
                        }
                    }
                }
            };
            DESTROY = anonymousClass5;
            $VALUES = new PresenterState[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5};
        }

        public /* synthetic */ PresenterState(String str, int i10, int i11, AnonymousClass1 anonymousClass1) {
            this(str, i10, i11);
        }

        public static PresenterState valueOf(String str) {
            return (PresenterState) Enum.valueOf(PresenterState.class, str);
        }

        public static PresenterState[] values() {
            return (PresenterState[]) $VALUES.clone();
        }

        public int index() {
            return this.mIndex;
        }

        public abstract void performCallState(Presenter presenter);

        private PresenterState(String str, int i10, int i11) {
            super(str, i10);
            this.mIndex = i11;
        }
    }

    private boolean Lh() {
        return this.aOh.index() >= PresenterState.CREATE.index();
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        int index = this.aOh.index();
        PresenterState presenterState = PresenterState.UNBIND;
        if (index >= presenterState.index() || presenter.aOh.index() >= presenterState.index()) {
            return;
        }
        if (Lh() && !presenter.Lh() && (view = this.mRootView) != null) {
            presenter.I(view);
        }
        if (!isBound() || !presenter.Lh() || presenter.isBound() || (obj = this.aOg) == null) {
            return;
        }
        presenter.k(obj);
    }

    private boolean isBound() {
        return this.aOh == PresenterState.BIND;
    }

    @UiThread
    public final void I(View view) {
        try {
            this.aOh = PresenterState.CREATE;
            this.mRootView = view;
            onCreate();
            this.aOh.performCallState(this);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public final List<Presenter> Li() {
        return this.aOf;
    }

    public final Object Lj() {
        return this.aOg;
    }

    public final void a(Presenter presenter) {
        this.aOf.add(presenter);
        if (!Lh() || presenter.Lh()) {
            return;
        }
        I(this.mRootView);
    }

    public void as() {
    }

    @UiThread
    public final void destroy() {
        try {
            if (this.aOh == PresenterState.BIND) {
                mM();
            }
            this.aOh = PresenterState.DESTROY;
            onDestroy();
            this.aOh.performCallState(this);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public final <T extends View> T findViewById(int i10) {
        return (T) this.mRootView.findViewById(i10);
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        return m.dH(getContext());
    }

    @NonNull
    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    public final void k(@NonNull Object obj) {
        try {
            PresenterState presenterState = this.aOh;
            if (presenterState != PresenterState.INIT) {
                PresenterState presenterState2 = PresenterState.DESTROY;
            }
            PresenterState presenterState3 = PresenterState.BIND;
            if (presenterState == presenterState3) {
                mM();
            }
            this.aOh = presenterState3;
            this.aOg = obj;
            as();
            this.aOh.performCallState(this);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @UiThread
    public final void mM() {
        try {
            this.aOh = PresenterState.UNBIND;
            onUnbind();
            this.aOh.performCallState(this);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onUnbind() {
    }

    public final void a(Presenter presenter, boolean z10) {
        this.aOf.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th2) {
            c.gatherException(th2);
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }
}

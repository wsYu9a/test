package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class Presenter {
    private Object aus;
    private View mRootView;
    private final List<Presenter> aur = new CopyOnWriteArrayList();
    private PresenterState aut = PresenterState.INIT;

    static abstract class PresenterState extends Enum<PresenterState> {
        private static final /* synthetic */ PresenterState[] $VALUES;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        private int mIndex;

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$1 */
        enum AnonymousClass1 extends PresenterState {
            AnonymousClass1(String str, int i2, int i3) {
                super(str, i2, i3);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
            }
        }

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$2 */
        enum AnonymousClass2 extends PresenterState {
            AnonymousClass2(String str, int i2, int i3) {
                super(str, i2, i3);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                Iterator it = presenter.aur.iterator();
                while (it.hasNext()) {
                    try {
                        ((Presenter) it.next()).E(presenter.mRootView);
                    } catch (Exception e2) {
                        b.gatherException(e2);
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
            }
        }

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$3 */
        enum AnonymousClass3 extends PresenterState {
            AnonymousClass3(String str, int i2, int i3) {
                super(str, i2, i3);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                Iterator it = presenter.aur.iterator();
                while (it.hasNext()) {
                    try {
                        ((Presenter) it.next()).f(presenter.aus);
                    } catch (Throwable th) {
                        b.gatherException(th);
                        com.kwad.sdk.core.d.b.printStackTrace(th);
                    }
                }
            }
        }

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$4 */
        enum AnonymousClass4 extends PresenterState {
            AnonymousClass4(String str, int i2, int i3) {
                super(str, i2, i3);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                Iterator it = presenter.aur.iterator();
                while (it.hasNext()) {
                    try {
                        ((Presenter) it.next()).jW();
                    } catch (Exception e2) {
                        b.gatherException(e2);
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
            }
        }

        /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState$5 */
        enum AnonymousClass5 extends PresenterState {
            AnonymousClass5(String str, int i2, int i3) {
                super(str, i2, i3);
            }

            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                Iterator it = presenter.aur.iterator();
                while (it.hasNext()) {
                    try {
                        ((Presenter) it.next()).destroy();
                    } catch (Exception e2) {
                        b.gatherException(e2);
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
            }
        }

        static {
            AnonymousClass1 anonymousClass1 = new PresenterState("INIT", 0, 0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                AnonymousClass1(String str, int i2, int i3) {
                    super(str, i2, i3);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                }
            };
            INIT = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new PresenterState("CREATE", 1, 1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                AnonymousClass2(String str, int i2, int i3) {
                    super(str, i2, i3);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aur.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).E(presenter.mRootView);
                        } catch (Exception e2) {
                            b.gatherException(e2);
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                }
            };
            CREATE = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new PresenterState("BIND", 2, 2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                AnonymousClass3(String str, int i2, int i3) {
                    super(str, i2, i3);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aur.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).f(presenter.aus);
                        } catch (Throwable th) {
                            b.gatherException(th);
                            com.kwad.sdk.core.d.b.printStackTrace(th);
                        }
                    }
                }
            };
            BIND = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new PresenterState("UNBIND", 3, 3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                AnonymousClass4(String str, int i2, int i3) {
                    super(str, i2, i3);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aur.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).jW();
                        } catch (Exception e2) {
                            b.gatherException(e2);
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                }
            };
            UNBIND = anonymousClass4;
            AnonymousClass5 anonymousClass5 = new PresenterState("DESTROY", 4, 4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                AnonymousClass5(String str, int i2, int i3) {
                    super(str, i2, i3);
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aur.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).destroy();
                        } catch (Exception e2) {
                            b.gatherException(e2);
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                }
            };
            DESTROY = anonymousClass5;
            $VALUES = new PresenterState[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5};
        }

        private PresenterState(String str, int i2, int i3) {
            super(str, i2);
            this.mIndex = i3;
        }

        /* synthetic */ PresenterState(String str, int i2, int i3, AnonymousClass1 anonymousClass1) {
            this(str, i2, i3);
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

        abstract void performCallState(Presenter presenter);
    }

    private boolean Bf() {
        return this.aut.index() >= PresenterState.CREATE.index();
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        int index = this.aut.index();
        PresenterState presenterState = PresenterState.UNBIND;
        if (index >= presenterState.index() || presenter.aut.index() >= presenterState.index()) {
            return;
        }
        if (Bf() && !presenter.Bf() && (view = this.mRootView) != null) {
            presenter.E(view);
        }
        if (!isBound() || !presenter.Bf() || presenter.isBound() || (obj = this.aus) == null) {
            return;
        }
        presenter.f(obj);
    }

    private boolean isBound() {
        return this.aut == PresenterState.BIND;
    }

    public final List<Presenter> Bg() {
        return this.aur;
    }

    public final Object Bh() {
        return this.aus;
    }

    @UiThread
    public final void E(View view) {
        this.aut = PresenterState.CREATE;
        this.mRootView = view;
        onCreate();
        this.aut.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.aur.add(presenter);
        if (!Bf() || presenter.Bf()) {
            return;
        }
        E(this.mRootView);
    }

    public final void a(Presenter presenter, boolean z) {
        this.aur.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            b.gatherException(th);
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    protected void ar() {
    }

    @UiThread
    public final void destroy() {
        if (this.aut == PresenterState.BIND) {
            jW();
        }
        this.aut = PresenterState.DESTROY;
        onDestroy();
        this.aut.performCallState(this);
    }

    @UiThread
    public final void f(@NonNull Object obj) {
        PresenterState presenterState = this.aut;
        if (presenterState != PresenterState.INIT) {
            PresenterState presenterState2 = PresenterState.DESTROY;
        }
        PresenterState presenterState3 = PresenterState.BIND;
        if (presenterState == presenterState3) {
            jW();
        }
        this.aut = presenterState3;
        this.aus = obj;
        ar();
        this.aut.performCallState(this);
    }

    public final <T extends View> T findViewById(int i2) {
        return (T) this.mRootView.findViewById(i2);
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        return k.dj(getContext());
    }

    public final Context getContext() {
        View view = this.mRootView;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    public final void jW() {
        this.aut = PresenterState.UNBIND;
        onUnbind();
        this.aut.performCallState(this);
    }

    protected void onCreate() {
    }

    protected void onDestroy() {
    }

    protected void onUnbind() {
    }
}

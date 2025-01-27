package com.kwad.components.core.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.core.g.a;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class c implements ImageLoadingListener {
    private b NI;

    @Nullable
    private a NJ;
    private long NM;
    private long iy;
    private int NK = 1;
    private int NL = 16;
    private List<h> NN = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.g.c$1 */
    public class AnonymousClass1 implements a.InterfaceC0428a {
        private boolean NO = false;
        private boolean NP = false;

        /* renamed from: com.kwad.components.core.g.c$1$1 */
        public class C04291 implements com.kwad.sdk.f.a<h> {

            /* renamed from: mc */
            final /* synthetic */ long f11927mc;

            public C04291(long j10) {
                j10 = j10;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: e */
            public void accept(h hVar) {
                hVar.onMediaPlayProgress(c.this.NM, j10);
            }
        }

        /* renamed from: com.kwad.components.core.g.c$1$2 */
        public class AnonymousClass2 implements com.kwad.sdk.f.a<h> {
            public AnonymousClass2() {
            }

            private static void e(h hVar) {
                hVar.onMediaPlayCompleted();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        }

        /* renamed from: com.kwad.components.core.g.c$1$3 */
        public class AnonymousClass3 implements com.kwad.sdk.f.a<h> {
            public AnonymousClass3() {
            }

            private static void e(h hVar) {
                hVar.onMediaPlayStart();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        }

        public AnonymousClass1() {
        }

        private void ls() {
            if (this.NO) {
                return;
            }
            c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.2
                public AnonymousClass2() {
                }

                private static void e(h hVar) {
                    hVar.onMediaPlayCompleted();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(h hVar) {
                    e(hVar);
                }
            });
            this.NO = true;
        }

        private void ps() {
            if (this.NP) {
                return;
            }
            com.kwad.sdk.core.d.c.d("KSImagePlayer", "onFirstFrame: ");
            this.NP = true;
            c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.3
                public AnonymousClass3() {
                }

                private static void e(h hVar) {
                    hVar.onMediaPlayStart();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(h hVar) {
                    e(hVar);
                }
            });
        }

        @Override // com.kwad.components.core.g.a.InterfaceC0428a
        public final void y(long j10) {
            com.kwad.sdk.core.d.c.d("KSImagePlayer", "onTimerProgress: " + j10);
            if (j10 == 0) {
                ps();
            }
            c.this.iy = j10;
            c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.1

                /* renamed from: mc */
                final /* synthetic */ long f11927mc;

                public C04291(long j102) {
                    j10 = j102;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: e */
                public void accept(h hVar) {
                    hVar.onMediaPlayProgress(c.this.NM, j10);
                }
            });
            if (c.this.iy < c.this.NM || c.this.NM <= 0) {
                return;
            }
            ls();
        }
    }

    /* renamed from: com.kwad.components.core.g.c$2 */
    public class AnonymousClass2 implements com.kwad.sdk.f.a<h> {
        public AnonymousClass2() {
        }

        private static void e(h hVar) {
            hVar.onMediaPlayPaused();
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(h hVar) {
            e(hVar);
        }
    }

    /* renamed from: com.kwad.components.core.g.c$3 */
    public class AnonymousClass3 implements com.kwad.sdk.f.a<h> {
        public AnonymousClass3() {
        }

        private static void e(h hVar) {
            hVar.onMediaPlaying();
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(h hVar) {
            e(hVar);
        }
    }

    /* renamed from: com.kwad.components.core.g.c$4 */
    public class AnonymousClass4 implements com.kwad.sdk.f.a<h> {
        public AnonymousClass4() {
        }

        private static void e(h hVar) {
            hVar.onMediaPlayCompleted();
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(h hVar) {
            e(hVar);
        }
    }

    /* renamed from: com.kwad.components.core.g.c$5 */
    public class AnonymousClass5 implements com.kwad.sdk.f.a<h> {
        final /* synthetic */ FailReason NS;

        public AnonymousClass5(FailReason failReason) {
            failReason = failReason;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: e */
        public void accept(h hVar) {
            hVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
        }
    }

    /* renamed from: com.kwad.components.core.g.c$6 */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c() {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.NJ = aVar;
        aVar.a(new a.InterfaceC0428a() { // from class: com.kwad.components.core.g.c.1
            private boolean NO = false;
            private boolean NP = false;

            /* renamed from: com.kwad.components.core.g.c$1$1 */
            public class C04291 implements com.kwad.sdk.f.a<h> {

                /* renamed from: mc */
                final /* synthetic */ long f11927mc;

                public C04291(long j102) {
                    j10 = j102;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: e */
                public void accept(h hVar) {
                    hVar.onMediaPlayProgress(c.this.NM, j10);
                }
            }

            /* renamed from: com.kwad.components.core.g.c$1$2 */
            public class AnonymousClass2 implements com.kwad.sdk.f.a<h> {
                public AnonymousClass2() {
                }

                private static void e(h hVar) {
                    hVar.onMediaPlayCompleted();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(h hVar) {
                    e(hVar);
                }
            }

            /* renamed from: com.kwad.components.core.g.c$1$3 */
            public class AnonymousClass3 implements com.kwad.sdk.f.a<h> {
                public AnonymousClass3() {
                }

                private static void e(h hVar) {
                    hVar.onMediaPlayStart();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(h hVar) {
                    e(hVar);
                }
            }

            public AnonymousClass1() {
            }

            private void ls() {
                if (this.NO) {
                    return;
                }
                c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.2
                    public AnonymousClass2() {
                    }

                    private static void e(h hVar) {
                        hVar.onMediaPlayCompleted();
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* synthetic */ void accept(h hVar) {
                        e(hVar);
                    }
                });
                this.NO = true;
            }

            private void ps() {
                if (this.NP) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onFirstFrame: ");
                this.NP = true;
                c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.3
                    public AnonymousClass3() {
                    }

                    private static void e(h hVar) {
                        hVar.onMediaPlayStart();
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* synthetic */ void accept(h hVar) {
                        e(hVar);
                    }
                });
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0428a
            public final void y(long j102) {
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onTimerProgress: " + j102);
                if (j102 == 0) {
                    ps();
                }
                c.this.iy = j102;
                c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.1

                    /* renamed from: mc */
                    final /* synthetic */ long f11927mc;

                    public C04291(long j1022) {
                        j10 = j1022;
                    }

                    @Override // com.kwad.sdk.f.a
                    /* renamed from: e */
                    public void accept(h hVar) {
                        hVar.onMediaPlayProgress(c.this.NM, j10);
                    }
                });
                if (c.this.iy < c.this.NM || c.this.NM <= 0) {
                    return;
                }
                ls();
            }
        });
    }

    public static /* synthetic */ int a(c cVar, FailReason.FailType failType) {
        return a(failType);
    }

    private void pr() {
        b bVar = this.NI;
        if (bVar != null) {
            bVar.setImageGravity(this.NK | this.NL);
        }
    }

    public final void c(h hVar) {
        if (hVar != null) {
            this.NN.add(hVar);
        }
    }

    public final void d(h hVar) {
        if (hVar != null) {
            this.NN.remove(hVar);
        }
    }

    public final void destroy() {
        this.NN.clear();
        b bVar = this.NI;
        if (bVar != null && bVar.getParent() != null) {
            ((ViewGroup) this.NI.getParent()).removeView(this.NI);
        }
        this.NI = null;
        a aVar = this.NJ;
        if (aVar != null) {
            aVar.destroy();
            this.NJ = null;
        }
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.NI == null) {
            this.NI = new b(context);
        }
        return this.NI;
    }

    public final long getPlayDuration() {
        return this.iy;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, FailReason failReason) {
        b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.5
            final /* synthetic */ FailReason NS;

            public AnonymousClass5(FailReason failReason2) {
                failReason = failReason2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: e */
            public void accept(h hVar) {
                hVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
            }
        });
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view) {
    }

    public final void pause() {
        a aVar = this.NJ;
        if (aVar != null) {
            aVar.pause();
        }
        b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.2
            public AnonymousClass2() {
            }

            private static void e(h hVar) {
                hVar.onMediaPlayPaused();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        });
    }

    public final void play() {
        a aVar = this.NJ;
        if (aVar != null) {
            aVar.start();
        }
    }

    public final void resume() {
        a aVar = this.NJ;
        if (aVar != null) {
            aVar.resume();
            b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.3
                public AnonymousClass3() {
                }

                private static void e(h hVar) {
                    hVar.onMediaPlaying();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(h hVar) {
                    e(hVar);
                }
            });
        }
    }

    public final void setHorizontalGravity(int i10) {
        this.NL = com.kwad.components.core.b.c.ak(i10);
        pr();
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.NI;
        if (bVar != null) {
            bVar.setImageScaleType(scaleType);
        }
    }

    public final void setRadius(float f10, float f11, float f12, float f13) {
        b bVar = this.NI;
        if (bVar != null) {
            bVar.setRadius(f10, f11, f12, f13);
        }
    }

    public final void setURLs(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String str = list.get(0);
        b bVar = this.NI;
        if (bVar != null) {
            bVar.a(str, this);
        }
    }

    public final void setVerticalGravity(int i10) {
        this.NL = com.kwad.components.core.b.c.aj(i10);
        pr();
    }

    public final void skipToEnd() {
        b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.4
            public AnonymousClass4() {
            }

            private static void e(h hVar) {
                hVar.onMediaPlayCompleted();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        });
    }

    public final void stop() {
        a aVar = this.NJ;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public final void z(long j10) {
        this.NM = j10;
    }

    public <T> void b(com.kwad.sdk.f.a<h> aVar) {
        List<h> list;
        if (aVar == null || (list = this.NN) == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
    }

    private static int a(FailReason.FailType failType) {
        int i10 = AnonymousClass6.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failType.ordinal()];
        if (i10 == 1) {
            return -2;
        }
        if (i10 == 2) {
            return -3;
        }
        if (i10 != 3) {
            return i10 != 4 ? -1 : -5;
        }
        return -4;
    }
}

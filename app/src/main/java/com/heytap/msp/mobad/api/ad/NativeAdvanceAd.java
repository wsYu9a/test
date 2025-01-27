package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeComplianceListener;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.opos.mobad.ad.c.g;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.ad.c.i;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class NativeAdvanceAd {
    private static final String TAG = "NativeAdvanceAd";
    private Context mContext;
    private c mListener;
    private volatile g mNativeAdImpl;
    private String mPosId;

    private static class a implements INativeAdvanceData {

        /* renamed from: a */
        private h f8987a;

        /* renamed from: b */
        private INativeAdvanceComplianceInfo f8988b;

        /* renamed from: com.heytap.msp.mobad.api.ad.NativeAdvanceAd$a$1 */
        class AnonymousClass1 implements h.a {

            /* renamed from: a */
            final /* synthetic */ INativeComplianceListener f8989a;

            AnonymousClass1(INativeComplianceListener iNativeComplianceListener) {
                iNativeComplianceListener = iNativeComplianceListener;
            }

            @Override // com.opos.mobad.ad.c.h.a
            public void a() {
                INativeComplianceListener iNativeComplianceListener = iNativeComplianceListener;
                if (iNativeComplianceListener == null) {
                    return;
                }
                iNativeComplianceListener.onClose();
            }

            @Override // com.opos.mobad.ad.c.h.a
            public void a(View view) {
                INativeComplianceListener iNativeComplianceListener = iNativeComplianceListener;
                if (iNativeComplianceListener == null) {
                    return;
                }
                iNativeComplianceListener.onClick(view);
            }
        }

        /* renamed from: com.heytap.msp.mobad.api.ad.NativeAdvanceAd$a$2 */
        class AnonymousClass2 implements h.a {

            /* renamed from: a */
            final /* synthetic */ INativeComplianceListener f8991a;

            AnonymousClass2(INativeComplianceListener iNativeComplianceListener) {
                iNativeComplianceListener2 = iNativeComplianceListener;
            }

            @Override // com.opos.mobad.ad.c.h.a
            public void a() {
                INativeComplianceListener iNativeComplianceListener = iNativeComplianceListener2;
                if (iNativeComplianceListener == null) {
                    return;
                }
                iNativeComplianceListener.onClose();
            }

            @Override // com.opos.mobad.ad.c.h.a
            public void a(View view) {
                INativeComplianceListener iNativeComplianceListener = iNativeComplianceListener2;
                if (iNativeComplianceListener == null) {
                    return;
                }
                iNativeComplianceListener.onClick(view);
            }
        }

        /* renamed from: com.heytap.msp.mobad.api.ad.NativeAdvanceAd$a$3 */
        class AnonymousClass3 implements INativeAdvanceComplianceInfo {
            AnonymousClass3() {
            }

            @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
            public String getAppVersion() {
                return a.this.f8987a.n().a();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
            public String getDeveloperName() {
                return a.this.f8987a.n().b();
            }
        }

        public a(h hVar) {
            this.f8987a = hVar;
            if (hVar.n() != null) {
                this.f8988b = new INativeAdvanceComplianceInfo() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.3
                    AnonymousClass3() {
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getAppVersion() {
                        return a.this.f8987a.n().a();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getDeveloperName() {
                        return a.this.f8987a.n().b();
                    }
                };
            }
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindMediaView(Context context, MediaView mediaView, INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
            this.f8987a.a(context, mediaView, new d(iNativeAdvanceMediaListener));
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToComplianceView(Context context, List<View> list, INativeComplianceListener iNativeComplianceListener, List<View> list2, INativeComplianceListener iNativeComplianceListener2) {
            this.f8987a.a(context, list, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.1

                /* renamed from: a */
                final /* synthetic */ INativeComplianceListener f8989a;

                AnonymousClass1(INativeComplianceListener iNativeComplianceListener3) {
                    iNativeComplianceListener = iNativeComplianceListener3;
                }

                @Override // com.opos.mobad.ad.c.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClose();
                }

                @Override // com.opos.mobad.ad.c.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClick(view);
                }
            }, list2, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.2

                /* renamed from: a */
                final /* synthetic */ INativeComplianceListener f8991a;

                AnonymousClass2(INativeComplianceListener iNativeComplianceListener22) {
                    iNativeComplianceListener2 = iNativeComplianceListener22;
                }

                @Override // com.opos.mobad.ad.c.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener2;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClose();
                }

                @Override // com.opos.mobad.ad.c.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener2;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClick(view);
                }
            });
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list) {
            this.f8987a.a(context, nativeAdvanceContainer, list);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getClickBnText() {
            return this.f8987a.l();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public INativeAdvanceComplianceInfo getComplianceInfo() {
            return this.f8988b;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getCreativeType() {
            return this.f8987a.e();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getDesc() {
            return this.f8987a.b();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public int getECPM() {
            return this.f8987a.g();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getExtra() {
            return this.f8987a.k();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getIconFiles() {
            List<com.opos.mobad.ad.c.e> c2 = this.f8987a.c();
            if (c2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (com.opos.mobad.ad.c.e eVar : c2) {
                if (eVar != null) {
                    arrayList.add(new e(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getImgFiles() {
            List<com.opos.mobad.ad.c.e> d2 = this.f8987a.d();
            if (d2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (com.opos.mobad.ad.c.e eVar : d2) {
                if (eVar != null) {
                    arrayList.add(new e(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public INativeAdFile getLogoFile() {
            com.opos.mobad.ad.c.e i2 = this.f8987a.i();
            if (i2 == null) {
                return null;
            }
            return new e(i2);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getTitle() {
            return this.f8987a.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getVideoDuration() {
            return this.f8987a.h();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public boolean isAdValid() {
            return this.f8987a.j();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void notifyRankLoss(int i2, String str, int i3) {
            this.f8987a.a(i2, str, i3);
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void notifyRankWin(int i2) {
            this.f8987a.b(i2);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void release() {
            this.f8987a.m();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void setBidECPM(int i2) {
            this.f8987a.c(i2);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void setInteractListener(INativeAdvanceInteractListener iNativeAdvanceInteractListener) {
            this.f8987a.a(new b(iNativeAdvanceInteractListener));
        }
    }

    private static class b implements i {

        /* renamed from: a */
        private INativeAdvanceInteractListener f8994a;

        public b(INativeAdvanceInteractListener iNativeAdvanceInteractListener) {
            this.f8994a = iNativeAdvanceInteractListener;
        }

        @Override // com.opos.mobad.ad.c.i
        public void a() {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f8994a;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onClick();
            }
        }

        @Override // com.opos.mobad.ad.c.i
        public void a(int i2, String str) {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f8994a;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onError(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.c.i
        public void b() {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f8994a;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onShow();
            }
        }
    }

    private static class c implements j {

        /* renamed from: a */
        private INativeAdvanceLoadListener f8995a;

        public c(INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
            this.f8995a = iNativeAdvanceLoadListener;
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(int i2, String str) {
            INativeAdvanceLoadListener iNativeAdvanceLoadListener = this.f8995a;
            if (iNativeAdvanceLoadListener != null) {
                iNativeAdvanceLoadListener.onAdFailed(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(List<h> list) {
            if (this.f8995a != null) {
                ArrayList arrayList = null;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator<h> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new a(it.next()));
                    }
                }
                this.f8995a.onAdSuccess(arrayList);
            }
        }
    }

    private static class d implements k {

        /* renamed from: a */
        private INativeAdvanceMediaListener f8996a;

        public d(INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
            this.f8996a = iNativeAdvanceMediaListener;
        }

        @Override // com.opos.mobad.ad.c.k
        public void a() {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f8996a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayStart();
            }
        }

        @Override // com.opos.mobad.ad.c.k
        public void a(int i2, String str) {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f8996a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayError(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.c.k
        public void b() {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f8996a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayComplete();
            }
        }
    }

    private static class e implements INativeAdFile {

        /* renamed from: a */
        private com.opos.mobad.ad.c.e f8997a;

        public e(com.opos.mobad.ad.c.e eVar) {
            this.f8997a = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return this.f8997a.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return this.f8997a.a();
        }
    }

    public NativeAdvanceAd(Context context, String str, INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeAdvanceLoadListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = new c(iNativeAdvanceLoadListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mNativeAdImpl == null) {
            if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
                return false;
            }
            synchronized (this) {
                if (this.mNativeAdImpl == null) {
                    this.mNativeAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mContext.getApplicationContext(), this.mPosId, this.mListener);
                    if (this.mNativeAdImpl == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mNativeAdImpl != null) {
            this.mNativeAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public void loadAd() {
        if (initImplIfNeed()) {
            this.mNativeAdImpl.a();
            return;
        }
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.a(-1, "inter ad create fail");
        }
    }
}

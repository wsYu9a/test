package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ExecutorGroup;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class gv {

    /* renamed from: a */
    private String f24433a;
    private INotificationClickCallback az;
    private IDownloadDepend bl;
    private boolean bw;

    /* renamed from: c */
    private int f24435c;
    private boolean cg;
    private long cm;
    private IDownloadDiskSpaceHandler db;

    /* renamed from: e */
    private IChunkAdjustCalculator f24436e;
    private boolean ei;

    /* renamed from: f */
    private boolean f24437f;

    /* renamed from: g */
    private List<String> f24438g;
    private IRetryDelayTimeCalculator gm;
    private String gs;
    private String gv;
    private AbsNotificationItem hm;

    /* renamed from: i */
    private String f24439i;
    private int[] il;

    /* renamed from: j */
    private Activity f24440j;
    private String l;
    private String lg;
    private boolean lt;
    private int lv;

    /* renamed from: me */
    private boolean f24441me;
    private String mx;
    private IDownloadListener p;
    private String q;
    private int qo;
    private int qt;
    private IDownloadListener r;
    private IDownloadFileUriProvider tc;
    private String tf;
    private com.ss.android.socialbase.appdownloader.i.q ts;
    private JSONObject ty;
    private long u;
    private IDownloadMonitorDepend um;
    private boolean up;
    private IChunkCntCalculator v;
    private boolean vy;
    private String w;
    private boolean xj;
    private boolean xl;
    private List<HttpHeader> y;
    private boolean z;
    private Context zx;
    private boolean k = true;
    private boolean pa = false;
    private boolean t = true;
    private boolean nt = false;
    private String s = AdBaseConstants.MIME_APK;
    private int gg = 5;
    private boolean vs = true;

    /* renamed from: b */
    private EnqueueType f24434b = EnqueueType.ENQUEUE_NONE;
    private int hk = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE;
    private boolean jg = true;

    /* renamed from: rx */
    private List<IDownloadCompleteHandler> f24442rx = new ArrayList();
    private boolean m = true;
    private boolean yq = true;

    public gv(@NonNull Context context, @NonNull String str) {
        this.zx = context.getApplicationContext();
        this.f24439i = str;
    }

    public String a() {
        return this.gs;
    }

    public int az() {
        return this.lv;
    }

    public EnqueueType b() {
        return this.f24434b;
    }

    public com.ss.android.socialbase.appdownloader.i.q bl() {
        return this.ts;
    }

    public boolean bw() {
        return this.vs;
    }

    public String c() {
        return this.f24433a;
    }

    public boolean cg() {
        return this.vy;
    }

    public boolean cm() {
        return this.m;
    }

    public List<IDownloadCompleteHandler> db() {
        return this.f24442rx;
    }

    public boolean e() {
        return this.z;
    }

    public boolean ei() {
        return this.f24437f;
    }

    public long f() {
        return this.u;
    }

    public List<HttpHeader> g() {
        return this.y;
    }

    public Activity getActivity() {
        return this.f24440j;
    }

    public Context getContext() {
        return this.zx;
    }

    public boolean gg() {
        return this.up;
    }

    public String gm() {
        return this.mx;
    }

    public boolean gv() {
        return this.pa;
    }

    public boolean hk() {
        return this.bw;
    }

    public String hm() {
        return this.tf;
    }

    public String i() {
        return this.lg;
    }

    public String j() {
        return this.f24439i;
    }

    public IDownloadMonitorDepend jg() {
        return this.um;
    }

    public IDownloadListener k() {
        return this.p;
    }

    public int l() {
        return this.qt;
    }

    public boolean lg() {
        return this.t;
    }

    public int lt() {
        return this.hk;
    }

    public boolean lv() {
        return this.xl;
    }

    public IDownloadDiskSpaceHandler m() {
        return this.db;
    }

    public boolean me() {
        return this.jg;
    }

    public int mx() {
        return this.qo;
    }

    public String nt() {
        return this.s;
    }

    public boolean p() {
        return this.ei;
    }

    public IDownloadListener pa() {
        return this.r;
    }

    public boolean q() {
        return this.k;
    }

    public IRetryDelayTimeCalculator qo() {
        return this.gm;
    }

    public String qt() {
        return this.gv;
    }

    public AbsNotificationItem r() {
        return this.hm;
    }

    public int[] rx() {
        return this.il;
    }

    public IChunkAdjustCalculator s() {
        return this.f24436e;
    }

    public String t() {
        return this.w;
    }

    public INotificationClickCallback tc() {
        return this.az;
    }

    public boolean tf() {
        return this.lt;
    }

    public IDownloadFileUriProvider ts() {
        return this.tc;
    }

    public boolean ty() {
        return this.yq;
    }

    public String u() {
        return this.l;
    }

    public IDownloadDepend um() {
        return this.bl;
    }

    public boolean up() {
        return this.xj;
    }

    public int v() {
        return this.f24435c;
    }

    public boolean vs() {
        return this.f24441me;
    }

    public long vy() {
        return this.cm;
    }

    public IChunkCntCalculator w() {
        return this.v;
    }

    public boolean xj() {
        return this.cg;
    }

    public List<String> xl() {
        return this.f24438g;
    }

    public boolean y() {
        return this.nt;
    }

    public JSONObject yq() {
        return this.ty;
    }

    public int z() {
        return this.gg;
    }

    public String zx() {
        return this.q;
    }

    public gv g(String str) {
        this.w = str;
        return this;
    }

    public gv gv(boolean z) {
        this.z = z;
        return this;
    }

    public gv i(@NonNull String str) {
        this.lg = str;
        return this;
    }

    public void j(int i2) {
        this.f24435c = i2;
    }

    public gv k(boolean z) {
        this.vs = z;
        return this;
    }

    public gv lg(String str) {
        this.tf = str;
        return this;
    }

    public gv nt(boolean z) {
        this.xj = z;
        return this;
    }

    public gv p(boolean z) {
        this.jg = z;
        return this;
    }

    public gv pa(boolean z) {
        this.up = z;
        return this;
    }

    public gv q(String str) {
        this.s = str;
        return this;
    }

    public gv r(boolean z) {
        this.bw = z;
        return this;
    }

    public gv s(boolean z) {
        this.m = z;
        return this;
    }

    public gv t(boolean z) {
        this.f24441me = z;
        return this;
    }

    public gv w(boolean z) {
        this.xl = z;
        return this;
    }

    public gv y(String str) {
        this.l = str;
        return this;
    }

    public gv zx(String str) {
        this.gv = str;
        return this;
    }

    public gv g(boolean z) {
        this.ei = z;
        return this;
    }

    public gv gv(String str) {
        this.mx = str;
        return this;
    }

    public gv i(boolean z) {
        this.nt = z;
        return this;
    }

    public gv j(String str) {
        this.q = str;
        return this;
    }

    public gv k(String str) {
        this.gs = str;
        return this;
    }

    public gv lg(boolean z) {
        this.lt = z;
        return this;
    }

    public gv pa(String str) {
        this.f24433a = str;
        return this;
    }

    public gv q(boolean z) {
        this.f24437f = z;
        return this;
    }

    public gv y(boolean z) {
        this.cg = z;
        return this;
    }

    public gv zx(boolean z) {
        this.pa = z;
        return this;
    }

    public gv g(int i2) {
        this.hk = i2;
        return this;
    }

    public gv gv(@ExecutorGroup int i2) {
        this.lv = i2;
        return this;
    }

    public gv i(int i2) {
        this.qo = i2;
        return this;
    }

    public gv j(List<HttpHeader> list) {
        this.y = list;
        return this;
    }

    public gv q(int i2) {
        this.qt = i2;
        return this;
    }

    public gv zx(int i2) {
        this.gg = i2;
        return this;
    }

    public gv j(boolean z) {
        this.k = z;
        return this;
    }

    public gv zx(List<String> list) {
        this.f24438g = list;
        return this;
    }

    public gv j(IDownloadListener iDownloadListener) {
        this.p = iDownloadListener;
        return this;
    }

    public gv j(long j2) {
        this.u = j2;
        return this;
    }

    public gv j(EnqueueType enqueueType) {
        this.f24434b = enqueueType;
        return this;
    }

    public gv j(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.tc = iDownloadFileUriProvider;
        return this;
    }

    public gv j(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.db = iDownloadDiskSpaceHandler;
        return this;
    }

    public gv j(JSONObject jSONObject) {
        this.ty = jSONObject;
        return this;
    }

    public gv j(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.f24442rx) {
            if (iDownloadCompleteHandler != null) {
                if (!this.f24442rx.contains(iDownloadCompleteHandler)) {
                    this.f24442rx.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }
}

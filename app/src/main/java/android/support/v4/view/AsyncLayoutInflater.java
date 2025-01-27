package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.util.Pools;
import android.support.v4.view.animation.C0005;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gason.C0107;
import com.google.gason.stream.C0106;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.a.utils.C0520;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes7.dex */
public final class AsyncLayoutInflater {
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f25short;
    LayoutInflater mInflater;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: android.support.v4.view.AsyncLayoutInflater.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.view == null) {
                inflateRequest.view = AsyncLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
            }
            inflateRequest.callback.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent);
            AsyncLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
            return true;
        }
    };
    Handler mHandler = new Handler(this.mHandlerCallback);
    InflateThread mInflateThread = InflateThread.getInstance();

    /* renamed from: android.support.v4.view.AsyncLayoutInflater$1 */
    class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.view == null) {
                inflateRequest.view = AsyncLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
            }
            inflateRequest.callback.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent);
            AsyncLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
            return true;
        }
    }

    private static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList;

        /* renamed from: short */
        private static final short[] f26short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(1893866)}[0]).intValue() ^ 1893824];
            sArr[0] = 3020;
            sArr[1] = 3011;
            sArr[2] = 3017;
            sArr[3] = 3039;
            sArr[4] = 3010;
            sArr[5] = 3012;
            sArr[6] = 3017;
            sArr[7] = 2947;
            sArr[8] = 3034;
            sArr[9] = 3012;
            sArr[10] = 3017;
            sArr[11] = 3018;
            sArr[12] = 3016;
            sArr[13] = 3033;
            sArr[14] = 2947;
            sArr[15] = 1193;
            sArr[16] = 1190;
            sArr[17] = 1196;
            sArr[18] = 1210;
            sArr[19] = 1191;
            sArr[20] = 1185;
            sArr[21] = 1196;
            sArr[22] = 1254;
            sArr[23] = 1215;
            sArr[24] = 1197;
            sArr[25] = 1194;
            sArr[26] = 1187;
            sArr[27] = 1185;
            sArr[28] = 1212;
            sArr[29] = 1254;
            sArr[30] = 1892;
            sArr[31] = 1899;
            sArr[32] = 1889;
            sArr[33] = 1911;
            sArr[34] = 1898;
            sArr[35] = 1900;
            sArr[36] = 1889;
            sArr[37] = 1835;
            sArr[38] = 1892;
            sArr[39] = 1909;
            sArr[40] = 1909;
            sArr[41] = 1835;
            f26short = sArr;
            sClassPrefixList = new String[]{C0521.m71(f26short, 56412 ^ C0008.m27((Object) "ۣ۟"), 1750670 ^ C0008.m27((Object) "ۣۣۡ"), C0008.m27((Object) "ۣۧ۠") ^ 1756713), C0107.m50(f26short, 1754536 ^ C0008.m27((Object) "ۧۤۤ"), 1751622 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "۠۟ۥ") ^ 1748494), C0106.m46(f26short, 1749756 ^ C0008.m27((Object) "ۢۤۤ"), 1748750 ^ C0008.m27((Object) "ۣۡۤ"), C0008.m27((Object) "ۡۦۥ") ^ 1747045)};
        }

        BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            Integer num = new Integer(1622801);
            String[] strArr = sClassPrefixList;
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 1622800) + i2) {
                try {
                    createView = createView(str, strArr[i2], attributeSet);
                } catch (ClassNotFoundException e2) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class InflateRequest {
        OnInflateFinishedListener callback;
        AsyncLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        InflateRequest() {
        }
    }

    private static class InflateThread extends Thread {
        private static final InflateThread sInstance;

        /* renamed from: short */
        private static final short[] f27short;
        private ArrayBlockingQueue<InflateRequest> mQueue;
        private Pools.SynchronizedPool<InflateRequest> mRequestPool;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(4724320)}[0]).intValue() ^ 4724449];
            sArr[0] = 3120;
            sArr[1] = 3095;
            sArr[2] = 3103;
            sArr[3] = 3098;
            sArr[4] = 3091;
            sArr[5] = 3090;
            sArr[6] = 3158;
            sArr[7] = 3074;
            sArr[8] = 3097;
            sArr[9] = 3158;
            sArr[10] = 3091;
            sArr[11] = 3096;
            sArr[12] = 3079;
            sArr[13] = 3075;
            sArr[14] = 3091;
            sArr[15] = 3075;
            sArr[16] = 3091;
            sArr[17] = 3158;
            sArr[18] = 3095;
            sArr[19] = 3077;
            sArr[20] = 3087;
            sArr[21] = 3096;
            sArr[22] = 3093;
            sArr[23] = 3158;
            sArr[24] = 3103;
            sArr[25] = 3096;
            sArr[26] = 3088;
            sArr[27] = 3098;
            sArr[28] = 3095;
            sArr[29] = 3074;
            sArr[30] = 3091;
            sArr[31] = 3158;
            sArr[32] = 3076;
            sArr[33] = 3091;
            sArr[34] = 3079;
            sArr[35] = 3075;
            sArr[36] = 3091;
            sArr[37] = 3077;
            sArr[38] = 3074;
            sArr[39] = 2757;
            sArr[40] = 2807;
            sArr[41] = 2813;
            sArr[42] = 2794;
            sArr[43] = 2791;
            sArr[44] = 2760;
            sArr[45] = 2789;
            sArr[46] = 2813;
            sArr[47] = 2795;
            sArr[48] = 2801;
            sArr[49] = 2800;
            sArr[50] = 2765;
            sArr[51] = 2794;
            sArr[52] = 2786;
            sArr[53] = 2792;
            sArr[54] = 2789;
            sArr[55] = 2800;
            sArr[56] = 2785;
            sArr[57] = 2806;
            sArr[58] = 3089;
            sArr[59] = 3126;
            sArr[60] = 3134;
            sArr[61] = 3131;
            sArr[62] = 3122;
            sArr[63] = 3123;
            sArr[64] = 3191;
            sArr[65] = 3107;
            sArr[66] = 3128;
            sArr[67] = 3191;
            sArr[68] = 3134;
            sArr[69] = 3129;
            sArr[70] = 3121;
            sArr[71] = 3131;
            sArr[72] = 3126;
            sArr[73] = 3107;
            sArr[74] = 3122;
            sArr[75] = 3191;
            sArr[76] = 3109;
            sArr[77] = 3122;
            sArr[78] = 3108;
            sArr[79] = 3128;
            sArr[80] = 3106;
            sArr[81] = 3109;
            sArr[82] = 3124;
            sArr[83] = 3122;
            sArr[84] = 3191;
            sArr[85] = 3134;
            sArr[86] = 3129;
            sArr[87] = 3191;
            sArr[88] = 3107;
            sArr[89] = 3135;
            sArr[90] = 3122;
            sArr[91] = 3191;
            sArr[92] = 3125;
            sArr[93] = 3126;
            sArr[94] = 3124;
            sArr[95] = 3132;
            sArr[96] = 3120;
            sArr[97] = 3109;
            sArr[98] = 3128;
            sArr[99] = 3106;
            sArr[100] = 3129;
            sArr[101] = 3123;
            sArr[102] = 3190;
            sArr[103] = 3191;
            sArr[104] = 3077;
            sArr[105] = 3122;
            sArr[106] = 3107;
            sArr[107] = 3109;
            sArr[108] = 3118;
            sArr[109] = 3134;
            sArr[110] = 3129;
            sArr[111] = 3120;
            sArr[112] = 3191;
            sArr[113] = 3128;
            sArr[114] = 3129;
            sArr[115] = 3191;
            sArr[116] = 3107;
            sArr[117] = 3135;
            sArr[118] = 3122;
            sArr[119] = 3191;
            sArr[120] = 3074;
            sArr[121] = 3102;
            sArr[122] = 3191;
            sArr[123] = 3107;
            sArr[124] = 3135;
            sArr[125] = 3109;
            sArr[126] = 3122;
            sArr[127] = 3126;
            sArr[128] = 3123;
            f27short = sArr;
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
            int intValue = ((Integer) new Object[]{new Integer(1113476)}[0]).intValue() ^ 1113486;
            this.mQueue = new ArrayBlockingQueue<>(intValue);
            this.mRequestPool = new Pools.SynchronizedPool<>(intValue);
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (InterruptedException e2) {
                throw new RuntimeException(C0520.m66(f27short, 1753578 ^ C0008.m27((Object) "ۦۤۨ"), 1748761 ^ C0008.m27((Object) "ۡۥۢ"), C0008.m27((Object) "ۡۥۦ") ^ 1745716), e2);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest inflateRequest = (InflateRequest) this.mRequestPool.acquire();
            return inflateRequest == null ? new InflateRequest() : inflateRequest;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.callback = null;
            inflateRequest.inflater = null;
            inflateRequest.parent = null;
            inflateRequest.resid = 0;
            inflateRequest.view = null;
            this.mRequestPool.release(inflateRequest);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            String m17 = C0005.m17(f27short, 1755525 ^ C0008.m27((Object) "ۨۦ۠"), 1754549 ^ C0008.m27((Object) "ۣۧۤ"), C0008.m27((Object) "ۥۢۢ") ^ 1750881);
            try {
                InflateRequest take = this.mQueue.take();
                try {
                    take.view = take.inflater.mInflater.inflate(take.resid, take.parent, false);
                } catch (RuntimeException e2) {
                    Log.w(m17, C0003.m11(f27short, 1750685 ^ C0008.m27((Object) "ۣۤۨ"), 1751717 ^ C0008.m27((Object) "ۤۨۦ"), C0008.m27((Object) "ۢۥ") ^ 53268), e2);
                }
                Message.obtain(take.inflater.mHandler, 0, take).sendToTarget();
            } catch (InterruptedException e3) {
                Log.w(m17, e3);
            }
        }
    }

    public interface OnInflateFinishedListener {
        void onInflateFinished(View view, int i2, ViewGroup viewGroup);
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(2425772)}[0]).intValue() ^ 2425753];
        sArr[0] = 2640;
        sArr[1] = 2658;
        sArr[2] = 2664;
        sArr[3] = 2687;
        sArr[4] = 2674;
        sArr[5] = 2653;
        sArr[6] = 2672;
        sArr[7] = 2664;
        sArr[8] = 2686;
        sArr[9] = 2660;
        sArr[10] = 2661;
        sArr[11] = 2648;
        sArr[12] = 2687;
        sArr[13] = 2679;
        sArr[14] = 2685;
        sArr[15] = 2672;
        sArr[16] = 2661;
        sArr[17] = 2676;
        sArr[18] = 2659;
        sArr[19] = 440;
        sArr[20] = 442;
        sArr[21] = 439;
        sArr[22] = 439;
        sArr[23] = 441;
        sArr[24] = 442;
        sArr[25] = 440;
        sArr[26] = 432;
        sArr[27] = 507;
        sArr[28] = 442;
        sArr[29] = 425;
        sArr[30] = 444;
        sArr[31] = 430;
        sArr[32] = 438;
        sArr[33] = 446;
        sArr[34] = 437;
        sArr[35] = 431;
        sArr[36] = 507;
        sArr[37] = 438;
        sArr[38] = 442;
        sArr[39] = 418;
        sArr[40] = 507;
        sArr[41] = 437;
        sArr[42] = 436;
        sArr[43] = 431;
        sArr[44] = 507;
        sArr[45] = 441;
        sArr[46] = 446;
        sArr[47] = 507;
        sArr[48] = 437;
        sArr[49] = 430;
        sArr[50] = 439;
        sArr[51] = 439;
        sArr[52] = 506;
        f25short = sArr;
        TAG = C0000.m1(f25short, 1749855 ^ C0008.m27((Object) "ۢۨۥ"), 1754527 ^ C0008.m27((Object) "ۣۧۨ"), C0008.m27((Object) "۟ۧۦ") ^ 1748463);
    }

    public AsyncLayoutInflater(Context context) {
        this.mInflater = new BasicInflater(context);
    }

    public void inflate(int i2, ViewGroup viewGroup, OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener == null) {
            throw new NullPointerException(C0522.m72(f25short, 56526 ^ C0008.m27((Object) "ۧۤ"), 1746845 ^ C0008.m27((Object) "۟ۥۥ"), C0008.m27((Object) "ۦ۟ۥ") ^ 1753239));
        }
        InflateRequest obtainRequest = this.mInflateThread.obtainRequest();
        obtainRequest.inflater = this;
        obtainRequest.resid = i2;
        obtainRequest.parent = viewGroup;
        obtainRequest.callback = onInflateFinishedListener;
        this.mInflateThread.enqueue(obtainRequest);
    }
}

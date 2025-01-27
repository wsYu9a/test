package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.graphics.C0001;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes7.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;

    /* renamed from: short */
    private static final short[] f35short;
    private final DataSetObservable mObservable = new DataSetObservable();
    private DataSetObserver mViewPagerObserver;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(6338856)}[0]).intValue() ^ 6338888];
        sArr[0] = 2217;
        sArr[1] = 2206;
        sArr[2] = 2186;
        sArr[3] = 2190;
        sArr[4] = 2194;
        sArr[5] = 2185;
        sArr[6] = 2206;
        sArr[7] = 2207;
        sArr[8] = 2267;
        sArr[9] = 2198;
        sArr[10] = 2206;
        sArr[11] = 2191;
        sArr[12] = 2195;
        sArr[13] = 2196;
        sArr[14] = 2207;
        sArr[15] = 2267;
        sArr[16] = 2207;
        sArr[17] = 2206;
        sArr[18] = 2184;
        sArr[19] = 2191;
        sArr[20] = 2185;
        sArr[21] = 2196;
        sArr[22] = 2178;
        sArr[23] = 2226;
        sArr[24] = 2191;
        sArr[25] = 2206;
        sArr[26] = 2198;
        sArr[27] = 2267;
        sArr[28] = 2188;
        sArr[29] = 2202;
        sArr[30] = 2184;
        sArr[31] = 2267;
        sArr[32] = 2197;
        sArr[33] = 2196;
        sArr[34] = 2191;
        sArr[35] = 2267;
        sArr[36] = 2196;
        sArr[37] = 2189;
        sArr[38] = 2206;
        sArr[39] = 2185;
        sArr[40] = 2185;
        sArr[41] = 2194;
        sArr[42] = 2207;
        sArr[43] = 2207;
        sArr[44] = 2206;
        sArr[45] = 2197;
        sArr[46] = 1029;
        sArr[47] = 1074;
        sArr[48] = 1062;
        sArr[49] = 1058;
        sArr[50] = 1086;
        sArr[51] = 1061;
        sArr[52] = 1074;
        sArr[53] = 1075;
        sArr[54] = 1143;
        sArr[55] = 1082;
        sArr[56] = 1074;
        sArr[57] = 1059;
        sArr[58] = 1087;
        sArr[59] = 1080;
        sArr[60] = 1075;
        sArr[61] = 1143;
        sArr[62] = 1086;
        sArr[63] = 1081;
        sArr[64] = 1060;
        sArr[65] = 1059;
        sArr[66] = 1078;
        sArr[67] = 1081;
        sArr[68] = 1059;
        sArr[69] = 1086;
        sArr[70] = 1078;
        sArr[71] = 1059;
        sArr[72] = 1074;
        sArr[73] = 1054;
        sArr[74] = 1059;
        sArr[75] = 1074;
        sArr[76] = 1082;
        sArr[77] = 1143;
        sArr[78] = 1056;
        sArr[79] = 1078;
        sArr[80] = 1060;
        sArr[81] = 1143;
        sArr[82] = 1081;
        sArr[83] = 1080;
        sArr[84] = 1059;
        sArr[85] = 1143;
        sArr[86] = 1080;
        sArr[87] = 1057;
        sArr[88] = 1074;
        sArr[89] = 1061;
        sArr[90] = 1061;
        sArr[91] = 1086;
        sArr[92] = 1075;
        sArr[93] = 1075;
        sArr[94] = 1074;
        sArr[95] = 1081;
        f35short = sArr;
    }

    @Deprecated
    public void destroyItem(View view, int i2, Object obj) {
        throw new UnsupportedOperationException(C0001.m3(f35short, 1752733 ^ C0008.m27((Object) "ۥۨ۠"), 1748779 ^ C0008.m27((Object) "ۣۡۧ"), C0008.m27((Object) "ۧۨۥ") ^ 1756895));
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        destroyItem((View) viewGroup, i2, obj);
    }

    @Deprecated
    public void finishUpdate(View view) {
    }

    public void finishUpdate(ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    public abstract int getCount();

    public int getItemPosition(Object obj) {
        return -1;
    }

    public CharSequence getPageTitle(int i2) {
        return null;
    }

    public float getPageWidth(int i2) {
        return 1.0f;
    }

    @Deprecated
    public Object instantiateItem(View view, int i2) {
        throw new UnsupportedOperationException(C0001.m3(f35short, 1746902 ^ C0008.m27((Object) "۟ۧ۠"), 1752755 ^ C0008.m27((Object) "ۥۣۧ"), C0008.m27((Object) "ۣۣۦ") ^ 1749713));
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        return instantiateItem((View) viewGroup, i2);
    }

    public abstract boolean isViewFromObject(View view, Object obj);

    public void notifyDataSetChanged() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.mViewPagerObserver;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(View view, int i2, Object obj) {
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        setPrimaryItem((View) viewGroup, i2, obj);
    }

    void setViewPagerObserver(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
        }
    }

    @Deprecated
    public void startUpdate(View view) {
    }

    public void startUpdate(ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }
}

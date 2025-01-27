package com.vivo.advv.virtualview.common;

import com.vivo.advv.Color;
import com.vivo.advv.Log;
import com.vivo.advv.TextUtils;

/* loaded from: classes4.dex */
public class Common {
    public static final byte CODE_END_TAG = 1;
    public static final byte CODE_START_TAG = 0;
    public static final int MAJOR_VERSION = 1;
    public static final int MAX_PAGE_ITEM_COUNT = 1024;
    public static final int MAX_PAGE_ITEM_MASK = 1023;
    public static final int MAX_TAB_SIZE = 20;
    public static final int MINOR_VERSION = 0;
    public static final int PATCH_VERSION = 0;
    public static final String TAG = "ALIVV";
    public static final int TYPE_FLOAT = 2;
    public static final int TYPE_INT = 1;
    public static final int TYPE_STRING = 3;
    public static final int USER_VIEW_ID_START = 1000;
    public static final int VIEW_ID_FlexLayout = 5;
    public static final int VIEW_ID_FrameLayout = 1;
    public static final int VIEW_ID_Grid = 17;
    public static final int VIEW_ID_GridLayout = 4;
    public static final int VIEW_ID_NFrameLayout = 25;
    public static final int VIEW_ID_NGridLayout = 26;
    public static final int VIEW_ID_NRatioLayout = 27;
    public static final int VIEW_ID_NVH2Layout = 28;
    public static final int VIEW_ID_NVHLayout = 29;
    public static final int VIEW_ID_NativeImage = 9;
    public static final int VIEW_ID_NativeLine = 13;
    public static final int VIEW_ID_NativeText = 7;
    public static final int VIEW_ID_Page = 16;
    public static final int VIEW_ID_RatioLayout = 6;
    public static final int VIEW_ID_Scroller = 15;
    public static final int VIEW_ID_Slider = 19;
    public static final int VIEW_ID_TMNativeImage = 12;
    public static final int VIEW_ID_TMVirtualImage = 11;
    public static final int VIEW_ID_VH = 18;
    public static final int VIEW_ID_VH2Layout = 3;
    public static final int VIEW_ID_VHLayout = 2;
    public static final int VIEW_ID_Var = 24;
    public static final int VIEW_ID_VirtualContainer = 23;
    public static final int VIEW_ID_VirtualGraph = 21;
    public static final int VIEW_ID_VirtualImage = 10;
    public static final int VIEW_ID_VirtualLine = 14;
    public static final int VIEW_ID_VirtualProgress = 22;
    public static final int VIEW_ID_VirtualText = 8;
    public static final int VIEW_ID_VirtualTime = 20;

    public static boolean parseColor(DataItem dataItem) {
        int parseColor;
        if (TextUtils.isEmpty(dataItem.mStrValue)) {
            return false;
        }
        try {
            if (TextUtils.equals("black", dataItem.mStrValue)) {
                parseColor = -16777216;
            } else if (TextUtils.equals("blue", dataItem.mStrValue)) {
                parseColor = Color.BLUE;
            } else if (TextUtils.equals("cyan", dataItem.mStrValue)) {
                parseColor = Color.CYAN;
            } else if (TextUtils.equals("dkgray", dataItem.mStrValue)) {
                parseColor = Color.DKGRAY;
            } else if (TextUtils.equals("gray", dataItem.mStrValue)) {
                parseColor = Color.GRAY;
            } else if (TextUtils.equals("green", dataItem.mStrValue)) {
                parseColor = Color.GREEN;
            } else if (TextUtils.equals("ltgray", dataItem.mStrValue)) {
                parseColor = Color.LTGRAY;
            } else {
                if (!TextUtils.equals("magenta", dataItem.mStrValue) && !TextUtils.equals("magenta", dataItem.mStrValue)) {
                    parseColor = TextUtils.equals("red", dataItem.mStrValue) ? -65536 : TextUtils.equals("transparent", dataItem.mStrValue) ? 0 : TextUtils.equals("yellow", dataItem.mStrValue) ? -256 : Color.parseColor(dataItem.mStrValue);
                }
                parseColor = Color.MAGENTA;
            }
            dataItem.setIntValue(parseColor);
            return true;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean parseInteger(DataItem dataItem) {
        if (dataItem == null || TextUtils.isEmpty(dataItem.mStrValue)) {
            Log.e(TAG, "parseInteger value invalidate:" + dataItem);
        } else {
            try {
                dataItem.setIntValue(Integer.parseInt(dataItem.mStrValue));
                return true;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}

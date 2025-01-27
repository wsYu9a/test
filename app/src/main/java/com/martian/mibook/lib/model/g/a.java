package com.martian.mibook.lib.model.g;

import android.text.TextUtils;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.data.BookWrapper;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    public static String[] f14018a = {"起点中文网", "起点", "红袖添香", "潇湘书院", "纵横中文", "手机纵横", "雷电搜索", "晋江文学城", "小说", "登陆", "排行榜", "全集TXT", "抽奖", "签到活动", "月票榜", "女生必看,女生精选", "男生必看,精品佳作", "分类精选", "友情提示", "小说阅读网", "逐浪", "17k", "言情小说吧", "登录", "作品分类", "神马小说", "注册", "详情", "找不到网页"};

    public static String a(BookWrapper bookWrapper) {
        if (bookWrapper.book == null) {
            return "";
        }
        if (bookWrapper.hasChapterUpdate && bookWrapper.item.isReaded()) {
            return "已缓存至(" + (bookWrapper.cacheIndex + 1) + "/" + (bookWrapper.cacheSize + 1) + "+): " + bookWrapper.lastestCachedChapterTitle;
        }
        return "已缓存至(" + (bookWrapper.cacheIndex + 1) + "/" + bookWrapper.cacheSize + "): " + bookWrapper.lastestCachedChapterTitle;
    }

    public static boolean b(BookWrapper bookWrapper) {
        if (bookWrapper.book == null) {
            return false;
        }
        return (bookWrapper.hasChapterUpdate && bookWrapper.item.isReaded()) ? bookWrapper.cacheIndex == bookWrapper.cacheSize : bookWrapper.cacheIndex + 1 == bookWrapper.cacheSize;
    }

    public static String c(String url) {
        String substring;
        if (TextUtils.isEmpty(url)) {
            return "Unknown";
        }
        if (!url.startsWith("http://")) {
            if (url.startsWith("https://")) {
                substring = url.substring(8);
            }
            return "Unknown";
        }
        substring = url.substring(7);
        try {
            int indexOf = substring.indexOf("/");
            return indexOf == -1 ? substring : substring.substring(0, indexOf);
        } catch (Exception unused) {
        }
    }

    public static boolean d(String item) {
        if (k.p(item) || item.length() >= 30 || item.length() <= 1) {
            return false;
        }
        return !e(item);
    }

    public static boolean e(String keyword) {
        for (String str : f14018a) {
            if (keyword.contains(str)) {
                return true;
            }
        }
        return false;
    }
}

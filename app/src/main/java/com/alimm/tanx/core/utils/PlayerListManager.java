package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.feed.FeedVideoManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PlayerListManager implements NotConfused {
    private static final int PLAYER_MAX_NUM = 20;
    static final String TAG = "PlayerListManager";
    private static PlayerListManager instance;
    public static LinkedHashMap<String, FeedVideoManager> mPlayerMap = new LinkedHashMap<String, FeedVideoManager>(20) { // from class: com.alimm.tanx.core.utils.PlayerListManager.1
        public AnonymousClass1(int i10) {
            super(i10);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, FeedVideoManager> entry) {
            boolean z10 = PlayerListManager.mPlayerMap.size() > 20;
            if (z10) {
                LogUtils.d(PlayerListManager.TAG, "FeedVideoManager 缓存超出20个，回收:" + entry.getKey());
                PlayerListManager.destroy(entry);
            }
            return z10;
        }
    };

    /* renamed from: com.alimm.tanx.core.utils.PlayerListManager$1 */
    public static class AnonymousClass1 extends LinkedHashMap<String, FeedVideoManager> {
        public AnonymousClass1(int i10) {
            super(i10);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, FeedVideoManager> entry) {
            boolean z10 = PlayerListManager.mPlayerMap.size() > 20;
            if (z10) {
                LogUtils.d(PlayerListManager.TAG, "FeedVideoManager 缓存超出20个，回收:" + entry.getKey());
                PlayerListManager.destroy(entry);
            }
            return z10;
        }
    }

    public static void destroy(Map.Entry<String, FeedVideoManager> entry) {
        LogUtils.d(TAG, "destroy");
        if (entry == null || entry.getValue() == null) {
            return;
        }
        entry.getValue().destroy();
    }

    public static PlayerListManager getInstance() {
        if (instance == null) {
            synchronized (PlayerListManager.class) {
                try {
                    if (instance == null) {
                        instance = new PlayerListManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private boolean isITanxAdNull(ITanxAd iTanxAd) {
        return iTanxAd == null || iTanxAd.getBidInfo() == null || TextUtils.isEmpty(iTanxAd.getBidInfo().getSessionId());
    }

    private static void pause(Map.Entry<String, FeedVideoManager> entry) {
        if (entry == null || entry.getValue() == null) {
            return;
        }
        LogUtils.d(TAG, "暂停sessionId：" + entry.getValue().getSessionId());
        entry.getValue().pause();
    }

    public void clearAll() {
        try {
            LinkedHashMap<String, FeedVideoManager> linkedHashMap = mPlayerMap;
            if (linkedHashMap == null || linkedHashMap.size() <= 0) {
                return;
            }
            Iterator<Map.Entry<String, FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
            if (it.hasNext()) {
                destroy(it.next());
                it.remove();
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }

    public void clearOtherPlayer(ITanxAd iTanxAd) {
        try {
            if (isITanxAdNull(iTanxAd)) {
                return;
            }
            Iterator<Map.Entry<String, FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, FeedVideoManager> next = it.next();
                if (!next.getKey().equals(iTanxAd.getBidInfo().getSessionId())) {
                    destroy(next);
                    it.remove();
                    return;
                }
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }

    public void clearThis(ITanxAd iTanxAd) {
        if (isITanxAdNull(iTanxAd)) {
            LogUtils.d("clearThis error  iTanxAd  == null", new String[0]);
        } else {
            clearThis(iTanxAd.getBidInfo().getSessionId());
        }
    }

    public FeedVideoManager getFeedVideoManager4SessionId(ITanxAd iTanxAd) {
        LinkedHashMap<String, FeedVideoManager> linkedHashMap;
        if (isITanxAdNull(iTanxAd) || (linkedHashMap = mPlayerMap) == null || linkedHashMap.size() <= 0) {
            return null;
        }
        return mPlayerMap.get(iTanxAd.getBidInfo().getSessionId());
    }

    public void putFeedVideoManager(ITanxAd iTanxAd, FeedVideoManager feedVideoManager) {
        if (isITanxAdNull(iTanxAd)) {
            LogUtils.d("putFeedVideoManager error iTanxAd == null", new String[0]);
            return;
        }
        LogUtils.d("putFeedVideoManager push sessionId:" + iTanxAd.getBidInfo().getSessionId(), new String[0]);
        mPlayerMap.put(iTanxAd.getBidInfo().getSessionId(), feedVideoManager);
    }

    public void stopOtherPlayer(ITanxAd iTanxAd) {
        try {
            if (isITanxAdNull(iTanxAd)) {
                return;
            }
            for (Map.Entry<String, FeedVideoManager> entry : mPlayerMap.entrySet()) {
                LogUtils.d(TAG, "stopOtherPlayer: 循环：" + entry.getKey() + " 当前广告id：" + iTanxAd.getBidInfo().getSessionId());
                if (!entry.getKey().equals(iTanxAd.getBidInfo().getSessionId())) {
                    pause(entry);
                }
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }

    private void clearThis(String str) {
        try {
            Iterator<Map.Entry<String, FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, FeedVideoManager> next = it.next();
                if (next.getKey().equals(str)) {
                    destroy(next);
                    it.remove();
                    return;
                }
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }
}

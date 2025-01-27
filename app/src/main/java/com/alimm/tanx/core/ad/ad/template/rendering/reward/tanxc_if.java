package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.utils.LogUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class tanxc_if {
    public static LinkedHashMap<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> tanxc_do = new LinkedHashMap<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if>(3) { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardGlobal$1
        public RewardGlobal$1(int i10) {
            super(i10);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> entry) {
            return tanxc_if.tanxc_do.size() > 3;
        }
    };
    public static volatile tanxc_try tanxc_if;

    public static void tanxc_do() {
        try {
            tanxc_if = null;
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }

    public static void tanxc_do(String str) {
        try {
            Iterator<String> it = tanxc_do.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(str)) {
                    it.remove();
                    return;
                }
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }
}

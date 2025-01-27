package com.martian.ads.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class AdsPosition {
    private String gromoreAppid;
    private List<AdSlots> positions;
    private String snAppid;
    private Map<String, String> unionAppids;

    public String getGromoreAppid() {
        return this.gromoreAppid;
    }

    public List<AdSlots> getPositions() {
        if (this.positions == null) {
            this.positions = new ArrayList();
        }
        return this.positions;
    }

    public String getSnAppid() {
        return this.snAppid;
    }

    public Map<String, String> getUnionAppids() {
        if (this.unionAppids == null) {
            this.unionAppids = new HashMap();
        }
        return this.unionAppids;
    }

    public void setGromoreAppid(String str) {
        this.gromoreAppid = str;
    }

    public void setPositions(List<AdSlots> list) {
        this.positions = list;
    }

    public void setSnAppid(String str) {
        this.snAppid = str;
    }

    public void setUnionAppids(Map<String, String> map) {
        this.unionAppids = map;
    }
}

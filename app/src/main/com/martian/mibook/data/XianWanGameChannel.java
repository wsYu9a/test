package com.martian.mibook.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class XianWanGameChannel {
    public static final int GAME_CHANNEL_TYPE_XIAN_WAN_SWITCH = 10001;
    private List<XianWanGame> gameList;
    private Integer mcid;

    public List<XianWanGame> getGameList() {
        if (this.gameList == null) {
            this.gameList = new ArrayList();
        }
        return this.gameList;
    }

    public Integer getMcid() {
        Integer num = this.mcid;
        return Integer.valueOf(num == null ? -1000 : num.intValue());
    }

    public void setGameList(List<XianWanGame> list) {
        this.gameList = list;
    }

    public void setMcid(Integer num) {
        this.mcid = num;
    }
}

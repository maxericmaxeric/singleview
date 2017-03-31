package com.ecsolutions.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public class CallMemo_Entity {
    private String CALLDTE;
    private List<Memo_Entity> memo_entityList;

    public String getCALLDTE() {
        return CALLDTE;
    }

    public void setCALLDTE(String CALLDTE) {
        this.CALLDTE = CALLDTE;
    }

    public List<Memo_Entity> getMemo_entityList() {
        return memo_entityList;
    }

    public void setMemo_entityList(List<Memo_Entity> memo_entityList) {
        this.memo_entityList = memo_entityList;
    }
}

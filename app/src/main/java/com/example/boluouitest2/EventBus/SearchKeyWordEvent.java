package com.example.boluouitest2.EventBus;

public class SearchKeyWordEvent {
    public String keyword;

    public SearchKeyWordEvent(String str) {
        this.keyword = str;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }
}

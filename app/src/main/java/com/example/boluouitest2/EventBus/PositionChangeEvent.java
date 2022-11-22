package com.example.boluouitest2.EventBus;

public class PositionChangeEvent {
    public int from;
    public int position;

    public PositionChangeEvent(int i, int i2) {
        this.from = i;
        this.position = i2;
    }

    public int getFrom() {
        return this.from;
    }

    public int getPosition() {
        return this.position;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}

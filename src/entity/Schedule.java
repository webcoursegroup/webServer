package entity;

import java.sql.Date;
import java.util.ArrayList;

public class Schedule {
    private Date date;
    private ArrayList<User> peers;
    private ScheduleItem morningItem;
    private ScheduleItem noonItem;
    private ScheduleItem nightItem;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<User> getPeers() {
        return peers;
    }

    public void setPeers(ArrayList<User> peers) {
        this.peers = peers;
    }

    public ScheduleItem getMorningItem() {
        return morningItem;
    }

    public void setMorningItem(ScheduleItem morningItem) {
        this.morningItem = morningItem;
    }

    public ScheduleItem getNoonItem() {
        return noonItem;
    }

    public void setNoonItem(ScheduleItem noonItem) {
        this.noonItem = noonItem;
    }

    public ScheduleItem getNightItem() {
        return nightItem;
    }

    public void setNightItem(ScheduleItem nightItem) {
        this.nightItem = nightItem;
    }
}

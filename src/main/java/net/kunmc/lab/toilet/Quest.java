package net.kunmc.lab.toilet;

import org.bukkit.entity.Player;

public class Quest {

    /*プレイヤー個人のクエスト管理を行うインスタンス*/

    Player player;
    int nonPonponTime;
    int count;
    boolean living;

    public Quest(Player p){
        player = p;
        setTime();
        living = true;  //生死判定
    }

    private void setTime(){
        nonPonponTime = new java.util.Random().nextInt(CommandManager.maxNonPonponTime);
        count = nonPonponTime+CommandManager.ponponTime;
    }

    public void play(){
        if(count == 0){
            this.dead();
        }
    }

    public void dead(){
        this.living = false;
        this.player.setHealth(0);
        this.setTime();
    }



}

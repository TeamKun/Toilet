package net.kunmc.lab.toilet;

import org.bukkit.entity.Player;

public class Quest {

    /*プレイヤー個人のクエスト管理を行うインスタンス*/

    private Player player;
    private int nonPonponTime;
    private int count;
    private boolean living;


    public Quest(Player p){
        player = p;
        resetCount();
        living = true;  //生死判定
    }

    public void play(){
        if(count <= 0){
            this.dead();
        }
    }

    public void dead(){
        this.living = false;
        this.player.setHealth(0);
        this.resetCount();
    }

    private void resetCount(){
        nonPonponTime = new java.util.Random().nextInt(net.kunmc.lab.toilet.Config.getMaxNonPonponTime());
        count = nonPonponTime+ net.kunmc.lab.toilet.Config.getPonponTime();
    }

    public void reduceCount(){
        this.count--;
    }

    public int getCount() {
        return count;
    }

    public boolean isLiving(){
        return living;
    }
}

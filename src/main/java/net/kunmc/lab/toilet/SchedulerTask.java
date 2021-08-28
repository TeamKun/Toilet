package net.kunmc.lab.toilet;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SchedulerTask extends BukkitRunnable {

    /*毎秒行う処理*/
    public void run(){
        if (!Toilet.plugin.running) {
            this.cancel();
            return;
        }

        for (Player key : Toilet.qM.keySet()) {
            if(key.getGameMode() == GameMode.SPECTATOR) continue;
            if(!Toilet.qM.get(key).living) continue;
            Toilet.qM.get(key).count--;
            Toilet.qM.get(key).play();
        }
    }
}

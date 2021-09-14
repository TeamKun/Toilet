package net.kunmc.lab.toilet;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.LinearComponents;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;
import static net.kyori.adventure.text.Component.text;

public final class Toilet extends JavaPlugin implements Listener{

    static Map<Player,Quest> qM = new HashMap<>();//各自のクエスト用インスタンスを保管
    static Toilet plugin = new Toilet();
    boolean running = false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(plugin, plugin);
        this.getCommand("toilet").setExecutor(new CommandManager());
    }


    /*開始時処理*/
    public void start(){
        if(this.running) return;
        qM.clear();
        for (Player p : plugin.getServer().getOnlinePlayers()) {
            if(p.getGameMode() == GameMode.SPECTATOR) continue;
            qM.put(p,new Quest(p));  //一人ずつクエスト用インスタンスを生成し、qMに追加する
        }
        running = true;
        this.timer();
    }

    /*終了時処理*/
    public void stop(){
        running = false;
    }

    /*タイマー生成*/
    public void timer(){
        new SchedulerTask().runTaskTimer(plugin,0L,20L);
    }


    /*死んだ際のメッセージ処理*/
    @EventHandler
    public static void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if(!qM.get(p).isLiving()) {    //うんちを漏らした以外の理由で死んだ場合のための回避
            Component message = LinearComponents.linear(text(p.getName() + "はうんちを漏らした!恥ずかしくて生きていけない!"));
            e.deathMessage(message);
            //qM.get(p).living = true; //要検討
        }
    }
}

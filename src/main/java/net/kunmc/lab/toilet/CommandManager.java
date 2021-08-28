package net.kunmc.lab.toilet;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandManager implements CommandExecutor, TabCompleter {

    static float x=0,y=0,z=0,radius=30;
    static int ponponTime = 30,maxNonPonponTime = 150;
    static int respawnTime = 0;
    static int toiletNum = 10;
    static boolean displayBar = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length <= 0) {
            sender.sendMessage("エラー：引数が足りない！");
            return false;
        }

        if (!args[0].equals("toilet")) {
            return false;
        }

        switch(args[1]){
            case "help" :
                final String[] HELP_MESSAGE = {
                        "-------------- [ " + ChatColor.GREEN + "Toilet Plugin" + ChatColor.RESET + " ] ---------------",
                        "/toilet on",
                        "/toilet off",
                        "/toilet setWorld <x,y,z,int 半径> : ワールド範囲指定",
                        "/toilet ponponTime <int> : 腹痛時間",
                        "/toilet maxNonPonponTime <int> : 腹痛でない時間の最大値",
                        "/toilet toiletNum <int>  : トイレの数",
                        "/toilet respawnTime <int>: リスポーン待機時間　",
                        "/toilet displayBar <boolean> : 残り時間バーの表示の有無",
                        "--------------------------------------------",
                };
                Stream.of(HELP_MESSAGE).forEach(sender::sendMessage);
                break;
            case "on" :
                Toilet.plugin.start();
                break;
            case "off" :
                Toilet.plugin.stop();
                break;
            case "setWorld" :
                break;
            case "ponponTime" :
                break;
            case "maxNonPonponTime" :
                break;
            case "toiletNum" :
                break;
            case "respawnTime" :
                break;
            case "displayBar" :
                break;
            default :
                sender.sendMessage("エラー：不正な引数です。");
                return false;
        }


    return true;

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Stream.of("on","off","setWorld","ponponTime","maxNonPonponTime","toiletNum","respawnTime","displayBar")
                    .filter(e -> e.startsWith(args[0]))
                    .collect(Collectors.toList());
        }

        if (args.length == 2) {
            switch(args[0]){
                case "on" :

                    break;
                case "off" :

                    break;
                case "setWorld" :
                    break;
                case "ponponTime" :

                    break;
                case "maxNonPonponTime" :

                    break;
                case "toiletNum" :

                    break;
                case "respawnTime" :

                    break;
                case "displayBar" :

                    break;
            }


            return Stream.of("on","off","setWorld","ponponTime","maxNonPonponTime","toiletNum","respawnTime","displayBar")
                    .filter(e -> e.startsWith(args[0]))
                    .collect(Collectors.toList());
        }









        // setWorld
        if (args.length == 2 && args[0].equals("setWorld")) {
            if (args[1].length() == 0) {
                return Collections.singletonList("40");
            }
        }





        return null;
    }

}

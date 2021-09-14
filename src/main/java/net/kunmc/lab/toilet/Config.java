package net.kunmc.lab.toilet;

public class Config {
    private static float x=0,y=0,z=0,radius=30;
    private static int ponponTime = 30,maxNonPonponTime = 150;
    private static int respawnTime = 0;
    private static int toiletNum = 10;
    private static boolean displayBar = false;


    /*セッター*/
    public static void setRange(float x, float y, float z, float radius){
        Config.x = x;
        Config.y = y;
        Config.z = z;
        Config.radius = radius;
    }

    public static void setPonponTime(int ponponTime) {
        Config.ponponTime = ponponTime;
    }

    public static void setMaxNonPonponTime(int maxNonPonponTime) {
        Config.maxNonPonponTime = maxNonPonponTime;
    }

    public static void setRespawnTime(int respawnTime) {
        Config.respawnTime = respawnTime;
    }

    public static void setToiletNum(int toiletNum) {
        Config.toiletNum = toiletNum;
    }

    public static void setDisplayBar(boolean displayBar) {
        Config.displayBar = displayBar;
    }

    public static int getPonponTime(){
        return ponponTime;
    }

    public static int getMaxNonPonponTime(){
        return maxNonPonponTime;
    }





}

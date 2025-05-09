package behavior_patterns;

public class TemplatePattern {
    public static void main(String[] args) {
        EggFireRice eggFireRice = new EggFireRice();
        eggFireRice.excute();
    }

}

abstract class CookTemplate{
    public final void excute(){
        fire();
        putMeta();
        offFire();
    }

    public void fire(){
        System.out.println("点火");
    }

    public abstract void putMeta();

    public void offFire(){
        System.out.println("关火");
    }
}

class EggFireRice extends CookTemplate{

    @Override
    public void putMeta() {
        System.out.println("放入鸡蛋和米饭");
    }
}
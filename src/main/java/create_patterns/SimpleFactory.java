package create_patterns;

public class SimpleFactory {
    public static void main(String[] args) {
        Phone xiaomi = new PhoneFactory().getPhone("小米");
        xiaomi.sendMessage("");
    }
}

//抽象产品
interface Phone{
    void sendMessage(String msg);
    void call(String msg);
}
//具体产品
class Xiaomi implements Phone{

    @Override
    public void sendMessage(String msg) {
        System.out.println("小米手机发短信");
    }

    @Override
    public void call(String msg) {
        System.out.println("小米手机打电话");

    }
}
class Huawei implements Phone{

    @Override
    public void sendMessage(String msg) {
        System.out.println("华为手机发短信");
    }

    @Override
    public void call(String msg) {
        System.out.println("华为手机打电话");

    }
}


//具体工厂
class PhoneFactory{

    Phone getPhone(String name){
        if (name.equals("小米")){
            return new Xiaomi();
        }else if (name.equals("华为")){
            return new Huawei();
        }
        return null;
    }

}

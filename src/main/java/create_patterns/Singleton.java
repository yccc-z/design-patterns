package create_patterns;

public class Singleton {
    public static void main(String[] args) {
        EagerSingleton instance = EagerSingleton.getInstance();
    }
}
//饿汉式
class EagerSingleton {
    // 类加载时即初始化实例
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // 私有构造函数防止外部实例化
    private EagerSingleton() {}

    // 提供全局访问点
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
//懒汉式（延迟初始化，需处理线程安全）
class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    // 非线程安全实现（不推荐）
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
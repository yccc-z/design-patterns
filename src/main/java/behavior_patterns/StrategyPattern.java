package behavior_patterns;

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.performAction();
    }
}
interface Strategy {
    void execute(); // 策略行为方法
}

 class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("执行策略A的逻辑：使用A*算法规划路径");
    }
}

 class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("执行策略B的逻辑：使用动态窗口法避障");
    }
}

class Context {
    private Strategy strategy; // 当前策略

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy; // 动态切换策略
    }

    public void performAction() {
        strategy.execute(); // 委托当前策略执行
    }
}
package behavior_patterns;

/**
 * 状态模式的适用场景
 * 对象行为随状态动态变化
 * 例如：
 * 订单系统：状态包括“未支付”“已支付”“已发货”“已完成”。
 * 游戏角色：状态包括“空闲”“攻击”“防御”“死亡”。
 * 网络连接：状态包括“连接中”“已连接”“断开连接”。
 * 状态迁移复杂且频繁
 * 例如：
 * 审批流程：状态从“提交”→“审核中”→“通过”→“归档”，不同状态可触发邮件通知、日志记录等行为。
 * 设备控制：空调模式从“制冷”→“制热”→“通风”，温度调节逻辑与当前模式强相关。
 * 避免条件分支失控
 * 例如：
 * UI状态管理：按钮在不同状态（可用/禁用/加载中）下显示不同样式和行为，避免在视图层写大量条件判断。
 */
public class StatePattern {
    public static void main(String[] args) {
        Context_x context =new Context_x(new ConcreteStateA());
        context.request();
        context.request();

    }
}

interface State{
    void handle(Context_x context);
}


class ConcreteStateA implements State {
    @Override
    public void handle(Context_x context) {
        System.out.println("当前状态A的行为逻辑");
        // 触发状态迁移（可选）
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB implements State {
    @Override
    public void handle(Context_x context) {
        System.out.println("当前状态B的行为逻辑");
        // 保持状态或迁移至其他状态
    }
}
class Context_x {
    private State currentState; // 当前状态

    public Context_x(State initialState) {
        this.currentState = initialState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle(this); // 委托当前状态处理请求
    }
}

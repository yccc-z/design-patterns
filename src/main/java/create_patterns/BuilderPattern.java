package create_patterns;

import lombok.Data;

/**
 * 建造者模式
 * 类：具体产品，抽象建造者，具体建造者，指挥者（可有可无）
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Product product = new BuilderImpl().builderName("小明").builderContent("小明6岁了").build();

        System.out.println(product);
    }
}

@Data
class Product{
    String name;
    String content;
}

interface Builder{
    Builder builderName(String name);
    Builder builderContent(String content);
    Product build();
}

class BuilderImpl implements Builder{

    Product product = new Product();
    @Override
    public Builder builderName(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public Builder builderContent(String content) {
        product.setContent(content);
        return this;
    }

    @Override
    public Product build() {
        return product;
    }
}

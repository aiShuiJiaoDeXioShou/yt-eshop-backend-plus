package com.yangteng.api.comm;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.Collections;

public class TableToEntityConstructor {
    private static String basePath = "D:\\Code\\javaworkspace\\yt-eshop-backend-plus\\src\\main\\";
    private static String basePath2 = "D:\\ytjava\\ideayt\\yt-eshop-backend-plus\\src\\main\\";

    // 新版本的代码生成器
    public static void AutoTable(String entity_package, String mapper_package, String service_package, String... tables) {
        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/shopping1?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false",
                        "root",
                        "yt2002")
                .globalConfig(builder -> {
                    builder.author("林河") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir()
                            .commentDate("yyyy-MM-dd")
                            // 指定输出目录
                            .outputDir(basePath + "java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.yangteng") // 设置父包名
                            .moduleName("api") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    basePath + "\\resources\\mapper"))
                            .entity(entity_package.isEmpty() ? "entity" : entity_package)
                            .mapper(mapper_package.isEmpty() ? "mapper" : mapper_package)
                            .service(service_package.isEmpty() ? "service" : service_package)
                            .serviceImpl(service_package.isEmpty() ? "service.impl" : service_package + ".impl");
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("t_", "c_", "ua_")// 设置过滤表前缀
                            .build()
                            .entityBuilder()
                            .enableChainModel()
                            // 设置采用Lombok策略
                            .enableLombok()
                            .enableChainModel()
                            .enableTableFieldAnnotation()
                            .logicDeletePropertyName("isDel")
                            .idType(IdType.ASSIGN_ID)
                            .enableFileOverride()
                            .addTableFills(
                                    new Property("updateTime", FieldFill.INSERT_UPDATE),
                                    new Property("createTime", FieldFill.INSERT),
                                    new Property("createUser", FieldFill.INSERT),
                                    new Property("updateUser", FieldFill.INSERT_UPDATE)

                            )
                            .build();
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER).entity("ftl/entity");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    public static void main(String[] args) {

        TableToEntityConstructor.AutoTable(
                "entity",
                "mapper",
                "service",
                "store_order", "store_cart", "store_order_cart_info"
        );
    }
}

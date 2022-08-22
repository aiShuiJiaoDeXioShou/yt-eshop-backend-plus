package com.yangteng.api.comm;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.Collections;

public class CodeAuto {
    // 新版本的代码生成器
    public static void AutoTable(String... tables){
        FastAutoGenerator.create(
                "jdbc:mysql://localhost:3306/shopping1?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false",
                "root",
                "root")
                .globalConfig(builder -> {
                    builder.author("林河") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            // 覆盖已生成文件
                            .fileOverride()
                            .disableOpenDir()
                            .commentDate("yyyy-MM-dd")
                            // 指定输出目录
                            .outputDir("D:\\ytjava\\ideayt\\yt-eshop-backend-plus\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.yangteng") // 设置父包名
                            .moduleName("api") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\ytjava\\ideayt\\yt-eshop-backend-plus\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")// 设置过滤表前缀
                            .build()
                            .entityBuilder()
                            .enableChainModel()
                            // 设置采用Lombok策略
                            .enableLombok()
                            .logicDeletePropertyName("deleteFlag")
                            .idType(IdType.AUTO)
                            .addTableFills(
                                    new Property("updatedDate",FieldFill.INSERT_UPDATE),
                                    new Property("createdDate",FieldFill.INSERT),
                                    new Property("operatingUser",FieldFill.INSERT)

                            );
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER);
                })
                .execute();
    }

    public static void main(String[] args) {
        CodeAuto.AutoTable("category");
    }
}

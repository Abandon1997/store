package com.myc;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: luyu
 * @Description:
 * @Date:Create：in 2021/11/03 23:29
 * @Modified By：
 */
public class AutoCodeGenerator {

    public static void main(String[] args) {
        // 数据库配置
        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig
                .Builder("jdbc:mysql://localhost:3306/store" +
                "?useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true"
                , "root", "root");
        FastAutoGenerator.create(dataSourceConfigBuilder)
                // 全局配置
                .globalConfig((scanner, builder) -> {
                    builder.author(scanner.apply("请输入作者名称？"))
                            // 覆盖已生成文件
                            .fileOverride()
                            // 指定输出目录
                            .outputDir(System.getProperty("user.dir") + "/src/main/java/")
                            // 开启 swagger 模式
                            .enableSwagger()
                            // 禁止打开输出目录
                            .disableOpenDir()
                            // 时间策略
                            .dateType(DateType.TIME_PACK)
                            // 类注释日期的格式
                            .commentDate("yyyy-MM-dd HH:mm:ss")
                            .build();
                })
                // 包配置
                .packageConfig((scanner, builder) -> {
                    // 父包名
                    builder.parent(scanner.apply("请输入父包名？"))
                            // 模块名
                            .moduleName(scanner.apply("请输入模块名？"))
                            // Entity 包名
                            .entity("entity")
                            // Service 包名
                            .service("service")
                            //	Service Impl 包名
                            .serviceImpl("service.impl")
                            // Controller 包名
                            .controller("controller")
                            // Mapper 包名
                            .mapper("mapper")
                            // MapperXML 包名
                            .xml("mapper")
                            // 路径配置信息
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/src/main/resources/mapper/"));
                })
                //策略配置
                .strategyConfig((scanner, builder) -> {
                    // 增加表匹配(内存过滤)，	include 与 exclude 只能配置一项
                    builder.addInclude(getTables(scanner.apply("请输入要生成的表名，多个英文逗号分隔？所有输入 all")))
                            // 	增加表排除匹配(内存过滤)，	include 与 exclude 只能配置一项
                            // .addExclude(scanner.apply("请输入要忽略的表名，多个英文逗号分隔？"))
                            // 	增加过滤表后缀
                            .addTableSuffix("")
                            // 	增加过滤表前缀
                            .addTablePrefix("t_")
                            // service 策略配置
                            .serviceBuilder()
                            // 	格式化文件名称
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            // 实体策略配置
                            .entityBuilder()
                            // 开启 lombok 模型
                            .enableLombok()
                            // 开启生成实体时生成字段注解
                            .enableTableFieldAnnotation()
                            // controller 策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")
                            // 开启生成@RestController 控制器
                            .enableRestStyle()
                            // 	mapper 策略配置
                            .mapperBuilder()
                            // 设置父类
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    /**
     * 处理 all 情况
     *
     * @param tables
     * @return
     */
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}


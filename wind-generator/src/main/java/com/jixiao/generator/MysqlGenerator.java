package com.jixiao.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiang
 * @since 2018-09-19
 */
public class MysqlGenerator {

    public static void main(String[] args) {
        String outputDir = "C:\\generator";

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
            // 全局配置
            new GlobalConfig()
                // 输出目录
                .setOutputDir(outputDir)
                // 是否覆盖文件
                .setFileOverride(true)
                // 开启 activeRecord 模式
                .setActiveRecord(false)
                // XML 二级缓存
                .setEnableCache(false)
                // XML resultMap
                .setBaseResultMap(false)
                // XML columnList
                .setBaseColumnList(true)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("I%sMapper")
                // 自定义时间类型
                .setDateType(DateType.ONLY_DATE)
                // author
                .setAuthor("jiang")
            ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                    .setDbType(DbType.MYSQL)
                    .setDriverName("com.mysql.jdbc.Driver")
                    .setUsername("jixiao")
                    .setPassword("U2FsdGVkX1/kI8gTEbiDwpdHxVl0Jf4+3lzKJr+kdCAYhTLEIqs=")
                    .setUrl("jdbc:mysql://101.132.116.108:3306/first_see_test?characterEncoding=utf8")
            ).setStrategy(
                // 策略配置
                new StrategyConfig()
                    // 此处可以修改为您的表前缀
                    //.setTablePrefix("")
                    // 表名生成策略
                    .setNaming(NamingStrategy.underline_to_camel)
                    // 需要生成的表
                    .setInclude("user_dynamic")
                    // restController
                    .setRestControllerStyle(true)
                    // superController
                    .setSuperControllerClass("com.jixiao.common.base.BaseController")
        );

        // 21行设置生成路径；以下2个是分包路径，跟59行结合使用
        String controllerPath = "api.modular";
        String mapperPath = "user";

        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outputDir + "/mapper/" + mapperPath + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        mpg.setCfg(new InjectionConfig() {
                    @Override
                    public void initMap() {

                    }
                }.setFileOutConfigList(focList)
        ).setTemplate(new TemplateConfig()
                .setXml(null)
        ).setPackageInfo(
            // 包配置
            new PackageConfig()
                // 自定义包路径
                .setParent("com.jixiao")
                .setEntity(mapperPath + ".entity")
                .setMapper(mapperPath + ".mapper")
                .setService(controllerPath + "." + mapperPath + ".service")
                .setServiceImpl(controllerPath + "." + mapperPath + ".service.impl")
                .setController(controllerPath + "." + mapperPath + ".controller")
        );

        // 执行生成
        mpg.execute();
    }

}

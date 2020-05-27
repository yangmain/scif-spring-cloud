package com.greenever.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuik
 */
public class CodeGenerator {


    private final static String DB_URL = "jdbc:mysql://eureka1.greenever.com:3306/account?useUnicode=true&useSSL=false&characterEncoding=utf8";

    private final static String USER_NAME = "root";

    private final static String PASSWORD = "Hx20@Mysql20cq";

    private final static String PACKAGE_NAME = "com.greenever";
    /**
     * TODO  当前模块名称 需手工修改
     */
    private final static String MODULE_NAME = "payment";
    /**
     * TODO  当前模块名称 需手工修改
     */
    private static String PROJECT_NAME = "scif-spring-cloud-model";
    /**
     * 表名，多个表","分割
     */
    private static String[] tables = {"open_account_online_application"};


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir" );
        gc.setOutputDir(projectPath + "/" + PROJECT_NAME + "/src/main/java" );
        gc.setAuthor("Mybatis Plus Generator" );
        gc.setOpen(false);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        //文件覆盖
        gc.setFileOverride(true);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);


        mpg.setDataSource(dataSource());

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE_NAME);
        pc.setParent(PACKAGE_NAME);
        pc.setEntity("po" );
        mpg.setPackageInfo(pc);

        // 自定义配置 模板中使用 ${cfg.typeHandler}
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("typeHandler", "cuikang" );
                this.setMap(map);
            }
        };

        String mapperXmlTemplate = "customtemplates/mapper.xml.ftl";
        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        //自定义配置会被优先输出
        focList.add(new FileOutConfig(mapperXmlTemplate) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                tableInfo.setImportPackages("com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler" );
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/" + PROJECT_NAME + "/src/main/resources/mappers/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        String daoTemplate = "customtemplates/dao.java.ftl";
        focList.add(new FileOutConfig(daoTemplate) {
            @Override
            public String outputFile(TableInfo tableInfo) {
//                return projectPath + "/" + PROJECT_NAME + "/src/java/com/" + tableInfo.getEntityName() + "Dao"+ StringPool.DOT_JAVA;
                return projectPath + "/" + PROJECT_NAME +"/src/main/java/" + tableInfo.getEntityName() + "Dao"+ StringPool.DOT_JAVA;
            }
        });
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                if (fileType == FileType.ENTITY) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return true;
                }
                // 允许生成模板文件
                return !new File(filePath).exists();
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("customtemplates/entity.java" );
        templateConfig.setService("customtemplates/service.java" );
        templateConfig.setController("customtemplates/controller.java" );
        templateConfig.setMapper("customtemplates/mapper.java" );
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


        mpg.setStrategy(getStrategy());
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    private static DataSourceConfig dataSource() {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver" );
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
    /*    dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //自定义类型转换
                if (fieldType.toLowerCase().contains("datetime")) {
                    return DbColumnType.DATE;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });*/
        return dsc;
    }


    /**
     * 策略配置
     *
     * @return StrategyConfig
     */
    private static StrategyConfig getStrategy() {

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id" );
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        //是否生成实体时，生成字段注解@TableField
//        strategy.setEntityTableFieldAnnotationEnable(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_" );
        //乐观锁属性名称
        strategy.setVersionFieldName("lock_version" );
        //逻辑删除属性名称
        strategy.setLogicDeleteFieldName("record_status" );
        //表填充字段
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("record_status", FieldFill.INSERT));
        tableFills.add(new TableFill("lock_version", FieldFill.INSERT));
        tableFills.add(new TableFill("create_time", FieldFill.INSERT));
        tableFills.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        strategy.setTableFillList(tableFills);

        return strategy;
    }

}
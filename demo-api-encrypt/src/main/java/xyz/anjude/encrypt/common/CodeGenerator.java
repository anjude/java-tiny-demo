package xyz.anjude.encrypt.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * CodeGenerator  代码生成类
 *
 * @author whr
 * @date 2021/8/27 11:07
 */
public class CodeGenerator {

    @Test
    public void run() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");

        gc.setAuthor("anjude");
        // 生成后是否打开资源管理器
        gc.setOpen(false);
        // 重新生成时文件是否覆盖
        gc.setFileOverride(false);

        // UserService
        // 去掉Service接口的首字母I
        gc.setServiceName("%sService");

        // 主键策略
        gc.setIdType(IdType.ID_WORKER_STR);
        // 定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 开启Swagger2模式
        gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://39.108.128.80:3306/weindex_index?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("wei1@mysql");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        // 包 xyz.anjude
        pc.setParent("xyz.anjude");
        // 包  xyz.anjude.encrypt
        // 模块名
        pc.setModuleName("encrypt");
        // 包  xyz.anjude.index.controller
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

//        strategy.setInclude("index_.*");

        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);

        // 生成实体时去掉表前缀
        strategy.setTablePrefix("index_");

        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);

        // 逻辑删除字段名
        strategy.setLogicDeleteFieldName("is_deleted");

        // 去掉布尔值的is_前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        // 乐观锁列
        strategy.setVersionFieldName("version");

        // restful api风格控制器
        strategy.setRestControllerStyle(true);
        // url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);


        // 6、执行
        mpg.execute();
    }
}

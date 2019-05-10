package org.vertex.springcloudvertexclient;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhe
 * @date 2018/1/11
 */
public class GeneratorSqlmap {

    public void generator() throws Exception {

        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;

        //指定 逆向工程配置文件
        String basePath = System.getProperty("user.dir");
        File configFile = new File(basePath + "/spring-cloud-vertex-client/src/main/resources/generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        System.out.println("成功");
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception {
        try {
            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

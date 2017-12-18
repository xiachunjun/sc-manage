import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MapperGenerator {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		final boolean overwrite = true;
		File configFile = new File("/Users/xcj/git/ggstudy/ggstudy-web/src/test/resources/mysqlGeneratorConfig.xml");
		
		// System.out.println("config fiel is in : " +
		// configFile.getAbsoluteFile());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration configuration;
		try {
			configuration = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator mybatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
			mybatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

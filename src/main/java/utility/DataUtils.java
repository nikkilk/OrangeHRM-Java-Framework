package utility;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.github.javafaker.Faker;

import base.BaseClass;
import enums.YamlEnums;
import lombok.SneakyThrows;

public class DataUtils extends BaseClass {
	public static Faker faker = new Faker();
	
	@SuppressWarnings("unchecked")
	@SneakyThrows
	public static List<String> readYamlFile(String filePath, String key) {
		Yaml yaml = new Yaml();
		FileInputStream fis = new FileInputStream(filePath);
		Map<String, Object> yamlMap = yaml.load(fis);
		return (List<String>) yamlMap.get(key);
	}
	
	@SuppressWarnings({ "unchecked" })
	public static String yamlData(YamlEnums key, int index) {
		List<String> list= (List<String>) yamlMap.get(key.name());
		return list.get(index);
	}
	

}

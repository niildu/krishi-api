package com.cropaccounting.krishi.api.clientapi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.cropaccounting.krishi.api.clientapi.model.Blocks;
import com.cropaccounting.krishi.api.clientapi.model.Crops;
import com.cropaccounting.krishi.api.clientapi.model.Varieties;

/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
	private static final String url = "http://107.170.4.9:3030/api";
	private static KrishiAPI service;
	private static Properties appProps;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InputStream inputStream = AppTest.class.getClassLoader().getResourceAsStream("application-test.properties");
		appProps = new Properties();
		if(inputStream != null)
			appProps.load(inputStream);

		String TESTURI = url;//appProps.getProperty("fareharbor.api.url");
		String appKey = appProps.getProperty("fareharbor.api.appKey");
		String userKey = appProps.getProperty("fareharbor.api.userKey");
		service = KrishiAPI.connect(TESTURI, null);
	}
	
	@Test
	public void test1BlockList() {
		Blocks companies = service.getBlocks();
		assertNotNull(companies);
		assertFalse(companies.getData().isEmpty());
	}
	
	@Test
	public void test2CropList() {
		Crops crops = service.getCrops();
		assertNotNull(crops);
		assertFalse(crops.getData().isEmpty());
	}
	
	@Test
	public void test3VarietyList() {
		Varieties crops = service.getVarieities();
		assertNotNull(crops);
		assertFalse(crops.getData().isEmpty());
	}
}

package com.impactiva.smoke.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.impactiva.smoke.script.BaseTestNG;

public class Common_Class extends BaseTestNG {

	public static final int DEFAULT_WAIT = 600;
	public static final int DEFAULT_WAIT_FOR_VIDEO = 60;
    public static int numberOfIterationsForFetchingVideo = 6;
	public static String hubURL;
	public static int oneSec;
	public static int twoSec;
	public static int threeSec;
	public static int hostPort;
	public static int gridPort;
	public static String initialPassword;
	public static String password;
	public static String AuthorCAI;
	public static String AuthorFirstName;
	public static String AuthorLastName;
	public static String AuthorEmail;
	public static String AuthorPassword;
	public static String AdminCAI;
	public static String AdminFirstName;
	public static String AdminLastName;
	public static String AdminEmail;
	public static String AdminPassword;
	public static int numberOfIterationsToFetchVideo = 6;

	public static String imusername;
	public static String impassword;

	public static void waitForMilliseconds(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void startDeleting(String path) {
		List<String> filesList = new ArrayList<String>();
		List<String> folderList = new ArrayList<String>();
		fetchCompleteList(filesList, folderList, path);
		for (String filePath : filesList) {
			File tempFile = new File(filePath);
			tempFile.delete();
		}
		for (String filePath : folderList) {
			File tempFile = new File(filePath);
			tempFile.delete();
		}
	}

	public static void fetchCompleteList(List<String> filesList, List<String> folderList, String path) {
		File file = new File(path);
		File[] listOfFile = file.listFiles();
		for (File tempFile : listOfFile) {
			if (tempFile.isDirectory()) {
				folderList.add(tempFile.getAbsolutePath());
				fetchCompleteList(filesList, folderList, tempFile.getAbsolutePath());
			} else {
				filesList.add(tempFile.getAbsolutePath());
			}

		}

	}

	public static String selectEnvironment(String environmentSelected) throws IOException {

		Properties prop = new Properties();
		InputStream commonInput = null;
		try {
			commonInput = new FileInputStream("./TestData/environments.properties");
			prop.load(commonInput);
			return prop.getProperty(environmentSelected.toLowerCase());
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (commonInput != null) {
				try {
					commonInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void fetchAllData() {
		Properties prop = new Properties();
		InputStream commonInput = null;
		try {

			// Load a common properties file
			commonInput = new FileInputStream("./TestData/CommonData.properties");
			prop.load(commonInput);

			hubURL = prop.getProperty("hubURL");
			oneSec = Integer.parseInt(prop.getProperty("wait1sec"));
			twoSec = Integer.parseInt(prop.getProperty("wait2sec"));
			threeSec = Integer.parseInt(prop.getProperty("wait3sec"));
			initialPassword = prop.getProperty("initialPassword");
			password = prop.getProperty("password");
			hostPort = Integer.parseInt(prop.getProperty("hostPort"));
			gridPort = Integer.parseInt(prop.getProperty("gridPort"));


			commonInput = new FileInputStream("./TestData/UserCredentials.properties");
			prop.load(commonInput);

			AuthorFirstName = prop.getProperty("AuthorFirstName");
			AuthorLastName = prop.getProperty("AuthorLastName");
			AuthorEmail = prop.getProperty("AuthorEmail");
			AuthorCAI = prop.getProperty("AuthorCAI")+timeStamp;
			AuthorPassword = prop.getProperty("AuthorPassword");
			
			AdminFirstName = prop.getProperty("AdminFirstName");
			AdminLastName = prop.getProperty("AdminLastName");
			AdminEmail = prop.getProperty("AdminEmail");
			AdminCAI = prop.getProperty("AdminCAI")+timeStamp;
			AdminPassword = prop.getProperty("AdminPassword");

			imusername = prop.getProperty("IMUsername");
			impassword = prop.getProperty("IMPassword");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (commonInput != null) {
				try {
					commonInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

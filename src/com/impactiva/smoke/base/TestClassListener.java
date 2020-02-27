package com.impactiva.smoke.base;

import com.impactiva.smoke.lib.Common_Class;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.IClassListener;
import org.testng.ITestClass;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class TestClassListener implements IClassListener {

    @Override
    public void onBeforeClass(ITestClass testClass) {

    }

    @Override
    public void onAfterClass(ITestClass testClass) {
        try {
            Common_Class.waitForMilliseconds(Common_Class.threeSec);
            fetchVideo( testClass,testClass.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ( DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().close();
        }
    }

    private void fetchVideo(ITestClass testClass,String className) {

        BufferedOutputStream outStream = null;

        try {
            InputStream is = null;
            try {
                URL url,urlHost;
                byte[] buf;
                int byteRead;
                urlHost = new URL(getFinalLocation(Common_Class.hubURL));
                String[] nodeAdndPort = getHostNameAndPort(urlHost.getHost(), Common_Class.hostPort,
                        ((RemoteWebDriver) DriverFactory.getDriver()).getSessionId());
                url = new URL(getFinalLocation("http://" + nodeAdndPort[0] + ":" + Common_Class.gridPort + ""));// instantiated
                // URL
                // object
                String videoURL = "http://" + url.getHost() + ":" + url.getPort() + "/download_video/"
                        + ((RemoteWebDriver) DriverFactory.getDriver()).getSessionId().toString() + ".mp4";
                url = new URL(videoURL);
                File outputVideo = new File(System.getProperty("user.dir") + "\\"
                        +"videos"+ "\\" +className +"\\"+className+ ".mp4");
                if (!outputVideo.getParentFile().exists()) {
                    outputVideo.getParentFile().mkdirs();
                }

                try {
                    outputVideo.createNewFile();
                } catch (Exception e) {
                    System.out.println("error in creating file or file already exists");
                    e.printStackTrace();
                }

                Common_Class.waitForMilliseconds(Common_Class.twoSec);

                outStream = new BufferedOutputStream(new FileOutputStream(System.getProperty("user.dir") + "\\"
                        +"videos"+ "\\" +className +"\\"+className+ ".mp4"));

                URLConnection conn = url.openConnection();
                int i = 0;
                while (i != Common_Class.numberOfIterationsForFetchingVideo) {
                    Common_Class.waitForSeconds(Common_Class.DEFAULT_WAIT_FOR_VIDEO);
                    try {
                        conn = url.openConnection();
                        is = conn.getInputStream();
                        break;
                    } catch (Exception e) {
                        System.out.println("Still waiting for the video to load...");
                    }
                    i++;
                }

                int size = 1024;
                buf = new byte[size];
                while ((byteRead = is.read(buf)) != -1) {
                    outStream.write(buf, 0, byteRead);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Fetches ip address and port number of the node using session id
    private static String[] getHostNameAndPort(String hostName, int port, SessionId session) {
        String[] hostAndPort = new String[2];
        String errorMsg = "Failed to acquire remote webdriver node and port info. Root cause: ";

        try {
            HttpHost host = new HttpHost(hostName, port);

            CloseableHttpClient client = HttpClientBuilder.create().build();
            URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session=" + session);
            BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST",
                    sessionURL.toExternalForm());
            HttpResponse response = client.execute(host, r);
            JSONObject object = extractObject(response);
            URL myURL = new URL(object.getString("proxyId"));
            if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
                hostAndPort[0] = myURL.getHost();
                hostAndPort[1] = Integer.toString(myURL.getPort());
            }
        } catch (Exception e) {
            throw new RuntimeException(errorMsg, e);
        }
        return hostAndPort;
    }

    //Extracts the jsonObject from Node
    private static JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
        StringBuffer s = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            s.append(line);
        }

        rd.close();
        JSONObject objToReturn = new JSONObject(s.toString());

        return objToReturn;
    }

    private static String getFinalLocation(String address) throws IOException {
        URL url = new URL(address);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        int status = conn.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM
                    || status == HttpURLConnection.HTTP_SEE_OTHER) {
                String newLocation = conn.getHeaderField("Location");
                return getFinalLocation(newLocation);
            }
        }
        return address;
    }
}

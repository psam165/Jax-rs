package jetty.jersey.client;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

public class JettyJerseyClient {

	public static final String URL = "https://localhost:8443/Jax-rs/rest/Greet/";

	public static void main(String[] args) throws KeyStoreException, CertificateException, KeyManagementException, IOException {
		// TODO Auto-generated method stub

		try {
			SSLContext context = SSLContext.getInstance("TLS");
			char[] password = "javarest".toCharArray();
			KeyStore ks = KeyStore.getInstance("JKS");
			try (FileInputStream fin = new FileInputStream(
					"/home/vagrant/workspace/Jax-rs/src/main/resources/rest.ks")) {
				ks.load(fin, password);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SUNX509");

			tmf.init(ks);
			context.init(null, tmf.getTrustManagers(), null);

			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
			HttpsURLConnection securedConnection = (HttpsURLConnection) new URL(URL).openConnection();
			securedConnection.setDoInput(true);
			securedConnection.setDoOutput(true);

			securedConnection.setRequestMethod("GET");

			securedConnection.setHostnameVerifier(new HostnameVerifier() {

				public boolean verify(String hostname, SSLSession session) {
					// TODO Auto-generated method stub
					return hostname.equals("localhost") ? true : false;
				}
			});

			securedConnection.connect();
			try (InputStream in = securedConnection.getInputStream();
					ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
				byte[] buff = new byte[1024];
				int num;
			
				while ((num = in.read(buff)) != -1) {
					bout.write(buff);
				}
				
				System.out.println("Secured output" + new String(bout.toString()));
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

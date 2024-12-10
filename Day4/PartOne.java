import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PartOne {

	public static final String INPUT = "ckczppom";

	// NOTES
	//
	//
	public static void main(String[] args) {
		Integer i = 1;

		String testString = INPUT + i.toString();

		String md5Hash = getMD5Hash(testString);

		while (!md5Hash.startsWith("000000")) {
			i++;
			testString = INPUT + i.toString();
			md5Hash = getMD5Hash(testString);
		}

		System.out.println(i);
		System.out.println(md5Hash);

	}

	private static String getMD5Hash(String input) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			result = no.toString(16);

			while (result.length() < 32) {
				result = "0" + result;
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}

}

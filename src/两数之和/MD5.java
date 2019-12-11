package 两数之和;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class IP{
	public static String getMd5(String plainText) {

		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(plainText.getBytes());

			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");

			for (int offset = 0; offset < b.length; offset++) {

				i = b[offset];

				if (i < 0)

					i += 256;

				if (i < 16)

					buf.append("0");

				buf.append(Integer.toHexString(i));

			}

			// 32位加密

			return buf.toString();

			// 16位的加密

//			return buf.toString().substring(8, 24);  

		} catch (NoSuchAlgorithmException e) {

			return null;

		}

	}
	
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		while (true) {
			String str=inScanner.next();
			System.out.println("第一次加密："+getMd5(str));
			System.out.println("第二次加密："+getMd5(getMd5(str)));
			System.out.println("---------");
		}
	}
}

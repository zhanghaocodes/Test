package Home;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class IP{
	
    public String checkSum;
    public String header;
    public String source;
    public String destination;
    public String checkSumData;

    public IP(String ipHeader) {
        header = ipHeader;
        checkSum = header.substring(20, 24);
        source = header.substring(24, 32);
        destination = header.substring(32, 40);
        checkSumData = header.replace(checkSum, "0000");
    }

    @Override
    public String toString() {
    	String sendString=header.substring(0,20)+IP.makeChecksum(checkSumData)+header.substring(24);
    	
        return String.format(
                "ip\nchecksum_data: %s\nchecksum_data_length: %d\nchecksum_c: %s\nsend:%s\nreceive:%s\n",
                checkSumData, checkSumData.length(),  IP.makeChecksum(checkSumData),sendString,IP.makeChecksum(sendString));
    }

    //已知一个字符串,求该字符串的16进制累加和，已知一段字符串和校验码，校验和累加是否合法，话不多说了直接上代码。
    public static String makeChecksum(String data) {
        if (data == null || data.equals("")) {
            return "";
        }
        int total = 0;
        int len = data.length();
        // 不足16位补足
        for (int i = 0; i < len % 4; i++) {
            data += "0";
        }
        int num = 0;
        while (num < len) {
            String s = data.substring(num, num + 4);
            total += Integer.parseInt(s, 16);
             num = num + 4;
        }
        String hex = Integer.toHexString(total);
        //System.out.println("hex的值是："+hex);
        int result = Integer.parseInt(hex.substring(0, 1), 16) +
                Integer.parseInt(hex.substring(1), 16);
        result = ~result;
        String result_hex = Integer.toHexString(result);
        //System.out.println("result_hex的值是："+result_hex);
        //System.out.println("校验和为："+result_hex.substring(result_hex.length() - 4));
        return result_hex.substring(result_hex.length() - 4);
    }
}
public class HomeWork {
	public static void main(String[] args) {
        List<IP> ipList = new ArrayList<>();
        String path = "C:\\Users\\Administrator\\Desktop\\Network\\src\\datagram.txt";
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("ip:")) {
                    ipList.add(new IP(line.substring(3)));
                    
                } 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ipList.stream().forEach(System.out::println);
	}
	
}

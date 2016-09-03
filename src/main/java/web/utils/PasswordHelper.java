package web.utils;


import org.apache.shiro.crypto.hash.Md5Hash;
import web.comm.Constants;
import web.po.User;


public class PasswordHelper {
	private static final int SALT_SIZE = 8;

    /**
     * 加密
     * @param plainpw
     * @param saltStr
     * @return
     */
	public static String encodePasswd(String plainpw,String saltStr){
		byte[] salt = Encodes.decodeHex(saltStr);
		byte[] hashPassword = Digests.sha1(plainpw.getBytes(), salt, Constants.HASH_INTERATIONS);
		return Encodes.encodeHex(hashPassword);
	}

	public static void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, Constants.HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
	}

    /**
     * 判断输入的密码是否和数据库中保存的密码一致
     * @param user
     * @param painPasswd
     * @return
     */
	public static boolean checkPasswd(User user, String painPasswd){
		String enpasswd = encodePasswd(painPasswd, user.getSalt());
		if(enpasswd.equals(user.getPassword()))
			return true;
		else
			return false;
	}
	
	/**
	 * 判断输入的密码是否和数据库中保存的密码一致
	 * @param truePasswd 数据库中保存的密码
	 * @param salt 数据中salt值
	 * @param thisPasswd 当前需要确认的密码
	 * @return
	 */
	public static boolean checkPasswd(String truePasswd, String salt, String thisPasswd){
		String enpasswd = encodePasswd(thisPasswd, salt);
		if(enpasswd.equals(truePasswd))
			return true;
		else
			return false;
	}

    /**
     * shiro md5 加密
     * @param password
     * @param salt
     * @return
     */
    public static String Md5(String password,String salt){
        return new Md5Hash(password,salt).toHex();
    }

    public static void main(String[] args) {
        User user=new User();
        user.setPassword("12356");
        System.out.println(PasswordHelper.encodePasswd("123456","ecee6ac551f5cb28"));

        /**md5加密*/
       // System.out.println(PasswordHelper.Md5("123", "user"));

    }

}

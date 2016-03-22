package me.qisama.jxlx.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.Teacher;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("${password.algorithmName}")
    private static String algorithmName = "md5";
    @Value("${password.hashIterations}")
    private static int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        PasswordHelper.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        PasswordHelper.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        PasswordHelper.hashIterations = hashIterations;
    }

    public static void encryptPassword(Teacher teacher) {

    	teacher.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                teacher.getPassword(),
                ByteSource.Util.bytes(teacher.getCredentialsSalt()),
                hashIterations).toHex();

        teacher.setPassword(newPassword);
    }
    
    public static void encryptPasswordS(Student student) {
    	
    	student.setSalt(randomNumberGenerator.nextBytes().toHex());
    	
    	String newPassword = new SimpleHash(
                algorithmName,
                student.getPassword(),
                ByteSource.Util.bytes(student.getCredentialsSalt()),
                hashIterations).toHex();
    	
    	student.setPassword(newPassword);
    }
}

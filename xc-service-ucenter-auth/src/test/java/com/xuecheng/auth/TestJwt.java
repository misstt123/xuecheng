package com.xuecheng.auth;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyh-god
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJwt {

    //创建jwt令牌
    @Test
    public void testCreateJwt(){
        //密钥库文件
        String keystore = "xc1.keystore";
        //密钥库的密码
        String keystore_password = "xuechengkeystore";

        //密钥库文件路径
        ClassPathResource classPathResource = new ClassPathResource(keystore);
        //密钥别名
        String alias  = "xckey";
        //密钥的访问密码
        String key_password = "xuecheng";
        //密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,keystore_password.toCharArray());
        //密钥对（公钥和私钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, key_password.toCharArray());
        //获取私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //jwt令牌的内容
        Map<String,String> body = new HashMap<>();
        body.put("name","itcast");
        String bodyString = JSON.toJSONString(body);
        //生成jwt令牌
        Jwt jwt = JwtHelper.encode(bodyString, new RsaSigner(aPrivate));
        //生成jwt令牌编码
        String encoded = jwt.getEncoded();
        System.out.println(encoded);

    }

    //校验jwt令牌
    @Test
    public void testVerify(){
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAljJN7gYuIpcATfidfNsvnuT73GJcebFXQjyjf5R07bMBJPMu1Y3HsdxQWzPF937C3BzDm23bZ+k5LSTjruT2Vi5am+ZJQYNTJvgKFE9w9TvUH7yjWP7aC8mKAKp8KzGV3/oTcwLScKp2wNRXkMSPpEnpRkGqAQ0i4OxvE25FBXlZ6KB86ROeJ+p8LYeE4H97gUZIDYLU8DvndsVBKcJOTCDwe557W8Q6zr1iHLVyV4Sx9GaUmkpqjCQZoh18vG++byXeVQvorkAh03GZDfU0xMvJEQk3hVfxio6F6rG+IviwKK3dAiKkZvHdPghV+KCeCfCx4qWzSmN24Ro+m3laNwIDAQAB-----END PUBLIC KEY-----";
        //jwt令牌
        String jwtString = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiaXRjYXN0In0.FTNAfKR-Phj7z3KF-fnNd_BDhX2z2yjqBw9gvDABB65-ijM59Ut4p4ilLL8anCGHWn5-ohXCvVSVXmRbQhdtdfn03VcQQPhxGNE5Bzay3jdxTKq4PmiJ81LX_FqknacK8VfyY5RdVFgiJhOU811D6Llx26C9RmuTT59dcX2xKt7rfX-TACxFkaEnYmSa_aqPdNs96Q3PA42fmOmzxG4ML-en6zRMCyPi4zId3znj25V7T7vB7rvF7niUtmo-CQUQXqHkujWEeiKbUvsIZWUWZw53Q8n1If-UETcZmaYcYVF2MuDP4_tnCxw6C0NQxp8kv3gfZgGEecr5kiG7y_ON7w";
        //校验jwt令牌
        Jwt jwt = JwtHelper.decodeAndVerify(jwtString, new RsaVerifier(publickey));
        //拿到jwt令牌中自定义的内容
        String claims = jwt.getClaims();
        System.out.println(claims);
    }
}

package com.heima.controller.authentication;

import cn.hutool.core.map.MapUtil;
import com.google.code.kaptcha.Producer;
import com.heima.response.common.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * 验证控制
 *
 * @author cjw
 */
@RequestMapping(value = "/authentication")
@Controller
public class AuthenticationController {

    @Autowired
    private Producer producer;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 获取验证码
     *
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/getCaptcha")
    public BaseResponse getCaptcha() throws IOException {
        //生成验证码
        String key = UUID.randomUUID().toString();
        String code = producer.createText();

        //生成图片
        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        //设置编码
        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray());
        //缓存redis：随机码为key，验证码为value
        // 存储到redis中
        redisTemplate.opsForValue().set(key, code, 120);

        //设置返回值
        Map<Object, Object> build = MapUtil.builder()
                .put("userKey", key)
                .put("captcherImg", base64Img)
                .build();
        return new BaseResponse(true, 8, "操作成功", build);
    }

}

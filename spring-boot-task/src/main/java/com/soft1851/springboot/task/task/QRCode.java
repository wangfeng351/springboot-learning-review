package com.soft1851.springboot.task.task;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.*;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import com.soft1851.springboot.task.util.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.Struct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/17
 * @Version 1.0
 */
@Slf4j
@Component
public class QRCode {

    @Async
    @Scheduled(fixedRate = 2000)
    public void download() {
        String template = "D:/test/1/{}.jpg";
        String path = StrUtil.format(template, IdUtil.simpleUUID());
        String url = "http://ww1.sinaimg.cn/large/007YO3iLgy1gcvrr2bfxfj31hc0xcn2u.jpg";
        String downloadUrl = StrUtil.format(url, RandomUtil.randomInt(1, 3));
        log.info(downloadUrl);
        log.info(path);
        HttpUtil.downloadFile(downloadUrl, FileUtil.file(path));
        createQRCode(path);
    }

    @Async
    public void createQRCode(String url) {
        //设置二维码格式
        QrConfig config = new QrConfig(500, 500);
        //设置外边距
        config.setMargin(2);
        String random = IdUtil.simpleUUID();
        String path = "d:/test/1/" + random + ".jpg";
        QrCodeUtil.generate(//
                "http://27e1537o04.zicp.vip:51682/asyncTask1", //二维码内容
                config.setImg(url), //附带logo
                FileUtil.file(path)//写出到的文件
        );
        ImgUtil.scale(
                FileUtil.file(path),
                FileUtil.file("d:/test/2/" + random +  "copy.jpg"),
                0.5f//缩放比例
        );
        zipFile(path);
    }

    @Async
    public void zipFile(String path) {
        //发送请求下载压缩文件
        Console.log("下载压缩文件");
        //压缩文件
        ZipUtil.zip(path, "d:/test/1/" + IdUtil.simpleUUID() + ".zip", true);
        //下载文件
        Console.log("下载文件");
    }

    /*
     * 类型转换
     */
    @Async
    @Scheduled(fixedRate = 2000)
    public void Convert() {
        //数组类型之间的转换
        String[] a = {"1", "2", "3", "4"};
        Integer[] intArray = Convert.toIntArray(a);
        Console.log("类型转换成功: " + Arrays.toString(intArray));
        //日期对象的转化
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Convert.toDate(localDateTime);
        Console.log("日期类转换成功：" + date);
    }

    public static void main(String[] args) {
        new QRCode().download();
    }
}

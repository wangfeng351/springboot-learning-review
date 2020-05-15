package com.soft1851.springboot.task.util;

import lombok.SneakyThrows;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.filters.Caption;
import net.coobird.thumbnailator.filters.ImageFilter;
import net.coobird.thumbnailator.filters.Watermark;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.util.BufferedImages;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/15
 * @Version 1.0
 */
public class ImageUtil {

    @SneakyThrows
    public void createBirthdayCard() {
        File file = new File("D:\\爱了爱了.png");
        //转为图片
        char[] data = "hello".toCharArray();
        BufferedImage img = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        BufferedImage image = ImageIO.read(file);
        //加文字
        Graphics2D g = img.createGraphics();
        g.drawChars(data, 0, data.length, 100, 30);
        Thumbnails.of(image).size(image.getWidth(), image.getHeight())
                .watermark(Positions.TOP_CENTER, img, 1)
                .toFile(new File("d:\\1.jpg"));
    }

    public static void main(String[] args) {
        new ImageUtil().createBirthdayCard();
    }
}

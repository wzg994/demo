package com.wzg.demo.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreatFu {
    //    Image image=new BufferedImage()
    public void Fu(){
        int width = 1920;
        int height = 1080;
        String fu = "福";

        File file = new File("D:/fu.jpg");

        Font font = new Font("Serif", Font.BOLD, 72);
        //创建一个画布
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取画布的画笔
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
//    Graphics2D graphics2d = bi.createGraphics();


//    graphics2d
        //开始绘图
        g2.setBackground(Color.WHITE);
        g2.clearRect(0,0,width,height);
//        g2.setPaint(new Color(0,0,255));
//        g2.fillRect(0,0,100,10);
//        g2.setPaint(new Color(253,2,0));
//        g2.fillRect(0,10,100,10);
        g2.setPaint(Color.red);


        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(fu, context);
        System.out.println("bounds"+bounds);
        double x = (width - bounds.getWidth()) / 2;// 位置
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        //绘制字符串
        g2.drawString(fu,(int)x,(int)baseY);
        System.out.println("绘制完成 ");
        //将生成的图片保存为jpg格式的文件。ImageIO支持jpg、png、gif等格式
        try {
                ImageIO.write(bi, "jpg", file);

        } catch (IOException e) {
            System.out.println("生成图片出错........");
            e.printStackTrace();
        }

//    img=Image.new('RGB',(512,440))#创建图片
//            num=20
//    f=open('福.txt')
//# ff=open('福2.txt','w')
//    t=f.read()
//    print(len(t))
//    print(t[0])
//
//for n in range(num):
//    dise1=(random.randint(0,255),random.randint(0,255),random.randint(0,255),random.randint(0,255))
//    dise2=(random.randint(0,255),random.randint(0,255),random.randint(0,255),random.randint(0,255))
//    zise1=(random.randint(0,255),random.randint(0,255),random.randint(0,255),random.randint(0,255))
//    zise2=(random.randint(0,255),random.randint(0,255),random.randint(0,255),random.randint(0,255))
//            for i in range(440):
//            for j in range(512):
//            if t[i*440+j]!='\n':
//            if t[i*440+j]=='A':
//    s=random.randint(0,1)
//            if s==0:
//            img.putpixel((j,i),dise1)
//    elif s==1:
//            img.putpixel((j,i),dise2)
//    elif t[i*440+j]=='O':
//    s=random.randint(0,1)
//            if s==0:
//            img.putpixel((j,i),zise1)
//    elif s==1:
//            img.putpixel((j,i),zise2)
//            # ff.write(t[i*440+j])
//            # ff.write('\n')
//            img.save(str(n+1)+'.png')
    }

    public static void main(String[] args) {
        CreatFu creatFu=new CreatFu();
        creatFu.Fu();
    }

}

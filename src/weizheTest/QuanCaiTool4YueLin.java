package com.wyuxuanzhuan.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


/**
 * Created by weizhe on 2017/1/13.
 * 图片限制为130*130
 * 红色和绿色翻转那里有问题 记得检查 还有图片缩小算法还没改
 *
 */

public class QuanCaiTool4YueLin {

    private int[] r;
    private int[] g;
    private int[] b;


    private int[][] data_r;
    private int[][] data_g;
    private int[][] data_b;

    public QuanCaiTool4YueLin(Bitmap bitmap) {
        getSeperateRGB(bitmap);
    }


    private void getSeperateRGB(Bitmap bitmap) {
//        int[][] data_bin = new int[130][130];
        int[][] r = new int[130][130];
        int[][] g = new int[130][130];
        int[][] b = new int[130][130];
        for (int i=0; i<130; i++){
            for(int j=0; j<130; j++){
                r[j][130-i-1] = Color.red(bitmap.getPixel(i,j));
                g[j][130-i-1] = Color.green(bitmap.getPixel(i,j));
                b[j][130-i-1] =Color.blue(bitmap.getPixel(i,j));
            }
        }

//        for (int i=0; i<130; i++){
//            for (int j=0; j<130; j++){
//                int m;
//               m = r[i][j];
//               r[i][j] = r[i][130-j-1];
//               r[i][130-j-1] = m;
//
//                m = g[i][j];
//                g[i][j] = g[i][130-j-1];
//                g[i][130-j-1] = m;
//
//                m = b[i][j];
//                b[i][j] = b[i][130-j-1];
//                b[i][130-j-1] = m;
//            }
//        }

        System.out.println("构造方法");
        int lx = 65; //图片的中心x坐标
        int ly = 65; //图片的中心y坐标
        int radius = 64; //取模半径
        int degree = 180; //取模精度
        int led = 64; //灯珠个数
        double a;

        data_r = new int[degree][led];
        data_g = new int[degree][led];
        data_b = new int[degree][led];


        for (int m=0; m<degree; m++){
            for (int n=0; n< led; n++){
                a = ((m+1)*2*Math.PI)/180;
                data_r[m][led-n-1] = r[(int) (lx + ((radius * Math.cos(a)) / led) * (n+1))][(int) (ly + ((radius * Math.sin(a)) / led) * (n+1))];
                data_g[m][led-n-1] = g[(int) (lx + ((radius * Math.cos(a)) / led) * (n+1))][(int) (ly + ((radius * Math.sin(a)) / led) * (n+1))];
                data_b[m][led-n-1] = b[(int) (lx + ((radius * Math.cos(a)) / led) * (n+1))][(int) (ly + ((radius * Math.sin(a)) / led) * (n+1))];
//                data_r[m][led-n-1] = Color.red(bitmap.getPixel((int) (lx + ((radius * Math.cos(a)) / led) * (n+1)),(int) (ly + ((radius * Math.sin(a)) / led) * (n+1))));
//                data_g[m][led-n-1] = Color.green(bitmap.getPixel((int) (lx + ((radius * Math.cos(a)) / led) * (n+1)),(int) (ly + ((radius * Math.sin(a)) / led) * (n+1))));
//                data_b[m][led-n-1] = Color.blue(bitmap.getPixel((int) (lx + ((radius * Math.cos(a)) / led) * (n+1)),(int) (ly + ((radius * Math.sin(a)) / led) * (n+1))));

            }
        }
        for (int i=0; i<180; i++){
            for (int j=0; j<64; j++){
                System.out.print(data_b[i][j]+" ");
            }
            System.out.println();
        }

        data_r = FanZhuanRed(data_r);
        data_g = OuShuFanzhuan4Green(data_g);
    }

    public int[][] getC1ToC12(){

        int[] r_victor = new int[64];
        int[] g_victor = new int[64];
        int[] b_victor = new int[64];
        int[][] data = new int[180][192];

        for(int i=0; i<180; i++){
            for (int j=0; j<64; j++){
                r_victor[j] = data_r[i][j];
                g_victor[j] = data_g[i][j];
                b_victor[j] = data_b[i][j];
            }
            for (int j=0; j<8; j++){
                data[i][j+8*0] = b_victor[j+8*0];
                data[i][j+8*1] = r_victor[j+8*0]; //C1
                data[i][j+8*2] = g_victor[j+8*0];
                data[i][j+8*3] = r_victor[j+8*1]; //C2
                data[i][j+8*4] = b_victor[j+8*1];
                data[i][j+8*5] = g_victor[j+8*1]; //C3

                data[i][j+8*6]  = b_victor[j+8*2];
                data[i][j+8*7]  = r_victor[j+8*2]; //C4
                data[i][j+8*8]  = g_victor[j+8*2];
                data[i][j+8*9]  = r_victor[j+8*3]; //C5
                data[i][j+8*10] = b_victor[j+8*3];
                data[i][j+8*11] = g_victor[j+8*3]; //C6

                data[i][j+8*12]  = b_victor[j+8*4];
                data[i][j+8*13]  = r_victor[j+8*4]; //C7
                data[i][j+8*14]  = g_victor[j+8*4];
                data[i][j+8*15]  = r_victor[j+8*5]; //C8
                data[i][j+8*16]  = b_victor[j+8*5];
                data[i][j+8*17]  = g_victor[j+8*5]; //C9

                data[i][j+8*12]  = b_victor[j+8*4];
                data[i][j+8*13]  = r_victor[j+8*4]; //C7
                data[i][j+8*14]  = g_victor[j+8*4];
                data[i][j+8*15]  = r_victor[j+8*5]; //C8
                data[i][j+8*16]  = b_victor[j+8*5];
                data[i][j+8*17]  = g_victor[j+8*5]; //C9

                data[i][j+8*18]  = b_victor[j+8*6];
                data[i][j+8*19]  = r_victor[j+8*6]; //C10
                data[i][j+8*20]  = g_victor[j+8*6];
                data[i][j+8*21]  = r_victor[j+8*7]; //C11
                data[i][j+8*22]  = b_victor[j+8*7];
                data[i][j+8*23]  = g_victor[j+8*7]; //C12

            }
        }
        //消鬼影算法
        for (int m=0; m<180; m++){
            for (int n=0; n<192; n++){
                if (data[m][n] <= 3){
                    data[m][n] = 0;
                }
            }
        }
        System.out.println("走到这里");
//        for (int i=0; i<180; i++){
//            for (int j=0; j<192; j++){
//                System.out.print(data[i][j]);
//            }
//            System.out.println();
//        }
        return data;
    }





    //red翻转
    private int[][] FanZhuanRed(int[][] data_r){
        int m;
        for (int i=0; i<180; i++){
            for(int j=0; j<8; j++){
                for (int k=0; k<4; k++){
                    m = data_r[i][j*8+k];
                    data_r[i][j*8+k] = data_r[i][j*8+7-k];
                    data_r[i][j*8+7-k] = m;
                }
            }
        }
        return  data_r;
    }

    //green偶数翻转
    private int[][] OuShuFanzhuan4Green(int[][] data_g){
        int m;
        for (int i=0; i<180; i++){
            for(int j=0; j<8; j++){
                if (j % 2 == 1){
                    for (int k=0; k<4; k++){
                        m = data_g[i][j*8+k];
                        data_g[i][j*8+k] = data_g[i][j*8+7-k];
                        data_g[i][j*8+7-k] = m;
                    }
                }
            }
        }
        return data_g;
    }



}

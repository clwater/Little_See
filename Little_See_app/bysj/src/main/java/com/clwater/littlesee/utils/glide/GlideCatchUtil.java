package com.clwater.littlesee.utils.glide;

import android.os.Looper;

import com.bumptech.glide.Glide;
import com.clwater.littlesee.Application;
import com.clwater.littlesee.utils.glide.config.GlideCatchConfig;

import java.io.File;
import java.math.BigDecimal;

import static com.clwater.littlesee.utils.FileHelp.getFolderSize;
import static com.clwater.littlesee.utils.FileHelp.getFormatSize;

/**
 * Glide缓存工具类
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class GlideCatchUtil {
    private static GlideCatchUtil instance;

    public static GlideCatchUtil getInstance() {
        if (null == instance) {
            instance = new GlideCatchUtil();
        }
        return instance;
    }

    // 获取Glide磁盘缓存大小
    public String getCacheSize() {
        try {
            return getFormatSize(getFolderSize(new File(Application.getInstance().getCacheDir() + "/" + GlideCatchConfig.GLIDE_CARCH_DIR)));
        } catch (Exception e) {
            e.printStackTrace();
            return "获取失败";
        }
    }

    // 清除Glide磁盘缓存，自己获取缓存文件夹并删除方法
    public boolean cleanCatchDisk() {
        return deleteFolderFile(Application.getInstance().getCacheDir() + "/" + GlideCatchConfig.GLIDE_CARCH_DIR, true);
    }

    // 清除图片磁盘缓存，调用Glide自带方法
    public boolean clearCacheDiskSelf() {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(Application.getInstance()).clearDiskCache();
                    }
                }).start();
            } else {
                Glide.get(Application.getInstance()).clearDiskCache();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 清除Glide内存缓存
    public boolean clearCacheMemory() {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                Glide.get(Application.getInstance()).clearMemory();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    // 按目录删除文件夹文件方法
    private boolean deleteFolderFile(String filePath, boolean deleteThisPath) {
        try {
            File file = new File(filePath);
            if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (File file1 : files) {
                    deleteFolderFile(file1.getAbsolutePath(), true);
                }
            }
            if (deleteThisPath) {
                if (!file.isDirectory()) {
                    file.delete();
                } else {
                    if (file.listFiles().length == 0) {
                        file.delete();
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

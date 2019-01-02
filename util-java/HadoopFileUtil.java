package com.chngenesis.nebula.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

/**
 * HDFS 文件相关操作
 * @author Zhanghengrui 2018-12-27
 *
 */
public class HadoopFileUtil {

	public static void main(String[] args) {
		// System.out.println(PropertiesUtil.readProperty("config/config.properties",
		// "hadoop.server"));
		// readFileContent("abc.txt");
//		 copy("C:\\aa.txt", "abc.txt");
	
//		InputStream is = downLoadFile("abc.txt", "C:\\bb.txt");
//		byte[] b;
//		try {
//			b = new byte[is.available()];
//			is.read(b);
//			new FileOutputStream("C:\\bb.txt").write(b);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
//		try {
//			upLoadFile("aa.zip", new FileInputStream("C:\\StarTrekTimer.zip"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		deleteFile("abc.txt");
		
//		System.out.println(getFileName("aa.txwerft"));
	}
	
	/**
	 * 根据文件名产生新的文件名
	 * @param fileName 文件名
	 * @return
	 */
	public static String getFileName(String fileName) {
		return UUIDUtil.getUUID() + fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 获取上传下载文件路径
	 * @param fileName
	 * @return
	 */
	public static String getFileUploadUri(String fileName) {
		return PropertiesUtil.readProperty("config/config.properties", "hadoop.upload") + fileName;
	}

	/**
	 * 读取文件内容
	 * @param fileName 文件名
	 */
	public static void readFileContent(String fileName) {
		FileSystem fs = getFileSystem();
		InputStream in = null;
		try {
			in = fs.open(new Path(getFileUploadUri(fileName)));
			IOUtils.copyBytes(in, System.out, 4096, false);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeStream(in);
		}
	}

	/**
	 * 复制本地文件
	 * @param fileUrl 本地文件地址如 C://aa.txt
	 * @param fileName 存入文件名
	 */
	public static void copy(String fileUrl, String fileName) {
		String dstFile = PropertiesUtil.readProperty("config/config.properties", "hadoop.upload");
		existDir(dstFile, true);
		dstFile += fileName;
		FileSystem fs = getFileSystem();
		try {
			Path srcPath = new Path(fileUrl);
			Path dstPath = new Path(dstFile);
			fs.copyFromLocalFile(srcPath, dstPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 判断目录是否存在
	 * @param filePath 目录
	 * @param create 不存在是否创建
	 * @return
	 */
	public static boolean existDir(String filePath, boolean create) {
		boolean flag = false;
		if (StringUtils.isEmpty(filePath)) {
			return flag;
		}
		try {
			Path path = new Path(filePath);
			// FileSystem对象
			FileSystem fs = getFileSystem();
			if (create) {
				if (!fs.exists(path)) {
					fs.mkdirs(path);
				}
			}

			if (fs.isDirectory(path)) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 获取文件系统
	 * @return
	 */
	public static FileSystem getFileSystem() {
		// 读取配置文件
		Configuration conf = new Configuration();
		// 文件系统
		FileSystem fs = null;
		String hdfsUri = PropertiesUtil.readProperty("config/config.properties", "hadoop.server");
		if (StringUtils.isBlank(hdfsUri)) {
			// 返回默认文件系统 如果在 Hadoop集群下运行，使用此种方法可直接获取默认文件系统
			try {
				fs = FileSystem.get(conf);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 返回指定的文件系统,如果在本地测试，需要使用此种方法获取文件系统
			try {
				URI uri = new URI(hdfsUri.trim());
				fs = FileSystem.get(uri, conf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fs;
	}

	/**
	 * 下载文件
	 * @param fileName 文件名
	 * @param downUrl 下载地址
	 * @return
	 */
	public static InputStream downLoadFile(String fileName, String downUrl) {
		// 构建FileSystem
		FileSystem fs = null;
		// 读取文件
		InputStream is = null;
		try {
			fs = getFileSystem();
			is = fs.open(new Path(getFileUploadUri(fileName)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(is != null) {
					is.close();
				}
				if(fs != null) {
					fs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return is;
	}

	/**
	 * 上传文件
	 * @param fileName 文件名
	 * @param fileInputStream 文件流
	 */
	public static void upLoadFile(String fileName, InputStream inputStream) {			
		// 文件输入流
		InputStream in = null;
		// 连接文件系统
		FileSystem fs = null;
		// 文件输出流，指向文件系统
		OutputStream out = null;
		try {
			in = new BufferedInputStream(inputStream);
			fs = getFileSystem();
			out = fs.create(new Path(getFileUploadUri(fileName)), new Progressable() {
				@Override
				// 每上传64KB,在控制台输出“＊”
				public void progress() {
					System.out.print("*");
				}
			});
			// 向文件系统写入文件
			IOUtils.copyBytes(in, out, 4096, true);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
				if(fs != null) {
					fs.close();
				}
				if(out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 删除文件
	 * @param fileName 文件名
	 */
	public static void deleteFile(String fileName) {
		try {
			 getFileSystem().delete(new Path(getFileUploadUri(fileName)), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

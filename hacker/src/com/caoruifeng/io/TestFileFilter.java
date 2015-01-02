package com.caoruifeng.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class TestFileFilter {

	
	public static void main(String[] args) {
		File file=new File("/Users/caoruifeng/Downloads/show_files");
		File[] files=file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println("筛选前：" + files[i].getName());
		}
		fileFilter(file);  
        filenameFilter(file);
	}

	private static void filenameFilter(File file) {
		// TODO Auto-generated method stub
		File[] files=file.listFiles( new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				if (pathname.getName().toLowerCase().endsWith(".css")) {  
                    return true;  
                } else {  
                    return false;  
                }
			}
		});
		 for (int i = 0; i < files.length; i++) {  
	            System.out.println("fileFilter：" + files[i].getName());  
	        }
	}

	private static void fileFilter(File file) {
		// TODO Auto-generated method stub
		File[] files=file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.toLowerCase().endsWith(".png")){
					return false;
				}else{
					return true;
				}
			}
		});
		for (int i = 0; i < files.length; i++) {
			 System.out.println("filenameFilter：" + files[i].getName());
		}
	}
}

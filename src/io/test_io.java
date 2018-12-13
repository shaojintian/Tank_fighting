package io;

import java.io.*;
public class test_io {
	
	 String input_source ="./src/io/input.txt";
	 String output_source="./src/io/output.txt";
	//因为eclipse的源文件路径src和编译路径bin不是同一个,
	//如果在eclipse写这句,它会在项目路径也就是src的上一级目录找这个文件,会出现找不到的异常。
	public  void io() throws IOException {
		//input stream
		InputStream in =new FileInputStream(this.input_source);
		byte[] bytes =new byte[100];
		in.read(bytes);
		in.close();
		String str=new String(bytes);
		System.out.println(str);
		//outstream,追加方式
		OutputStream out=new FileOutputStream(this.output_source);
		byte[] out_bytes=str.getBytes("UTF-8");
		out.write(out_bytes);
		out.close();
		
		
		
		
		
		
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		test_io IO =new test_io();
		IO.io();
		
	}

}

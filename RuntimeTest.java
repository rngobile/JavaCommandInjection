import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.File;
import java.io.*;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.lang.ProcessBuilder;

import java.util.Arrays;

public class RuntimeTest{
	public static void main(String[] args) throws Exception{
		Runtime runtime = null;
		Process process = null;

		runtime = Runtime.getRuntime();

		String destPath = args[0];
		String fileName = args[1];
		String sourcePath = args[2];

		String cmd = "/usr/bin/gs -dBATCH -dNOPAUSE -sDEVICE=jpeg -r100 -sOutputFile="+ destPath+fileName + "_P%d.jpg -f " + sourcePath+fileName + ".pdf";

		System.out.println(cmd);
		String line = "";

		process = runtime.exec(cmd);
		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while (( line = input.readLine()) != null ){
			System.out.println(line);
		}
	}
}

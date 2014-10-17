package simpleTests;

import java.io.File;
import java.net.URL;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TestTesseract {
	public static void main(String[] args) {
		URL resource = TestTesseract.class.getClassLoader()//
//				.getResource("images.jpg");
				.getResource("PoorLight&blurness.jpg");
//				.getResource("Test5.png");

		File f = new File(resource.getFile());

		try {
			Tesseract instance = Tesseract.getInstance();
//			Tesseract1 instance = new Tesseract1();
			String doOCR = instance.doOCR(f);
			System.out.println(doOCR);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
	}
}
